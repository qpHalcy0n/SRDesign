package ink3d.ConfigurationObjects;


public class SupportMaterialConfiguration {
	
	/**
	 * When set to true, G-code for support material will be generated.
	 */
	private boolean generateSupportMaterial;
	
	/**
	 * The overhang threshold in degrees.  Support material will not be
	 * extruded for overhangs whose slope angle is above this threshold.
	 */
	private int overhangThreshold;
	
	/**
	 * Forces support material on the first n layers.
	 */
	private int enforceSupportForFirstNLayers;
	
	/**
	 * Number of raft layers to print below the object.
	 */
	private int raftLayers;
	
	/**
	 * Pattern used to generate support material.
	 */
	private String supportMaterialPattern;
	
	/**
	 * The spacing in mm between support lines.
	 */
	private double supportPatternSpacing;
	
	/**
	 * The angle the support pattern is extruded at (between 0 and 359).
	 */
	private int supportPatternAngle;
	
	/**
	 * The number of interface layers to print between the raft and object.
	 */
	private int interfaceLayers;
	
	/**
	 * The spacing in mm between support lines.
	 */
	private double interfacePatternSpacing;
	
}
