/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import java.io.File;

/**
 *
 * @author daniellain
 */
public class DeletePrintConfigurationCommand extends ink3d.UserInterface.Database.CommandStructure{
    private String fileName;
    
    public DeletePrintConfigurationCommand(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void execute() {
        try{
            File file = new File("./Prints/"+fileName);
            result = file.delete();
     	}catch(Exception e){
             e.printStackTrace();
     	}
    }
    
}