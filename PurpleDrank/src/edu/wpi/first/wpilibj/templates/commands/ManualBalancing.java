/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.team2035.meta.MetaGyro;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 * Manual Balancing command for the Robot
 * @author abbottk
 * 
 * Handles operator control balancing of the robot using a gyroscope.
 */
public class ManualBalancing extends CommandBase{

    private DriveTrain DriveTrain;
    private MetaGyro gyro1;
    
    /**
     * 
     */
    public ManualBalancing() {
       super();
       DriveTrain = PurpleDrank.getDriveTrain(); 
       gyro1 = DriveTrain.getGyro1();
       requires(DriveTrain);
    }

    // Called just before this Command runs the first time
    /**
     * 
     */
    protected void initialize() {
        gyro1.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * 
     */
    protected void execute() {
        DriveTrain.move(1);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * 
     * @return 
     */
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    /**
     * 
     */
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    /**
     * 
     */
    protected void interrupted() {
    }
}
