/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.subsystems.RampController;

/**
 *
 * @author plevinson
 */
public class ArmDown extends CommandBase {
    private RampController Ramp;
    
    public ArmDown() {
        super("Arm Down");
        requires(Ramp);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        RampController.getRelay1().setDirection(Relay.Direction.kForward); 

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Ramp.push();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
