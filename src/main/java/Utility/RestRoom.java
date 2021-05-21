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

/**
 *
 * @author guial
 */
public class RestRoom {

    public Semaphore mutex = new Semaphore(1);

    List workers = Collections.synchronizedList(new ArrayList());
    private Receptionist receptionist;
    private VaccinePreparer vaccinePreparer;
    
    public RestRoom(){

    }
    
    public void goIn(HealthcareWorker h){
        workers.add(h);
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
}
