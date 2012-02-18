/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.subsystems.RampController;

/**
 *This class controls the robot arm, designed to push the ramp down.
 * 
 * @author plevinson
 */
public class ArmDown extends CommandBase {
    private RampController Ramp;
    
    /*
     * Constructor to make the arm push the ramp down.
     */
    public ArmDown() {
        super("Arm Down");
        requires(Ramp);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    /*
     * This is called right before the command is run.
     * It sets the motor direction to forward.
     */
    protected void initialize() {
        RampController.setDir(); 
        RampController.getArmRelay().set(Relay.Value.kForward);
    }

    /*
     * This is the actual action of the arm pushing the ramp down. 
     * It will run until told to stop by button4 being double pressed (I think).We haven't decided yet. 
     */
    protected void execute() {
        //Ramp.push();
    }

    /*
     *Once button4 is double pressed, this will change to false and stop the execute method. 
     * 
     * @return true to stop command, false to countinue execute()
     */
    protected boolean isFinished() {
        return false;
    }

    //Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
