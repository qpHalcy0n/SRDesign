package ink3d.ConfigurationObjects;
public class ExtruderConfiguration {
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

    public String getExtruderType() {
        return extruderType;
    }

    public void setExtruderType(String extruderType) {
        this.extruderType = extruderType;
    }

    public double getNozzleDiameter() {
        return nozzleDiameter;
    }

    public void setNozzleDiameter(double nozzleDiameter) {
        this.nozzleDiameter = nozzleDiameter;
    }

    public double getxOffset() {
        return xOffset;
    }

    public void setxOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    public double getyOffset() {
        return yOffset;
    }

    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
    }

    public double getzOffset() {
        return zOffset;
    }

    public void setzOffset(double zOffset) {
        this.zOffset = zOffset;
    }
}
