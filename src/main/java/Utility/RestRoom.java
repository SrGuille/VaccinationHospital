package Utility;

import Log.WriteToLog;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestRoom {

    private Semaphore mutex = new Semaphore(1);

    private Queue workers = new LinkedList();
    private Receptionist receptionist;
    private VaccinePreparer vaccinePreparer;
    private Queue emergencyDesks = new LinkedList();
    private ObservationRoom oRoom;
    private WriteToLog log;

    public RestRoom(ObservationRoom o, WriteToLog log) {
        oRoom = o;
        this.log = log;
    }

    public void goIn(HealthcareWorker h) {
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(RestRoom.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!emergencyDesks.isEmpty()) { //If there is an emergency and the rest room was empty the worker directly goes to help
            
            Desk emergencyDesk=(Desk) emergencyDesks.poll();//Get first desk where there is an emergency
            h.setEmergencyDesk(emergencyDesk); //In this way it will know the desk he has to go to
            h.interrupt();
            
        } else {
            workers.offer(h);
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
        try {
            mutex.acquire();
            workers.remove(h);
        } catch (InterruptedException ex) {
            Logger.getLogger(RestRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        mutex.release();
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

    /**
     * The first healthcare worker in the queue will go to help the patient. 
     * If there were no workers resting, then the emergency is noted in the list of emergencies 
     * and it will be attended by the first worker to come to rest
     * @param desk is the desk of the patient that needs help
     */
    public void callForHelp(Desk desk) {
        try {
            mutex.acquire();
            if (!workers.isEmpty()) { //If there is someone, send him to help
                HealthcareWorker calledWorker = (HealthcareWorker) workers.poll();
                calledWorker.setEmergencyDesk(desk); //In this way it will know the desk he has to go to
                calledWorker.interrupt();
            } else {//Else, note the emergency
                emergencyDesks.add(desk);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(RestRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        mutex.release();
    }
}
