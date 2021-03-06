package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.Robot;
import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsDoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterWheels extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	SpeedController leftShooterMotor = new CANTalon(RobotMap.LEFT_SHOOTER_MOTOR);
	public SpeedController rightShooterMotor = new CANTalon(RobotMap.RIGHT_SHOOTER_MOTOR);
	
	//public CANTalon topEncoder = new CANTalon(RobotMap.RIGHT_SHOOTER_MOTOR);
	
//	Encoder encoder = new Encoder()
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ShooterWheelsDoNothing());
    }
    public void moveForward(){
    	leftShooterMotor.set(-1); //Bottom wheels
    	rightShooterMotor.set(1); //Top Wheels
    	
    	Robot.cameraServo.toggle = false;
    	Robot.cameraServo.reverse();
    }
    public void moveBackward(){
    	leftShooterMotor.set(1);
    	rightShooterMotor.set(-1);
    }
    public void doNotMove(){
    	leftShooterMotor.set(0);
    	rightShooterMotor.set(0);
    }
    public void moveBackIntake() {
    	leftShooterMotor.set(.25);
    	rightShooterMotor.set(-.25);
    }
}

