/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author daniellain
 */
public class GetExtruderConfigurationsCommandTest {
    ArrayList<String> actual;
    ArrayList<String> expected;
    File file1;
    File file2;
    File file3;
    File file4;
    File file5;

    @Before
    public void setUp() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("./Database/Extruders/Trash.txt", "UTF-8");
            writer.println("Text");
            writer.close();
            writer = null;
        } catch (Exception ex) {
            Logger.getLogger(GetExtruderConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SaveExtruderConfigurationCommand save;
        
        ExtruderConfiguration extruder = new ExtruderConfiguration();
        extruder.setName("GetTest1");
        extruder.setExtruderType("ABS");
        extruder.setNozzleDiameter(2);
        extruder.setxOffset(0);
        extruder.setyOffset(0);
        extruder.setzOffset(0);
        save = new SaveExtruderConfigurationCommand(extruder);
        save.execute();
        
        extruder.setName("GetTest2");
        save = new SaveExtruderConfigurationCommand(extruder);
        save.execute();
        
        extruder.setName("GetTest3");
        save = new SaveExtruderConfigurationCommand(extruder);
        save.execute();
        
        extruder.setName("GetTest4");
        save = new SaveExtruderConfigurationCommand(extruder);
        save.execute();
        
        expected = new ArrayList<>();
        expected.add("GetTest1");
        expected.add("GetTest2");
        expected.add("GetTest3");
        expected.add("GetTest4");
    }
    
    @After
    public void tearDown() {
        file1 = new File("./Database/Extruders/GetTest1.xml");
        file2 = new File("./Database/Extruders/GetTest2.xml");
        file3 = new File("./Database/Extruders/GetTest3.xml");
        file4 = new File("./Database/Extruders/GetTest4.xml"); 
        file5 = new File("./Database/Extruders/Trash.txt");
        System.gc();
        file1.delete();
        file2.delete();
        file3.delete();
        file4.delete();
        file5.delete();
        }

    /**
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void GetExtruderConfigurationsTest() throws IOException {
        GetExtruderConfigurationsCommand instance = new GetExtruderConfigurationsCommand();
        instance.execute();
        actual = (ArrayList<String>)instance.getResult();

        if(!expected.equals(actual)) System.out.printf("Test "+this.getClass().getName()+"\nExpected: "+ expected+"\nGot:      "+actual);
        assertTrue(expected.equals(actual));
    }
    
}
