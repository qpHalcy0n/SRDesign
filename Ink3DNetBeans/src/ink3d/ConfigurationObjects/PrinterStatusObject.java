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
    
    public PrinterStatusObject()
    {
        currentToolTemperatures = new ArrayList<TemperatureObject>();
        lastGcodesExecuted = new ArrayList<String>();
    }
    
    public boolean hasCurrentToolTemperatures()
    {
        if(currentToolTemperatures.size() <= 0)
            return false;
        
        return true;
    }
    
    public ArrayList<TemperatureObject> getCurrentToolTemperatures()
    {
        if(currentToolTemperatures.size() <= 0)
            return null;
        
        ArrayList<TemperatureObject> ret = currentToolTemperatures;
        currentToolTemperatures.clear();
        
        return ret;
    }
    
    public ArrayList<String> getLastGcodesExecuted()
    {
        if(lastGcodesExecuted.size() <= 0)
            return null;
        
        ArrayList<String> ret = lastGcodesExecuted;
        lastGcodesExecuted.clear();
        
        return ret;
    }
    
    public void setCurrentToolTemperatures(ArrayList<TemperatureObject> temps)
    {
        currentToolTemperatures = temps;
    }
    
    public void setLastGcodesExecuted(ArrayList<String> gCodes)
    {
        lastGcodesExecuted = gCodes;
    }
}


