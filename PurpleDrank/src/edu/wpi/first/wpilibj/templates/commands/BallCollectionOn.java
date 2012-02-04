/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.subsystems.BallCollector;
/**
 *
 * @author Rachel and Jenny who are awesome
 */
public class BallCollectionOn extends CommandBase {
    private BallCollector ballCollection;
    
    public BallCollectionOn() {
        super("Ball Collect On");
        requires(ballCollection);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    /**
     * Called just before this Command runs the first time
     * sets the Motor direction to forward to pick up balls
     */
    protected void initialize() {
        BallCollector.getRelay().setDirection(Relay.Direction.kForward);
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     * motor keeps running
     */
    protected void execute() {
        ballCollection.collect();
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