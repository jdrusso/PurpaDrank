/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author abbottk
 */
public class ShooterSpeed extends PIDCommand {
    
    private Shooter shootController;
    private final double gravity = 32.1895039;
    private double range; //feet
    private double angleDegress;
    private double angleRadians;
    private double setpoint;
    private double output = 0;
    
    public ShooterSpeed(double Kp, double Ki, double Kd, double angle, double range){
        super("ShooterSpeed", Kp, Ki, Kd);
        this.range = range;
        this.angleDegress = angle;
        this.shootController = PurpleDrank.getShooterController(); 
        requires(this.shootController);
        
    }
    protected double returnPIDInput() {
        return 0;
    }

    protected void usePIDOutput(double output) {
        this.output += output;
        shootController.rotate(this.output);
    }

    protected void initialize() {
        calculateVelocity();
        this.setSetpoint(setpoint);
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
    
    protected void calculateVelocity(){
        angleRadians = Math.toRadians(angleDegress);
        setpoint = range*Math.sqrt(gravity/((range*Math.tan(angleRadians))-(RobotMap.target1Height)+RobotMap.shooterHeight))/(Math.sqrt(2.0)*Math.cos(angleRadians));
        //target 1 height tBD as well as shooter height
    }
    
    
    
}
