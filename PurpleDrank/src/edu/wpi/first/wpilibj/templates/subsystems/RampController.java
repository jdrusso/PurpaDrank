/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ArmUp;

/**
 * 
 * Handles motors for ramp controller and joystick input
 *
 * @author jrusso
 */
public class RampController extends Subsystem {
    private static Relay armRelay = RobotMap.armSpike;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {    
        //Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());   
        //setDefaultCommand(new ArmUp());
        setDir();
    }  
    
    /*
     * moves the motor in a certain direction, determined by command.
     */
    public static void setDir() {
        armRelay.setDirection(Relay.Direction.kBoth); 
    }
    
    public static Relay getArmRelay() {
       return armRelay; 
    }
}