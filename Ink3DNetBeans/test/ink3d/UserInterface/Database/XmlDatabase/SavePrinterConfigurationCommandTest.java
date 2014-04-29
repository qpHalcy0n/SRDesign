/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.PrinterConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daniellain
 */
public class SavePrinterConfigurationCommandTest {
    PrinterConfiguration printer;
    String expected;

    @Before
    public void setUp() {       
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
        
        expected ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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
                    "    <bedTemp>0</bedTemp>\n" +
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
    }
    
    @After
    public void tearDown() {
        printer = null;
        System.gc();
        File file = new File("./Database/Printers/SaveTest.xml");
        file.delete();
    }

    /**
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void SavePrinterTest() throws IOException {
        String actual;

        String path = "./Database/Printers/"+printer.getName()+".xml";
        File fileToCheck;
        SavePrinterConfigurationCommand instance = new SavePrinterConfigurationCommand(printer);
        instance.execute();
        assertTrue((Boolean)instance.getResult());
        fileToCheck = new File(path);
        actual = FileUtils.readFileToString(fileToCheck);
        actual = actual.substring(0, actual.length()-1);
        if(!expected.equals(actual)) System.out.printf("Test "+this.getClass().getName()+" expected: "+ expected+"\nGot: "+actual);
        assertTrue(expected.equals(actual));
        fileToCheck = null;
    }
    
}
