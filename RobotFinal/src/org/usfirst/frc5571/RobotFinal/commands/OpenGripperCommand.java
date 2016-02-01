package org.usfirst.frc5571.RobotFinal.commands;

import org.usfirst.frc5571.RobotFinal.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class OpenGripperCommand extends Command {
	private Timer timer;
	double openTime = 1.5;

	public OpenGripperCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.clamp);
	}

	public OpenGripperCommand(double duration) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.clamp);
		timer = new Timer();
		openTime = duration;
	}



	// Called just before this Command runs the first time
	protected void initialize() {
		timer.reset();
		timer.start();

		// initialize PID profiles for gripper
		//Robot.clamp.initCanPID();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.clamp.openClamp();

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (timer.get() > openTime ||Robot.clamp.openLimitReached() );
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


