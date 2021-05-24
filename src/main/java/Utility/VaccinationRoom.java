package Utility;

import Interface.*;
import Log.WriteToLog;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ArrayUtils;

public class VaccinationRoom {

    private Desk[] desks = new Desk[10];
    public Semaphore mutex;
    private int numWorkers;
    private int numPatients;
    private final ObservationRoom oRoom;
    private AtomicInteger numVaccines;
    private Receptionist receptionist;
    private WriteToLog log;
    private Hospital hospital;

    public VaccinationRoom(ObservationRoom o, WriteToLog log, Hospital hospital) {
        mutex = new Semaphore(1);
        oRoom = o;
        this.log = log;
        numVaccines = new AtomicInteger(0);
        numWorkers = 0;
        numPatients = 0;
        for (int i = 0; i < 10; i++) {
            desks[i] = new Desk(i + 1, true, log);
        }
        this.hospital = hospital;
    }

    public void setReceptionist(Receptionist r) {
        receptionist = r;
    }

    /**
     * Healthcare worker goes in, in mutual exclusion, to be sure that more than
     * 1 tries to go to the same desk
     *
     * @param h Healthcare worker
     */
    public void goInside(HealthcareWorker h) {
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 10; i++) {
            if (desks[i].isAvailableForWorker()) {
                try {
                    numWorkers++;
                    desks[i].goInside(h);
                    //hospital.displayHealthcareWorkerVaccination(h, i);
                    break;
                } catch (InterruptedException ex) {
                    Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            receptionist.conditionalInterrupt(2); //We tell the receptionist that now there is a spot in the room, as a worker has come
        }
        mutex.release();

    }
    /**
     * Finds an available worker in the room to go help at the observation room
     * @param emergencyDesk
     * @return if there was someone
     */
    public boolean findWorkerForEmergency(Desk emergencyDesk){
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean anyWorkerFound=false;
        for (int i = 0; i < 10; i++) {           
            if (desks[i].isAvailableForEmergency()) {
                anyWorkerFound=true;
                desks[i].getWorker().setEmergencyDesk(emergencyDesk);
                desks[i].attendEmergency();//resume execution
                break;
            }
        }
        mutex.release();
        return anyWorkerFound;
    }

    /**
     * You can only go on in the case where there is an available doctor alone
     * in his desk and if the number of patients in vaccination room added to
     * number of patients in observation room is lower or equal than 20. This
     * second condition is mandatory because we need to be sure that the patient
     * will be able to go to an observation room just after recieving the
     * vaccine.
     */
    private boolean patientCanGoIn() {

        boolean isAuthorised = false;

        int numPatientsAtORoom = oRoom.numPatients();

        if (numWorkers > numPatients && (numPatients + numPatientsAtORoom) <= 20) {
            isAuthorised = true;
        }

        return isAuthorised;
    }

    /**
     * Finds the correct desk and goes in
     *
     * @param Patient to move in
     */
    private void findDesk(Patient p) {

        for (int i = 0; i < 10; i++) {

            if (desks[i].isAvailableForPatient()) {
                try {
                    p.setCurrentDesk(desks[i]);
                    desks[i].goInside(p);
                    //hospital.displayPatientVaccination(p, i);
                    break;
                } catch (InterruptedException ex) {
                    Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Tries to introduce to patient to the room
     *
     * @param p Patient to go in
     * @return if it managed to go in
     */
    public boolean tryGoInside(Patient p) {

        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean success = false;

        if (patientCanGoIn()) {

            success = true;

            findDesk(p); //Go in
            numPatients++;
        }
        mutex.release();
        return success;
    }

    /**
     * Healthcare worker goes out, necessary mutual exclusion as a worker can't
     * abandon the room if a patient is trying to go in
     *
     * @param h HealthcareWorker
     * 
     */
    public void goOut(HealthcareWorker h) {
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        Desk workerCurrentDesk = h.getCurrentDesk();
        workerCurrentDesk.goOut(h);
        //hospital.displayHealthcareWorkerVaccination(null, (ArrayUtils.indexOf(desks, workerCurrentDesk)));
        numWorkers--;
        mutex.release();

    }

    /**
     * Patient goes out, necessary mutual exclusion as a patient can't abandon
     * the room if another patient is trying to go in
     *
     * @param p patient to move
     * @throws InterruptedException
     */
    public void goToObservation(Patient p) throws InterruptedException {
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        Desk patientCurrentDesk = p.getCurrentDesk();

        patientCurrentDesk.goOut(p); //Go out from vaccination room
        //hospital.displayPatientVaccination(null, (ArrayUtils.indexOf(desks, patientCurrentDesk)));
        numPatients--;
        oRoom.goInside(p); //Go into observation room

        receptionist.conditionalInterrupt(2); //We tell the receptionist that now there is a spot in the room, as a patient has left
        mutex.release();
    }

    public synchronized void produceVaccine() {
        int vaccinesReady = numVaccines.incrementAndGet();
        //hospital.displayVaccinesAvailable(vaccinesReady);
        String message = " Vaccine produced, there are " + vaccinesReady + " ready";
        log.write(message);
        notify(); //Notify to a worker that was waiting for vaccine

    }

    public synchronized boolean getVaccine() {
        boolean vaccineFound = true;

        if (numVaccines.get() == 0) {
            vaccineFound = false;
        } else {
            numVaccines.decrementAndGet();
            //hospital.displayVaccinesAvailable(numVaccines.get());
        }
        return vaccineFound;
    }

    public synchronized void waitForVaccineIsReady(HealthcareWorker h) {
        try {
            wait(); //Wait in case it is necessary because of lack of vaccines
        } catch (InterruptedException ex) {
            Logger.getLogger(Desk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
