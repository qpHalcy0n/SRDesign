/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrinterConfig;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.PrinterConfiguration;
import ink3d.UserInterface.Database.PersistenceFramework;
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
    
    @Before
    public void setUp() {
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
        String[] expResult = null;
        String[] result = instance.getSerialPortEnumeration();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadPrinterConfiguration method, of class PrinterController.
     */
    @Test
    public void testLoadPrinterConfiguration() throws Exception {
        System.out.println("loadPrinterConfiguration");
        String name = "";
        PrinterController instance = new PrinterController();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.loadPrinterConfiguration(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savePrinterConfiguratoin method, of class PrinterController.
     */
    @Test
    public void testSavePrinterConfiguratoin() throws Exception {
        System.out.println("savePrinterConfiguratoin");
        ArrayList<String> vars = null;
        ArrayList<String> extruderList = null;
        PrinterController instance = new PrinterController();
        Boolean expResult = null;
        Boolean result = instance.savePrinterConfiguratoin(vars, extruderList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
