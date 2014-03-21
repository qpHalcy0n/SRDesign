package ink3d.ConfigurationObjects;
import java.util.Objects;
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
}
