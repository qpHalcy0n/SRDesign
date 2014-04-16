/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrintJob;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.PrintJobSelection;
import ink3d.ConfigurationObjects.PrinterConfiguration;
import ink3d.UserInterface.Database.PersistenceFramework;
import ink3d.UserInterface.Database.XmlDatabase.XmlPersistenceFramework;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dan
 */
public class PrintJobController {
    PersistenceFramework db;
    PrintJobSelection selection;
    PrintJobConfiguration printJob;
    
    ArrayList<String> loadAvailableFiles(){
        return db.getStlFiles();
    }

    PrintJobController(){
        db = new XmlPersistenceFramework();
    }
    
    ArrayList<String> loadAvailablePrintJobs(){
        return db.getPrintJobSelectionss();
    }
    
    ArrayList<String> loadAvailablePrinters(){
        return db.getPrinterConfigurations();
    }
    
    ArrayList<String> loadAvailablePrints(){
        return db.getPrintConfigurations();
    }
    
    ArrayList<String> loadAvailableExtruders(){
        return db.getExtruderConfigurations();
    }
    
    ArrayList<String> loadAvailableMaterials(){
        return db.getMaterialConfigurations();
    }
   
    PrintJobConfiguration loadPrintJobConfiguration(PrintJobSelection selected){
        return db.getPrintJobConfiguration(selected);
    }
    
    Boolean savePrintJobConfiguration(String name, PrintJobSelection job){
        job.setName(name);
        return db.savePrintJobSelection(job);
    }
    
    void startPrint(PrintJobSelection printJob){
    
    }
}
