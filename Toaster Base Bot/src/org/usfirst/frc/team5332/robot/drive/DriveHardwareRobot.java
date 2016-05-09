package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;
import edu.wpi.first.wpilibj.TalonSRX;

/**
 * 
 * This is the concrete hardware layer that specifically runs a WPI 
 * environment versus a simulation environment. All hardware 
 * processing should be done in this class.
 * <br>
 * <br>
 * This layer is designed for a two-motor-per-side tank
 * drive.
 * 
 * @author Toaster Tech
 *
 */
public class DriveHardwareRobot extends DriveHardwareLayer{
	
	private double leftValue;
	private double rightValue;
	private TalonSRX leftMotor1;
	private TalonSRX leftMotor2;
	private TalonSRX rightMotor1;
	private TalonSRX rightMotor2;
	
	/**
	 * Constructor. Creates a new {@link DriveHardwareRobot}
	 */
	public DriveHardwareRobot(){
		leftMotor1 = new TalonSRX(0);
		leftMotor2 = new TalonSRX(1);
		rightMotor1 = new TalonSRX(2);
		rightMotor2 = new TalonSRX(3);
	}
	
	@Override
	public void runPeriodic() {
		leftMotor1.set(leftValue);
		leftMotor2.set(leftValue);
		rightMotor1.set(rightValue);
		rightMotor2.set(rightValue);
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
