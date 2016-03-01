package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.ServoDoNothing;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraServo extends Subsystem {
    
	Servo servo = new Servo(RobotMap.SERVO);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ServoDoNothing());
    }
    public void doNothing() {
    	servo.setAngle(servo.getAngle());
    }
    public void forward(){
    	servo.setAngle(180);
    }
    public void reverse() {
    	servo.setAngle(0);
    }
    public double getAngle() {
    	return servo.getAngle();
    }
}

