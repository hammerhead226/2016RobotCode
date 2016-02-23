package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.IntakeWheelsBackward;
import org.usfirst.frc.team226.robot.commands.IntakeWheelsForward;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsBackward;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsForward;

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
	Button M1 = new JoystickButton(manip, 1);
	Button M2 = new JoystickButton(manip, 2);
	Button M3 = new JoystickButton(manip, 3);
	Button M4 = new JoystickButton(manip, 4);
	Button M5 = new JoystickButton(manip, 5);
	Button M6 = new JoystickButton(manip, 6);
	Button M7 = new JoystickButton(manip, 7);
	Button M8 = new JoystickButton(manip, 8);
	
	public OI() {
		//M1.whenPressed(new SetFourBarLinkageSetpoint(FourBarLinkageAuto.ZERO));
		//M2.whenPressed(new SetFourBarLinkageSetpoint(FourBarLinkageAuto.HALF));
		//M3.whenPressed(new SetFourBarLinkageSetpoint(FourBarLinkageAuto.FULL));
		//M4.whenPressed(new SetFourBarLinkageSetpoint(FourBarLinkageAuto.EXTENDED));
		M5.whileHeld(new IntakeWheelsForward());
		M6.whileHeld(new ShooterWheelsForward());
		M7.whileHeld(new IntakeWheelsBackward());
		M8.whileHeld(new ShooterWheelsBackward());
	}
	
	public double getLeftDriveSpeed() {
		return driver.getY()*-1;
	}
	
	public double getRightDriveSpeed() {
		return driver.getRawAxis(5)*-1;
	}
	
	public double getLeftManipAxis() {
		return manip.getY()*-1;
	}
	
	public double getRightManipAxis() {
		return manip.getRawAxis(5) *-1;
	}
	
	/*public double getRightManipAxis() {
		if (Math.abs(manip.getRawAxis(5)) > .1) 
			return (manip.getRawAxis(5) *-1) + Robot.fourBarLinkageAuto.getSetpoint();
		else return Robot.fourBarLinkageAuto.getSetpoint();
	}*/
	
}

