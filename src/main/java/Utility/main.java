package Utility;

import Log.WriteToLog;

import java.time.LocalDateTime;


/**
 *
 * @author guial
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        WriteToLog log = new WriteToLog("evolutionHospital.txt");
        log.write(" Main: Hospital opened");
        
        
        //Create rooms
        ObservationRoom oRoom = new ObservationRoom(log);
        RestRoom rRoom = new RestRoom(oRoom, log);
        VaccinationRoom vRoom = new VaccinationRoom(oRoom, log);
        oRoom.setVaccinationRoom(vRoom);
        Reception reception = new Reception(vRoom, log);

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
        Patient patients[]= new Patient[50];
        
        for (int j=0;j<50;j++){
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