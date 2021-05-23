package DistributedSystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author guial
 */
public interface RemoteMethodsInterface extends Remote  {

    void updateDisplay()throws RemoteException;
    void cleanVaccinationDesk()throws RemoteException;
}
