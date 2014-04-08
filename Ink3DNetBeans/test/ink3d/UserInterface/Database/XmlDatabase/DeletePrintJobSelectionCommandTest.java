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
public class DeletePrintJobSelectionCommandTest {
    private File file;
    private String name = "./Database/PrintJobs/DeleteTest.xml";
 
    /**
     * Test of execute method, of class DeleteExtruderConfigurationCommand.
     */
    @Test
    public void DeletePrintJobValidFileTest() {
        file = new File(name);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            fail("Could not create File to delete");
            Logger.getLogger(DeletePrintJobSelectionCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        DeletePrintJobSelectionCommand delete = new DeletePrintJobSelectionCommand("DeleteTest");
        delete.execute();
        assertTrue((Boolean)delete.getResult());
    }
    @Test
    public void DeletePrintJobNoSuchFileTest(){
        DeletePrintJobSelectionCommand delete = new DeletePrintJobSelectionCommand("DeleteExceptionTest");
        delete.execute();
        assertFalse((Boolean)delete.getResult());
    }
    
}
