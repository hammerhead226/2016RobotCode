package org.usfirst.frc.team226.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton extends CommandGroup {
    
    public  Auton() {
    	addSequential(new DriveWithAuton(4, .75, .75));
    	addParallel(new MoveFourBarAuton(3, -.25));
    	addSequential(new MoveFourBarEncoderReset());
    	addSequential(new DriveWithAuton(.9, .75, -.75));
    	addParallel(new MoveFourBarToSetpointHalf());
    	addParallel(new AutoPop());
    	//addSequential(new DriveWithVision());
    	addSequential(new ShooterWheelsForward(5));
    	addSequential(new IntakeWheelsForward(2));
    	addSequential(new IntakeWheelsDoNothing());
    	addSequential(new ShooterWheelsDoNothing());
    	
    	
    	//addSequential(new DriveWithEncoder(100, .5, .5));
    	
    	//addSequential(new DriveWithAuton(2, .75, -.75));  90 Degree turn
    	
    	
//    	addSequential(new DriveWithEncoder(500, .25, .25));
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
