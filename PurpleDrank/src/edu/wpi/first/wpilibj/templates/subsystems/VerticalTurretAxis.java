/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author abbottk
 */
public class VerticalTurretAxis extends Subsystem  {

    private Jaguar VerTurretJag;

    public VerticalTurretAxis(){
        super("VerticalTurretAxis");
        VerTurretJag = new Jaguar(RobotMap.VerTurretMotor);
    }
    protected void initDefaultCommand() {
    }
    
    public void rotate(double speed){
        VerTurretJag.set(speed);
    }
}
