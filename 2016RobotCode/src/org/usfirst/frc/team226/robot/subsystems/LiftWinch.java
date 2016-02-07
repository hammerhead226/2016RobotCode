package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.LiftWinchDoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftWinch extends Subsystem {
    
	SpeedController leftLiftMotor = new CANTalon(RobotMap.LEFT_LIFT_MOTOR);
	SpeedController rightLiftMotor = new CANTalon(RobotMap.RIGHT_LIFT_MOTOR);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LiftWinchDoNothing());
    }
    public void doNotMove(){
    	leftLiftMotor.set(0);
    	rightLiftMotor.set(0);
    }
    public void retractWinch(){
    	leftLiftMotor.set(-1);
    	rightLiftMotor.set(1);
    }
    
}

