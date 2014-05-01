/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Import;

import ink3d.UserInterface.Database.PersistenceFramework;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tim
 */
public class ImportControllerTest {
    
    private PersistenceFramework db;
    
    @Before
    public void setUp() {
        db = PersistenceFramework.getDB();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getStlFiles method, of class ImportController.
     */
    @Test
    public void testGetStlFiles() {
        System.out.println("getStlFiles");
        ImportController instance = new ImportController();
        ArrayList<String> expResult = db.getStlFiles();
        ArrayList<String> result = instance.getStlFiles();
        assertEquals(expResult, result);
    }

    /**
     * Test of importStl method, of class ImportController.
     */
    @Test
    public void testImportStl() {
        System.out.println("importStl");
        String Path = "test-files/import/cube.stl";
        ImportController instance = new ImportController();
        Boolean result = instance.importStl(Path);
        assertTrue(result);
        db.deleteStlFile("cube");
    }

    /**
     * Test of deleteStl method, of class ImportController.
     */
    @Test
    public void testDeleteStl() throws Exception {
        System.out.println("deleteStl");
        db.importStlFile("test-files/import/cube.stl");
        String name = "cube";
        ImportController instance = new ImportController();
        Boolean result = instance.deleteStl(name);
        assertTrue(result);
    }
    
}
