
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
	 * 
	 */
	private double zOffset;
	
	/**
	 * The G-Code flavor to output.
	 */
	private String gCodeFlavor;
	
	/**
	 * When true, uses relative E values (required by some firmwares)
	 */
	private boolean useRelativeEDistances;
	
	/**
	 * The number of extruders on the printer.
	 */
	private int numExtruders;
	
	/**
	 * The limit of vibrations (in Hz) where movements will be slowed.
	 * If a move hits the specified vibration frequency, the 
	 */
	private double vibrationLimit;
}
