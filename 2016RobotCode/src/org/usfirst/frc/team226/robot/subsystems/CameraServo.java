package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.CameraServoDoNothing;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraServo extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Servo servo = new Servo(RobotMap.CAMERA_SERVO);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CameraServoDoNothing());
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

