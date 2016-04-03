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
	
	public double leftSpeed, rightSpeed;
	public boolean leftDone = false;
	public boolean rightDone = false;
	public double lCount = 0;
	public double rCount = 0;
	public boolean set = true;
	
	public CANTalon rearLeft = new CANTalon(RobotMap.LEFT_ENCODER);
    public CANTalon rearRight = new CANTalon(RobotMap.RIGHT_ENCODER);
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveWithJoysticks());
	}
	
	public void tankDrive(double leftJoystick, double rightJoystick) {
		drive.tankDrive(leftJoystick, rightJoystick);
	}

	public void encoderDrive(double leftCount, double rightCount, double lSpeed, double rSpeed, boolean set) {
//		int avg = (Robot.leftDriveEncoderDistance + rearRight.getEncPosition()) / 2;
//		SmartDashboard.putInt("avg", avg);
//		System.out.println(avg);
//		if (avg < count) {
//			drive.tankDrive(lSpeed, rSpeed);
//		}
//		else {
//			drive.tankDrive(0, 0);
//		} 
		leftSpeed = lSpeed;
		rightSpeed = rSpeed;
		
		if (this.set) {
			lCount = (rearLeft.get()*-1) + leftCount;
			rCount = rightCount + rearRight.get();
			this.set = false;
		}
		
		
		if (lCount <= rearLeft.get() *-1) {
			leftSpeed = 0;
			leftDone = true;
		}
		if (rCount <= rearRight.get()) {
			rightSpeed = 0;
			rightDone = true;
		}
//		if (reset) {
//			rearLeft.reset();
//			rearRight.reset();
//			rearLeft.set(0);
//			rearRight.set(0);
//			
//		}
		drive.tankDrive(leftSpeed, rightSpeed);
		
		
	}
	
	public boolean encoderDriveIsFinished() {
		if ((leftDone == true) && (rightDone == true)) {
			leftDone = false;
			rightDone = false;
			this.set = true;
			return true;
			
		}
		else {
			return false;
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
