package org.usfirst.frc.team5332.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import subsystem.Subsystem;
import org.usfirst.frc.team5332.robot.drive.DriveHardwareRobot;
import org.usfirst.frc.team5332.robot.drive.DriveSystem;
import org.usfirst.frc.team5332.robot.drive.DriveTeleop;
import org.usfirst.frc.team5332.robot.drive.base.DriveCommandLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveHardwareLayer;
import org.usfirst.frc.team5332.robot.drive.base.DriveSystemLayer;

import edu.wpi.first.wpilibj.CameraServer;

/**
 * 
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 */
public class Robot extends IterativeRobot {
	/*
	 * Defines the drive subsystem.
	 */
	Subsystem<DriveHardwareLayer,DriveSystemLayer,DriveCommandLayer> drive;
	
    /**
     * This method is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	drive=new Subsystem<DriveHardwareLayer,DriveSystemLayer,DriveCommandLayer>
    	(new DriveHardwareRobot(),new DriveSystem(),new DriveTeleop()); // Define the drive subsystem and its layers
    	drive.robotInit(); // Run the robotInit method for all drive subsystem layers
    	
		try{
			CameraServer server = CameraServer.getInstance();
			server.setQuality(50);
			server.startAutomaticCapture("cam0");
		}catch(Exception e){
			System.out.println(e);
    	}
    }
    
    /**
     * This method is called specifically at the very beginning of
     * autonomous
     */
    public void autonomousInit() {
    	
    }

    /**
     * This method is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }
    
    /**
     * This method is called specifically at the very beginning of
     * teleop
     */
    public void teleopInit(){
    	/*
    	 * Set the command layers for teleop.     	
    	 */
    	drive.setCommandLayer(new DriveTeleop());
    }

    /**
     * This method is called periodically during operator control
     */
    public void teleopPeriodic() {
    	/*
    	 * Execute all of the drive subsystem layers' runPeriodic() methodss
    	 */
        drive.runPeriodic();
    }
    
    /**
     * This method is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
