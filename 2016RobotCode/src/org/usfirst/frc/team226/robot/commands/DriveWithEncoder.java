package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithEncoder extends Command {
	
	int count;
	int lSpeed;
	int rSpeed;
    public DriveWithEncoder(int count, double lSpeed, double rSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	count = this.count;
    	lSpeed = this.lSpeed;
    	rSpeed = this.rSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.driveTrain.leftEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.tankDrive(lSpeed, rSpeed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
        //return Robot.driveTrain.encoderDriveIsFinished(count);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}