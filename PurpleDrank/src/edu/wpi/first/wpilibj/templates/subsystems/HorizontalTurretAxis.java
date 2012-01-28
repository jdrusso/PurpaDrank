/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author abbottk
 */
public class HorizontalTurretAxis extends Subsystem{
    private Jaguar HorTurretJag;

    public HorizontalTurretAxis(){
        super("HorizontalTurretAxis");
        HorTurretJag = new Jaguar(RobotMap.HorTurretMotor);
    }
    protected void initDefaultCommand() {
    }
    
    public void rotate(double speed){
        HorTurretJag.set(speed);
    }
    
}
