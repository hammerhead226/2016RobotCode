package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.CameraServoToggle;
import org.usfirst.frc.team226.robot.commands.DriveWithVision;
import org.usfirst.frc.team226.robot.commands.IntakeWheelsBackward;
import org.usfirst.frc.team226.robot.commands.IntakeWheelsBackwardRelease;
import org.usfirst.frc.team226.robot.commands.IntakeWheelsForward;
import org.usfirst.frc.team226.robot.commands.LightSpikeToggle;
import org.usfirst.frc.team226.robot.commands.MoveFourBarEncoderReset;
import org.usfirst.frc.team226.robot.commands.MoveFourBarToSetpointFull;
import org.usfirst.frc.team226.robot.commands.MoveFourBarToSetpointHalf;
import org.usfirst.frc.team226.robot.commands.MoveFourBarToSetpointZero;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsBackward;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsForward;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsForwardRelease;
import org.usfirst.frc.team226.robot.commands.WinchServoToggle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public Controller driver = new Controller(0);
	public Controller manip = new Controller(1);

	public OI() {
		driver.getAButton().whileHeld(new DriveWithVision());
		driver.getXButton().whenPressed(new LightSpikeToggle());
		driver.getLSButton().whenPressed(new CameraServoToggle());
//		manip.getAButton().whileHeld(new MoveFourBarToSetpointZero());
//		manip.getBButton().whenPressed(new MoveFourBarEncoderReset());
//		manip.getXButton().whileHeld(new MoveFourBarToSetpointHalf());
//		manip.getYButton().whileHeld(new MoveFourBarToSetpointFull());
		
//		manip.getLBButton().whileHeld(new IntakeWheelsForward());
		driver.getLBButton().whileHeld(new IntakeWheelsForward());
		
//		manip.getRBButton().whenPressed(new ShooterWheelsForward());
		driver.getRBButton().whenPressed(new ShooterWheelsForward());

//		manip.getRBButton().whenReleased(new ShooterWheelsForwardRelease());
		driver.getRBButton().whenReleased(new ShooterWheelsForwardRelease());

//		manip.getBACKButton().whenPressed(new IntakeWheelsBackward());
		driver.getBACKButton().whenPressed(new IntakeWheelsBackward());
		
//		manip.getBACKButton().whenReleased(new IntakeWheelsBackwardRelease());
		driver.getBACKButton().whenReleased(new IntakeWheelsBackwardRelease());
		
//		manip.getSTARTButton().whileHeld(new ShooterWheelsBackward());
		driver.getSTARTButton().whileHeld(new ShooterWheelsBackward());

//		manip.getLSButton().whenReleased(new WinchServoToggle());
		driver.getLSButton().whenReleased(new WinchServoToggle());

		
	}
}
