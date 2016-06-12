package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.MoveFourBar;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FourBar extends Subsystem {
	
	SpeedController leftArmMotor = new CANTalon(RobotMap.LEFT_ARM_MOTOR);
	SpeedController rightArmMotor = new CANTalon(RobotMap.RIGHT_ARM_MOTOR);
	
	Encoder encoder = new Encoder(RobotMap.LIFT_ENCODER_A, RobotMap.LIFT_ENCODER_B, false, Encoder.EncodingType.k4X);
		
	public static final double ZERO = 0.0,
			HALF = 600,
			FULL = 1200;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MoveFourBar());
    	
    }
    @SuppressWarnings("deprecation")
	public void moveFourBar(double rightJoystick) {
//    	if (encoder.getDistance() < 500) {
//    		leftArmMotor.set(rightJoystick *-1);
//			rightArmMotor.set(rightJoystick);
//    	}
//    	else {
//    		leftArmMotor.set(rightJoystick *-1);
//			rightArmMotor.set(rightJoystick);
//    	}
    	leftArmMotor.set(rightJoystick *-1);
		rightArmMotor.set(rightJoystick);
    	
    	encoder.setMaxPeriod(.1);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(5);
		encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(5);
		SmartDashboard.putDouble("Encoder Distance", encoder.getDistance());
		
	}
    
    public void setpointZero() {
    	if (encoder.getDistance() > 0) {
    		leftArmMotor.set(Math.abs((1 - encoder.getDistance())/FULL));
    		rightArmMotor.set(Math.abs((1 - encoder.getDistance())/FULL) *-1);
    	}
    	else {
    		leftArmMotor.set(0);
    		rightArmMotor.set(0);
    	}
    }
    public void setpointHalf() {
    	if (encoder.getDistance() > HALF) {
    		leftArmMotor.set((Math.abs(encoder.getDistance() - HALF)/HALF)*1.5);
    		rightArmMotor.set((Math.abs(encoder.getDistance() - HALF)/HALF)*-1.5);
    	}
    	else if (encoder.getDistance() < HALF) {
    		leftArmMotor.set((Math.abs(encoder.getDistance() - HALF)/HALF)*-1.5);
    		rightArmMotor.set((Math.abs(encoder.getDistance() - HALF)/HALF)*1.5);
    	}
    	else {
    		leftArmMotor.set(0);
    		rightArmMotor.set(0);
    	}
    }
    public void setpointFull() {
    	if (encoder.getDistance() < FULL) {
    		leftArmMotor.set((Math.abs(encoder.getDistance() - FULL)/FULL)*-1.5);
    		rightArmMotor.set((Math.abs(encoder.getDistance() - FULL)/FULL)*1.5);
    	}
    	else {
    		leftArmMotor.set(0);
    		rightArmMotor.set(0);
    	}
    }
    public void resetEncoder() {
    	encoder.reset();
    }
    
    @SuppressWarnings("deprecation")
	public void moveAuton(double speed) {		
    	encoder.setMaxPeriod(.1);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(5);
		encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(5);
    	leftArmMotor.set(speed * -1);
    	rightArmMotor.set(speed);
    	SmartDashboard.putDouble("Encoder Distance", encoder.getDistance());
    }
    	
}

