package Utility;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guial
 */
public class Patient extends Thread{
    
    private final String patientID;
    private Desk currentDesk;
    private boolean hasAnAppointment=true;
    private Reception reception;
    private VaccinationRoom vRoom;
    private ObservationRoom oRoom;
    private RestRoom rRoom;
    
    public Patient(int pID, Object[] hospitalRooms){
        patientID=assignID(pID);
        this.reception=(Reception)hospitalRooms[0];
        this.vRoom=(VaccinationRoom)hospitalRooms[1];
        this.oRoom=(ObservationRoom)hospitalRooms[2];
        this.rRoom=(RestRoom)hospitalRooms[3];
        start();
    }
    
    public void run(){
        reception.arriveToHospital(this);
        if (hasAnAppointment){ //Everything happens automatically as the patient is always controlled by the workers, he is only in charge of checking if it has symptoms
            waitForSymptoms(10000);
        }
    }
    
    private String assignID(int pID){
        
        StringBuilder stringBuilder = new StringBuilder("P");
        
        if (pID<10){
            stringBuilder.append("0");
        }
        
        if (pID<100){
            stringBuilder.append("0");
        }
        
        if (pID<1000){
            stringBuilder.append("0");
        }
        
        stringBuilder.append(pID);
        
        return stringBuilder.toString();
    }
    
    public String getID(){
        return patientID;
    }
    
    public Desk getCurrentDesk(){
        return currentDesk;
    }
    
    public void setCurrentDesk(Desk desk){
        currentDesk=desk;
    }
    
    public void notAppointment(){
        hasAnAppointment=false;
    }
    
    private void waitForSymptoms(int time){
         try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        Random r = new Random();
        if (r.nextInt(100)<5){ //5% chance of having symptoms
            rRoom.callForHelp(currentDesk);
        }  
    }
    
}

