package Utility;

import Log.WriteToLog;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VaccinationRoom {
    private Desk[] desks=new Desk[10];
    public Semaphore mutex;
    private AtomicInteger numWorkers;
    private AtomicInteger numPatients;
    private final ObservationRoom oRoom;
    private AtomicInteger numVaccines;
    private Receptionist receptionist;
    private WriteToLog log;
    
    public VaccinationRoom(ObservationRoom o, WriteToLog log){
        mutex = new Semaphore(1);
        oRoom=o;
        this.log=log;
        numVaccines =new AtomicInteger(0);
        numWorkers =new AtomicInteger(0);
        numPatients=new AtomicInteger(0);
        for (int i=0; i<10; i++){
            desks[i]= new Desk(i+1,true,log);
        }
    }
    
    public void setReceptionist(Receptionist r){
        receptionist=r;
    }

    public void goInside(HealthcareWorker h){
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i=0;i<10;i++){
            if (desks[i].isAvailableForWorker()){
                System.out.println("Is available" + desks[i].getID()+" "+desks[i].isAvailableForWorker());
                try {
                    numWorkers.getAndIncrement();
                    desks[i].goInside(h);
                    break;
                } catch (InterruptedException ex) {
                    Logger.getLogger(VaccinationRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            receptionist.conditionalInterrupt(2); //We tell the receptionist that now there is a spot in the room, as a worker has come
        }
        mutex.release();
        
    }
    
    /*
    *  You can only go on in the case where there is an available doctor alone in his desk 
    *  and if the number of patients in vaccination room added to number of patients in observation room is lower or equal than 20.
    *  This second condition is mandatory because we need to be sure that the patient will be able to go to an observation room just after recieving the vaccine.
    */
    private boolean patientCanGoIn(){
        
        boolean isAuthorised=false;
        int numPatientsAtVRoom = numPatients.get();
        int numWorkersAtVRoom = numWorkers.get();
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
                        p.setCurrentDesk(desks[i]);
                        desks[i].goInside(p);
                        break;
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
             
            numPatients.getAndIncrement();
            
            findDesk(p); //Go in
        }
        mutex.release();
        return success;       
    }
    
   public void goOut(HealthcareWorker h) throws InterruptedException{
        Desk workerCurrentDesk=h.getCurrentDesk();
        workerCurrentDesk.goOut(h);  
        numWorkers.getAndDecrement();
        
    }
   
   public void goOut(Patient p) throws InterruptedException{
        Desk patientCurrentDesk=p.getCurrentDesk();
       
        patientCurrentDesk.goOut(p); //Go out from vaccination room
        numPatients.getAndDecrement();
        oRoom.goInside(p); //Go into observation room

        receptionist.conditionalInterrupt(2); //We tell the receptionist that now there is a spot in the room, as a patient has left

   }
   
   public synchronized void produceVaccine(){
       int vaccinesReady =numVaccines.incrementAndGet();
       String message = " Vaccine produced, there are " + vaccinesReady + " ready";
       log.write(message);
       notify(); //Notify to a worker that was waiting for vaccine
       
   }
   
   public synchronized boolean getVaccine(){
       boolean vaccineFound=true;
       
       if (numVaccines.get()==0){
           vaccineFound=false;
       }
       else{
           numVaccines.decrementAndGet();
       }
      return vaccineFound;
   }
   
    public synchronized void waitForVaccineIsReady(HealthcareWorker h){
        try {
            wait(); //Wait in case it is necessary because of lack of vaccines
        } catch (InterruptedException ex) {
            Logger.getLogger(Desk.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
}