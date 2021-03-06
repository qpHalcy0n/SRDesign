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
    private static int updateDelay                  = 100;
    private static TXRX commsObject                 = null;
    private static boolean isMonitoring             = true;
    
    public PrinterFeedbackImpl()
    {

    }
    
    public PrinterFeedbackImpl(PrintJobConfiguration printJobConfig)
    {
        pjc = printJobConfig;
    }
    
    public PrinterFeedbackImpl(int delay)
    {
        if(delay <= 0 || delay > 4000)
            return;
        
        updateDelay = delay;
    }
    
    @Override
    public void setCommsObject(TXRX c)
    {
        commsObject = c;
    }
    
    @Override
    public void setUpdateDelay(int delay)
    {
        if(delay <= 0 || delay > 4000)
            return;
       
        updateDelay = delay;
    }
    
    @Override
    public void stopMonitoring()
    {
        isMonitoring = false;
    }
    
    @Override
    public void beginMonitoring()
    {
        start();
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
                    sleep(updateDelay);
                }
            
                catch(InterruptedException ex)
                {
                    System.err.println("Error in Printer Feedback: Thread sleep error");
                }
            }
            
            ArrayList<FeedbackObject> feedback = commsObject.getPrinterFeedback();
            ArrayList<String> lastGcodes = commsObject.getLastGcodesSent();
            ArrayList<TemperatureObject> temps = new ArrayList<>();
            
            for(int i = 0; i < feedback.size(); ++i)
                for(int j = 0; j < feedback.get(i).getToolTemps().size(); ++j)
                    temps.add(feedback.get(i).getToolTemps().get(j));
            
            pjc.getPrinterStatusObject().setCurrentToolTemperatures(temps);
            pjc.getPrinterStatusObject().setLastGcodesExecuted(lastGcodes);    
        }
    }
}
