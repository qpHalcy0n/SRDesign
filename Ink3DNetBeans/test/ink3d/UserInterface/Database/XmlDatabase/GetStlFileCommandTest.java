/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import java.io.File;
import java.io.PrintWriter;
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
public class GetStlFileCommandTest {
    File file1;
    
    public GetStlFileCommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("./Database/Files/GetStlTest.stl", "UTF-8");
            writer.println("Text");
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetPrinterConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        File file1 = new File("./Database/Files/GetStlTest.stl");
        System.gc();
        file1.delete();
    }

    /**
     * Test of execute method, of class GetStlFileCommand.
     */
    @Test
    public void testGetStlFileCommand() {
        String name = "GetStlTest";
        GetStlFileCommand instance = new GetStlFileCommand(name);
        instance.execute();
        File expResult = new File("./Database/Files/GetStlTest.stl");
        assertEquals(expResult, ((File)instance.getResult()));
    }
}
