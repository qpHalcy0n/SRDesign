package ink3d.ConfigurationObjects;

/**
 * Created by daniellain on 2/8/14.
 */
public class PrintConfiguration {
    private InfillConfiguration infillConfiguration;
    private LayerAndPerimeterConfiguration layerPerimiterConfiguration;
    private SpeedConfiguration speedConfiguration;
    private SkirtAndBrimConfiguration skirtAndBrimConfiguration;
    private SupportMaterialConfiguration supportMaterialConfiguration;

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
    
    
}
