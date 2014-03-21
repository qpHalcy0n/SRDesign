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

    public boolean isGenerateSupportMaterial() {
        return generateSupportMaterial;
    }

    public void setGenerateSupportMaterial(boolean generateSupportMaterial) {
        this.generateSupportMaterial = generateSupportMaterial;
    }

    public int getOverhangThreshold() {
        return overhangThreshold;
    }

    public void setOverhangThreshold(int overhangThreshold) {
        this.overhangThreshold = overhangThreshold;
    }

    public int getEnforceSupportForFirstNLayers() {
        return enforceSupportForFirstNLayers;
    }

    public void setEnforceSupportForFirstNLayers(int enforceSupportForFirstNLayers) {
        this.enforceSupportForFirstNLayers = enforceSupportForFirstNLayers;
    }

    public int getRaftLayers() {
        return raftLayers;
    }

    public void setRaftLayers(int raftLayers) {
        this.raftLayers = raftLayers;
    }

    public String getSupportMaterialPattern() {
        return supportMaterialPattern;
    }

    public void setSupportMaterialPattern(String supportMaterialPattern) {
        this.supportMaterialPattern = supportMaterialPattern;
    }

    public double getSupportPatternSpacing() {
        return supportPatternSpacing;
    }

    public void setSupportPatternSpacing(double supportPatternSpacing) {
        this.supportPatternSpacing = supportPatternSpacing;
    }

    public int getSupportPatternAngle() {
        return supportPatternAngle;
    }

    public void setSupportPatternAngle(int supportPatternAngle) {
        this.supportPatternAngle = supportPatternAngle;
    }

    public int getInterfaceLayers() {
        return interfaceLayers;
    }

    public void setInterfaceLayers(int interfaceLayers) {
        this.interfaceLayers = interfaceLayers;
    }

    public double getInterfacePatternSpacing() {
        return interfacePatternSpacing;
    }

    public void setInterfacePatternSpacing(double interfacePatternSpacing) {
        this.interfacePatternSpacing = interfacePatternSpacing;
    }
	
        
}
