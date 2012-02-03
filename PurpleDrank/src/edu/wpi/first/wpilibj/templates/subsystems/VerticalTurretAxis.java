/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.team2035.meta.MetaCommandLog;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author abbottk
 */
public class VerticalTurretAxis extends Subsystem  {

    private Jaguar VerTurretJag;
    private static MetaCommandLog VerLog;

    public VerticalTurretAxis(){
        super("VerticalTurretAxis");
        VerLog = new MetaCommandLog("VerticalTurretAxis", "NA" , "Jaguar");
        VerTurretJag = new Jaguar(RobotMap.VerTurretMotor);
    }
    protected void initDefaultCommand() {
        VerLog.setCommand("Default");
    }
    
    public void rotate(double speed){
        VerTurretJag.set(speed);
        VerLog.setOutputs("" + speed);
    }
    
    public static MetaCommandLog getCommandLog(){
        return VerLog;
    }
}
