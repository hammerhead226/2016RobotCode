package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;
import org.usfirst.frc.team226.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeWheelsForward extends Command {

	public IntakeWheelsForward(/* double timeOut */) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.intakeWheels);
		// setTimeout(timeOut);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
				Robot.intakeWheels.moveForward();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.intakeWheels.doNotMove();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
