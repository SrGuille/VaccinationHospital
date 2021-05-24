package DistributedSystem;

import Interface.Hospital;
import Utility.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMethodsInterface extends Remote {

    void setHospital(Hospital hospital);

    public ObservationRoom getoRoom();

    public RestRoom getrRoom();

    public VaccinationRoom getvRoom();

    public Reception getReception();

    public Receptionist getAux1();

    public VaccinePreparer getAux2();

    void cleanVaccinationDesk(Desk desk) throws RemoteException;
}
