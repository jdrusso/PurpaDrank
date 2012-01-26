/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.OI;

/**
 *
 * @author abbottk
 */
public class AutoBalancing extends PIDCommand{

    private DriveTrain DriveTrain;
    private Gyro gyro1;
    
    public AutoBalancing(double Kp, double Ki, double Kd){
        super("AutoBalancing", Kp, Ki, Kd);
        this.DriveTrain = PurpleDrank.getDriveTrain(); 
        gyro1 = DriveTrain.getGyro1();
        requires(DriveTrain);
        
    }
    protected double returnPIDInput() {
        return gyro1.getAngle();
        
    }

    protected void usePIDOutput(double output) {
        DriveTrain.move(output);
    }

    protected void initialize() {
        DriveTrain.getCommandLog().setCommand(this.getName());
        
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        
            return OI.getButton3().get();
            
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
