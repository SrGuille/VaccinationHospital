/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guial
 */
public class Reception {
    
    private BlockingQueue queue;
    
    public Reception(BlockingQueue q){
        queue=q;
    }
    
    public Patient attend(){
        Random random = new Random();
        Patient attendedPatient=null;
        try {
            attendedPatient = (Patient) queue.take();
        } catch (InterruptedException ex) {
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (random.nextInt(100)==0){ //Give a 1% chance of not listed
            attendedPatient=null;
        }
        
        return attendedPatient;
    }
}
