package subsystem;

/**
 * 
 * This is the interface for all layer based classes. Methods that will be 
 * implemented in all layer based classes should be added here
 *
 * @author Toaster Tech
 * 
 */
public interface BaseLayer {
	/**
	 * Universal method called during a periodic run-time
	 */
	public void runPeriodic();
	
	/**
	 * Universal method called during initializations
	 */
	public void robotInit();
}
