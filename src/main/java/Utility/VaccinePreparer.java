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
public class VaccinePreparer extends AuxiliaryWorker{
    
    private VaccinationRoom vaccinationRoom;
    private RestRoom rRoom;
    private Thread me=Thread.currentThread();
    private int remainingToRest;
    
    public VaccinePreparer(int wID, VaccinationRoom v, RestRoom r){
        super(wID);
        vaccinationRoom=v;
        rRoom=r;
        remainingToRest=20;
    }
    
    @Override
    public void run(){
        while (!me.isInterrupted()){ //If it recieves an interrupt, finish (only interrupt from main class is possible)
            if (remainingToRest==0){
                goRest(1000,4000); //Sleep for 3 to 5 secs 
            }
            vaccinationRoom.produceVaccine();
            waitVaccineIsReady(500,1000);
            remainingToRest--;
            
        }
        
    }
    
    private void waitVaccineIsReady(int minTime, int maxTime){
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
        remainingToRest=20; //Restore the numPatients to attend before next rest
    }
    
}
