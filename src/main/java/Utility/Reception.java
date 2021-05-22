/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guial
 */
public class Reception {
    
    private Lock entranceLock;
    private Condition queue;
    private Condition stopService;
    private Patient patientAtFrontDesk;
    private LinkedList patients = new LinkedList();
    private VaccinationRoom vRoom;
    
    public Reception(VaccinationRoom v){
        entranceLock=new ReentrantLock();
        queue=entranceLock.newCondition();
        stopService=entranceLock.newCondition(); 
        vRoom=v;
    }
   
    
    /*
    *   Calling this, a patient waits in the queue.
    */
    public void arriveToHospital(Patient p){
        entranceLock.lock();
        try{
            queue.await(); //Patient execution waiting at the queue
            patients.offer(p); //Patient information stored to later display
            
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
             
        } finally {
            entranceLock.unlock();
        }
    }

    /*
    *   Calling this will get the first patient in the queue to be able to go on with his execution.
    */
    public void forwardPatient(){
        
        Random random = new Random();  
        
        if (random.nextInt(100)==0){ //Give a 1% chance of not listed
            patientAtFrontDesk.notAppointment(); //Makes it to leave the hospital
            queue.signal();
        }
        
        else if (vRoom.tryGoInside(patientAtFrontDesk)){ //If it has managed to go in, let it go
            queue.signal(); //signal first patient thread
        }   
        
        else{ //No possibility of forwarding to the patient, stop service until interrupted
            try {
                stopService.await();
            } catch (InterruptedException spotRelased) { //When interrupted, there is a place in the room (a patient has left or a doctor has come)
                vRoom.tryGoInside(patientAtFrontDesk);
            }
        }
       
    }
    
    
   
}

