package ink3d.ConfigurationObjects;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SkirtAndBrimConfiguration {
    private String name;
	
    /**
     * The number loops of skirt to extrude (0 will extrude no skirt).
     */
    private int skirtLoops;

    /**
     * The distance from the object the skirt will be extruded at in mm >= 0.
     * Setting this to 0 will essentially turn the skirt into brim.
     */
    private double skirtDistanceFromObject;

    /**
     * The height of the skirt in layers >= 1.
     */
    private int skirtHeight;

    /**
     * The minimum extrusion length of the skirt in mm >= 0.
     */
    private double skirtMinimumExtrusionLength;

    /**
     * The width of the brim in mm (0 will extrude no brim).
     */
    private double brimWidth;

    public int getSkirtLoops() {
        return skirtLoops;
    }

    public void setSkirtLoops(int skirtLoops) {
        this.skirtLoops = skirtLoops;
    }

    public double getSkirtDistanceFromObject() {
        return skirtDistanceFromObject;
    }

    public void setSkirtDistanceFromObject(double skirtDistanceFromObject) {
        this.skirtDistanceFromObject = skirtDistanceFromObject;
    }

    public int getSkirtHeight() {
        return skirtHeight;
    }

    public void setSkirtHeight(int skirtHeight) {
        this.skirtHeight = skirtHeight;
    }

    public double getSkirtMinimumExtrusionLength() {
        return skirtMinimumExtrusionLength;
    }

    public void setSkirtMinimumExtrusionLength(double skirtMinimumExtrusionLength) {
        this.skirtMinimumExtrusionLength = skirtMinimumExtrusionLength;
    }

    public double getBrimWidth() {
        return brimWidth;
    }

    public void setBrimWidth(double brimWidth) {
        this.brimWidth = brimWidth;
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
        hash = 83 * hash + Objects.hashCode(this.name);
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
        final SkirtAndBrimConfiguration other = (SkirtAndBrimConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.skirtLoops != other.skirtLoops) {
            return false;
        }
        if (Double.doubleToLongBits(this.skirtDistanceFromObject) != Double.doubleToLongBits(other.skirtDistanceFromObject)) {
            return false;
        }
        if (this.skirtHeight != other.skirtHeight) {
            return false;
        }
        if (Double.doubleToLongBits(this.skirtMinimumExtrusionLength) != Double.doubleToLongBits(other.skirtMinimumExtrusionLength)) {
            return false;
        }
        if (Double.doubleToLongBits(this.brimWidth) != Double.doubleToLongBits(other.brimWidth)) {
            return false;
        }
        return true;
    }
    
    
}
