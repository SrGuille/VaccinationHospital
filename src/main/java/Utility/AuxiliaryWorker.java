package Utility;

public abstract class AuxiliaryWorker extends Thread{
    private final String auxWorkerID;

    
    public AuxiliaryWorker(int wID){
        auxWorkerID=assignID(wID);      
    }
    
    private String assignID(int wID){
        return "A"+wID;
    }
    
    public String getID(){
        return auxWorkerID;
    }

            
    }
