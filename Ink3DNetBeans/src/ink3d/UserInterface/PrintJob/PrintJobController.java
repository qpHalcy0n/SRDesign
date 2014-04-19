/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrintJob;

import ink3d.ConfigurationObjects.ExtruderMaterialSelection;
import ink3d.ConfigurationObjects.FileSelection;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.PrintJobSelection;
import ink3d.ConfigurationObjects.PrinterConfiguration;
import ink3d.ConfigurationObjects.SubsetSelection;
import ink3d.PostProcessing.PostProcessorException;
import ink3d.PostProcessing.Slic3rPostProcessorImpl;
import ink3d.Preprocessing.Normalizer;
import ink3d.Preprocessing.PreprocessorException;
import ink3d.Preprocessing.Slic3rNormalizerImpl;
import ink3d.Processing.ProcessorException;
import ink3d.Processing.Slic3rSlicingEngineWrapperImpl;
import ink3d.UserInterface.Database.PersistenceFramework;
import ink3d.UserInterface.Database.XmlDatabase.XmlPersistenceFramework;
import ink3d.UserInterface.MainMenu.BadFieldException;
import ink3d.UserInterface.MainMenu.MainWindow;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan
 */
public class PrintJobController {
    double d;
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
    
    Boolean savePrintJobConfiguration(String name, String printerName, ArrayList<SubsectionPanel> panels) throws BadFieldException{
        PrintJobSelection job = new PrintJobSelection();
        PrinterConfiguration printer = db.getPrinterConfiguration(printerName);
        job.setName(name);
        job.setPrinterConfiguration(printerName);
        if(printer.getExtruderList().size()<PrintJobPanel.extruderMaterialArrayListForPrintJob.size()) throw new BadFieldException("You can not assign more Materials than you have extruders.");
        ArrayList<ExtruderMaterialSelection> extruderMaterialSelection = new ArrayList<>();
        for(int i =0; i < PrintJobPanel.extruderMaterialArrayListForPrintJob.size(); i++){
            extruderMaterialSelection.add(new ExtruderMaterialSelection(printer.getExtruderList().get(i).getName() ,PrintJobPanel.extruderMaterialArrayListForPrintJob.get(i)));
        }      
        job.setMaterials(extruderMaterialSelection);
        
        job.setSubsetConfigurationList(new ArrayList<SubsetSelection>());
        for(int i=0; i< panels.size(); i++){
            SubsetSelection subset = new SubsetSelection();
            if(panels.get(i).getFileList().size() != panels.get(i).getExtruderList().size())throw new BadFieldException("All files must have a material associated with it.");
            subset.setFileConfigurations(new ArrayList<FileSelection>());
            for(int j=0; j < panels.get(i).getFileList().size(); j++){
                subset.getFileConfigurations().add(new FileSelection(panels.get(i).getExtruderList().get(j), 
                                PrintJobPanel.extruderMaterialArrayListForPrintJob.get(j).substring(3),
                        panels.get(i).getFileList().get(j)));
            }
            try{
                d = Double.valueOf(panels.get(i).getStartZ());
                if(d<0)throw new BadFieldException("Subset start must be a double precision value greater than or equal to 0.");
                subset.setBottomZ(d);
            }catch(NumberFormatException e){
                throw new BadFieldException("Subset start must be a double precision value greater than or equal to 0.");
            }
            
            try{
                d = Double.valueOf(panels.get(i).getFinishZ());
                if(d<0)throw new BadFieldException("Subset finish must be a double precision value greater than or equal to 0.");
                subset.setTopZ(d);
            }catch(NumberFormatException e){
                throw new BadFieldException("Subset finish must be a double precision value greater than or equal to 0.");
            }
            job.getSubsetConfigurationList().add(subset);
        }
        return db.savePrintJobSelection(job);
    }
    
    public ArrayList<String> loadPrintJobSelection(String name){
        ArrayList<String> list = new ArrayList();
        PrintJobSelection job;
        job = db.getPrintJobSelection(name);
        list.add(job.getName());
        list.add(job.getPrinterConfiguration());
        MasterSubsectionPane pane = MainWindow.printJobPanel.getMasterSubsectionPane();
        pane.removeAllSubsections();
        for(SubsetSelection subset: job.getSubsetConfigurationList()){
            pane.addNewSubsectionPanel(new SubsectionPanel(subset));
        }
        for(ExtruderMaterialSelection extruder:job.getMaterials()){
            PrintJobPanel.extruderMaterialArrayListForPrintJob.add(extruder.getMaterial());
        }
        return list;
    }
    
    void startPrint(String name) throws BadFieldException, PreprocessorException, ProcessorException, PostProcessorException{
        PrintJobSelection job;
        job = db.getPrintJobSelection(name);
        
        PrintJobConfiguration printJob;
        printJob = db.getPrintJobConfiguration(job);
        
        Slic3rNormalizerImpl normalizer = new Slic3rNormalizerImpl();
        Slic3rSlicingEngineWrapperImpl slicer = new Slic3rSlicingEngineWrapperImpl();
        Slic3rPostProcessorImpl post = new Slic3rPostProcessorImpl();
        normalizer.normalize(printJob);
        slicer.generateGCode(printJob);
        post.postprocess(printJob);           
    }
}
