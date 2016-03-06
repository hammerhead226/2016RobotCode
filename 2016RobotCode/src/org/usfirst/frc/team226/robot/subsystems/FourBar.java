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
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MoveFourBar());
    }
    @SuppressWarnings("deprecation")
	public void moveFourBar(double rightJoystick) {
		leftArmMotor.set(rightJoystick *-1);
		rightArmMotor.set(rightJoystick);
		
		encoder.setMaxPeriod(.1);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(5);
		encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(7);
		
		//Max Distance is 1271.25
		SmartDashboard.putDouble("Encoder Distance", encoder.getDistance());
	}

    	
}

