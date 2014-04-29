/*
    01 April, 2014
    Transmit/Receive module developed for Team Ink3d 
    Developed for the RepRapRumba/Marlin firmware 3D printer
 */

package ink3d.Communications;

import ink3d.ConfigurationObjects.*;
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
    private static String initFileName                          = "init.gcode";
    private static int BAUD                                     = 115200;
    private static String comPort                               = "COM3";
    
    private static boolean isOutBufEmpty                        = false;                        // flag for output (to printer) buffer being empty
    private static SerialPortList serialPortList;                                               // Port listing
    private static SerialPort serialPort;                                                       // serial port object
    private static String feedbackString                        = new String("");
    private static String ackString                             = new String("");
    private static boolean handshakeReceived                    = false;
    private static ArrayList<String> lastGcodesSent             = new ArrayList<>();
    private static boolean ackSent                              = false;
    private static boolean initCodesSent                        = false;
    private static PrintJobConfiguration printJobConfig         = null;
    private static PrinterStatusObject pso                      = null;
    private static boolean isConnected                          = false;
    private Object lock                                         = new Object();
    
    public TXRXImpl()
    {
        serialPortList = new SerialPortList();
    }
    
    public TXRXImpl(PrintJobConfiguration pjc)
    {
        serialPortList = new SerialPortList();
        
        printJobConfig = pjc;
        pso = pjc.getPrinterStatusObject();
        comPort = printJobConfig.getPrinterConfiguration().getHardware().getComPort();
        BAUD = printJobConfig.getPrinterConfiguration().getHardware().getBaudRate();
        
        if(connectToPrinter() == false)
            System.err.println("TXRX error: Could not connect to printer");
    }
    
    @Override
    protected void finalize() throws Throwable
    {
        if(isConnected())
            serialPort.closePort();
        
        super.finalize();
    }
    
    /**
     * 
     * @return 'true' if the initialization codes were sent. 'false' otherwise
     */
    private boolean initCodesSent()
    {
        return initCodesSent;
    }
 
    /**
     * 
     * @return String[] packed with available serial ports
     */
    @Override
    public String[] getSerialPortNames()
    {
        String[] portNames = serialPortList.getPortNames();
        return portNames;
    }
    
    public void clearFeedbackString()
    {
        feedbackString = "";
    }
    
    /**
     * 
     * @return ArrayList<FeedbackObject> An array list packed with byte buffers of the latest data received from 
     * the printer
     */
    @Override
    public ArrayList<FeedbackObject> getPrinterFeedback()
    {
        ArrayList<FeedbackObject> feedbackArray = new ArrayList<>();
        ArrayList<TemperatureObject> allTemps = new ArrayList<>();
        String pfRet;
        
        // Check that feedback buffer is packed
        if(feedbackString.length() <= 0)
            return null;
        
        synchronized(lock)
        {
            // Copy printer feedback data and clear the current feedback string
            pfRet = new String(feedbackString);
        }
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
                    
                    try
                    {
                        float curTemp = Float.parseFloat(curTempStr);
                        float desiredTemp = Float.parseFloat(desiredTempStr);
                        TemperatureObject temp = new TemperatureObject();
                        temp.tool = toolName;
                        temp.curTemp = curTemp;
                        temp.desiredTemp = desiredTemp;
                        obj.toolTemps.add(temp);
                        
                        allTemps.add(temp);
                    }
                    
                    catch(NumberFormatException ex)
                    {
                        System.err.println("Error parsing temp");
                    }
                    
                    
                }
                
                // miscellaneous data is assumed to be resend line information //
                else 
                {
                    // Look for resend line //
//                    int resend = Integer.parseInt(lineObjects[j]);
//                    obj.resendLine = resend;
                }
            }
            
            feedbackArray.add(obj);
        }
        
        pso.setCurrentToolTemperatures(allTemps);
        
        return feedbackArray;
    }
    
    /**
     * 
     * @return boolean - indicating whether there is feedback data present
     */
    @Override
    public boolean isPrinterFeedbackReady()
    {
        synchronized(lock)
        {
            if(feedbackString.length() > 0)
                return true;
            return false;
        }
    }
    
    @Override
    public boolean isConnected()
    {
        return isConnected;
    }
    
    /**
     * 
     * @return boolean indicating whether the operation succeeded or failed
     */
    @Override
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
            int lineNo = Thread.currentThread().getStackTrace()[2].getLineNumber();
            System.out.println("Serial Port Exception in TXRXImpl line: " + lineNo + " " + ex);
            return false;
        }
        
        int mask = SerialPort.MASK_RXCHAR;
        try
        {
            System.out.println("Output buffer bytes: " + serialPort.getOutputBufferBytesCount());
            System.out.println("Input buffer bytes: " + serialPort.getInputBufferBytesCount());
            System.out.println("Connection opened: " + serialPort.isOpened());
            System.out.println("Port: " + serialPort.getPortName());
            
            if(!serialPort.setEventsMask(mask))
                return false;
            
            serialPort.addEventListener(new SerialPortReader());
            
            
            System.out.println("Waiting for handshake");
//            while(!handshakeReceived){}
            System.out.println("Handshake received");
            
            // FIXME: Sometimes the handshake happens too fast so just sleep for 4 seconds (this only happens once)
            try
            {
                Thread.sleep(10000);
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
                line = line + printJobConfig.getPrinterConfiguration().getHardware().getLineEnding();
                
                serialPort.writeBytes(line.getBytes());
            }
            
            initCodesSent = true;
        }
        
        catch(IOException ex)
        {
            int lineNo = Thread.currentThread().getStackTrace()[2].getLineNumber();
            System.err.println("IO Exception: TXRXImpl line: " + lineNo + " " + ex);
            System.err.println(ex);
        }
        
        catch(SerialPortException ex)
        {
            int lineNo = Thread.currentThread().getStackTrace()[2].getLineNumber();
            System.err.println("Serial Port Exception: TXRXImpl line: " + lineNo + " " + ex);
        }
        
        isConnected = true;
        return true;
    }

    
    
    /**
     * 
     * @return boolean indicating whether the object succeeded or failed
     * @param gCode - G-code to be sent to the printer
     */
    @Override
    public boolean sendGcode(String gCode)
    {
        if(!handshakeReceived || !initCodesSent)
            return false;
        
        if(gCode.equals("M105"))
            feedbackString = "";
        
        String send;
        if((send = serialize(gCode)) == null)
            return false;
        
        ackString = "";
        ackSent = false;
        
        try
        {
            serialPort.writeBytes(send.getBytes());
            
            // Spin in the loop until the ack is received by the printer
            // Some commands demand waiting (M109, M28, etc...).
            // Move commands usually ack immediately
            while(ackString.contains("ok") == false){}
            ackSent = true;
            
            synchronized(lock)
            {
                lastGcodesSent.add(send);
            }
            
            // Sleep: otherwise we end up clobbering the buffer and garbling g-codes
            // The OK message from the device is supposed to prevent this, but this proves to not be the case.
 //           try
 //           {
 //               Thread.sleep(50);
 //           }
 //           catch(InterruptedException ex)
 //           {
 //               System.err.println(ex);
 //           }
        }
        
        catch(SerialPortException ex)
        {
            int lineNo = Thread.currentThread().getStackTrace()[2].getLineNumber();
            System.err.println("Serial Port Exception in TXRXImpl line: " + lineNo + " " + ex);
        }

        return true;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public ArrayList<String> getLastGcodesSent()
    {
        ArrayList<String> gCodeList;
        
        synchronized(lock)
        {
            gCodeList = new ArrayList<>(lastGcodesSent);
        }
        lastGcodesSent.clear();
        return gCodeList;
    }
    
    /**
     * This was originally intended to be its own module. In reality, the method is so simple, small, 
     * and really just allows us to do any processing on g-codes that might need to happen based on the printer
     * firmware. Therefore it is a function. For marlin nothing needs to happen at this point.
     * @return boolean - success or failure of method
     * @param gCodeLine - string to serialize
     */
    @Override
    public String serialize(String gCodeLine)
    {
        // Just bail on comments or empty lines //
        if(gCodeLine.length() <= 0 || gCodeLine.charAt(0) == ';')
            return null;
        
        String ret = gCodeLine;
        
        // Strip comments after commands //
        if(ret.indexOf(';') != -1)
            ret = ret.substring(0, ret.indexOf(';') - 1);
        
        ret = ret + printJobConfig.getPrinterConfiguration().getHardware().getLineEnding();
        
        return ret;
    }
    
    /**
     * Same situation as serialize. In reality, this simply allows us to assemble the data into a readable type
     * Does nothing for marlin as of yet.
     * @return boolean - success or failure of method
     * @param str - string to deserialize
     */
    @Override
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
        @Override
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
                    
                    ackString += inBuffer;
                    synchronized(lock)
                    {
                        feedbackString += inBuffer;
                        if(feedbackString.contains("M301"))
                            handshakeReceived = true;
                    }
                    
                    // Just echo the printer feedback for now
                    System.out.println(inBuffer);
                }
                
                catch(SerialPortException ex)
                {
                    int lineNo = Thread.currentThread().getStackTrace()[2].getLineNumber();
                    System.err.println("Serial Port Exception in TXRXImpl line: " + lineNo + " " + ex);
                }
            }
        }
    }
}
