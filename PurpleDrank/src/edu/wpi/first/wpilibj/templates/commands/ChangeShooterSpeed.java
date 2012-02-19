/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author jrusso
 */
public class ChangeShooterSpeed extends CommandBase {
    char modifier;
    
    public ChangeShooterSpeed(char c) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        modifier = c;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (modifier == '+')
            RobotMap.defaultShooterSpeed += 0.02;
        else if (modifier == '-')
            RobotMap.defaultShooterSpeed -= 0.02;
        else if (modifier == 'r')
            RobotMap.defaultShooterSpeed = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (modifier == '-' || modifier == '+' || modifier == 'r')
            return false;
        else
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
