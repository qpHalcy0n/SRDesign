/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.PrinterFeedback;

import ink3d.Communications.TXRX;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author qpHalcy0n
 */
public class PrinterFeedbackImplTest {
    
    public PrinterFeedbackImplTest() {
    }

    /**
     * Test of setCommsObject method, of class PrinterFeedbackImpl.
     */
    @Test
    public void testSetCommsObject() {
        System.out.println("setCommsObject");
        TXRX c = null;
        PrinterFeedbackImpl instance = new PrinterFeedbackImpl();
        instance.setCommsObject(c);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setUpdateDelay method, of class PrinterFeedbackImpl.
     */
    @Test
    public void testSetUpdateDelay() {
        System.out.println("setUpdateDelay");
        int delay = 0;
        PrinterFeedbackImpl instance = new PrinterFeedbackImpl();
        instance.setUpdateDelay(delay);
        // TODO review the generated test code and remove the default call to fail.
 //       fail("The test case is a prototype.");
    }

    /**
     * Test of stopMonitoring method, of class PrinterFeedbackImpl.
     */
    @Test
    public void testStopMonitoring() {
        System.out.println("stopMonitoring");
        PrinterFeedbackImpl instance = new PrinterFeedbackImpl();
        instance.stopMonitoring();
        // TODO review the generated test code and remove the default call to fail.
 //       fail("The test case is a prototype.");
    }

    /**
     * Test of beginMonitoring method, of class PrinterFeedbackImpl.
     */
    @Test
    public void testBeginMonitoring() {
        System.out.println("beginMonitoring");
        PrinterFeedbackImpl instance = new PrinterFeedbackImpl();
        instance.beginMonitoring();
        // TODO review the generated test code and remove the default call to fail.
 //       fail("The test case is a prototype.");
    }
    
}
