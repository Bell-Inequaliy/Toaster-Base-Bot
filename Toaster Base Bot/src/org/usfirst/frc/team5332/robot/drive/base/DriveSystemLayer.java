package org.usfirst.frc.team5332.robot.drive.base;

import subsystem.Layer;

/**
 * 
 * As a layer superclass, this class is designed to define methods that all 
 * concrete layers will inherit, to extend {@link Layer} methods to the 
 * classes that inherit it, and to extend its functionality to the child
 * class as defined in the {@link Layer} generic interface
 * 
 * @author Toaster Tech
 *
 */
public abstract class DriveSystemLayer implements Layer<DriveHardwareLayer> {
	
	@Override
	public abstract void runPeriodic();

	@Override
	public abstract void setChild(DriveHardwareLayer c); // Set the child
	
	/**
	 * Set the left side value for the hardware layer
	 * 
	 * @param value : The left side value, from -1.0 to 1.0
	 */
	public abstract void setDriveHardwareLeft(double value);
	
	/**
	 * Set the right side value for the hardware layer
	 * 
	 * @param value : The right side value, from -1.0 to 1.0
	 */
	public abstract void setDriveHardwareRight(double value);
	
}
