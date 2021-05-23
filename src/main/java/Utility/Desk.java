package Utility;

import Log.WriteToLog;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Desk {

    private final String deskID;
    private HealthcareWorker healthcareWorker;
    private Patient patient;
    private String type;
    private Lock lock = new ReentrantLock();
    private Condition waitForPatient = lock.newCondition();
    private Condition waitForBeingVaccinated = lock.newCondition();
    private WriteToLog log;

    public Desk(int dID, boolean vaccination, WriteToLog log) {
        healthcareWorker = null;
        patient = null;
        if (vaccination == true) {
            type = "VD";

        } else {
            type = "OD";
        }
        deskID = assignID(dID, type);
        this.log = log;
    }

    private String assignID(int wID, String type) {

        StringBuilder stringBuilder = new StringBuilder(type);

        if (wID < 10) {
            stringBuilder.append("0");
        }

        stringBuilder.append(wID);

        return stringBuilder.toString();
    }

    public String getID() {
        return deskID;
    }

    public Patient getPatient() {

        return patient;
    }

    /*
    * It must be impossible for 2 workers to try to go into the same desk
     */
    public void goInside(HealthcareWorker h) throws InterruptedException {
        lock.lock();
        String message = " Healthcare Worker " + h.getID() + " entered " + deskID;
        log.write(message);
        try {
            h.setCurrentDesk(this); //Set the worker desk to this one
            healthcareWorker = h;
            waitForPatient.await(); //We wait for patient
        } finally {
            lock.unlock();
        }
    }

    /*
    * Only 1 worker can execute this at the same time, as only 1 can be in
     */
    public void goOut(HealthcareWorker h) throws InterruptedException {
        healthcareWorker = null;
        h.setCurrentDesk(null); //We free also the worker's desk
    }

    /*
    * It must be impossible for 2 workers to try to go into the same desk
     */
    public void goInside(Patient p) throws InterruptedException {
        waitForPatient.signal();//We notify to the doctor
        p.setCurrentDesk(this); //Set the patient's desk to this one
        patient = p;
        String message = " Healthcare Worker " + p.getID() + " entered " + deskID;
        log.write(message);
        waitForBeingVaccinated.await();
    }

    public synchronized void goOut(Patient p) throws InterruptedException {
        patient = null;
        p.setCurrentDesk(null); //We free also the patient's desk
    }

    public boolean isAvailableForWorker() {
        boolean isAvailable = false;
        if (healthcareWorker == null) {
            isAvailable = true;
        }
        return isAvailable;
    }

    public boolean isAvailableForPatient() {
        boolean isAvailable = false;
        if (patient == null && healthcareWorker != null) { //Only can go in if it has no patient and it has a doctor
            isAvailable = true;
        }
        return isAvailable;
    }

}
