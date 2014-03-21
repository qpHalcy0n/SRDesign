package ink3d.ConfigurationObjects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExtruderConfiguration {
    
    private String name;
    /**
     * The type of extruder.
     */
    private String extruderType;

    /**
     * the diameter of the nozzle in mm.
     */
    private double nozzleDiameter;

    /**
     * The x offset in respect to the first extruder.
     */
    private double xOffset;

    /**
     * The y offset in respect to the first extruder.
     */
    private double yOffset;

    /**
     * The z offset in respect to the first extruder.
     */
    private double zOffset;

    public void setName(String name) {
        this.name = name;
    }
    
    public void setExtruderType(String extruderType) {
        this.extruderType = extruderType;
    }

    public void setNozzleDiameter(double nozzleDiameter) {
        this.nozzleDiameter = nozzleDiameter;
    }
    
    public void setxOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
    }

    public void setzOffset(double zOffset) {
        this.zOffset = zOffset;
    }
    
    public double getyOffset() {
        return yOffset;
    }
    
    public double getzOffset() {
        return zOffset;
    }
    
    public double getxOffset() {
        return xOffset;
    }
    
    public String getExtruderType() {
        return extruderType;
    }

    public String getName() {
        return name;
    }
    
    public double getNozzleDiameter() {
        return nozzleDiameter;
    }
    
}
