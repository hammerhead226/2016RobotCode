package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class XboxCheesyDrive extends Command {

    public XboxCheesyDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double throttle = Robot.oi.getLeftDriveSpeed();
    	double turn = Robot.oi.getRightJoystick_X();
    	
    	if (Robot.oi.getRightTriggerPulled()) {
    		throttle *= 0.5;
    		turn *= 0.7;
    	}
    	if (Robot.oi.getLeftTriggerPulled()) {
    		throttle *= -1;
    	}
    	
    	Robot.driveTrain.arcadeDrive(throttle, turn, true);
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
