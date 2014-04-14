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
//    public static ArrayList<String> gCodes      = new ArrayList<String>();
    public static String initFileName           = "init.gcode";
    public static int BAUD                      = 250000;
    public static int MAX_OUT_BUF_LEN           = 5;
    
    public static String comPort                = "COM1";
    

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
    
    public ArrayList<String> getLastGcodesSent();
    
    // Serialize data (do processing on g-codes)
    public boolean serialize(PrintJobConfiguration pjc, String gCodeLine);
    
    // Deserialize data (process byte stream from printer)
    public boolean deserialize(String str);
    
    class TemperatureObject
    {
        public TemperatureObject()
        {
            tool        = new String("");
            curTemp     = 0.0f;
            desiredTemp = 0.0f;
        }
        
        String tool;
        float  curTemp;
        float  desiredTemp;
    }
        
    class FeedbackObject
    {
        public FeedbackObject()
        {
            resendLine      = 0;
            toolTemps       = new ArrayList<TemperatureObject>();
            isFault         = false;
            isResend        = false;
            isACK           = false;
        }
        
        int                 resendLine;
        ArrayList<TemperatureObject> toolTemps;
        public boolean      isFault;
        public boolean      isResend;
        public boolean      isACK;
    }
}
