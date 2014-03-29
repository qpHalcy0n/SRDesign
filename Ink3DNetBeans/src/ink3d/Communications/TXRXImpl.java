/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author shawn_000
 */
public class TXRXImpl implements TXRX 
{
    private static ArrayList<byte[]> printerFeedback    = new ArrayList<byte[]>();
    private static boolean isOutBufEmpty                = false;
    private static SerialPortList serialPortList;
    private static SerialPort serialPort;
    
    TXRXImpl()
    {
        serialPortList = new SerialPortList();
    }
    
    public String[] getSerialPortNames()
    {
        String[] portNames = serialPortList.getPortNames();
        return portNames;
    }
    
    // FIXME: Don't return null
    public ArrayList<byte[]> getPrinterFeedback()
    {
        if(!isPrinterFeedbackReady())
            return null;
        
        return printerFeedback;
    }
    
    public boolean isPrinterFeedbackReady()
    {
        if(printerFeedback.size() > 0)
            return true;
        return false;
    }
    
    public boolean addGcode(ArrayList<String> ppGcode)
    {
        if(ppGcode.size() <= 0)
            return false;
        
        for(int i = 0; i < ppGcode.size(); ++i)
        {
            // There may be some additional processing on G-Code here, so leave this open
            gCodes.add(ppGcode.get(i));
        }
        return true;
    }
    
    public boolean connectToPrinter()
    {
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
    
    
    class SerialPortReader implements SerialPortEventListener
    {
        public void serialEvent(SerialPortEvent event)
        {
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
            
            // Receiving buffer is empty...send out G-Codes
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
                    
                    int bufBytes    = event.getEventValue();
                    int nGCodes     = bufBytes / 128;
                    
                    if(nGCodes > gCodes.size())
                        nGCodes = gCodes.size();
                    
                    for(int i = 0; i < nGCodes; ++i)
                    {
                        // The index into the gCodes ArrayList will always be zero because we're removing
                        // at index 0 every time 
                        if(!serialPort.writeBytes(gCodes.get(0).toString().getBytes()))
                            break;
                        
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
