package Utility;

import Log.WriteToLog;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Reception {
    
    private Lock entranceLock;
    private Condition queue;
    private Condition stopService;
    private Patient patientAtFrontDesk=null;
    private Queue patients = new LinkedList();
    private VaccinationRoom vRoom;
    private WriteToLog log;
    private Receptionist receptionist;
    
    public Reception(VaccinationRoom v, WriteToLog log){
        entranceLock=new ReentrantLock(true);
        queue=entranceLock.newCondition();
        stopService=entranceLock.newCondition(); 
        vRoom=v;
        this.log=log;
        
    }
   
    public void setReceptionist(Receptionist r){
        receptionist=r;
    }
    
   
    /**
     * Calling this, a patient waits in the queue.
     * @param p patient, to store it and stop it
     */
    public void arriveToHospital(Patient p){
        entranceLock.lock();
        
        String message = " Patient "+ p.getID()+" arrived at the hospital";
        log.write(message);
        
        try{
            
            patients.offer(p); //Patient information stored to later display
            if (receptionist!=null){ //If the receptionist hasn't left and it is waiting for patients to arrive
                receptionist.conditionalInterrupt(3);
            }
            queue.await(); //Patient execution waiting at the queue
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            entranceLock.unlock();
        }
    }
    
    /**
     * Calling this, a receptionist moves the first in the queue to the front desk. If no patients, we wait until one arrives.
     */
    public void callFirstInQueue(){
        entranceLock.lock();
        boolean isAttended=false;
        while(!isAttended){

            try {
                patientAtFrontDesk=(Patient)patients.poll(); //Patient information stored to later display
                if (patientAtFrontDesk==null){
                    try {
                        receptionist.setStatus(3); //Status of waiting for patients to arrive
                        stopService.await();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    isAttended=true;
                    String message = " Patient "+ patientAtFrontDesk.getID()+" is at front desk";
                    log.write(message);
                }

        } finally {
            entranceLock.unlock();
        }
            }
    }

    /*
    *   Calling this will get the first patient in the queue to be able to go on with his execution.
    */
    public void forwardPatient(Receptionist r){
        Random random = new Random();  
        
        if (random.nextInt(100)==0){ //Give a 1% chance of not listed
            patientAtFrontDesk.notAppointment(); //Makes it to leave the hospital
            entranceLock.lock();
            try {
                queue.signal(); //signal first patient thread 
            } finally {
                entranceLock.unlock();
            }
            String message = " Patient "+ patientAtFrontDesk.getID()+" doesn't have an an appointment, he is leaving the hospital";
            log.write(message);
        }
        
        else if (vRoom.tryGoInside(patientAtFrontDesk)){ //If it has managed to go in, let it go
            entranceLock.lock();
            try {
                patientAtFrontDesk=null;
                queue.signal(); //signal first patient thread 
            } finally {
                entranceLock.unlock();
            }
        }   
        
        else{ //No possibility of forwarding to the patient, stop service until interrupted
            entranceLock.lock();
            try {
                System.out.println("STOP");
                r.setStatus(2); //Waiting for free desk status
                stopService.await();
            } catch (InterruptedException spotRelased) { //When interrupted, there is a place in the room (a patient has left or a doctor has come)
                vRoom.tryGoInside(patientAtFrontDesk);
            }
            finally{
                entranceLock.unlock();
            }
        }
       
    }
    
    
   
}

