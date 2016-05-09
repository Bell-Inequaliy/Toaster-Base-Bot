package org.usfirst.frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * 
 * This class is designed for usage with a standard gamepad. Provisions 
 * for triggers treated as an axis are included. Provisions for 
 * inverted gamepads are given in the constructor.
 * 
 * @author Toaster Tech
 *
 */
public class Gamepad {
	
	private Joystick js;
	private double scale;
	
	/**
	 * Constructor for a gamepad instance.
	 * 
	 * @param index : The USB port index for the gamepad.
	 * @param inverted : If the gamepad has inverted stick axes.
	 */
	public Gamepad (int index, boolean inverted){
		js = new Joystick(index);
		if(inverted){   // If it is inverted we want to invert all our inputs
			scale = -1; // Multiply by -1 to invert
		}else{
			scale = 1;  // Leave it be otherwise
		}
	}
	
	/**
	 * Get the left axis of the joystick
	 * 
	 * @return The axis value, from -1.0 to 1.0
	 */
	public double getYLeft(){
		return js.getRawAxis(1)*scale;
	}
	
	/**
	 * Get the right axis of the joystick
	 * 
	 * @return The axis value, from -1.0 to 1.0
	 */
	public double getYRight(){
		return js.getRawAxis(5)*scale;
	}
	
	/**
	 * Get the left trigger of the joystick
	 * 
	 * @return If the trigger is being pushed past a defined threshold,
	 * as a boolean
	 */
	public boolean getTriggerLeft(){
		return js.getRawAxis(2)>.3;
	}
	
	/**
	 * Get the right trigger of the joystick
	 * 
	 * @return If the trigger is being pushed past a defined threshold,
	 * as a boolean
	 */
	public boolean getTriggerRight(){
		return js.getRawAxis(3)>.3;
	}

	/**
	 * Get if the defined button is being pressed
	 * 
	 * @param type : The index of the button. Starts at 1.
	 * @return If the button is being pushed, as a boolean
	 */
	public boolean getButton(int type){
		return(js.getRawButton(type));
	}
	
}
