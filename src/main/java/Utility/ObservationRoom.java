/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

/**
 *
 * @author guial
 */
public class ObservationRoom {
    private int availableDesks;
    private Desk[] desks;
    
    public ObservationRoom(){
        availableDesks=20;
        for (int i=0;i<20;i++){
            desks[i]=new Desk(i);
        }
        
    }
}
