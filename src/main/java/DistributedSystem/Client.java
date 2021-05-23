/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DistributedSystem;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

/**
 *
 * @author guial
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try
        {
            
            RemoteMethodsInterface rmi =(RemoteMethodsInterface) Naming.lookup("//localhost/Prime");//Locate object 
            rmi.updateDisplay();
            rmi.cleanVaccinationDesk();

        }catch(IOException | NotBoundException ex) 
          {
              System.out.println("Error: "+ ex.getMessage());
          }
    }
    
}
