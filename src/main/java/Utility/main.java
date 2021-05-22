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
        
        //Create rooms
        ObservationRoom oRoom = new ObservationRoom();
        RestRoom rRoom = new RestRoom(oRoom);
        VaccinationRoom vRoom = new VaccinationRoom(oRoom);
        oRoom.setVaccinationRoom(vRoom);
        Reception reception = new Reception(vRoom);

        Object[] hospitalRooms ={reception, vRoom, oRoom, rRoom};
       
        //Create workers
        Receptionist aux1 = new Receptionist(1, reception, rRoom);
        VaccinePreparer aux2 = new VaccinePreparer(2, vRoom, rRoom);
        
        vRoom.setReceptionist(aux1);
        
        HealthcareWorker[] workers = new HealthcareWorker[10];
        for (int i=0;i<10;i++){
            workers[i]=new HealthcareWorker(i+1, hospitalRooms);

        }
        
        //Create patients
        Patient patients[]= new Patient[2000];
        
        for (int j=0;j<2000;j++){
            patients[j] = new Patient(j+1, hospitalRooms);
        }
        
        //Wait for all to finish
        for (int k=0;k<2000;k++){
            patients[k].join();
        }
        
        //Close hospital (join finished)
        for (int i=0;i<10;i++){
            workers[i].interrupt();
        }
        aux1.interrupt();
        aux2.interrupt();
    }
    
    
    
}