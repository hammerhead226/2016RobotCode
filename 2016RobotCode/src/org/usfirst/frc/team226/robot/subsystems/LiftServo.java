package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.LiftServoDoNothing;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftServo extends Subsystem {
    
	Servo servo = new Servo(RobotMap.SERVO);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LiftServoDoNothing());
    }
    public void doNotMove(){
    	servo.set(0);
    }
    public void open(){
    	servo.set(1);
    }
}

