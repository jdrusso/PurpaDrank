/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author abbottk
 */
public class Shooting extends CommandBase{
    
    Shooter shooter = new Shooter();
    private ShooterSpeed shooterSpeed;
    
    public Shooting(double spd){
        
        super("Shooting");
    }

    protected void initialize() {
        
        //shooter.setShooterMotors(ShooterSpeed.);
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
