/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;

/**
 *
 * @author daniellain
 */
public class SaveExtruderConfigurationCommand extends ink3d.UserInterface.Database.CommandStructure{
    private ExtruderConfiguration config;
    
    public SaveExtruderConfigurationCommand(ExtruderConfiguration config){
        this.config = config;
    }
    
    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
