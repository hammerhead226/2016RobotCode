package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.MoveFourBar;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FourBar extends Subsystem {
	
	SpeedController leftArmMotor = new CANTalon(RobotMap.LEFT_ARM_MOTOR);
	SpeedController rightArmMotor = new CANTalon(RobotMap.RIGHT_ARM_MOTOR);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MoveFourBar());
    }
    public void moveFourBar(double rightJoystick) {
		leftArmMotor.set(rightJoystick *-1);
		rightArmMotor.set(rightJoystick);
	}

    	
}

