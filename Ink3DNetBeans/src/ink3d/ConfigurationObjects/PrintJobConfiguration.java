package ink3d.ConfigurationObjects;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PrintJobConfiguration {

    public static final String DEFAULT_NAME = "Default";
    public static final boolean DEFAULT_COMPLETE_INDIVIDUAL_OBJECTS = false;
    public static final boolean DEFAULT_OOZE_PREVENTION = false;
    public static final int DEFAULT_TEMPERATURE_DELTA = -5;
    public static final double DEFAULT_EXTRUDER_CLEARANCE_RADIUS = 20.0;
    public static final double DEFAULT_EXTRUDER_CLEARANCE_HEIGHT = 20.0;
    public static final boolean DEFAULT_VERBOSE_GCODE = false;

    private String name;
    private PrinterConfiguration printerConfiguration;
    private List <SubsetConfiguration> subsetConfigurationList;
    private boolean completeIndividualObjects;
    private boolean oozePrevention;
    private int temperatureDelta;
    private double extruderClearanceRadius;
    private double extruderClearanceHeight;
    private boolean verboseGCode;
    private File finalizedGCode;


    /**
     * Mapping of materials to extruders.
     * i.e. extruderMaterials[0] is the material that is loaded into extruder 0
     */
    private List<MaterialConfiguration> extruderMaterials;

    public PrintJobConfiguration() {
        this.name = DEFAULT_NAME;
        this.printerConfiguration = new PrinterConfiguration();
        this.subsetConfigurationList = new ArrayList<SubsetConfiguration>();
        this.extruderMaterials = new ArrayList<MaterialConfiguration>();
        this.completeIndividualObjects = DEFAULT_COMPLETE_INDIVIDUAL_OBJECTS;
        this.oozePrevention = DEFAULT_OOZE_PREVENTION;
        this.temperatureDelta = DEFAULT_TEMPERATURE_DELTA;
        this.extruderClearanceRadius = DEFAULT_EXTRUDER_CLEARANCE_RADIUS;
        this.extruderClearanceHeight = DEFAULT_EXTRUDER_CLEARANCE_HEIGHT;
        this.verboseGCode = DEFAULT_VERBOSE_GCODE;
    }

    public MaterialConfiguration getMaterialForExtruderPosition(int i) {
        return extruderMaterials.get(i);
    }

    public PrinterConfiguration getPrinterConfiguration() {
        return printerConfiguration;
    }

    public void setPrinterConfiguration(PrinterConfiguration printerConfiguration) {
        this.printerConfiguration = printerConfiguration;
    }

    public List<SubsetConfiguration> getSubsetConfigurationList() {
        return subsetConfigurationList;
    }

    public void setSubsetConfigurationList(List<SubsetConfiguration> subsetConfigurationList) {
        this.subsetConfigurationList = subsetConfigurationList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.printerConfiguration);
        hash = 17 * hash + Objects.hashCode(this.subsetConfigurationList);
        hash = 17 * hash + Objects.hashCode(this.getExtruderMaterials());
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
        final PrintJobConfiguration other = (PrintJobConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.printerConfiguration, other.printerConfiguration)) {
            return false;
        }
        if (!Objects.equals(this.subsetConfigurationList, other.subsetConfigurationList)) {
            return false;
        }
        if (!Objects.equals(this.extruderMaterials, other.extruderMaterials)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PrintJobConfiguration{" + "name=" + name + ", printerConfiguration=" + printerConfiguration + ", subsetConfigurationList=" + subsetConfigurationList + ", extruderMaterials=" + getExtruderMaterials() + '}';
    }

    /**
     * @return the extruderMaterials
     */
    public List<MaterialConfiguration> getExtruderMaterials() {
        return extruderMaterials;
    }

    /**
     * @param extruderMaterials the extruderMaterials to set
     */
    public void setExtruderMaterials(List<MaterialConfiguration> extruderMaterials) {
        this.extruderMaterials = extruderMaterials;
    }

    /**
     * @return the oozePrevention
     */
    public boolean isOozePrevention() {
        return oozePrevention;
    }

    /**
     * @param oozePrevention the oozePrevention to set
     */
    public void setOozePrevention(boolean oozePrevention) {
        this.oozePrevention = oozePrevention;
    }

    /**
     * @return the temperatureDelta
     */
    public int getTemperatureDelta() {
        return temperatureDelta;
    }

    /**
     * @param temperatureDelta the temperatureDelta to set
     */
    public void setTemperatureDelta(int temperatureDelta) {
        this.setTemperatureDelta(temperatureDelta);
    }

    /**
     * @return the extruderClearanceRadius
     */
    public double getExtruderClearanceRadius() {
        return extruderClearanceRadius;
    }

    /**
     * @param extruderClearanceRadius the extruderClearanceRadius to set
     */
    public void setExtruderClearanceRadius(double extruderClearanceRadius) {
        this.extruderClearanceRadius = extruderClearanceRadius;
    }

    /**
     * @return the extruderClearanceHeight
     */
    public double getExtruderClearanceHeight() {
        return extruderClearanceHeight;
    }

    /**
     * @param extruderClearanceHeight the extruderClearanceHeight to set
     */
    public void setExtruderClearanceHeight(double extruderClearanceHeight) {
        this.extruderClearanceHeight = extruderClearanceHeight;
    }

    /**
     * @return the finalizedGCode
     */
    public File getFinalizedGCode() {
        return finalizedGCode;
    }

    /**
     * @param finalizedGCode the finalizedGCode to set
     */
    public void setFinalizedGCode(File finalizedGCode) {
        this.finalizedGCode = finalizedGCode;
    }

    /**
     * @return the completeIndividualObjects
     */
    public boolean isCompleteIndividualObjects() {
        return completeIndividualObjects;
    }

    /**
     * @param completeIndividualObjects the completeIndividualObjects to set
     */
    public void setCompleteIndividualObjects(boolean completeIndividualObjects) {
        this.completeIndividualObjects = completeIndividualObjects;
    }

    /**
     * @return the verboseGCode
     */
    public boolean isVerboseGCode() {
        return verboseGCode;
    }

    /**
     * @param verboseGCode the verboseGCode to set
     */
    public void setVerboseGCode(boolean verboseGCode) {
        this.verboseGCode = verboseGCode;
    }

    
}
