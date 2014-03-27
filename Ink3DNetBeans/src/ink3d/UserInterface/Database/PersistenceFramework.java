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
import ink3d.ConfigurationObjects.PrintJobSelection;
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
    public abstract ArrayList<String> getPrintJobSelectionss();
    public abstract ArrayList<String> getPrintConfigurations();
    public abstract PrinterConfiguration getPrinterConfiguration(String name);
    public abstract ExtruderConfiguration getExtruderConfiguration(String name);
    public abstract MaterialConfiguration getMaterialConfiguration(String name);
    public abstract PrintJobConfiguration getPrintJobConfiguration(PrintJobSelection printJOb);
    public abstract PrintJobSelection getPrintJobSelection(String name);
    public abstract PrintConfiguration getPrintConfiguration(String fileName);
    public abstract Boolean savePrinterConfiguration(PrinterConfiguration config);
    public abstract Boolean saveExtruderConfiguration(ExtruderConfiguration config);
    public abstract Boolean saveMaterialConfiguration(MaterialConfiguration config);
    public abstract Boolean savePrintJobSelection(PrintJobSelection config);
    public abstract Boolean savePrintConfiguration(PrintConfiguration config);
    public abstract Boolean deletePrinterConfiguration(String fileName);
    public abstract Boolean deleteExtruderConfiguration(String fileName);
    public abstract Boolean deleteMaterialConfiguration(String fileName);
    public abstract Boolean deletePrintJobSelection(String fileName);
    public abstract Boolean deletePrintConfiguration(String fileName);
    
}
