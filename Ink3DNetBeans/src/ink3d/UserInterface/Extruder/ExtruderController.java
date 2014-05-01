/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Extruder;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.UserInterface.Database.PersistenceFramework;
import ink3d.UserInterface.MainMenu.BadFieldException;
import ink3d.Util.InputValidationUtility;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tim
 */
public class ExtruderController {
    private PersistenceFramework db;
    
    public ExtruderController() {
        this.db = PersistenceFramework.getDB();
    }

    public List<String> loadExtruderConfigurationList() {
        return db.getExtruderConfigurations();
    }

    public ExtruderConfiguration loadExtruderConfiguration(String name) {
        return db.getExtruderConfiguration(name);
    }

    public boolean saveExtruderConfiguration(ExtruderConfiguration extruder) {
        if(validateExtruder(extruder)) {
            db.saveExtruderConfiguration(extruder);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteExtruderConfiguration(String name) {
        return db.deleteExtruderConfiguration(name);
    }

    private boolean validateExtruder(ExtruderConfiguration extruder) {
        try {
            InputValidationUtility.checkIfInRange("Nozzle Diameter", extruder.getNozzleDiameter(), 0.0, Double.POSITIVE_INFINITY);
            return true;
        } catch (BadFieldException ex) {
            Logger.getLogger(ExtruderController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex.getMessage(), ex.getMessage(), JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
