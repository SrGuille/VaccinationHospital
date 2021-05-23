package Utility;

import Log.WriteToLog;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObservationRoom {

    private Desk[] desks = new Desk[20];
    private AtomicInteger numPatients;
    private VaccinationRoom vRoom;
    public Semaphore mutex;

    public ObservationRoom(WriteToLog log) {
        numPatients = new AtomicInteger(0);
        mutex = new Semaphore(1);
        for (int i = 0; i < 20; i++) {
            desks[i] = new Desk(i + 1, false, log);
        }

    }

    public int numPatients() {
        return numPatients.get(); //Returns how many places are available checking semaphore
    }

    public void setVaccinationRoom(VaccinationRoom v) {
        vRoom = v;
    }

    /**
     * Healthcare worker goes into the requested patient desk, not necessary
     * mutual exclusion, as only one is called
     *
     * @param h
     * @param desk
     */
    public void goInside(HealthcareWorker h, Desk desk) {
        try {
            desk.goInside(h);
        } catch (InterruptedException ex) {
            Logger.getLogger(ObservationRoom.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void goInside(Patient p) {
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(ObservationRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 20; i++) {
            if (desks[i].isAvailableForPatient()) {
                try {
                    desks[i].goInside(p);
                    p.setCurrentDesk(desks[i]);
                    numPatients.getAndIncrement();
                    break;
                } catch (InterruptedException ex) {
                    Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        mutex.release();
    }

    public void goOut(HealthcareWorker h) {
        Desk workersCurrentDesk = h.getCurrentDesk();
        workersCurrentDesk.goOut(h); //Go out from observation room
        vRoom.goInside(h); //Go to vaccination room

    }

    /**
     * Go out form the room
     *
     * @param p
     */
    public void goOut(Patient p) {
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(ObservationRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        Desk patientCurrentDesk = p.getCurrentDesk();
        patientCurrentDesk.goOut(p); //Go out from observation room
        numPatients.getAndDecrement();
        mutex.release();
    }

}
