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
public class HealthcareWorker extends Thread{
    private final String hcWorkerID;
    private Desk currentDesk;
    private Desk emergencyDesk;
    private Thread me=Thread.currentThread();
    private RestRoom rRoom;
    private VaccinationRoom vRoom;
    private ObservationRoom oRoom;
    private int remainingToRest=15;
    private int status; //status=0 working, status=1 resting, status=2 vaccinating
    
    public HealthcareWorker(int wID, Object[] hospitalRooms){
        hcWorkerID=assignID(wID);
        vRoom=(VaccinationRoom)hospitalRooms[1];
        oRoom=(ObservationRoom)hospitalRooms[2];
        rRoom=(RestRoom)hospitalRooms[3];
        status=0;
    }
  
    private String assignID(int wID){
        
        StringBuilder stringBuilder = new StringBuilder("H");
        
        if (wID<10){
            stringBuilder.append("0");
        }
        
        stringBuilder.append(wID);
        
        return stringBuilder.toString();
    }
    
    public void run(){
        arriveHospital();
        while(!me.isInterrupted()){
            if (remainingToRest==0){
                
                goRest(5000,8000);
            }
            vRoom.goInside(this);
            vaccinate(3000,5000); 
            remainingToRest--;
        }
    }
    public String getID(){
        return hcWorkerID;
    }
    
    public Desk getCurrentDesk(){
        return currentDesk;
    }
    
    public void setCurrentDesk(Desk desk){
        currentDesk=desk;
    }
    
    public void setEmergencyDesk(Desk desk){
        emergencyDesk=desk;
    }
    
    public void arriveHospital(){
        rRoom.goIn(this);
        prepareForWork(1000,3000);
        rRoom.goIn(this);
        
    }
    
    private void prepareForWork(int minTime, int maxTime){
        try {
                Thread.sleep(minTime+(int)(Math.random()*(maxTime-minTime)));
            } catch (InterruptedException ex) {
                Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void goRest(int minTime, int maxTime){
        
        try {
            vRoom.goOut(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(HealthcareWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        rRoom.goIn(this);
        
        try {
                Thread.sleep(minTime+(int)(Math.random()*(maxTime-minTime)));
                rRoom.goOut(this);
                
            } catch (InterruptedException ex) { //If there is an emergency, go to attend it
                rRoom.goOut(this);
                oRoom.goInside(this, emergencyDesk);

            } 
   
    }
    
    private void vaccinate(int minTime, int maxTime) {
        boolean vaccinated=false;
        while(!vaccinated){ 
            
            if (vRoom.getVaccine()){
                vaccinated=true;
                try {
                    Thread.sleep(minTime+(int)(Math.random()*(maxTime-minTime)));
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    Patient vaccinatedPatient = currentDesk.getPatient();
                    currentDesk.goOut(vaccinatedPatient); //Take out to patient
                    oRoom.goInside(vaccinatedPatient); //Move him to observation room
                } catch (InterruptedException ex) {
                    Logger.getLogger(HealthcareWorker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else{
                  vRoom.waitForVaccineIsReady(this);
            }
       
        }
    
    }
    
 
        
    
}
