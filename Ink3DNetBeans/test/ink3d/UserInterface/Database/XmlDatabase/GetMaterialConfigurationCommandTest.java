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
        speed = new SpeedConfiguration();
        speed.setBridgeAcceleration(.02);
        speed.setBridgesSpeed(1.02);
        speed.setDefaultAcceleration(.1);
        speed.setExternalPerimetersSpeed(2.2);
        speed.setFirstLayerSpeed(1.3);
        speed.setGapFillSpeed(1.2);
        speed.setInfillAcceleration(.3);
        speed.setInfillSpeed(1.5);
        speed.setName("GetMaterialConfigurationTest.Speed");
        speed.setNonPrintMovesSpeed(2.2);
        speed.setPerimetersAcceleration(.5);
        speed.setPerimetersSpeed(3.4);
        speed.setSmallPerimetersSpeed(2.1);
        speed.setSolidInfillSpeed(1.3);
        speed.setSupportMaterialSpeed(3.4);
        speed.setTopSolidInfillSpeed(2.63);
        
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
        expected.setSpeedConfiguration(speed);
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
                    "    <speedConfiguration>\n" +
                    "        <bridgeAcceleration>0.02</bridgeAcceleration>\n" +
                    "        <bridgesSpeed>1.02</bridgesSpeed>\n" +
                    "        <defaultAcceleration>0.1</defaultAcceleration>\n" +
                    "        <externalPerimetersSpeed>2.2</externalPerimetersSpeed>\n" +
                    "        <firstLayerSpeed>1.3</firstLayerSpeed>\n" +
                    "        <gapFillSpeed>1.2</gapFillSpeed>\n" +
                    "        <infillAcceleration>0.3</infillAcceleration>\n" +
                    "        <infillSpeed>1.5</infillSpeed>\n" +
                    "        <name>GetMaterialConfigurationTest.Speed</name>\n" +
                    "        <nonPrintMovesSpeed>2.2</nonPrintMovesSpeed>\n" +
                    "        <perimetersAcceleration>0.5</perimetersAcceleration>\n" +
                    "        <perimetersSpeed>3.4</perimetersSpeed>\n" +
                    "        <smallPerimetersSpeed>2.1</smallPerimetersSpeed>\n" +
                    "        <solidInfillSpeed>1.3</solidInfillSpeed>\n" +
                    "        <supportMaterialSpeed>3.4</supportMaterialSpeed>\n" +
                    "        <topSolidInfillSpeed>2.63</topSolidInfillSpeed>\n" +
                    "    </speedConfiguration>\n" +
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
