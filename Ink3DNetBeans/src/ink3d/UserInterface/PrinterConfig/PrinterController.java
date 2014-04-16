/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrinterConfig;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.HardwareConfiguration;
import ink3d.ConfigurationObjects.PrinterConfiguration;
import ink3d.UserInterface.Database.PersistenceFramework;
import ink3d.UserInterface.MainMenu.BadFieldException;
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
    
    public Boolean deletePrinterConfiguration(String name) throws BadFieldException{
        if(name == null || name =="")throw new BadFieldException("Please select a file to delete");
        return db.deletePrinterConfiguration(name);
    }
    
    public ArrayList<String> loadExtruderList(){
        return db.getExtruderConfigurations();
    }
    
    public ArrayList<String> loadMyExtruders(String name){
        ArrayList<String> extruderList = new ArrayList<String>();
        if(name == null || name =="")return extruderList;
        PrinterConfiguration printer = db.getPrinterConfiguration(name);
        for(ExtruderConfiguration extruder: printer.getExtruderList()){
            extruderList.add(extruder.getName());
        }
        return extruderList;
    }
    
    public ArrayList<String> loadPrinterConfiguration(String name) throws BadFieldException{
        if(name == null || name =="")throw new BadFieldException("Please select a file to delete");
        PrinterConfiguration printer;
        printer = db.getPrinterConfiguration(name);
        ArrayList<String> varList = new ArrayList<>();
        varList.add(name);
        varList.add(Double.toString(printer.getBedX()));
        varList.add(Double.toString(printer.getBedY()));
        varList.add(Double.toString(printer.getPrintCenterX()));
        varList.add(Double.toString(printer.getPrintCenterY()));
        varList.add(Double.toString(printer.getzOffset()));
        varList.add(printer.getgCodeFlavor());
        varList.add(Boolean.toString(printer.getUseRelativeEDistances()));
        varList.add(Integer.toString(printer.getNumExtruders()));
        varList.add(Double.toString(printer.getVibrationLimit()));
        varList.add(Boolean.toString(printer.getUseFirmwareRetraction()));
        varList.add(printer.getStartGCode());
        varList.add(printer.getEndGCode());
        
        return varList;
    }
    
    public Boolean savePrinterConfiguratoin(ArrayList<String> vars, ArrayList<String> extruderList) throws BadFieldException{
        Double d;
        Integer i;
        PrinterConfiguration config = new PrinterConfiguration();
        try{
            if(vars.get(0).length()>0)config.setName(vars.get(0));
            else {
                throw new BadFieldException("Name must not be empty.");
            }

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

            config.setUseFirmwareRetraction(Boolean.parseBoolean(vars.get(10)));
            config.setStartGCode(vars.get(11));
            config.setEndGCode(vars.get(12));

            config.setHardware(new HardwareConfiguration());
            /*
            config.getHardware().setComPort(vars.get(13));
            i = new Integer(vars.get(14));
            if(i>=0 && i <= 250000)config.getHardware().setBaudRate(i);
            else{
                throw new BadFieldException("Baud rate must be between 0 and 250,000");
            }
            config.getHardware().setLineEnd(new Integer(vars.get(15)));
            */
            ArrayList<ExtruderConfiguration> extruders = new ArrayList<>();
            for(String name: extruderList){
                  extruders.add(db.getExtruderConfiguration(name));
            }
            config.setExtruderList(extruders);
        }catch(NumberFormatException e){
            throw new BadFieldException("All Fields need to be filed out to save a Printer");
        }
        return db.savePrinterConfiguration(config);
    }
}
