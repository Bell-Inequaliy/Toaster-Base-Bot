package org.usfirst.frc.team5332.robot.drive.teleopmodes;

import org.usfirst.frc.team5332.robot.Gamepad;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;

/**
 * 
 * This is a teleop mode to drive in a tank drive mode using both gamepad
 * axes
 * 
 * @author Toaster Tech
 *
 */
public class DriveTeleopTank extends DriveCommandLayer{
	
	private Gamepad gamepad;
	
	public DriveTeleopTank(Gamepad js){
		gamepad = js;
	}

	@Override
	public void robotInit() {
		
	}

	@Override
	/*
	 * Set the child of this class
	 */
	public void setChild(DriveSystemLayer c) {
		systemLayer=c;
	}

	@Override
	public void runPeriodic() {
		systemLayer.setDriveHardwareLeft(gamepad.getYLeft());
		systemLayer.setDriveHardwareRight(gamepad.getYRight());
	}

	@Override
	public boolean isFinished() {
		return false;
	}
	
}
