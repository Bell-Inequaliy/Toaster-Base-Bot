package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.Gamepad;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;
import org.usfirst.frc.team5332.robot.drive.teleopmodes.DriveTeleopStraight;
import org.usfirst.frc.team5332.robot.drive.teleopmodes.DriveTeleopTank;

/**
 * 
 * This is the main class that is called periodically during
 * the teleop mode. It has two modes, one that drives straight
 * when the gamepad left trigger is pressed and the other that
 * runs a simple tank drive mode.
 * 
 * @author Toaster Tech
 *
 */
public class DriveTeleop extends DriveCommandLayer{
	
	private Gamepad gamepad;
	private DriveTeleopTank driveTank;
	private DriveTeleopStraight driveStraight;

	/**
	 * Constructor.
	 */
	public DriveTeleop(){
		gamepad = new Gamepad(0, true);
		driveTank = new DriveTeleopTank(gamepad);
		driveStraight = new DriveTeleopStraight(gamepad);
	}
	
	@Override
	/*
	 * Set the child for all the layers
	 */
	public void setChild(DriveSystemLayer c) {
		systemLayer=c;
		driveStraight.setChild(c);
		driveTank.setChild(c);
	}
	
	@Override
	/*
	 * Initialize the sub classes
	 */
	public void robotInit() {
		driveStraight.robotInit();
		driveTank.robotInit();
	}

	@Override
	public void runPeriodic() {
		if(gamepad.getTriggerLeft()){
			driveStraight.runPeriodic();
		}else{
			driveTank.runPeriodic();
		}
	}

	@Override
	public boolean isFinished() {
		return false; // Do not return finished, as there is no need to
	}
	
}
