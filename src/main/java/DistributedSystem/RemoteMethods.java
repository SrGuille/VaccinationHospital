/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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