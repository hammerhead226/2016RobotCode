package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.Robot;
import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.MoveWinch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftWinch extends Subsystem {

	SpeedController leftLiftMotor = new CANTalon(RobotMap.LEFT_LIFT_MOTOR);
	SpeedController rightLiftMotor = new CANTalon(RobotMap.RIGHT_LIFT_MOTOR);

	private double CONSTANT_SLOW_LIFT = 0.3;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new MoveWinch());
	}

	public void moveWinch(double leftJoystick) {
		if (leftJoystick > 0.0) {
			leftLiftMotor.set(leftJoystick);
			rightLiftMotor.set(leftJoystick);
		}

		else if (-0.85 < leftJoystick && leftJoystick < 0.0) {
			leftJoystick *= CONSTANT_SLOW_LIFT;
			leftLiftMotor.set(leftJoystick);
			rightLiftMotor.set(leftJoystick);
		}

		else {
			leftLiftMotor.set(leftJoystick);
			rightLiftMotor.set(leftJoystick);
		}
	}
}
