/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.PrinterConfiguration;
import java.io.File;
import java.io.IOException;
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
        
        expected ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<printer>\n" +
                    "    <bedX>150.0</bedX>\n" +
                    "    <bedY>100.0</bedY>\n" +
                    "    <name>SaveTest</name>\n" +
                    "    <numExtruders>5</numExtruders>\n" +
                    "    <printCenterX>75.0</printCenterX>\n" +
                    "    <printCenterY>50.0</printCenterY>\n" +
                    "    <useRelativeEDistances>true</useRelativeEDistances>\n" +
                    "    <vibrationLimit>1.1</vibrationLimit>\n" +
                    "    <gCodeFlavor>rep-rap</gCodeFlavor>\n" +
                    "    <zOffset>1.34</zOffset>\n" +
                    "</printer>";
    }
    
    @After
    public void tearDown() {
        printer = null;
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
        SavePrinterConfigurationCommand instance = new SavePrinterConfigurationCommand(printer);
        instance.execute();
        assertTrue((Boolean)instance.getResult());
        actual = FileUtils.readFileToString(new File(path));
        
        for(int i=0; i < expected.length(); i++){
            assertTrue(expected.charAt(i) == actual.charAt(i));
        }
    }
    
}