/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.UserInterface.Database.CommandStructure;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniellain
 */
public class ImportStlFileCommand extends CommandStructure{
    private File stlFile;
    
    ImportStlFileCommand(String path){
        stlFile = new File(path);
    }
    
    @Override
    public void execute() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("./Database/Files/");
            sb.append(stlFile.getName().substring(0, stlFile.getName().length() - 4));
            sb.append(".stl");
            Files.copy(stlFile.toPath(), (new File(sb.toString())).toPath(), StandardCopyOption.REPLACE_EXISTING);
            result = Boolean.TRUE;
        } catch (IOException ex) {
            Logger.getLogger(ImportStlFileCommand.class.getName()).log(Level.SEVERE, null, ex);
            result = Boolean.FALSE;
        }
    }
    
}
