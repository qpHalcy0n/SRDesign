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
import org.apache.commons.io.FileUtils;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author daniellain
 */
public class SaveMaterialConfigurationCommandTest {
    MaterialConfiguration material;
    SpeedConfiguration speed;
    String expected;

    @Before
    public void setUp() {
        material = new MaterialConfiguration();
        material.setName("SaveTest");
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
        material.setgCodeStart("haha");
        material.setgCodeEnd("lol");
        
        expected ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<material>\n" +
                    "    <bridgeFanSpeedPercent>1</bridgeFanSpeedPercent>\n" +
                    "    <disableFanForFirstNLayers>2</disableFanForFirstNLayers>\n" +
                    "    <enableAutoCooling>true</enableAutoCooling>\n" +
                    "    <enableFanTimeThreshold>3</enableFanTimeThreshold>\n" +
                    "    <extraLengthAfterRetraction>1.4</extraLengthAfterRetraction>\n" +
                    "    <extraLengthOnToolReenable>1.5</extraLengthOnToolReenable>\n" +
                    "    <extrusionMultiplier>1.6</extrusionMultiplier>\n" +
                    "    <extrusionTemperature>124</extrusionTemperature>\n" +
                    "    <fanAlwaysOn>false</fanAlwaysOn>\n" +
                    "    <filamentDiameter>0.98</filamentDiameter>\n" +
                    "    <firstLayerExtrusionTemperature>129</firstLayerExtrusionTemperature>\n" +
                    "    <maxFanSpeed>6</maxFanSpeed>\n" +
                    "    <minFanSpeed>0</minFanSpeed>\n" +
                    "    <minPrintSpeed>9</minPrintSpeed>\n" +
                    "    <minimumTravelAfterRetraction>0.01</minimumTravelAfterRetraction>\n" +
                    "    <name>SaveTest</name>\n" +
                    "    <retractOnLayerChange>true</retractOnLayerChange>\n" +
                    "    <retractionLength>0.04</retractionLength>\n" +
                    "    <retractionLengthBeforeToolChange>0.13</retractionLengthBeforeToolChange>\n" +
                    "    <retractionLiftZ>0.2</retractionLiftZ>\n" +
                    "    <retractionSpeed>12</retractionSpeed>\n" +
                    "    <slowDownTimeTreshold>13</slowDownTimeTreshold>\n" +
                    "    <wipeBeforeRetract>true</wipeBeforeRetract>\n" +
                    "    <gCodeEnd>lol</gCodeEnd>\n" +
                    "    <gCodeStart>haha</gCodeStart>\n" +
                    "</material>";
    }
    
    @After
    public void tearDown() {
        material = null;
        File file = new File("./Database/Materials/SaveTest.xml");
        System.gc();
        file.delete();
    }

    /**
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void SaveMaterialTest() throws IOException {
        String actual;

        String path = "./Database/Materials/"+material.getName()+".xml";
        SaveMaterialConfigurationCommand instance = new SaveMaterialConfigurationCommand(material);
        instance.execute();
        assertTrue((Boolean)instance.getResult());
        actual = FileUtils.readFileToString(new File(path));
        
        actual = actual.substring(0, actual.length()-1);
        if(!expected.equals(actual)) System.out.printf("Test "+this.getClass().getName()+" expected: "+ expected+"\nGot: "+actual);
        assertTrue(expected.equals(actual));
    }
    
}
