/*
    01 April, 2014
    Transmit/Receive module developed for Team Ink3d 
    Developed for the RepRapRumba/Marlin firmware 3D printer
 */

package ink3d.Communications;

import ink3d.ConfigurationObjects.PrintJobConfiguration;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author Shawn Simonson
 */
public class TXRXImpl implements TXRX 
{
    private static String initFileName           = "init.gcode";
    private static int BAUD                      = 250000;
    private static String comPort                = "COM1";
    
    private static boolean isOutBufEmpty                        = false;                        // flag for output (to printer) buffer being empty
    private static SerialPortList serialPortList;                                               // Port listing
    private static SerialPort serialPort;                                                       // serial port object
    private static String feedbackString                        = new String("begin:");
    private static String ackString                             = new String(" ");
    private static boolean handshakeReceived                    = false;
    private static String lastGcodeSent                         = new String();
    private static ArrayList<String> lastGcodesSent             = new ArrayList<String>();
    private static boolean ackSent                              = false;
    private static boolean initCodesSent                        = false;
    private static PrintJobConfiguration printJobConfig         = null;
    private static boolean isConnected                          = false;
    
    public TXRXImpl()
    {
        serialPortList = new SerialPortList();
    }
    
    public TXRXImpl(PrintJobConfiguration pjc)
    {
        serialPortList = new SerialPortList();
        
        printJobConfig = pjc;
        comPort = printJobConfig.getHardwareConfiguration().getComPort();
        BAUD = printJobConfig.getHardwareConfiguration().getBaudRate();
        
        if(connectToPrinter() == false)
            System.err.println("TXRX error: Could not connect to printer");
    }
    
    protected void finalize() throws Throwable
    {
        if(isConnected())
            serialPort.closePort();
        
        super.finalize();
    }
    
    private boolean initCodesSent()
    {
        return initCodesSent;
    }
 
    /**
     * 
     * @return String[] packed with available serial ports
     */
    public String[] getSerialPortNames()
    {
        String[] portNames = serialPortList.getPortNames();
        return portNames;
    }
    
    /**
     * 
     * @return ArrayList<byte[]> An array list packed with byte buffers of the latest data received from 
     * the printer
     */
    public ArrayList<FeedbackObject> getPrinterFeedback()
    {
        // Check that feedback buffer is packed
        if(!isPrinterFeedbackReady())
            return null;
        
        ArrayList<FeedbackObject> feedbackArray = new ArrayList<FeedbackObject>();
        
        // Copy printer feedback data and clear the current feedback string
        String pfRet = new String(feedbackString);
        feedbackString = "";
        
        deserialize(pfRet);
        
        // Split feedback into individual messages //
        String[] feedbackLines = pfRet.split("\n");
        for(int i = 0; i < feedbackLines.length; ++i)
        {
            FeedbackObject obj = new FeedbackObject();

            // Split message into tokens //
            String[] lineObjects = feedbackLines[i].split(" ");
            for(int j = 0; j < lineObjects.length; ++j)
            {
                if(lineObjects[j].contains("ok"))
                    obj.isACK = true;
                else if(lineObjects[j].contains("!!"))
                    obj.isFault = true;
                else if(lineObjects[j].contains("rs"))
                    obj.isResend = true;
                
                // The only message with a colon are temperature feedback messages //
                // They follow the form   "toolName:actualTemp/setTemp"
                else if(lineObjects[j].contains(":"))
                {
                    // find colon //
                    int colonPos = lineObjects[j].indexOf(':');
                    String toolName = lineObjects[j].substring(0, colonPos);
                    String curTempStr, desiredTempStr;
                    if(lineObjects[j].contains("/"))
                    {
                        curTempStr = lineObjects[j].substring(colonPos + 1, lineObjects[j].indexOf('/'));
                        desiredTempStr = lineObjects[j].substring(lineObjects[j].indexOf('/') + 1, lineObjects[j].length());
                    }
                    else
                    {
                        curTempStr = lineObjects[j].substring(colonPos + 1, lineObjects[j].length());
                        desiredTempStr = "0";
                    }
                   
                    float curTemp = Float.parseFloat(curTempStr);
                    float desiredTemp = Float.parseFloat(desiredTempStr);
                    TemperatureObject temp = new TemperatureObject();
                    temp.tool = toolName;
                    temp.curTemp = curTemp;
                    temp.desiredTemp = desiredTemp;
                    
                    obj.toolTemps.add(temp);
                }
                
                // miscellaneous data is assumed to be resend line information //
                else 
                {
                    // Look for resend line //
                    int resend = Integer.parseInt(lineObjects[j]);
                    obj.resendLine = resend;
                }
            }
            
            feedbackArray.add(obj);
        }
        
        return feedbackArray;
    }
    
    /**
     * 
     * @return boolean - indicating whether there is feedback data present
     */
    public boolean isPrinterFeedbackReady()
    {
        if(feedbackString.length() > 0)
            return true;
        return false;
    }
    
    public boolean isConnected()
    {
        return isConnected;
    }
    
    /**
     * 
     * @return boolean indicating whether the operation succeeded or failed
     */
    public boolean connectToPrinter()
    {  
        // Make new serial port object and attempt to open
        serialPort = new SerialPort(comPort);
        try
        {
            if(!serialPort.openPort())
                return false;
            
            if(!serialPort.setParams(BAUD, 8, 1, 0))
                return false;        
        }
        
        catch(SerialPortException ex)
        {
            System.out.println(ex);
            return false;
        }
        
        int mask = SerialPort.MASK_RXFLAG;
        try
        {
            if(!serialPort.setEventsMask(mask))
                return false;
            
            serialPort.addEventListener(new SerialPortReader());
            
            while(!handshakeReceived){}
            
            // FIXME: Sometimes the handshake happens too fast so just sleep for 4 seconds (this only happens once)
            try
            {
                Thread.sleep(4000);
            }
            catch(InterruptedException ex)
            {
                System.err.println(ex);
            }
            
            // send init gcodes //
            BufferedReader br = new BufferedReader(new FileReader(initFileName));
            String line;
            while((line = br.readLine()) != null)
            {
                if(line.length() <= 0 || line.charAt(0) == ';')
                    continue;
                
                if(line.indexOf(';') != -1)
                    line = line.substring(0, line.indexOf(';') - 1);
                line = line + printJobConfig.getHardwareConfiguration().getLineEnding();
                
                serialPort.writeBytes(line.getBytes());
            }
            
            initCodesSent = true;
        }
        
        catch(Exception ex)
        {
            System.err.println(ex);
        }
        
        isConnected = true;
        return true;
    }

    
    
    /**
     * 
     * @return boolean indicating whether the object succeeded or failed
     */
    public boolean sendGcode(String gCode)
    {
        if(!handshakeReceived || !initCodesSent)
            return false;
        
        serialize(gCode);
        
        ackString = "";
        ackSent = false;
        
        try
        {
            serialPort.writeBytes(gCode.getBytes());
            
            // Spin in the loop until the ack is received by the printer
            // Some commands demand waiting (M109, M28, etc...).
            // Move commands usually ack immediately
            while(ackString.contains("ok") == false){}
            ackSent = true;
            lastGcodeSent = gCode;
            lastGcodesSent.add(gCode);
            
            // Sleep: otherwise we end up clobbering the buffer and garbling g-codes
            // The OK message from the device is supposed to prevent this, but this proves to not be the case.
            try
            {
                Thread.sleep(50);
            }
            catch(InterruptedException ex)
            {
                System.err.println(ex);
            }
        }
        
        catch(SerialPortException ex)
        {
            System.err.println(ex);
        }

        return true;
    }
    
    public ArrayList<String> getLastGcodesSent()
    {
        ArrayList<String> gCodeList = new ArrayList<String>(lastGcodesSent);
        lastGcodesSent.clear();
        return gCodeList;
    }
    
    /**
     * This was originally intended to be its own module. In reality, the method is so simple, small, 
     * and really just allows us to do any processing on g-codes that might need to happen based on the printer
     * firmware. Therefore it is a function. For marlin nothing needs to happen at this point.
     * @return boolean - success or failure of method
     */
    public boolean serialize(String gCodeLine)
    {
        // Just bail on comments or empty lines //
        if(gCodeLine.length() <= 0 || gCodeLine.charAt(0) == ';')
            return false;
        
        // Strip comments after commands //
        if(gCodeLine.indexOf(';') != -1)
            gCodeLine = gCodeLine.substring(0, gCodeLine.indexOf(';') - 1);
        
        gCodeLine = gCodeLine + printJobConfig.getHardwareConfiguration().getLineEnding();
        
        return true;
    }
    
    /**
     * Same situation as serialize. In reality, this simply allows us to assemble the data into a readable type
     * Does nothing for marlin as of yet.
     * @return boolean - success or failure of method
     */
    public boolean deserialize(String str)
    {
        return true;
    }

    
    /**
     * SerialPortReader defines the actions to be taken when the receive buffer becomes full
     * and when the transmit buffer becomes empty
     * 
     * This is where the sending and receipt of data actually happens
     */
    class SerialPortReader implements SerialPortEventListener
    {
        public void serialEvent(SerialPortEvent event)
        {
            // Receive buffer is available //
            if(event.isRXCHAR())
            {
                try
                {
                    // getEventValue returns size of buffer on RXCHAR event //
                    byte buffer[]   = serialPort.readBytes(event.getEventValue());
                    String inBuffer = new String(buffer);
                    
                    feedbackString += inBuffer;
                    ackString += inBuffer;
                    
                    if(feedbackString.contains("M301"))
                        handshakeReceived = true;
                    
                    // Just echo the printer feedback for now
                    System.out.println(inBuffer);
                }
                
                catch(Exception ex)
                {
                    System.err.println(ex);
                }
            }
        }
    }
}
