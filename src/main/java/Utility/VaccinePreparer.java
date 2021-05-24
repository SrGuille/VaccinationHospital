package Utility;

import Interface.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VaccinePreparer extends AuxiliaryWorker {

    private VaccinationRoom vaccinationRoom;
    private RestRoom rRoom;
    private int remainingToRest;
    private int totalVaccinesPrepared;
    private int status; //Status=0 WORKING and Status=1 RESTING
    private Hospital hospital;

    public VaccinePreparer(int wID, VaccinationRoom v, RestRoom r, Hospital hospital) {
        super(wID);
        vaccinationRoom = v;
        rRoom = r;
        remainingToRest = 20;
        totalVaccinesPrepared = 0;
        status = 0;
        this.hospital = hospital;
        start();
    }

    @Override
    public void run() {
        while (totalVaccinesPrepared<50) { //It can end after preparing all the vaccines
            if (remainingToRest == 0) {
                goRest(1000, 4000); //Sleep for 3 to 5 secs 
            }
            waitVaccineIsReady(500, 1000);
            vaccinationRoom.produceVaccine();
            remainingToRest--;
            totalVaccinesPrepared++;

        }

    }

    public int getStatus(){
        return status;
    }
    
    private void waitVaccineIsReady(int minTime, int maxTime) {
        try {
            Thread.sleep(minTime + (int) (Math.random() * (maxTime - minTime)));
        } catch (InterruptedException ex) {
            Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void goRest(int minTime, int maxTime) {
        
        status=1;
        hospital.displayVaccinePreparerBooth(status);
        rRoom.goIn(this);

        try {
            Thread.sleep(minTime + (int) (Math.random() * (maxTime - minTime)));
        } catch (InterruptedException ex) {
            Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
        }

        rRoom.goOut(this);
        status=0;
        hospital.displayVaccinePreparerBooth(status);
        remainingToRest = 20; //Restore the numPatients to attend before next rest
    }

}
