
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
    
    CANTalon rearLeft = new CANTalon(6);
//	CANTalon rearRight = new CANTalon(RobotMap.REAR_RIGHT_DRIVE);
//	CANTalon frontLeft = new CANTalon(RobotMap.FRONT_LEFT_DRIVE);
//	CANTalon frontRight = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);	
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
		
		/* first choose the sensor */
        rearLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        rearLeft.reverseSensor(false);

        /* set the peak and nominal outputs, 12V means full */
        rearLeft.configNominalOutputVoltage(+0.0f, -0.0f);
        rearLeft.configPeakOutputVoltage(+12.0f, 0.0f);
        /* set closed loop gains in slot0 */
        rearLeft.setProfile(0);
        rearLeft.setF(0.1097);
        rearLeft.setP(0.22);
        rearLeft.setI(0); 
        rearLeft.setD(0);
				
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        count.start();
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
        	System.out.print(rearLeft.getEncVelocity());
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
