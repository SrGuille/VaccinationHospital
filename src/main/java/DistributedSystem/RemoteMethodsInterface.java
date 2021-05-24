package DistributedSystem;

import Interface.Hospital;
import Utility.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMethodsInterface extends Remote {

    public String getoRoom() throws RemoteException;

    public String getrRoom() throws RemoteException;

    public String getvRoom() throws RemoteException;

    public String getReception() throws RemoteException;

    public String getAux1() throws RemoteException;

    public String getAux2() throws RemoteException;

    public void setAux1(String aux1) throws RemoteException;

    public void setAux2(String aux2) throws RemoteException;

    public void setoRoom(String oRoom) throws RemoteException;

    public void setrRoom(String rRoom) throws RemoteException;

    public void setvRoom(String vRoom) throws RemoteException;

    public void setReception(String reception) throws RemoteException;

    void cleanVaccinationDesk(String desk) throws RemoteException;
}
