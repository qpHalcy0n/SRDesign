/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.FileConfiguration;
import ink3d.ConfigurationObjects.FileSelection;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.PrintJobSelection;
import ink3d.ConfigurationObjects.SubsetConfiguration;
import ink3d.ConfigurationObjects.SubsetSelection;
import ink3d.UserInterface.Database.CommandStructure;
import ink3d.UserInterface.Database.PersistenceFramework;
import java.util.ArrayList;

/**
 *
 * @author daniellain
 */
public class GetPrintJobConfigurationCommand extends CommandStructure{
    PrintJobSelection selection;
    PrintJobConfiguration printJob;
    ArrayList<SubsetConfiguration> subsetList;
    ArrayList<FileConfiguration> fileList;
    SubsetConfiguration subset;
    FileConfiguration fileConfig;
    PersistenceFramework db;
    
    GetPrintJobConfigurationCommand(PrintJobSelection selection){
        this.selection = selection;
        printJob = new PrintJobConfiguration();
    }
    
    @Override
    public void execute() {
        db = new XmlPersistenceFramework();
        
        subsetList = new ArrayList<>();
        
        for(SubsetSelection set : selection.getSubsetConfigurationList()){            
            fileList = new ArrayList<>();
            for(FileSelection select : set.getFileConfigurations()){
                fileConfig = new FileConfiguration();
                fileConfig.setExtruderConfiguration(db.getExtruderConfiguration(select.getExtruder()));
                fileConfig.setMaterialConfiguration(db.getMaterialConfiguration(select.getMaterial()));
                fileConfig.setName(select.getFile());
                fileList.add(fileConfig);
            }
            
            subset = new SubsetConfiguration();
            subset.setBottomZ(set.getBottomZ());
            subset.setTopZ(set.getTopZ());
            subset.setPrintConfiguration(db.getPrintConfiguration(selection.getPrinterConfiguration()));
            subset.setFileConfigurations(fileList);
        }
        
        printJob.setName(selection.getName());
        printJob.setPrinterConfiguration(db.getPrinterConfiguration(selection.getPrinterConfiguration()));
        printJob.setSubsetConfigurationList(subsetList);
        
        this.result = printJob;
    }
    
}
