
package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.subsystems.DriveTrain;
import org.usfirst.frc.team226.robot.subsystems.FourBar;
import org.usfirst.frc.team226.robot.subsystems.FourBarLinkageAuto;
import org.usfirst.frc.team226.robot.subsystems.IntakeWheels;
import org.usfirst.frc.team226.robot.subsystems.CameraServo;
import org.usfirst.frc.team226.robot.subsystems.LiftWinch;
import org.usfirst.frc.team226.robot.subsystems.ShooterWheels;

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
	public static final FourBarLinkageAuto fourBarLinkageAuto = new FourBarLinkageAuto();
	public static final IntakeWheels intakeWheels = new IntakeWheels();
	public static final ShooterWheels shooterWheels = new ShooterWheels();
	public static final CameraServo cameraServo = new CameraServo();
	public static final LiftWinch liftWinch = new LiftWinch();
	public static final FourBar fourBar = new FourBar();	
	public static OI oi;

    Command autonomousCommand;
    CameraServer server;
    
    NetworkTable table;
    
    public Robot() {
    	server = CameraServer.getInstance();
        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam0");
        table = NetworkTable.getTable("SharkCV/contours/0");
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
       // autonomousCommand = new ExampleCommand();
		while(true) {
			double areas = table.getNumber("area", -1);
			double width = table.getNumber("width", -1);
			double height = table.getNumber("height", -1);
			double centerX = table.getNumber("centerX", -1);
			double centerY = table.getNumber("centerY", -1);
			SmartDashboard.putDouble("area", areas);
			SmartDashboard.putDouble("width", width);
			Timer.delay(1);
		}
		
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
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //System.out.println(cameraServo.getAngle());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
