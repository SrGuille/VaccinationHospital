package Utility;

import Log.WriteToLog;
import Interface.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Test {

    private static JFrame goBack;
    private static Hospital hospital;

    public Test(JFrame v) throws InterruptedException {
        goBack = v;
        //Create interface
        hospital = new Hospital(goBack);
        WriteToLog log = new WriteToLog("evolutionHospital.txt");
        log.write(" Main: Hospital opened");

        //Create rooms
        ObservationRoom oRoom = new ObservationRoom(log, hospital);
        RestRoom rRoom = new RestRoom(oRoom, log, hospital);
        VaccinationRoom vRoom = new VaccinationRoom(oRoom, log, hospital);
        oRoom.setVaccinationRoom(vRoom);
        Reception reception = new Reception(vRoom, log, hospital);

        Object[] hospitalRooms = {reception, vRoom, oRoom, rRoom};

        //Create workers
        Receptionist aux1 = new Receptionist(1, reception, rRoom, hospital);
        VaccinePreparer aux2 = new VaccinePreparer(2, vRoom, rRoom, hospital);

        reception.setReceptionist(aux1);
        vRoom.setReceptionist(aux1);

        HealthcareWorker[] workers = new HealthcareWorker[10];
        for (int i = 0; i < 10; i++) {
            workers[i] = new HealthcareWorker(i + 1, hospitalRooms, log);

        }

        //Create patients
        Patient patients[] = new Patient[50];

        for (int j = 0; j < 50; j++) {
            try {
                Thread.sleep(1000 + (int) (Math.random()) * 2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
            }
            patients[j] = new Patient(j + 1, hospitalRooms);
        }

        //Wait for all to finish
        for (int k = 0; k < 50; k++) {
            patients[k].join();
        }

        //Close hospital (join finished)
        for (int i = 0; i < 10; i++) {
            workers[i].interrupt();
        }
        aux1.interrupt();
        aux2.interrupt();
    }
}
