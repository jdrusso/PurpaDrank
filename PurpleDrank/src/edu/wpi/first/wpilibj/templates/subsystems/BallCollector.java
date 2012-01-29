/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * Handles Ball collection motors
 * 
 * @author jrusso
 */
public class BallCollector extends Subsystem {
    private Jaguar ballCollectJag;
    // here. Call these from Commands.
    
    public BallCollector(){
        ballCollectJag= new Jaguar(RobotMap.ballCollectMotor);
    }
    public void ballCollectorOn(){
        ballCollectJag.set(1);//full foward can be switced to full back
        
    }
    public void ballCollectorOff(){
        ballCollectJag.set(0);
        
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
