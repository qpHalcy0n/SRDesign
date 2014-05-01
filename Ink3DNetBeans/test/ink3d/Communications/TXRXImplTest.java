/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Communications;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author qpHalcy0n
 */
public class TXRXImplTest {
    
    public TXRXImplTest() {
    }

    /**
     * Test of getPrinterFeedback method, of class TXRXImpl.
     */
    @Test
    public void testGetPrinterFeedback() {
        System.out.println("getPrinterFeedback");
        TXRXImpl instance = new TXRXImpl();
        ArrayList<FeedbackObject> expResult = null;
        ArrayList<FeedbackObject> result = instance.getPrinterFeedback();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of isPrinterFeedbackReady method, of class TXRXImpl.
     */
    @Test
    public void testIsPrinterFeedbackReady() {
        System.out.println("isPrinterFeedbackReady");
        TXRXImpl instance = new TXRXImpl();
        boolean expResult = false;
        boolean result = instance.isPrinterFeedbackReady();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 //       fail("The test case is a prototype.");
    }

    /**
     * Test of isConnected method, of class TXRXImpl.
     */
    @Test
    public void testIsConnected() {
        System.out.println("isConnected");
        TXRXImpl instance = new TXRXImpl();
        boolean expResult = false;
        boolean result = instance.isConnected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastGcodesSent method, of class TXRXImpl.
     */
    @Test
    public void testGetLastGcodesSent() {
        System.out.println("getLastGcodesSent");
        TXRXImpl instance = new TXRXImpl();
        ArrayList<String> expResult = new ArrayList<String>();
        ArrayList<String> result = instance.getLastGcodesSent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 //       fail("The test case is a prototype.");
    }

    /**
     * Test of deserialize method, of class TXRXImpl.
     */
    @Test
    public void testDeserialize() {
        System.out.println("deserialize");
        String str = "";
        TXRXImpl instance = new TXRXImpl();
        boolean expResult = true;
        boolean result = instance.deserialize(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 //       fail("The test case is a prototype.");
    }
    
}
