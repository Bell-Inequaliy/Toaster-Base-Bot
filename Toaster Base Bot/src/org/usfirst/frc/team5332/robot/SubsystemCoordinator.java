package org.usfirst.frc.team5332.robot;

import java.util.HashMap;
import utils.time.ToasterTimer;

/**
 * 
 * This class is designed to coordinate multiple subsystems. It can be
 * viewed as a sort of global handler in which booleans, numbers, strings 
 * and other objects can pass data and interact across their subsystems. It
 * maintains separation of interests by storing the data inside this class
 * rather than having a complex variable chain between subsystems. The 
 * coordinator maps these values to a {@link HashMap} of either doubles or 
 * booleans.
 * 
 * @author Toaster Tech
 *
 */
public class SubsystemCoordinator {
	
	private static SubsystemCoordinator instance = null;
	private ToasterTimer timer = null;
	private boolean timerStarted;
	private HashMap<String, Double> doubleHashMap;
	private HashMap<String, Boolean> booleanHashMap;
	private HashMap<String, String> stringHashMap;
	
	/**
	 * Constructor. Creates a new {@link SubsystemCoordinator} and
	 * initializes HashMaps.
	 */
	public SubsystemCoordinator(){
		timerStarted = false;
		doubleHashMap = new HashMap<String, Double>();
		booleanHashMap = new HashMap<String, Boolean>();
		stringHashMap = new HashMap<String, String>();
	}
	
	/**
	 * Get the static instance of the {@link SubsystemCoordinator}, or
	 * create a new instance if it has not already been created. Note
	 * that a get should be called initially to ensure construction
	 * of the {@link SubsystemCoordinator}
	 * 
	 * @return The static instance of the {@link SubsystemCoordinator}
	 */
	public static SubsystemCoordinator get(){
		if(instance == null){
			instance = new SubsystemCoordinator();
		}
		return instance;
	}
	
	/**
	 * Set the global timer entity to the target timer
	 * 
	 * @param timer The target timer, as a {@link ToasterTimer}
	 */
	public void setTimer(ToasterTimer timer){
		if(this.timer == null){ // If the timer has not been set
			this.timer = timer; // Set the timer
		}else{					// If the timer has been set
								// Do nothing
		}
	}
	
	/**
	 * Starts the global timer, if mapped and if not already started.
	 */
	public void startTimer(){
		if(!(timer == null)){  // If the timer exists
			if(!timerStarted){ // If we have not already started the timer
				timer.start(); // Start the timer
			}
		}
	}
	
	/**
	 * Get the current time on the global timer.
	 * 
	 * @return
	 * <strong>If the timer is set and started:</strong> The current time
	 * <br><br>
	 * <strong>If the timer is set and not started:</strong> -1
	 * <br><br>
	 * <strong>If the timer is not set:</strong> -1000
	 */
	public double getTime(){
		if(!(timer == null)){		// If the timer exists
			if(timerStarted){		// If the timer was started
				return timer.get(); // Return the current time
			}else{					// If the timer wasn't started
				return -1;			// Return -1
			}
		}else{						// If the timer doesn't exist
			return -1000;			// Return -1000
		}
	}
	
	/**
	 * Get a double value mapped to the HashMap at the target key.
	 * 
	 * @param key The access key for the target double on the HashMap
	 * @return The double value mapped to the HashMap at the target key
	 */
	public double getDouble(String key){
		return doubleHashMap.get(key);
	}
	
	/**
	 * Get a boolean value mapped to the HashMap at the target key.
	 * 
	 * @param key The access key for the target double on the HashMap
	 * @return The boolean value mapped to the HashMap at the target key
	 */
	public boolean getBoolean(String key){
		return booleanHashMap.get(key);
	}
	
	/**
	 * Get a String value mapped to the HashMap at the target key.
	 * 
	 * @param key The access key for the target double on the HashMap
	 * @return The String value mapped to the HashMap at the target key
	 */
	public String getString(String key){
		return stringHashMap.get(key);
	}
	
	/**
	 * Put a double value to the HashMap at the target key.
	 * 
	 * @param key The access key for the target double on the HashMap
	 * @param value The double value to be mapped at the target key
	 */
	public void putDouble(String key, double value){
		doubleHashMap.put(key, value);
	}
	
	/**
	 * Put a boolean value to the HashMap at the target key.
	 * 
	 * @param key The access key for the target boolean on the HashMap
	 * @param value The boolean value to be mapped at the target key
	 */
	public void putBoolean(String key, boolean value){
		booleanHashMap.put(key, value);
	}
	
	/**
	 * Put a string value to the HashMap at the target key.
	 * 
	 * @param key The access key for the target string on the HashMap
	 * @param value The string value to be mapped at the target key
	 */
	public void putString(String key, String value){
		stringHashMap.put(key, value);
	}
	
}
