/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class GetStlFilesCommandTest {
    ArrayList<String> actual;
    ArrayList<String> expected;
    File file1;
    File file2;
    File file3;
    File file4;
    File file5;
    
    public GetStlFilesCommandTest() {
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
            writer = new PrintWriter("./Database/Files/Trash.txt", "UTF-8");
            writer.println("Text");
            writer.close();
            
            writer = new PrintWriter("./Database/Files/GetStlFilesTest1.stl", "UTF-8");
            writer.println("Text");
            writer.close();
            
            writer = new PrintWriter("./Database/Files/GetStlFilesTest2.stl", "UTF-8");
            writer.println("Text");
            writer.close();
            
            writer = new PrintWriter("./Database/Files/GetStlFilesTest3.stl", "UTF-8");
            writer.println("Text");
            writer.close();
            
            writer = new PrintWriter("./Database/Files/GetStlFilesTest4.stl", "UTF-8");
            writer.println("Text");
            writer.close();
            
            writer = null;
        } catch (Exception ex) {
            Logger.getLogger(GetStlFilesCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        expected = new ArrayList<>();
        expected.add("GetStlFilesTest1");
        expected.add("GetStlFilesTest2");
        expected.add("GetStlFilesTest3");
        expected.add("GetStlFilesTest4");
        
        
    }
    
    @After
    public void tearDown() {
        System.gc();
        file1 = new File("./Database/Files/GetStlFilesTest1.stl");
        file2 = new File("./Database/Files/GetStlFilesTest2.stl");
        file3 = new File("./Database/Files/GetStlFilesTest3.stl");
        file4 = new File("./Database/Files/GetStlFilesTest4.stl");
        file5 = new File("./Database/Files/Trash.txt");
        file1.delete();
        file2.delete();
        file3.delete();
        file4.delete();
        file5.delete();
        }

    /**
     * Test of execute method, of class GetStlFilesCommand.
     */
    @Test
    public void testExecute() {
        GetStlFilesCommand instance = new GetStlFilesCommand();
        instance.execute();
        actual = (ArrayList<String>)instance.getResult();
        if(!expected.equals(actual)) System.out.printf("Test "+this.getClass().getName()+" \nexpected: "+ expected+"\nGot:      "+actual);
        assertTrue(expected.equals(actual));
    }
    
}
