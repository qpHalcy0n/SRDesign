/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.UserInterface.PrintConfig;

import ink3d.ConfigurationObjects.CoolingConfiguration;
import ink3d.ConfigurationObjects.ExtrusionWidthConfiguration;
import ink3d.ConfigurationObjects.InfillConfiguration;
import ink3d.ConfigurationObjects.LayerAndPerimeterConfiguration;
import ink3d.ConfigurationObjects.PrintConfiguration;
import ink3d.ConfigurationObjects.SkirtAndBrimConfiguration;
import ink3d.ConfigurationObjects.SpeedConfiguration;
import ink3d.ConfigurationObjects.SupportMaterialConfiguration;
import ink3d.UserInterface.Database.PersistenceFramework;
import ink3d.UserInterface.MainMenu.BadFieldException;
import ink3d.Util.InputValidationUtility;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tim
 */
public class PrintController {
    private PersistenceFramework db;

    public PrintController() {
        this.db = PersistenceFramework.getDB();
    }

    public List<String> loadPrintConfigurationList() {
        return db.getPrintConfigurations();
    }

    public PrintConfiguration loadPrintConfiguration(String name) {
        return db.getPrintConfiguration(name);
    }

    public boolean savePrintConfiguration(PrintConfiguration printConfiguration) {
        if(validatePrintConfiguration(printConfiguration)) {
            db.savePrintConfiguration(printConfiguration);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deletePrintConfiguration(String name) {
        return db.deletePrintConfiguration(name);
    }

    private boolean validatePrintConfiguration(PrintConfiguration print) {
        try {
            validateInfillConfiguration(print.getInfillConfiguration());
            validateLayerAndPerimeterConfiguration(print.getLayerPerimiterConfiguration());
            validateSpeedConfiguration(print.getSpeedConfiguration());
            validateSkirtAndBrimConfiguration(print.getSkirtAndBrimConfiguration());
            validateSupportMaterialConfiguration(print.getSupportMaterialConfiguration());
            validateCoolingConfiguration(print.getCoolingConfiguration());
            validateExtrusionWidthConfiguration(print.getExtrusionWidthConfiguration());
            InputValidationUtility.checkIfInRange("Bed Temperature", print.getBedTemperature(), 0, Integer.MAX_VALUE);
            InputValidationUtility.checkIfInRange("First Layer Bed Temperature", print.getFirstLayerBedTemperature(), 0, Integer.MAX_VALUE);
            InputValidationUtility.checkIfInRange("Bridge Flow Ratio", print.getBridgeFlowRatio(), 0.0, Double.POSITIVE_INFINITY);
            InputValidationUtility.checkIfInRange("Perimeter Extruder", print.getPerimeterExtruder(), 0, Integer.MAX_VALUE);
            InputValidationUtility.checkIfInRange("Infill Extruder", print.getInfillExtruder(), 0, Integer.MAX_VALUE);
            InputValidationUtility.checkIfInRange("Support Material Extruder", print.getSupportMaterialExtruder(), 0, Integer.MAX_VALUE);
            InputValidationUtility.checkIfInRange("Support Material Interface Extruder", print.getSupportMaterialInterfaceExtruder(), 0, Integer.MAX_VALUE);
            return true;
        } catch (BadFieldException ex) {
            Logger.getLogger(PrintController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    private boolean validateInfillConfiguration(InfillConfiguration infill) throws BadFieldException {
        InputValidationUtility.checkIfInRange("Infill Density", infill.getInfillDensity(), 0.0, 1.0);
        InputValidationUtility.checkIfInRange("Infill Every N Layers", infill.getInfillEveryNLayers(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Solid Infill Every N Layers", infill.getSolidInfillEveryNLayers(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Infill Angle", infill.getInfillAngle(), 0, 360);
        InputValidationUtility.checkIfInRange("Solid Infill Threshold Area", infill.getSolidInfillThresholdArea(), 0, Integer.MAX_VALUE);
        return true;
    }

    private boolean validateLayerAndPerimeterConfiguration(LayerAndPerimeterConfiguration lp) throws BadFieldException {
        InputValidationUtility.checkIfInRange("Layer Height", lp.getLayerHeight(), 0.0000001, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("First Layer Height", lp.getFirstLayerHeight(), 0.0000001, Double.POSITIVE_INFINITY);;
        InputValidationUtility.checkIfInRange("Perimeters", lp.getPerimeters(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Solid Top Layers", lp.getSolidTopLayers(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Solid Bottom Layers", lp.getSolidBottomLayers(), 0, Integer.MAX_VALUE);
        return true;
    }

    private boolean validateSpeedConfiguration(SpeedConfiguration speed) throws BadFieldException {
        InputValidationUtility.checkIfInRange("Perimeters Speed", speed.getPerimetersSpeed(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Small Perimeters Speed", speed.getSmallPerimetersSpeed(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("External Perimeters Speed", speed.getExternalPerimetersSpeed(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Infill Speed", speed.getInfillSpeed(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Solid Infill Speed", speed.getSolidInfillSpeed(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Top Solid Infill Speed", speed.getTopSolidInfillSpeed(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Support Material Speed", speed.getSupportMaterialSpeed(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Bridges Speed", speed.getBridgesSpeed(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Gap Fill Speed", speed.getGapFillSpeed(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Move Speed", speed.getNonPrintMovesSpeed(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("First Layer Speed", speed.getFirstLayerSpeed(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Perimeter Acceleration", speed.getPerimetersAcceleration(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Infill Acceleration", speed.getInfillAcceleration(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Bridge Acceleration", speed.getBridgeAcceleration(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("First Layer Acceleration", speed.getFirstLayerAcceleration(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Default Acceleration", speed.getDefaultAcceleration(), 0.0, Double.POSITIVE_INFINITY);
        return true;
    }

    private boolean validateSkirtAndBrimConfiguration(SkirtAndBrimConfiguration sb) throws BadFieldException {
        InputValidationUtility.checkIfInRange("Skirt Loops", sb.getSkirtLoops(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Skirt Distance From Object", sb.getSkirtDistanceFromObject(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Skirt Height", sb.getSkirtHeight(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Skirt Minimum Extrusion Length", sb.getSkirtMinimumExtrusionLength(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Brim Width", sb.getBrimWidth(), 0, Integer.MAX_VALUE);
        return true;
    }

    private boolean validateSupportMaterialConfiguration(SupportMaterialConfiguration s) throws BadFieldException {
        InputValidationUtility.checkIfInRange("Overhand Threshold", s.getOverhangThreshold(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Enforce Support For First N Layers", s.getEnforceSupportForFirstNLayers(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Raft Layers", s.getRaftLayers(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Support Material Pattern Spacing", s.getSupportPatternSpacing(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Support Material Pattern Angle", s.getSupportPatternAngle(), 0, 359);
        InputValidationUtility.checkIfInRange("Interface Layers", s.getInterfaceLayers(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Interface Pattern Spacing", s.getInterfacePatternSpacing(), 0.0, Double.POSITIVE_INFINITY);
        return true;
    }

    private boolean validateCoolingConfiguration(CoolingConfiguration c) throws BadFieldException {
        InputValidationUtility.checkIfInRange("Min Fan Speed", c.getMinFanSpeed(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Max Fan Speed", c.getMaxFanSpeed(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Bridge Fan Speed Percent", c.getBridgeFanSpeedPercent(), 0, 100);
        InputValidationUtility.checkIfInRange("Disable Fan For First N Layers", c.getDisableFanForFirstNLayers(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Enable Fan Time Threshold", c.getEnableFanTimeThreshold(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Slow Down Time Threshold", c.getSlowDownTimeTreshold(), 0, Integer.MAX_VALUE);
        InputValidationUtility.checkIfInRange("Minimum Print Speed", c.getMinPrintSpeed(), 0, Integer.MAX_VALUE);
        return true;
    }

    private boolean validateExtrusionWidthConfiguration(ExtrusionWidthConfiguration e) throws BadFieldException {
        InputValidationUtility.checkIfInRange("Default Extrusion Width", e.getDefaultExtrusionWidth(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("First Layer Extrusion Width", e.getFirstLayerExtrusionWidth(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Perimeters Extrusion Width", e.getPerimetersExtrusionWidth(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Infill Extrusion Width", e.getInfillExtrusionWidth(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Solid Infill Extrusion Width", e.getSolidInfillExtrusionWidth(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Top Solid Infill Extrusion Width", e.getTopSolidInfillExtrusionWidth(), 0.0, Double.POSITIVE_INFINITY);
        InputValidationUtility.checkIfInRange("Support Material Extrusion Width", e.getSupportMaterialExtrusionWidth(), 0.0, Double.POSITIVE_INFINITY);
        return true;
    }
}
