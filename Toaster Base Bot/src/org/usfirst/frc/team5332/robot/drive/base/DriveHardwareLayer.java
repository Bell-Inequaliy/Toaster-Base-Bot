package org.usfirst.frc.team5332.robot.drive.base;

import subsystem.BaseLayer;

/**
 * 
 * As a base layer superclass, this class is designed to define methods
 * that all concrete layers will inherit as well as to extend 
 * {@link BaseLayer} methods to these layers as well.
 * 
 * @author Toaster Tech
 *
 */
public abstract class DriveHardwareLayer implements BaseLayer{
	
	/**
	 * Set the value to the left drive motor controller
	 * 
	 * @param value : The target value, from -1.0 to 1.0
	 */
	public abstract void setDriveLeft(double value);
	
	/**
	 * Set the value to the right drive motor controller
	 * 
	 * @param value : The target value, from -1.0 to 1.0
	 */
	public abstract void setDriveRight(double value);
	
}
