/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author guial
 */
public abstract class AuxiliaryWorker implements Runnable{
    private final String auxWorkerID;
    private CountDownLatch allPatientsAttended;
    
    public AuxiliaryWorker(int wID, CountDownLatch allPatientsAttended){
        auxWorkerID=assignID(wID);
        this.allPatientsAttended=allPatientsAttended;
    }
    
    private String assignID(int wID){
        return "A"+wID;
    }
    
    public String getID(){
        return auxWorkerID;
    }
    

    @Override
    public abstract void run();
            
    }

