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
public class Receptionist extends AuxiliaryWorker{
    
    private Reception reception;
    private int remainingToRest;
    Thread t=Thread.currentThread();
    
    public Receptionist(int wID, CountDownLatch allPatientsAttended, Reception room){
        super(wID, allPatientsAttended);
        reception=room;
        remainingToRest=10;
    }
    
    @Override
    public void run(){
        while (t.isInterrupted()==false){ //If no one interrupts us, we keep working
            reception.callFirstInQueue();
            
        }
        //Patient patient = reception.attend();
        //patient.validate();
        
        
    }
}
