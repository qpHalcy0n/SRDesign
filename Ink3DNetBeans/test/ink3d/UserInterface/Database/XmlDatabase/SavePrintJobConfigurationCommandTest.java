/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.FileConfiguration;
import ink3d.ConfigurationObjects.InfillConfiguration;
import ink3d.ConfigurationObjects.LayerAndPerimeterConfiguration;
import ink3d.ConfigurationObjects.MaterialConfiguration;
import ink3d.ConfigurationObjects.PrintConfiguration;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.PrinterConfiguration;
import ink3d.ConfigurationObjects.SkirtAndBrimConfiguration;
import ink3d.ConfigurationObjects.SpeedConfiguration;
import ink3d.ConfigurationObjects.SubsetConfiguration;
import ink3d.ConfigurationObjects.SupportMaterialConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author daniellain
 */
public class SavePrintJobConfigurationCommandTest {
    PrintJobConfiguration printJob;
    PrinterConfiguration printer;
    ArrayList<SubsetConfiguration> subsetList;
    String expected;

    @Before
    public void setUp() {
        
        printer = new PrinterConfiguration();
        printer.setName("SaveTest.Printer");
        printer.setBedX(100.5);
        printer.setBedY(150.5);
        printer.setNumExtruders(3);
        printer.setPrintCenterX(65.8);
        printer.setPrintCenterY(70.4);
        printer.setUseRelativeEDistances(true);
        printer.setVibrationLimit(1.1);
        printer.setgCodeFlavor("rep-rap");
        printer.setzOffset(1.5);
        
        SpeedConfiguration speed = new SpeedConfiguration();
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
        
        MaterialConfiguration material1 = new MaterialConfiguration();
        material1.setName("SaveTest");
        material1.setBridgeFanSpeedPercent(1);
        material1.setDisableFanForFirstNLayers(2);
        material1.setEnableAutoCooling(true);
        material1.setEnableFanTimeThreshold(3);
        material1.setExtraLengthAfterRetraction(1.4);
        material1.setExtraLengthOnToolReenable(1.5);
        material1.setExtrusionMultiplier(1.6);
        material1.setExtrusionTemperature(124);
        material1.setFanAlwaysOn(false);
        material1.setFilamentDiameter(.98);
        material1.setFirstLayerExtrusionTemperature(129);
        material1.setMaxFanSpeed(6);
        material1.setMinFanSpeed(0);
        material1.setMinPrintSpeed(9);
        material1.setMinimumTravelAfterRetraction(.01);
        material1.setRetractOnLayerChange(true);
        material1.setRetractionLength(.02);
        material1.setRetractionLength(.04);
        material1.setRetractionLengthBeforeToolChange(.13);
        material1.setRetractionLiftZ(.2);
        material1.setRetractionSpeed(12);
        material1.setSlowDownTimeTreshold(13);
        material1.setSpeedConfiguration(speed);
        material1.setWipeBeforeRetract(true);
        
        ExtruderConfiguration extruder = new ExtruderConfiguration();
        extruder.setName("SaveTest");
        extruder.setExtruderType("ABS");
        extruder.setNozzleDiameter(2);
        extruder.setxOffset(0);
        extruder.setyOffset(0);
        extruder.setzOffset(0);
             
        File stlfile1 = new File("./Database/Files/SaveTest1.stl");
        File stlfile2 = new File("./Database/Files/SaveTest2.stl");
        File stlfile3 = new File("./Database/Files/SaveTest3.stl");
        
        FileConfiguration file1 = new FileConfiguration();
        
        file1.setExtruderConfiguration(extruder);
        file1.setMaterialConfiguration(material1);
        file1.setName("SaveTest.file1");
        file1.setParentSTLFile(stlfile1);
        
        FileConfiguration file2 = new FileConfiguration();
        file2.setExtruderConfiguration(extruder);
        file2.setMaterialConfiguration(material1);
        file2.setName("SaveTest.file2");
        file2.setParentSTLFile(stlfile2);
        
        FileConfiguration file3 = new FileConfiguration();
        file3.setExtruderConfiguration(extruder);
        file3.setMaterialConfiguration(material1);
        file3.setName("SaveTest.file3");
        file3.setParentSTLFile(stlfile2);
        
        ArrayList<FileConfiguration> files = new ArrayList<>();
        files.add(file1);
        
        InfillConfiguration  infill = new InfillConfiguration();
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
        
        LayerAndPerimeterConfiguration layer = new LayerAndPerimeterConfiguration();
        layer.setFirstLayerHeight(.001);
        layer.setGenerateExtraPerimetersWhenNeeded(true);
        layer.setLayerHeight(.0005);
        layer.setName("SaveTest.Layer");
        layer.setPerimeters(2);
        layer.setRandomizedStartingPoints(true);
        layer.setSolidBottomLayers(2);
        layer.setSolidTopLayers(3);
        
        SkirtAndBrimConfiguration skirt = new SkirtAndBrimConfiguration();
        skirt.setBrimWidth(1.1);
        skirt.setName("SaveTest.Skirt");
        skirt.setSkirtDistanceFromObject(1.2);
        skirt.setSkirtHeight(2);
        skirt.setSkirtLoops(3);
        skirt.setSkirtMinimumExtrusionLength(2.2);
        
        SupportMaterialConfiguration support = new SupportMaterialConfiguration();
        support.setEnforceSupportForFirstNLayers(1);
        support.setInterfaceLayers(2);
        support.setInterfacePatternSpacing(1.1);
        support.setName("SaveTest.Support");
        support.setOverhangThreshold(3);
        support.setRaftLayers(4);
        support.setSupportMaterialPattern("rectilinear");
        support.setSupportPatternAngle(10);
        support.setSupportPatternSpacing(2.3);
        
        PrintConfiguration print = new PrintConfiguration();
        print.setName("SaveTest");
        print.setInfillConfiguration(infill);
        print.setLayerPerimiterConfiguration(layer);
        print.setSkirtAndBrimConfiguration(skirt);
        print.setSpeedConfiguration(speed);
        print.setSupportMaterialConfiguration(support);
        
        SubsetConfiguration sub1= new SubsetConfiguration();
        sub1.setBottomZ(0);
        sub1.setFileConfigurations(files);
        sub1.setTopZ(1);
        sub1.setPrintConfiguration(print);
        
        SubsetConfiguration sub2= new SubsetConfiguration();
        sub1.setBottomZ(1);
        sub1.setFileConfigurations(files);
        sub1.setTopZ(2);
        sub1.setPrintConfiguration(print);
        
        subsetList = new ArrayList<>();
        subsetList.add(sub1);
        subsetList.add(sub2);
        
        printJob = new PrintJobConfiguration();
        printJob.setName("SaveTest");
        printJob.setPrinterConfiguration(printer);
        printJob.setSubsetConfigurationList(subsetList);
        
        expected ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<printjob>\n" +
                    "    <name>SaveTest</name>\n" +
                    "    <printerConfiguration>\n" +
                    "        <bedX>100.5</bedX>\n" +
                    "        <bedY>150.5</bedY>\n" +
                    "        <name>SaveTest.Printer</name>\n" +
                    "        <numExtruders>3</numExtruders>\n" +
                    "        <printCenterX>65.8</printCenterX>\n" +
                    "        <printCenterY>70.4</printCenterY>\n" +
                    "        <useRelativeEDistances>true</useRelativeEDistances>\n" +
                    "        <vibrationLimit>1.1</vibrationLimit>\n" +
                    "        <gCodeFlavor>rep-rap</gCodeFlavor>\n" +
                    "        <zOffset>1.5</zOffset>\n" +
                    "    </printerConfiguration>\n" +
                    "    <subsetConfigurationList>\n" +
                    "        <bottomZ>1.0</bottomZ>\n" +
                    "        <fileConfigurations>\n" +
                    "            <extruderConfiguration>\n" +
                    "                <extruderType>ABS</extruderType>\n" +
                    "                <headxOffset>0.0</headxOffset>\n" +
                    "                <headyOffset>0.0</headyOffset>\n" +
                    "                <headzOffset>0.0</headzOffset>\n" +
                    "                <name>SaveTest</name>\n" +
                    "                <nozzleDiameter>2.0</nozzleDiameter>\n" +
                    "                <xOffset>0.0</xOffset>\n" +
                    "                <yOffset>0.0</yOffset>\n" +
                    "                <zOffset>0.0</zOffset>\n" +
                    "            </extruderConfiguration>\n" +
                    "            <materialConfiguration>\n" +
                    "                <bridgeFanSpeedPercent>1</bridgeFanSpeedPercent>\n" +
                    "                <disableFanForFirstNLayers>2</disableFanForFirstNLayers>\n" +
                    "                <enableAutoCooling>true</enableAutoCooling>\n" +
                    "                <enableFanTimeThreshold>3</enableFanTimeThreshold>\n" +
                    "                <extraLengthAfterRetraction>1.4</extraLengthAfterRetraction>\n" +
                    "                <extraLengthOnToolReenable>1.5</extraLengthOnToolReenable>\n" +
                    "                <extrusionMultiplier>1.6</extrusionMultiplier>\n" +
                    "                <extrusionTemperature>124</extrusionTemperature>\n" +
                    "                <fanAlwaysOn>false</fanAlwaysOn>\n" +
                    "                <filamentDiameter>0.98</filamentDiameter>\n" +
                    "                <firstLayerExtrusionTemperature>129</firstLayerExtrusionTemperature>\n" +
                    "                <maxFanSpeed>6</maxFanSpeed>\n" +
                    "                <minFanSpeed>0</minFanSpeed>\n" +
                    "                <minPrintSpeed>9</minPrintSpeed>\n" +
                    "                <minimumTravelAfterRetraction>0.01</minimumTravelAfterRetraction>\n" +
                    "                <name>SaveTest</name>\n" +
                    "                <retractOnLayerChange>true</retractOnLayerChange>\n" +
                    "                <retractionLength>0.04</retractionLength>\n" +
                    "                <retractionLengthBeforeToolChange>0.13</retractionLengthBeforeToolChange>\n" +
                    "                <retractionLiftZ>0.2</retractionLiftZ>\n" +
                    "                <retractionSpeed>12</retractionSpeed>\n" +
                    "                <slowDownTimeTreshold>13</slowDownTimeTreshold>\n" +
                    "                <speedConfiguration>\n" +
                    "                    <bridgeAcceleration>0.02</bridgeAcceleration>\n" +
                    "                    <bridgesSpeed>1.02</bridgesSpeed>\n" +
                    "                    <defaultAcceleration>0.1</defaultAcceleration>\n" +
                    "                    <externalPerimetersSpeed>2.2</externalPerimetersSpeed>\n" +
                    "                    <firstLayerSpeed>1.3</firstLayerSpeed>\n" +
                    "                    <gapFillSpeed>1.2</gapFillSpeed>\n" +
                    "                    <infillAcceleration>0.3</infillAcceleration>\n" +
                    "                    <infillSpeed>1.5</infillSpeed>\n" +
                    "                    <name>SaveTest.Speed</name>\n" +
                    "                    <nonPrintMovesSpeed>2.2</nonPrintMovesSpeed>\n" +
                    "                    <perimetersAcceleration>0.5</perimetersAcceleration>\n" +
                    "                    <perimetersSpeed>3.4</perimetersSpeed>\n" +
                    "                    <smallPerimetersSpeed>2.1</smallPerimetersSpeed>\n" +
                    "                    <solidInfillSpeed>1.3</solidInfillSpeed>\n" +
                    "                    <supportMaterialSpeed>3.4</supportMaterialSpeed>\n" +
                    "                    <topSolidInfillSpeed>2.63</topSolidInfillSpeed>\n" +
                    "                </speedConfiguration>\n" +
                    "                <wipeBeforeRetract>true</wipeBeforeRetract>\n" +
                    "            </materialConfiguration>\n" +
                    "            <name>SaveTest.file1</name>\n" +
                    "            <parentSTLFile>./Database/Files/SaveTest1.stl</parentSTLFile>\n" +
                    "        </fileConfigurations>\n" +
                    "        <printConfiguration>\n" +
                    "            <infillConfiguration>\n" +
                    "                <infillAngle>12</infillAngle>\n" +
                    "                <infillBeforePerimeters>true</infillBeforePerimeters>\n" +
                    "                <infillDensity>0.4</infillDensity>\n" +
                    "                <infillEveryNLayers>3</infillEveryNLayers>\n" +
                    "                <infillPattern>rectilinear</infillPattern>\n" +
                    "                <name>SaveTest.Infill</name>\n" +
                    "                <onlyInfillWhereNeeded>false</onlyInfillWhereNeeded>\n" +
                    "                <onlyRetractInfillWhenCrossingPerimeters>true</onlyRetractInfillWhenCrossingPerimeters>\n" +
                    "                <solidInfillEveryNLayers>4</solidInfillEveryNLayers>\n" +
                    "                <solidInfillThresholdArea>7</solidInfillThresholdArea>\n" +
                    "                <topBottomInfillPattern>circles</topBottomInfillPattern>\n" +
                    "            </infillConfiguration>\n" +
                    "            <layerPerimiterConfiguration>\n" +
                    "                <firstLayerHeight>0.001</firstLayerHeight>\n" +
                    "                <generateExtraPerimetersWhenNeeded>true</generateExtraPerimetersWhenNeeded>\n" +
                    "                <layerHeight>5.0E-4</layerHeight>\n" +
                    "                <name>SaveTest.Layer</name>\n" +
                    "                <perimeters>2</perimeters>\n" +
                    "                <randomizedStartingPoints>true</randomizedStartingPoints>\n" +
                    "                <solidBottomLayers>2</solidBottomLayers>\n" +
                    "                <solidTopLayers>3</solidTopLayers>\n" +
                    "            </layerPerimiterConfiguration>\n" +
                    "            <name>SaveTest</name>\n" +
                    "            <skirtAndBrimConfiguration>\n" +
                    "                <brimWidth>1.1</brimWidth>\n" +
                    "                <name>SaveTest.Skirt</name>\n" +
                    "                <skirtDistanceFromObject>1.2</skirtDistanceFromObject>\n" +
                    "                <skirtHeight>2</skirtHeight>\n" +
                    "                <skirtLoops>3</skirtLoops>\n" +
                    "                <skirtMinimumExtrusionLength>2.2</skirtMinimumExtrusionLength>\n" +
                    "            </skirtAndBrimConfiguration>\n" +
                    "            <speedConfiguration>\n" +
                    "                <bridgeAcceleration>0.02</bridgeAcceleration>\n" +
                    "                <bridgesSpeed>1.02</bridgesSpeed>\n" +
                    "                <defaultAcceleration>0.1</defaultAcceleration>\n" +
                    "                <externalPerimetersSpeed>2.2</externalPerimetersSpeed>\n" +
                    "                <firstLayerSpeed>1.3</firstLayerSpeed>\n" +
                    "                <gapFillSpeed>1.2</gapFillSpeed>\n" +
                    "                <infillAcceleration>0.3</infillAcceleration>\n" +
                    "                <infillSpeed>1.5</infillSpeed>\n" +
                    "                <name>SaveTest.Speed</name>\n" +
                    "                <nonPrintMovesSpeed>2.2</nonPrintMovesSpeed>\n" +
                    "                <perimetersAcceleration>0.5</perimetersAcceleration>\n" +
                    "                <perimetersSpeed>3.4</perimetersSpeed>\n" +
                    "                <smallPerimetersSpeed>2.1</smallPerimetersSpeed>\n" +
                    "                <solidInfillSpeed>1.3</solidInfillSpeed>\n" +
                    "                <supportMaterialSpeed>3.4</supportMaterialSpeed>\n" +
                    "                <topSolidInfillSpeed>2.63</topSolidInfillSpeed>\n" +
                    "            </speedConfiguration>\n" +
                    "            <supportMaterialConfiguration>\n" +
                    "                <enforceSupportForFirstNLayers>1</enforceSupportForFirstNLayers>\n" +
                    "                <generateSupportMaterial>false</generateSupportMaterial>\n" +
                    "                <interfaceLayers>2</interfaceLayers>\n" +
                    "                <interfacePatternSpacing>1.1</interfacePatternSpacing>\n" +
                    "                <name>SaveTest.Support</name>\n" +
                    "                <overhangThreshold>3</overhangThreshold>\n" +
                    "                <raftLayers>4</raftLayers>\n" +
                    "                <supportMaterialPattern>rectilinear</supportMaterialPattern>\n" +
                    "                <supportPatternAngle>10</supportPatternAngle>\n" +
                    "                <supportPatternSpacing>2.3</supportPatternSpacing>\n" +
                    "            </supportMaterialConfiguration>\n" +
                    "        </printConfiguration>\n" +
                    "        <topZ>2.0</topZ>\n" +
                    "    </subsetConfigurationList>\n" +
                    "    <subsetConfigurationList>\n" +
                    "        <bottomZ>0.0</bottomZ>\n" +
                    "        <topZ>0.0</topZ>\n" +
                    "    </subsetConfigurationList>\n" +
                    "</printjob>";
    }
    
    @After
    public void tearDown() {
        printJob = null;
        File file = new File("./Database/PrintJobs/SaveTest.xml");
        //file.delete();
    }

    /**
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void SavePrintJobTest() throws IOException {
        String actual;

        String path = "./Database/PrintJobs/"+printJob.getName()+".xml";
        SavePrintJobConfigurationCommand instance = new SavePrintJobConfigurationCommand(printJob);
        instance.execute();
        assertTrue((Boolean)instance.getResult());
        actual = FileUtils.readFileToString(new File(path));
        
        for(int i=0; i < expected.length(); i++){
            assertTrue(expected.charAt(i) == actual.charAt(i));
        }
    }
    
}
