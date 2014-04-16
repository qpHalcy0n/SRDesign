/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.PrinterFeedback;

import ink3d.Communications.*;
import ink3d.PrinterStatus.*;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import java.util.ArrayList;

/**
 *
 * @author shawn_000
 */
public class PrinterFeedbackImpl extends Thread implements PrinterFeedback
{
    private static PrintJobConfiguration pjc        = null;
    private static int updateDelay                  = 0;
    private static TXRX commsObject                 = null;
    private static boolean isMonitoring             = true;
    
    public PrinterFeedbackImpl()
    {
        updateDelay = 100;
    }
    
    public PrinterFeedbackImpl(PrintJobConfiguration printJobConfig)
    {
        updateDelay = 100;
        pjc = printJobConfig;
    }
    
    public PrinterFeedbackImpl(int delay)
    {
        if(delay <= 0 || delay > 4000)
            return;
        
        updateDelay = delay;
    }
    
    public void setCommsObject(TXRX c)
    {
        commsObject = c;
    }
    
    public void setUpdateDelay(int delay)
    {
        if(delay <= 0 || delay > 4000)
            return;
       
        updateDelay = delay;
    }
    
    public void stopMonitoring()
    {
        isMonitoring = false;
    }
    
    public void beginMonitoring()
    {
        Thread.currentThread().start();
    }
    
    @Override
    public void run()
    {
        while(isMonitoring)
        {
            while(commsObject.isPrinterFeedbackReady() == false)
            {
                try
                {
                    Thread.currentThread().sleep(updateDelay);
                }
            
                catch(InterruptedException ex)
                {
                    System.err.println("Error in Printer Feedback: Thread sleep error");
                }
            }
            
            ArrayList<FeedbackObject> feedback = commsObject.getPrinterFeedback();
            ArrayList<String> lastGcodes = commsObject.getLastGcodesSent();
            ArrayList<TemperatureObject> temps = new ArrayList<TemperatureObject>();
            
            for(int i = 0; i < feedback.size(); ++i)
                for(int j = 0; j < feedback.get(i).getToolTemps().size(); ++j)
                    temps.add(feedback.get(i).getToolTemps().get(j));
            
            pjc.getPrinterStatusObject().setCurrentToolTemperatures(temps);
            pjc.getPrinterStatusObject().setLastGcodesExecuted(lastGcodes);    
        }
    }
}
