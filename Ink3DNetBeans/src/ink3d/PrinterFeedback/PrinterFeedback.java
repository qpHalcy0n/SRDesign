/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.PrinterFeedback;

import ink3d.Communications.TXRX;

/**
 *
 * @author shawn_000
 */
public interface PrinterFeedback 
{
    public void setUpdateDelay(int delay);
    
    public void setCommsObject(TXRX c);
    
    public void stopMonitoring();
    
    public void beginMonitoring();
}
