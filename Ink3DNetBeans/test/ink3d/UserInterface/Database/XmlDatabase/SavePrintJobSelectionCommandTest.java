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
public class SavePrintJobSelectionCommandTest {
    PrintJobSelection printJob;
    String expected;

    @Before
    public void setUp() {       
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
        
        printJob = new PrintJobSelection();
        printJob.setName("SaveTest");
        printJob.setPrinterConfiguration("SaveTest.printer");
        printJob.getMaterials().add(new ExtruderMaterialSelection("extruder 1", "material 1"));
        printJob.getMaterials().add(new ExtruderMaterialSelection("extruder 2", "material 1"));
        printJob.getMaterials().add(new ExtruderMaterialSelection("extruder 3", "material 2"));
        printJob.getSubsetConfigurationList().add(subset1);
        printJob.getSubsetConfigurationList().add(subset2);
        
        expected ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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
                    "        <printConfiguration>SaveTest.Sub2.Print</printConfiguration>\n" +
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
    }
    
    @After
    public void tearDown() {
        printJob = null;
        File file = new File("./Database/PrintJobs/SaveTest.xml");
       file.delete();
    }

    /**
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void SavePrintJobTest() throws IOException {
        String actual;

        String path = "./Database/PrintJobs/"+printJob.getName()+".xml";
        SavePrintJobSelectionCommand instance = new SavePrintJobSelectionCommand(printJob);
        instance.execute();
        assertTrue((Boolean)instance.getResult());
        actual = FileUtils.readFileToString(new File(path));
        
        for(int i=0; i < expected.length(); i++){
            assertTrue(expected.charAt(i) == actual.charAt(i));
        }
    }
    
}
