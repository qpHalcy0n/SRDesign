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
public class GetPrinterConfigurationsCommandTest {
    PrinterConfiguration printer;
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
            writer = new PrintWriter("./Database/Printers/Trash.txt", "UTF-8");
            writer.println("Text");
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(GetPrinterConfigurationsCommandTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SavePrinterConfigurationCommand save;
        
        printer = new PrinterConfiguration();
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
        
        expected = new ArrayList<>();
        expected.add("GetPrintersTest1");
        expected.add("GetPrintersTest2");
        expected.add("GetPrintersTest3");
        expected.add("GetPrintersTest4");
    }
    
    @After
    public void tearDown() {
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
     * Test of execute method, of class SaveExtruderConfigurationCommand.
     */
    @Test
    public void GetPrinterConfigurationsTest() throws IOException {
        GetPrinterConfigurationsCommand instance = new GetPrinterConfigurationsCommand();
        instance.execute();
        actual = (ArrayList<String>)instance.getResult();
        if(!expected.equals(actual)) System.out.printf("Test "+this.getClass().getName()+" \nexpected: "+ expected+"\nGot:      "+actual);
        assertTrue(expected.equals(actual));
    }
    
}
