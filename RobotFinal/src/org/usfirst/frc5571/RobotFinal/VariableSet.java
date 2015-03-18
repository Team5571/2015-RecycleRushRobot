package org.usfirst.frc5571.RobotFinal;
    

public class VariableSet {

	
	//CLAMP
	public static double MAX_CLAMP_CURRENT = 25.0;  // limit current to 10A x 12V = 120W  mini CIM motor is rated at 230W and 86A Stall Current
	public static double CLOSE_SPEED = 400;  // change in encoder position  per 10 ms
	public static double OPEN_SPEED = -200;

	
	
	//ELEVATOR
	public static double MAX_ELEV_CURRENT = 100.0;  // limit current to 3A  motor is rated at 36.91W 
	public static double DOWN_SPEED = -100;  // position change per 10 ms
	public static double UP_SPEED = 200;
	
	
	
	//DRIVETRAIN
    public static double deadZone = 0.10;
    public static double rotateReduction = .60;
    public static double magnitudeReduction = .50;
	
	
	
	
}
