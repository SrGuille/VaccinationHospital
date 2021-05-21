/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guial
 */
public class VaccinationRoom {
    private Desk[] desks;
    public Semaphore mutex;
    private Semaphore fullPatients;
    private Semaphore fullWorkers;
    private final ObservationRoom oRoom;
    private AtomicInteger numVaccines;
    
    public VaccinationRoom(ObservationRoom o){
        mutex = new Semaphore(1);
        fullPatients= new Semaphore(10);
        fullWorkers= new Semaphore(10);
        oRoom=o;
        numVaccines =new AtomicInteger(0);
   
    }
     
    private int numPatients(){
        return 10-fullPatients.availablePermits(); //Returns how many places are available checking semaphore
    }
    
    private int numWorkers(){
        return 10-fullWorkers.availablePermits(); //Returns how many places are available checking semaphore
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
    
    /*
    *  You can only go on in the case where there is an available doctor alone in his desk 
    *  and if the number of patients in vaccination room added to number of patients in observation room is lower or equal than 20.
    *  This second condition is mandatory because we need to be sure that the patient will be able to go to an observation room just after recieving the vaccine.
    */
    private boolean patientCanGoIn(){
        
        boolean isAuthorised=false;
        int numPatientsAtVRoom = numPatients();
        int numWorkersAtVRoom = numWorkers();
        int numPatientsAtORoom = oRoom.numPatients();  
        
        if (numWorkersAtVRoom>numPatientsAtVRoom && (numPatientsAtVRoom+numPatientsAtORoom)<=20){ 
            isAuthorised=true;
        }
        
        return isAuthorised;
    }
    
    /*
    *  Finds the correct desk and goes in
    */
    private void findDesk(Patient p){
        
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
    
    public boolean tryGoInside(Patient p){
        
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean success=false;
        
        if (patientCanGoIn()){
            
            success=true;
            
            try {
                fullPatients.acquire(); 
            } catch (InterruptedException ex) {
                Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            findDesk(p);
        }
        
        return success; 
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
   
   public void produceVaccine(){
       numVaccines.incrementAndGet();
   }
   
   public void getVaccine(){
       numVaccines.decrementAndGet();
   }
}