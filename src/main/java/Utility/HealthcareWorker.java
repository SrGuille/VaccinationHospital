/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author guial
 */
public class HealthcareWorker extends Thread{
    private final String hcWorkerID;
    private CountDownLatch allPatientsAttended;
    private String currentDesk;
    
    public HealthcareWorker(int wID, CountDownLatch allPatientsAttended){
        hcWorkerID=assignID(wID);
        this.allPatientsAttended= allPatientsAttended;
    }
    
    private String assignID(int wID){
        
        StringBuilder stringBuilder = new StringBuilder("H");
        
        if (wID<10){
            stringBuilder.append("0");
        }
        
        stringBuilder.append(wID);
        
        return stringBuilder.toString();
    }
    
    public String getID(){
        return hcWorkerID;
    }
    
    public String getCurrentDesk(){
        return currentDesk;
    }
    
    public void setCurrentDesk(String desk){
        currentDesk=desk;
    }
}
