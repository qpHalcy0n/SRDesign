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
    // Get list of COM port identifiers as strings
    public String[] getSerialPortNames();
    
    // Get printer feedback information
    public ArrayList<FeedbackObject> getPrinterFeedback();
    
    // Initialize connection to printer
    public boolean connectToPrinter(PrintJobConfiguration pjc);
    
    // Send G-Codes to printer to be printed
    public boolean sendGcode(PrintJobConfiguration pjc, String gCode);
    
    // Query whether printer feedback buffer has data
    public boolean isPrinterFeedbackReady();
    
    // Get the last g-codes sent to the printer successfully. //
    public ArrayList<String> getLastGcodesSent();
    
    // Serialize data (do processing on g-codes)
    public boolean serialize(PrintJobConfiguration pjc, String gCodeLine);
    
    // Deserialize data (process byte stream from printer)
    public boolean deserialize(String str); 
}
