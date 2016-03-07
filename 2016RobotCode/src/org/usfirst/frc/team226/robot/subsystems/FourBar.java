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
			HALF = 1200,
			FULL = 2000;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MoveFourBar());
    }
    @SuppressWarnings("deprecation")
	public void moveFourBar(double rightJoystick) {
    	if (encoder.getDistance() < 500) {
    		leftArmMotor.set(rightJoystick *-2);
			rightArmMotor.set(rightJoystick/2);
    	}
    	else {
    		leftArmMotor.set(rightJoystick *-1);
			rightArmMotor.set(rightJoystick);
    	}
		
		encoder.setMaxPeriod(.1);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(5);
		encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(5);
		
		//Max Distance is 1271.25
		SmartDashboard.putDouble("Encoder Distance", encoder.getDistance());
	}
    
    public void setpointZero() {
    	if (encoder.getDistance() > 0) {
    		leftArmMotor.set(Math.abs((1 - encoder.getDistance())/FULL)/2);
    		rightArmMotor.set(Math.abs((1 - encoder.getDistance())/FULL) *-2);
    	}
    	else {
    		leftArmMotor.set(0);
    		rightArmMotor.set(0);
    	}
    }
    public void setpointHalf() {
    	if (encoder.getDistance() > HALF) {
    		leftArmMotor.set((Math.abs(encoder.getDistance() - HALF)/HALF));
    		rightArmMotor.set((Math.abs(encoder.getDistance() - HALF)/HALF)*-1);
    	}
    	else if (encoder.getDistance() < HALF) {
    		leftArmMotor.set((Math.abs(encoder.getDistance() - HALF)/HALF)*-1);
    		rightArmMotor.set((Math.abs(encoder.getDistance() - HALF)/HALF));
    	}
    	else {
    		leftArmMotor.set(0);
    		rightArmMotor.set(0);
    	}
    }
    public void setpointFull() {
    	if (encoder.getDistance() < FULL) {
    		leftArmMotor.set((Math.abs(encoder.getDistance() - FULL)/FULL)*-1);
    		rightArmMotor.set((Math.abs(encoder.getDistance() - FULL)/FULL));
    	}
    	else {
    		leftArmMotor.set(0);
    		rightArmMotor.set(0);
    	}
    }
    public void resetEncoder() {
    	encoder.reset();
    }
    	
}

