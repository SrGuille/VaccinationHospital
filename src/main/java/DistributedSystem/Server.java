/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DistributedSystem;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author guial
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try
        {
            RemoteMethods methods =new RemoteMethods();
            Registry registry = LocateRegistry.createRegistry(1099);//Starts local rmiregistry. Port 1099
            Naming.rebind("//localhost/Prime", methods);
        }
        catch(Exception e){ System.out.println("Error: "+ e.getMessage());
        }
    }
    
}
