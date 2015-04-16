package org.usfirst.frc5571.RobotFinal.commands;

import org.usfirst.frc5571.RobotFinal.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class MoveElevatorToPositionCommand extends Command {
	private Timer timer;
	double moveTime;
	double targetPosition;

	public MoveElevatorToPositionCommand() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.elevator);
	}

	public MoveElevatorToPositionCommand(double position, double duration) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.elevator);
		timer = new Timer();
		moveTime = duration;
		targetPosition = position;
	}



	// Called just before this Command runs the first time
	protected void initialize() {
		timer.reset();
		timer.start();

		// initialize PID profiles for gripper
		Robot.elevator.initCanPID();
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.elevator.isHomed()){
			Robot.elevator.moveToPosition(targetPosition);
		}
		
//		if (Robot.elevator.clampCuurenLimited()) {
//			Robot.clamp.closeClamp();
//			SmartDashboard.putString("Clamp MODE:", "Closing");
//		} else {
//			Robot.clamp.servoHere();
//			SmartDashboard.putString("Clamp MODE:", "CLOSE CURRENT LIMIT EXCEEDED");
//		}
//		if (Robot.clamp.closedLimitReached()){
//			this.end();
//		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return ((timer.get() > moveTime) || ((Robot.elevator.getPositionError() < 200) && (Robot.elevator.getPositionError() > -200)));
	}


	// Called once after isFinished returns true
	protected void end() {
		//Robot.elevator.servoHere();
		timer.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.elevator.disable_ElevMotor();
		timer.stop();
	}
}


