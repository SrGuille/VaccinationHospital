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

    public RemoteMethods(String oRoom,
            String rRoom,
            String vRoom,
            String reception,
            String aux1,
            String aux2) throws RemoteException {

        this.reception = reception;
        this.vRoom = vRoom;
        this.oRoom = oRoom;
        this.rRoom = rRoom;

        this.aux1 = aux1;
        this.aux2 = aux2;
    }

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

    @Override
    public void cleanVaccinationDesk(String deskString) throws RemoteException {
        Desk desk = gson.fromJson(deskString, Desk.class);
        VaccinationRoom vRoomClass = gson.fromJson(vRoom, VaccinationRoom.class);
        vRoomClass.closeToClean(desk);
    }

}
