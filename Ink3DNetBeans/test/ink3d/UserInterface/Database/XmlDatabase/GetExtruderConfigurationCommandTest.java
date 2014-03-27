/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import java.io.File;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author daniellain
 */
public class GetExtruderConfigurationCommandTest {
    ExtruderConfiguration expected;
    ExtruderConfiguration actual;
    String name = "GetExtruderConfigurationTest";
    String path = "./Database/Extruders/";
    
    @Before
    public void setup(){
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<extruder>\n" +
                    "    <extruderType>ABS</extruderType>\n" +
                    "    <headxOffset>0.0</headxOffset>\n" +
                    "    <headyOffset>0.0</headyOffset>\n" +
                    "    <headzOffset>0.0</headzOffset>\n" +
                    "    <name>GetExtruderConfigurationTest</name>\n" +
                    "    <nozzleDiameter>2.0</nozzleDiameter>\n" +
                    "    <xOffset>0.0</xOffset>\n" +
                    "    <yOffset>0.0</yOffset>\n" +
                    "    <zOffset>0.0</zOffset>\n" +
                    "</extruder>";
        
        expected = new ExtruderConfiguration();
        expected.setName(name);
        expected.setExtruderType("ABS");
        expected.setNozzleDiameter(2);
        expected.setxOffset(0);
        expected.setyOffset(0);
        expected.setzOffset(0);
        expected.setHeadxOffset(0);
        expected.setHeadyOffset(0);
        expected.setHeadzOffset(0);
        
        
        PrintWriter writer;
        try {
            writer = new PrintWriter(path+name+".xml", "UTF-8");
            writer.println(xml);
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetExtruderConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        File file = new File(path+name+".xml");
        file.delete();
    }
    
    @Test
    public void GetExtruderConfigurationTest() {
        GetExtruderConfigurationCommand instance = new GetExtruderConfigurationCommand(name);
        instance.execute();
        actual = (ExtruderConfiguration)instance.getResult();
        assertTrue(expected.equals(actual));
    }
    
}
