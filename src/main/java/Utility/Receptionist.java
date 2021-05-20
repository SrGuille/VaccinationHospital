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
    
    public Receptionist(int wID, CountDownLatch allPatientsAttended, Reception room){
        super(wID, allPatientsAttended);
        reception=room;
    }
    
    @Override
    public void run(){
       /* while (allPatientsAttended.getCount()>0){
            
        }
        Patient patient = reception.attend();
        patient.validate();
        
        */
    }
}
