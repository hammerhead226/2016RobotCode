package org.usfirst.frc.team226.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick driver = new Joystick(0);
	//Joystick manip = new Joystick(1);
	//Button M1 = new JoystickButton(manip, 1);
	//Button M2 = new JoystickButton(manip, 2);
	//Button M3 = new JoystickButton(manip, 3);
	//Button M4 = new JoystickButton(manip, 4);
	
	
	public double getLeftDriveSpeed() {
		return driver.getY();
	}
	
	public double getRightDriveSpeed() {
		return driver.getRawAxis(5)*-1;
	}
	
}

