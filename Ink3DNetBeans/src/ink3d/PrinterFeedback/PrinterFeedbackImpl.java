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
public class PrinterFeedbackImpl extends Thread implements PrinterFeedback
{
    private static int updateDelay          = 0;
    
    public PrinterFeedbackImpl()
    {
        updateDelay = 100;
    }
    
    public PrinterFeedbackImpl(int delay)
    {
        if(delay <= 0 || delay > 4000)
            return;
        
        updateDelay = delay;
    }
    
    public void setUpdateDelay(int delay)
    {
        if(delay <= 0 || delay > 4000)
            return;
       
        updateDelay = delay;
    }
    
    @Override
    public void run()
    {
        // Need TXRX object instantiation //
        // Poll TXRX->getPrinterFeedback()
        // Call TXRX->getLastGcodesSent()
        // delay the thread by "updateDelay"
        // Populate PrinterStatusObject
    }
}
