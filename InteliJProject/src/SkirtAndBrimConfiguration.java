
public class SkirtAndBrimConfiguration {
	
	/**
	 * The number loops of skirt to extrude (0 will extrude no skirt).
	 */
	private int skirtLoops;
	
	/**
	 * The distance from the object the skirt will be extruded at in mm >= 0.
	 * Setting this to 0 will essentially turn the skirt into brim.
	 */
	private int skirtDistanceFromObject;
	
	/**
	 * The height of the skirt in layers >= 1.
	 */
	private int skirtHeight;
	
	/**
	 * The minimum extrusion length of the skirt in mm >= 0.
	 */
	private int skirtMinimumExtrusionLength;
	
	/**
	 * The width of the brim in mm (0 will extrude no brim).
	 */
	private int brimWidth;
}
