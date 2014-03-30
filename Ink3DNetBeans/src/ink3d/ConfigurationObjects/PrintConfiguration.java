package ink3d.ConfigurationObjects;

/**
 * Created by daniellain on 2/8/14.
 */
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PrintConfiguration {
    private String name;
    private InfillConfiguration infillConfiguration;
    private LayerAndPerimeterConfiguration layerPerimiterConfiguration;
    private SpeedConfiguration speedConfiguration;
    private SkirtAndBrimConfiguration skirtAndBrimConfiguration;
    private SupportMaterialConfiguration supportMaterialConfiguration;

    public PrintConfiguration() {
        this.infillConfiguration = new InfillConfiguration();
        this.layerPerimiterConfiguration = new LayerAndPerimeterConfiguration();
        this.speedConfiguration = new SpeedConfiguration();
        this.skirtAndBrimConfiguration = new SkirtAndBrimConfiguration();
        this.supportMaterialConfiguration = new SupportMaterialConfiguration();
    }

    public InfillConfiguration getInfillConfiguration() {
        return infillConfiguration;
    }

    public void setInfillConfiguration(InfillConfiguration infillConfiguration) {
        this.infillConfiguration = infillConfiguration;
    }

    public LayerAndPerimeterConfiguration getLayerPerimiterConfiguration() {
        return layerPerimiterConfiguration;
    }

    public void setLayerPerimiterConfiguration(LayerAndPerimeterConfiguration layerPerimiterConfiguration) {
        this.layerPerimiterConfiguration = layerPerimiterConfiguration;
    }

    public SpeedConfiguration getSpeedConfiguration() {
        return speedConfiguration;
    }

    public void setSpeedConfiguration(SpeedConfiguration speedConfiguration) {
        this.speedConfiguration = speedConfiguration;
    }

    public SkirtAndBrimConfiguration getSkirtAndBrimConfiguration() {
        return skirtAndBrimConfiguration;
    }

    public void setSkirtAndBrimConfiguration(SkirtAndBrimConfiguration skirtAndBrimConfiguration) {
        this.skirtAndBrimConfiguration = skirtAndBrimConfiguration;
    }

    public SupportMaterialConfiguration getSupportMaterialConfiguration() {
        return supportMaterialConfiguration;
    }

    public void setSupportMaterialConfiguration(SupportMaterialConfiguration supportMaterialConfiguration) {
        this.supportMaterialConfiguration = supportMaterialConfiguration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   

    @Override
    public int hashCode() {
        int hash = 3;
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
        final PrintConfiguration other = (PrintConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.infillConfiguration, other.infillConfiguration)) {
            return false;
        }
        if (!Objects.equals(this.layerPerimiterConfiguration, other.layerPerimiterConfiguration)) {
            return false;
        }
        if (!Objects.equals(this.speedConfiguration, other.speedConfiguration)) {
            return false;
        }
        if (!Objects.equals(this.skirtAndBrimConfiguration, other.skirtAndBrimConfiguration)) {
            return false;
        }
        if (!Objects.equals(this.supportMaterialConfiguration, other.supportMaterialConfiguration)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PrintConfiguration{" + "name=" + name + ", infillConfiguration=" + infillConfiguration + ", layerPerimiterConfiguration=" + layerPerimiterConfiguration + ", speedConfiguration=" + speedConfiguration + ", skirtAndBrimConfiguration=" + skirtAndBrimConfiguration + ", supportMaterialConfiguration=" + supportMaterialConfiguration + '}';
    }
    
    
}
