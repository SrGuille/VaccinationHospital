package Utility;

import Log.WriteToLog;
import Interface.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Test {

    private Hospital hospital;
    private WriteToLog log;
    private ObservationRoom oRoom;
    private RestRoom rRoom;
    private VaccinationRoom vRoom;
    private Reception reception;
    private Object[] hospitalRooms = new Object[4];
    private Patient patients[];
    private Receptionist aux1;
    private VaccinePreparer aux2;
    private HealthcareWorker[] workers;

    public Test(JFrame v) throws InterruptedException {

        //Create interface
        this.hospital = new Hospital(v);
        log = new WriteToLog("evolutionHospital.txt");
        log.write(" Main: Hospital opened");

        createRooms();
        createPatients();
        createWorkers();

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

    public void createPatients() {
        patients = new Patient[50];

        for (int j = 0; j < 50; j++) {
            try {
                Thread.sleep(1000 + (int) (Math.random()) * 2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
            }
            patients[j] = new Patient(j + 1, hospitalRooms);
        }
    }

    public void createWorkers() {
        aux1 = new Receptionist(1, reception, rRoom, hospital);
        aux2 = new VaccinePreparer(2, vRoom, rRoom, hospital);

        reception.setReceptionist(aux1);
        vRoom.setReceptionist(aux1);

        workers = new HealthcareWorker[10];
        for (int i = 0; i < 10; i++) {
            workers[i] = new HealthcareWorker(i + 1, hospitalRooms, log);

        }
    }

    public void createRooms() {
        oRoom = new ObservationRoom(log, hospital);
        rRoom = new RestRoom(oRoom, log, hospital);
        vRoom = new VaccinationRoom(oRoom, log, hospital);
        oRoom.setVaccinationRoom(vRoom);
        reception = new Reception(vRoom, log, hospital);
        hospitalRooms[0] = reception;
        hospitalRooms[1] = vRoom;
        hospitalRooms[2] = oRoom;
        hospitalRooms[3] = rRoom;
    }
}
