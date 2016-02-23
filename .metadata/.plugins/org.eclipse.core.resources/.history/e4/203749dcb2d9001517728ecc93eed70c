package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class ShooterWheels extends PIDSubsystem {

	private static final double Kp = 0.0;
	private static final double Ki = 0.0;
	private static final double Kd = 0.0;
	
	public static final double OFF = 0.0,
			ON = 0.0;
	
	CANTalon leftShooterMotor = new CANTalon(RobotMap.LEFT_SHOOTER_MOTOR);
	CANTalon rightShooterMotor = new CANTalon(RobotMap.RIGHT_SHOOTER_MOTOR);
	
    // Initialize your subsystem here
    public ShooterWheels() {
    	super("ShooterWheels", Kp, Ki, Kd);
    
    	leftShooterMotor.changeControlMode(TalonControlMode.Speed);
    	leftShooterMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	leftShooterMotor.reset();
    	
    	rightShooterMotor.changeControlMode(TalonControlMode.Follower);
    	leftShooterMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	rightShooterMotor.set(leftShooterMotor.getDeviceID());
    	
    	setSetpoint(OFF);
    	enable();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return leftShooterMotor.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	leftShooterMotor.set(output);
    	rightShooterMotor.set(output *-1);
    }
}
