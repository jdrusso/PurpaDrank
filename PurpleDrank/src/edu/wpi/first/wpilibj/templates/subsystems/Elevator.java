/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * Handles Ball collection motors
 * 
 * @author jrusso
 */
public class BallCollector extends Subsystem {
    private static Relay ballRelay;
    // here. Call these from Commands.

    public void initDefaultCommand() {
        ballRelay = new Relay(1);
        ballRelay.setDirection(Relay.Direction.kBoth);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * sets the motor to whichever direction the command calls for
     */
//    public void collect(){
//        
//        ballRelay.set(Relay.Value.kForward);
//    }
//    
//    public void stopCollect(){
//        
//        ballRelay.set(Relay.Value.kOff);
//    }
    
    
    
    /**
     * 
     * @return Relay
     */
    public static Relay getRelay(){
        return ballRelay;
    }
           
}
