/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.team2035.meta.MetaGyro;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.subsystems.*;
import edu.wpi.first.wpilibj.templates.PurpleDrank;

/**
 *
 * @author abbottk
 */
public class ManualBalancing extends CommandBase{

    private DriveTrain DriveTrain;
    private Gyro gyro1;//
    
   public ManualBalancing() {
       super("ManualBalancing");
       DriveTrain = PurpleDrank.getDriveTrain(); 
       gyro1 = DriveTrain.getGyro1();
       requires(DriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        gyro1.reset();
        DriveTrain.getCommandLog().setCommand(this.getName());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        DriveTrain.getCommandLog().setInputs("" + gyro1.getAngle());
        DriveTrain.setMetaCommandOutputs();
        DriveTrain.drive(-0.75);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(PurpleDrank.getIsDisabled()){
            return true;
        }
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
