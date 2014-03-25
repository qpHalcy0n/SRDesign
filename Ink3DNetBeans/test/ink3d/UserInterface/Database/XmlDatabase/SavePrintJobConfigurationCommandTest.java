/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.FileConfiguration;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.PrinterConfiguration;
import ink3d.ConfigurationObjects.SubsetConfiguration;
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
        file1.setMaterialConfiguration(material);
        file1.setName("SaveTest.file1");
        file1.setParentSTLFile(stlfile1);
        
        
        ArrayList<FileConfiguration> files = new ArrayList<FileConfiguration>();
        files.add(file1)
        
        SubsetConfiguration sub1= new SubsetConfiguration();
        sub1.setBottomZ(0);
        sub1.setFileConfigurations(files);
        
        subsetList = new ArrayList<SubsetConfiguration>();
        subsetList.add(subset1)
        
        printJob = new PrintJobConfiguration();
        printJob.setName("SaveTest");
        printJob.setPrinterConfiguration(printer);
        printJob.setSubsetConfigurationList(subsetList);
        
        expected ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<print>\n" +
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
                    "    <layerPerimiterConfiguration>\n" +
                    "        <firstLayerHeight>0.001</firstLayerHeight>\n" +
                    "        <generateExtraPerimetersWhenNeeded>true</generateExtraPerimetersWhenNeeded>\n" +
                    "        <layerHeight>5.0E-4</layerHeight>\n" +
                    "        <name>SaveTest.Layer</name>\n" +
                    "        <perimeters>2</perimeters>\n" +
                    "        <randomizedStartingPoints>true</randomizedStartingPoints>\n" +
                    "        <solidBottomLayers>2</solidBottomLayers>\n" +
                    "        <solidTopLayers>3</solidTopLayers>\n" +
                    "    </layerPerimiterConfiguration>\n" +
                    "    <name>SaveTest</name>\n" +
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
                    "</print>";
    }
    
    @After
    public void tearDown() {
        printJob = null;
        //File file = new File("./Database/PrintJobs/SaveTest.xml");
        //file.delete();
    }

    /**
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void SavePrintTest() throws IOException {
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
