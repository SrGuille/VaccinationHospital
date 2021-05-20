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
public class VaccinePreparer extends AuxiliaryWorker{
    
    private VaccinationRoom vaccinationRoom;
    
    public VaccinePreparer(int wID, CountDownLatch allPatientsAttended, VaccinationRoom room){
        super(wID, allPatientsAttended);
        vaccinationRoom=room;
    }
    
    @Override
    public void run(){
        
    }
}
