/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrinterConfig;

import ink3d.Communications.TXRX;
import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.PrinterConfiguration;
import ink3d.UserInterface.Database.PersistenceFramework;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author time9_000
 */
public class PrinterControllerTest {

    private PersistenceFramework db;
    private String PRINTER_CONFIG_DIR = (new File("").getAbsolutePath()) + "/Database/Printers/";
    
    @Before
    public void setUp() {
        db = PersistenceFramework.getDB();
    }

    /**
     * Test of getPrinterConfigurations method, of class PrinterController.
     */
    @Test
    public void testGetPrinterConfigurations() {
        System.out.println("getPrinterConfigurations");
        PrinterController instance = new PrinterController();
        ArrayList<String> expResult = db.getPrinterConfigurations();
        ArrayList<String> result = instance.getPrinterConfigurations();
        assertEquals(expResult, result);
    }

    /**
     * Test of deletePrinterConfiguration method, of class PrinterController.
     */
    @Test
    public void testDeletePrinterConfiguration() throws Exception {
        System.out.println("deletePrinterConfiguration");
        String name = "Printer Controller Delete Test";
        PrinterController instance = new PrinterController();
        PrinterConfiguration printer = new PrinterConfiguration();
        printer.setName(name);
        db.savePrinterConfiguration(printer);

        // wait for file to delete (probably need to fix this in the database code)
        Thread.currentThread().sleep(2000);

        Boolean result = instance.deletePrinterConfiguration(name);
        assertTrue(result);
    }

    /**
     * Test of loadExtruderList method, of class PrinterController.
     */
    @Test
    public void testLoadExtruderList() {
        System.out.println("loadExtruderList");
        PrinterController instance = new PrinterController();
        ArrayList<String> result = instance.loadExtruderList();
        ArrayList<String> expResult = db.getExtruderConfigurations();
        assertEquals(expResult, result);
    }

    /**
     * Test of loadMyExtruders method, of class PrinterController.
     */
    @Test
    public void testLoadMyExtruders() {
        System.out.println("loadMyExtruders");
        String name = "Printer Controller Load My Extruder Test";
        PrinterController instance = new PrinterController();
        PrinterConfiguration printer = new PrinterConfiguration();
        printer.setName(name);
        ExtruderConfiguration extruder = new ExtruderConfiguration();
        extruder.setName(name);
        db.saveExtruderConfiguration(extruder);
        ArrayList<ExtruderConfiguration> extruders = new ArrayList<>();
        extruders.add(extruder);
        printer.setExtruderList(extruders);
        db.savePrinterConfiguration(printer);

        ArrayList<String> result = instance.loadMyExtruders(name);
        assertNotNull(result);

        // clean up
        db.deleteExtruderConfiguration(name);
        db.deletePrinterConfiguration(name);
    }

    /**
     * Test of getSerialPortEnumeration method, of class PrinterController.
     */
    @Test
    public void testGetSerialPortEnumeration() {
        System.out.println("getSerialPortEnumeration");
        PrinterController instance = new PrinterController();
        String[] expResult = TXRX.txrx.getSerialPortNames();
        String[] result = instance.getSerialPortEnumeration();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of loadPrinterConfiguration method, of class PrinterController.
     */
    @Test
    public void testLoadPrinterConfiguration() throws Exception {
        System.out.println("loadPrinterConfiguration");
        String name = "Printer Controller Load Test";
        PrinterConfiguration printer = new PrinterConfiguration();
        printer.setName(name);
        db.savePrinterConfiguration(printer);
        PrinterController instance = new PrinterController();
        ArrayList<String> result = instance.loadPrinterConfiguration(name);
        assertNotNull(result);
        assertTrue(result.size() > 0);

        // clean up
        db.deletePrinterConfiguration(name);
    }

    /**
     * Test of savePrinterConfiguratoin method, of class PrinterController.
     */
    @Test
    public void testSavePrinterConfiguratoin() throws Exception {
        System.out.println("savePrinterConfiguratoin");
        String name = "Printer Controller Save Test";
        PrinterConfiguration printer = new PrinterConfiguration();
        printer.setName(name);
        printer.setNumExtruders(1);
        ExtruderConfiguration extruder = new ExtruderConfiguration();
        extruder.setName(name);
        db.saveExtruderConfiguration(extruder);
        ArrayList<String> extruderList = new ArrayList<>();
        extruderList.add(name);
        
        ArrayList<String> varList = new ArrayList<>();
        varList.add(name);
        varList.add(Double.toString(printer.getBedX()));
        varList.add(Double.toString(printer.getBedY()));
        varList.add(Double.toString(printer.getPrintCenterX()));
        varList.add(Double.toString(printer.getPrintCenterY()));
        varList.add(Double.toString(printer.getzOffset()));
        varList.add(printer.getgCodeFlavor());
        varList.add(Boolean.toString(printer.getUseRelativeEDistances()));
        varList.add(Integer.toString(printer.getNumExtruders()));
        varList.add(Double.toString(printer.getVibrationLimit()));
        varList.add(Boolean.toString(printer.getUseFirmwareRetraction()));
        varList.add(printer.getStartGCode());
        varList.add(printer.getEndGCode());
        varList.add(printer.getHardware().getComPort());
        varList.add(Integer.toString(printer.getHardware().getBaudRate()));
        varList.add(Integer.toString(printer.getHardware().getLineEnd()));
        varList.add(Integer.toString(printer.getBedTempFirstLayer()));
        varList.add(Integer.toString(printer.getBedTemp()));

        PrinterController instance = new PrinterController();
        Boolean result = instance.savePrinterConfiguratoin(varList, extruderList);
        assertTrue(result);

        db.deleteExtruderConfiguration(name);
        db.deletePrinterConfiguration(name);
    }
    
}
