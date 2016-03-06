package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.CameraServoForward;
import org.usfirst.frc.team226.robot.commands.CameraServoReverse;
import org.usfirst.frc.team226.robot.commands.DriveWithVision;
import org.usfirst.frc.team226.robot.commands.IntakeWheelsBackward;
import org.usfirst.frc.team226.robot.commands.IntakeWheelsForward;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsBackward;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsForward;
import org.usfirst.frc.team226.robot.commands.WinchServoForward;
import org.usfirst.frc.team226.robot.commands.WinchServoReverse;

import edu.wpi.first.wpilibj.Joystick;
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
		D9.whenPressed(new CameraServoForward());
		D10.whenPressed(new CameraServoReverse());
		//M1.whenPressed(new SetFourBarLinkageSetpoint(FourBarLinkageAuto.ZERO));
		//M2.whenPressed(new SetFourBarLinkageSetpoint(FourBarLinkageAuto.HALF));
		//M3.whenPressed(new SetFourBarLinkageSetpoint(FourBarLinkageAuto.FULL));
		//M4.whenPressed(new SetFourBarLinkageSetpoint(FourBarLinkageAuto.EXTENDED));
		M5.whileHeld(new IntakeWheelsForward());
		M6.whileHeld(new ShooterWheelsForward());
		M7.whileHeld(new IntakeWheelsBackward());
		M8.whileHeld(new ShooterWheelsBackward());	
		M9.whenPressed(new WinchServoForward());
		M10.whenPressed(new WinchServoReverse());
	}
	
	public double getLeftDriveSpeed() {
		if (Math.abs(driver.getY()) > .1 ){
			return driver.getY()*-1;
		}else return 0;
	}
	
	public double getRightDriveSpeed() {
		if (Math.abs(driver.getRawAxis(5)) > .1) {
			return driver.getRawAxis(5)*-1;
		}else return 0;
	}
	
	public double getLeftManipAxis() {
		if (Math.abs(manip.getY()) > .2) {
			return manip.getY()*-1;
		}else return 0;
	}
	
	public double getRightManipAxis() {
		if (Math.abs(manip.getRawAxis(5)) > .1){
			return manip.getRawAxis(5)*-1;
		}else return 0;
	}
	
	public boolean getLeftTriggerPulled() {
		if (Math.abs(manip.getRawAxis(3)) > .5) {
			return true;
		}else return false;
	}
	
	public boolean getRightTriggerPulled() {
		if (manip.getRawAxis(3) < -.5) {
			return true;
		}else return false;
	}
	
	/*public double getRightManipAxis() {
		if (Math.abs(manip.getRawAxis(5)) > .1) 
			return (manip.getRawAxis(5) *-1) + Robot.fourBarLinkageAuto.getSetpoint();
		else return Robot.fourBarLinkageAuto.getSetpoint();
	}*/
	
}

