package Utility;

import Log.WriteToLog;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestRoom {

    private Semaphore mutex = new Semaphore(1);

    private List workers = Collections.synchronizedList(new ArrayList());
    private Receptionist receptionist;
    private VaccinePreparer vaccinePreparer;
    private List emergencyDesks = Collections.synchronizedList(new ArrayList());
    private ObservationRoom oRoom;
    private WriteToLog log;

    public RestRoom(ObservationRoom o, WriteToLog log) {
        oRoom = o;
        this.log=log;
    }

    public void goIn(HealthcareWorker h) {
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(RestRoom.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!emergencyDesks.isEmpty()) { //If there is an emergency and the rest room was empty the worker directly goes to help
            oRoom.goInside(h, (Desk) emergencyDesks.get(0));
            h.interrupt();
            emergencyDesks.remove(0);
        } else {
            workers.add(h);
            String message = " Healthcare worker " + h.getID() + " is resting";
            log.write(message);
        }
        mutex.release();
    }

    public void goIn(Receptionist r) {
        receptionist = r;
        String message = " Receptionist " + r.getID() + " is resting";
        log.write(message);
    }

    public void goIn(VaccinePreparer vp) {
        vaccinePreparer = vp;
        String message = " Vaccine Preparer " + vp.getID() + " is resting";
        log.write(message);
    }

    public void goOut(HealthcareWorker h) {
        workers.remove(h);
        String message = " Healthcare worker " + h.getID() + " has returned to his spot";
        log.write(message);
    }

    public void goOut(Receptionist r) {
        receptionist = null;
        String message = " Receptionist " + r.getID() + " has returned to his spot";
        log.write(message);
    }

    public void goOut(VaccinePreparer vp) {
        vaccinePreparer = null;
        String message = " Vaccine Preparer " + vp.getID() + " has returned to his spot";
        log.write(message);
    }

    public void callForHelp(Desk desk) {
        if (!workers.isEmpty()) { //If there is someone, send him to help
            HealthcareWorker calledWorker = (HealthcareWorker) workers.remove(0);
            calledWorker.interrupt();
        } else {//Else, note the emergency
            emergencyDesks.add(desk);
        }
    }
}
