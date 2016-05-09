package utils.time;

/**
 * 
 * This class is the basic interface for Java and WPI timers. This
 * allows for the separations of interest and simulations outside
 * a WPI environment. All variants of timers should implement
 * this class.
 * 
 * @author Tosater Tech
 *
 */
public interface ToasterTimer {
	
	/**
	 * Start the timer
	 */
	public void start();
	
	/**
	 * Reset the timer count to zero
	 */
	public void reset();
	
	/**
	 * Get the current time
	 * 
	 * @return The current time in seconds, as a double
	 */
	public double get();
	
}
