package ink3d.ConfigurationObjects;


public class PrinterConfiguration {
	
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
        
        
}
