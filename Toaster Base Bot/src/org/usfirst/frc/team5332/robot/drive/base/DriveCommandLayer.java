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
public abstract class DriveCommandLayer implements Layer<DriveSystemLayer>{
	
	/*
	 * As command layers are the most common and most versatile, they all
	 * must use the same systemLayer so that new hardware/system layers are
	 * not being created for each command layer. Thus, they are all defined
	 * in the layer superclass for each individual layer to inherit. The
	 * child must still be set in each individual class, but the definition
	 * here allows it so that each class is setting its child as the same
	 * layer.
	 */
	protected DriveSystemLayer systemLayer;
	
	@Override
	public abstract void runPeriodic();
	
	@Override
	public void setChild(DriveSystemLayer c){
		systemLayer=c; // Set the universal system layer
	}
	
	public abstract boolean isFinished();
	
}
