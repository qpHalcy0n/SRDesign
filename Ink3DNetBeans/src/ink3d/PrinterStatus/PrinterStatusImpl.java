/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.PrinterStatus;

import ink3d.PrinterFeedback.*;
import ink3d.Communications.*;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author Shawn Simonson
 */
public class PrinterStatusImpl extends Thread implements PrinterStatus
{
    private static ArrayList<String> gCodes;
    private static ArrayList<String> failsafeGcodes;
    private static PrintJobConfiguration printJobConfig         = null;
    private static int dispatchDelay;
    private static TXRX commsObject                             = null;
    private static PrinterFeedbackImpl feedbackObject               = null;
    private static boolean isPaused                             = false;
    
    
    public PrinterStatusImpl(PrintJobConfiguration pjc)
    {
        dispatchDelay = 10;
        gCodes = new ArrayList<String>();
        failsafeGcodes = new ArrayList<String>();
        printJobConfig = pjc;
        
        
        
        // Build the G-codes from the file //
        if(printJobConfig.getFinalizedGCode() != null)
        {
            try
            {
                BufferedReader br = new BufferedReader(new FileReader(printJobConfig.getFinalizedGCode()));
                String line;
                while((line = br.readLine()) != null)
                    gCodes.add(line);
            }
            
            catch(Exception ex)
            {
                System.err.println(ex);
            }
        }                   
    }
    
    public void pausePrinting()
    {
        isPaused = true;
    }
    
    
    public void resumePrinting()
    {
        isPaused = false;
    }
    
    public void cancelPrinting()
    {
        interrupt();
    }
    
    public void setFailsafeGcodes(ArrayList<String> failsafe)
    {
        failsafeGcodes = failsafe;
    }
    
    public void setDispatchDelay(int delay)
    {
        if(delay <= 0 || delay >= 4000)
            dispatchDelay = 100;
        else
            dispatchDelay = delay;
    }
    
    public void go()
    {
        commsObject = new TXRXImpl(printJobConfig);
        if(commsObject.isConnected() == false)
            System.out.println("Error in Printer Status: Could not connect to printer");
        
        feedbackObject = new PrinterFeedbackImpl(printJobConfig); 
        feedbackObject.setCommsObject(commsObject);
        feedbackObject.beginMonitoring();

        
        start();
    }
    
    public boolean hasCommsObject()
    {
        if(commsObject == null)
            return false;
        return true;
    }
    
    public TXRX getCommsObject()
    {
        return commsObject;
    }
    
    @Override
    public void run()
    {
        try
        {
            while(gCodes.size() > 0)
            {
            
                while(printJobConfig.getPrinterStatusObject().hasCurrentToolTemperatures() == false)
                    Thread.currentThread().sleep(dispatchDelay);
            
                ArrayList<TemperatureObject> temps = printJobConfig.getPrinterStatusObject().getCurrentToolTemperatures();
                for(int i = 0; i < temps.size(); ++i)
                {
                    if(temps.get(i).getToolName().contentEquals("T"))
                    {
                        if(temps.get(i).getCurrentTemperature() > temps.get(i).getDesiredTemp())
                        {
                          // Do we want to execute some failsafe or just wait for the temp to cool off? //
//                        for(int j = 0; j < failsafeGcodes.size(); ++i)
//                            commsObject.sendGcode(failsafeGcodes.get(j));
                        
                        // Spin until we cool off
                            while(temps.get(i).getCurrentTemperature() > temps.get(i).getDesiredTemp())
                            {   
                                temps = printJobConfig.getPrinterStatusObject().getCurrentToolTemperatures();
                                Thread.currentThread().sleep(dispatchDelay);
                            }
                        }
                    }    
                }
            
            
                // Wait here if we're paused //
                while(isPaused)
                {
                    sleep(10);
                }
            
                commsObject.sendGcode(gCodes.get(0));
                gCodes.remove(0);
            }
        }
        
        catch(InterruptedException ex)
        {
            System.out.println(ex);
        }
    }
}
