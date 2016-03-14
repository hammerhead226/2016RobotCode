package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.AutoPop;
import org.usfirst.frc.team226.robot.commands.CameraServoForward;
import org.usfirst.frc.team226.robot.commands.CameraServoReverse;
import org.usfirst.frc.team226.robot.commands.DriveWithVision;
import org.usfirst.frc.team226.robot.commands.IntakeWheelsForward;
import org.usfirst.frc.team226.robot.commands.MoveFourBarEncoderReset;
import org.usfirst.frc.team226.robot.commands.MoveFourBarToSetpointFull;
import org.usfirst.frc.team226.robot.commands.MoveFourBarToSetpointHalf;
import org.usfirst.frc.team226.robot.commands.MoveFourBarToSetpointZero;
import org.usfirst.frc.team226.robot.commands.MoveWinchFullSpeed;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsBackward;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsForward;
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

	Button D1 = new JoystickButton(driver, 1);
	Button D6 = new JoystickButton(driver, 6);
	Button D9 = new JoystickButton(driver, 9);
	Button D10 = new JoystickButton(driver, 10);

	Button M1 = new JoystickButton(manip, 1);
	Button M2 = new JoystickButton(manip, 2);
	Button M3 = new JoystickButton(manip, 3);
	Button M4 = new JoystickButton(manip, 4);
	Button M5 = new JoystickButton(manip, 5);
	Button M6 = new JoystickButton(manip, 6);
	Button M7 = new JoystickButton(manip, 7);
	Button M8 = new JoystickButton(manip, 8);
	Button M9 = new JoystickButton(manip, 9);
	Button M10 = new JoystickButton(manip, 10);

	public OI() {
		D1.whileHeld(new DriveWithVision());
		D6.whileHeld(new MoveWinchFullSpeed());
		D9.whenPressed(new CameraServoForward());
		D10.whenPressed(new CameraServoReverse());
		M1.whileHeld(new MoveFourBarToSetpointZero());
		M2.whenPressed(new MoveFourBarEncoderReset());
		M3.whileHeld(new MoveFourBarToSetpointHalf());
		M4.whileHeld(new MoveFourBarToSetpointFull());
		M5.whileHeld(new IntakeWheelsForward(.5));
		M6.whileHeld(new ShooterWheelsForward(.5));
		M7.whenPressed(new AutoPop());
		M8.whileHeld(new ShooterWheelsBackward(.5));
		M9.whenPressed(new WinchServoToggle());
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
