/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
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

    @Before
    public void setUp() {
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
        
          
        
        expected = new ArrayList<String>();
        expected.add("GetTest1");
        expected.add("GetTest2");
        expected.add("GetTest3");
        expected.add("GetTest4");
    }
    
    @After
    public void tearDown() {
        /*file1 = new File("./Database/Extruders/GetTest1.xml");
        file2 = new File("./Database/Extruders/GetTest2.xml");
        file3 = new File("./Database/Extruders/GetTest3.xml");
        file4 = new File("./Database/Extruders/GetTest4.xml"); 
        file1.delete();
        file2.delete();
        file3.delete();
        file4.delete();
    */
        }

    /**
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void SaveExtruderTest() throws IOException {
        GetExtruderConfigurationsCommand instance = new GetExtruderConfigurationsCommand();
        instance.execute();
        actual = (ArrayList<String>)instance.getResult();
        
        for(int i = 0; i < actual.size(); i++){
            assertTrue(expected.get(i).equals(actual.get(i)));
        }
    }
    
}
