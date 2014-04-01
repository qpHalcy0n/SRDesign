/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.ConfigurationObjects;

/**
 *
 * @author Tim
 */
public class CoolingConfiguration {

    // Cooling Options
    public static final String DEFAULT_NAME = "Default";
    public static final boolean DEFAULT_FAN_ALWAYS_ON = false;
    public static final boolean DEFAULT_ENABLE_AUTO_COOLING = true;
    public static final int DEFAULT_MIN_FAN_SPEED = 35;
    public static final int DEFAULT_MAX_FAN_SPEED = 100;
    public static final int DEFAULT_BRIDGE_FAN_SPEED_PERCENT = 100;
    public static final int DEFAULT_DISABLE_FAN_FOR_FIRST_N_LAYERS = 1;
    public static final int DEFAULT_ENABLE_FAN_TIME_THRESHOLD = 60;
    public static final int DEFAULT_SLOW_DOWN_TIME_THRESHOLD = 30;
    public static final int DEFAULT_MIN_PRINT_SPEED = 10;

    public CoolingConfiguration() {
        name = DEFAULT_NAME;
        fanAlwaysOn = DEFAULT_FAN_ALWAYS_ON;
        enableAutoCooling = DEFAULT_ENABLE_AUTO_COOLING;
        minFanSpeed = DEFAULT_MIN_FAN_SPEED;
        maxFanSpeed = DEFAULT_MAX_FAN_SPEED;
        bridgeFanSpeedPercent = DEFAULT_BRIDGE_FAN_SPEED_PERCENT;
        disableFanForFirstNLayers = DEFAULT_DISABLE_FAN_FOR_FIRST_N_LAYERS;
        enableFanTimeThreshold = DEFAULT_ENABLE_FAN_TIME_THRESHOLD;
        slowDownTimeTreshold = DEFAULT_SLOW_DOWN_TIME_THRESHOLD;
        minPrintSpeed = DEFAULT_MIN_PRINT_SPEED;
    }

    private String name;
    
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

    /**
     * @return the fanAlwaysOn
     */
    public boolean isFanAlwaysOn() {
        return fanAlwaysOn;
    }

    /**
     * @param fanAlwaysOn the fanAlwaysOn to set
     */
    public void setFanAlwaysOn(boolean fanAlwaysOn) {
        this.fanAlwaysOn = fanAlwaysOn;
    }

    /**
     * @return the enableAutoCooling
     */
    public boolean isEnableAutoCooling() {
        return enableAutoCooling;
    }

    /**
     * @param enableAutoCooling the enableAutoCooling to set
     */
    public void setEnableAutoCooling(boolean enableAutoCooling) {
        this.enableAutoCooling = enableAutoCooling;
    }

    /**
     * @return the minFanSpeed
     */
    public int getMinFanSpeed() {
        return minFanSpeed;
    }

    /**
     * @param minFanSpeed the minFanSpeed to set
     */
    public void setMinFanSpeed(int minFanSpeed) {
        this.minFanSpeed = minFanSpeed;
    }

    /**
     * @return the maxFanSpeed
     */
    public int getMaxFanSpeed() {
        return maxFanSpeed;
    }

    /**
     * @param maxFanSpeed the maxFanSpeed to set
     */
    public void setMaxFanSpeed(int maxFanSpeed) {
        this.maxFanSpeed = maxFanSpeed;
    }

    /**
     * @return the bridgeFanSpeedPercent
     */
    public int getBridgeFanSpeedPercent() {
        return bridgeFanSpeedPercent;
    }

    /**
     * @param bridgeFanSpeedPercent the bridgeFanSpeedPercent to set
     */
    public void setBridgeFanSpeedPercent(int bridgeFanSpeedPercent) {
        this.bridgeFanSpeedPercent = bridgeFanSpeedPercent;
    }

    /**
     * @return the disableFanForFirstNLayers
     */
    public int getDisableFanForFirstNLayers() {
        return disableFanForFirstNLayers;
    }

    /**
     * @param disableFanForFirstNLayers the disableFanForFirstNLayers to set
     */
    public void setDisableFanForFirstNLayers(int disableFanForFirstNLayers) {
        this.disableFanForFirstNLayers = disableFanForFirstNLayers;
    }

    /**
     * @return the enableFanTimeThreshold
     */
    public int getEnableFanTimeThreshold() {
        return enableFanTimeThreshold;
    }

    /**
     * @param enableFanTimeThreshold the enableFanTimeThreshold to set
     */
    public void setEnableFanTimeThreshold(int enableFanTimeThreshold) {
        this.enableFanTimeThreshold = enableFanTimeThreshold;
    }

    /**
     * @return the slowDownTimeTreshold
     */
    public int getSlowDownTimeTreshold() {
        return slowDownTimeTreshold;
    }

    /**
     * @param slowDownTimeTreshold the slowDownTimeTreshold to set
     */
    public void setSlowDownTimeTreshold(int slowDownTimeTreshold) {
        this.slowDownTimeTreshold = slowDownTimeTreshold;
    }

    /**
     * @return the minPrintSpeed
     */
    public int getMinPrintSpeed() {
        return minPrintSpeed;
    }

    /**
     * @param minPrintSpeed the minPrintSpeed to set
     */
    public void setMinPrintSpeed(int minPrintSpeed) {
        this.minPrintSpeed = minPrintSpeed;
    }
}
