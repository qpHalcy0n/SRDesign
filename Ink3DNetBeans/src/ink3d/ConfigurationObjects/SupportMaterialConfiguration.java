package ink3d.ConfigurationObjects;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SupportMaterialConfiguration {

    public static final String DEFAULT_NAME = "Default";
    public static final boolean DEFAULT_GENERATE_SUPPORT_MATERIAL = false;
    public static final int DEFAULT_OVERHANG_THRESHOLD = 0;
    public static final int DEFAULT_ENFORCE_SUPPORT_FOR_FIRST_N_LAYER = 0;
    public static final int DEFAULT_RAFT_LAYERS = 0;
    public static final String DEFAULT_SUPPORT_MATERIAL_PATTERN = "rectilinear";
    public static final double DEFAULT_SUPPORT_PATTERN_SPACING = 2.5;
    public static final int DEFAULT_SUPPORT_PATTERN_ANGLE = 0;
    public static final int DEFAULT_INTERFACE_LAYERS = 0;
    public static final double DEFAULT_INTERFACE_PATTERN_SPACING = 0.0;

    public SupportMaterialConfiguration() {
        name = DEFAULT_NAME;
        generateSupportMaterial = DEFAULT_GENERATE_SUPPORT_MATERIAL;
        overhangThreshold = DEFAULT_OVERHANG_THRESHOLD;
        enforceSupportForFirstNLayers = DEFAULT_ENFORCE_SUPPORT_FOR_FIRST_N_LAYER;
        raftLayers = DEFAULT_RAFT_LAYERS;
        supportMaterialPattern = DEFAULT_SUPPORT_MATERIAL_PATTERN;
        supportPatternSpacing = DEFAULT_SUPPORT_PATTERN_SPACING;
        supportPatternAngle = DEFAULT_SUPPORT_PATTERN_ANGLE;
        interfaceLayers = DEFAULT_INTERFACE_LAYERS;
        interfacePatternSpacing = DEFAULT_INTERFACE_PATTERN_SPACING;
    }

    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SupportMaterialConfiguration other = (SupportMaterialConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.generateSupportMaterial != other.generateSupportMaterial) {
            return false;
        }
        if (this.overhangThreshold != other.overhangThreshold) {
            return false;
        }
        if (this.enforceSupportForFirstNLayers != other.enforceSupportForFirstNLayers) {
            return false;
        }
        if (this.raftLayers != other.raftLayers) {
            return false;
        }
        if (!Objects.equals(this.supportMaterialPattern, other.supportMaterialPattern)) {
            return false;
        }
        if (Double.doubleToLongBits(this.supportPatternSpacing) != Double.doubleToLongBits(other.supportPatternSpacing)) {
            return false;
        }
        if (this.supportPatternAngle != other.supportPatternAngle) {
            return false;
        }
        if (this.interfaceLayers != other.interfaceLayers) {
            return false;
        }
        if (Double.doubleToLongBits(this.interfacePatternSpacing) != Double.doubleToLongBits(other.interfacePatternSpacing)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SupportMaterialConfiguration{" + "name=" + name + ", generateSupportMaterial=" + generateSupportMaterial + ", overhangThreshold=" + overhangThreshold + ", enforceSupportForFirstNLayers=" + enforceSupportForFirstNLayers + ", raftLayers=" + raftLayers + ", supportMaterialPattern=" + supportMaterialPattern + ", supportPatternSpacing=" + supportPatternSpacing + ", supportPatternAngle=" + supportPatternAngle + ", interfaceLayers=" + interfaceLayers + ", interfacePatternSpacing=" + interfacePatternSpacing + '}';
    }
    
}
