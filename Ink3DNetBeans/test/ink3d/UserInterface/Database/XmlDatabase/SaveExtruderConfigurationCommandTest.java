/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
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
    
    public SaveExtruderConfigurationCommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() { 
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        extruder = new ExtruderConfiguration();
        extruder.setName("Test");
        extruder.setExtruderType("ABS");
        extruder.setNozzleDiameter(2);
        extruder.setxOffset(0);
        extruder.setyOffset(0);
        extruder.setzOffset(0);
    }
    
    @After
    public void tearDown() {
        extruder = null;
    }

    /**
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void testExecute() {
        SaveExtruderConfigurationCommand instance = new SaveExtruderConfigurationCommand(extruder);
        instance.execute();
        assertTrue((Boolean)instance.getResult());
    }
    
}
