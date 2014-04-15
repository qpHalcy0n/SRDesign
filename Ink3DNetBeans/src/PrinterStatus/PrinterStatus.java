/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PrinterStatus;

import ink3d.PrinterFeedback.PrinterFeedback;
import java.util.ArrayList;

/**
 *
 * @author shawn_000
 */
public interface PrinterStatus 
{
    public void setGcodes(ArrayList<String> codes);
    
    public void setFailsafeGcodes(ArrayList<String> failsafe);
    
    public void setDispatchDelay(int delay);
}
