/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.PrinterStatus;

import ink3d.PrinterFeedback.*;
import ink3d.Communications.*;
import ink3d.ConfigurationObjects.*;
import ink3d.UserInterface.Status.*;
import java.util.ArrayList;
import java.io.*;


/**
 *
 * @author Shawn Simonson
 */
public class PrinterStatusImpl implements PrinterStatus
{
    private static ArrayList<String> gCodes;
    private static ArrayList<String> failsafeGcodes;
    private static PrintJobConfiguration printJobConfig         = null;
    private static int dispatchDelay                            = 20;
    private static TXRXImpl commsObject                         = null;
    private static PrinterFeedbackImpl feedbackObject           = null;
    private static boolean isPaused                             = false;
    private static StatusController statusController            = null;
    
    public PrinterStatusImpl(PrintJobConfiguration pjc)
    {
        dispatchDelay = 10;
        gCodes = new ArrayList<>();
        failsafeGcodes = new ArrayList<>();
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
            
            catch(IOException ex)
            {
                System.err.println(ex);
            }
        }                   
    }
    
    public PrinterStatusImpl(PrintJobConfiguration pjc, StatusController sc)
    {
        statusController = sc;
        
        dispatchDelay = 10;
        gCodes = new ArrayList<>();
        failsafeGcodes = new ArrayList<>();
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
            
            catch(IOException ex)
            {
                System.err.println(ex);
            }
        }  
    }
    
    @Override
    public void pausePrinting()
    {
        isPaused = true;
    }
    
    @Override
    public void resumePrinting()
    {
        isPaused = false;
    }
    
    @Override
    public void cancelPrinting()
    {
       // interrupt();
    }
    
    @Override
    public void setFailsafeGcodes(ArrayList<String> failsafe)
    {
        failsafeGcodes = failsafe;
    }
    
    @Override
    public void setDispatchDelay(int delay)
    {
        if(delay <= 0 || delay >= 4000)
            dispatchDelay = 100;
        else
            dispatchDelay = delay;
    }
    
    @Override
    public void go()
    {
    //    start();
        try
        {
            commsObject = new TXRXImpl(printJobConfig);
            if(commsObject.isConnected() == false)
                System.out.println("Error in Printer Status: Could not connect to printer");
        
 //           feedbackObject = new PrinterFeedbackImpl(printJobConfig); 
 //           feedbackObject.setCommsObject(commsObject);
 //           feedbackObject.beginMonitoring();

            PrinterStatusObject pso = printJobConfig.getPrinterStatusObject();
            
            boolean once = true;
            int iter = 0;
            while(gCodes.size() > 0)
            {
                System.err.println("Iteration: " + iter);
                
                while(pso.hasCurrentToolTemperatures() == false)
                {
                    // Ask for the current temperatures //
                    if(once)
                    {
                        commsObject.clearFeedbackString();
                        once = false;
                    }
                    commsObject.sendGcode("M105");
                    ArrayList<FeedbackObject> fbo = commsObject.getPrinterFeedback();
                    Thread.sleep(dispatchDelay);
                }
            
                ArrayList<TemperatureObject> temps = pso.getCurrentToolTemperatures();
                statusController.updateTemperatures(temps);
                for(int i = 0; i < temps.size(); ++i)
                {
                    if(temps.get(i).getToolName().contentEquals("T"))
                    {
                        // TODO: FIX THIS: desired temps for initial run
//                        if(temps.get(i).getCurrentTemperature() > temps.get(i).getDesiredTemp())
                        if(temps.get(i).getCurrentTemperature() > 210.0)
                        {
                            while(temps.get(i).getCurrentTemperature() > 210.0)
                            {   
                                temps = printJobConfig.getPrinterStatusObject().getCurrentToolTemperatures();
                                commsObject.sendGcode("M105");
                                Thread.sleep(dispatchDelay);
                            }
                        }
                    }    
                }
            
            
                // Wait here if we're paused //
                while(isPaused)
                {
//                    sleep(dispatchDelay);
                }
            
                // Execute next g-code and remove it //
                System.err.println("Executing: " + gCodes.get(0));
                commsObject.sendGcode(gCodes.get(0));
                System.err.println("Executed: " + gCodes.get(0));
                gCodes.remove(0);
                
   //             sleep(100);
            }
        }
        
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    @Override
    public boolean hasCommsObject()
    {
        if(commsObject == null)
            return false;
        return true;
    }
    
    @Override
    public TXRX getCommsObject()
    {
        return commsObject;
    }
    
   /* 
    @SuppressWarnings("SleepWhileInLoop")
    public void run()
    {
        try
        {
            commsObject = new TXRXImpl(printJobConfig);
            if(commsObject.isConnected() == false)
                System.out.println("Error in Printer Status: Could not connect to printer");
        
 //           feedbackObject = new PrinterFeedbackImpl(printJobConfig); 
 //           feedbackObject.setCommsObject(commsObject);
 //           feedbackObject.beginMonitoring();

            PrinterStatusObject pso = printJobConfig.getPrinterStatusObject();
            
            boolean once = true;
            while(gCodes.size() > 0)
            {
                
/*                while(pso.hasCurrentToolTemperatures() == false)
                {
                    // Ask for the current temperatures //
                    if(once)
                    {
                        commsObject.clearFeedbackString();
                        once = false;
                    }
                    commsObject.sendGcode("M105");
                    ArrayList<FeedbackObject> fbo = commsObject.getPrinterFeedback();
                    sleep(dispatchDelay);
                }
            
                ArrayList<TemperatureObject> temps = pso.getCurrentToolTemperatures();
                statusController.updateTemperatures(temps);
                for(int i = 0; i < temps.size(); ++i)
                {
                    if(temps.get(i).getToolName().contentEquals("T"))
                    {
                        // TODO: FIX THIS: desired temps for initial run
//                        if(temps.get(i).getCurrentTemperature() > temps.get(i).getDesiredTemp())
                        if(temps.get(i).getCurrentTemperature() > 210.0)
                        {
                            while(temps.get(i).getCurrentTemperature() > 210.0)
                            {   
                                temps = printJobConfig.getPrinterStatusObject().getCurrentToolTemperatures();
                                commsObject.sendGcode("M105");
                                sleep(dispatchDelay);
                            }
                        }
                    }    
                }
            
            
                // Wait here if we're paused //
                while(isPaused)
                {
                    sleep(dispatchDelay);
                }
            
                // Execute next g-code and remove it //
                System.err.println("Executing: " + gCodes.get(0));
                commsObject.sendGcode(gCodes.get(0));
                gCodes.remove(0);
                
                sleep(100);
            }
        }
        
        catch(InterruptedException ex)
        {
            System.out.println(ex);
        }
    }
    */
}
