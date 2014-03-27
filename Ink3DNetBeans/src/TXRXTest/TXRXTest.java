/*
    ink3D - TX/RX test module (3/15/14)
    Shawn Simonson
 */

package TXRXTest;

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
public class TXRXTest 
{
    private static SerialPortList serialPortList;
    private static SerialPort serialPort;
    private static String fileName                  = "test-cube.gcode";
    private static int MAX_BUF_LEN                  = 5;
    private static int BAUD_RATE                    = 250000;
    
    private boolean isEmpty                         = false;
    private ArrayList gCodes                        = new ArrayList();
    
    
    public TXRXTest()
    {
        serialPortList = new SerialPortList();
    }
    
    public static String[] getPortNames()
    {
        String[] portNames = serialPortList.getPortNames();
        return portNames;
    }
    /**
     * @param args the command line arguments
     */
    public void main(String[] args) 
    {
        String[] serialPorts = getPortNames();
        if(serialPorts.length <= 0)
        {
            System.out.println("No serial ports reported. Exiting");
            return;
        }
        
        // Diagnostic: Dump serial ports
        for(int i = 0; i < serialPorts.length; i++)
            System.out.println(serialPorts[i]);
        
        // Read g-codes //
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = br.readLine()) != null)
                gCodes.add(line);
        }
        
        catch(Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        
        
        // Open serial port //
        serialPort = new SerialPort("COM2");
        try
        {
            System.out.println("Port Opened: " + serialPort.openPort());
            System.out.println("Params set: " + serialPort.setParams(BAUD_RATE, 8, 1, 0));
            System.out.println("Output Buffer Bytes: " + serialPort.getOutputBufferBytesCount());
            System.out.println("Input Buffer Bytes: " + serialPort.getInputBufferBytesCount());
            
            int mask = SerialPort.MASK_RXCHAR + SerialPort.MASK_TXEMPTY;
            serialPort.setEventsMask(mask);
            serialPort.addEventListener(new SerialPortReader());
            
            // Sit and spin until all g-codes are sent //
            // Callback will raise empty flag, this loop will kick out and remove listeners and close port //
            while(!isEmpty)
            {
            }
            
            serialPort.removeEventListener();
            System.out.println("Port closed:" + serialPort.closePort());
        }
        
        catch(SerialPortException ex)
        {
            System.out.println(ex);
        }
    }
    
    
    // Callback for RXCHAR/TXEMPTY events //
    // Will read entire input buffer contents and spit them out to console //
    // Gives us an idea of what feedback we can expect //
    
    // Fills printer buffer on TXEMPTY event //
    // Raises g-code empty flag when g-codes are exhausted //
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
                        isEmpty = true;
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
