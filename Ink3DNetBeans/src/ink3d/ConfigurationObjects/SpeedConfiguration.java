
public class SpeedConfiguration {
	
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
}
