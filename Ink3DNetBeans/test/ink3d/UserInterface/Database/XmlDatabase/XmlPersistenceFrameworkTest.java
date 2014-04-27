/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.ExtruderMaterialConfiguration;
import ink3d.ConfigurationObjects.ExtruderMaterialSelection;
import ink3d.ConfigurationObjects.FileConfiguration;
import ink3d.ConfigurationObjects.FileSelection;
import ink3d.ConfigurationObjects.InfillConfiguration;
import ink3d.ConfigurationObjects.LayerAndPerimeterConfiguration;
import ink3d.ConfigurationObjects.MaterialConfiguration;
import ink3d.ConfigurationObjects.PrintConfiguration;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.PrintJobSelection;
import ink3d.ConfigurationObjects.PrinterConfiguration;
import ink3d.ConfigurationObjects.SkirtAndBrimConfiguration;
import ink3d.ConfigurationObjects.SpeedConfiguration;
import ink3d.ConfigurationObjects.SubsetConfiguration;
import ink3d.ConfigurationObjects.SubsetSelection;
import ink3d.ConfigurationObjects.SupportMaterialConfiguration;
import ink3d.UserInterface.Database.PersistenceFramework;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dan
 */
public class XmlPersistenceFrameworkTest {
    PersistenceFramework db = new XmlPersistenceFramework();
    ExtruderConfiguration extruder;
    MaterialConfiguration material;
    SpeedConfiguration speed2;
    PrintConfiguration print;
    InfillConfiguration infill;
    LayerAndPerimeterConfiguration layer;
    SkirtAndBrimConfiguration skirt;
    SpeedConfiguration speed;
    SupportMaterialConfiguration support;
    PrinterConfiguration printer;
    SubsetConfiguration subset;
    ArrayList<ExtruderMaterialConfiguration> extruderMaterials;
    ArrayList<SubsetConfiguration> subsets;
    ArrayList<FileConfiguration> files;
    ArrayList<ExtruderMaterialSelection> materialsSelections;
    ArrayList<FileSelection> fileSelections;
    ArrayList<SubsetSelection> subsetSelections;
    private File file;
    File file1;
    File file2;
    File file3;
    File file4;
    File file5;
    
    public void setupExtruder(){
        extruder = new ExtruderConfiguration();
        extruder.setName("GetPrintJobTest");
        extruder.setExtruderType("ABS");
        extruder.setNozzleDiameter(2);
        extruder.setxOffset(0);
        extruder.setyOffset(0);
        extruder.setzOffset(0);
        db.saveExtruderConfiguration(extruder);
    }
     
    private void setupMaterial(){
        speed2 = new SpeedConfiguration();
        speed2.setBridgeAcceleration(.02);
        speed2.setBridgesSpeed(1.02);
        speed2.setDefaultAcceleration(.1);
        speed2.setExternalPerimetersSpeed(2.2);
        speed2.setFirstLayerSpeed(30);
        speed2.setGapFillSpeed(1.2);
        speed2.setInfillAcceleration(.3);
        speed2.setInfillSpeed(1.5);
        speed2.setName("GetPrintJobTest.Speed");
        speed2.setNonPrintMovesSpeed(2.2);
        speed2.setPerimetersAcceleration(.5);
        speed2.setPerimetersSpeed(3.4);
        speed2.setSmallPerimetersSpeed(2.1);
        speed2.setSolidInfillSpeed(1.3);
        speed2.setSupportMaterialSpeed(3.4);
        speed2.setTopSolidInfillSpeed(2.63);
        
        material = new MaterialConfiguration();
        material.setName("GetPrintJobTest");
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
        
        db.saveMaterialConfiguration(material);
    }
    
    private void setupExtruderMaterial(){
        this.extruderMaterials = new ArrayList<>();
        this.extruderMaterials.add(new ExtruderMaterialConfiguration(extruder, material));
    }
    
    private void setupPrint(){
        speed = new SpeedConfiguration();
        speed.setBridgeAcceleration(.02);
        speed.setBridgesSpeed(1.02);
        speed.setDefaultAcceleration(.1);
        speed.setExternalPerimetersSpeed(2.2);
        speed.setFirstLayerSpeed(30);
        speed.setGapFillSpeed(1.2);
        speed.setInfillAcceleration(.3);
        speed.setInfillSpeed(1.5);
        speed.setName("GetPrintJobTest.Speed");
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
        infill.setName("GetPrintJobTest.Infill");
        infill.setOnlyInfillWhereNeeded(false);
        infill.setOnlyRetractInfillWhenCrossingPerimeters(true);
        infill.setSolidInfillEveryNLayers(4);
        infill.setSolidInfillThresholdArea(7);
        infill.setTopBottomInfillPattern("circles");
        
        layer = new LayerAndPerimeterConfiguration();
        layer.setFirstLayerHeight(.001);
        layer.setGenerateExtraPerimetersWhenNeeded(true);
        layer.setLayerHeight(.0005);
        layer.setName("GetPrintJobTest.Layer");
        layer.setPerimeters(2);
        layer.setRandomizedStartingPoints(true);
        layer.setSolidBottomLayers(2);
        layer.setSolidTopLayers(3);
        
        skirt = new SkirtAndBrimConfiguration();
        skirt.setBrimWidth(1.1);
        skirt.setName("GetPrintJobTest.Skirt");
        skirt.setSkirtDistanceFromObject(1.2);
        skirt.setSkirtHeight(2);
        skirt.setSkirtLoops(3);
        skirt.setSkirtMinimumExtrusionLength(2.2);
        
        support = new SupportMaterialConfiguration();
        support.setEnforceSupportForFirstNLayers(1);
        support.setInterfaceLayers(2);
        support.setInterfacePatternSpacing(1.1);
        support.setName("GetPrintJobTest.Support");
        support.setOverhangThreshold(3);
        support.setRaftLayers(4);
        support.setSupportMaterialPattern("rectilinear");
        support.setSupportPatternAngle(10);
        support.setSupportPatternSpacing(2.3);
        
        print = new PrintConfiguration();
        print.setName("GetPrintJobTest");
        print.setInfillConfiguration(infill);
        print.setLayerPerimiterConfiguration(layer);
        print.setSkirtAndBrimConfiguration(skirt);
        print.setSpeedConfiguration(speed);
        print.setSupportMaterialConfiguration(support);
        
        db.savePrintConfiguration(print);
    }
    
    private void setupFiles(){
        files = new ArrayList<>();
        FileConfiguration file = new FileConfiguration();
        
        file.setExtruderConfiguration(extruder);
        file.setMaterialConfiguration(material);
        file.setParentSTLFile(db.getStlFile("GetPrintJobTest"));
        file.setName("GetPrintJobTest");
        
        files.add(file);
    }
    
    private void setupPrinter(){
        printer = new PrinterConfiguration();
        printer.setName("GetPrintJobTest");
        printer.setBedX(150);
        printer.setBedY(100);
        printer.setNumExtruders(5);
        printer.setPrintCenterX(75);
        printer.setPrintCenterY(50);
        printer.setUseRelativeEDistances(true);
        printer.setVibrationLimit(1.1);
        printer.setgCodeFlavor("rep-rap");
        printer.setzOffset(1.34);
        printer.setExtruderList(new ArrayList<ExtruderConfiguration>());
        printer.getExtruderList().add(extruder);        
        
        db.savePrinterConfiguration(printer);
    }
    
    public void delete(){
        System.gc();
        db.deleteExtruderConfiguration(extruder.getName());
        db.deleteMaterialConfiguration(material.getName());
        db.deletePrintConfiguration(print.getName());
        db.deletePrinterConfiguration(printer.getName());
    }
    
    public void setupMaterialsSelection(){
        this.materialsSelections = new ArrayList<>();
        this.materialsSelections.add(new ExtruderMaterialSelection(extruder.getName(), material.getName()));
    }
    
    public void setupFileSelection(){
        fileSelections = new ArrayList<>();
        fileSelections.add(new FileSelection("01-"+extruder.getName(), material.getName(), files.get(0).getName()));
    }
        
    private void setupSubsets(){
        subset = new SubsetConfiguration();
        subset.setBottomZ(0);
        subset.setTopZ(1.1);
        subset.setPrintConfiguration(print);
        subset.setFileConfigurations(files);
        
        subsets = new ArrayList<>();
        subsets.add(subset);
    }
    
    public void setupSubsetSelection(){
        this.subsetSelections = new ArrayList<>();
        this.setupFileSelection();
        
        SubsetSelection subsetSel = new SubsetSelection();
        subsetSel.setBottomZ(0);
        subsetSel.setTopZ(1.1);
        subsetSel.setPrintConfiguration(print.getName());
        subsetSel.setFileConfigurations(fileSelections);
        
        this.subsetSelections.add(subsetSel);
    }

    /**
     * Test of getPrinterConfigurations method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetPrinterConfigurations() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("./Database/Printers/Trash.txt", "UTF-8");
            writer.println("Text");
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetPrinterConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SavePrinterConfigurationCommand save;
        
        PrinterConfiguration printer = new PrinterConfiguration();
        printer.setName("GetPrintersTest1");
        printer.setBedX(150);
        printer.setBedY(100);
        printer.setNumExtruders(5);
        printer.setPrintCenterX(75);
        printer.setPrintCenterY(50);
        printer.setUseRelativeEDistances(true);
        printer.setVibrationLimit(1.1);
        printer.setgCodeFlavor("rep-rap");
        printer.setzOffset(1.34);
        save = new SavePrinterConfigurationCommand(printer);
        save.execute();
        
        printer.setName("GetPrintersTest2");
        save = new SavePrinterConfigurationCommand(printer);
        save.execute();
        
        printer.setName("GetPrintersTest3");
        save = new SavePrinterConfigurationCommand(printer);
        save.execute();
        
        printer.setName("GetPrintersTest4");
        save = new SavePrinterConfigurationCommand(printer);
        save.execute();
        
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("GetPrintersTest1");
        expResult.add("GetPrintersTest2");
        expResult.add("GetPrintersTest3");
        expResult.add("GetPrintersTest4");
        
        System.out.println("getPrinterConfigurations");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        ArrayList<String> result = instance.getPrinterConfigurations();
        assertEquals(expResult, result);
        
        file1 = new File("./Database/Printers/GetPrintersTest1.xml");
        file2 = new File("./Database/Printers/GetPrintersTest2.xml");
        file3 = new File("./Database/Printers/GetPrintersTest3.xml");
        file4 = new File("./Database/Printers/GetPrintersTest4.xml"); 
        file5 = new File("./Database/Printers/Trash.txt");
        System.gc();
        file1.delete();
        file2.delete();
        file3.delete();
        file4.delete();
        file5.delete();
    }

    /**
     * Test of getExtruderConfigurations method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetExtruderConfigurations() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("./Database/Extruders/Trash.txt", "UTF-8");
            writer.println("Text");
            writer.close();
            writer = null;
        } catch (Exception ex) {
            Logger.getLogger(GetExtruderConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SaveExtruderConfigurationCommand save;
        
        ExtruderConfiguration extruder = new ExtruderConfiguration();
        extruder.setName("GetTest1");
        extruder.setExtruderType("ABS");
        extruder.setNozzleDiameter(2);
        extruder.setxOffset(0);
        extruder.setyOffset(0);
        extruder.setzOffset(0);
        save = new SaveExtruderConfigurationCommand(extruder);
        save.execute();
        
        extruder.setName("GetTest2");
        save = new SaveExtruderConfigurationCommand(extruder);
        save.execute();
        
        extruder.setName("GetTest3");
        save = new SaveExtruderConfigurationCommand(extruder);
        save.execute();
        
        extruder.setName("GetTest4");
        save = new SaveExtruderConfigurationCommand(extruder);
        save.execute();
        
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("GetTest1");
        expResult.add("GetTest2");
        expResult.add("GetTest3");
        expResult.add("GetTest4");
        
        System.out.println("getExtruderConfigurations");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        ArrayList<String> result = instance.getExtruderConfigurations();
        assertEquals(expResult, result);
        
        file1 = new File("./Database/Extruders/GetTest1.xml");
        file2 = new File("./Database/Extruders/GetTest2.xml");
        file3 = new File("./Database/Extruders/GetTest3.xml");
        file4 = new File("./Database/Extruders/GetTest4.xml"); 
        file5 = new File("./Database/Extruders/Trash.txt");
        System.gc();
        file1.delete();
        file2.delete();
        file3.delete();
        file4.delete();
        file5.delete();
    }

    /**
     * Test of getMaterialConfigurations method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetMaterialConfigurations() {
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
        
          
        
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("GetMaterialTest1");
        expResult.add("GetMaterialTest2");
        expResult.add("GetMaterialTest3");
        expResult.add("GetMaterialTest4");
        
        System.out.println("getMaterialConfigurations");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        ArrayList<String> result = instance.getMaterialConfigurations();
        assertEquals(expResult, result);
        
        file1 = new File("./Database/Materials/GetMaterialTest1.xml");
        file2 = new File("./Database/Materials/GetMaterialTest2.xml");
        file3 = new File("./Database/Materials/GetMaterialTest3.xml");
        file4 = new File("./Database/Materials/GetMaterialTest4.xml");
        file5 = new File("./Database/Materials/Trash.txt");
        System.gc();
        file1.delete();
        file2.delete();
        file3.delete();
        file4.delete();
        file5.delete();
    }

    /**
     * Test of getPrintJobSelectionss method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetPrintJobSelections() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("./Database/PrintJobs/Trash.txt", "UTF-8");
            writer.println("Text");
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetPrintJobSelectionsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        SubsetSelection subset1 = new SubsetSelection();
        subset1.setBottomZ(0);
        subset1.setPrintConfiguration("SaveTest.Sub1.Print");
        subset1.setTopZ(1);
        subset1.getFileConfigurations().add(new FileSelection("extruder1", "material1", "file1"));
        subset1.getFileConfigurations().add(new FileSelection("extruder2", "material2", "file2"));
        subset1.getFileConfigurations().add(new FileSelection("extruder3", "material3", "file3"));
        
        SubsetSelection subset2 = new SubsetSelection();
        subset2.setBottomZ(1);
        subset2.setPrintConfiguration("SaveTest.Sub2.Print");
        subset2.setTopZ(2);
        subset2.getFileConfigurations().add(new FileSelection("extruder2", "material2", "file1"));
        subset2.getFileConfigurations().add(new FileSelection("extruder3", "material3", "file2"));
        subset2.getFileConfigurations().add(new FileSelection("extruder1", "material1", "file3"));
        
        PrintJobSelection printJob = new PrintJobSelection();
        printJob.setName("GetPrintJobsTest1");
        printJob.setPrinterConfiguration("SaveTest.printer");
        printJob.getMaterials().add(new ExtruderMaterialSelection("extruder 1", "material 1"));
        printJob.getMaterials().add(new ExtruderMaterialSelection("extruder 2", "material 1"));
        printJob.getMaterials().add(new ExtruderMaterialSelection("extruder 3", "material 2"));
        printJob.getSubsetConfigurationList().add(subset1);
        printJob.getSubsetConfigurationList().add(subset2);
        
        SavePrintJobSelectionCommand save = new SavePrintJobSelectionCommand(printJob);
        save.execute();
        
        printJob.setName("GetPrintJobsTest2");
        save = new SavePrintJobSelectionCommand(printJob);
        save.execute();
        
        printJob.setName("GetPrintJobsTest3");
        save = new SavePrintJobSelectionCommand(printJob);
        save.execute();
        
        printJob.setName("GetPrintJobsTest4");
        save = new SavePrintJobSelectionCommand(printJob);
        save.execute();
        
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("GetPrintJobsTest1");
        expResult.add("GetPrintJobsTest2");
        expResult.add("GetPrintJobsTest3");
        expResult.add("GetPrintJobsTest4");
        
        System.out.println("getPrintJobSelectionss");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        ArrayList<String> result = instance.getPrintJobSelectionss();
        assertEquals(expResult, result);
        
        file1 = new File("./Database/PrintJobs/GetPrintJobsTest1.xml");
        file2 = new File("./Database/PrintJobs/GetPrintJobsTest2.xml");
        file3 = new File("./Database/PrintJobs/GetPrintJobsTest3.xml");
        file4 = new File("./Database/PrintJobs/GetPrintJobsTest4.xml"); 
        file5 = new File("./Database/PrintJobs/Trash.txt");
        System.gc();
        file1.delete();
        file2.delete();
        file3.delete();
        file4.delete();
        file5.delete();
    }

    /**
     * Test of getPrintConfigurations method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetPrintConfigurations() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("./Database/Prints/Trash.txt", "UTF-8");
            writer.println("Text");
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetPrintConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SavePrintConfigurationCommand save;
        
        SpeedConfiguration speed = new SpeedConfiguration();
        speed.setBridgeAcceleration(.02);
        speed.setBridgesSpeed(1.02);
        speed.setDefaultAcceleration(.1);
        speed.setExternalPerimetersSpeed(2.2);
        speed.setFirstLayerSpeed(30);
        speed.setGapFillSpeed(1.2);
        speed.setInfillAcceleration(.3);
        speed.setInfillSpeed(1.5);
        speed.setName("GetTest.Speed");
        speed.setNonPrintMovesSpeed(2.2);
        speed.setPerimetersAcceleration(.5);
        speed.setPerimetersSpeed(3.4);
        speed.setSmallPerimetersSpeed(2.1);
        speed.setSolidInfillSpeed(1.3);
        speed.setSupportMaterialSpeed(3.4);
        speed.setTopSolidInfillSpeed(2.63);
        
        InfillConfiguration infill = new InfillConfiguration();
        infill.setInfillAngle(12);
        infill.setInfillBeforePerimeters(true);
        infill.setInfillDensity(.4);
        infill.setInfillEveryNLayers(3);
        infill.setInfillPattern("rectilinear");
        infill.setName("GetTest.Infill");
        infill.setOnlyInfillWhereNeeded(false);
        infill.setOnlyRetractInfillWhenCrossingPerimeters(true);
        infill.setSolidInfillEveryNLayers(4);
        infill.setSolidInfillThresholdArea(7);
        infill.setTopBottomInfillPattern("circles");
        
        LayerAndPerimeterConfiguration layer = new LayerAndPerimeterConfiguration();
        layer.setFirstLayerHeight(.001);
        layer.setGenerateExtraPerimetersWhenNeeded(true);
        layer.setLayerHeight(.0005);
        layer.setName("GetTest.Layer");
        layer.setPerimeters(2);
        layer.setRandomizedStartingPoints(true);
        layer.setSolidBottomLayers(2);
        layer.setSolidTopLayers(3);
        
        SkirtAndBrimConfiguration skirt = new SkirtAndBrimConfiguration();
        skirt.setBrimWidth(1.1);
        skirt.setName("GetTest.Skirt");
        skirt.setSkirtDistanceFromObject(1.2);
        skirt.setSkirtHeight(2);
        skirt.setSkirtLoops(3);
        skirt.setSkirtMinimumExtrusionLength(2.2);
        
        SupportMaterialConfiguration support = new SupportMaterialConfiguration();
        support.setEnforceSupportForFirstNLayers(1);
        support.setInterfaceLayers(2);
        support.setInterfacePatternSpacing(1.1);
        support.setName("GetTest.Support");
        support.setOverhangThreshold(3);
        support.setRaftLayers(4);
        support.setSupportMaterialPattern("rectilinear");
        support.setSupportPatternAngle(10);
        support.setSupportPatternSpacing(2.3);
        
        PrintConfiguration print = new PrintConfiguration();
        print.setName("GetPrintTest1");
        print.setInfillConfiguration(infill);
        print.setLayerPerimiterConfiguration(layer);
        print.setSkirtAndBrimConfiguration(skirt);
        print.setSpeedConfiguration(speed);
        print.setSupportMaterialConfiguration(support);
        
        save = new SavePrintConfigurationCommand(print);
        save.execute();
        
        print.setName("GetPrintTest2");
        save = new SavePrintConfigurationCommand(print);
        save.execute();
        
        print.setName("GetPrintTest3");
        save = new SavePrintConfigurationCommand(print);
        save.execute();
        
        print.setName("GetPrintTest4");
        save = new SavePrintConfigurationCommand(print);
        save.execute();
        
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("GetPrintTest1");
        expResult.add("GetPrintTest2");
        expResult.add("GetPrintTest3");
        expResult.add("GetPrintTest4");
        
        System.out.println("getPrintConfigurations");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        ArrayList<String> result = instance.getPrintConfigurations();
        assertEquals(expResult, result);
        
        file1 = new File("./Database/Prints/GetPrintTest1.xml");
        file2 = new File("./Database/Prints/GetPrintTest2.xml");
        file3 = new File("./Database/Prints/GetPrintTest3.xml");
        file4 = new File("./Database/Prints/GetPrintTest4.xml"); 
        file5 = new File("./Database/Prints/Trash.txt");
        System.gc();
        file1.delete();
        file2.delete();
        file3.delete();
        file4.delete();
        file5.delete();
    }

    /**
     * Test of getPrinterConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetPrinterConfiguration() {
        String name = "GetPrinterConfigurationTest";
        String path = "./Database/Printers/";
        
        PrinterConfiguration expResult = new PrinterConfiguration();
        expResult.setName(name);
        expResult.setBedX(150);
        expResult.setBedY(100);
        expResult.setNumExtruders(5);
        expResult.setPrintCenterX(75);
        expResult.setPrintCenterY(50);
        expResult.setUseRelativeEDistances(true);
        expResult.setVibrationLimit(1.1);
        expResult.setgCodeFlavor("rep-rap");
        expResult.setzOffset(1.34);
        
        String xml ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<printer>\n" +
                    "    <bedX>150.0</bedX>\n" +
                    "    <bedY>100.0</bedY>\n" +
                    "    <name>GetPrinterConfigurationTest</name>\n" +
                    "    <numExtruders>5</numExtruders>\n" +
                    "    <printCenterX>75.0</printCenterX>\n" +
                    "    <printCenterY>50.0</printCenterY>\n" +
                    "    <useRelativeEDistances>true</useRelativeEDistances>\n" +
                    "    <vibrationLimit>1.1</vibrationLimit>\n" +
                    "    <gCodeFlavor>rep-rap</gCodeFlavor>\n" +
                    "    <zOffset>1.34</zOffset>\n" +
                    "</printer>";
        
        
        PrintWriter writer;
        try {
            writer = new PrintWriter(path+name+".xml", "UTF-8");
            writer.println(xml);
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetPrinterConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("getPrinterConfiguration");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        PrinterConfiguration result = instance.getPrinterConfiguration(name);
        assertEquals(expResult, result);

        File file = new File(path+name+".xml");
        file.delete();
    }

    /**
     * Test of getExtruderConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetExtruderConfiguration() {
        String name = "GetExtruderConfigurationTest";
        String path = "./Database/Extruders/";

        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<extruder>\n" +
                    "    <name>GetExtruderConfigurationTest</name>\n" +
                    "    <extruderType>ABS</extruderType>\n" +
                    "    <headxOffset>0.0</headxOffset>\n" +
                    "    <headyOffset>0.0</headyOffset>\n" +
                    "    <headzOffset>0.0</headzOffset>\n" +
                    "    <nozzleDiameter>2.0</nozzleDiameter>\n" +
                    "    <xOffset>0.0</xOffset>\n" +
                    "    <yOffset>0.0</yOffset>\n" +
                    "    <zOffset>0.0</zOffset>\n" +
                    "</extruder>";
        
        ExtruderConfiguration expResult = new ExtruderConfiguration();
        expResult.setName(name);
        expResult.setExtruderType("ABS");
        expResult.setNozzleDiameter(2);
        expResult.setxOffset(0);
        expResult.setyOffset(0);
        expResult.setzOffset(0);
        
        
        PrintWriter writer;
        try {
            writer = new PrintWriter(path+name+".xml", "UTF-8");
            writer.println(xml);
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetExtruderConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("getExtruderConfiguration");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        ExtruderConfiguration result = instance.getExtruderConfiguration(name);
        assertEquals(expResult, result);
        
        File file = new File(path+name+".xml");
        file.delete();
    }

    /**
     * Test of getMaterialConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetMaterialConfiguration() {
        String name = "GetMaterialConfigurationTest";
        String path = "./Database/Materials/";
        MaterialConfiguration expResult = new MaterialConfiguration();
        expResult.setName("GetMaterialConfigurationTest");
        expResult.setBridgeFanSpeedPercent(1);
        expResult.setDisableFanForFirstNLayers(2);
        expResult.setEnableAutoCooling(true);
        expResult.setEnableFanTimeThreshold(3);
        expResult.setExtraLengthAfterRetraction(1.4);
        expResult.setExtraLengthOnToolReenable(1.5);
        expResult.setExtrusionMultiplier(1.6);
        expResult.setExtrusionTemperature(124);
        expResult.setFanAlwaysOn(false);
        expResult.setFilamentDiameter(.98);
        expResult.setFirstLayerExtrusionTemperature(129);
        expResult.setMaxFanSpeed(6);
        expResult.setMinFanSpeed(0);
        expResult.setMinPrintSpeed(9);
        expResult.setMinimumTravelAfterRetraction(.01);
        expResult.setRetractOnLayerChange(true);
        expResult.setRetractionLength(.02);
        expResult.setRetractionLength(.04);
        expResult.setRetractionLengthBeforeToolChange(.13);
        expResult.setRetractionLiftZ(.2);
        expResult.setRetractionSpeed(12);
        expResult.setSlowDownTimeTreshold(13);
        expResult.setWipeBeforeRetract(true);
        
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
        
        System.out.println("getMaterialConfiguration");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        MaterialConfiguration result = instance.getMaterialConfiguration(name);
        assertEquals(expResult, result);
        
        File file = new File(path+name+".xml");
        file.delete();
    }

    /**
     * Test of getPrintJobConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetPrintJobConfiguration() {
        this.setupExtruder();
        this.setupMaterial();
        this.setupPrint();
        this.setupPrinter(); 
        this.setupFiles();
        this.setupExtruderMaterial();
        this.setupSubsets();
        
        PrintJobConfiguration expResult = new PrintJobConfiguration();
        expResult.setName("GetPrintJobTest");
        expResult.setPrinterConfiguration(printer);
        expResult.setSubsetConfigurationList(subsets);
        
        this.setupMaterialsSelection();
        this.setupSubsetSelection();
        
        PrintJobSelection printJob = new PrintJobSelection();
        printJob.setName("GetPrintJobTest");
        printJob.setPrinterConfiguration("GetPrintJobTest");
        printJob.setMaterials(materialsSelections);
        printJob.setSubsetConfigurationList(subsetSelections);
        
        
        System.out.println("getPrintJobConfiguration");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        PrintJobConfiguration result = instance.getPrintJobConfiguration(printJob);
        assertEquals(expResult, result);
        
        this.delete();
    }

    /**
     * Test of getPrintJobSelection method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetPrintJobSelection() {
        String name = "GetPrintJobSelectionTest";
        String path = "./Database/PrintJobs/";
        SubsetSelection subset1 = new SubsetSelection();
        subset1.setBottomZ(0);
        subset1.setPrintConfiguration(name+".Sub1.Print");
        subset1.setTopZ(1);
        subset1.getFileConfigurations().add(new FileSelection("extruder1", "material1", "file1"));
        subset1.getFileConfigurations().add(new FileSelection("extruder2", "material2", "file2"));
        subset1.getFileConfigurations().add(new FileSelection("extruder3", "material3", "file3"));
        
        SubsetSelection subset2 = new SubsetSelection();
        subset2.setBottomZ(1);
        subset2.setPrintConfiguration(name+".Sub2.Print");
        subset2.setTopZ(2);
        
        subset2.getFileConfigurations().add(new FileSelection("extruder2", "material2", "file1"));
        subset2.getFileConfigurations().add(new FileSelection("extruder3", "material3", "file2"));
        subset2.getFileConfigurations().add(new FileSelection("extruder1", "material1", "file3"));
        
        PrintJobSelection expResult = new PrintJobSelection();
        expResult.setName(name);
        expResult.setPrinterConfiguration(name+".printer");
        expResult.getMaterials().add(new ExtruderMaterialSelection("extruder 1", "material 1"));
        expResult.getMaterials().add(new ExtruderMaterialSelection("extruder 2", "material 1"));
        expResult.getMaterials().add(new ExtruderMaterialSelection("extruder 3", "material 2"));
        expResult.getSubsetConfigurationList().add(subset1);
        expResult.getSubsetConfigurationList().add(subset2);
               
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<printjob>\n" +
                    "    <name>GetPrintJobSelectionTest</name>\n" +
                    "    <printerConfiguration>GetPrintJobSelectionTest.printer</printerConfiguration>\n" +
                    "    <extruderMarterial>\n" +
                    "        <extruder>extruder 1</extruder>\n" +
                    "        <material>material 1</material>\n" +
                    "    </extruderMarterial>\n" +
                    "    <extruderMarterial>\n" +
                    "        <extruder>extruder 2</extruder>\n" +
                    "        <material>material 1</material>\n" +
                    "    </extruderMarterial>\n" +
                    "    <extruderMarterial>\n" +
                    "        <extruder>extruder 3</extruder>\n" +
                    "        <material>material 2</material>\n" +
                    "    </extruderMarterial>\n" +
                    "    <subsetSelection>\n" +
                    "        <bottomZ>0.0</bottomZ>\n" +
                    "        <topZ>1.0</topZ>\n" +
                    "        <printConfiguration>GetPrintJobSelectionTest.Sub1.Print</printConfiguration>\n" +
                    "        <fileSelection>\n" +
                    "            <file>file1</file>\n" +
                    "            <extruder>extruder1</extruder>\n" +
                    "            <material>material1</material>\n" +
                    "        </fileSelection>\n" +
                    "        <fileSelection>\n" +
                    "            <file>file2</file>\n" +
                    "            <extruder>extruder2</extruder>\n" +
                    "            <material>material2</material>\n" +
                    "        </fileSelection>\n" +
                    "        <fileSelection>\n" +
                    "            <file>file3</file>\n" +
                    "            <extruder>extruder3</extruder>\n" +
                    "            <material>material3</material>\n" +
                    "        </fileSelection>\n" +
                    "    </subsetSelection>\n" +
                    "    <subsetSelection>\n" +
                    "        <bottomZ>1.0</bottomZ>\n" +
                    "        <topZ>2.0</topZ>\n" +
                    "        <printConfiguration>GetPrintJobSelectionTest.Sub2.Print</printConfiguration>\n" +
                    "        <fileSelection>\n" +
                    "            <file>file1</file>\n" +
                    "            <extruder>extruder2</extruder>\n" +
                    "            <material>material2</material>\n" +
                    "        </fileSelection>\n" +
                    "        <fileSelection>\n" +
                    "            <file>file2</file>\n" +
                    "            <extruder>extruder3</extruder>\n" +
                    "            <material>material3</material>\n" +
                    "        </fileSelection>\n" +
                    "        <fileSelection>\n" +
                    "            <file>file3</file>\n" +
                    "            <extruder>extruder1</extruder>\n" +
                    "            <material>material1</material>\n" +
                    "        </fileSelection>\n" +
                    "    </subsetSelection>\n" +
                    "</printjob>";
        
        PrintWriter writer;
        try {
            writer = new PrintWriter(path+name+".xml", "UTF-8");
            writer.println(xml);
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetPrintJobSelectionCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("getPrintJobSelection");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        PrintJobSelection result = instance.getPrintJobSelection(name);
        assertEquals(expResult, result);
        
        File file = new File(path+name+".xml");
        file.delete();
    }

    /**
     * Test of getPrintConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetPrintConfiguration() {
        String name = "GetPrintConfigurationTest";
        String path = "./Database/Prints/";
        speed = new SpeedConfiguration();
        speed.setBridgeAcceleration(.02);
        speed.setBridgesSpeed(1.02);
        speed.setDefaultAcceleration(.1);
        speed.setExternalPerimetersSpeed(2.2);
        speed.setFirstLayerSpeed(30);
        speed.setGapFillSpeed(1.2);
        speed.setInfillAcceleration(.3);
        speed.setInfillSpeed(1.5);
        speed.setName(name+".Speed");
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
        infill.setName(name+".Infill");
        infill.setOnlyInfillWhereNeeded(false);
        infill.setOnlyRetractInfillWhenCrossingPerimeters(true);
        infill.setSolidInfillEveryNLayers(4);
        infill.setSolidInfillThresholdArea(7);
        infill.setTopBottomInfillPattern("circles");
        
        layer = new LayerAndPerimeterConfiguration();
        layer.setFirstLayerHeight(.001);
        layer.setGenerateExtraPerimetersWhenNeeded(true);
        layer.setLayerHeight(.0005);
        layer.setName(name+".Layer");
        layer.setPerimeters(2);
        layer.setRandomizedStartingPoints(true);
        layer.setSolidBottomLayers(2);
        layer.setSolidTopLayers(3);
        
        skirt = new SkirtAndBrimConfiguration();
        skirt.setBrimWidth(1.1);
        skirt.setName(name+".Skirt");
        skirt.setSkirtDistanceFromObject(1.2);
        skirt.setSkirtHeight(2);
        skirt.setSkirtLoops(3);
        skirt.setSkirtMinimumExtrusionLength(2.2);
        
        support = new SupportMaterialConfiguration();
        support.setEnforceSupportForFirstNLayers(1);
        support.setInterfaceLayers(2);
        support.setInterfacePatternSpacing(1.1);
        support.setName(name+".Support");
        support.setOverhangThreshold(3);
        support.setRaftLayers(4);
        support.setSupportMaterialPattern("rectilinear");
        support.setSupportPatternAngle(10);
        support.setSupportPatternSpacing(2.3);
        
        PrintConfiguration expResult = new PrintConfiguration();
        expResult.setName(name);
        expResult.setInfillConfiguration(infill);
        expResult.setLayerPerimiterConfiguration(layer);
        expResult.setSkirtAndBrimConfiguration(skirt);
        expResult.setSpeedConfiguration(speed);
        expResult.setSupportMaterialConfiguration(support);
        
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<print>\n" +
                    "    <infillConfiguration>\n" +
                    "        <infillAngle>12</infillAngle>\n" +
                    "        <infillBeforePerimeters>true</infillBeforePerimeters>\n" +
                    "        <infillDensity>0.4</infillDensity>\n" +
                    "        <infillEveryNLayers>3</infillEveryNLayers>\n" +
                    "        <infillPattern>rectilinear</infillPattern>\n" +
                    "        <name>GetPrintConfigurationTest.Infill</name>\n" +
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
                    "        <name>GetPrintConfigurationTest.Layer</name>\n" +
                    "        <perimeters>2</perimeters>\n" +
                    "        <randomizedStartingPoints>true</randomizedStartingPoints>\n" +
                    "        <solidBottomLayers>2</solidBottomLayers>\n" +
                    "        <solidTopLayers>3</solidTopLayers>\n" +
                    "    </layerPerimiterConfiguration>\n" +
                    "    <name>GetPrintConfigurationTest</name>\n" +
                    "    <skirtAndBrimConfiguration>\n" +
                    "        <brimWidth>1.1</brimWidth>\n" +
                    "        <name>GetPrintConfigurationTest.Skirt</name>\n" +
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
                    "        <firstLayerSpeed>30</firstLayerSpeed>\n" +
                    "        <gapFillSpeed>1.2</gapFillSpeed>\n" +
                    "        <infillAcceleration>0.3</infillAcceleration>\n" +
                    "        <infillSpeed>1.5</infillSpeed>\n" +
                    "        <name>GetPrintConfigurationTest.Speed</name>\n" +
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
                    "        <name>GetPrintConfigurationTest.Support</name>\n" +
                    "        <overhangThreshold>3</overhangThreshold>\n" +
                    "        <raftLayers>4</raftLayers>\n" +
                    "        <supportMaterialPattern>rectilinear</supportMaterialPattern>\n" +
                    "        <supportPatternAngle>10</supportPatternAngle>\n" +
                    "        <supportPatternSpacing>2.3</supportPatternSpacing>\n" +
                    "    </supportMaterialConfiguration>\n" +
                    "</print>";
        
        PrintWriter writer;
        try {
            writer = new PrintWriter(path+name+".xml", "UTF-8");
            writer.println(xml);
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetPrintConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("getPrintConfiguration");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        PrintConfiguration result = instance.getPrintConfiguration(name);
        assertEquals(expResult, result);
        
        File file = new File(path+name+".xml");
        file.delete();
    }

    /**
     * Test of savePrinterConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testSavePrinterConfiguration() {
        printer = new PrinterConfiguration();
        printer.setName("SaveTest");
        printer.setBedX(150);
        printer.setBedY(100);
        printer.setNumExtruders(5);
        printer.setPrintCenterX(75);
        printer.setPrintCenterY(50);
        printer.setUseRelativeEDistances(true);
        printer.setVibrationLimit(1.1);
        printer.setgCodeFlavor("rep-rap");
        printer.setzOffset(1.34);
        printer.setExtruderList(new ArrayList<ExtruderConfiguration>());
        printer.getExtruderList().add(new ExtruderConfiguration());
        
        String expResult ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                            "<printer>\n" +
                            "    <hardware>\n" +
                            "        <baudRate>115200</baudRate>\n" +
                            "        <comPort>COM1</comPort>\n" +
                            "        <lineEnd>3</lineEnd>\n" +
                            "    </hardware>\n" +
                            "    <name>SaveTest</name>\n" +
                            "    <bedX>150.0</bedX>\n" +
                            "    <bedY>100.0</bedY>\n" +
                            "    <printCenterX>75.0</printCenterX>\n" +
                            "    <printCenterY>50.0</printCenterY>\n" +
                            "    <zOffset>1.34</zOffset>\n" +
                            "    <gCodeFlavor>rep-rap</gCodeFlavor>\n" +
                            "    <useRelativeEDistances>true</useRelativeEDistances>\n" +
                            "    <numExtruders>5</numExtruders>\n" +
                            "    <vibrationLimit>1.1</vibrationLimit>\n" +
                            "    <useFirmwareRetraction>false</useFirmwareRetraction>\n" +
                            "    <startGCode></startGCode>\n" +
                            "    <endGCode></endGCode>\n" +
                            "    <bedTempFirstLayer>0</bedTempFirstLayer>\n" +
                            "    <bedTemp>0</bedTemp>" +
                            "    <extruderList>\n" +
                            "        <name>Default</name>\n" +
                            "        <extruderType></extruderType>\n" +
                            "        <nozzleDiameter>0.5</nozzleDiameter>\n" +
                            "        <xDimension>0.0</xDimension>\n" +
                            "        <yDimension>0.0</yDimension>\n" +
                            "        <xOffset>0.0</xOffset>\n" +
                            "        <yOffset>0.0</yOffset>\n" +
                            "        <zOffset>0.0</zOffset>\n" +
                            "        <startGCode></startGCode>\n" +
                            "        <endGCode></endGCode>\n" +
                            "    </extruderList>\n" +
                            "</printer>";
        
        System.out.println("savePrinterConfiguration");
        XmlPersistenceFramework instance = new XmlPersistenceFramework(); 
        
        assertTrue(instance.savePrinterConfiguration(printer));
        
        String path = "./Database/Printers/"+printer.getName()+".xml";
        File newfile = new File(path);
        String result;
        try {
            result = FileUtils.readFileToString(newfile);
            result = result.substring(0, result.length()-1);
            if(!expResult.equals(result)) System.out.printf("Test "+this.getClass().getName()+"\nexpected: "+ expResult+"\nGot: "+result);
            assertEquals(expResult, result);
        } catch (IOException ex) {
            Logger.getLogger(XmlPersistenceFrameworkTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Could not read saved printer configuration");
            printer = null;
            newfile = null;
            System.gc();
            File file = new File("./Database/Printers/SaveTest.xml");
            file.delete();
        }
         
        printer = null;
        System.gc();
        File file = new File("./Database/Printers/SaveTest.xml");
        file.delete();
    }

    /**
     * Test of saveExtruderConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testSaveExtruderConfiguration() {
        ExtruderConfiguration config = new ExtruderConfiguration();
        config.setName("SaveTest");
        config.setExtruderType("ABS");
        config.setNozzleDiameter(2);
        config.setxOffset(0);
        config.setyOffset(0);
        config.setzOffset(0);
        
        String expResult ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<extruder>\n" +
                        "    <name>SaveTest</name>\n" +
                        "    <extruderType>ABS</extruderType>\n" +
                        "    <nozzleDiameter>2.0</nozzleDiameter>\n" +
                        "    <xDimension>0.0</xDimension>\n" +
                        "    <yDimension>0.0</yDimension>\n" +
                        "    <xOffset>0.0</xOffset>\n" +
                        "    <yOffset>0.0</yOffset>\n" +
                        "    <zOffset>0.0</zOffset>\n" +
                        "    <startGCode></startGCode>\n" +
                        "    <endGCode></endGCode>\n" +
                        "</extruder>";
        
        System.out.println("saveExtruderConfiguration");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        assertTrue(instance.saveExtruderConfiguration(config));
        
        String result;
        try {
            String path = "./Database/Extruders/"+config.getName()+".xml";
            file = new File(path);
            result = FileUtils.readFileToString(file);
            result = result.substring(0, result.length()-1);
            assertEquals(expResult, result);
        } catch (IOException ex) {
            Logger.getLogger(XmlPersistenceFrameworkTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Could not read in saved extruder configuration");
        }
        
        file = null;
        extruder = null;
        System.gc();
        file = new File("./Database/Extruders/SaveTest.xml");
        file.delete();
        
    }

    /**
     * Test of saveMaterialConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testSaveMaterialConfiguration() {
        MaterialConfiguration config = new MaterialConfiguration();
        config.setName("SaveTest");
        config.setBridgeFanSpeedPercent(1);
        config.setDisableFanForFirstNLayers(2);
        config.setEnableAutoCooling(true);
        config.setEnableFanTimeThreshold(3);
        config.setExtraLengthAfterRetraction(1.4);
        config.setExtraLengthOnToolReenable(1.5);
        config.setExtrusionMultiplier(1.6);
        config.setExtrusionTemperature(124);
        config.setFanAlwaysOn(false);
        config.setFilamentDiameter(.98);
        config.setFirstLayerExtrusionTemperature(129);
        config.setMaxFanSpeed(6);
        config.setMinFanSpeed(0);
        config.setMinPrintSpeed(9);
        config.setMinimumTravelAfterRetraction(.01);
        config.setRetractOnLayerChange(true);
        config.setRetractionLength(.02);
        config.setRetractionLength(.04);
        config.setRetractionLengthBeforeToolChange(.13);
        config.setRetractionLiftZ(.2);
        config.setRetractionSpeed(12);
        config.setSlowDownTimeTreshold(13);
        config.setWipeBeforeRetract(true);
        config.setgCodeStart("haha");
        config.setgCodeEnd("lol");
        
        String expResult ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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
        
        System.out.println("saveMaterialConfiguration");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        assertTrue(instance.saveMaterialConfiguration(config));
        
        String result;
        try {
            String path = "./Database/Materials/"+config.getName()+".xml";
            file = new File(path);
            result = FileUtils.readFileToString(file);
            result = result.substring(0, result.length()-1);
            assertEquals(expResult, result);
        } catch (IOException ex) {
            Logger.getLogger(XmlPersistenceFrameworkTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Could not read in saved extruder configuration");
        }
        
        material = null;
        File file = new File("./Database/Materials/SaveTest.xml");
        System.gc();
        file.delete();
    }

    /**
     * Test of savePrintJobSelection method, of class XmlPersistenceFramework.
     */
    @Test
    public void testSavePrintJobSelection() {
        SubsetSelection subset1 = new SubsetSelection();
        subset1.setBottomZ(0);
        subset1.setPrintConfiguration("SaveTest.Sub1.Print");
        subset1.setTopZ(1);
        subset1.getFileConfigurations().add(new FileSelection("extruder1", "material1", "file1"));
        subset1.getFileConfigurations().add(new FileSelection("extruder2", "material2", "file2"));
        subset1.getFileConfigurations().add(new FileSelection("extruder3", "material3", "file3"));
        
        SubsetSelection subset2 = new SubsetSelection();
        subset2.setBottomZ(1);
        subset2.setPrintConfiguration("SaveTest.Sub2.Print");
        subset2.setTopZ(2);
        subset2.getFileConfigurations().add(new FileSelection("extruder2", "material2", "file1"));
        subset2.getFileConfigurations().add(new FileSelection("extruder3", "material3", "file2"));
        subset2.getFileConfigurations().add(new FileSelection("extruder1", "material1", "file3"));
        
        PrintJobSelection config = new PrintJobSelection();
        config.setName("SaveTest");
        config.setPrinterConfiguration("SaveTest.printer");
        config.getMaterials().add(new ExtruderMaterialSelection("extruder 1", "material 1"));
        config.getMaterials().add(new ExtruderMaterialSelection("extruder 2", "material 1"));
        config.getMaterials().add(new ExtruderMaterialSelection("extruder 3", "material 2"));
        config.getSubsetConfigurationList().add(subset1);
        config.getSubsetConfigurationList().add(subset2);
        
        String expResult ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                            "<printjob>\n" +
                            "    <name>SaveTest</name>\n" +
                            "    <printerConfiguration>SaveTest.printer</printerConfiguration>\n" +
                            "    <extruderMarterial>\n" +
                            "        <extruder>extruder 1</extruder>\n" +
                            "        <material>material 1</material>\n" +
                            "    </extruderMarterial>\n" +
                            "    <extruderMarterial>\n" +
                            "        <extruder>extruder 2</extruder>\n" +
                            "        <material>material 1</material>\n" +
                            "    </extruderMarterial>\n" +
                            "    <extruderMarterial>\n" +
                            "        <extruder>extruder 3</extruder>\n" +
                            "        <material>material 2</material>\n" +
                            "    </extruderMarterial>\n" +
                            "    <subsetSelection>\n" +
                            "        <bottomZ>0.0</bottomZ>\n" +
                            "        <topZ>1.0</topZ>\n" +
                            "        <printConfiguration>SaveTest.Sub1.Print</printConfiguration>\n" +
                            "        <fileSelection>\n" +
                            "            <file>file1</file>\n" +
                            "            <extruderNum>0</extruderNum>\n" +
                            "            <extruder>extruder1</extruder>\n" +
                            "            <material>material1</material>\n" +
                            "        </fileSelection>\n" +
                            "        <fileSelection>\n" +
                            "            <file>file2</file>\n" +
                            "            <extruderNum>0</extruderNum>\n" +
                            "            <extruder>extruder2</extruder>\n" +
                            "            <material>material2</material>\n" +
                            "        </fileSelection>\n" +
                            "        <fileSelection>\n" +
                            "            <file>file3</file>\n" +
                            "            <extruderNum>0</extruderNum>\n" +
                            "            <extruder>extruder3</extruder>\n" +
                            "            <material>material3</material>\n" +
                            "        </fileSelection>\n" +
                            "    </subsetSelection>\n" +
                            "    <subsetSelection>\n" +
                            "        <bottomZ>1.0</bottomZ>\n" +
                            "        <topZ>2.0</topZ>\n" +
                            "        <printConfiguration>SaveTest.Sub2.Print</printConfiguration>\n" +
                            "        <fileSelection>\n" +
                            "            <file>file1</file>\n" +
                            "            <extruderNum>0</extruderNum>\n" +
                            "            <extruder>extruder2</extruder>\n" +
                            "            <material>material2</material>\n" +
                            "        </fileSelection>\n" +
                            "        <fileSelection>\n" +
                            "            <file>file2</file>\n" +
                            "            <extruderNum>0</extruderNum>\n" +
                            "            <extruder>extruder3</extruder>\n" +
                            "            <material>material3</material>\n" +
                            "        </fileSelection>\n" +
                            "        <fileSelection>\n" +
                            "            <file>file3</file>\n" +
                            "            <extruderNum>0</extruderNum>\n" +
                            "            <extruder>extruder1</extruder>\n" +
                            "            <material>material1</material>\n" +
                            "        </fileSelection>\n" +
                            "    </subsetSelection>\n" +
                            "</printjob>";
        
        System.out.println("savePrintJobSelection");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        assertTrue(instance.savePrintJobSelection(config));
        
        String path = "./Database/PrintJobs/"+config.getName()+".xml";
        String result;
        try {
            result = FileUtils.readFileToString(new File(path));
            result = result.substring(0, result.length()-1);
            assertEquals(expResult, result);
        } catch (IOException ex) {
            Logger.getLogger(XmlPersistenceFrameworkTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Cannot read saved PrintJobSelection from disk");
        }

        System.gc();
        File file = new File("./Database/PrintJobs/SaveTest.xml");
        file.delete();
    }

    /**
     * Test of savePrintConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testSavePrintConfiguration() {
        speed = new SpeedConfiguration();
        speed.setBridgeAcceleration(.02);
        speed.setBridgesSpeed(1.02);
        speed.setDefaultAcceleration(.1);
        speed.setExternalPerimetersSpeed(2.2);
        speed.setFirstLayerSpeed(30);
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
        
        PrintConfiguration config = new PrintConfiguration();
        config.setName("SaveTest");
        config.setInfillConfiguration(infill);
        config.setLayerPerimiterConfiguration(layer);
        config.setSkirtAndBrimConfiguration(skirt);
        config.setSpeedConfiguration(speed);
        config.setSupportMaterialConfiguration(support);
        
        String expResult ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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
                            "        <combineInfillEveryNLayers>0</combineInfillEveryNLayers>\n" +
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
                            "        <firstLayerSpeed>30</firstLayerSpeed>\n" +
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
        
        System.out.println("savePrintConfiguration");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        assertTrue(instance.savePrintConfiguration(config));
        

        String result; 
        try {
            String path = "./Database/Prints/"+config.getName()+".xml";
            result = FileUtils.readFileToString(new File(path));
            result = result.substring(0, result.length()-1);
            assertEquals(expResult, result);
        } catch (IOException ex) {
            Logger.getLogger(XmlPersistenceFrameworkTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Could not open Saved Print configuration");
        }
       
        System.gc();
        File file = new File("./Database/Prints/SaveTest.xml");
        file.delete();
    }

    /**
     * Test of deletePrinterConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testDeletePrinterConfigurationValidFile() {
        String name = "./Database/Printers/DeleteTest.xml";
        file = new File(name);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            fail("Could not create File to delete");
            Logger.getLogger(DeletePrinterConfigurationCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        name = "DeleteTest";
        System.out.println("DeletePrinterConfigurationValidFile");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        assertTrue(instance.deletePrinterConfiguration(name));
    }
    
    /**
     * Test of deletePrinterConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testDeletePrinterConfigurationInvalidFile() {
        System.out.println("DeletePrinterConfigurationInvalidFile");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        assertFalse(instance.deletePrinterConfiguration("DeleteExceptionTest"));
    }

    /**
     * Test of deleteExtruderConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testDeleteExtruderConfigurationValidFile() {
        String name = "./Database/Extruders/DeleteTest.xml";
        file = new File(name);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            fail("Could not create File to delete");
            Logger.getLogger(DeleteExtruderConfigurationCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        name = "DeleteTest";
        System.out.println("deleteExtruderConfigurationValidFile");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        assertTrue(instance.deleteExtruderConfiguration(name));
    }
    
    /**
     * Test of deleteExtruderConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testDeleteExtruderConfigurationInvalidFile() {
        String name = "DeleteTest";
        System.out.println("deleteExtruderConfigurationInvalidFile");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        assertFalse(instance.deleteExtruderConfiguration(name));
    }

    /**
     * Test of deleteMaterialConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testDeleteMaterialConfigurationValidFile() {
        String name = "./Database/Materials/DeleteTest.xml";
        file = new File(name);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            fail("Could not create File to delete");
            Logger.getLogger(DeleteMaterialConfigurationCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("deleteMaterialConfigurationValidFile");
        name = "DeleteTest";
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        Boolean expResult = Boolean.TRUE;
        Boolean result = instance.deleteMaterialConfiguration(name);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of deleteMaterialConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testDeleteMaterialConfigurationInvalidFile() {
        System.out.println("deleteMaterialConfigurationInvalidFile");
        String name  = "DeleteTest";
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        Boolean expResult = Boolean.FALSE;
        Boolean result = instance.deleteMaterialConfiguration(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of deletePrintJobSelection method, of class XmlPersistenceFramework.
     */
    @Test
    public void testDeletePrintJobSelectionValidFile() {
        String name = "./Database/PrintJobs/DeleteTest.xml";
        file = new File(name);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            fail("Could not create File to delete");
            Logger.getLogger(DeletePrintJobSelectionCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("deletePrintJobSelection");
        name = "DeleteTest";
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        Boolean expResult = Boolean.TRUE;
        Boolean result = instance.deletePrintJobSelection(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of deletePrintJobSelection method, of class XmlPersistenceFramework.
     */
    @Test
    public void testDeletePrintJobSelectionInvalidFile() {
        System.out.println("deletePrintJobSelectionInvalidFile");
        String name = "DeleteTest";
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        Boolean expResult = Boolean.FALSE;
        Boolean result = instance.deletePrintJobSelection(name);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of deletePrintConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testDeletePrintConfigurationValidFile() {
        String name = "./Database/Prints/DeleteTest.xml";
        
        file = new File(name);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            fail("Could not create File to delete");
            Logger.getLogger(DeletePrintConfigurationCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("deletePrintConfigurationValidFile");
        name = "DeleteTest";
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        Boolean expResult = Boolean.TRUE;
        Boolean result = instance.deletePrintConfiguration(name);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of deletePrintConfiguration method, of class XmlPersistenceFramework.
     */
    @Test
    public void testDeletePrintConfigurationInvalidFile() {
        System.out.println("deletePrintConfigurationInvalidFile");
        String name = "DeleteTest";
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        Boolean expResult = Boolean.FALSE;
        Boolean result = instance.deletePrintConfiguration(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStlFiles method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetStlFiles() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("./Database/Files/Trash.txt", "UTF-8");
            writer.println("Text");
            writer.close();
            
            writer = new PrintWriter("./Database/Files/GetStlFilesTest1.stl", "UTF-8");
            writer.println("Text");
            writer.close();
            
            writer = new PrintWriter("./Database/Files/GetStlFilesTest2.stl", "UTF-8");
            writer.println("Text");
            writer.close();
            
            writer = new PrintWriter("./Database/Files/GetStlFilesTest3.stl", "UTF-8");
            writer.println("Text");
            writer.close();
            
            writer = new PrintWriter("./Database/Files/GetStlFilesTest4.stl", "UTF-8");
            writer.println("Text");
            writer.close();
            
            writer = null;
        } catch (Exception ex) {
            Logger.getLogger(GetStlFilesCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("GetStlFilesTest1");
        expResult.add("GetStlFilesTest2");
        expResult.add("GetStlFilesTest3");
        expResult.add("GetStlFilesTest4");
        
        System.out.println("getStlFiles");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        ArrayList<String> result = instance.getStlFiles();
        assertEquals(expResult, result);
        
        System.gc();
        file1 = new File("./Database/Files/GetStlFilesTest1.stl");
        file2 = new File("./Database/Files/GetStlFilesTest2.stl");
        file3 = new File("./Database/Files/GetStlFilesTest3.stl");
        file4 = new File("./Database/Files/GetStlFilesTest4.stl");
        file5 = new File("./Database/Files/Trash.txt");
        file1.delete();
        file2.delete();
        file3.delete();
        file4.delete();
        file5.delete();
    }

    /**
     * Test of getStlFile method, of class XmlPersistenceFramework.
     */
    @Test
    public void testGetStlFile() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("./Database/Files/GetStlTest.stl", "UTF-8");
            writer.println("Text");
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetPrinterConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("getStlFile");
        String name = "GetStlTest";
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        File expResult = new File("./Database/Files/GetStlTest.stl");
        File result = instance.getStlFile(name);
        assertEquals(expResult, result);

        file1 = new File("./Database/Files/GetStlTest.stl");
        System.gc();
        file1.delete();
    }

    /**
     * Test of importStlFile method, of class XmlPersistenceFramework.
     */
    @Test
    public void testImportStlFile() {
        String expected = "./Database/Files/Feed-Housing.stl";
        String name = "./test-files/stl/Feed-Housing.STL";
        File newFile;
        
        System.out.println("importStlFile");
        String path = name;
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        assertTrue(instance.importStlFile(path));
        newFile = new File(expected);
        try {
            String result = FileUtils.readFileToString(newFile);
            String expResult =  FileUtils.readFileToString(new File(name));
            assertEquals(expResult, result);
        } catch (IOException ex) {
            Logger.getLogger(XmlPersistenceFrameworkTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        newFile.delete();
    }

    /**
     * Test of deleteStlFile method, of class XmlPersistenceFramework.
     */
    @Test
    public void testDeleteStlFileValidFile() {
        String name = "./Database/Files/DeleteTest.stl";
        file = new File(name);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            fail("Could not create File to delete");
            Logger.getLogger(DeleteStlFileCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        file = null;
        System.gc();
        System.out.println("deleteStlFileValidFile");
        name = "DeleteTest";
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        Boolean expResult = Boolean.TRUE;
        Boolean result = instance.deleteStlFile(name);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of deleteStlFile method, of class XmlPersistenceFramework.
     */
    @Test
    public void testDeleteStlFileInvalidFile() {
        System.out.println("deleteStlFileValidFile");
        XmlPersistenceFramework instance = new XmlPersistenceFramework();
        Boolean expResult = Boolean.FALSE;
        Boolean result = instance.deleteStlFile("DeleteExceptoinTest");
        assertEquals(expResult, result);
    }
}
