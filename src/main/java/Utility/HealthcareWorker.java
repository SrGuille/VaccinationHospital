package Utility;

import Log.WriteToLog;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HealthcareWorker extends Thread {

    private final String hcWorkerID;
    private Desk currentDesk;
    private Desk emergencyDesk;
    private Thread me;
    private RestRoom rRoom;
    private VaccinationRoom vRoom;
    private ObservationRoom oRoom;
    private int remainingToRest = 3;
    private int status; //Status=0 resting or working (available for helping at observation), status=1 vaccinating
    private WriteToLog log;

    public HealthcareWorker(int wID, Object[] hospitalRooms, WriteToLog log) {
        
        hcWorkerID = assignID(wID);
        vRoom = (VaccinationRoom) hospitalRooms[1];
        oRoom = (ObservationRoom) hospitalRooms[2];
        rRoom = (RestRoom) hospitalRooms[3];
        status = 0;
        this.log = log;
        start();
    }

    private String assignID(int wID) {

        StringBuilder stringBuilder = new StringBuilder("H");

        if (wID < 10) {
            stringBuilder.append("0");
        }

        stringBuilder.append(wID);

        return stringBuilder.toString();
    }

    public void run() {
        me = Thread.currentThread();
        arriveHospital();
        while (!me.isInterrupted()) {
            if (remainingToRest <= 0 && currentDesk.getPatient() == null) {
                //In an extreme case it could happen that a patient has come in after the last vaccination, in that case we vaccine him
                goRest(5000, 8000);
            }
            
            goInAndWait();
            
            if (emergencyDesk==null){//If it there hasn't been any emergency then vaccinate to patient that signalled 
                vaccinate(3000, 5000);
                remainingToRest--;
            }
            else{//In case of emergency, then heal patient that has called us
                healPatient(2000,5000,false); //The false stands for that the call is not perform while resting
            }
            
            
        }
    }

    public synchronized void goInAndWait(){
        vRoom.goInside(this);
            
        currentDesk.waitForPatient();
        
    }
    public String getID() {
        return hcWorkerID;
    }

    public Desk getCurrentDesk() {
        return currentDesk;
    }

    public void setCurrentDesk(Desk desk) {
        currentDesk = desk;
    }

    public void setEmergencyDesk(Desk desk) {
        emergencyDesk = desk;
    }

    public void arriveHospital() {
        rRoom.goIn(this);
        prepareForWork(1000, 3000);
        rRoom.goOut(this);

    }
    
    public synchronized void conditionalInterrupt(int desiredStatus) {
        if (status == desiredStatus) {
            setStatus(0); //ready to help status
            me.interrupt();
           
        }
    }

    public synchronized int getStatus(){
        return status;
    }
    
    public synchronized void setStatus(int newValue) {
        status = newValue;
    }

    private void prepareForWork(int minTime, int maxTime) {
        try {
            Thread.sleep(minTime + (int) (Math.random() * (maxTime - minTime)));
        } catch (InterruptedException ex) {
            Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goRest(int minTime, int maxTime) {

        vRoom.goOut(this);

        rRoom.goIn(this);

        try {
            Thread.sleep(minTime + (int) (Math.random() * (maxTime - minTime)));
            rRoom.goOut(this);

        } catch (InterruptedException ex) { //If there is an emergency, go to attend it
            healPatient(2000, 5000, true);

        }
        remainingToRest = 3;
    }

    private void vaccinate(int minTime, int maxTime) {
        boolean vaccinated = false;
        while (!vaccinated) {

            if (vRoom.getVaccine()) {
                vaccinated = true;
                try {
                    Thread.sleep(minTime + (int) (Math.random() * (maxTime - minTime)));

                } catch (InterruptedException ex) {
                    Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    Patient vaccinatedPatient = currentDesk.getPatient();
                    
                    String message = " Healthcare Worker " + getID() + " vaccinated to patient " + vaccinatedPatient.getID() + " at " + currentDesk.getID();
                    log.write(message);

                    vRoom.goToObservation(vaccinatedPatient); //Take out to patient and also move him to observation room

                } catch (InterruptedException ex) {
                    Logger.getLogger(HealthcareWorker.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                vRoom.waitForVaccineIsReady(this);
            }

        }

    }

    /**
     * Attend patient who needs help at observation room
     * @param minTime
     * @param maxTime
     * @param fromRestRoom indicates the source of the worker, that can be either the rest room or the vaccination room.
     * 
     */
    private void healPatient(int minTime, int maxTime, boolean fromRestRoom) {
        if (fromRestRoom){
            rRoom.goOut(this);
        }
        else{
            vRoom.goOut(this); //Take the worker out of vax room
        }
            oRoom.goInside(this,emergencyDesk); //move to the desk of the patient
            
        
            try {
                Thread.sleep(minTime + (int) (Math.random() * (maxTime - minTime)));

            } catch (InterruptedException ex) {
                Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
            }

            emergencyDesk.tellPatientToGoHome(currentDesk.getPatient());
            emergencyDesk=null;
            oRoom.goOut(this);
            
           if (fromRestRoom){ //Return to rest room
               goRest(2500, 4000); //Go rest the half of the time
           }
           
           else{//In case of been called in the middle of the work, then return to the spot
               vRoom.goInside(this);
           }
            
        
        
        

    }

}
