/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.MaterialConfiguration;
import ink3d.ConfigurationObjects.PrintConfiguration;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.PrintJobSelection;
import ink3d.ConfigurationObjects.PrinterConfiguration;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author daniellain
 */
public class XmlPersistenceFramework extends ink3d.UserInterface.Database.PersistenceFramework{

    @Override
    public ArrayList<String> getPrinterConfigurations() {
        GetPrinterConfigurationsCommand get = new GetPrinterConfigurationsCommand();
        get.execute();
        return (ArrayList<String>)get.getResult();
    }

    @Override
    public ArrayList<String> getExtruderConfigurations() {
        GetExtruderConfigurationsCommand get = new GetExtruderConfigurationsCommand();
        get.execute();
        return (ArrayList<String>)get.getResult();
    }

    @Override
    public ArrayList<String> getMaterialConfigurations() {
        GetMaterialConfigurationsCommand get = new GetMaterialConfigurationsCommand();
        get.execute();
        return (ArrayList<String>)get.getResult();
    }

    @Override
    public ArrayList<String> getPrintJobSelectionss() {
       GetPrintJobSelectionsCommand get = new GetPrintJobSelectionsCommand();
       get.execute();
       return (ArrayList<String>)get.getResult();
    }

    @Override
    public ArrayList<String> getPrintConfigurations() {
       GetPrintConfigurationsCommand get = new GetPrintConfigurationsCommand();
       get.execute();
       return (ArrayList<String>)get.getResult();
    }

    @Override
    public PrinterConfiguration getPrinterConfiguration(String name) {
        GetPrinterConfigurationCommand get = new GetPrinterConfigurationCommand(name);
        get.execute();
        return (PrinterConfiguration)get.getResult();
    }

    @Override
    public ExtruderConfiguration getExtruderConfiguration(String name) {
        GetExtruderConfigurationCommand get = new GetExtruderConfigurationCommand(name);
        get.execute();
        return (ExtruderConfiguration)get.getResult();
    }

    @Override
    public MaterialConfiguration getMaterialConfiguration(String name) {
        GetMaterialConfigurationCommand get = new GetMaterialConfigurationCommand(name);
        get.execute();
        return (MaterialConfiguration)get.getResult();
    }

    @Override
    public PrintJobConfiguration getPrintJobConfiguration(PrintJobSelection printJob) {
        GetPrintJobConfigurationCommand get = new GetPrintJobConfigurationCommand(printJob);
        get.execute();
        return (PrintJobConfiguration)get.getResult();
    }

    @Override
    public PrintJobSelection getPrintJobSelection(String name) {
        GetPrintJobSelectionCommand get = new GetPrintJobSelectionCommand(name);
        get.execute();
        return (PrintJobSelection)get.getResult();
    }

    @Override
    public PrintConfiguration getPrintConfiguration(String name) {
        GetPrintConfigurationCommand get = new GetPrintConfigurationCommand(name);
        get.execute();
        return (PrintConfiguration)get.getResult();
    }

    @Override
    public Boolean savePrinterConfiguration(PrinterConfiguration config) {
        SavePrinterConfigurationCommand save = new SavePrinterConfigurationCommand(config);
        save.execute();
        return (Boolean)save.getResult();
    }

    @Override
    public Boolean saveExtruderConfiguration(ExtruderConfiguration config) {
        SaveExtruderConfigurationCommand save = new SaveExtruderConfigurationCommand(config);
        save.execute();
        return (Boolean)save.getResult();
    }

    @Override
    public Boolean saveMaterialConfiguration(MaterialConfiguration config) {
        SaveMaterialConfigurationCommand save = new SaveMaterialConfigurationCommand(config);
        save.execute();
        return (Boolean)save.getResult();
    }

    @Override
    public Boolean savePrintJobSelection(PrintJobSelection config) {
        SavePrintJobSelectionCommand save = new SavePrintJobSelectionCommand(config);
        save.execute();
        return (Boolean)save.getResult();
    }

    @Override
    public Boolean savePrintConfiguration(PrintConfiguration config) {
        SavePrintConfigurationCommand save = new SavePrintConfigurationCommand(config);
        save.execute();
        return (Boolean)save.getResult();
    }

    @Override
    public Boolean deletePrinterConfiguration(String name) {
        DeletePrinterConfigurationCommand delete = new DeletePrinterConfigurationCommand(name);
        delete.execute();
        return (Boolean)delete.getResult();
    }

    @Override
    public Boolean deleteExtruderConfiguration(String name) {
        DeleteExtruderConfigurationCommand delete = new DeleteExtruderConfigurationCommand(name);
        delete.execute();
        return (Boolean)delete.getResult();
    }

    @Override
    public Boolean deleteMaterialConfiguration(String name) {
        DeleteMaterialConfigurationCommand delete = new DeleteMaterialConfigurationCommand(name);
        delete.execute();
        return (Boolean)delete.getResult();
    }

    @Override
    public Boolean deletePrintJobSelection(String name) {
        DeletePrintJobSelectionCommand delete = new DeletePrintJobSelectionCommand(name);
        delete.execute();
        return (Boolean)delete.getResult();
    }

    @Override
    public Boolean deletePrintConfiguration(String name) {
        DeletePrintConfigurationCommand delete = new DeletePrintConfigurationCommand(name);
        delete.execute();
        return (Boolean)delete.getResult();
    }

    @Override
    public ArrayList<String> getStlFiles() {
        GetStlFilesCommand get = new GetStlFilesCommand();
        get.execute();
        return (ArrayList<String>)get.getResult();
    }

    @Override
    public File getStlFile(String name) {
        GetStlFileCommand get = new GetStlFileCommand(name);
        get.execute();
        return (File)get.getResult();
    }

    @Override
    public Boolean importStlFile(String path) {
        ImportStlFileCommand importStl = new ImportStlFileCommand(path);
        importStl.execute();
        return (Boolean) importStl.getResult();
    }

    @Override
    public Boolean deleteStlFile(String name) {
        DeleteStlFileCommand delete = new DeleteStlFileCommand(name);
        delete.execute();
        return (Boolean)delete.getResult();
    }

}
