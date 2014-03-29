/*
    01 April, 2014
    Transmit/Receive module developed for Team Ink3d 
    Developed for the RepRapRumba/Marlin firmware 3D printer
 */

package ink3d.Communications;

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
    private static ArrayList<byte[]> printerFeedback    = new ArrayList<byte[]>();  // Printer feedback data
    private static boolean isOutBufEmpty                = false;                    // flag for output (to printer) buffer being empty
    private static SerialPortList serialPortList;                                   // Port listing
    private static SerialPort serialPort;                                           // serial port object
    
    TXRXImpl()
    {
        serialPortList = new SerialPortList();
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
    
    // FIXME: Don't return null
    /**
     * 
     * @return ArrayList<byte[]> An array list packed with byte buffers of the latest data received from 
     * the printer
     */
    public ArrayList<byte[]> getPrinterFeedback()
    {
        // Check that feedback buffer is packed
        if(!isPrinterFeedbackReady())
            return null;
        
        // Copy printer feedback data and clear the current buffer
        ArrayList<byte[]> pfRet = printerFeedback;
        printerFeedback.clear();
        return pfRet;
    }
    
    /**
     * 
     * @return boolean - indicating whether there is feedback data present
     */
    public boolean isPrinterFeedbackReady()
    {
        if(printerFeedback.size() > 0)
            return true;
        return false;
    }
    
    /**
     * 
     * @param ppGcode - serialized G-Codes
     * @return boolean indicating whether the operation succeeded or failed
     */
    public boolean addGcode(ArrayList<String> ppGcode)
    {
        // Sanity check
        if(ppGcode.size() <= 0)
            return false;
        
        for(int i = 0; i < ppGcode.size(); ++i)
        {
            // There may be some additional processing on G-Code here, so leave this open
            gCodes.add(ppGcode.get(i));
        }
        return true;
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
        
        return true;
    }
    
    /**
     * 
     * @return boolean indicating whether the object succeeded or failed
     */
    public boolean sendGcode()
    {
        int mask = SerialPort.MASK_RXFLAG + SerialPort.MASK_TXEMPTY;
        
        try
        {
            if(!serialPort.setEventsMask(mask))
                return false;
            
            serialPort.addEventListener(new SerialPortReader());
            
            while(!isOutBufEmpty){}
            
            if(!serialPort.removeEventListener())
                return false;
            if(!serialPort.closePort())
                return false;
        }
        
        catch(SerialPortException e)
        {
            System.out.println(e);
            return false;
        }
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
                    
                    printerFeedback.add(buffer);
                    
                    // Just echo the printer feedback for now
                    System.out.println(inBuffer);
                }
                
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
            
            // transmission buffer is empty...send out G-Codes
            if(event.isTXEMPTY())
            {
                try
                {
                    // Sanity check //
                    if(gCodes.size() <= 0)
                    {
                        isOutBufEmpty = true;
                        return;
                    }
                    
                    // G-codes are 128B long at most.
                    // Ring buffer in Marlin is 5x128B
                    // May require modification
                    int bufBytes    = event.getEventValue();
                    int nGCodes     = bufBytes / 128;
                    
                    // Send only as many as we have
                    if(nGCodes > gCodes.size())
                        nGCodes = gCodes.size();
                    
                    for(int i = 0; i < nGCodes; ++i)
                    {
                        // The index into the gCodes ArrayList will always be zero because we're removing
                        // at index 0 every time 
                        if(!serialPort.writeBytes(gCodes.get(0).toString().getBytes()))
                            break;
                        
                        // Pull g-codes successfully sent from front of list
                        gCodes.remove(0);
                    }
                }
                
                catch(Exception ex)
                {
                    System.out.println(ex); 
                }
            }
        }
    }
}
