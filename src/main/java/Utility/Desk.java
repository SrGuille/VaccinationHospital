package Utility;

import Log.WriteToLog;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Desk {

    private final String deskID;
    private HealthcareWorker healthcareWorker;
    private Patient patient;
    private String type;
    private Lock lock = new ReentrantLock();
    private Condition waitForPatient = lock.newCondition();
    private Condition waitForBeingVaccinated = lock.newCondition();
    private Condition waitForBeingHealed = lock.newCondition();
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
        String message;
        if (type.equals("VD")) {
            message = " Healthcare Worker " + h.getID() + " entered " + deskID + " and is waiting to vaccinate a patient";
        } else {
            message = " Healthcare Worker " + h.getID() + " entered " + deskID + " to heal to patient " + patient.getID();
        }
        log.write(message);

        try {
            h.setCurrentDesk(this); //Set the worker desk to this one
            healthcareWorker = h;
        } finally {
            lock.unlock();
        }
    }

    /*
    * Only 1 worker can execute this at the same time, as only 1 can be in
     */
    public void goOut(HealthcareWorker h) {
        healthcareWorker = null;
        h.setCurrentDesk(null); //We free also the worker's desk
    }

    /*
    * It must be impossible for 2 patients to try to go into the same desk
     */
    public void goInside(Patient p) throws InterruptedException {
        lock.lock();
        try {
            if (type.equals("VD")) { //If it is a vaccination desk, then
                waitForPatient.signal();//We notify to the doctor to vaccinate to the patient
            }
            System.out.println(this.deskID);
            p.setCurrentDesk(this); //Set the patient's desk to this one
            patient = p;
            String message = " Patient " + p.getID() + " entered " + deskID;
            log.write(message);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Patient who calls this wait to be vaccinated
     */
    public void waitForBeingVaccinated() {
        lock.lock();
        try {
            waitForBeingVaccinated.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Desk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Healthcare worker who calls awakes to the vaccinated patient
     */
    private void awakeVaccinatedPatient() {
        lock.lock();
        try {
            waitForBeingVaccinated.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Healthcare worker who calls it waits for a patient to come to the room
     */
    public void waitForPatient() {
        lock.lock();
        try {
            waitForPatient.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Desk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Patient who calls it has symptoms and waits to be healed
     */
    public void waitForBeenHealed() {
        lock.lock();
        try {
            waitForBeingHealed.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Desk.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Healthcare worker who calls it tells to his patient that his symptoms
     * have stopped and it can leave the hospital
     */
    public void tellPatientToGoHome() {
        lock.lock();
        try {
            waitForBeingHealed.signal();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void goOut(Patient p) {
        patient = null;
        p.setCurrentDesk(null); //We free also the patient's desk
        awakeVaccinatedPatient();
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
        if (type.equals("VD") && patient == null && healthcareWorker != null) { // In case of vaccination desk only can go in if it has no patient and it has a doctor
            isAvailable = true;
        } else if (type.equals("OD") && patient == null) { //In case of observation desk, then the only contition is that there must be no patient inside
            isAvailable = true;
        }
        return isAvailable;
    }

}
