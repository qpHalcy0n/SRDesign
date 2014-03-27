/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderMaterialSelection;
import ink3d.ConfigurationObjects.FileSelection;
import ink3d.ConfigurationObjects.PrintJobSelection;
import ink3d.ConfigurationObjects.SubsetSelection;
import java.io.File;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author daniellain
 */
public class GetPrintJobSelectionCommandTest {
    PrintJobSelection expected;
    PrintJobSelection actual;
    String name = "GetPrintJobSelectionTest";
    String path = "./Database/PrintJobs/";
    
    @Before
    public void setup(){
        SubsetSelection subset1 = new SubsetSelection();
        subset1.setBottomZ(0);
        subset1.setPrintConfiguration(name+".Sub1.Print");
        subset1.setTopZ(1);
        subset1.getFileConfigurations().add(new FileSelection("file1", "extruder1"));
        subset1.getFileConfigurations().add(new FileSelection("file2", "extruder2"));
        subset1.getFileConfigurations().add(new FileSelection("file3", "extruder3"));
        
        SubsetSelection subset2 = new SubsetSelection();
        subset2.setBottomZ(1);
        subset2.setPrintConfiguration(name+".Sub2.Print");
        subset2.setTopZ(2);
        
        subset2.getFileConfigurations().add(new FileSelection("file1", "extruder2"));
        subset2.getFileConfigurations().add(new FileSelection("file2", "extruder3"));
        subset2.getFileConfigurations().add(new FileSelection("file3", "extruder4"));
        
        expected = new PrintJobSelection();
        expected.setName(name);
        expected.setPrinterConfiguration(name+".printer");
        expected.getMaterials().add(new ExtruderMaterialSelection("extruder 1", "material 1"));
        expected.getMaterials().add(new ExtruderMaterialSelection("extruder 2", "material 1"));
        expected.getMaterials().add(new ExtruderMaterialSelection("extruder 3", "material 2"));
        expected.getSubsetConfigurationList().add(subset1);
        expected.getSubsetConfigurationList().add(subset2);
        
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
                    "            <file>extruder1</file>\n" +
                    "            <extruder>file1</extruder>\n" +
                    "        </fileSelection>\n" +
                    "        <fileSelection>\n" +
                    "            <file>extruder2</file>\n" +
                    "            <extruder>file2</extruder>\n" +
                    "        </fileSelection>\n" +
                    "        <fileSelection>\n" +
                    "            <file>extruder3</file>\n" +
                    "            <extruder>file3</extruder>\n" +
                    "        </fileSelection>\n" +
                    "    </subsetSelection>\n" +
                    "    <subsetSelection>\n" +
                    "        <bottomZ>1.0</bottomZ>\n" +
                    "        <topZ>2.0</topZ>\n" +
                    "        <printConfiguration>GetPrintJobSelectionTest.Sub2.Print</printConfiguration>\n" +
                    "        <fileSelection>\n" +
                    "            <file>extruder2</file>\n" +
                    "            <extruder>file1</extruder>\n" +
                    "        </fileSelection>\n" +
                    "        <fileSelection>\n" +
                    "            <file>extruder3</file>\n" +
                    "            <extruder>file2</extruder>\n" +
                    "        </fileSelection>\n" +
                    "        <fileSelection>\n" +
                    "            <file>extruder4</file>\n" +
                    "            <extruder>file3</extruder>\n" +
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
    }
    
    @After
    public void tearDown() {
        File file = new File(path+name+".xml");
        file.delete();
    }
    
    @Test
    public void GetPrintJobSelectionTest() {
        GetPrintJobSelectionCommand instance = new GetPrintJobSelectionCommand(name);
        instance.execute();
        actual = (PrintJobSelection)instance.getResult();
        assertTrue(expected.equals(actual));
    }
}
