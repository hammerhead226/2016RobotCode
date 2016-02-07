package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class FourBarLinkageAuto extends PIDSubsystem {

	//PID Values
	private static final double Kp = 0.0;
	private static final double Ki = 0.0;
	private static final double Kd = 0.0;
	
	//Preset 4 bar linkage positions
	public static final double ZERO = 0.0,
			HALF = 0.0,
			FULL = 0.0,
			EXTENDED = 0.0;
	
	CANTalon leftArmMotor = new CANTalon(RobotMap.LEFT_ARM_MOTOR);
	CANTalon rightArmMotor = new CANTalon(RobotMap.RIGHT_ARM_MOTOR);
	
    // Initialize your subsystem here
    public FourBarLinkageAuto() {
    	super ("FourBarLinkageAuto", Kp, Ki, Kd);
    	leftArmMotor.changeControlMode(TalonControlMode.Position);
    	leftArmMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	leftArmMotor.reset();
    	
    	//Have right motor be a slave to left
    	rightArmMotor.changeControlMode(TalonControlMode.Follower);
    	rightArmMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	rightArmMotor.set(leftArmMotor.getDeviceID());
    	
    	//Default Setpoint
    	setSetpoint(ZERO);
    	enable();    	
    }
    
    //Not needed
    public void initDefaultCommand() {}
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return leftArmMotor.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	leftArmMotor.set(output);
    	rightArmMotor.set(output);
    }
}
