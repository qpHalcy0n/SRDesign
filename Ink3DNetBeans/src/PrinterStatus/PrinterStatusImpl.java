/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PrinterStatus;

import ink3d.PrinterFeedback.PrinterFeedback;
import ink3d.Communications.TemperatureObject;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import java.util.ArrayList;

/**
 *
 * @author shawn_000
 */
public class PrinterStatusImpl extends Thread implements PrinterStatus
{
    private static ArrayList<String> gCodes;
    private static ArrayList<String> failsafeGcodes;
    private static PrintJobConfiguration pjc;
    private static int dispatchDelay;
    
    public PrinterStatusImpl(PrintJobConfiguration pjc)
    {
        gCodes = new ArrayList<String>();
        failsafeGcodes = new ArrayList<String>();
        this.pjc = pjc;
    }
    
    public void setGcodes(ArrayList<String> codes)
    {
        gCodes = codes;
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
    
    @Override
    public void run()
    {
        try
        {
            while(pjc.getPrinterStatusObject().hasCurrentToolTemperatures() == false)
                Thread.currentThread().sleep(dispatchDelay);
            
            ArrayList<TemperatureObject> temps = pjc.getPrinterStatusObject().getCurrentToolTemperatures();
            for(int i = 0; i < temps.size(); ++i)
            {
                if(temps.get(i).getToolName().contentEquals("T"))
                {
                    if(temps.get(i).getCurrentTemperature() > temps.get(i).getDesiredTemp())
                    {
                        // halt...send failsafe commands and wait //
                    }
                }     
            }
            
            // Send next g-code //
            // TXRX->sendGcode(pjc, nextGcode)
            // remove next g-code
        }
        catch(InterruptedException ex)
        {
            System.out.println(ex);
        }
    }
}
