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
public class GetStlFileCommand extends CommandStructure{
    String name;
    private static String path = "./Database/Files/";
    private static String extention =".stl";
    
    public GetStlFileCommand(String name){
        this.name = name;
    }
    @Override
    public void execute() {
        File file = new File(path+name+extention);
        if(file.exists()) result = file;
        else result = null;
    }
}
