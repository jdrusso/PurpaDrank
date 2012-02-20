/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.Elevator;
import edu.wpi.first.wpilibj.Timer;


/**
 * The Ball Collector should be running continously but this command is just
 * here in case we need to get it to stop. 
 *
 * @author plevinson
 */
public class ElevatorUp extends CommandBase {
    private Elevator elevator;
    private Timer timer;
    
    public ElevatorUp() {
        super ("Elevator Up");
        elevator = PurpleDrank.getElevator();
        requires (elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//        timer = new Timer();
//       timer.reset();
    }
    
    /**
     * Called just before this Command runs the first time
     * turns the motor off
     */
    protected void initialize() {
        Elevator.raiseBalls();
//        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        if (RobotMap.elevatorSwitch.get()) && timer.get() > 50)
//            return true;
//        return false;
        return true;
        
    }

    // Called once after isFinished returns true
    protected void end() {
//        timer.stop();
//        Elevator.stopRaising();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//        timer.stop();
//        Elevator.stopRaising();
    }
}
