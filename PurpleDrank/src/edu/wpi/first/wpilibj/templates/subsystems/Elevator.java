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


/**
 * Handles Ball collection motors
 * 
 * @author jrusso
 */
public class Elevator extends Subsystem {
    private static Relay elevatorRelay;
    // here. Call these from Commands.

    public void initDefaultCommand() {
        elevatorRelay = RobotMap.elevator;
        elevatorRelay.setDirection(Relay.Direction.kBoth);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * sets the motor to whichever direction the command calls for
     */
    public static void raiseBalls(){
        
        elevatorRelay.set(Relay.Value.kForward);
    }
    
    public static void stopRaising(){
        
        elevatorRelay.set(Relay.Value.kOff);
   }
    
    public static void lowerBalls(){
        
        elevatorRelay.set(Relay.Value.kReverse);
    }
    
    /**
     * 
     * @return Relay
     */
    public static Relay getRelay(){
        return elevatorRelay;
    }
           
}
