/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guial
 */
public class ObservationRoom {
    private Desk[] desks;
    private Semaphore fullPatients;
    private Semaphore fullWorkers;
    
    public ObservationRoom(){
        fullPatients= new Semaphore(10);
        fullWorkers= new Semaphore(10);
        
        
    }
    public int numPatients(){
        return 20-fullPatients.availablePermits(); //Returns how many places are available checking semaphore
    }
    
    public int numWorkers(){
        return 20-fullWorkers.availablePermits(); //Returns how many places are available checking semaphore
    }
    
    public void goInside(HealthcareWorker h){
        try {
            fullWorkers.acquire(); //Blocked if full
        } catch (InterruptedException ex) {
            Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i=0;i<10;i++){
            if (desks[i].isAvailableForWorker()){
                try {
                    desks[i].goInside(h);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    public void goInside(Patient p){
        try {
            fullPatients.acquire(); //Blocked if full
        } catch (InterruptedException ex) {
            Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i=0;i<10;i++){
            if (desks[i].isAvailableForPatient()){
                try {
                    desks[i].goInside(p);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
   public void goOut(HealthcareWorker h) throws InterruptedException{
        String workersCurrentDesk=h.getCurrentDesk();
        for (int i=0;i<10;i++){
            if (desks[i].getID().equals(workersCurrentDesk)){ //If this is the desk where it is working, then go out
                desks[i].goOut(h);  
                fullWorkers.release(); //Realease one place, as it has gone out
            }
        }
    }
   
   public void goOut(Patient p) throws InterruptedException{
        String patientsCurrentDesk=p.getCurrentDesk();
        for (int i=0;i<10;i++){
            if (desks[i].getID().equals(patientsCurrentDesk)){ //If this is the desk where it is being attended, then go out
                desks[i].goOut(p);
                fullPatients.release(); //Realease one place, as it has gone out
            }
        }
    }
}
