/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.UserInterface.Database.CommandStructure;
import java.io.File;

/**
 *
 * @author daniellain
 */
public class DeleteStlFileCommand extends CommandStructure {
   private String fileName;
    
    public DeleteStlFileCommand(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void execute() {
        try{
            File file = new File("./Database/Files/"+fileName+".xml");
            result = file.delete();
     	}catch(Exception e){
             e.printStackTrace();
     	}
    }
    
}
