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
public class GetPrintConfigurationsCommandTest {
    PrintConfiguration print;
    InfillConfiguration infill;
    LayerAndPerimeterConfiguration layer;
    SkirtAndBrimConfiguration skirt;
    SpeedConfiguration speed;
    SupportMaterialConfiguration support;
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
            writer = new PrintWriter("./Database/Prints/Trash.txt", "UTF-8");
            writer.println("Text");
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetPrintConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SavePrintConfigurationCommand save;
        
        speed = new SpeedConfiguration();
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
        
        infill = new InfillConfiguration();
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
        
        layer = new LayerAndPerimeterConfiguration();
        layer.setFirstLayerHeight(.001);
        layer.setGenerateExtraPerimetersWhenNeeded(true);
        layer.setLayerHeight(.0005);
        layer.setName("GetTest.Layer");
        layer.setPerimeters(2);
        layer.setRandomizedStartingPoints(true);
        layer.setSolidBottomLayers(2);
        layer.setSolidTopLayers(3);
        
        skirt = new SkirtAndBrimConfiguration();
        skirt.setBrimWidth(1.1);
        skirt.setName("GetTest.Skirt");
        skirt.setSkirtDistanceFromObject(1.2);
        skirt.setSkirtHeight(2);
        skirt.setSkirtLoops(3);
        skirt.setSkirtMinimumExtrusionLength(2.2);
        
        support = new SupportMaterialConfiguration();
        support.setEnforceSupportForFirstNLayers(1);
        support.setInterfaceLayers(2);
        support.setInterfacePatternSpacing(1.1);
        support.setName("GetTest.Support");
        support.setOverhangThreshold(3);
        support.setRaftLayers(4);
        support.setSupportMaterialPattern("rectilinear");
        support.setSupportPatternAngle(10);
        support.setSupportPatternSpacing(2.3);
        
        print = new PrintConfiguration();
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
        
        expected = new ArrayList<>();
        expected.add("GetPrintTest1");
        expected.add("GetPrintTest2");
        expected.add("GetPrintTest3");
        expected.add("GetPrintTest4");
    }
    
    @After
    public void tearDown() {
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
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void GetPrintConfigurationsTest() throws IOException {
        GetPrintConfigurationsCommand instance = new GetPrintConfigurationsCommand();
        instance.execute();
        actual = (ArrayList<String>)instance.getResult();
        if(!expected.equals(actual)) System.out.printf("Test "+this.getClass().getName()+" expected: "+ expected+"\nGot: "+actual);
        assertTrue(expected.equals(actual));
    }
    
}
