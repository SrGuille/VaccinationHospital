package DistributedSystem;

import Interface.Hospital;
import Utility.*;
import com.google.gson.Gson;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author guial
 */
public class RemoteMethods extends UnicastRemoteObject implements RemoteMethodsInterface {

    private String oRoom;
    private String rRoom;
    private String vRoom;
    private String reception;
    private String aux1;
    private String aux2;
    Gson gson = new Gson();

    public RemoteMethods() throws RemoteException {

    }

    /* public RemoteMethods(Object[] hospitalRooms, Receptionist aux1, VaccinePreparer aux2) throws RemoteException {
        this.reception = (Reception) hospitalRooms[0];
        this.vRoom = (VaccinationRoom) hospitalRooms[1];
        this.oRoom = (ObservationRoom) hospitalRooms[2];
        this.rRoom = (RestRoom) hospitalRooms[3];

        this.aux1 = aux1;
        this.aux2 = aux2;
    }*/
    @Override
    public String getoRoom() {

        return oRoom;
    }

    @Override
    public String getrRoom() {
        return rRoom;
    }

    @Override
    public String getvRoom() {
        return vRoom;
    }

    @Override
    public String getReception() {
        return reception;
    }

    @Override
    public String getAux1() {
        return aux1;
    }

    @Override
    public String getAux2() {
        return aux2;
    }

    public void setAux1(String aux1) {
        this.aux1 = aux1;
    }

    public void setAux2(String aux2) {
        this.aux2 = aux2;
    }

    public void setoRoom(String oRoom) {
        this.oRoom = oRoom;
    }

    public void setrRoom(String rRoom) {
        this.rRoom = rRoom;
    }

    public void setvRoom(String vRoom) {
        this.vRoom = vRoom;
    }

    public void setReception(String reception) {
        this.reception = reception;
    }
    

    @Override
    public void cleanVaccinationDesk(String deskString) throws RemoteException {
        Desk desk = gson.fromJson(deskString, Desk.class);
        VaccinationRoom vRoomClass = gson.fromJson(vRoom, VaccinationRoom.class);
        vRoomClass.closeToClean(desk);
    }

}
