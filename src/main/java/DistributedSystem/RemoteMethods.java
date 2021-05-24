package DistributedSystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author guial
 */
public class RemoteMethods extends UnicastRemoteObject implements RemoteMethodsInterface
{
    public RemoteMethods ()throws RemoteException {}


    @Override
    public void updateDisplay()throws RemoteException 
    {   
        
    }
    
    @Override
    public void cleanVaccinationDesk()throws RemoteException 
    { 
    }
}