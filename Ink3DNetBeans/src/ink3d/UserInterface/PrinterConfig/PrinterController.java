/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrinterConfig;

import ink3d.ConfigurationObjects.HardwareConfiguration;
import ink3d.ConfigurationObjects.PrinterConfiguration;
import ink3d.UserInterface.Database.PersistenceFramework;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dan
 */
public class PrinterController {
    private PersistenceFramework db = PersistenceFramework.getDB();
    
    public ArrayList<String> getPrinterConfigurations(){
        return db.getPrinterConfigurations();
    }
    
    public Boolean deletePrinterConfiguration(String name){
        return db.deletePrinterConfiguration(name);
    }
    
    public Boolean savePrinterConfiguratoin(ArrayList<String> vars, ArrayList<Boolean> errors) throws Exception{
        Double d;
        Integer i;
        PrinterConfiguration config = new PrinterConfiguration();
        config.setName(vars.get(0));
        
        d = new Double(vars.get(1));
        if(d>0) config.setBedX(d);
        else {
            throw new BadFieldException("Bed X must be a double precision value greater than 0.");
        }
        
        d = new Double(vars.get(2));
        if(d>0) config.setBedY(d);
        else {
            throw new BadFieldException("Bed Y must be a double precision value greater than 0.");
        }
        
        d = new Double(vars.get(3));
        if(d >=0 && d <= config.getBedX()) config.setPrintCenterX(d);
        else {
            throw new BadFieldException("Print Center X must be a double precision value greater than 0 and less than Bed X.");
        }
        
        d = new Double(vars.get(4));
        if(d >=0 && d<=config.getBedY()) config.setPrintCenterY(d);
        else {
            throw new BadFieldException("Print Center Y must be a double precision value greater than 0 and lessthan Bed Y.");
        }
       
        d = new Double(vars.get(5));
        if(d>=0)config.setzOffset(d);
        else {
            throw new BadFieldException("Z Offset must be a double precision value greater than or equal to 0.");
        }
        
        config.setgCodeFlavor(vars.get(6));
        config.setUseRelativeEDistances(Boolean.parseBoolean(vars.get(7)));
        
        i = new Integer(vars.get(8));
        if(i>0)config.setNumExtruders(i);
        else {
            throw new BadFieldException("Number of Extruders must be a integer value greater than 0.");
        }
        
        d = new Double(vars.get(9));
        if(d>=0) config.setVibrationLimit(d);
        else {
            throw new BadFieldException("Vibration Limit must be a double precision value greater than or equal to  0.");
        }
        
        config.setHardware(new HardwareConfiguration());
        config.getHardware().setComPort(vars.get(10));
        i = new Integer(vars.get(10));
        if(i>=0 && i <= 250000)config.getHardware().setBaudRate(i);
        else{
            throw new BadFieldException("Baud rate must be between 0 and 250,000");
        }
        config.getHardware().setLineEnd(new Integer(vars.get(11)));
        
        config.setUseFirmwareRetraction(new Boolean(vars.get(12)));
        config.setStartGCode(vars.get(13));
        config.setEndGCode(vars.get(14));
        
        return db.savePrinterConfiguration(config);
    }
    public class BadFieldException extends Exception{
        public BadFieldException(String message){
            super(message);
        }  
    }
}
