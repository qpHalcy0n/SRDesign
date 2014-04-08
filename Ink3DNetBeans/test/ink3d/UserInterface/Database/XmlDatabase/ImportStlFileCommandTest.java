/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daniellain
 */
public class ImportStlFileCommandTest {
    String expected = "./Database/Files/Feed-Housing.stl";
    String name = "./test-files/stl/Feed-Housing.STL";
    File newFile;
    
    public ImportStlFileCommandTest() {
    }
    
    @After
    public void tearDown(){
        newFile.delete();
    }
    
    @Test
    public void testImportStlFileCommnadTest() {
        ImportStlFileCommand importStl = new ImportStlFileCommand(name);
        importStl.execute();
        newFile = new File(expected);
        assertTrue(newFile.exists());
        try {
            String actual = FileUtils.readFileToString(new File(name));
            expected =  FileUtils.readFileToString(newFile);
        } catch (IOException ex) {
            Logger.getLogger(ImportStlFileCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
