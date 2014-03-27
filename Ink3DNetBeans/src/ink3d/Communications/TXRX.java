/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Communications;

import ink3d.ConfigurationObjects.PrintJobConfiguration;

/**
 *
 * @author Shawn Simonson
 */
public interface TXRX 
{
    public String[] getSerialPortNames();
    
    public byte[] getPrinterFeedback();
    
    public boolean connectToPrinter();
    
    public boolean sendGcode();
}
