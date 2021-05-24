package DistributedSystem;

import Interface.Hospital;
import Utility.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author guial
 */
public class RemoteMethods extends UnicastRemoteObject implements RemoteMethodsInterface {

    private ObservationRoom oRoom;
    private RestRoom rRoom;
    private VaccinationRoom vRoom;
    private Reception reception;
    private Receptionist aux1;
    private VaccinePreparer aux2;

    public RemoteMethods() throws RemoteException {
      /*  this.reception = (Reception) hospitalRooms[0];
        this.vRoom = (VaccinationRoom) hospitalRooms[1];
        this.oRoom = (ObservationRoom) hospitalRooms[2];
        this.rRoom = (RestRoom) hospitalRooms[3];

        this.aux1 = aux1;
        this.aux2 = aux2;*/
    }

    @Override
    public ObservationRoom getoRoom() {
        return oRoom;
    }

    @Override
    public RestRoom getrRoom() {
        return rRoom;
    }

    @Override
    public VaccinationRoom getvRoom() {
        return vRoom;
    }

    @Override
    public Reception getReception() {
        return reception;
    }

    @Override
    public Receptionist getAux1() {
        int receptionistStatus = aux1.getStatus();
        System.out.println(receptionistStatus);
        return aux1;
    }

    @Override
    public VaccinePreparer getAux2() {
        return aux2;
    }

    @Override
    public void cleanVaccinationDesk(Desk desk) throws RemoteException {
        vRoom.closeToClean(desk);
    }

    @Override
    public void setHospital(Hospital hospital) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
