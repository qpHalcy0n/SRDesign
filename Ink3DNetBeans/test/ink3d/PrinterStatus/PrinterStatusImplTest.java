/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.PrinterStatus;

import ink3d.Communications.TXRX;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author qpHalcy0n
 */
public class PrinterStatusImplTest {
    
    public PrinterStatusImplTest() {
        
    }

    /**
     * Test of pausePrinting method, of class PrinterStatusImpl.
     */
    @Test
    public void testPausePrinting() {
        System.out.println("pausePrinting");
        PrinterStatusImpl instance = null;
        instance.pausePrinting();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resumePrinting method, of class PrinterStatusImpl.
     */
    @Test
    public void testResumePrinting() {
        System.out.println("resumePrinting");
        PrinterStatusImpl instance = null;
        instance.resumePrinting();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelPrinting method, of class PrinterStatusImpl.
     */
    @Test
    public void testCancelPrinting() {
        System.out.println("cancelPrinting");
        PrinterStatusImpl instance = null;
        instance.cancelPrinting();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFailsafeGcodes method, of class PrinterStatusImpl.
     */
    @Test
    public void testSetFailsafeGcodes() {
        System.out.println("setFailsafeGcodes");
        ArrayList<String> failsafe = null;
        PrinterStatusImpl instance = null;
        instance.setFailsafeGcodes(failsafe);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDispatchDelay method, of class PrinterStatusImpl.
     */
    @Test
    public void testSetDispatchDelay() {
        System.out.println("setDispatchDelay");
        int delay = 0;
        PrinterStatusImpl instance = null;
        instance.setDispatchDelay(delay);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of go method, of class PrinterStatusImpl.
     */
    @Test
    public void testGo() {
        System.out.println("go");
        PrinterStatusImpl instance = null;
        instance.go();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasCommsObject method, of class PrinterStatusImpl.
     */
    @Test
    public void testHasCommsObject() {
        System.out.println("hasCommsObject");
        PrinterStatusImpl instance = null;
        boolean expResult = false;
        boolean result = instance.hasCommsObject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCommsObject method, of class PrinterStatusImpl.
     */
    @Test
    public void testGetCommsObject() {
        System.out.println("getCommsObject");
        PrinterStatusImpl instance = null;
        TXRX expResult = null;
        TXRX result = instance.getCommsObject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class PrinterStatusImpl.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        PrinterStatusImpl instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
