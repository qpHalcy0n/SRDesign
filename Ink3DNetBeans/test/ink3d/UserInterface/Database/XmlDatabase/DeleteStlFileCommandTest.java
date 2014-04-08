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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dan
 */
public class DeleteStlFileCommandTest {
    private File file;
    private String name = "./Database/Files/DeleteTest.xml";
    
    public DeleteStlFileCommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class DeleteStlFileCommand.
     */
    @Test
    public void testDeleteStlFileValidFile() {
        file = new File(name);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            fail("Could not create File to delete");
            Logger.getLogger(DeleteStlFileCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        DeleteStlFileCommand delete = new DeleteStlFileCommand("DeleteTest");
        delete.execute();
        assertTrue((Boolean)delete.getResult());
    }
    
    /**
     * Test of execute method, of class DeleteStlFileCommand.
     */
    @Test
    public void testDeleteStlFileInvalidFile() {
        DeleteStlFileCommand delete = new DeleteStlFileCommand("DeleteTest");
        delete.execute();
        assertFalse((Boolean)delete.getResult());
    }  
}
