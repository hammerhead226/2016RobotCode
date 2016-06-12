package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.IntakeWheelsDoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeWheels extends Subsystem {
    
	SpeedController intakeMotor = new CANTalon(RobotMap.INTAKE_MOTOR);
	
	public boolean shoot = true;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeWheelsDoNothing());
    }
    public void moveForward(){
    	intakeMotor.set(-1);
    	shoot = false;
    }
    public void moveBackward(){
    	intakeMotor.set(1);
    }
    public void doNotMove(){
    	intakeMotor.set(0);
    	shoot = true;
    }
}

