
public class LayerAndPerimeterConfiguration {
	// Layers and Perimeters
	
	/* Layer Height */
	/**
	 * The height of each layer in mm.
	 */
	private double layerHeight; // in mm
	
	/**
	 * The height of the first layer of the print in mm.
	 */
	private double firstLayerHeight; // in mm
	
	
	/* Vertical Shells */
	
	/**
	 * The number of vertical perimeters in the print.  Essentially the number of "walls"
	 * around the perimeter of the print.
	 */
	private int perimeters;
	
	/**
	 * If true, each layer should start from a different vertex to avoid build up on
	 * a specific corner.
	 */
	private boolean randomizedStartingPoints;
	
	/**
	 * If true, extra perimeters should be added in slopes where more than the specified
	 * number of perimeters is needed.
	 */
	private boolean generateExtraPerimetersWhenNeeded;
	
	/**
	 * The number of solid layers to generate on the top of the print.
	 */
	private int solidTopLayers;
	
	/**
	 * The number of solid layers to generate on the bottom of the print.
	 */
	private int solidBottomLayers;
}
