/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.ExtruderMaterialSelection;
import ink3d.ConfigurationObjects.ExtruderMaterialConfiguration;
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
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author daniellain
 */
public class GetPrintJobConfigurationCommandTest {
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
    PrintJobSelection input;
    PrintJobConfiguration expected;
    PrintJobConfiguration actual;
    
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
        speed2.setFirstLayerSpeed(1.3);
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
        speed.setFirstLayerSpeed(1.3);
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
    
    @Before
    public void setUp() {
        this.setupExtruder();
        this.setupMaterial();
        this.setupPrint();
        this.setupPrinter(); 
        this.setupFiles();
        this.setupExtruderMaterial();
        this.setupSubsets();
        
        expected = new PrintJobConfiguration();
        expected.setName("GetPrintJobTest");
        expected.setPrinterConfiguration(printer);
        expected.setSubsetConfigurationList(subsets);
        
        this.setupMaterialsSelection();
        this.setupSubsetSelection();
        
        input = new PrintJobSelection();
        input.setName("GetPrintJobTest");
        input.setPrinterConfiguration("GetPrintJobTest");
        input.setMaterials(materialsSelections);
        input.setSubsetConfigurationList(subsetSelections);
        
    }
    
    @After
    public void tearDown(){
        this.delete();
    }
    @Test
    public void getPrintJobConfigurationTest() {
        actual = db.getPrintJobConfiguration(input);
        if(!expected.equals(actual)) System.out.printf("Test "+this.getClass().getName()+"\nexpected: "+ expected+"\nGot:      "+actual);
        assertTrue(expected.equals(actual));
    }
    
}
