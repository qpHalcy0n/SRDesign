package ink3d.ConfigurationObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PrinterConfiguration {
    public static final String DEFAULT_NAME = "Default";
    public static final double DEFAULT_BED_X = 200.0;
    public static final double DEFAULT_BED_Y = 200.0;
    public static final double DEFAULT_PRINT_CENTER_X = 100.0;
    public static final double DEFAULT_PRINT_CENTER_Y = 100.0;
    public static final double DEFAULT_Z_OFFSET = 0.0;
    public static final String DEFAULT_GCODE_FLAVOR = "reprap";
    public static final boolean DEFAULT_USE_RELATIVE_E_DISTANCES = false;
    public static final boolean DEFAULT_USE_FIRMWARE_RETRACTION = false;
    public static final double DEFAULT_VIBRATION_LIMIT = 0.0;
    public static final String DEFAULT_START_GCODE = "";
    public static final String DEFAULT_END_GCODE = "";

    public PrinterConfiguration() {
        name = DEFAULT_NAME;
        bedX = DEFAULT_BED_X;
        bedY = DEFAULT_BED_Y;
        printCenterX = DEFAULT_PRINT_CENTER_X;
        printCenterY = DEFAULT_PRINT_CENTER_Y;
        zOffset = DEFAULT_Z_OFFSET;
        gCodeFlavor = DEFAULT_GCODE_FLAVOR;
        useRelativeEDistances = DEFAULT_USE_RELATIVE_E_DISTANCES;
        vibrationLimit = DEFAULT_VIBRATION_LIMIT;
        useFirmwareRetraction = DEFAULT_USE_FIRMWARE_RETRACTION;
        startGCode = DEFAULT_START_GCODE;
        endGCode = DEFAULT_END_GCODE;
        extruderList = new ArrayList<ExtruderConfiguration>();
    }

    private String name;
    /**
     * The max x of the bed.
     */
    private double bedX;

    /**
     * The max y of the bed.
     */
    private double bedY;

    /**
     * The x of the center of the print.
     */
    private double printCenterX;

    /**
     * The y of the center of the print.
     */
    private double printCenterY;

    /**
     * The zOffset of the print bed surfaces.  Used if the bed does not
     * sit exactly at z = 0.
     */
    private double zOffset;

    /**
     * The G-Code flavor to output.
     */
    private String gCodeFlavor;

    /**
     * When true, uses relative E values (required by some firmwares).
     */
    private boolean useRelativeEDistances;

    /**
     * The number of extruders on the printer.
     */
    private int numExtruders;

    /**
     * The limit of vibrations (in Hz) where movements will be slowed.
     * If a move hits the specified vibration frequency, the extruder
     * will slow.
     */
    private double vibrationLimit;

    private boolean useFirmwareRetraction;
    private String startGCode;
    private String endGCode;

    /**
     * List of the extruders on the printer.  In order of where they
     * are on the printer (i.e. extruderList[0] is T0).
     */
    private List<ExtruderConfiguration> extruderList;

    public double getBedX() {
        return bedX;
    }

    public void setBedX(double bedX) {
        this.bedX = bedX;
    }

    public double getBedY() {
        return bedY;
    }

    public void setBedY(double bedY) {
        this.bedY = bedY;
    }

    public double getPrintCenterX() {
        return printCenterX;
    }

    public void setPrintCenterX(double printCenterX) {
        this.printCenterX = printCenterX;
    }

    public double getPrintCenterY() {
        return printCenterY;
    }

    public void setPrintCenterY(double printCenterY) {
        this.printCenterY = printCenterY;
    }

    public double getzOffset() {
        return zOffset;
    }

    public void setzOffset(double zOffset) {
        this.zOffset = zOffset;
    }

    public String getgCodeFlavor() {
        return gCodeFlavor;
    }

    public void setgCodeFlavor(String gCodeFlavor) {
        this.gCodeFlavor = gCodeFlavor;
    }

    public boolean isUseRelativeEDistances() {
        return useRelativeEDistances;
    }

    public void setUseRelativeEDistances(boolean useRelativeEDistances) {
        this.useRelativeEDistances = useRelativeEDistances;
    }

    public int getNumExtruders() {
        return numExtruders;
    }

    public void setNumExtruders(int numExtruders) {
        this.numExtruders = numExtruders;
    }

    public double getVibrationLimit() {
        return vibrationLimit;
    }

    public void setVibrationLimit(double vibrationLimit) {
        this.vibrationLimit = vibrationLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }        

    /**
     * @return the extruderList
     */
    public List<ExtruderConfiguration> getExtruderList() {
        return extruderList;
    }

    /**
     * @param extruderList the extruderList to set
     */
    public void setExtruderList(List<ExtruderConfiguration> extruderList) {
        this.extruderList = extruderList;
    }

    /**
     * @return the startGCode
     */
    public String getStartGCode() {
        return startGCode;
    }

    /**
     * @param startGCode the startGCode to set
     */
    public void setStartGCode(String startGCode) {
        this.startGCode = startGCode;
    }

    /**
     * @return the endGCode
     */
    public String getEndGCode() {
        return endGCode;
    }

    /**
     * @param endGCode the endGCode to set
     */
    public void setEndGCode(String endGCode) {
        this.endGCode = endGCode;
    }

    /**
     * @return the useFirmwareRetraction
     */
    public boolean isUseFirmwareRetraction() {
        return useFirmwareRetraction;
    }

    /**
     * @param useFirmwareRetraction the useFirmwareRetraction to set
     */
    public void setUseFirmwareRetraction(boolean useFirmwareRetraction) {
        this.useFirmwareRetraction = useFirmwareRetraction;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.bedX) ^ (Double.doubleToLongBits(this.bedX) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.bedY) ^ (Double.doubleToLongBits(this.bedY) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.printCenterX) ^ (Double.doubleToLongBits(this.printCenterX) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.printCenterY) ^ (Double.doubleToLongBits(this.printCenterY) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.zOffset) ^ (Double.doubleToLongBits(this.zOffset) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.gCodeFlavor);
        hash = 67 * hash + (this.useRelativeEDistances ? 1 : 0);
        hash = 67 * hash + this.numExtruders;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.vibrationLimit) ^ (Double.doubleToLongBits(this.vibrationLimit) >>> 32));
        hash = 67 * hash + (this.useFirmwareRetraction ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.startGCode);
        hash = 67 * hash + Objects.hashCode(this.endGCode);
        hash = 67 * hash + Objects.hashCode(this.extruderList);
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
        final PrinterConfiguration other = (PrinterConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bedX) != Double.doubleToLongBits(other.bedX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bedY) != Double.doubleToLongBits(other.bedY)) {
            return false;
        }
        if (Double.doubleToLongBits(this.printCenterX) != Double.doubleToLongBits(other.printCenterX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.printCenterY) != Double.doubleToLongBits(other.printCenterY)) {
            return false;
        }
        if (Double.doubleToLongBits(this.zOffset) != Double.doubleToLongBits(other.zOffset)) {
            return false;
        }
        if (!Objects.equals(this.gCodeFlavor, other.gCodeFlavor)) {
            return false;
        }
        if (this.useRelativeEDistances != other.useRelativeEDistances) {
            return false;
        }
        if (this.numExtruders != other.numExtruders) {
            return false;
        }
        if (Double.doubleToLongBits(this.vibrationLimit) != Double.doubleToLongBits(other.vibrationLimit)) {
            return false;
        }
        if (this.useFirmwareRetraction != other.useFirmwareRetraction) {
            return false;
        }
        if (!Objects.equals(this.startGCode, other.startGCode)) {
            return false;
        }
        if (!Objects.equals(this.endGCode, other.endGCode)) {
            return false;
        }
        if (!Objects.equals(this.extruderList, other.extruderList)) {
            return false;
        }
        return true;
    }
}
