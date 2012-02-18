/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.HorizontalTurretAxis;

/**
 *
 * @author abbottk
 */
public class HorizontalDefaultCommand extends CommandBase {

    private HorizontalTurretAxis horizontalAxis;
    public HorizontalDefaultCommand(){
        super("HorizontalDefaultCommand");
        this.horizontalAxis = PurpleDrank.getHorizontalTurretAxis();
        requires(this.horizontalAxis);
        
    }
    protected void initialize() {
        HorizontalTurretAxis.getCommandLog().setCommand(this.getName());
        HorizontalTurretAxis.getCommandLog().setInputs("N/A");
    }

    protected void execute() {
        horizontalAxis.rotate(OI.getJoystick2().getX()*.25);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        new HorizontalTurretRotation(RobotMap.HorTurretKp, RobotMap.HorTurretKi, RobotMap.HorTurretKd).start();//
    }

    protected void interrupted() {
    }
    
}