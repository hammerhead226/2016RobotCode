package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.Robot;
import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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

	RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

	public boolean isAlignedLeft, isAlignedRight;
	
	CANTalon rearLeft = new CANTalon(RobotMap.REAR_LEFT_DRIVE);
	CANTalon rearRight = new CANTalon(RobotMap.REAR_RIGHT_DRIVE);
	CANTalon frontLeft = new CANTalon(RobotMap.FRONT_LEFT_DRIVE);
	CANTalon frontRight = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveWithJoysticks());
	}

	public DriveTrain() {
		//Master Talons
		rearLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		rearRight.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		rearLeft.changeControlMode(TalonControlMode.Position);
		rearRight.changeControlMode(TalonControlMode.Position);
		//Slave Talons
		frontRight.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		frontLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		frontRight.changeControlMode(TalonControlMode.Follower);
		frontLeft.changeControlMode(TalonControlMode.Follower);
		frontRight.set(rearRight.getDeviceID());
		frontLeft.set(rearLeft.getDeviceID());	
		
		rearLeft.enable();
		rearRight.enable();
		frontLeft.enable();
		frontRight.enable();
	}
	
	public void tankDrive(double leftJoystick, double rightJoystick) {
		drive.tankDrive(leftJoystick, rightJoystick);
	}

	@SuppressWarnings("deprecation")
	public void encoderDrive(double count, double lSpeed, double rSpeed) {
		int avg = (rearLeft.getEncPosition() + rearRight.getEncPosition()) / 2;
		SmartDashboard.putInt("avg", avg);
		System.out.println(avg);
		if (avg < count) {
			drive.tankDrive(lSpeed, rSpeed);
		}
		else {
			drive.tankDrive(0, 0);
		} 
	}
	
	public boolean encoderDriveIsFinished(int count) {
		int avg = (rearLeft.getEncPosition() + rearRight.getEncPosition()) / 2;
		if (avg < count) {
			return false;
		}
		else {
			return true;
		} 
	}
	
	public void autonDrive(double leftSpeed, double rightSpeed) {
		drive.tankDrive(leftSpeed, rightSpeed);
	}
	
	public void visionDrive(double centerValue) {
		double left = ((centerValue-130)/130);
		double right = ((centerValue-130)/130)*-1;
		
		if (left > .1) {
			left = .55;
			isAlignedLeft = false;
		}
		else if (left < -.1) {
			left = -.55;
			isAlignedLeft = false;
		}
		else {
			isAlignedLeft = true;
		}

		if (right > .1) {
			right = .55;
			isAlignedRight = false;
		}
		else if (right < -.1) {
			right = -.55;
			isAlignedRight = false;
		}
		else {
			isAlignedRight = true;
		}
		
		if (isAlignedRight && isAlignedLeft) {
			Robot.oi.turnRumbleOn(1);
		}

		drive.tankDrive(left, right);
		
	}
}
