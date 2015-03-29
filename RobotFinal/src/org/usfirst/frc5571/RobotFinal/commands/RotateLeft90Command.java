package org.usfirst.frc5571.RobotFinal.commands;

import org.usfirst.frc5571.RobotFinal.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class RotateLeft90Command extends Command {
   	private Timer timer;
   	double driveDuration;
   	
	
	public RotateLeft90Command() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
	}

	public RotateLeft90Command(double duration) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	Timer timer = new Timer();
    	timer.reset();
	}
	

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.mecanumDriveAutoFine(0, 0, -1);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (timer.get() < driveDuration){
    		return false;
    	}
    	else{ /* command is finished so stop the drive train */
    		Robot.driveTrain.mecanumDriveAutoFine(0, 0, 0);
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
