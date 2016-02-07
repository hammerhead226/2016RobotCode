package org.usfirst.frc.team226.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static final int REAR_LEFT_DRIVE = 1;
	public static final int FRONT_LEFT_DRIVE = 2;
	public static final int REAR_RIGHT_DRIVE = 3;
	public static final int FRONT_RIGHT_DRIVE = 4;
	
	public static final int LEFT_ARM_MOTOR = 5;
	public static final int RIGHT_ARM_MOTOR = 6;
	
	public static final int LEFT_LIFT_MOTOR = 7;
	public static final int RIGHT_LIFT_MOTOR = 8;
	
	public static final int INTAKE_MOTOR = 9;
	
	public static final int LEFT_SHOOTER_MOTOR = 10;
	public static final int RIGHT_SHOOTER_MOTOR = 11;
	
}
