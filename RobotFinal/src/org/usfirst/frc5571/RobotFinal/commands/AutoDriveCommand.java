package org.usfirst.frc5571.RobotFinal.commands;

import org.usfirst.frc5571.RobotFinal.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveCommand extends Command {
	Timer timer;
	double autoMagnitude;
	double autoDirection;
	double autoRotation;
	double autoDriveDuration;

	public AutoDriveCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
	}

	public AutoDriveCommand(double magnitude, double direction, double rotation, double duration) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
		timer = new Timer();
		autoMagnitude = magnitude;
		autoDirection = direction;
		autoRotation = rotation;
		autoDriveDuration = duration;	
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.reset();
		timer.start();
		Robot.driveTrain.mecanumDriveAutoFine(autoMagnitude, autoDirection, autoRotation);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (timer.get() > autoDriveDuration);
	}
	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.mecanumDriveAutoFine(0, 0, 0);
		timer.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
	}
}


