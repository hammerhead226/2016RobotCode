package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	SpeedController rearRightMotor = new CANTalon(RobotMap.REAR_RIGHT_DRIVE);
	SpeedController frontRightMotor = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);
	SpeedController rearLeftMotor = new CANTalon(RobotMap.REAR_LEFT_DRIVE);
	SpeedController frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_DRIVE);

	//public Encoder leftEncoder = new Encoder(RobotMap.LEFT_DT_ENCODER_CH1, RobotMap.LEFT_DT_ENCODER_CH2, false,
	//		EncodingType.k4X);
	//public Encoder rightEncoder = new Encoder(RobotMap.RIGHT_DT_ENCODER_CH1, RobotMap.RIGHT_DT_ENCODER_CH2, true,
	//		EncodingType.k4X);

	RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveWithJoysticks());
	}

	public void tankDrive(double leftJoystick, double rightJoystick) {
		drive.tankDrive(leftJoystick, rightJoystick);
	}

	/*public boolean encoderDriveIsFinished(int count) {
		int avg = (leftEncoder.get() + rightEncoder.get()) / 2;
		if (avg < count) {
			return false;
		}
		else {
			return true;
		} 
	} */
	
	public void visionDrive(double centerValue) {
		double left = ((centerValue-160)/160);
		double right = ((centerValue-160)/160)/-1;
		
		if (left > 0.5) {
			left = 0.5;
		}
		else if (left < -0.5) {
			left = -0.5;
		}
		
		if (right > 0.5) {
			right = 0.5;
		}
		else if (right < -0.5) {
			right = -0.5;
		}

		drive.tankDrive(left, right);
//		SmartDashboard.putDouble("centervision", );
	}
}
