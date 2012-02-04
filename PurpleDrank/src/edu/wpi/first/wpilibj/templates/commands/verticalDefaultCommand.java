/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.VerticalTurretAxis;

/**
 *
 * @author abbottk
 */
public class verticalDefaultCommand extends CommandBase {

    private VerticalTurretAxis VerticalAxis;
    
    public verticalDefaultCommand(){
        super("verticalDefaultCommand");
        this.VerticalAxis = PurpleDrank.getVerticalTurretAxis();
        requires(this.VerticalAxis);
        
    }
    protected void initialize() {
        VerticalTurretAxis.getCommandLog().setCommand(this.getName());
        VerticalTurretAxis.getCommandLog().setInputs("N/A");
    }

    protected void execute() {
        VerticalAxis.rotate(OI.getJoystick2().getY()*.25);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
       new VerticalTurretRotation(RobotMap.VerTurretKp, RobotMap.VerTurretKi, RobotMap.VerTurretKd).start();
    }

    protected void interrupted() {
    }
    
}
