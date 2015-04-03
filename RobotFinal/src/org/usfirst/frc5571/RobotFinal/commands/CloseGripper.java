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
    	Timer timer = new Timer();
		timer.reset();
    	closeTime = duration;
    }
    
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	requires(Robot.clamp);
		Timer timer = new Timer();
		timer.reset();
		
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
		if (timer.get() < closeTime){
			return false;
		}
		else{ /* command is finished so stop the drive train */
			//Robot.driveTrain.mecanumDriveAutoFine(0, 0, 0);
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


