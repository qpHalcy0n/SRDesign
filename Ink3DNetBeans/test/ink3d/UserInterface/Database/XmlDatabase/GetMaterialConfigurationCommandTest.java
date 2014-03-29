/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.MaterialConfiguration;
import ink3d.ConfigurationObjects.SpeedConfiguration;
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
public class GetMaterialConfigurationCommandTest {  
    MaterialConfiguration expected;
    MaterialConfiguration actual;
    SpeedConfiguration speed;
    String name = "GetMaterialConfigurationTest";
    String path = "./Database/Materials/";
    
    @Before
    public void setup(){
        expected = new MaterialConfiguration();
        expected.setName("GetMaterialConfigurationTest");
        expected.setBridgeFanSpeedPercent(1);
        expected.setDisableFanForFirstNLayers(2);
        expected.setEnableAutoCooling(true);
        expected.setEnableFanTimeThreshold(3);
        expected.setExtraLengthAfterRetraction(1.4);
        expected.setExtraLengthOnToolReenable(1.5);
        expected.setExtrusionMultiplier(1.6);
        expected.setExtrusionTemperature(124);
        expected.setFanAlwaysOn(false);
        expected.setFilamentDiameter(.98);
        expected.setFirstLayerExtrusionTemperature(129);
        expected.setMaxFanSpeed(6);
        expected.setMinFanSpeed(0);
        expected.setMinPrintSpeed(9);
        expected.setMinimumTravelAfterRetraction(.01);
        expected.setRetractOnLayerChange(true);
        expected.setRetractionLength(.02);
        expected.setRetractionLength(.04);
        expected.setRetractionLengthBeforeToolChange(.13);
        expected.setRetractionLiftZ(.2);
        expected.setRetractionSpeed(12);
        expected.setSlowDownTimeTreshold(13);
        expected.setWipeBeforeRetract(true);
        
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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
                    "    <name>GetMaterialConfigurationTest</name>\n" +
                    "    <retractOnLayerChange>true</retractOnLayerChange>\n" +
                    "    <retractionLength>0.04</retractionLength>\n" +
                    "    <retractionLengthBeforeToolChange>0.13</retractionLengthBeforeToolChange>\n" +
                    "    <retractionLiftZ>0.2</retractionLiftZ>\n" +
                    "    <retractionSpeed>12</retractionSpeed>\n" +
                    "    <slowDownTimeTreshold>13</slowDownTimeTreshold>\n" +
                    "    <wipeBeforeRetract>true</wipeBeforeRetract>\n" +
                    "</material>";
        
        PrintWriter writer;
        try {
            writer = new PrintWriter(path+name+".xml", "UTF-8");
            writer.println(xml);
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetMaterialConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        File file = new File(path+name+".xml");
        file.delete();
    }
    
    @Test
    public void GetMaterialConfigurationTest() {
        GetMaterialConfigurationCommand instance = new GetMaterialConfigurationCommand(name);
        instance.execute();
        actual = (MaterialConfiguration)instance.getResult();
        assertTrue(expected.equals(actual));
    }
}
