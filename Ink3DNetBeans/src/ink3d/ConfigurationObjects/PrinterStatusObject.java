/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.ConfigurationObjects;


import java.util.ArrayList;
import ink3d.Communications.TemperatureObject;

/**
 *
 * @author shawn_000
 */
public class PrinterStatusObject 
{
    public static ArrayList<TemperatureObject>  currentToolTemperatures;
    public static ArrayList<String> lastGcodesExecuted;
    private Object lock             = new Object();
    
    public PrinterStatusObject()
    {
        currentToolTemperatures = new ArrayList<>();
        lastGcodesExecuted = new ArrayList<>();
    }

    
    public boolean hasCurrentToolTemperatures()
    {
        synchronized(lock)
        {
            if(currentToolTemperatures.size() <= 0)
                return false;
        
            return true;
        }
    }

    public boolean hasGCodes() 
    {
        synchronized(lock)
        {
            if(lastGcodesExecuted.size() <= 0) {
                return false;
            }
            return true;
        }
    }
    
    public ArrayList<TemperatureObject> getCurrentToolTemperatures()
    {
        if(currentToolTemperatures.size() <= 0)
            return null;
        
        ArrayList<TemperatureObject> ret = new ArrayList<>();
        
        synchronized(lock)
        {
            ret.addAll(currentToolTemperatures);
        }
        
        currentToolTemperatures.clear();
        return ret;
    }
    
    public ArrayList<String> getLastGcodesExecuted()
    {
        if(lastGcodesExecuted.size() <= 0)
            return null;
        
        ArrayList<String> ret = new ArrayList<>();
        
        synchronized(lock)
        {
            ret.addAll(lastGcodesExecuted);
        }
        
        lastGcodesExecuted.clear();
        return ret;
    }
    
    public void setCurrentToolTemperatures(ArrayList<TemperatureObject> temps)
    {
        synchronized(lock)
        {
            currentToolTemperatures.addAll(temps);
        }
    }
    
    public void setLastGcodesExecuted(ArrayList<String> gCodes)
    {
        synchronized(lock)
        {
            lastGcodesExecuted.addAll(gCodes);
        }
    }
}


