/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

    private Joystick  Joystick1;
    private Joystick Joystick2;
    private RobotDrive drive;
    private DriveTrain DriveTrain;
    
    public DefaultDriveTrain(RobotDrive d, Joystick j){
        super("DefaultDriveTrain");
        DriveTrain = PurpleDrank.getDriveTrain(); 
        requires(DriveTrain);
        Joystick1 = j;
        drive = d;    
    }
    
    protected void initialize() {
        DriveTrain.getCommandLog().setCommand(this.getName());
    }

    protected void execute() {
        drive.arcadeDrive(Joystick1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
