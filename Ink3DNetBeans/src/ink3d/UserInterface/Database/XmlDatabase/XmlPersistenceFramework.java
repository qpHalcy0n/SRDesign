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
import ink3d.ConfigurationObjects.PrinterConfiguration;
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
    public ArrayList<String> getPrintJobConfigurations() {
        GetPrintJobSelectionsCommand get = new GetPrintJobSelectionsCommand();
        get.execute();
        return (ArrayList<String>)get.getResult();
    }

    @Override
    public ArrayList<String> getprintConfigurations() {
        GetPrintConfigurationsCommand get = new GetPrintConfigurationsCommand();
        get.execute();
        return (ArrayList<String>)get.getResult();
    }

    @Override
    public PrinterConfiguration getPrinterConfiguration(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExtruderConfiguration getExtruderConfiguration(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MaterialConfiguration getMaterialConfiguration(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PrintJobConfiguration getPrintJobConfiguration(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PrintConfiguration getPrintConfiguration(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean savePrinterConfiguration(PrinterConfiguration config) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean saveExtruderConfiguration(ExtruderConfiguration config) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean saveMaterialConfiguration(MaterialConfiguration config) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean savePrintJobConfiguration(PrintJobConfiguration config) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean savePrintConfiguration(PrintConfiguration config) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean deletePrinterConfiguration(String fileName) {
        DeletePrinterConfigurationCommand delete = new DeletePrinterConfigurationCommand(fileName);
        delete.execute();
        return (Boolean)delete.getResult();
    }

    @Override
    public Boolean deleteExtruderConfiguration(String fileName) {
        DeleteExtruderConfigurationCommand delete = new DeleteExtruderConfigurationCommand(fileName);
        delete.execute();
        return (Boolean)delete.getResult();
    }

    @Override
    public Boolean deleteMaterialConfiguration(String fileName) {
        DeleteMaterialConfigurationCommand delete = new DeleteMaterialConfigurationCommand(fileName);
        delete.execute();
        return (Boolean)delete.getResult();
    }

    @Override
    public Boolean deletePrintJobConfiguration(String fileName) {
        DeletePrintJobConfigurationCommand delete = new DeletePrintJobConfigurationCommand(fileName);
        delete.execute();
        return (Boolean)delete.getResult();
    }

    @Override
    public Boolean deletePrintConfiguration(String fileName) {
        DeletePrintConfigurationCommand delete = new DeletePrintConfigurationCommand(fileName);
        delete.execute();
        return (Boolean)delete.getResult();
    }
    
}
