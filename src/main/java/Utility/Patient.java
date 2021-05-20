package Utility;

import java.util.concurrent.CountDownLatch;

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
    private CountDownLatch allPatientsAttended;
    private String currentDesk;
    private boolean isValidated=false;
    
    public Patient(int pID, CountDownLatch allPatientsAttended){
        patientID=assignID(pID);
        this.allPatientsAttended=allPatientsAttended;
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
    
    public String getCurrentDesk(){
        return currentDesk;
    }
    
    public void setCurrentDesk(String desk){
        currentDesk=desk;
    }
    
    public void validate(){
        isValidated=true;
    }
}
