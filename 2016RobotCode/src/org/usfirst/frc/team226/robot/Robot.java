
package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.Auton;
import org.usfirst.frc.team226.robot.subsystems.CameraServo;
import org.usfirst.frc.team226.robot.subsystems.DriveTrain;
import org.usfirst.frc.team226.robot.subsystems.FourBar;
import org.usfirst.frc.team226.robot.subsystems.IntakeWheels;
import org.usfirst.frc.team226.robot.subsystems.LiftWinch;
import org.usfirst.frc.team226.robot.subsystems.LightSpike;
import org.usfirst.frc.team226.robot.subsystems.ShooterWheels;
import org.usfirst.frc.team226.robot.subsystems.WinchServo;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final IntakeWheels intakeWheels = new IntakeWheels();
	public static final ShooterWheels shooterWheels = new ShooterWheels();
	public static final WinchServo winchServo = new WinchServo();
	public static final LiftWinch liftWinch = new LiftWinch();
	public static final FourBar fourBar = new FourBar();	
	public static final CameraServo cameraServo = new CameraServo();
	public static final LightSpike lightSpike = new LightSpike();
	public static OI oi;

    Command autonomousCommand;
    CameraServer server;
    public static Timer count;
    
    NetworkTable table;
    public static double centerValue;
    
    public static double liftSetPointValue;
    
    public static double liftEncPos;	
    
    public static boolean activateSetpoint = false;
    
    CANTalon rearLeft = new CANTalon(2);
    CANTalon rearRight = new CANTalon(6);
    public static double leftDriveEncoderDistance;
    public static double rightDriveEncoderDistance;
    int loops = 0;
    
    public Robot() {
    	server = CameraServer.getInstance();
        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam0");

        table = NetworkTable.getTable("SharkCV/contours/0");  
        
        count = new Timer();
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
       // autonomousCommand = new ExampleCommand();
		autonomousCommand = new Auton();
		count.start();
		
        rearLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        rearLeft.changeControlMode(TalonControlMode.Position);
        rearLeft.reverseSensor(true);
        rearLeft.configNominalOutputVoltage(+0.0f, -0.0f);
        rearLeft.configPeakOutputVoltage(+12.0f, 0.0f);
        rearLeft.setProfile(0);
        rearLeft.setF(0);
        rearLeft.setP(0);
        rearLeft.setI(0); 
        rearLeft.setD(0);
        
        rearRight.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        rearRight.changeControlMode(TalonControlMode.Position);
        rearRight.reverseSensor(true);
        rearRight.configNominalOutputVoltage(+0.0f, -0.0f);
        rearRight.configPeakOutputVoltage(+12.0f, 0.0f);
        rearRight.setProfile(0);
        rearRight.setF(0);
        rearRight.setP(0);
        rearRight.setI(0); 
        rearRight.setD(0);
				
        rearLeft.reset();
        rearRight.reset();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	rearLeft.reset();
        rearRight.reset();
        rearLeft.set(0);
        rearRight.set(0);
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        if(loops >= 5) {
        	loops = 0;
        	System.out.print("Left : " + rearLeft.get()*-1);
        	System.out.print("Right : " + rearRight.get());
        	leftDriveEncoderDistance = rearLeft.get()*-1;
        	rightDriveEncoderDistance = rearRight.get();
        }
        else loops++;
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        count.start();
        rearLeft.reset();
        rearRight.reset();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	count.reset();
    	count.stop();
    }

    /**
     * This function is called periodically during operator control
     */
    @SuppressWarnings("deprecation")
	public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        centerValue = table.getNumber("centerX",-1);
        SmartDashboard.putDouble("Center", centerValue);
        SmartDashboard.putDouble("Timer", count.get());
        
        if(loops >= 10) {
        	loops = 0;
        	System.out.print("Left : " + rearLeft.get() + "\n");
        	System.out.print("Right : " + rearRight.get() + "\n");
        	leftDriveEncoderDistance = rearLeft.get();
        	rightDriveEncoderDistance = rearRight.get();
        }
        else loops++;
        

    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
