/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database;

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
public abstract class PersistenceFramework {
    public abstract ArrayList<String> getPrinterConfigurations();
    public abstract ArrayList<String> getExtruderConfigurations();
    public abstract ArrayList<String> getMaterialConfigurations();
    public abstract ArrayList<String> getPrintJobConfigurations();
    public abstract ArrayList<String> getprintConfigurations();
    public abstract PrinterConfiguration getPrinterConfiguration(String fileName);
    public abstract ExtruderConfiguration getExtruderConfiguration(String fileName);
    public abstract MaterialConfiguration getMaterialConfiguration(String fileName);
    public abstract PrintJobConfiguration getPrintJobConfiguration(String fileName);
    public abstract PrintConfiguration getPrintConfiguration(String fileName);
    public abstract Boolean savePrinterConfiguration(PrinterConfiguration config);
    public abstract Boolean saveExtruderConfiguration(ExtruderConfiguration config);
    public abstract Boolean saveMaterialConfiguration(MaterialConfiguration config);
    public abstract Boolean savePrintJobConfiguration(PrintJobConfiguration config);
    public abstract Boolean savePrintConfiguration(PrintConfiguration config);
    public abstract Boolean deletePrinterConfiguration(String fileName);
    public abstract Boolean deleteExtruderConfiguration(String fileName);
    public abstract Boolean deleteMaterialConfiguration(String fileName);
    public abstract Boolean deletePrintJobConfiguration(String fileName);
    public abstract Boolean deletePrintConfiguration(String fileName);
    
}
