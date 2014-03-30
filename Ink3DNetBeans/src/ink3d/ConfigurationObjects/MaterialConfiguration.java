package ink3d.ConfigurationObjects;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MaterialConfiguration {
    
    // General Material Options
    public static final String DEFAULT_NAME = "Default";
    public static final double DEFAULT_FILAMENT_DIAMETER = 3.0;
    public static final double DEFAULT_EXTRUSION_MULTIPLIER = 1.0;

    // Temperature Options
    public static final int DEFAULT_FIRST_LAYER_EXTRUSION_TEMPERATURE = 200;
    public static final int DEFAULT_EXTRUSION_TEMPERATURE = 200;
    public static final int DEFAULT_FIRST_LAYER_BED_TEMPERATURE = 0;
    public static final int DEFAULT_BED_TEMPERATURE = 0;

    // Cooling Options
    public static final boolean DEFAULT_FAN_ALWAYS_ON = false;
    public static final boolean DEFAULT_ENABLE_AUTO_COOLING = true;
    public static final int DEFAULT_MIN_FAN_SPEED = 35;
    public static final int DEFAULT_MAX_FAN_SPEED = 100;
    public static final int DEFAULT_BRIDGE_FAN_SPEED_PERCENT = 100;
    public static final int DEFAULT_DISABLE_FAN_FOR_FIRST_N_LAYERS = 1;
    public static final int DEFAULT_ENABLE_FAN_TIME_THRESHOLD = 60;
    public static final int DEFAULT_SLOW_DOWN_TIME_THRESHOLD = 30;
    public static final int DEFAULT_MIN_PRINT_SPEED = 10;

    // Retraction Options
    public static final double DEFAULT_RETRACTION_LENGTH = 1.0;
    public static final double DEFAULT_RETRACTION_LIFT_Z = 0.0;
    public static final int DEFAULT_RETRACTION_SPEED = 30;
    public static final double DEFAULT_EXTRA_LENGTH_AFTER_RETRACTION = 0.0;
    public static final double DEFAULT_MINIMUM_TRAVEL_AFTER_RETRACTION = 2.0;
    public static final boolean DEFAULT_RETRACT_ON_LAYER_CHANGE = true;
    public static final boolean DEFAULT_WIPE_BEFORE_RETRACT = false;
    public static final double DEFAULT_RETRACTION_LENGTH_BEFORE_TOOL_CHANGE = 10.0;
    public static final double DEFAULT_EXTRA_LENGTH_ON_TOOL_REENABLE = 0.0;

    public MaterialConfiguration() {
        name = DEFAULT_NAME;
        filamentDiameter = DEFAULT_FILAMENT_DIAMETER;
        extrusionMultiplier = DEFAULT_EXTRUSION_MULTIPLIER;
        firstLayerExtrusionTemperature = DEFAULT_FIRST_LAYER_EXTRUSION_TEMPERATURE;
        extrusionTemperature = DEFAULT_EXTRUSION_TEMPERATURE;

        // TODO: Add bed temperatures options
        
        fanAlwaysOn = DEFAULT_FAN_ALWAYS_ON;
        enableAutoCooling = DEFAULT_ENABLE_AUTO_COOLING;
        minFanSpeed = DEFAULT_MIN_FAN_SPEED;
        maxFanSpeed = DEFAULT_MAX_FAN_SPEED;
        bridgeFanSpeedPercent = DEFAULT_BRIDGE_FAN_SPEED_PERCENT;
        disableFanForFirstNLayers = DEFAULT_DISABLE_FAN_FOR_FIRST_N_LAYERS;
        enableFanTimeThreshold = DEFAULT_ENABLE_FAN_TIME_THRESHOLD;
        slowDownTimeTreshold = DEFAULT_SLOW_DOWN_TIME_THRESHOLD;
        minPrintSpeed = DEFAULT_MIN_PRINT_SPEED;
        retractionLength = DEFAULT_RETRACTION_LENGTH;
        retractionLiftZ = DEFAULT_RETRACTION_LIFT_Z;
        retractionSpeed = DEFAULT_RETRACTION_SPEED;
        extraLengthAfterRetraction = DEFAULT_EXTRA_LENGTH_AFTER_RETRACTION;
        minimumTravelAfterRetraction = DEFAULT_MINIMUM_TRAVEL_AFTER_RETRACTION;
        retractOnLayerChange = DEFAULT_RETRACT_ON_LAYER_CHANGE;
        wipeBeforeRetract = DEFAULT_WIPE_BEFORE_RETRACT;
        retractionLengthBeforeToolChange = DEFAULT_RETRACTION_LENGTH_BEFORE_TOOL_CHANGE;
        extraLengthOnToolReenable = DEFAULT_EXTRA_LENGTH_ON_TOOL_REENABLE;

    }


    private String name;

    /**
     * Diameter in mm of the filament.
     */
    private double filamentDiameter;

    /**
     * Flow rate multiplier.  This changes the flow rate proportionally.
     * 0.9 will be 90% flow rate, while 1.1 will be 110% flow rate.
     */
    private double extrusionMultiplier;
    
    /**
     * The temperature (in degrees C) the extruder needs to be to extrude the first layer
     * of this material.
     */
    private int firstLayerExtrusionTemperature;
    
    /**
     * The temperature (in degrees C) the extruder needs to be to extrude this material.
     */
    private int extrusionTemperature;
    
    /**
     * Length (in mm) to retract during retraction. 0 to disable retraction.
     */
    private double retractionLength;
    
    /**
     * The (positive) z value to quickly lift the extruder by during a retraction.
     */
    private double retractionLiftZ;
    
    /**
     * The speed (in mm/s) at which to retract the filament during retraction
     * (extruder motor speed).
     */
    private int retractionSpeed;
    
    /**
     * The extra length of filament to push out during the first extrude after a retraction.
     */
    private double extraLengthAfterRetraction;
    
    /**
     * Retraction is not triggered when travel moves shorter than this distance.
     */
    private double minimumTravelAfterRetraction;
    
    /**
     * When set to true, retraction will be triggered on each layer change.
     */
    private boolean retractOnLayerChange;
    
    /**
     * When set to true, the nozzle will be moved while retracting to reduce blob.
     */
    private boolean wipeBeforeRetract;
    
    /**
     * Length (in mm) to retract when the tool is disabled.
     */
    private double retractionLengthBeforeToolChange;
    
    /**
     * The extra length of filament to push out during the first extrude 
     * after the tool is re-enabled.
     */
    private double extraLengthOnToolReenable;
    
    /**
     * When set to true, fan will always run at at least minimum speed.
     */
    private boolean fanAlwaysOn;
    
    /**
     * When set to true, fan speed will automatically be set based on
     * printing time.
     */
    private boolean enableAutoCooling;
    
    /**
     * The minimum fan speed in PWM.
     */
    private int minFanSpeed;
    
    /**
     * The maximum fan speed in PWM.
     */
    private int maxFanSpeed;
    
    /**
     * The percentage of default fan speed used for bridges
     * expressed as an int (100 = 100%)
     */
    private int bridgeFanSpeedPercent;
    
    /**
     * The number of first layers to disable the fan for.
     */
    private int disableFanForFirstNLayers;
    
    /**
     * If the print time of a layer is below this threshold (in seconds),
     * the fan will be activated.
     */
    private int enableFanTimeThreshold;
    
    /**
     * If the print time of a layer is below this threshold (in seconds),
     * the move speed will be slowed to attempt to get the
     * layer print time up to this threshold.
     */
    private int slowDownTimeTreshold;
    
    /**
     * The move speed will not be scaled down below this speed (in mm/s).
     */
    private int minPrintSpeed;

    public double getFilamentDiameter() {
        return filamentDiameter;
    }

    public void setFilamentDiameter(double filamentDiameter) {
        this.filamentDiameter = filamentDiameter;
    }

    public double getExtrusionMultiplier() {
        return extrusionMultiplier;
    }

    public void setExtrusionMultiplier(double extrusionMultiplier) {
        this.extrusionMultiplier = extrusionMultiplier;
    }

    public int getFirstLayerExtrusionTemperature() {
        return firstLayerExtrusionTemperature;
    }

    public void setFirstLayerExtrusionTemperature(int firstLayerExtrusionTemperature) {
        this.firstLayerExtrusionTemperature = firstLayerExtrusionTemperature;
    }

    public int getExtrusionTemperature() {
        return extrusionTemperature;
    }

    public void setExtrusionTemperature(int extrusionTemperature) {
        this.extrusionTemperature = extrusionTemperature;
    }

    public double getRetractionLength() {
        return retractionLength;
    }

    public void setRetractionLength(double retractionLength) {
        this.retractionLength = retractionLength;
    }

    public double getRetractionLiftZ() {
        return retractionLiftZ;
    }

    public void setRetractionLiftZ(double retractionLiftZ) {
        this.retractionLiftZ = retractionLiftZ;
    }

    public int getRetractionSpeed() {
        return retractionSpeed;
    }

    public void setRetractionSpeed(int retractionSpeed) {
        this.retractionSpeed = retractionSpeed;
    }

    public double getExtraLengthAfterRetraction() {
        return extraLengthAfterRetraction;
    }

    public void setExtraLengthAfterRetraction(double extraLengthAfterRetraction) {
        this.extraLengthAfterRetraction = extraLengthAfterRetraction;
    }

    public double getMinimumTravelAfterRetraction() {
        return minimumTravelAfterRetraction;
    }

    public void setMinimumTravelAfterRetraction(double minimumTravelAfterRetraction) {
        this.minimumTravelAfterRetraction = minimumTravelAfterRetraction;
    }

    public boolean isRetractOnLayerChange() {
        return retractOnLayerChange;
    }

    public void setRetractOnLayerChange(boolean retractOnLayerChange) {
        this.retractOnLayerChange = retractOnLayerChange;
    }

    public boolean isWipeBeforeRetract() {
        return wipeBeforeRetract;
    }

    public void setWipeBeforeRetract(boolean wipeBeforeRetract) {
        this.wipeBeforeRetract = wipeBeforeRetract;
    }

    public double getRetractionLengthBeforeToolChange() {
        return retractionLengthBeforeToolChange;
    }

    public void setRetractionLengthBeforeToolChange(double retractionLengthBeforeToolChange) {
        this.retractionLengthBeforeToolChange = retractionLengthBeforeToolChange;
    }

    public double getExtraLengthOnToolReenable() {
        return extraLengthOnToolReenable;
    }

    public void setExtraLengthOnToolReenable(double extraLengthOnToolReenable) {
        this.extraLengthOnToolReenable = extraLengthOnToolReenable;
    }

    public boolean isFanAlwaysOn() {
        return fanAlwaysOn;
    }

    public void setFanAlwaysOn(boolean fanAlwaysOn) {
        this.fanAlwaysOn = fanAlwaysOn;
    }

    public boolean isEnableAutoCooling() {
        return enableAutoCooling;
    }

    public void setEnableAutoCooling(boolean enableAutoCooling) {
        this.enableAutoCooling = enableAutoCooling;
    }

    public int getMinFanSpeed() {
        return minFanSpeed;
    }

    public void setMinFanSpeed(int minFanSpeed) {
        this.minFanSpeed = minFanSpeed;
    }

    public int getMaxFanSpeed() {
        return maxFanSpeed;
    }

    public void setMaxFanSpeed(int maxFanSpeed) {
        this.maxFanSpeed = maxFanSpeed;
    }

    public int getBridgeFanSpeedPercent() {
        return bridgeFanSpeedPercent;
    }

    public void setBridgeFanSpeedPercent(int bridgeFanSpeedPercent) {
        this.bridgeFanSpeedPercent = bridgeFanSpeedPercent;
    }

    public int getDisableFanForFirstNLayers() {
        return disableFanForFirstNLayers;
    }

    public void setDisableFanForFirstNLayers(int disableFanForFirstNLayers) {
        this.disableFanForFirstNLayers = disableFanForFirstNLayers;
    }

    public int getEnableFanTimeThreshold() {
        return enableFanTimeThreshold;
    }

    public void setEnableFanTimeThreshold(int enableFanTimeThreshold) {
        this.enableFanTimeThreshold = enableFanTimeThreshold;
    }

    public int getSlowDownTimeTreshold() {
        return slowDownTimeTreshold;
    }

    public void setSlowDownTimeTreshold(int slowDownTimeTreshold) {
        this.slowDownTimeTreshold = slowDownTimeTreshold;
    }

    public int getMinPrintSpeed() {
        return minPrintSpeed;
    }

    public void setMinPrintSpeed(int minPrintSpeed) {
        this.minPrintSpeed = minPrintSpeed;
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
        hash = 53 * hash + Objects.hashCode(this.name);
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
        final MaterialConfiguration other = (MaterialConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.filamentDiameter) != Double.doubleToLongBits(other.filamentDiameter)) {
            return false;
        }
        if (Double.doubleToLongBits(this.extrusionMultiplier) != Double.doubleToLongBits(other.extrusionMultiplier)) {
            return false;
        }
        if (this.firstLayerExtrusionTemperature != other.firstLayerExtrusionTemperature) {
            return false;
        }
        if (this.extrusionTemperature != other.extrusionTemperature) {
            return false;
        }
        if (Double.doubleToLongBits(this.retractionLength) != Double.doubleToLongBits(other.retractionLength)) {
            return false;
        }
        if (Double.doubleToLongBits(this.retractionLiftZ) != Double.doubleToLongBits(other.retractionLiftZ)) {
            return false;
        }
        if (this.retractionSpeed != other.retractionSpeed) {
            return false;
        }
        if (Double.doubleToLongBits(this.extraLengthAfterRetraction) != Double.doubleToLongBits(other.extraLengthAfterRetraction)) {
            return false;
        }
        if (Double.doubleToLongBits(this.minimumTravelAfterRetraction) != Double.doubleToLongBits(other.minimumTravelAfterRetraction)) {
            return false;
        }
        if (this.retractOnLayerChange != other.retractOnLayerChange) {
            return false;
        }
        if (this.wipeBeforeRetract != other.wipeBeforeRetract) {
            return false;
        }
        if (Double.doubleToLongBits(this.retractionLengthBeforeToolChange) != Double.doubleToLongBits(other.retractionLengthBeforeToolChange)) {
            return false;
        }
        if (Double.doubleToLongBits(this.extraLengthOnToolReenable) != Double.doubleToLongBits(other.extraLengthOnToolReenable)) {
            return false;
        }
        if (this.fanAlwaysOn != other.fanAlwaysOn) {
            return false;
        }
        if (this.enableAutoCooling != other.enableAutoCooling) {
            return false;
        }
        if (this.minFanSpeed != other.minFanSpeed) {
            return false;
        }
        if (this.maxFanSpeed != other.maxFanSpeed) {
            return false;
        }
        if (this.bridgeFanSpeedPercent != other.bridgeFanSpeedPercent) {
            return false;
        }
        if (this.disableFanForFirstNLayers != other.disableFanForFirstNLayers) {
            return false;
        }
        if (this.enableFanTimeThreshold != other.enableFanTimeThreshold) {
            return false;
        }
        if (this.slowDownTimeTreshold != other.slowDownTimeTreshold) {
            return false;
        }
        if (this.minPrintSpeed != other.minPrintSpeed) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MaterialConfiguration{" + "name=" + name + ", speedConfiguration=" + speedConfiguration + ", filamentDiameter=" + filamentDiameter + ", extrusionMultiplier=" + extrusionMultiplier + ", firstLayerExtrusionTemperature=" + firstLayerExtrusionTemperature + ", extrusionTemperature=" + extrusionTemperature + ", retractionLength=" + retractionLength + ", retractionLiftZ=" + retractionLiftZ + ", retractionSpeed=" + retractionSpeed + ", extraLengthAfterRetraction=" + extraLengthAfterRetraction + ", minimumTravelAfterRetraction=" + minimumTravelAfterRetraction + ", retractOnLayerChange=" + retractOnLayerChange + ", wipeBeforeRetract=" + wipeBeforeRetract + ", retractionLengthBeforeToolChange=" + retractionLengthBeforeToolChange + ", extraLengthOnToolReenable=" + extraLengthOnToolReenable + ", fanAlwaysOn=" + fanAlwaysOn + ", enableAutoCooling=" + enableAutoCooling + ", minFanSpeed=" + minFanSpeed + ", maxFanSpeed=" + maxFanSpeed + ", bridgeFanSpeedPercent=" + bridgeFanSpeedPercent + ", disableFanForFirstNLayers=" + disableFanForFirstNLayers + ", enableFanTimeThreshold=" + enableFanTimeThreshold + ", slowDownTimeTreshold=" + slowDownTimeTreshold + ", minPrintSpeed=" + minPrintSpeed + '}';
    }
    
}
