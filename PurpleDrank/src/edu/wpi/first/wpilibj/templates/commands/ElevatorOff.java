/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.subsystems.BallCollector;
import edu.wpi.first.wpilibj.templates.subsystems.Elevator;


/**
 * The Ball Collector should be running continously but this command is just
 * here in case we need to get it to stop. 
 *
 * @author plevinson
 */
public class ElevatorOff extends CommandBase {
    private Elevator elevator;
    
    public ElevatorOff() {
        super("Elevator Off");
        elevator = PurpleDrank.getElevator();
        requires(elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    /**
     * Called just before this Command runs the first time
     * turns the motor off
     */
    protected void initialize() {
        Elevator.stopRaising();
        // also turn off the ball collector motor if it is spitting out.
        //if (BallCollector.isSpitting())
        //    BallCollector.stopSucking();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
