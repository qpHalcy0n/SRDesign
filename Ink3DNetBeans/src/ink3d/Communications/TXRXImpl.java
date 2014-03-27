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
    public byte[] getPrinterFeedback()
    {
        return null;
    }
    
    public boolean connectToPrinter()
    {
        return true;
    }
    
    public boolean sendGcode()
    {
        return true;
    }
}
