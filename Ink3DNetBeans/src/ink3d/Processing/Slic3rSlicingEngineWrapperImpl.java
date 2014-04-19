/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Processing;

import ink3d.ConfigurationObjects.CoolingConfiguration;
import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.ExtrusionWidthConfiguration;
import ink3d.ConfigurationObjects.InfillConfiguration;
import ink3d.ConfigurationObjects.LayerAndPerimeterConfiguration;
import ink3d.ConfigurationObjects.MaterialConfiguration;
import ink3d.ConfigurationObjects.PrintConfiguration;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.PrinterConfiguration;
import ink3d.ConfigurationObjects.SkirtAndBrimConfiguration;
import ink3d.ConfigurationObjects.SpeedConfiguration;
import ink3d.ConfigurationObjects.SubsetConfiguration;
import ink3d.ConfigurationObjects.SupportMaterialConfiguration;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tim
 */
public class Slic3rSlicingEngineWrapperImpl implements SlicingEngineWrapper {
    // Printer Settings
    public static String BED_SIZE = "bed_size";
    public static String PRINT_CENTER = "print_center";
    public static String Z_OFFSET = "z_offset";
    public static String GCODE_FLAVOR = "gcode_flavor";
    public static String USE_RELATIVE_E_DISTANCES = "use_relative_e_distances";
    public static String USE_FIRMWARE_RETRACTION = "use_firmware_retraction";
    public static String VIBRATION_LIMIT = "vibration_limit";
    public static String NOZZLE_DIAMTER = "nozzle_diameter";

    // Filament/Material Settings
    public static String FILAMENT_DIAMTER = "filament_diameter";
    public static String EXTRUSION_MULTIPLIER = "extrusion_multiplier";
    public static String TEMPERATURE = "temperature";
    public static String FIRST_LAYER_TEMPERATURE = "first_layer_temperature";
    public static String BED_TEMPERATURE = "bed_temperature";
    public static String FIRST_LAYER_BED_TEMPERATURE = "first_layer_bed_temperature";

    // Speed Settings
    public static String TRAVEL_SPEED = "travel_speed";
    public static String PERIMETER_SPEED = "perimeter_speed";
    public static String SMALL_PERIMETER_SPEED = "small_perimeter_speed";
    public static String EXTERNAL_PERIMETER_SPEED = "external_perimeter_speed";
    public static String INFILL_SPEED = "infill_speed";
    public static String SOLID_INFILL_SPEED = "solid_infill_speed";
    public static String TOP_SOLID_INFILL_SPEED = "top_solid_infill_speed";
    public static String SUPPORT_MATERIAL_SPEED = "support_material_speed";
    public static String BRIDGE_SPEED = "bridge_speed";
    public static String GAP_FILL_SPEED = "gap_fill_speed";
    public static String FIRST_LAYER_SPEED = "first_layer_speed";

    // Acceleration Settings
    public static String PERIMETER_ACCELERATION = "perimeter_acceleration";
    public static String INFILL_ACCELERATION = "infill_acceleration";
    public static String BRIDGE_ACCELERATION = "bridge_acceleration";
    public static String DEFAULT_ACCELERATION = "default_acceleration";
    public static String FIRST_LAYER_ACCELERATION = "first_layer_acceleration";
    // Accuracy Options
    public static String LAYER_HEIGHT = "layer_height";
    public static String FIRST_LAYER_HEIGHT = "first_layer_height";
    public static String INFILL_EVERY_LAYERS = "infill_every_layers";
    public static String SOLID_INFILL_EVERY_LAYERS = "solid_infill_every_layers";

    // Print Options
    public static String PERIMETERS = "perimeters";
    public static String SPIRAL_VASE = "spiral_vase";
    public static String TOP_SOLID_LAYERS = "top_solid_layers";
    public static String BOTTOM_SOLID_LAYERS = "bottom_solid_layers";
    public static String SOLID_LAYERS = "solid_layers";
    public static String FILL_DENSITY = "fill_density";
    public static String FILL_ANGLE = "fill_angle";
    public static String FILL_PATTERN = "fill_pattern";
    public static String SOLID_FILL_PATTERN = "solid_fill_pattern";
    public static String START_GCODE = "start_gcode";
    public static String END_GCODE = "end_gcode";
    public static String LAYER_GCODE = "layer_gcode";
    public static String TOOLCHANGE_GCODE = "toolchange_gcode";
    public static String EXTRA_PERIMETERS = "extra_perimeters";
    public static String RANDOMIZE_START = "randomize_start";
    public static String AVOID_CROSSING_PERIMETERS = "avoid_crossing_perimeters";
    public static String EXTERNAL_PERIMETERS_FIRST = "external_perimeters_first";
    public static String ONLY_RETRACT_WHEN_CROSSING_PERIMETERS = "only_retract_when_crossing_perimeters";
    public static String SOLID_INFILL_BELOW_AREA = "solid_infill_below_area";
    public static String INFILL_ONLY_WHERE_NEEDED = "infill_only_where_needed";
    public static String INFILL_FIRST = "infill_first";

    public static String START_PERIMETERS_AT_CONCAVE = "start_perimeters_at_concave_points";
    public static String START_PERIMETERS_AT_NONOVERHANGS = "start_perimeters_at_non_overhang";
    public static String DETECT_THIN_WALLS = "thin_walls";
    public static String DETECT_BRIDGING_PERIMETERS = "overhangs";

    // Support Material Options
    public static String SUPPORT_MATERIAL = "support_material";
    public static String SUPPORT_MATERIAL_THRESHOLD = "support_material_threshold";
    public static String SUPPORT_MATERIAL_PATTERN = "support_material_pattern";
    public static String SUPPORT_MATERIAL_SPACING = "support_material_spacing";
    public static String SUPPORT_MATERIAL_ANGLE = "support_material_angle";
    public static String SUPPORT_MATERIAL_INTERFACE_LAYERS = "support_material_interface_layers";
    public static String SUPPORT_MATERIAL_INTERFACE_SPACING = "support_material_interface_spacing";
    public static String RAFT_LAYERS = "raft_layers";
    public static String SUPPORT_MATERIAL_ENFORCE_LAYERS = "support_material_enforce_layers";

    // Retraction Options
    public static String RETRACT_LENGTH = "retract_length";
    public static String RETRACT_SPEED = "retract_speed";
    public static String RETRACT_RESTART_EXTRA = "retract_restart_extra";
    public static String RETRACT_BEFORE_TRAVEL = "retract_before_travel";
    public static String RETRACT_LIFT = "retract_lift";
    public static String RETRACT_LAYER_CHANGE = "retract_layer_change";
    public static String WIPE = "wipe";

    // Retract Options for Multi_Extruder Setup
    public static String RETRACT_LENGTH_TOOLCHANGE = "retract_length_toolchange";
    public static String RETRACT_RESTART_EXTRA_TOOLCHANGE = "retract_restart_extra_toolchange";

    // Cooling Options
    public static String COOLING = "cooling";
    public static String MIN_FAN_SPEED = "min_fan_speed";
    public static String MAX_FAN_SPEED = "max_fan_speed";
    public static String BRIDGE_FAN_SPEED = "bridge_fan_speed";
    public static String FAN_BELOW_LAYER_TIME = "fan_below_layer_time";
    public static String SLOWDOWN_BELOW_LAYER_TIME = "slowdown_below_layer_time";
    public static String MIN_PRINT_SPEED = "min_print_speed";
    public static String DISABLE_FAN_FIRST_LAYERS = "disable_fan_first_layers";
    public static String FAN_ALWAYS_ON = "fan_always_on";

    // Skirt Options
    public static String SKIRTS = "skirts";
    public static String SKIRT_DISTANCE = "skirt_distance";
    public static String SKIRT_HEIGHT = "skirt_height";
    public static String MIN_SKIRT_LENGTH = "min_skirt_length";
    public static String BRIM_WIDTH = "brim_width";

    // Extrusion Width Options
    public static String EXTRUSION_WIDTH = "extrusion_width";
    public static String FIRST_LAYER_EXTRUSION_WIDTH = "first_layer_extrusion_width";
    public static String PERIMETER_EXTRUSION_WIDTH = "perimeter_extrusion_width";
    public static String INFILL_EXTRUSION_WIDTH = "infill_extrusion_width";
    public static String SOLID_INFILL_EXTRUSION_WIDTH = "solid_infill_extrusion_width";
    public static String TOP_INFILL_EXTRUSION_WIDTH = "top_infill_extrusion_width";
    public static String SUPPORT_MATERIAL_EXTRUSION_WIDTH = "support_material_extrusion_width";
    public static String DEFAULT_EXTRUSION_WIDTH = "extrusion_width";
    public static String PERIMETERS_EXTRUSION_WIDTH = "perimeter_extrusion_width";

    // Flow Options 
    public static String BRIDGE_FLOW_RATIO = "bridge_flow_ratio";

    // Advanced Options
    public static String THREADS = "threads";
    public static String RESOLUTION = "resolution";

    // Mulitple Extruder Options
    public static String EXTRUDER_OFFSET = "extruder_offset";
    public static String PERIMETER_EXTRUDER = "perimeter_extruder";
    public static String INFILL_EXTRUDER = "infill_extruder";
    public static String SUPPORT_MATERIAL_EXTRUDER = "support_material_extruder";
    public static String SUPPORT_MATERIAL_INTERFACE_EXTRUDER = "support_material_interface_extruder";
    public static String OOZE_PREVENTION = "ooze_prevention";
    public static String STANDBY_TEMPERATURE_DELTA = "standby_temperature_delta";

    // Output Options
    public static String COMPLETE_OBJECTS = "complete_objects";
    public static String EXTRUDER_CLEARANCE_HEIGHT = "extruder_clearance_height";
    public static String EXTRUDER_CLEARANCE_RADIUS = "extruder_clearance_radius";
    public static String VERBOSE_GCODE = "gcode_comments";
    public static String OUTPUT_FILENAME_FORMAT = "output_filename_format";
    public static String POST_PROCESSING_SCRIPTS = "post_process";

    // Other Options
    public static String EXTRUSION_AXIS = "extrusion_axis";
    public static String GCODE_ARCS = "gcode_arcs";
    public static String G0 = "g0";
    public static String ROTATE = "rotate";
    public static String SCALE = "scale";
    public static String DUPLICATE = "duplicate";
    public static String DUPLICATE_DISTANCE = "duplicate_distance";
    public static String DUPLICATE_GRID = "duplicate_grid";

    public static String SLIC3R_CONFIG_DIR = "slic3r-configs";
    public static String GCODE_DIR = "subset-gcode";
    public static String GCODE_EXTENSION = ".gcode";
    public static String CONFIG_EXTENSION = ".ini";

    private static String SLIC3R_PATH = "third-party" + File.separator 
            + "Slic3r" + File.separator + "slic3r-console.exe";

    @Override
    public boolean generateGCode(PrintJobConfiguration printJobConfiguration) throws ProcessorException {
        PrinterConfiguration printerConfiguration = printJobConfiguration.getPrinterConfiguration();

        // Create a string builder to build a string of config options
        int subsetNum = 0;

        // initialize first zOffset
        double zOffset = printerConfiguration.getzOffset();
        List<SubsetConfiguration> subsets = printJobConfiguration.getSubsetConfigurationList();
        // Append subset specific options
        for(SubsetConfiguration subset : subsets) {
            PrintConfiguration printConfig = subset.getPrintConfiguration();
            InfillConfiguration infill = printConfig.getInfillConfiguration();
            LayerAndPerimeterConfiguration layerAndPerimeters = printConfig.getLayerPerimiterConfiguration();
            SkirtAndBrimConfiguration skirtAndBrim = printConfig.getSkirtAndBrimConfiguration();
            SpeedConfiguration speed = printConfig.getSpeedConfiguration();
            SupportMaterialConfiguration supportMaterial = printConfig.getSupportMaterialConfiguration();
            ExtrusionWidthConfiguration extrusionWidth = printConfig.getExtrusionWidthConfiguration();
            CoolingConfiguration cooling = printConfig.getCoolingConfiguration();

            // Get the extruder and material configurations that are actually
            // used in order from lowest to highest.  Slic3r assigns tools to
            // volumes in the AMF file in sequential order based on what volumes
            // are defined.  This means that we need to define the properties
            // for each extruder in the same order.  We also have to do post processing
            // to replace any T codes with their correct values.
            List<ExtruderConfiguration> extruders = new ArrayList<>();
            List<MaterialConfiguration> materials = new ArrayList<>();
            for(Integer index : subset.getExtrudersNeeded()) {
                extruders.add(printerConfiguration.getExtruderList().get(index));
                materials.add(printJobConfiguration.getMaterialForExtruderPosition(index));
            }

            

            // String builder to build config string
            StringBuilder sb = new StringBuilder();

            // Special first subset options
            if(subsetNum == 0) {
                appendProperty(sb, FIRST_LAYER_TEMPERATURE, getFirstLayerTemperatures(materials));
                appendProperty(sb, FIRST_LAYER_BED_TEMPERATURE, 0);
                appendProperty(sb, FIRST_LAYER_SPEED, speed.getFirstLayerSpeed());
                appendProperty(sb, FIRST_LAYER_ACCELERATION, 0);
                appendProperty(sb, FIRST_LAYER_HEIGHT, layerAndPerimeters.getFirstLayerHeight());
                appendProperty(sb, BOTTOM_SOLID_LAYERS, layerAndPerimeters.getSolidBottomLayers());
                appendProperty(sb, FIRST_LAYER_EXTRUSION_WIDTH, extrusionWidth.getFirstLayerExtrusionWidth());
                appendProperty(sb, DISABLE_FAN_FIRST_LAYERS, 1);
                appendProperty(sb, SKIRTS, skirtAndBrim.getSkirtLoops());
                appendProperty(sb, SKIRT_DISTANCE, skirtAndBrim.getSkirtDistanceFromObject());
                appendProperty(sb, SKIRT_HEIGHT, skirtAndBrim.getSkirtHeight());
                appendProperty(sb, MIN_SKIRT_LENGTH, skirtAndBrim.getSkirtMinimumExtrusionLength());
                appendProperty(sb, BRIM_WIDTH, skirtAndBrim.getBrimWidth());
            }
            else {
                appendProperty(sb, FIRST_LAYER_TEMPERATURE, getExtrusionTemperatures(materials));
                appendProperty(sb, FIRST_LAYER_BED_TEMPERATURE, 0);
                appendProperty(sb, FIRST_LAYER_SPEED, "100%");
                appendProperty(sb, FIRST_LAYER_ACCELERATION, 0);
                appendProperty(sb, FIRST_LAYER_HEIGHT, layerAndPerimeters.getLayerHeight());
                appendProperty(sb, BOTTOM_SOLID_LAYERS, 0);
                appendProperty(sb, FIRST_LAYER_EXTRUSION_WIDTH, extrusionWidth.getDefaultExtrusionWidth());
                appendProperty(sb, DISABLE_FAN_FIRST_LAYERS, 0);
                appendProperty(sb, SKIRTS, 0);
                appendProperty(sb, SKIRT_DISTANCE, skirtAndBrim.getSkirtDistanceFromObject());
                appendProperty(sb, SKIRT_HEIGHT, skirtAndBrim.getSkirtHeight());
                appendProperty(sb, MIN_SKIRT_LENGTH, skirtAndBrim.getSkirtMinimumExtrusionLength());
                appendProperty(sb, BRIM_WIDTH, 0);

            }

            // Special last subset options
            if(subsetNum == subsets.size() - 1) {
                appendProperty(sb, TOP_SOLID_INFILL_SPEED, speed.getTopSolidInfillSpeed());
                appendProperty(sb, TOP_SOLID_LAYERS, layerAndPerimeters.getSolidTopLayers());
                appendProperty(sb, TOP_INFILL_EXTRUSION_WIDTH, extrusionWidth.getTopSolidInfillExtrusionWidth());
            }
            else {
                appendProperty(sb, TOP_SOLID_INFILL_SPEED, speed.getSolidInfillSpeed());
                appendProperty(sb, TOP_SOLID_LAYERS, 0);
                appendProperty(sb, TOP_INFILL_EXTRUSION_WIDTH, extrusionWidth.getDefaultExtrusionWidth());
            }

            // Append printer options
            appendProperty(sb, BED_SIZE, printerConfiguration.getBedX() + "," + printerConfiguration.getBedY());
            appendProperty(sb, PRINT_CENTER, printerConfiguration.getPrintCenterX() 
                    + "," + printerConfiguration.getPrintCenterY());
            appendProperty(sb, GCODE_FLAVOR, printerConfiguration.getgCodeFlavor());
            appendProperty(sb, USE_RELATIVE_E_DISTANCES, printerConfiguration.isUseRelativeEDistances());
            appendProperty(sb, VIBRATION_LIMIT, printerConfiguration.getVibrationLimit());
            appendProperty(sb, NOZZLE_DIAMTER, getNozzleDiameters(extruders));
            appendProperty(sb, USE_FIRMWARE_RETRACTION, printerConfiguration.isUseFirmwareRetraction());
            // Hardcode custom G-Code properties to empty (take care of this in post processing)
            appendProperty(sb, START_GCODE, "");
            appendProperty(sb, END_GCODE, "");
            appendProperty(sb, TOOLCHANGE_GCODE, "");
            appendProperty(sb, EXTRUDER_OFFSET, getExtruderOffsets(extruders));

            appendProperty(sb, LAYER_GCODE, printConfig.getLayerChangeGCode());
            
            appendProperty(sb, Z_OFFSET, zOffset);
            appendProperty(sb, FILAMENT_DIAMTER, getFilamentDiameters(materials));
            appendProperty(sb, EXTRUSION_MULTIPLIER, getExtrusionMultipliers(materials));
            appendProperty(sb, TEMPERATURE, getExtrusionTemperatures(materials));
            appendProperty(sb, BED_TEMPERATURE, printConfig.getBedTemperature());

            // Speed Options
            appendProperty(sb, TRAVEL_SPEED, speed.getNonPrintMovesSpeed());
            appendProperty(sb, PERIMETER_SPEED, speed.getPerimetersSpeed());
            appendProperty(sb, SMALL_PERIMETER_SPEED, speed.getSmallPerimetersSpeed());
            appendProperty(sb, EXTERNAL_PERIMETER_SPEED, speed.getExternalPerimetersSpeed());
            appendProperty(sb, INFILL_SPEED, speed.getInfillSpeed());
            appendProperty(sb, SOLID_INFILL_SPEED, speed.getSolidInfillSpeed());
            appendProperty(sb, SUPPORT_MATERIAL_SPEED, speed.getSupportMaterialSpeed());
            appendProperty(sb, BRIDGE_SPEED, speed.getBridgesSpeed());
            appendProperty(sb, GAP_FILL_SPEED, speed.getGapFillSpeed());

            // Acceleration Options
            appendProperty(sb, PERIMETER_ACCELERATION, speed.getPerimetersAcceleration());
            appendProperty(sb, INFILL_ACCELERATION, speed.getInfillAcceleration());
            appendProperty(sb, BRIDGE_ACCELERATION, speed.getBridgeAcceleration());
            appendProperty(sb, DEFAULT_ACCELERATION, speed.getDefaultAcceleration());

            // Accuracy Options
            appendProperty(sb, LAYER_HEIGHT, layerAndPerimeters.getLayerHeight());
            appendProperty(sb, INFILL_EVERY_LAYERS, infill.getInfillEveryNLayers());
            appendProperty(sb, SOLID_INFILL_EVERY_LAYERS, infill.getSolidInfillEveryNLayers());

            // Print Options
            appendProperty(sb, SPIRAL_VASE, layerAndPerimeters.isSpiralVase());
            appendProperty(sb, PERIMETERS, layerAndPerimeters.getPerimeters());
            appendProperty(sb, FILL_DENSITY, infill.getInfillDensity());
            appendProperty(sb, FILL_ANGLE, infill.getInfillAngle());
            appendProperty(sb, FILL_PATTERN, infill.getInfillPattern());
            appendProperty(sb, SOLID_FILL_PATTERN, infill.getTopBottomInfillPattern());

            // Hardcoded for now
            appendProperty(sb, DEFAULT_EXTRUSION_WIDTH, extrusionWidth.getDefaultExtrusionWidth());
            appendProperty(sb, PERIMETERS_EXTRUSION_WIDTH, extrusionWidth.getPerimetersExtrusionWidth());
            appendProperty(sb, INFILL_EXTRUSION_WIDTH, extrusionWidth.getInfillExtrusionWidth());
            appendProperty(sb, SOLID_INFILL_EXTRUSION_WIDTH, extrusionWidth.getSolidInfillExtrusionWidth());
            appendProperty(sb, SUPPORT_MATERIAL_EXTRUSION_WIDTH, extrusionWidth.getSupportMaterialExtrusionWidth());
            appendProperty(sb, BRIDGE_FLOW_RATIO, printConfig.getBridgeFlowRatio());

            // Advanced Options
            appendProperty(sb, THREADS, 2);
            appendProperty(sb, RESOLUTION, 0);

            // Layers and Perimeters -> Quality
            appendProperty(sb, EXTRA_PERIMETERS, layerAndPerimeters.isGenerateExtraPerimetersWhenNeeded());
            appendProperty(sb, AVOID_CROSSING_PERIMETERS, layerAndPerimeters.isAvoidCrossingPerimeters());
            appendProperty(sb, START_PERIMETERS_AT_CONCAVE, layerAndPerimeters.isStartPerimetersAtConcavePoints());
            appendProperty(sb, START_PERIMETERS_AT_NONOVERHANGS, layerAndPerimeters.isStartPerimetersAtNonOverhangPoints());
            appendProperty(sb, DETECT_THIN_WALLS, layerAndPerimeters.isDetectThinWalls());
            appendProperty(sb, DETECT_BRIDGING_PERIMETERS, layerAndPerimeters.isDetectBridgingPerimeters());
            appendProperty(sb, RANDOMIZE_START, layerAndPerimeters.isRandomizedStartingPoints());
            appendProperty(sb, EXTERNAL_PERIMETERS_FIRST, layerAndPerimeters.isExternalPerimetersFirst());

            appendProperty(sb, ONLY_RETRACT_WHEN_CROSSING_PERIMETERS, infill.isOnlyRetractInfillWhenCrossingPerimeters());
            appendProperty(sb, SOLID_INFILL_BELOW_AREA, infill.getSolidInfillThresholdArea());
            appendProperty(sb, INFILL_ONLY_WHERE_NEEDED, infill.isOnlyInfillWhereNeeded());
            appendProperty(sb, INFILL_FIRST, infill.isInfillBeforePerimeters());

            // Material Options
            appendProperty(sb, SUPPORT_MATERIAL, supportMaterial.isGenerateSupportMaterial());
            appendProperty(sb, SUPPORT_MATERIAL_THRESHOLD, supportMaterial.getOverhangThreshold());
            appendProperty(sb, SUPPORT_MATERIAL_PATTERN, supportMaterial.getSupportMaterialPattern());
            appendProperty(sb, SUPPORT_MATERIAL_SPACING, supportMaterial.getSupportPatternSpacing());
            appendProperty(sb, SUPPORT_MATERIAL_ANGLE, supportMaterial.getSupportPatternAngle());
            appendProperty(sb, SUPPORT_MATERIAL_INTERFACE_LAYERS, supportMaterial.getInterfaceLayers() );
            appendProperty(sb, SUPPORT_MATERIAL_INTERFACE_SPACING, supportMaterial.getInterfacePatternSpacing());
            appendProperty(sb, RAFT_LAYERS, supportMaterial.getRaftLayers());
            appendProperty(sb, SUPPORT_MATERIAL_ENFORCE_LAYERS, supportMaterial.getEnforceSupportForFirstNLayers());

            // Retraction Options
            appendProperty(sb, RETRACT_LENGTH, getRetractLengths(materials));
            appendProperty(sb, RETRACT_SPEED, getRetractSpeeds(materials));
            appendProperty(sb, RETRACT_RESTART_EXTRA, getExtraAfterRetracts(materials));
            appendProperty(sb, RETRACT_BEFORE_TRAVEL, getRetractBeforeTravelValues(materials));
            appendProperty(sb, RETRACT_LIFT, getRetractLifts(materials));
            appendProperty(sb, RETRACT_LAYER_CHANGE, getRetractOnLayerChangeValues(materials));
            appendProperty(sb, WIPE, getWipeBeforeRetract(materials));
            appendProperty(sb, RETRACT_LENGTH_TOOLCHANGE, getRetractBeforeToolChange(materials) );
            appendProperty(sb, RETRACT_RESTART_EXTRA_TOOLCHANGE, getExtraAfterRetractToolchange(materials));
            
            // Cooling Options
            appendProperty(sb, COOLING, cooling.isEnableAutoCooling());
            appendProperty(sb, FAN_ALWAYS_ON, cooling.isFanAlwaysOn());
            appendProperty(sb, MIN_FAN_SPEED, cooling.getMinFanSpeed());
            appendProperty(sb, MAX_FAN_SPEED, cooling.getMaxFanSpeed());
            // TODO:  Fix this mess.  Bridge fan speed probably needs to be an int instead of double
            appendProperty(sb, BRIDGE_FAN_SPEED, String.valueOf(Math.round(cooling.getBridgeFanSpeedPercent())));
            appendProperty(sb, FAN_BELOW_LAYER_TIME, cooling.getEnableFanTimeThreshold());
            appendProperty(sb, SLOWDOWN_BELOW_LAYER_TIME, cooling.getSlowDownTimeTreshold());
            appendProperty(sb, MIN_PRINT_SPEED, cooling.getMinPrintSpeed());

            // Multiple Extruder Options
            appendProperty(sb, PERIMETER_EXTRUDER, printConfig.getPerimeterExtruder());
            appendProperty(sb, INFILL_EXTRUDER, printConfig.getInfillExtruder());
            appendProperty(sb, SUPPORT_MATERIAL_EXTRUDER, printConfig.getSupportMaterialExtruder());
            appendProperty(sb, SUPPORT_MATERIAL_INTERFACE_EXTRUDER, printConfig.getSupportMaterialInterfaceExtruder());
            appendProperty(sb, OOZE_PREVENTION, printJobConfiguration.isOozePrevention());
            appendProperty(sb, STANDBY_TEMPERATURE_DELTA, printJobConfiguration.getTemperatureDelta());

            // Output Options
            appendProperty(sb, COMPLETE_OBJECTS, printJobConfiguration.isCompleteIndividualObjects());
            appendProperty(sb, EXTRUDER_CLEARANCE_RADIUS, printJobConfiguration.getExtruderClearanceRadius());
            appendProperty(sb, EXTRUDER_CLEARANCE_HEIGHT, printJobConfiguration.getExtruderClearanceHeight());
            appendProperty(sb, VERBOSE_GCODE, printJobConfiguration.isVerboseGCode());
            appendProperty(sb, OUTPUT_FILENAME_FORMAT, "[input_filename_base].gcode");
            appendProperty(sb, POST_PROCESSING_SCRIPTS, "");

            // Other Options
            // TODO:  Figure out exactly what "duplicate" is
            appendProperty(sb, DUPLICATE, 1);
            appendProperty(sb, DUPLICATE_DISTANCE, 6);
            appendProperty(sb, DUPLICATE_GRID, "1,1");
            appendProperty(sb, EXTRUSION_AXIS, "E");
            appendProperty(sb, G0, 0);
            appendProperty(sb, GCODE_ARCS, false);
            appendProperty(sb, ROTATE, 0);
            appendProperty(sb, SCALE, 1);

            // Write to config file and create gcode file with Slic3r
            File subsetGCodeFile = null;
            try {
                String baseDir = new File("").getAbsolutePath();

                // Create config filename based on print job and subsection number
                String configFilename =
                        baseDir + File.separator + SLIC3R_CONFIG_DIR + File.separator
                        + printJobConfiguration.getName() + File.separator
                        + "subsets" + File.separator + "sub" + subsetNum + CONFIG_EXTENSION;

                // Create directory for subset config files if one does not exist
                File subsetConfigDir = new File(configFilename).getParentFile();
                if(!subsetConfigDir.exists()) {
                    boolean success = subsetConfigDir.mkdirs();
                    if(!success) {
                        throw new Exception("Could not create directory for subset config files.");
                    }
                }

                // Create subset config file and write properties
                File subsetConfigFile = new File(configFilename);
                FileWriter fw = new FileWriter(subsetConfigFile);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(sb.toString());
                bw.close();

                // Create GCode directory if it does not exist
                String gCodeFilename =
                        baseDir + File.separator + GCODE_DIR + File.separator
                        + printJobConfiguration.getName() + File.separator 
                        + "sub" + subsetNum + GCODE_EXTENSION;

                System.out.println("gCodeFilename = " + gCodeFilename);
                
                File subsetGCodeDir = new File(gCodeFilename).getParentFile();
                if(!subsetGCodeDir.exists()) {
                    boolean success = subsetGCodeDir.mkdirs();
                    if(!success) {
                        throw new Exception("Could not create directory for subset G-Code files files.");
                    }
                }
                String subsetAmfFilename = subset.getAmfFile().getAbsolutePath();
                String command = baseDir + File.separator + SLIC3R_PATH
                        + " " + "--load \"" + configFilename + "\" --output \"" 
                        + gCodeFilename + "\" " + subsetAmfFilename;

                System.out.println(command);
                
                Process slic3rProcess = Runtime.getRuntime().exec(command);
                slic3rProcess.waitFor();

                subsetGCodeFile = new File(gCodeFilename);
                if(subsetGCodeFile.exists()) {
                    subset.setgCodeFile(subsetGCodeFile);
                }
                else {
                    throw new Exception("Could not create G-Code file");
                }
            }
            catch(IOException ex) {
                Logger.getLogger(Slic3rSlicingEngineWrapperImpl.class.getName()).log(Level.SEVERE, null, ex);
                throw new ProcessorException(ex.getMessage() + "; Subset " + (subsetNum + 1));
            } catch (InterruptedException ex) {
                Logger.getLogger(Slic3rSlicingEngineWrapperImpl.class.getName()).log(Level.SEVERE, null, ex);
                throw new ProcessorException(ex.getMessage() + "; Subset " + (subsetNum + 1));
            } catch (Exception ex) {
                Logger.getLogger(Slic3rSlicingEngineWrapperImpl.class.getName()).log(Level.SEVERE, null, ex);
                throw new ProcessorException(ex.getMessage() + "; Subset " + (subsetNum + 1));
            }
            
            try {
                // calculate new z-offset based on the last z value from the created GCode file
                zOffset = calculateNextZOffset(subsetGCodeFile);
            } catch (Exception ex) {
                Logger.getLogger(Slic3rSlicingEngineWrapperImpl.class.getName()).log(Level.SEVERE, null, ex);
                throw new ProcessorException("Could not properly calculate Z Offset for subset " + (subsetNum + 1));
            }
            
            // increment subset number for naming files
            subsetNum++;
        }
        return true;
    }

    private double calculateNextZOffset(File gCodeFile) throws FileNotFoundException, IOException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new FileReader(gCodeFile));
        double zOffset = 0.0;
        Pattern pattern = Pattern.compile("Z[0-9]+.[0-9]+");
        String line = "";
        while((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if(matcher.find()) {
                String match = matcher.group();
                zOffset = Double.parseDouble(match.substring(1));
            }
        }
        return zOffset;
    }

    /**
     * Returns the x,y offsets of each extruder in a comma separated list as String.
     * These offsets are in reference to the first extruder.
     * @param extruders The list of extruders.
     * @return  String of comma separated list of x,y offsets.
     */
    private String getExtruderOffsets(List<ExtruderConfiguration> extruders) {
        int numExtruders = extruders.size();
        double[] slic3rXOffsets = new double[numExtruders];
        double[] slic3rYOffsets = new double[numExtruders];

        // The first extruder always has a 0 offset because the rest of
        // the extruder offsets are relative to the first extruder.
        slic3rXOffsets[0] = 0.0;
        slic3rYOffsets[0] = 0.0;
        
        int i = 1;
        while(i < extruders.size()) {
            ExtruderConfiguration prevExtruder = extruders.get(i - 1);
            ExtruderConfiguration currentExtruder = extruders.get(i);
            double prevSlic3rXOffset = slic3rXOffsets[i-1];
            slic3rXOffsets[i] = prevExtruder.getxDimension() - prevExtruder.getxOffset() + currentExtruder.getxOffset() + prevSlic3rXOffset;
            slic3rYOffsets[i] = extruders.get(i).getyOffset() - extruders.get(0).getyOffset();
            i++;
        }

        StringBuilder sb = new StringBuilder();
        i = 0;
        while (i < numExtruders - 1) {
            sb.append(String.valueOf(slic3rXOffsets[i]))
              .append("x")
              .append(String.valueOf(slic3rYOffsets[i]))
              .append(",");
            i++;
        }
        sb.append(String.valueOf(slic3rXOffsets[i]))
          .append("x")
          .append(String.valueOf(slic3rYOffsets[i]));
        
        return sb.toString();

    }

    private String getNozzleDiameters(List<ExtruderConfiguration> extruders) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < extruders.size() - 1) {
            sb.append(extruders.get(i).getNozzleDiameter());
            sb.append(",");
            i++;
        }
        sb.append(extruders.get(i).getNozzleDiameter());
        return sb.toString();
    }

    private String getFilamentDiameters(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).getFilamentDiameter())
              .append(",");
            i++;
        }
        sb.append(materials.get(i).getFilamentDiameter());
        return sb.toString();
    }
    
    private String getExtrusionMultipliers(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).getExtrusionMultiplier())
              .append(",");
            i++;
        }
        sb.append(materials.get(i).getExtrusionMultiplier());
        return sb.toString();
    }

    private String getFirstLayerTemperatures(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).getFirstLayerExtrusionTemperature())
              .append(",");
            i++;
        }
        sb.append(materials.get(i).getFirstLayerExtrusionTemperature());
        return sb.toString();
    }

    private String getExtrusionTemperatures(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).getExtrusionTemperature())
              .append(",");
            i++;
        }
        sb.append(materials.get(i).getExtrusionTemperature());
        return sb.toString();
    }

    private String getRetractBeforeTravelValues(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).getMinimumTravelAfterRetraction())
              .append(",");
            i++;
        }
        sb.append(materials.get(i).getMinimumTravelAfterRetraction());
        return sb.toString();
    }

    private String getRetractOnLayerChangeValues(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).isRetractOnLayerChange() ? "1" : "0")
              .append(",");
            i++;
        }
        sb.append(materials.get(i).isRetractOnLayerChange() ? "1" : "0");
        return sb.toString();
    }

    private String getRetractLengths(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).getRetractionLength())
              .append(",");
            i++;
        }
        sb.append(materials.get(i).getRetractionLength());
        return sb.toString();
    }

    private String getRetractBeforeToolChange(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).getRetractionLengthBeforeToolChange())
              .append(",");
            i++;
        }
        sb.append(materials.get(i).getRetractionLengthBeforeToolChange());
        return sb.toString();
    }

    private String getRetractLifts(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).getRetractionLiftZ())
              .append(",");
            i++;
        }
        sb.append(materials.get(i).getRetractionLiftZ());
        return sb.toString();
    }

    private String getExtraAfterRetracts(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).getExtraLengthAfterRetraction())
              .append(",");
            i++;
        }
        sb.append(materials.get(i).getExtraLengthAfterRetraction());
        return sb.toString();
    }

    private String getExtraAfterRetractToolchange(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).getExtraLengthOnToolReenable())
              .append(",");
            i++;
        }
        sb.append(materials.get(i).getExtraLengthOnToolReenable());
        return sb.toString();
    }

    private String getRetractSpeeds(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).getRetractionSpeed())
              .append(",");
            i++;
        }
        sb.append(materials.get(i).getRetractionSpeed());
        return sb.toString();
    }

    private String getWipeBeforeRetract(List<MaterialConfiguration> materials) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < materials.size() - 1) {
            sb.append(materials.get(i).isWipeBeforeRetract() ? "1" : "0")
              .append(",");
            i++;
        }
        sb.append(materials.get(i).isWipeBeforeRetract() ? "1" : "0");
        return sb.toString();
    }

    private StringBuilder appendProperty(StringBuilder sb, String property, String value) {
        sb.append(property)
          .append(" = ")
          .append(value)
          .append("\n");
        return sb;
    }

    private StringBuilder appendProperty(StringBuilder sb, String property, boolean value) {
        sb.append(property)
          .append(" = ")
          .append(value ? "1" : "0")
          .append("\n");
        return sb;
    }

    private StringBuilder appendProperty(StringBuilder sb, String property, int value) {
        sb.append(property)
          .append(" = ")
          .append(String.valueOf(value))
          .append("\n");
        return sb;
    }

    private StringBuilder appendProperty(StringBuilder sb, String property, double value) {
        sb.append(property)
          .append(" = ")
          .append(String.valueOf(value))
          .append("\n");
        return sb;
    }
    
}
