package utils.time;

import edu.wpi.first.wpilibj.Timer;

/**
 * 
 * This class is a timer class implementing the WPI timer. This
 * class is a child of {@link ToasterTimer} but made for use in
 * a WPI environment.
 * 
 * @author Toaster Tech
 *
 */
public class WPITimer implements ToasterTimer {
	
	private Timer timer;
	private boolean timerStarted;
	
	/**
	 * Constructor. Creates a new {@link WPITimer} instance.
	 */
	public WPITimer(){
		timer = new Timer();
		timerStarted = false;
	}
	
	@Override
	public void start() {
		if(!timerStarted){
			timer.start();
			timerStarted = true;
		}
	}

	@Override
	public void reset() {
		timer.reset();
	}

	@Override
	public double get() {
		return timer.get();
	}

}
