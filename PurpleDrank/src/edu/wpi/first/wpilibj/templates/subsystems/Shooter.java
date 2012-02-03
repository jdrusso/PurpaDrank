/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DefaultDriveTrain;

/**
 *
 * @author abbottk
 */
public class Shooter extends Subsystem {

    private Jaguar TopJaguar;
    private Jaguar BottomJaguar;
    
    public Shooter(){
        TopJaguar = new Jaguar(RobotMap.TopShooterMotor);
        BottomJaguar = new Jaguar(RobotMap.BottomShooterMotor);
    }
    protected void initDefaultCommand() {
    
    
    }
    
    public void rotate(double speed){
        TopJaguar.set(speed);
        BottomJaguar.set(speed);
        
    }
    
    
}
