/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.UserInterface.Database.CommandStructure;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

            // Create temp scad file
            File tempFile = new File("temp.scad");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String inputFilePath = stlFile.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");
            writer.append("import(\"" + inputFilePath + "\");");
            writer.close();

            // Create command to use openscad
            String baseDir = new File("").getAbsolutePath();
            String destPath = baseDir + "/Database/Files/"
                + stlFile.getName().substring(0, stlFile.getName().length() - 4)
                + ".stl";
            String command = baseDir + "/third-party/openscad/openscad.exe -o "
                + "\"" + destPath + "\" \"" + tempFile.getAbsolutePath() + "\"";
            
            // Use openscad to convert STL file to ascii
            Process openScadProcess = Runtime.getRuntime().exec(command);
            openScadProcess.waitFor();

            // Delete temp file
            tempFile.delete();
            
            /*
            StringBuilder sb = new StringBuilder();
            sb.append("./Database/Files/");
            sb.append(stlFile.getName().substring(0, stlFile.getName().length() - 4));
            sb.append(".stl");
            Files.copy(stlFile.toPath(), (new File(sb.toString())).toPath(), StandardCopyOption.REPLACE_EXISTING);
            stlFile = null;
            */

            System.gc();
            result = Boolean.TRUE;
        } catch (IOException ex) {
            Logger.getLogger(ImportStlFileCommand.class.getName()).log(Level.SEVERE, null, ex);
            result = Boolean.FALSE;
        } catch (InterruptedException ex) {
            Logger.getLogger(ImportStlFileCommand.class.getName()).log(Level.SEVERE, null, ex);
            result = Boolean.FALSE;
        }
    }
    
}
