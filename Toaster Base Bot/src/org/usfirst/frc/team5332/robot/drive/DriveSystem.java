package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;

/**
 * 
 * This is the concrete system layer, which is created once and designed
 * to operate separately from hardware. Speed curving and data storage
 * or processing is typically handled here.
 * 
 * @author Toaster Tech
 * 
 */
public class DriveSystem extends DriveSystemLayer{
	
	private DriveHardwareLayer hardwareLayer;
	private double leftValue;
	private double rightValue;
	
	/**
	 * Constructor.
	 */
	public DriveSystem(){
		
	}
	
	@Override
	public void robotInit() {
		
	}

	@Override
	public void runPeriodic() {
		hardwareLayer.setDriveLeft(leftValue);
		hardwareLayer.setDriveRight(rightValue);
	}

	@Override
	public void setChild(DriveHardwareLayer c) {
		hardwareLayer = c;
	}

	@Override
	public void setDriveHardwareLeft(double value) {
		leftValue = Math.pow(value, 3); // Speed curving
	}

	@Override
	public void setDriveHardwareRight(double value) {
		rightValue = Math.pow(value, 3); // Speed curving
	}

}
