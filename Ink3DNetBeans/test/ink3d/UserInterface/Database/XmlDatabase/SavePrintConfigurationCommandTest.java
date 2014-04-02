/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.InfillConfiguration;
import ink3d.ConfigurationObjects.LayerAndPerimeterConfiguration;
import ink3d.ConfigurationObjects.PrintConfiguration;
import ink3d.ConfigurationObjects.SkirtAndBrimConfiguration;
import ink3d.ConfigurationObjects.SpeedConfiguration;
import ink3d.ConfigurationObjects.SupportMaterialConfiguration;
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
public class SavePrintConfigurationCommandTest {
    PrintConfiguration print;
    InfillConfiguration infill;
    LayerAndPerimeterConfiguration layer;
    SkirtAndBrimConfiguration skirt;
    SpeedConfiguration speed;
    SupportMaterialConfiguration support;
    String expected;

    @Before
    public void setUp() {
        speed = new SpeedConfiguration();
        speed.setBridgeAcceleration(.02);
        speed.setBridgesSpeed(1.02);
        speed.setDefaultAcceleration(.1);
        speed.setExternalPerimetersSpeed(2.2);
        speed.setFirstLayerSpeed(1.3);
        speed.setGapFillSpeed(1.2);
        speed.setInfillAcceleration(.3);
        speed.setInfillSpeed(1.5);
        speed.setName("SaveTest.Speed");
        speed.setNonPrintMovesSpeed(2.2);
        speed.setPerimetersAcceleration(.5);
        speed.setPerimetersSpeed(3.4);
        speed.setSmallPerimetersSpeed(2.1);
        speed.setSolidInfillSpeed(1.3);
        speed.setSupportMaterialSpeed(3.4);
        speed.setTopSolidInfillSpeed(2.63);
        
        infill = new InfillConfiguration();
        infill.setInfillAngle(12);
        infill.setInfillBeforePerimeters(true);
        infill.setInfillDensity(.4);
        infill.setInfillEveryNLayers(3);
        infill.setInfillPattern("rectilinear");
        infill.setName("SaveTest.Infill");
        infill.setOnlyInfillWhereNeeded(false);
        infill.setOnlyRetractInfillWhenCrossingPerimeters(true);
        infill.setSolidInfillEveryNLayers(4);
        infill.setSolidInfillThresholdArea(7);
        infill.setTopBottomInfillPattern("circles");
        
        layer = new LayerAndPerimeterConfiguration();
        layer.setFirstLayerHeight(.001);
        layer.setGenerateExtraPerimetersWhenNeeded(true);
        layer.setLayerHeight(.0005);
        layer.setName("SaveTest.Layer");
        layer.setPerimeters(2);
        layer.setRandomizedStartingPoints(true);
        layer.setSolidBottomLayers(2);
        layer.setSolidTopLayers(3);
        
        skirt = new SkirtAndBrimConfiguration();
        skirt.setBrimWidth(1.1);
        skirt.setName("SaveTest.Skirt");
        skirt.setSkirtDistanceFromObject(1.2);
        skirt.setSkirtHeight(2);
        skirt.setSkirtLoops(3);
        skirt.setSkirtMinimumExtrusionLength(2.2);
        
        support = new SupportMaterialConfiguration();
        support.setEnforceSupportForFirstNLayers(1);
        support.setInterfaceLayers(2);
        support.setInterfacePatternSpacing(1.1);
        support.setName("SaveTest.Support");
        support.setOverhangThreshold(3);
        support.setRaftLayers(4);
        support.setSupportMaterialPattern("rectilinear");
        support.setSupportPatternAngle(10);
        support.setSupportPatternSpacing(2.3);
        
        print = new PrintConfiguration();
        print.setName("SaveTest");
        print.setInfillConfiguration(infill);
        print.setLayerPerimiterConfiguration(layer);
        print.setSkirtAndBrimConfiguration(skirt);
        print.setSpeedConfiguration(speed);
        print.setSupportMaterialConfiguration(support);
        
        expected ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<print>\n" +
                    "    <bedTemperature>0</bedTemperature>\n" +
                    "    <bridgeFlowRatio>1.0</bridgeFlowRatio>\n" +
                    "    <coolingConfiguration>\n" +
                    "        <bridgeFanSpeedPercent>100</bridgeFanSpeedPercent>\n" +
                    "        <disableFanForFirstNLayers>1</disableFanForFirstNLayers>\n" +
                    "        <enableAutoCooling>true</enableAutoCooling>\n" +
                    "        <enableFanTimeThreshold>60</enableFanTimeThreshold>\n" +
                    "        <fanAlwaysOn>false</fanAlwaysOn>\n" +
                    "        <maxFanSpeed>100</maxFanSpeed>\n" +
                    "        <minFanSpeed>35</minFanSpeed>\n" +
                    "        <minPrintSpeed>10</minPrintSpeed>\n" +
                    "        <slowDownTimeTreshold>30</slowDownTimeTreshold>\n" +
                    "    </coolingConfiguration>\n" +
                    "    <extrusionWidthConfiguration>\n" +
                    "        <defaultExtrusionWidth>0.0</defaultExtrusionWidth>\n" +
                    "        <firstLayerExtrusionWidth>0.0</firstLayerExtrusionWidth>\n" +
                    "        <infillExtrusionWidth>0.0</infillExtrusionWidth>\n" +
                    "        <perimetersExtrusionWidth>0.0</perimetersExtrusionWidth>\n" +
                    "        <solidInfillExtrusionWidth>0.0</solidInfillExtrusionWidth>\n" +
                    "        <supportMaterialExtrusionWidth>0.0</supportMaterialExtrusionWidth>\n" +
                    "        <topSolidInfillExtrusionWidth>0.0</topSolidInfillExtrusionWidth>\n" +
                    "    </extrusionWidthConfiguration>\n" +
                    "    <firstLayerBedTemperature>0</firstLayerBedTemperature>\n" +
                    "    <infillConfiguration>\n" +
                    "        <infillAngle>12</infillAngle>\n" +
                    "        <infillBeforePerimeters>true</infillBeforePerimeters>\n" +
                    "        <infillDensity>0.4</infillDensity>\n" +
                    "        <infillEveryNLayers>3</infillEveryNLayers>\n" +
                    "        <infillPattern>rectilinear</infillPattern>\n" +
                    "        <name>SaveTest.Infill</name>\n" +
                    "        <onlyInfillWhereNeeded>false</onlyInfillWhereNeeded>\n" +
                    "        <onlyRetractInfillWhenCrossingPerimeters>true</onlyRetractInfillWhenCrossingPerimeters>\n" +
                    "        <solidInfillEveryNLayers>4</solidInfillEveryNLayers>\n" +
                    "        <solidInfillThresholdArea>7</solidInfillThresholdArea>\n" +
                    "        <topBottomInfillPattern>circles</topBottomInfillPattern>\n" +
                    "    </infillConfiguration>\n" +
                    "    <infillExtruder>0</infillExtruder>\n" +
                    "    <layerChangeGCode></layerChangeGCode>\n" +
                    "    <layerPerimiterConfiguration>\n" +
                    "        <avoidCrossingPerimeters>false</avoidCrossingPerimeters>\n" +
                    "        <detectBridgingPerimeters>true</detectBridgingPerimeters>\n" +
                    "        <detectThinWalls>true</detectThinWalls>\n" +
                    "        <externalPerimetersFirst>false</externalPerimetersFirst>\n" +
                    "        <firstLayerHeight>0.001</firstLayerHeight>\n" +
                    "        <generateExtraPerimetersWhenNeeded>true</generateExtraPerimetersWhenNeeded>\n" +
                    "        <layerHeight>5.0E-4</layerHeight>\n" +
                    "        <name>SaveTest.Layer</name>\n" +
                    "        <perimeters>2</perimeters>\n" +
                    "        <randomizedStartingPoints>true</randomizedStartingPoints>\n" +
                    "        <solidBottomLayers>2</solidBottomLayers>\n" +
                    "        <solidTopLayers>3</solidTopLayers>\n" +
                    "        <spiralVase>false</spiralVase>\n" +
                    "        <startPerimetersAtConcavePoints>false</startPerimetersAtConcavePoints>\n" +
                    "        <startPerimetersAtNonOverhangPoints>false</startPerimetersAtNonOverhangPoints>\n" +
                    "    </layerPerimiterConfiguration>\n" +
                    "    <name>SaveTest</name>\n" +
                    "    <perimeterExtruder>0</perimeterExtruder>\n" +
                    "    <skirtAndBrimConfiguration>\n" +
                    "        <brimWidth>1.1</brimWidth>\n" +
                    "        <name>SaveTest.Skirt</name>\n" +
                    "        <skirtDistanceFromObject>1.2</skirtDistanceFromObject>\n" +
                    "        <skirtHeight>2</skirtHeight>\n" +
                    "        <skirtLoops>3</skirtLoops>\n" +
                    "        <skirtMinimumExtrusionLength>2.2</skirtMinimumExtrusionLength>\n" +
                    "    </skirtAndBrimConfiguration>\n" +
                    "    <speedConfiguration>\n" +
                    "        <bridgeAcceleration>0.02</bridgeAcceleration>\n" +
                    "        <bridgesSpeed>1.02</bridgesSpeed>\n" +
                    "        <defaultAcceleration>0.1</defaultAcceleration>\n" +
                    "        <externalPerimetersSpeed>2.2</externalPerimetersSpeed>\n" +
                    "        <firstLayerAcceleration>0.0</firstLayerAcceleration>\n" +
                    "        <firstLayerSpeed>1.3</firstLayerSpeed>\n" +
                    "        <gapFillSpeed>1.2</gapFillSpeed>\n" +
                    "        <infillAcceleration>0.3</infillAcceleration>\n" +
                    "        <infillSpeed>1.5</infillSpeed>\n" +
                    "        <name>SaveTest.Speed</name>\n" +
                    "        <nonPrintMovesSpeed>2.2</nonPrintMovesSpeed>\n" +
                    "        <perimetersAcceleration>0.5</perimetersAcceleration>\n" +
                    "        <perimetersSpeed>3.4</perimetersSpeed>\n" +
                    "        <smallPerimetersSpeed>2.1</smallPerimetersSpeed>\n" +
                    "        <solidInfillSpeed>1.3</solidInfillSpeed>\n" +
                    "        <supportMaterialSpeed>3.4</supportMaterialSpeed>\n" +
                    "        <topSolidInfillSpeed>2.63</topSolidInfillSpeed>\n" +
                    "    </speedConfiguration>\n" +
                    "    <supportMaterialConfiguration>\n" +
                    "        <enforceSupportForFirstNLayers>1</enforceSupportForFirstNLayers>\n" +
                    "        <generateSupportMaterial>false</generateSupportMaterial>\n" +
                    "        <interfaceLayers>2</interfaceLayers>\n" +
                    "        <interfacePatternSpacing>1.1</interfacePatternSpacing>\n" +
                    "        <name>SaveTest.Support</name>\n" +
                    "        <overhangThreshold>3</overhangThreshold>\n" +
                    "        <raftLayers>4</raftLayers>\n" +
                    "        <supportMaterialPattern>rectilinear</supportMaterialPattern>\n" +
                    "        <supportPatternAngle>10</supportPatternAngle>\n" +
                    "        <supportPatternSpacing>2.3</supportPatternSpacing>\n" +
                    "    </supportMaterialConfiguration>\n" +
                    "    <supportMaterialExtruder>0</supportMaterialExtruder>\n" +
                    "    <supportMaterialInterfaceExtruder>0</supportMaterialInterfaceExtruder>\n" +
                    "</print>";
    }
    
    @After
    public void tearDown() {
        print = null;
        File file = new File("./Database/Prints/SaveTest.xml");
        file.delete();
    }

    /**
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void SavePrintTest() throws IOException {
        String actual;

        String path = "./Database/Prints/"+print.getName()+".xml";
        SavePrintConfigurationCommand instance = new SavePrintConfigurationCommand(print);
        instance.execute();
        assertTrue((Boolean)instance.getResult());
        actual = FileUtils.readFileToString(new File(path));
        
        actual = actual.substring(0, actual.length()-1);
        if(!expected.equals(actual)) System.out.printf("Test "+this.getClass().getName()+" expected: "+ expected+"\nGot: "+actual);
        assertTrue(expected.equals(actual));
    }
    
}
