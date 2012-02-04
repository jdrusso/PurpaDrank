/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.team2035.meta.MetaCommandLog;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.HorizontalTurretRotation;
import edu.wpi.first.wpilibj.templates.commands.horizontalDefaultCommand;
import edu.wpi.first.wpilibj.templates.commands.verticalDefaultCommand;

/**
 *
 * @author abbottk
 */
public class HorizontalTurretAxis extends Subsystem{
    private Jaguar HorTurretJag;
    private static MetaCommandLog HorLog;

    public HorizontalTurretAxis(){
        super("HorizontalTurretAxis");
        HorLog = new MetaCommandLog("HorizontalTurretAxis", "Target X-value" , "Jaguar");
        HorTurretJag = new Jaguar(RobotMap.HorTurretMotor);
    }
    protected void initDefaultCommand() {
        HorLog.setCommand("Default");
        super.setDefaultCommand(new HorizontalTurretRotation(RobotMap.HorTurretKp, RobotMap.HorTurretKi, RobotMap.HorTurretKd));
    }
    
    public void rotate(double speed){
        HorTurretJag.set(speed);
        HorLog.setOutputs("" + speed);
        
    }
    
    public static MetaCommandLog getCommandLog(){
        return HorLog;
    }
    
}
