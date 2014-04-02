/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import java.io.File;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daniellain
 */
public class ImportStlFileCommandTest {
    String importedPath;
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
    }
    
}
