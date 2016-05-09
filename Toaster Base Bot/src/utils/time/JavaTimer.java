package utils.time;

/**
 * 
 * This class is a timer class implementing the Java timer. This
 * class is a child of {@link ToasterTimer} but made for use in
 * a non-WPI environment.
 * 
 * @author Toaster Tech
 *
 */
public class JavaTimer implements ToasterTimer {
	
	private long startTime;
	private boolean timerStarted;
	
	/**
	 * Constructor. Creates new {@link JavaTimer} instance.
	 */
	public JavaTimer(){
		timerStarted = false;
	}
	
	@Override
	public void start() {
		if(!timerStarted){
			startTime = System.nanoTime();
			timerStarted = true;
		}
	}

	@Override
	public void reset() {
		if(timerStarted){
			startTime = System.nanoTime();
		}
	}

	@Override
	public double get() {
		return (System.nanoTime() - startTime)/Math.pow(10, 9); // In seconds
	}

}
