/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.team2035.meta.MetaTCPVariables;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.HorizontalTurretAxis;
import edu.wpi.first.wpilibj.templates.subsystems.VerticalTurretAxis;

/**
 *
 * @author abbottk
 */
public class VerticalTurretRotation extends PIDCommand {
    private VerticalTurretAxis VerticalAxis;
    private MetaTCPVariables mdu;
    private int TargetAngle;
    private int range;
    
    public VerticalTurretRotation(double Kp, double Ki, double Kd){
        super("VerticalTurretRotation", Kp, Ki, Kd);
        this.VerticalAxis = PurpleDrank.getVerticalTurretAxis();
        this.mdu = OI.getMdu();
        requires(this.VerticalAxis);
        
    }
    protected double returnPIDInput() {
        return (double)mdu.getVariableFloatValue(RobotMap.VTy);
        
    }

    protected void usePIDOutput(double output) {
        VerticalAxis.rotate(output);
    }

    protected void initialize() {
        VerticalTurretAxis.getCommandLog().setCommand(this.getName());
        TargetAngle = 30; //Angle Calculation TBD
        new ShooterSpeed(RobotMap.shooterKp, RobotMap.shooterKi, RobotMap.shooterKp, TargetAngle, range).start();
        
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        
            return false;
            
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
