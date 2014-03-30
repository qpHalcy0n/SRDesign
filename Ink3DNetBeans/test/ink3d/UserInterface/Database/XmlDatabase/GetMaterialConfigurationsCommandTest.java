/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.MaterialConfiguration;
import ink3d.ConfigurationObjects.SpeedConfiguration;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class GetMaterialConfigurationsCommandTest {
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
            writer = new PrintWriter("./Database/Materials/Trash.txt", "UTF-8");
            writer.println("Text");
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetMaterialConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SaveMaterialConfigurationCommand save;
        
        MaterialConfiguration material = new MaterialConfiguration();
        material.setName("GetMaterialTest1");
        material.setBridgeFanSpeedPercent(1);
        material.setDisableFanForFirstNLayers(2);
        material.setEnableAutoCooling(true);
        material.setEnableFanTimeThreshold(3);
        material.setExtraLengthAfterRetraction(1.4);
        material.setExtraLengthOnToolReenable(1.5);
        material.setExtrusionMultiplier(1.6);
        material.setExtrusionTemperature(124);
        material.setFanAlwaysOn(false);
        material.setFilamentDiameter(.98);
        material.setFirstLayerExtrusionTemperature(129);
        material.setMaxFanSpeed(6);
        material.setMinFanSpeed(0);
        material.setMinPrintSpeed(9);
        material.setMinimumTravelAfterRetraction(.01);
        material.setRetractOnLayerChange(true);
        material.setRetractionLength(.02);
        material.setRetractionLength(.04);
        material.setRetractionLengthBeforeToolChange(.13);
        material.setRetractionLiftZ(.2);
        material.setRetractionSpeed(12);
        material.setSlowDownTimeTreshold(13);
        material.setWipeBeforeRetract(true);
        
        save = new SaveMaterialConfigurationCommand(material);
        save.execute();
        
        material.setName("GetMaterialTest2");
        save = new SaveMaterialConfigurationCommand(material);
        save.execute();
        
        material.setName("GetMaterialTest3");
        save = new SaveMaterialConfigurationCommand(material);
        save.execute();
        
        material.setName("GetMaterialTest4");
        save = new SaveMaterialConfigurationCommand(material);
        save.execute();
        
          
        
        expected = new ArrayList<>();
        expected.add("GetMaterialTest1");
        expected.add("GetMaterialTest2");
        expected.add("GetMaterialTest3");
        expected.add("GetMaterialTest4");
    }
    
    @After
    public void tearDown() {
        file1 = new File("./Database/Materials/GetMaterialTest1.xml");
        file2 = new File("./Database/Materials/GetMaterialTest2.xml");
        file3 = new File("./Database/Materials/GetMaterialTest3.xml");
        file4 = new File("./Database/Materials/GetMaterialTest4.xml");
        file5 = new File("./Database/Materials/Trash.txt");
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
    public void GetMaterialConfigurationsTest() throws IOException {
        GetMaterialConfigurationsCommand instance = new GetMaterialConfigurationsCommand();
        instance.execute();
        actual = (ArrayList<String>)instance.getResult();
        
        for(int i = 0; i < actual.size(); i++){
            assertTrue(expected.equals(actual));
        }
    }
    
}