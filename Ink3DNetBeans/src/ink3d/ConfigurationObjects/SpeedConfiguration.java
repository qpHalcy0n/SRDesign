package ink3d.ConfigurationObjects;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SpeedConfiguration {
    private String name;
    /**
     * Speed for perimeters (mm/s)
     */
    private double perimetersSpeed;

    /**
     * Speed for small perimeters (mm/s)
     */
    private double smallPerimetersSpeed;

    /**
     * Speed for external perimeters (mm/s)
     */
    private double externalPerimetersSpeed;

    /**
     * Speed for infill (mm/s)
     */
    private double infillSpeed;

    /**
     * Speed for solid infill (mm/s)
     */
    private double solidInfillSpeed;

    /**
     * Speed for top solid infil (mm/s)
     */
    private double topSolidInfillSpeed;

    /**
     * Speed for support material (mm/s)
     */
    private double supportMaterialSpeed;

    /**
     * Speed for bridges (mm/s)
     */
    private double bridgesSpeed;

    /**
     * Speed for gap fill (mm/s)
     */
    private double gapFillSpeed;

    /**
     * Speed for non prdouble movements (mm/s)
     */
    private double nonPrintMovesSpeed;

    /**
     * Speed for the first layer (mm/s)
     */
    private double firstLayerSpeed;

    /**
     * Acceleration for perimeters (mm/s^2)
     */
    private double perimetersAcceleration;

    /**
     * Acceleration for infill (mm/s^2)
     */
    private double infillAcceleration;

    /**
     * Acceleration for bridges (mm/s^2)
     */
    private double bridgeAcceleration;

    /**
     * Default Acceleration (mm/s^2)
     */
    private double defaultAcceleration;

    public double getPerimetersSpeed() {
        return perimetersSpeed;
    }

    public void setPerimetersSpeed(double perimetersSpeed) {
        this.perimetersSpeed = perimetersSpeed;
    }

    public double getSmallPerimetersSpeed() {
        return smallPerimetersSpeed;
    }

    public void setSmallPerimetersSpeed(double smallPerimetersSpeed) {
        this.smallPerimetersSpeed = smallPerimetersSpeed;
    }

    public double getExternalPerimetersSpeed() {
        return externalPerimetersSpeed;
    }

    public void setExternalPerimetersSpeed(double externalPerimetersSpeed) {
        this.externalPerimetersSpeed = externalPerimetersSpeed;
    }

    public double getInfillSpeed() {
        return infillSpeed;
    }

    public void setInfillSpeed(double infillSpeed) {
        this.infillSpeed = infillSpeed;
    }

    public double getSolidInfillSpeed() {
        return solidInfillSpeed;
    }

    public void setSolidInfillSpeed(double solidInfillSpeed) {
        this.solidInfillSpeed = solidInfillSpeed;
    }

    public double getTopSolidInfillSpeed() {
        return topSolidInfillSpeed;
    }

    public void setTopSolidInfillSpeed(double topSolidInfillSpeed) {
        this.topSolidInfillSpeed = topSolidInfillSpeed;
    }

    public double getSupportMaterialSpeed() {
        return supportMaterialSpeed;
    }

    public void setSupportMaterialSpeed(double supportMaterialSpeed) {
        this.supportMaterialSpeed = supportMaterialSpeed;
    }

    public double getBridgesSpeed() {
        return bridgesSpeed;
    }

    public void setBridgesSpeed(double bridgesSpeed) {
        this.bridgesSpeed = bridgesSpeed;
    }

    public double getGapFillSpeed() {
        return gapFillSpeed;
    }

    public void setGapFillSpeed(double gapFillSpeed) {
        this.gapFillSpeed = gapFillSpeed;
    }

    public double getNonPrintMovesSpeed() {
        return nonPrintMovesSpeed;
    }

    public void setNonPrintMovesSpeed(double nonPrintMovesSpeed) {
        this.nonPrintMovesSpeed = nonPrintMovesSpeed;
    }

    public double getFirstLayerSpeed() {
        return firstLayerSpeed;
    }

    public void setFirstLayerSpeed(double firstLayerSpeed) {
        this.firstLayerSpeed = firstLayerSpeed;
    }

    public double getPerimetersAcceleration() {
        return perimetersAcceleration;
    }

    public void setPerimetersAcceleration(double perimetersAcceleration) {
        this.perimetersAcceleration = perimetersAcceleration;
    }

    public double getInfillAcceleration() {
        return infillAcceleration;
    }

    public void setInfillAcceleration(double infillAcceleration) {
        this.infillAcceleration = infillAcceleration;
    }

    public double getBridgeAcceleration() {
        return bridgeAcceleration;
    }

    public void setBridgeAcceleration(double bridgeAcceleration) {
        this.bridgeAcceleration = bridgeAcceleration;
    }

    public double getDefaultAcceleration() {
        return defaultAcceleration;
    }

    public void setDefaultAcceleration(double defaultAcceleration) {
        this.defaultAcceleration = defaultAcceleration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
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
        final SpeedConfiguration other = (SpeedConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.perimetersSpeed) != Double.doubleToLongBits(other.perimetersSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.smallPerimetersSpeed) != Double.doubleToLongBits(other.smallPerimetersSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.externalPerimetersSpeed) != Double.doubleToLongBits(other.externalPerimetersSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.infillSpeed) != Double.doubleToLongBits(other.infillSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.solidInfillSpeed) != Double.doubleToLongBits(other.solidInfillSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.topSolidInfillSpeed) != Double.doubleToLongBits(other.topSolidInfillSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.supportMaterialSpeed) != Double.doubleToLongBits(other.supportMaterialSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bridgesSpeed) != Double.doubleToLongBits(other.bridgesSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gapFillSpeed) != Double.doubleToLongBits(other.gapFillSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.nonPrintMovesSpeed) != Double.doubleToLongBits(other.nonPrintMovesSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.firstLayerSpeed) != Double.doubleToLongBits(other.firstLayerSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.perimetersAcceleration) != Double.doubleToLongBits(other.perimetersAcceleration)) {
            return false;
        }
        if (Double.doubleToLongBits(this.infillAcceleration) != Double.doubleToLongBits(other.infillAcceleration)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bridgeAcceleration) != Double.doubleToLongBits(other.bridgeAcceleration)) {
            return false;
        }
        if (Double.doubleToLongBits(this.defaultAcceleration) != Double.doubleToLongBits(other.defaultAcceleration)) {
            return false;
        }
        return true;
    }
    
    
}
