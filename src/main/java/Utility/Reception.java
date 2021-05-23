package Utility;

import Log.WriteToLog;
import java.util.LinkedList;
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
    private Patient patientAtFrontDesk;
    private LinkedList patients = new LinkedList();
    private VaccinationRoom vRoom;
    private WriteToLog log;
    
    public Reception(VaccinationRoom v, WriteToLog log){
        entranceLock=new ReentrantLock(true);
        queue=entranceLock.newCondition();
        stopService=entranceLock.newCondition(); 
        vRoom=v;
        this.log=log;
    }
   
    
    /*
    *   Calling this, a patient waits in the queue.
    */
    public void arriveToHospital(Patient p){
        entranceLock.lock();
        
        String message = " Patient "+ p.getID()+" arrived at the hospital";
        log.write(message);
        
        try{
            
            patients.offer(p); //Patient information stored to later display
            queue.await(); //Patient execution waiting at the queue
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            entranceLock.unlock();
        }
    }
    
    /*
    *   Calling this, a receptionist signals to the first in the queue.
    */
    public void callFirstInQueue(){
        entranceLock.lock();
        try {
            patientAtFrontDesk=(Patient)patients.poll(); //Patient information stored to later display
            
            String message = " Patient "+ patientAtFrontDesk.getID()+" is at front desk";
            log.write(message);
             
        } finally {
            entranceLock.unlock();
        }
    }

    /*
    *   Calling this will get the first patient in the queue to be able to go on with his execution.
    */
    public void forwardPatient(){
        System.out.println("forward");
        Random random = new Random();  
        
        if (random.nextInt(100)==0){ //Give a 1% chance of not listed
            patientAtFrontDesk.notAppointment(); //Makes it to leave the hospital
            queue.signal();
            String message = " Patient "+ patientAtFrontDesk.getID()+" doesn't have an an appointment, he is leaving the hospital";
            log.write(message);
        }
        
        else if (vRoom.tryGoInside(patientAtFrontDesk)){ //If it has managed to go in, let it go
            queue.signal(); //signal first patient thread
            patientAtFrontDesk=(Patient)patients.poll(); //Patient information stored to later display
        }   
        
        else{ //No possibility of forwarding to the patient, stop service until interrupted
            entranceLock.lock();
            try {
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

