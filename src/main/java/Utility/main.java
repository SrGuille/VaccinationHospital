/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author guial
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        CountDownLatch allPatientsAttended = new CountDownLatch(2000);
        HealthcareWorker[] workers = new HealthcareWorker[10];
        for (int i=0;i<10;i++){
            workers[i]=new HealthcareWorker(i+1, allPatientsAttended);

        }
        
       
        ObservationRoom oRoom = new ObservationRoom();
        VaccinationRoom vRoom = new VaccinationRoom(oRoom);
        Reception reception = new Reception(vRoom);
        
        
        Object[] hospitalRooms ={reception, vRoom, oRoom};
       
        
        AuxiliaryWorker aux1 = new Receptionist(1, allPatientsAttended, reception);
        AuxiliaryWorker aux2 = new VaccinePreparer(2, allPatientsAttended, vRoom);
        
        Patient patients[]= new Patient[2000];
        
        for (int j=0;j<2000;j++){
            patients[j] = new Patient(j+1, allPatientsAttended, hospitalRooms);
        }
        for (int k=0;k<2000;k++){
            patients[k].join();
        }
    }
    
    
    
}
