package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftSpeed = Robot.oi.getLeftDriveSpeed();
    	double rightSpeed = Robot.oi.getRightDriveSpeed();

    	if (Robot.oi.getLeftTriggerPulled()) {
    		leftSpeed = rightSpeed * -1;
    		rightSpeed = leftSpeed * -1;
    	}
    	if (Robot.oi.getRightTriggerPulled()) {
    		leftSpeed = leftSpeed/2;
    		rightSpeed = rightSpeed/2;
    	}
    	
    	Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
