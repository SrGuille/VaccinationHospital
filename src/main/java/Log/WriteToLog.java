/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guial
 */
public class WriteToLog {
    
    private String path;
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    
    public WriteToLog(String filePath){
        path=filePath;
    }
    
    public void write(String line){
        try {
            FileWriter file = new FileWriter(path, true); //Append to file
            PrintWriter writeLine = new PrintWriter(file);
            
            LocalDateTime date = LocalDateTime.now();
            String formattedDate = date.format(myFormatObj);
            writeLine.printf(formattedDate);
            writeLine.printf("%s"+"%n", line);
            writeLine.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteToLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
}
