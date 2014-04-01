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
public class ExtrusionWidthConfiguration {

    public static final double DEFAULT_EXTRUSION_WIDTH = 0;
    public static final double DEFAULT_FIRST_LAYER_EXTRUSION_WIDTH = 0;
    public static final double DEFAULT_PERIMETERS_EXTRUSION_WIDTH = 0;
    public static final double DEFAULT_INFILL_EXTRUSION_WIDTH = 0;
    public static final double DEFAULT_SOLID_INFILL_EXTRUSION_WIDTH = 0;
    public static final double DEFAULT_TOP_SOLID_INFILL_EXTRUSION_WIDTH = 0;
    public static final double DEFAULT_SUPPORT_MATERIAL_EXTRUSION_WIDHT = 0;

    public ExtrusionWidthConfiguration() {
        defaultExtrusionWidth = DEFAULT_EXTRUSION_WIDTH;
        firstLayerExtrusionWidth = DEFAULT_FIRST_LAYER_EXTRUSION_WIDTH;
        perimetersExtrusionWidth = DEFAULT_PERIMETERS_EXTRUSION_WIDTH;
        infillExtrusionWidth = DEFAULT_INFILL_EXTRUSION_WIDTH;
        solidInfillExtrusionWidth = DEFAULT_SOLID_INFILL_EXTRUSION_WIDTH;
        topSolidInfillExtrusionWidth = DEFAULT_TOP_SOLID_INFILL_EXTRUSION_WIDTH;
        supportMaterialExtrusionWidth = DEFAULT_SUPPORT_MATERIAL_EXTRUSION_WIDHT;
    }

    private double defaultExtrusionWidth;
    private double firstLayerExtrusionWidth;
    private double perimetersExtrusionWidth;
    private double infillExtrusionWidth;
    private double solidInfillExtrusionWidth;
    private double topSolidInfillExtrusionWidth;
    private double supportMaterialExtrusionWidth;

    /**
     * @return the defaultExtrusionWidth
     */
    public double getDefaultExtrusionWidth() {
        return defaultExtrusionWidth;
    }

    /**
     * @param defaultExtrusionWidth the defaultExtrusionWidth to set
     */
    public void setDefaultExtrusionWidth(double defaultExtrusionWidth) {
        this.defaultExtrusionWidth = defaultExtrusionWidth;
    }

    /**
     * @return the firstLayerExtrusionWidth
     */
    public double getFirstLayerExtrusionWidth() {
        return firstLayerExtrusionWidth;
    }

    /**
     * @param firstLayerExtrusionWidth the firstLayerExtrusionWidth to set
     */
    public void setFirstLayerExtrusionWidth(double firstLayerExtrusionWidth) {
        this.firstLayerExtrusionWidth = firstLayerExtrusionWidth;
    }

    /**
     * @return the perimetersExtrusionWidth
     */
    public double getPerimetersExtrusionWidth() {
        return perimetersExtrusionWidth;
    }

    /**
     * @param perimetersExtrusionWidth the perimetersExtrusionWidth to set
     */
    public void setPerimetersExtrusionWidth(double perimetersExtrusionWidth) {
        this.perimetersExtrusionWidth = perimetersExtrusionWidth;
    }

    /**
     * @return the infillExtrusionWidth
     */
    public double getInfillExtrusionWidth() {
        return infillExtrusionWidth;
    }

    /**
     * @param infillExtrusionWidth the infillExtrusionWidth to set
     */
    public void setInfillExtrusionWidth(double infillExtrusionWidth) {
        this.infillExtrusionWidth = infillExtrusionWidth;
    }

    /**
     * @return the solidInfillExtrusionWidth
     */
    public double getSolidInfillExtrusionWidth() {
        return solidInfillExtrusionWidth;
    }

    /**
     * @param solidInfillExtrusionWidth the solidInfillExtrusionWidth to set
     */
    public void setSolidInfillExtrusionWidth(double solidInfillExtrusionWidth) {
        this.solidInfillExtrusionWidth = solidInfillExtrusionWidth;
    }

    /**
     * @return the topSolidInfillExtrusionWidth
     */
    public double getTopSolidInfillExtrusionWidth() {
        return topSolidInfillExtrusionWidth;
    }

    /**
     * @param topSolidInfillExtrusionWidth the topSolidInfillExtrusionWidth to set
     */
    public void setTopSolidInfillExtrusionWidth(double topSolidInfillExtrusionWidth) {
        this.topSolidInfillExtrusionWidth = topSolidInfillExtrusionWidth;
    }

    /**
     * @return the supportMaterialExtrusionWidth
     */
    public double getSupportMaterialExtrusionWidth() {
        return supportMaterialExtrusionWidth;
    }

    /**
     * @param supportMaterialExtrusionWidth the supportMaterialExtrusionWidth to set
     */
    public void setSupportMaterialExtrusionWidth(double supportMaterialExtrusionWidth) {
        this.supportMaterialExtrusionWidth = supportMaterialExtrusionWidth;
    }
}
