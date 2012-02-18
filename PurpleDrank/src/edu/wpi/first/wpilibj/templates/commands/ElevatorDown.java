/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.subsystems.Elevator;


/**
 * The Ball Collector should be running continously but this command is just
 * here in case we need to get it to stop. 
 *
 * @author plevinson
 */
public class ElevatorDown extends CommandBase {
    private Elevator elevator;
    
    public ElevatorDown() {
        super ("Elevator Up");
        requires (elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    /**
     * Called just before this Command runs the first time
     * turns the motor off
     */
    protected void initialize() {
        Elevator.lowerBalls();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
