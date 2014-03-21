package ink3d.ConfigurationObjects;

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
}
