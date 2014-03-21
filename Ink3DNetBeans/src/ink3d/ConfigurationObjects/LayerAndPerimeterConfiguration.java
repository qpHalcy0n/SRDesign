package ink3d.ConfigurationObjects;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LayerAndPerimeterConfiguration {
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
    
    
}
