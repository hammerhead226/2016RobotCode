package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.LightSpikeDoNothing;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LightSpike extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Relay spike = new Relay(RobotMap.LIGHT_SPIKE);
	public boolean toggle = false;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LightSpikeDoNothing()); 
    }
    
    public void turnLightOn() {
    	spike.set(Relay.Value.kForward);
    }
    public void turnLightOff() {
    	spike.set(Relay.Value.kOff);
    }
    public void doNothing() {
    	spike.set(spike.get());
    }
}

