/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guial
 */
public class Receptionist extends AuxiliaryWorker{
    
    private Reception reception;
    private RestRoom rRoom;
    private int remainingToRest;
    private Thread me=Thread.currentThread();
    private int status; //State=0 normal working, state=1 resting, state=2 waiting for available desk at vaccination room
    
    public Receptionist(int wID, Reception recep, RestRoom r){
        super(wID);
        reception=recep;
        rRoom=r;
        remainingToRest=10;
        status=0; 
    }
    
    @Override
    public void run(){
        while (me.isInterrupted()==false && (status==0) || status==1){ //If no one interrupts us, we keep working
            if (remainingToRest==0){
                goRest(3000,5000); //Sleep for 3 to 5 secs
                
            }
            reception.callFirstInQueue();
            
            checkIfListed(500,1000); //Sleep for 0,5 to 1 sec
            
            reception.forwardPatient();
            
            remainingToRest--; //One less to rest
            
        }
        
    }
    /*
    *It only interrupts it if the status is the one that the calling thread is interested in
    */
    public synchronized void conditionalInterrupt(int desiredStatus){
        if (status==desiredStatus){
            me.interrupt();
            setStatus(0); //working status
        }
    }
    
    private void setStatus(int newValue){
        status=0;
    }
    
    private void checkIfListed(int minTime, int maxTime){
        try {
                Thread.sleep(minTime+(int)(Math.random()*(maxTime-minTime)));
            } catch (InterruptedException ex) {
                Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void goRest(int minTime, int maxTime){
        setStatus(1); //Rest status
        rRoom.goIn(this);
        
        try {
                Thread.sleep(minTime+(int)(Math.random()*(maxTime-minTime)));
            } catch (InterruptedException ex) {
                Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        rRoom.goOut(this);
        remainingToRest=10; //Restore the numPatients to attend before next rest
    }
    

   
    
}
