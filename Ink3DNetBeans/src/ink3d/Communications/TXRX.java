/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Communications;

import ink3d.ConfigurationObjects.PrintJobConfiguration;
import java.util.ArrayList;

/**
 *
 * @author Shawn Simonson
 */
public interface TXRX
{
    // FIXME: Items here are contained in PrintJobConfiguration object. These are placeholders
    public static ArrayList<String> gCodes      = new ArrayList<String>();
    public static int BAUD                      = 250000;
    public static int MAX_OUT_BUF_LEN           = 5;
    
    public static String comPort                = "COM1";
    
    
    // Get list of COM port identifiers as strings
    public String[] getSerialPortNames();
    
    // Get printer feedback information
    public ArrayList<byte[]> getPrinterFeedback();
    
    // Initialize connection to printer
    public boolean connectToPrinter();
    
    // Send G-Codes to printer to be printed
    public boolean sendGcode();
    
    // Query whether printer feedback buffer has data
    public boolean isPrinterFeedbackReady();
    
    // Pass G-Codes from serialization into communications
    public boolean addGcode(ArrayList<String> ppGcode);
}
