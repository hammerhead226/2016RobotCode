package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithEncoder extends Command {
	
	double leftCount, rightCount;
	double lSpeed;
	double rSpeed;
	boolean reset;
    public DriveWithEncoder(double leftCount, double rightCount, double lSpeed, double rSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	this.leftCount = leftCount; 
    	this.rightCount = rightCount;
    	this.lSpeed = lSpeed;
    	this.rSpeed = rSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.encoderDrive(leftCount, rightCount, lSpeed, rSpeed, reset);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.driveTrain.encoderDriveIsFinished();
    }
    

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
