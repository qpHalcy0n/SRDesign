/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.UserInterface.Database.CommandStructure;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author daniellain
 */
public class GetStlFilesCommand extends CommandStructure{

    @Override
    public void execute() {
        File folder = new File("./Database/Files/");
        File[] files = folder.listFiles();
        result = new ArrayList<String>();
        if(files!=null)for(File f: files){
            if(f.getName().contains(".stl"))((ArrayList<String>)result).add(f.getName().substring(0,f.getName().length()-4 ));
        }
        files = null;
    }
    
}
