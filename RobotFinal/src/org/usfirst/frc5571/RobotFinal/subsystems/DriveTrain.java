// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5571.RobotFinal.subsystems;

import org.usfirst.frc5571.RobotFinal.Robot;
import org.usfirst.frc5571.RobotFinal.RobotMap;
import org.usfirst.frc5571.RobotFinal.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public double triggerTwist;
    CANTalon cANTalonRearLeft = RobotMap.driveTrainCANTalonRearLeft;
    CANTalon cANTalonFrontLeft = RobotMap.driveTrainCANTalonFrontLeft;
    CANTalon cANTalonRearRight = RobotMap.driveTrainCANTalonRearRight;
    CANTalon cANTalonFrontRight = RobotMap.driveTrainCANTalonFrontRight;
    RobotDrive robotDrive41 = RobotMap.driveTrainRobotDrive41;
    
    public void initInvert() {
    	RobotMap.driveTrainRobotDrive41.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    	RobotMap.driveTrainRobotDrive41.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    }
    
	public void mecanumDrive_Polar() {
	    double triggerTwist = (Robot.oi.xboxController.getRawAxis(2) * -1) + Robot.oi.xboxController.getRawAxis(3);  
	    robotDrive41.mecanumDrive_Polar(correctDeadSpot( Robot.oi.xboxController.getMagnitude() ), -Robot.oi.xboxController.getDirectionDegrees(), triggerTwist);
	}

    
	  public double correctDeadSpot(double value) {
	    	double deadZone = 0.20; 					//This sets a deadzone that i have seen works for Xbox controllers online
	        if (Math.abs(value) < deadZone ) 			//Checks value pulled from the double inside the methode against the deadzone.
	                return 0; 							// if less than the deadzone, returns nothing.
	        return value; 								//Above deadzone just applies voltage.
	}
	
	
	// Added this so the stop method can be used
		public void disable_Drive() {
			robotDrive41.mecanumDrive_Polar(0, 0, 0);
		}
		
	    
	    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveTrainCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

