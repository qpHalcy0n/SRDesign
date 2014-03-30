package ink3d.ConfigurationObjects;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExtruderConfiguration {

    public static final String DEFAULT_NAME = "Default";
    public static final String DEFAULT_EXTRUDER_TYPE = "";
    public static final double DEFAULT_NOZZLE_DIAMETER = 0.5;
    public static final double DEFAULT_HEAD_X_OFFSET = 0.0;
    public static final double DEFAULT_HEAD_Y_OFFSET = 0.0;
    public static final double DEFAULT_HEAD_Z_OFFSET = 0.0;
    public static final double DEFAULT_X_OFFSET = 0.0;
    public static final double DEFAULT_Y_OFFSET = 0.0;
    public static final double DEFAULT_Z_OFFSET = 0.0;

    public ExtruderConfiguration() {
        name = DEFAULT_NAME;
        extruderType = DEFAULT_EXTRUDER_TYPE;
        nozzleDiameter = DEFAULT_NOZZLE_DIAMETER;
        headxOffset = DEFAULT_HEAD_X_OFFSET;
        headyOffset = DEFAULT_HEAD_Y_OFFSET;
        headzOffset = DEFAULT_HEAD_Z_OFFSET;
        xOffset = DEFAULT_X_OFFSET;
        yOffset = DEFAULT_Y_OFFSET;
        zOffset = DEFAULT_Z_OFFSET;
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
     * The x offset this extruder adds base for its neighbor.
     */
    private double headxOffset;

    /**
     * The y offset this extruder adds base for its neighbor.
     */
    private double headyOffset;

    /**
     * The z offset this extruder adds base for its neighbor.
     */
    private double headzOffset;
    
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

    public void setHeadxOffset(double headxOffset) {
        this.headxOffset = headxOffset;
    }

    public void setHeadyOffset(double headyOffset) {
        this.headyOffset = headyOffset;
    }

    public void setHeadzOffset(double headzOffset) {
        this.headzOffset = headzOffset;
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

    public void setName(String name) {
        this.name = name;
    }
    
    public void setExtruderType(String extruderType) {
        this.extruderType = extruderType;
    }

    public void setNozzleDiameter(double nozzleDiameter) {
        this.nozzleDiameter = nozzleDiameter;
    }

    public double getHeadxOffset() {
        return headxOffset;
    }

    public double getHeadyOffset() {
        return headyOffset;
    }

    public double getHeadzOffset() {
        return headzOffset;
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
        if (Double.doubleToLongBits(this.headxOffset) != Double.doubleToLongBits(other.headxOffset)) {
            return false;
        }
        if (Double.doubleToLongBits(this.headyOffset) != Double.doubleToLongBits(other.headyOffset)) {
            return false;
        }
        if (Double.doubleToLongBits(this.headzOffset) != Double.doubleToLongBits(other.headzOffset)) {
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
        return "ExtruderConfiguration{" + "name=" + name + ", extruderType=" + extruderType + ", nozzleDiameter=" + nozzleDiameter + ", headxOffset=" + headxOffset + ", headyOffset=" + headyOffset + ", headzOffset=" + headzOffset + ", xOffset=" + xOffset + ", yOffset=" + yOffset + ", zOffset=" + zOffset + '}';
    }        
}
