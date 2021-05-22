/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guial
 */
public class RestRoom {

    private Semaphore mutex = new Semaphore(1);

    private List workers = Collections.synchronizedList(new ArrayList());
    private Receptionist receptionist;
    private VaccinePreparer vaccinePreparer;
    private List emergencyDesks = Collections.synchronizedList(new ArrayList());
    private ObservationRoom oRoom;
    
    public RestRoom(ObservationRoom o){
        oRoom=o;
    }
    
    public void goIn(HealthcareWorker h){
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(RestRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!emergencyDesks.isEmpty()){ //If there is an emergency and the rest room was empty the worker directly goes to help
            oRoom.goInside(h, (Desk)emergencyDesks.get(0));
            h.interrupt();
            emergencyDesks.remove(0);
        }
        else{
            workers.add(h);
        }
        mutex.release();
    }
    
    public void goIn(Receptionist r){
        receptionist=r;
    }
    
    public void goIn(VaccinePreparer vp){
        vaccinePreparer=vp;
    }
    
    public void goOut(HealthcareWorker h){
        workers.remove(h);
    }
    
    public void goOut(Receptionist r){
        receptionist=null;
    }
    
    public void goOut(VaccinePreparer vp){
        vaccinePreparer=null;
    }
    
    public void callForHelp(Desk desk){
        if (!workers.isEmpty()){ //If there is someone, send him to help
            HealthcareWorker calledWorker = (HealthcareWorker) workers.remove(0);
            calledWorker.interrupt();
        }
        else{//Else, note the emergency
            emergencyDesks.add(desk);
        }
    }
}
