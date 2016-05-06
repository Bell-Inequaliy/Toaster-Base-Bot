package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;

/**
 * 
 * This is the concrete hardware layer that specifically does not run a 
 * WPI environment so that values can be debugged and logged without a 
 * robot.
 * 
 * @author Toaster Tech
 *
 */
public class DriveHardwareSimulation extends DriveHardwareLayer{
	
	private double leftValue;
	private double rightValue;
	
	@Override
	public void runPeriodic() {
		System.out.println("Left output value: " + leftValue);
		System.out.println("Right output value: " + rightValue);
	}

	@Override
	public void robotInit() {
		
	}

	@Override
	public void setDriveLeft(double value) {
		leftValue = value;
	}

	@Override
	public void setDriveRight(double value) {
		rightValue = value;
	}

}
