package DistributedSystem;

import Interface.*;
import Utility.Desk;
import Utility.ObservationRoom;
import Utility.Patient;
import Utility.Reception;
import Utility.Receptionist;
import Utility.RestRoom;
import Utility.VaccinationRoom;
import Utility.VaccinePreparer;
import com.google.gson.Gson;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread {

    private HospitalClient hospital;
    private RemoteMethodsInterface rmi;
    private Thread me;
    public Boolean[] buttonDesks = new Boolean[10];
    private ObservationRoom oRoom;
    private RestRoom rRoom;
    private VaccinationRoom vRoom;
    private Reception reception;
    private Receptionist aux1;
    private VaccinePreparer aux2;
    Gson gson = new Gson();

    public Client(HospitalClient hospital) {
        this.hospital = hospital;
        rmiSetup();
        start();
    }

    @Override
    public void run() {
        me = Thread.currentThread();
        while (true) {
            try {
                rmiUpdate();
                Thread.sleep(1000);
            } catch (RemoteException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {

            }
        }
    }

    public void rmiSetup() {
        try {

            rmi = (RemoteMethodsInterface) Naming.lookup("//localhost/Prime");//Locate object 

        } catch (IOException | NotBoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void rmiUpdate() throws RemoteException {

        aux1 = gson.fromJson(rmi.getAux1(), Receptionist.class);
        aux2 = gson.fromJson(rmi.getAux2(), VaccinePreparer.class);
        reception = gson.fromJson(rmi.getReception(), Reception.class);
        vRoom = gson.fromJson(rmi.getvRoom(), VaccinationRoom.class);
        oRoom = gson.fromJson(rmi.getoRoom(), ObservationRoom.class);
        rRoom = gson.fromJson(rmi.getrRoom(), RestRoom.class);
        display();

    }

    public void display() {
        Queue patientsWaiting = reception.getPatients();
        Patient patientAtFrontDesk = reception.getPatientAtFrontDesk();
        int receptionistStatus = aux1.getStatus();
        Desk[] desksVaccination = vRoom.getDesks();
        int vaccinePreparerStatus = aux2.getStatus();
        AtomicInteger numVaccines = vRoom.getNumVaccines();
        Desk[] desksObservation = oRoom.getDesks();
        Queue healthcareWorkers = rRoom.getWorkers();
        /* hospital.displayUpdate(patientsWaiting, patientAtFrontDesk,
                receptionistStatus, desksVaccination, vaccinePreparerStatus,
                numVaccines, desksObservation, healthcareWorkers,
                aux1, aux2);*/
        System.out.println(receptionistStatus);
    }

    public void closeDesk(int desk) {
        Desk[] desks = vRoom.getDesks();
        try {
            rmi.cleanVaccinationDesk(new Gson().toJson(desks[desk]));
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
