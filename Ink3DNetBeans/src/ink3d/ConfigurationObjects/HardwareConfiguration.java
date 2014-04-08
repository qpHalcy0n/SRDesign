/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.ConfigurationObjects;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shawn Simonson
 */
@XmlRootElement
public class HardwareConfiguration 
{
    public enum LineEnding
    {
        NONE
        {
            public String toString()
            {
                return "";
            }
        },
        
        NR
        {
            public String toString()
            {
                return "\n\r";
            }
        },
        
        RN
        {
            public String toString()
            {
                return "r\n";
            }
        },
        
        N
        {
            public String toString()
            {
                return "\n";
            }
        }
    }
    
    
    public static String DEFAULT_LINE_ENDING        = LineEnding.RN.toString();
    public static String DEFAULT_COM_PORT           = "COM1";
    public static int DEFAULT_BAUD_RATE             = 115200;
    
    private String lineEnding;
    private String comPort;
    private int baudRate;
    
    public HardwareConfiguration()
    {
        this.lineEnding     = DEFAULT_LINE_ENDING;
        this.comPort        = DEFAULT_COM_PORT;
        this.baudRate       = DEFAULT_BAUD_RATE;
    }
    
    public String getLineEnding()
    {
        return lineEnding;
    }
    
    public String getComPort()
    {
        return comPort;
    }
    
    public int getBaudRate()
    {
        return baudRate;
    }
    
    public void setLineEnding(String l)
    {
        this.lineEnding = l;
    }
    
    public void setComPort(String c)
    {
        this.comPort = c;
    }
    
    public void setBaudRate(int b)
    {
        this.baudRate = b;
    }
    
    //TODO: Add Hash
    @Override
    public int hashCode()
    {
        return 1;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        
        if(getClass() != obj.getClass())
            return false;
        
        final HardwareConfiguration other = (HardwareConfiguration)obj;
        if(!Objects.equals(this.lineEnding, other.lineEnding))
            return false;
        
        if(!Objects.equals(this.comPort, other.comPort))
            return false;
        
        if(!Objects.equals(this.baudRate, other.baudRate))
            return false;
        
        return true;
    }
    
    @Override
    public String toString()
    {
        return "HardwareConfiguration{" + "lineEnding=" + lineEnding + "comPort=" + comPort + "baudRate=" + baudRate;
    }
}
