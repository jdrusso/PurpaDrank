/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.team2035.meta.MetaTCPVariables;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.HorizontalTurretAxis;

/**
 *
 * @author abbottk
 */
public class HorizontalTurretRotation extends PIDCommand {
    private HorizontalTurretAxis HorizontalAxis;
    private MetaTCPVariables mdu;
    
    
    public HorizontalTurretRotation(double Kp, double Ki, double Kd){
        super("HorizontalTurretRotation", Kp, Ki, Kd);
        this.HorizontalAxis = PurpleDrank.getHorizontalTurretAxis();
        this.mdu = OI.getMdu();
        requires(this.HorizontalAxis);
        
    }
    protected double returnPIDInput() {
        return (double)mdu.getVariableFloatValue(RobotMap.VTx);
        //TODO:  Get x values and add to meta command log, also do for vertical turret
        
    }

    protected void usePIDOutput(double output) {
        HorizontalAxis.rotate(output);
    }

    protected void initialize() {
        HorizontalTurretAxis.getCommandLog().setCommand(this.getName());
        
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
