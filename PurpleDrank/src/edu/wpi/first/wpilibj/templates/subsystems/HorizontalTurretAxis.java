/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.team2035.meta.MetaCommandLog;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author abbottk
 */
public class HorizontalTurretAxis extends Subsystem{
    private Jaguar HorTurretJag;
    private static MetaCommandLog HorLog;

    public HorizontalTurretAxis(){
        super("HorizontalTurretAxis");
        HorLog = new MetaCommandLog("HorizontalTurretAxis", "NA" , "Jaguar");
        HorTurretJag = new Jaguar(RobotMap.HorTurretMotor);
    }
    protected void initDefaultCommand() {
        HorLog.setCommand("Default");
    }
    
    public void rotate(double speed){
        HorTurretJag.set(speed);
        HorLog.setOutputs("" + speed);
        
    }
    
    public static MetaCommandLog getCommandLog(){
        return HorLog;
    }
    
}
