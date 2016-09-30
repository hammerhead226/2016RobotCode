package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.AutoPop;
import org.usfirst.frc.team226.robot.commands.CameraServoToggle;
import org.usfirst.frc.team226.robot.commands.DriveWithVision;
import org.usfirst.frc.team226.robot.commands.IntakeWheelsForward;
import org.usfirst.frc.team226.robot.commands.LightSpikeToggle;
import org.usfirst.frc.team226.robot.commands.MoveFourBarEncoderReset;
import org.usfirst.frc.team226.robot.commands.MoveFourBarToSetpointFull;
import org.usfirst.frc.team226.robot.commands.MoveFourBarToSetpointHalf;
import org.usfirst.frc.team226.robot.commands.MoveFourBarToSetpointZero;
import org.usfirst.frc.team226.robot.commands.MoveWinchFullSpeed;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsBackward;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsForward;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsForwardRelease;
import org.usfirst.frc.team226.robot.commands.WinchServoToggle;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick driver = new Joystick(0);
	Joystick manip = new Joystick(1);
	public LogitechF310Controller cDriver = new LogitechF310Controller(2);

	Button D_A = new JoystickButton(driver, 1);
	Button D_B = new JoystickButton(driver, 2);
	Button D_X= new JoystickButton(driver, 3);
	Button D_LB = new JoystickButton(driver, 5);
	Button D_RB = new JoystickButton(driver, 6);
	Button D_LS = new JoystickButton(driver, 9);
	
	Button M_A = new JoystickButton(manip, 1);
	Button M_B = new JoystickButton(manip, 2);
	Button M_X = new JoystickButton(manip, 3);
	Button M_Y = new JoystickButton(manip, 4);
	Button M_LB = new JoystickButton(manip, 5);
	Button M_RB = new JoystickButton(manip, 6);
	Button M_SELECT = new JoystickButton(manip, 7);
	Button M_START = new JoystickButton(manip, 8);
	Button M_LS = new JoystickButton(manip, 9);
	Button M_RS = new JoystickButton(manip, 10);
	
	public OI() {
		D_A.whileHeld(new DriveWithVision());
		D_X.whenPressed(new LightSpikeToggle());
		D_RB.whileHeld(new MoveWinchFullSpeed());
		D_LS.whenPressed(new CameraServoToggle());
		M_A.whileHeld(new MoveFourBarToSetpointZero());
		M_B.whenPressed(new MoveFourBarEncoderReset());
		M_X.whileHeld(new MoveFourBarToSetpointHalf());
		M_Y.whileHeld(new MoveFourBarToSetpointFull());
		M_LB.whileHeld(new IntakeWheelsForward());
		M_RB.whenPressed(new ShooterWheelsForward());
		M_RB.whenReleased(new ShooterWheelsForwardRelease());
		M_SELECT.whenPressed(new AutoPop());
		M_START.whileHeld(new ShooterWheelsBackward());
		M_LS.whenReleased(new WinchServoToggle());
	}

	public void turnRumbleOn(double time) {
		driver.setRumble(RumbleType.kRightRumble, 1);
		driver.setRumble(RumbleType.kLeftRumble, 1);
		Timer.delay(time);
		driver.setRumble(RumbleType.kRightRumble, 0);
		driver.setRumble(RumbleType.kLeftRumble, 0);
	}

	public double getLeftDriveSpeed() {
		if (Math.abs(driver.getY()) > .1) {
			return driver.getY() * -1;
		} else
			return 0;
	}

	public double getRightDriveSpeed() {
		if (Math.abs(driver.getRawAxis(5)) > .1) {
			return driver.getRawAxis(5) * -1;
		} else
			return 0;
	}

	public double getLeftManipAxis() {
		if (Math.abs(manip.getY()) > .2) {
			return manip.getY() * -1;
		} else
			return 0;
	}

	public double getRightManipAxis() {
		if (Math.abs(manip.getRawAxis(5)) > .1) {
			return manip.getRawAxis(5) * -1;
		} else
			return 0;
	}
	
	public double getRightJoystick_X() {
		if (Math.abs(driver.getRawAxis(4)) > 0.2) {
			//Correct inversion -- stick left returns 1.0
			return -driver.getRawAxis(4);
		} else {
			return 0;
		}
	}
	
	/**
	 * Warning! getRightTrigger() and getLeftTrigger() both use getRawAxis(3).
	 * As getRawAxis(3) goes below zero, getRightTrigger() increases, and as
	 * getRawAxis(3) goes above zero, getLeftTrigger() increases. If both
	 * triggers are pressed, both of them will be treated as zero. You can only
	 * use one trigger at a time.
	 */

	public boolean getRightTriggerPulled() {
		if (driver.getRawAxis(3) > .5) {
			return true;
		} else {
			return false;
		}
	}

	public boolean getLeftTriggerPulled() {
		if (driver.getRawAxis(2) > .5) {
			return true;
		} else
			return false;
	}

	public boolean getRightManipTrigger() {
		if (manip.getRawAxis(3) > .5) {
			return true;
		} else {
			return false;
		}
	}
}
