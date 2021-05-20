/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

/**
 *
 * @author guial
 */
public class Desk {
    private final String deskID;
    private HealthcareWorker healthcareWorker;
    private Patient patient;
    private String type;
    
    public Desk(int dID, HealthcareWorker h){ //Constructor for vaccination room desk, by default with a healthcare worker
        type="VD";
        deskID=assignID(dID, type);
        healthcareWorker=h;
        patient=null;
    }
    
    public Desk(int dID){ //Constructor for observation room desk, by default empty
        type="OD";
        deskID=assignID(dID, type);
        healthcareWorker=null;
        patient=null;
    }

    
    private String assignID(int wID, String type){
        
        StringBuilder stringBuilder = new StringBuilder(type);
        
        if (wID<10){
            stringBuilder.append("0");
        }
        
        stringBuilder.append(wID);
        
        return stringBuilder.toString();
    }
    
    public String getID(){
        return deskID;
    }
    
    public synchronized void goInside(HealthcareWorker h) throws InterruptedException{
        
        while (healthcareWorker!=null){
            wait();
        }
        h.setCurrentDesk(deskID); //Set the worker desk to this one
        healthcareWorker=h;
    }
    
    public synchronized void goOut(HealthcareWorker h) throws InterruptedException{
        healthcareWorker=null;
        h.setCurrentDesk(""); //We free also the worker's desk
        notifyAll();
    }
    
    public synchronized void goInside(Patient p) throws InterruptedException{
        while (patient!=null){
            wait();
        }
        p.setCurrentDesk(deskID); //Set the patient's desk to this one
        patient=p;
    }
    
    public synchronized void goOut(Patient p) throws InterruptedException{
        patient=null;
        p.setCurrentDesk(""); //We free also the patient's desk
        notifyAll();
    }
    
     public synchronized boolean isAvailableForWorker(){
        boolean isAvailable=false;
        if (healthcareWorker==null){
           isAvailable=true;
        }
        return isAvailable;
    }
     
    public synchronized boolean isAvailableForPatient(){
        boolean isAvailable=false;
        if (patient==null){
           isAvailable=true;
        }
        return isAvailable;
    }


}
