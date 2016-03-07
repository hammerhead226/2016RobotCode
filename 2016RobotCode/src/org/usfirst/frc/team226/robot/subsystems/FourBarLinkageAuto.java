package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.MoveFourBar;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FourBarLinkageAuto extends PIDSubsystem {


	SpeedController leftArmMotor = new CANTalon(RobotMap.LEFT_ARM_MOTOR);
	SpeedController rightArmMotor = new CANTalon(RobotMap.RIGHT_ARM_MOTOR);
	
	Encoder encoder = new Encoder(RobotMap.LIFT_ENCODER_A, RobotMap.LIFT_ENCODER_B, false, Encoder.EncodingType.k4X);
	
	//PID Values
	private static final double Kp = 0.5;
	private static final double Ki = 0.0;
	private static final double Kd = 0.0;
	
	//Preset 4 bar linkage positions
	public static final double ZERO = 0.0,
			HALF = 635.5,
			FULL = 1271.25;
	
	
    // Initialize your subsystem here
    @SuppressWarnings("deprecation")
	public FourBarLinkageAuto() {
    	super ("FourBarLinkageAuto", Kp, Ki, Kd);
    	encoder.setMaxPeriod(.1);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(5);
		encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(7);
		
		//Max Distance is 1271.25
		SmartDashboard.putDouble("Encoder Distance", encoder.getDistance());
    	
    	//Default Setpoint
    	setSetpoint(ZERO);
    	enable();    	
    }
    
    //Not needed
    public void initDefaultCommand() {
    	setDefaultCommand(new MoveFourBar());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return encoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	leftArmMotor.set(output * -1);
    	rightArmMotor.set(output);
    }
}
