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
                return "\r\n";
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
    
    
    public static int DEFAULT_LINE_ENDING           = 3;
    public static String DEFAULT_COM_PORT           = "COM1";
    public static int DEFAULT_BAUD_RATE             = 115200;
    
    private int lineEnd;
    private String comPort;
    private int baudRate;
    
    public HardwareConfiguration()
    {
        this.lineEnd        = DEFAULT_LINE_ENDING;
        this.comPort        = DEFAULT_COM_PORT;
        this.baudRate       = DEFAULT_BAUD_RATE;
    }
    
    public String getLineEnding()
    {
        switch (lineEnd){
            case 0:return LineEnding.NONE.toString();
            case 1:return LineEnding.NR.toString();
            case 2:return LineEnding.RN.toString();
            case 3:return LineEnding.N.toString();
            default: return null;
        }
                
    }
    
    public String getComPort()
    {
        return comPort;
    }
    
    public int getBaudRate()
    {
        return baudRate;
    }
    
    public void setLineEnd(int l)
    {
        this.lineEnd = l;
    }

    public int getLineEnd() {
        return lineEnd;
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
        if(!Objects.equals(this.lineEnd, other.lineEnd))
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
        return "HardwareConfiguration{" + " lineEnding=" + lineEnd + " comPort=" + comPort + " baudRate=" + baudRate+"}";
    }
}
