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
        HealthcareWorker[] workers = null;
        for (int i=0;i<10;i++){
            workers[i]=new HealthcareWorker(i+1, allPatientsAttended);

        }
        
       
        BlockingQueue queue = new LinkedBlockingQueue();
        Reception reception = new Reception(queue);
        VaccinationRoom vRoom = new VaccinationRoom(workers);
        ObservationRoom oRoom = new ObservationRoom();
        AuxiliaryWorker aux1 = new Receptionist(1, allPatientsAttended, reception);
        AuxiliaryWorker aux2 = new VaccinePreparer(2, allPatientsAttended, vRoom);
        
        for (int j=0;j<2000;j++){
            Patient patient = new Patient(j+1, allPatientsAttended);
            Thread.sleep(1000 + (int)(Math.random()*2000));
            queue.put(patient);
        }
    }
    
    
    
}
