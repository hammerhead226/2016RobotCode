package org.usfirst.frc.team226.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton extends CommandGroup {

	public Auton() {
		// addSequential(new DriveWithEncoder((Robot.leftDriveEncoderDistance +
		// 10), (Robot.rightDriveEncoderDistance +10), .75, .75, true));
		addSequential(new DriveWithEncoder(1, 1, .75, .75));

		// addSequential(new DriveWithEncoder(10, .75, .75, true));

		// if (SmartDashboard.getBoolean("Auton Shoot")){

		addSequential(new CameraServoAuton());
//		addParallel(new IntakeWheelsForward(1));
		addParallel(new MoveFourBarAuton(1.5, -.4));
		addSequential(new DriveWithEncoder(7, 7, .70, .65));
		addSequential(new MoveFourBarEncoderReset());

		addSequential(new DriveWithEncoder(1.85, 0, 1, .1));
		addSequential(new DriveWithEncoder(.5, .5, .75, .75));
//		addSequential(new DriveWithAuton(.1, 0, 0));
//		addSequential(new DriveWithAuton(.5, .5, .5));
		// AutoPop
//				addSequential(new ShooterWheelsBackward(.25));
//				addSequential(new IntakeWheelsBackward(.20));
//				addSequential(new IntakeWheelsDoNothing());
//				addSequential(new ShooterWheelsDoNothing());
		
		/* Shooting
		 * 
		addSequential(new MoveFourBarAuton(.75, .75));
		 addParallel(new MoveFourBarAuton(4, .3));
		 addSequential(new ShooterWheelsForward(4));
		 addSequential(new IntakeWheelsForward(2));
		 addSequential(new IntakeWheelsDoNothing());
		 addSequential(new ShooterWheelsDoNothing());
		*/
		
		// addSequential(new DriveWithEncoder(100, .5, .5));

		// addSequential(new DriveWithAuton(1.8, .75, -.75)); 90 Degree turn

		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
	}
}
