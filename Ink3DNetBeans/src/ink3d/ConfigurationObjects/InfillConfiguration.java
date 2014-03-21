package ink3d.ConfigurationObjects;

public class InfillConfiguration {
	
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
	
}
