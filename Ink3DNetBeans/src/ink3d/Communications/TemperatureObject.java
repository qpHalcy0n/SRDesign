/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Communications;

/**
 *
 * @author shawn_000
 */
public class TemperatureObject 
{
    public TemperatureObject()
    {
        tool        = new String("");
        curTemp     = 0.0f;
        desiredTemp = 0.0f;
    }
    
    public String getToolName()
    {
        return tool;
    }

    public int getToolNumber() {
        String numStr = tool.substring(1);
        int num;
        try {
            num = Integer.parseInt(numStr);
        }
        catch(NumberFormatException ex) {
            num = -1;
        }
        return num;
    }
    
    public float getCurrentTemperature()
    {
        return curTemp;
    }
    
    public float getDesiredTemp()
    {
        return desiredTemp;
    }

        
    String tool;
    float  curTemp;
    float  desiredTemp;  
}
