/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.PrinterStatus;

import ink3d.PrinterFeedback.PrinterFeedback;
import ink3d.Communications.*;
import java.util.ArrayList;

/**
 *
 * @author shawn_000
 */
public interface PrinterStatus 
{
    public void setFailsafeGcodes(ArrayList<String> failsafe);
    
    public void setDispatchDelay(int delay);
    
    public TXRX getCommsObject();
    
    public boolean hasCommsObject();
    
    public void go();
    
    public void pausePrinting();
    
    public void resumePrinting();
    
    public void cancelPrinting();
}
