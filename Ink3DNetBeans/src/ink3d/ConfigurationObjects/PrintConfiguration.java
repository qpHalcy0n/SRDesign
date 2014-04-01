package ink3d.ConfigurationObjects;

/**
 * Created by daniellain on 2/8/14.
 */
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PrintConfiguration {
    public static final int DEFAULT_BED_TEMPERATURE = 0;
    public static final int DEFAULT_FIRST_LAYER_BED_TEMPERATURE = 0;
    public static final double DEFAULT_BRIDGE_FLOW_RATIO = 1.0;
    public static final int DEFAULT_PERIMETER_EXTRUDER = 0;
    public static final int DEFAULT_INFILL_EXTRUDER = 0;
    public static final int DEFAULT_SUPPORT_MATERIAL_EXTRUDER = 0;
    public static final int DEFAULT_SUPPORT_MATERIAL_INTERFACE_EXTRUDER = 0;
    public static final String DEFAULT_LAYER_CHANGE_GCODE = "";

    private String name;
    private InfillConfiguration infillConfiguration;
    private LayerAndPerimeterConfiguration layerPerimiterConfiguration;
    private SpeedConfiguration speedConfiguration;
    private SkirtAndBrimConfiguration skirtAndBrimConfiguration;
    private SupportMaterialConfiguration supportMaterialConfiguration;
    private CoolingConfiguration coolingConfiguration;
    private ExtrusionWidthConfiguration extrusionWidthConfiguration;
    private int bedTemperature;
    private int firstLayerBedTemperature;
    private double bridgeFlowRatio;
    private int perimeterExtruder;
    private int infillExtruder;
    private int supportMaterialExtruder;
    private int supportMaterialInterfaceExtruder;
    private String layerChangeGCode;

    public PrintConfiguration() {
        this.infillConfiguration = new InfillConfiguration();
        this.layerPerimiterConfiguration = new LayerAndPerimeterConfiguration();
        this.speedConfiguration = new SpeedConfiguration();
        this.skirtAndBrimConfiguration = new SkirtAndBrimConfiguration();
        this.supportMaterialConfiguration = new SupportMaterialConfiguration();
        this.coolingConfiguration = new CoolingConfiguration();
        this.extrusionWidthConfiguration = new ExtrusionWidthConfiguration();
        this.bedTemperature = DEFAULT_BED_TEMPERATURE;
        this.firstLayerBedTemperature = DEFAULT_FIRST_LAYER_BED_TEMPERATURE;
        this.bridgeFlowRatio = DEFAULT_BRIDGE_FLOW_RATIO;
        this.perimeterExtruder = DEFAULT_PERIMETER_EXTRUDER;
        this.infillExtruder = DEFAULT_INFILL_EXTRUDER;
        this.supportMaterialExtruder = DEFAULT_SUPPORT_MATERIAL_EXTRUDER;
        this.supportMaterialInterfaceExtruder = DEFAULT_SUPPORT_MATERIAL_INTERFACE_EXTRUDER;
        this.layerChangeGCode = DEFAULT_LAYER_CHANGE_GCODE;
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

    /**
     * @return the bedTemperature
     */
    public int getBedTemperature() {
        return bedTemperature;
    }

    /**
     * @param bedTemperature the bedTemperature to set
     */
    public void setBedTemperature(int bedTemperature) {
        this.bedTemperature = bedTemperature;
    }

    /**
     * @return the firstLayerBedTemperature
     */
    public int getFirstLayerBedTemperature() {
        return firstLayerBedTemperature;
    }

    /**
     * @param firstLayerBedTemperature the firstLayerBedTemperature to set
     */
    public void setFirstLayerBedTemperature(int firstLayerBedTemperature) {
        this.firstLayerBedTemperature = firstLayerBedTemperature;
    }

    /**
     * @return the coolingConfiguration
     */
    public CoolingConfiguration getCoolingConfiguration() {
        return coolingConfiguration;
    }

    /**
     * @param coolingConfiguration the coolingConfiguration to set
     */
    public void setCoolingConfiguration(CoolingConfiguration coolingConfiguration) {
        this.coolingConfiguration = coolingConfiguration;
    }

    /**
     * @return the bridgeFlowRatio
     */
    public double getBridgeFlowRatio() {
        return bridgeFlowRatio;
    }

    /**
     * @param bridgeFlowRatio the bridgeFlowRatio to set
     */
    public void setBridgeFlowRatio(double bridgeFlowRatio) {
        this.bridgeFlowRatio = bridgeFlowRatio;
    }

    /**
     * @return the perimeterExtruder
     */
    public int getPerimeterExtruder() {
        return perimeterExtruder;
    }

    /**
     * @param perimeterExtruder the perimeterExtruder to set
     */
    public void setPerimeterExtruder(int perimeterExtruder) {
        this.perimeterExtruder = perimeterExtruder;
    }

    /**
     * @return the infillExtruder
     */
    public int getInfillExtruder() {
        return infillExtruder;
    }

    /**
     * @param infillExtruder the infillExtruder to set
     */
    public void setInfillExtruder(int infillExtruder) {
        this.infillExtruder = infillExtruder;
    }

    /**
     * @return the supportMaterialExtruder
     */
    public int getSupportMaterialExtruder() {
        return supportMaterialExtruder;
    }

    /**
     * @param supportMaterialExtruder the supportMaterialExtruder to set
     */
    public void setSupportMaterialExtruder(int supportMaterialExtruder) {
        this.supportMaterialExtruder = supportMaterialExtruder;
    }

    /**
     * @return the supportMaterialInterfaceExtruder
     */
    public int getSupportMaterialInterfaceExtruder() {
        return supportMaterialInterfaceExtruder;
    }

    /**
     * @param supportMaterialInterfaceExtruder the supportMaterialInterfaceExtruder to set
     */
    public void setSupportMaterialInterfaceExtruder(int supportMaterialInterfaceExtruder) {
        this.supportMaterialInterfaceExtruder = supportMaterialInterfaceExtruder;
    }

    /**
     * @return the layerChangeGCode
     */
    public String getLayerChangeGCode() {
        return layerChangeGCode;
    }

    /**
     * @param layerChangeGCode the layerChangeGCode to set
     */
    public void setLayerChangeGCode(String layerChangeGCode) {
        this.layerChangeGCode = layerChangeGCode;
    }

    /**
     * @return the extrusionWidthConfiguration
     */
    public ExtrusionWidthConfiguration getExtrusionWidthConfiguration() {
        return extrusionWidthConfiguration;
    }

    /**
     * @param extrusionWidthConfiguration the extrusionWidthConfiguration to set
     */
    public void setExtrusionWidthConfiguration(ExtrusionWidthConfiguration extrusionWidthConfiguration) {
        this.extrusionWidthConfiguration = extrusionWidthConfiguration;
    }
    
    
}
