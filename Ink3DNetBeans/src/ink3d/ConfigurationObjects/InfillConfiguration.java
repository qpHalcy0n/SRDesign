package ink3d.ConfigurationObjects;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InfillConfiguration {
    private String name;
    /**
     * The density of infill from 0.0 - 1.0.  0.0 being no infill, 1.0 being a solid infill.
     */
    private double infillDensity;

    /**
     * The pattern to use for internal infill.
     */
    private String infillPattern;

    /**
     * The pattern to use for the top and bottom layers' infill.
     */
    private String topBottomInfillPattern;

    /**
     * The ratio of layers to infill layers expresses as an integer >= 1.
     * For example, infillEveryNLayers = 2 results in using infill every other layer,
     * while infillEveryNLayers = 1 results in infill every layer.
     */
    private int infillEveryNLayers;

    /**
     * When set to true, infill is treated as support material and only extruded
     * where necessary.
     */
    private boolean onlyInfillWhereNeeded;

    /**
     * When set to a integer other than 0, a layer of solid infill with be extruded
     * every n layers, where the value of solidInfillEveryNLayers is n.
     */
    private int solidInfillEveryNLayers;

    /**
     * Default base angle for fill orientation in degrees from 0 to 359.
     * This is the angle the infill will oriented in relation to the vertical perimeters.
     */
    private int infillAngle;

    /**
     * The threshold for area in square mm for which to force solid infill.
     */
    private int solidInfillThresholdArea;

    /**
     * When set to true, filament will not be retracted unless crossing a 
     * perimeter, resulting in some visible oozing throughout the infill.
     */
    private boolean onlyRetractInfillWhenCrossingPerimeters;

    /**
     * When set to true, infill for each layer will be extruded before the
     * perimeters are extruded.
     */
    private boolean infillBeforePerimeters;

    public double getInfillDensity() {
        return infillDensity;
    }

    public void setInfillDensity(double infillDensity) {
        this.infillDensity = infillDensity;
    }

    public String getInfillPattern() {
        return infillPattern;
    }

    public void setInfillPattern(String infillPattern) {
        this.infillPattern = infillPattern;
    }

    public String getTopBottomInfillPattern() {
        return topBottomInfillPattern;
    }

    public void setTopBottomInfillPattern(String topBottomInfillPattern) {
        this.topBottomInfillPattern = topBottomInfillPattern;
    }

    public int getInfillEveryNLayers() {
        return infillEveryNLayers;
    }

    public void setInfillEveryNLayers(int infillEveryNLayers) {
        this.infillEveryNLayers = infillEveryNLayers;
    }

    public boolean isOnlyInfillWhereNeeded() {
        return onlyInfillWhereNeeded;
    }

    public void setOnlyInfillWhereNeeded(boolean onlyInfillWhereNeeded) {
        this.onlyInfillWhereNeeded = onlyInfillWhereNeeded;
    }

    public int getSolidInfillEveryNLayers() {
        return solidInfillEveryNLayers;
    }

    public void setSolidInfillEveryNLayers(int solidInfillEveryNLayers) {
        this.solidInfillEveryNLayers = solidInfillEveryNLayers;
    }

    public int getInfillAngle() {
        return infillAngle;
    }

    public void setInfillAngle(int infillAngle) {
        this.infillAngle = infillAngle;
    }

    public int getSolidInfillThresholdArea() {
        return solidInfillThresholdArea;
    }

    public void setSolidInfillThresholdArea(int solidInfillThresholdArea) {
        this.solidInfillThresholdArea = solidInfillThresholdArea;
    }

    public boolean isOnlyRetractInfillWhenCrossingPerimeters() {
        return onlyRetractInfillWhenCrossingPerimeters;
    }

    public void setOnlyRetractInfillWhenCrossingPerimeters(boolean onlyRetractInfillWhenCrossingPerimeters) {
        this.onlyRetractInfillWhenCrossingPerimeters = onlyRetractInfillWhenCrossingPerimeters;
    }

    public boolean isInfillBeforePerimeters() {
        return infillBeforePerimeters;
    }

    public void setInfillBeforePerimeters(boolean infillBeforePerimeters) {
        this.infillBeforePerimeters = infillBeforePerimeters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.name);
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
        final InfillConfiguration other = (InfillConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.infillDensity) != Double.doubleToLongBits(other.infillDensity)) {
            return false;
        }
        if (!Objects.equals(this.infillPattern, other.infillPattern)) {
            return false;
        }
        if (!Objects.equals(this.topBottomInfillPattern, other.topBottomInfillPattern)) {
            return false;
        }
        if (this.infillEveryNLayers != other.infillEveryNLayers) {
            return false;
        }
        if (this.onlyInfillWhereNeeded != other.onlyInfillWhereNeeded) {
            return false;
        }
        if (this.solidInfillEveryNLayers != other.solidInfillEveryNLayers) {
            return false;
        }
        if (this.infillAngle != other.infillAngle) {
            return false;
        }
        if (this.solidInfillThresholdArea != other.solidInfillThresholdArea) {
            return false;
        }
        if (this.onlyRetractInfillWhenCrossingPerimeters != other.onlyRetractInfillWhenCrossingPerimeters) {
            return false;
        }
        if (this.infillBeforePerimeters != other.infillBeforePerimeters) {
            return false;
        }
        return true;
    }
    
}
