/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.Database.XmlDatabase;

import ink3d.ConfigurationObjects.PrinterConfiguration;
import java.io.File;
import java.io.PrintWriter;
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
public class GetPrinterConfigurationCommandTest {
    PrinterConfiguration expected;
    PrinterConfiguration actual;
    String name = "GetPrinterConfigurationTest";
    String path = "./Database/Printers/";
    
    @Before
    public void setup(){
        expected = new PrinterConfiguration();
        expected.setName(name);
        expected.setBedX(150);
        expected.setBedY(100);
        expected.setNumExtruders(5);
        expected.setPrintCenterX(75);
        expected.setPrintCenterY(50);
        expected.setUseRelativeEDistances(true);
        expected.setVibrationLimit(1.1);
        expected.setgCodeFlavor("rep-rap");
        expected.setzOffset(1.34);
        
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
    }
    
    @After
    public void tearDown() {
        File file = new File(path+name+".xml");
        file.delete();
    }
    
    @Test
    public void GetPrinterConfigurationTest() {
        GetPrinterConfigurationCommand instance = new GetPrinterConfigurationCommand(name);
        instance.execute();
        actual = (PrinterConfiguration)instance.getResult();
        if(!expected.equals(actual)) System.out.printf("Test "+this.getClass().getName()+" expected: "+ expected+"\nGot: "+actual);
        assertTrue(expected.equals(actual));
    }
}
