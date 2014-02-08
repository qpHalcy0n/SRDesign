
public class SpeedConfiguration {
	
	/**
	 * Speed for perimeters (mm/s)
	 */
	private int perimetersSpeed;
	
	/**
	 * Speed for small perimeters (mm/s)
	 */
	private int smallPerimetersSpeed;
	
	/**
	 * Speed for external perimeters (mm/s)
	 */
	private int externalPerimetersSpeed;
	
	/**
	 * Speed for infill (mm/s)
	 */
	private int infillSpeed;
	
	/**
	 * Speed for solid infill (mm/s)
	 */
	private int solidInfillSpeed;
	
	/**
	 * Speed for top solid infil (mm/s)
	 */
	private int topSolidInfillSpeed;
	
	/**
	 * Speed for support material (mm/s)
	 */
	private int supportMaterialSpeed;
	
	/**
	 * Speed for bridges (mm/s)
	 */
	private int bridgesSpeed;
	
	/**
	 * Speed for gap fill (mm/s)
	 */
	private int gapFillSpeed;
	
	/**
	 * Speed for non print movements (mm/s)
	 */
	private int nonPrintMovesSpeed;
	
	/**
	 * Speed for the first layer (mm/s)
	 */
	private int firstLayerSpeed;
	
	/**
	 * Acceleration for perimeters (mm/s^2)
	 */
	private int perimetersAcceleration;
	
	/**
	 * Acceleration for infill (mm/s^2)
	 */
	private int infillAcceleration;
	
	/**
	 * Acceleration for bridges (mm/s^2)
	 */
	private int bridgeAcceleration;
	
	/**
	 * Default Acceleration (mm/s^2)
	 */
	private int defaultAcceleration;
}
