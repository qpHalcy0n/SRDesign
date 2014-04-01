package ink3d.ConfigurationObjects;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LayerAndPerimeterConfiguration {

    public static final String DEFAULT_NAME = "Default";
    public static final double DEFAULT_LAYER_HEIGHT = 0.4;
    public static final double DEFAULT_FIRST_LAYER_HEIGHT = 0.35;
    public static final int DEFAULT_PERIMETERS = 3;
    public static final boolean DEFAULT_SPIRAL_VASE = false;
    public static final boolean DEFAULT_RANDOMIZE_STARTING_POINTS = false;
    public static final boolean DEFAULT_GENERATE_EXTRA_PERIMETERS_WHERE_NEEDED = true;
    public static final int DEFAULT_SOLID_TOP_LAYERS = 3;
    public static final int DEFAULT_SOLID_BOTTOM_LAYERS = 3;

    public static final boolean DEFAULT_AVOID_CROSSING_PERIMETERS = false;
    public static final boolean DEFAULT_START_PERIMETERS_AT_CONCAVE_POINTS = false;
    public static final boolean DEFAULT_START_PERIMETERS_AT_NON_OVERHANG_POINTS = false;
    public static final boolean DEFAULT_DETECT_THIN_WALLS = true;
    public static final boolean DEFAULT_DETECT_BRIDGING_PERIMETERS = true;
    public static final boolean DEFAULT_EXTERNAL_PERIMETERS_FIRST = false;

    public LayerAndPerimeterConfiguration() {
        name = DEFAULT_NAME;
        layerHeight = DEFAULT_LAYER_HEIGHT;
        firstLayerHeight = DEFAULT_FIRST_LAYER_HEIGHT;
        perimeters = DEFAULT_PERIMETERS;
        spiralVase = DEFAULT_SPIRAL_VASE;
        randomizedStartingPoints = DEFAULT_RANDOMIZE_STARTING_POINTS;
        generateExtraPerimetersWhenNeeded = DEFAULT_GENERATE_EXTRA_PERIMETERS_WHERE_NEEDED;
        solidTopLayers = DEFAULT_SOLID_TOP_LAYERS;
        solidBottomLayers = DEFAULT_SOLID_BOTTOM_LAYERS;
        avoidCrossingPerimeters = DEFAULT_AVOID_CROSSING_PERIMETERS;
        startPerimetersAtConcavePoints = DEFAULT_START_PERIMETERS_AT_CONCAVE_POINTS;
        startPerimetersAtNonOverhangPoints = DEFAULT_START_PERIMETERS_AT_NON_OVERHANG_POINTS;
        detectThinWalls = DEFAULT_DETECT_THIN_WALLS;
        detectBridgingPerimeters = DEFAULT_DETECT_BRIDGING_PERIMETERS;
        externalPerimetersFirst = DEFAULT_EXTERNAL_PERIMETERS_FIRST;
    }
    

	// Layers and Perimeters
    private String name;
	
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

    private boolean spiralVase;

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

    private boolean avoidCrossingPerimeters;
    private boolean startPerimetersAtConcavePoints;
    private boolean startPerimetersAtNonOverhangPoints;
    private boolean detectThinWalls;
    private boolean detectBridgingPerimeters;
    private boolean externalPerimetersFirst;

    public double getLayerHeight() {
        return layerHeight;
    }

    public void setLayerHeight(double layerHeight) {
        this.layerHeight = layerHeight;
    }

    public double getFirstLayerHeight() {
        return firstLayerHeight;
    }

    public void setFirstLayerHeight(double firstLayerHeight) {
        this.firstLayerHeight = firstLayerHeight;
    }

    public int getPerimeters() {
        return perimeters;
    }

    public void setPerimeters(int perimeters) {
        this.perimeters = perimeters;
    }

    public boolean isRandomizedStartingPoints() {
        return randomizedStartingPoints;
    }

    public void setRandomizedStartingPoints(boolean randomizedStartingPoints) {
        this.randomizedStartingPoints = randomizedStartingPoints;
    }

    public boolean isGenerateExtraPerimetersWhenNeeded() {
        return generateExtraPerimetersWhenNeeded;
    }

    public void setGenerateExtraPerimetersWhenNeeded(boolean generateExtraPerimetersWhenNeeded) {
        this.generateExtraPerimetersWhenNeeded = generateExtraPerimetersWhenNeeded;
    }

    public int getSolidTopLayers() {
        return solidTopLayers;
    }

    public void setSolidTopLayers(int solidTopLayers) {
        this.solidTopLayers = solidTopLayers;
    }

    public int getSolidBottomLayers() {
        return solidBottomLayers;
    }

    public void setSolidBottomLayers(int solidBottomLayers) {
        this.solidBottomLayers = solidBottomLayers;
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
        hash = 29 * hash + Objects.hashCode(this.name);
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
        final LayerAndPerimeterConfiguration other = (LayerAndPerimeterConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.layerHeight) != Double.doubleToLongBits(other.layerHeight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.firstLayerHeight) != Double.doubleToLongBits(other.firstLayerHeight)) {
            return false;
        }
        if (this.perimeters != other.perimeters) {
            return false;
        }
        if (this.randomizedStartingPoints != other.randomizedStartingPoints) {
            return false;
        }
        if (this.generateExtraPerimetersWhenNeeded != other.generateExtraPerimetersWhenNeeded) {
            return false;
        }
        if (this.solidTopLayers != other.solidTopLayers) {
            return false;
        }
        if (this.solidBottomLayers != other.solidBottomLayers) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LayerAndPerimeterConfiguration{" + "name=" + name + ", layerHeight=" + layerHeight + ", firstLayerHeight=" + firstLayerHeight + ", perimeters=" + perimeters + ", randomizedStartingPoints=" + randomizedStartingPoints + ", generateExtraPerimetersWhenNeeded=" + generateExtraPerimetersWhenNeeded + ", solidTopLayers=" + solidTopLayers + ", solidBottomLayers=" + solidBottomLayers + '}';
    }

    /**
     * @return the spiralVase
     */
    public boolean isSpiralVase() {
        return spiralVase;
    }

    /**
     * @param spiralVase the spiralVase to set
     */
    public void setSpiralVase(boolean spiralVase) {
        this.spiralVase = spiralVase;
    }

    /**
     * @return the avoidCrossingPerimeters
     */
    public boolean isAvoidCrossingPerimeters() {
        return avoidCrossingPerimeters;
    }

    /**
     * @param avoidCrossingPerimeters the avoidCrossingPerimeters to set
     */
    public void setAvoidCrossingPerimeters(boolean avoidCrossingPerimeters) {
        this.avoidCrossingPerimeters = avoidCrossingPerimeters;
    }

    /**
     * @return the startPerimetersAtConcavePoints
     */
    public boolean isStartPerimetersAtConcavePoints() {
        return startPerimetersAtConcavePoints;
    }

    /**
     * @param startPerimetersAtConcavePoints the startPerimetersAtConcavePoints to set
     */
    public void setStartPerimetersAtConcavePoints(boolean startPerimetersAtConcavePoints) {
        this.startPerimetersAtConcavePoints = startPerimetersAtConcavePoints;
    }

    /**
     * @return the startPerimetersAtNonOverhangPoints
     */
    public boolean isStartPerimetersAtNonOverhangPoints() {
        return startPerimetersAtNonOverhangPoints;
    }

    /**
     * @param startPerimetersAtNonOverhangPoints the startPerimetersAtNonOverhangPoints to set
     */
    public void setStartPerimetersAtNonOverhangPoints(boolean startPerimetersAtNonOverhangPoints) {
        this.startPerimetersAtNonOverhangPoints = startPerimetersAtNonOverhangPoints;
    }

    /**
     * @return the detectThinWalls
     */
    public boolean isDetectThinWalls() {
        return detectThinWalls;
    }

    /**
     * @param detectThinWalls the detectThinWalls to set
     */
    public void setDetectThinWalls(boolean detectThinWalls) {
        this.detectThinWalls = detectThinWalls;
    }

    /**
     * @return the detectBridgingPerimeters
     */
    public boolean isDetectBridgingPerimeters() {
        return detectBridgingPerimeters;
    }

    /**
     * @param detectBridgingPerimeters the detectBridgingPerimeters to set
     */
    public void setDetectBridgingPerimeters(boolean detectBridgingPerimeters) {
        this.detectBridgingPerimeters = detectBridgingPerimeters;
    }

    /**
     * @return the externalPerimetersFirst
     */
    public boolean isExternalPerimetersFirst() {
        return externalPerimetersFirst;
    }

    /**
     * @param externalPerimetersFirst the externalPerimetersFirst to set
     */
    public void setExternalPerimetersFirst(boolean externalPerimetersFirst) {
        this.externalPerimetersFirst = externalPerimetersFirst;
    }
    
    
}
