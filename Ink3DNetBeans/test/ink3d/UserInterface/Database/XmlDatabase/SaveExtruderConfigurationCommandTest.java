/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import java.io.File;
import java.io.IOException;
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
public class SaveExtruderConfigurationCommandTest {
    ExtruderConfiguration extruder;
    String expected;

    @Before
    public void setUp() {
        extruder = new ExtruderConfiguration();
        extruder.setName("SaveTest");
        extruder.setExtruderType("ABS");
        extruder.setNozzleDiameter(2);
        extruder.setxOffset(0);
        extruder.setyOffset(0);
        extruder.setzOffset(0);
        
        expected ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<extruder>\n" +
                    "    <endGCode></endGCode>\n" +
                    "    <extruderType>ABS</extruderType>\n" +
                    "    <name>SaveTest</name>\n" +
                    "    <nozzleDiameter>2.0</nozzleDiameter>\n" +
                    "    <startGCode></startGCode>\n" +
                    "    <xDimension>0.0</xDimension>\n" +
                    "    <xOffset>0.0</xOffset>\n" +
                    "    <yDimension>0.0</yDimension>\n" +
                    "    <yOffset>0.0</yOffset>\n" +
                    "    <zOffset>0.0</zOffset>\n" +
                    "</extruder>";
    }
    
    @After
    public void tearDown() {
        extruder = null;
        File file = new File("./Database/Extruders/SaveTest.xml");
        file.delete();
    }

    /**
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void SaveExtruderTest() throws IOException {
        String actual;

        String path = "./Database/Extruders/"+extruder.getName()+".xml";
        SaveExtruderConfigurationCommand instance = new SaveExtruderConfigurationCommand(extruder);
        instance.execute();
        assertTrue((Boolean)instance.getResult());
        actual = FileUtils.readFileToString(new File(path));
        
        for(int i=0; i < expected.length(); i++){
            assertTrue(expected.charAt(i) == actual.charAt(i));
        }
    }
    
}
