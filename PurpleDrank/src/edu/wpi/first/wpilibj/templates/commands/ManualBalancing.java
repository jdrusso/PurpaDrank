/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.team2035.meta.MetaGyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.subsystems.*;
import edu.wpi.first.wpilibj.templates.PurpleDrank;

/**
 *
 * @author abbottk
 */
public class ManualBalancing extends CommandBase{

    private DriveTrain DriveTrain;
    private MetaGyro gyro1;
    
   public ManualBalancing() {
       super();
       DriveTrain = PurpleDrank.getDriveTrain(); 
       gyro1 = DriveTrain.getGyro1();
       requires(DriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        gyro1.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        DriveTrain.move(1);
        
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
