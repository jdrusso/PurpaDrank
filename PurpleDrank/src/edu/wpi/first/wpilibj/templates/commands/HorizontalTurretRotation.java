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
    
    
    public HorizontalTurretRotation(double Kp, double Ki, double Kd){
        super("HorizontalTurretRotation", Kp, Ki, Kd);
        this.HorizontalAxis = PurpleDrank.getHorizontalTurretAxis();
        requires(this.HorizontalAxis);
        
    }
    protected double returnPIDInput() {
        if(RobotMap.isTop){
            HorizontalTurretAxis.getCommandLog().setOutputs("" + RobotMap.Tx);
            return RobotMap.Tx;
            
        }
        else if(RobotMap.isRight){
            HorizontalTurretAxis.getCommandLog().setOutputs("" + RobotMap.Rx);
            return RobotMap.Rx;
        }
        else if(RobotMap.isLeft){
            HorizontalTurretAxis.getCommandLog().setOutputs("" + RobotMap.Lx);
            return RobotMap.Lx;
        }
        else if(RobotMap.isBottom){
            HorizontalTurretAxis.getCommandLog().setOutputs("" + RobotMap.Bx);
            return RobotMap.Bx;
        }
        
        else{
            HorizontalTurretAxis.getCommandLog().setOutputs("N/A");
            return RobotMap.cameraXOffset;
        }
        //TODO:  Get x values and add to meta command log, also do for vertical turret
        
    }

    protected void usePIDOutput(double output) {
        HorizontalAxis.rotate(output);
    }

    protected void initialize() {
        this.setSetpoint(RobotMap.cameraXOffset);
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