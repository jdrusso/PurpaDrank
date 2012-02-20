/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.subsystems.BallCollector;


/**
 * The Ball Collector should be running continously but this command is just
 * here in case we need to get it to stop. 
 *
 * @author plevinson
 */
public class BallCollectionOff extends CommandBase {
    private BallCollector ballCollection;
    
    public BallCollectionOff() {
        super ("Ball Collect Off");
        ballCollection = PurpleDrank.getBallCollector();
        requires (ballCollection);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    /**
     * Called just before this Command runs the first time
     * turns the motor off
     */
    protected void initialize() {
        BallCollector.stopSucking();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return false;
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
