package Utility;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Patient extends Thread{
    
    private final String patientID;
    private Desk currentDesk;
    private boolean hasAnAppointment=true;
    private Reception reception;
    private ObservationRoom oRoom;
    private RestRoom rRoom;
    
    public Patient(int pID, Object[] hospitalRooms){
        patientID=assignID(pID);
        this.reception=(Reception)hospitalRooms[0];
        this.oRoom=(ObservationRoom)hospitalRooms[2];
        this.rRoom=(RestRoom)hospitalRooms[3];
        start();
    }
    
    public void run(){
        reception.arriveToHospital(this);
        if (hasAnAppointment){ 
            currentDesk.waitForBeingVaccinated();
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
        if (r.nextInt(100)<30){ //5% chance of having symptoms
            System.out.println("My desk: "+currentDesk.getID());
            rRoom.callForHelp(currentDesk);
            currentDesk.waitForBeenHealed(); //Wait for help
        }
        else{
            oRoom.goOut(this);
        }
    }
    
}

