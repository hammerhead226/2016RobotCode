package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Auton extends CommandGroup {
    
    public  Auton() {
    	//if (SmartDashboard.getBoolean("Auton Shoot")){
    	addSequential(new DriveWithAuton(.5, .75, .75));
    	addParallel(new IntakeWheelsForward(1));
    	addParallel(new MoveFourBarAuton(2, -.25));
    	addSequential(new DriveWithAuton(2.8, .75, .75));
    	addSequential(new MoveFourBarEncoderReset());
    	
//    	AutoPop
    		addSequential(new ShooterWheelsBackward(.25));
    		addSequential(new IntakeWheelsBackward(.25));
    		addSequential(new IntakeWheelsDoNothing());
    		addSequential(new ShooterWheelsDoNothing());
    	addParallel(new ShooterWheelsForwardAuton());
    	addSequential(new DriveWithAuton(1.15, .75, -.75));
    	addSequential(new DriveWithAuton(.1, 0, 0));
    	addSequential(new DriveWithAuton(.5, .5, .5));
    	addSequential(new MoveFourBarAuton(1, .75));
    	addParallel(new MoveFourBarAuton(2, .3));
    	addSequential(new IntakeWheelsForward(2));
    	addSequential(new IntakeWheelsDoNothing());
    	addSequential(new ShooterWheelsDoNothing());
    	
//    	else {
//    		addSequential(new DriveWithAuton(.5, .75, .75));
//        	addParallel(new MoveFourBarAuton(2, -.25));
//        	addSequential(new DriveWithAuton(3.5, .75, .75));
//        	addSequential(new MoveFourBarEncoderReset());
//        	addSequential(new MoveFourBarAuton(.1, 0));
//        	addSequential(new DriveWithAuton(.9, .75, -.75));
//        	addSequential(new DriveWithAuton(.1, 0, 0));
//    	}
    	
    	
    	//addSequential(new DriveWithEncoder(100, .5, .5));
    	
    	//addSequential(new DriveWithAuton(1.8, .75, -.75));  90 Degree turn
    	
//    	while (!Robot.driveTrain.isAlignedLeft || !Robot.driveTrain.isAlignedRight) {
//    		Robot.driveTrain.visionDrive(Robot.centerValue);
//    		Timer.delay(.5);
//    	}
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
