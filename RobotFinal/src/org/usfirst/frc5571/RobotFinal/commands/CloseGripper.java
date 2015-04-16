package org.usfirst.frc5571.RobotFinal.commands;

import org.usfirst.frc5571.RobotFinal.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class CloseGripper extends Command {
	private Timer timer;
	double closeTime;

	public CloseGripper() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.clamp);
	}

	public CloseGripper(double duration) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.clamp);
		timer = new Timer();
		closeTime = duration;
	}



	// Called just before this Command runs the first time
	protected void initialize() {
		timer.reset();
		timer.start();

		// initialize PID profiles for gripper
		Robot.clamp.initCanPID();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!Robot.clamp.clampCuurenLimited()) {
			Robot.clamp.closeClamp();
			SmartDashboard.putString("Clamp MODE:", "Closing");
		} else {
			Robot.clamp.servoHere();
			SmartDashboard.putString("Clamp MODE:", "CLOSE CURRENT LIMIT EXCEEDED");
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (timer.get() > closeTime);
	}


	// Called once after isFinished returns true
	protected void end() {
		Robot.clamp.servoHere();
		timer.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.clamp.disable_ClampMotor();
		timer.stop();
	}
}


