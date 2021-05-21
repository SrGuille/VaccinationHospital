/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.concurrent.CountDownLatch;
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
    
    
    public Receptionist(int wID, CountDownLatch allPatientsAttended, Reception recep, RestRoom r){
        super(wID, allPatientsAttended);
        reception=recep;
        rRoom=r;
        remainingToRest=10;
    }
    
    @Override
    public void run(){
        while (me.isInterrupted()==false){ //If no one interrupts us, we keep working
            if (remainingToRest==0){
                goRest(3000,5000); //Sleep for 3 to 5 secs
                
            }
            reception.callFirstInQueue();
            
            checkIfListed(500,1000); //Sleep for 0,5 to 1 sec
            
            reception.forwardPatient();
            
            remainingToRest--; //One less to rest
            
        }
        
    }
    
    private void checkIfListed(int minTime, int maxTime){
        try {
                Thread.sleep(minTime+(int)(Math.random()*(maxTime-minTime)));
            } catch (InterruptedException ex) {
                Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void goRest(int minTime, int maxTime){
        
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
