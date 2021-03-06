/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author daniellain
 */
public class GetExtruderConfigurationsCommand extends ink3d.UserInterface.Database.CommandStructure{

    @Override
    public void execute() {
        File folder = new File("./Database/Extruders/");
        File[] files = folder.listFiles();
        result = new ArrayList<String>();
        for(File f: files){
            if(f.getName().contains(".xml"))((ArrayList<String>)result).add(f.getName().substring(0,f.getName().length()-4 ));
        }
    }
    
}
