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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daniellain
 */
public class DeleteMaterialConfigurationCommandTest {
    private File file;
    private String name = "./Database/Materials/DeleteTest.xml";
    
    /**
     * Test of execute method, of class DeleteExtruderConfigurationCommand.
     */
    @Test
    public void DeleteMaterialValidFileTest() {
         file = new File(name);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            fail("Could not create File to delete");
            Logger.getLogger(DeleteMaterialConfigurationCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        DeleteMaterialConfigurationCommand delete = new DeleteMaterialConfigurationCommand("DeleteTest");
        delete.execute();
        assertTrue((Boolean)delete.getResult());
    }
    @Test
    public void DeleteMaterialNoSuchFileTest(){
        DeleteMaterialConfigurationCommand delete = new DeleteMaterialConfigurationCommand("DeleteExceptionTest");
        delete.execute();
        assertFalse((Boolean)delete.getResult());
    }
    
}
