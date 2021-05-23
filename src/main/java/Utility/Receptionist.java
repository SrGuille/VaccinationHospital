package Utility;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Receptionist extends AuxiliaryWorker {

    private Reception reception;
    private RestRoom rRoom;
    private int remainingToRest;
    private Thread me = Thread.currentThread();
    private int status; //State=0 normal working, state=1 resting, state=2 waiting for available desk at vaccination room

    public Receptionist(int wID, Reception recep, RestRoom r) {
        super(wID);
        reception = recep;
        rRoom = r;
        remainingToRest = 10;
        status = 0;
        start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (me.isInterrupted() == false && (status == 0) || status == 1) { //If no one interrupts us, we keep working
            if (remainingToRest == 0) {
                goRest(3000, 5000); //Sleep for 3 to 5 secs

            }
            reception.callFirstInQueue();

            checkIfListed(500, 1000); //Sleep for 0,5 to 1 sec

            reception.forwardPatient(this);

            remainingToRest--; //One less to rest

        }

    }

    /**
     *
     * It only interrupts it if the status is the one that the calling thread is
     * interested in
     *
     * @param desiredStatus is the status that must be found to interrupt him
     *
     */
    public synchronized void conditionalInterrupt(int desiredStatus) {
        if (status == desiredStatus) {
            me.interrupt();
            setStatus(0); //working status
        }
    }

    public void setStatus(int newValue) {
        status = newValue;
    }

    private void checkIfListed(int minTime, int maxTime) {
        try {
            Thread.sleep(minTime + (int) (Math.random() * (maxTime - minTime)));
        } catch (InterruptedException ex) {
            Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void goRest(int minTime, int maxTime) {
        setStatus(1); //Rest status
        rRoom.goIn(this);

        try {
            Thread.sleep(minTime + (int) (Math.random() * (maxTime - minTime)));
        } catch (InterruptedException ex) {
            Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
        }

        rRoom.goOut(this);
        setStatus(0); //working status
        remainingToRest = 10; //Restore the numPatients to attend before next rest
    }

}
