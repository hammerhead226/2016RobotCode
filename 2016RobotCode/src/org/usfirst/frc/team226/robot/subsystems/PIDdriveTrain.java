package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.Robot;
import org.usfirst.frc.team226.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class PIDdriveTrain extends PIDSubsystem {

	// Initialize your subsystem here
	public PIDdriveTrain() {
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		// to
		// enable() - Enables the PID controller.
		super("driveControl", 0, 0, 0);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(true);
		LiveWindow.addActuator("driveControl", "Drive PID", getPIDController());
		getPIDController().enable();
		while (true) {
			getPIDController().setSetpoint(setpoint);
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveWithJoysticks());
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		return
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
	}
}
