package org.usfirst.frc5571.RobotFinal.commands;

import org.usfirst.frc5571.RobotFinal.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForwardCommand extends Command {
	private Timer timer;
	double driveDuration;

	public DriveForwardCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
	}

	public DriveForwardCommand(double duration) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
		Timer timer = new Timer();
		timer.reset();
		driveDuration = duration;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrain.mecanumDriveAutoFine(1, 0, 0);
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


