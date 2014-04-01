package ink3d.ConfigurationObjects;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExtruderConfiguration {

    public static final String DEFAULT_NAME = "Default";
    public static final String DEFAULT_EXTRUDER_TYPE = "";
    public static final double DEFAULT_NOZZLE_DIAMETER = 0.5;
    public static final double DEFAULT_X_DIMENSION = 0.0;
    public static final double DEFAULT_Y_DIMENSION = 0.0;
    public static final double DEFAULT_X_OFFSET = 0.0;
    public static final double DEFAULT_Y_OFFSET = 0.0;
    public static final double DEFAULT_Z_OFFSET = 0.0;
    public static final String DEFAULT_START_GCODE = "";
    public static final String DEFAULT_END_GCODE = "";

    public ExtruderConfiguration() {
        name = DEFAULT_NAME;
        extruderType = DEFAULT_EXTRUDER_TYPE;
        nozzleDiameter = DEFAULT_NOZZLE_DIAMETER;
        xDimension = DEFAULT_X_DIMENSION;
        yDimension = DEFAULT_Y_DIMENSION;
        xOffset = DEFAULT_X_OFFSET;
        yOffset = DEFAULT_Y_OFFSET;
        zOffset = DEFAULT_Z_OFFSET;
        startGCode = DEFAULT_START_GCODE;
        endGCode = DEFAULT_END_GCODE;
    }

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
    * The x dimension of the extruder.  Used to calculate true offsets.
    */
    private double xDimension;

    /**
     * The y dimension of the extruder.  Used to calculate true offsets.
     */
    private double yDimension;
    
     /**
     * The x offset in respect to the current base.
     */
    private double xOffset;

    /**
     * The y offset in respect to the current base.
     */
    private double yOffset;

    /**
     * The z offset in respect to the current base.
     */
    private double zOffset;

    private String startGCode;
    private String endGCode;

    public void setxOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
    }

    public void setzOffset(double zOffset) {
        this.zOffset = zOffset;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setExtruderType(String extruderType) {
        this.extruderType = extruderType;
    }

    public void setNozzleDiameter(double nozzleDiameter) {
        this.nozzleDiameter = nozzleDiameter;
    }

    public double getxOffset() {
        return xOffset;
    }

    public double getyOffset() {
        return yOffset;
    }

    public double getzOffset() {
        return zOffset;
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
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExtruderConfiguration other = (ExtruderConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.extruderType, other.extruderType)) {
            return false;
        }
        if (Double.doubleToLongBits(this.nozzleDiameter) != Double.doubleToLongBits(other.nozzleDiameter)) {
            return false;
        }
        if (Double.doubleToLongBits(this.getxDimension()) != Double.doubleToLongBits(other.getxDimension())) {
            return false;
        }
        if (Double.doubleToLongBits(this.getyDimension()) != Double.doubleToLongBits(other.getyDimension())) {
            return false;
        }
        if (Double.doubleToLongBits(this.xOffset) != Double.doubleToLongBits(other.xOffset)) {
            return false;
        }
        if (Double.doubleToLongBits(this.yOffset) != Double.doubleToLongBits(other.yOffset)) {
            return false;
        }
        if (Double.doubleToLongBits(this.zOffset) != Double.doubleToLongBits(other.zOffset)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExtruderConfiguration{" + "name=" + name + ", extruderType=" + extruderType + ", nozzleDiameter=" + nozzleDiameter + ", xDimension=" + getxDimension() + ", yDimension=" + getyDimension() + ", xOffset=" + xOffset + ", yOffset=" + yOffset + ", zOffset=" + zOffset + '}';
    }        

    /**
     * @return the xDimension
     */
    public double getxDimension() {
        return xDimension;
    }

    /**
     * @param xDimension the xDimension to set
     */
    public void setxDimension(double xDimension) {
        this.xDimension = xDimension;
    }

    /**
     * @return the yDimension
     */
    public double getyDimension() {
        return yDimension;
    }

    /**
     * @param yDimension the yDimension to set
     */
    public void setyDimension(double yDimension) {
        this.yDimension = yDimension;
    }

    /**
     * @return the startGCode
     */
    public String getStartGCode() {
        return startGCode;
    }

    /**
     * @param startGCode the startGCode to set
     */
    public void setStartGCode(String startGCode) {
        this.startGCode = startGCode;
    }

    /**
     * @return the endGCode
     */
    public String getEndGCode() {
        return endGCode;
    }

    /**
     * @param endGCode the endGCode to set
     */
    public void setEndGCode(String endGCode) {
        this.endGCode = endGCode;
    }
}
