/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
/**
 *
 * @author abbottk
 */
public class DefaultDriveTrain extends CommandBase{

    private Joystick Joystick1;
    private Joystick Joystick2;
    private RobotDrive drive;
    private DriveTrain DriveTrain;
    
    /**
     * 
     * @param d
     * @param j 
     */
    public DefaultDriveTrain(RobotDrive d, Joystick j){
        super();
        DriveTrain = PurpleDrank.getDriveTrain(); 
        requires(DriveTrain);
        Joystick1 = j;
        drive = d;    
    }
    
    /**
     * 
     */
    protected void initialize() {
    }

    /**
     * 
     */
    protected void execute() {
        drive.arcadeDrive(Joystick1);
    }

    /**
     * 
     * @return 
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * 
     */
    protected void end() {
    }

    /**
     * 
     */
    protected void interrupted() {
    }
    
}
