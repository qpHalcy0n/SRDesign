/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Communications;

import java.util.ArrayList;

/**
 *
 * @author shawn_000
 */
public class FeedbackObject 
{
    public FeedbackObject()
    {
        resendLine      = 0;
        toolTemps       = new ArrayList<TemperatureObject>();
        isFault         = false;
        isResend        = false;
        isACK           = false;
    }
    
    public ArrayList<TemperatureObject> getToolTemps()
    {
        return toolTemps;
    }
        
        
    int                 resendLine;
    ArrayList<TemperatureObject> toolTemps;
    public boolean      isFault;
    public boolean      isResend;
    public boolean      isACK;    
    
}
