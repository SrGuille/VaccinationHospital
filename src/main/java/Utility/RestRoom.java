package Utility;

import Interface.*;
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
    private VaccinationRoom vRoom;
    private WriteToLog log;
    private Hospital hospital;

    public RestRoom(VaccinationRoom v, ObservationRoom o, WriteToLog log, Hospital hospital) {
        vRoom = v;
        oRoom = o;
        this.log = log;
        this.hospital = hospital;
    }

    public Queue getWorkers() {
        return workers;
    }

    public void goIn(HealthcareWorker h) {
        
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(RestRoom.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!emergencyDesks.isEmpty()) { //If there is an emergency and the rest room was empty the worker directly goes to help
            System.out.println("A");
            Desk emergencyDesk = (Desk) emergencyDesks.poll();//Get first desk where there is an emergency
            h.setEmergencyDesk(emergencyDesk); //In this way it will know the desk he has to go to
            h.interrupt();

        } else {
            workers.offer(h);
            hospital.displayHealthcareWorkersRest(workers);

            String message = " Healthcare worker " + h.getID() + " is resting";
            log.write(message);
        }
        mutex.release();
    }

    public void goIn(Receptionist r) {
        receptionist = r;
        hospital.displayReceptionistRest(receptionist);
        String message = " Receptionist " + r.getID() + " is resting";
        log.write(message);
    }

    public void goIn(VaccinePreparer vp) {
        vaccinePreparer = vp;
        hospital.displayVaccinePreparerRest(vaccinePreparer);
        String message = " Vaccine Preparer " + vp.getID() + " is resting";
        log.write(message);
    }

    public void goOut(HealthcareWorker h) {
        try {
            mutex.acquire();
            workers.remove(h);
            hospital.displayHealthcareWorkersRest(workers);
        } catch (InterruptedException ex) {
            Logger.getLogger(RestRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        mutex.release();
    }

    public void goOut(Receptionist r) {
        receptionist = null;
        hospital.displayReceptionistRest(receptionist);
        String message = " Receptionist " + r.getID() + " has returned to his spot";
        log.write(message);
    }

    public void goOut(VaccinePreparer vp) {
        vaccinePreparer = null;
        hospital.displayVaccinePreparerRest(vaccinePreparer);
        String message = " Vaccine Preparer " + vp.getID() + " has returned to his spot";
        log.write(message);
    }

    /**
     * 1)The first healthcare worker in the queue will go to help the patient. 
     * 2)If there were no workers resting, a worker from vaccination room will be called
     * 3)If there is anyone available, then the emergency is noted in the list of
     * emergencies and it will be attended by the first worker to come to rest
     *
     * @param desk is the desk of the patient that needs help
     */
    public void callForHelp(Desk desk) {
        try {
            mutex.acquire();
            if (!workers.isEmpty()) { //If there is someone, send him to help
                HealthcareWorker calledWorker = (HealthcareWorker) workers.poll();
                hospital.displayHealthcareWorkersRest(workers);
                calledWorker.setEmergencyDesk(desk); //In this way it will know the desk he has to go to
                calledWorker.interrupt();
            } else {
                //if(!vRoom.findWorkerForEmergency(desk)){ //Call a worker to go help. If it was impossible, then note the emergency for when a future hcworker comes
                    emergencyDesks.add(desk);
                //}
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(RestRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        mutex.release();
    }
}
