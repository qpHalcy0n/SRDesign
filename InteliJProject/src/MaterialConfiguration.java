
public class MaterialConfiguration {
    private SpeedConfiguration speedConfiguration;
	/**
	 * Diameter in mm of the filament.
	 */
	private double filamentDiameter;
	
	/**
	 * Flow rate multiplier.  This changes the flow rate proportionally.
	 * 0.9 will be 90% flow rate, while 1.1 will be 110% flow rate.
	 */
    private double extruionMultiplier;
    
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
}
