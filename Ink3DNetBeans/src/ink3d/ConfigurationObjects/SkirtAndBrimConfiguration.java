package ink3d.ConfigurationObjects;


public class SkirtAndBrimConfiguration {
	
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
        
        
}
