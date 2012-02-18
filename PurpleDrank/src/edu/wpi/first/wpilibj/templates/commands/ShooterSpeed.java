/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.Timer;
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
    private double angleRadians;
    private double setpoint;
    private double output = 0;
    public Timer shooterTimer;
    
    public ShooterSpeed(double Kp, double Ki, double Kd){
        super("ShooterSpeed", Kp, Ki, Kd);
        this.shootController = PurpleDrank.getShooterController(); 
        requires(this.shootController);
        
    }
    protected double returnPIDInput() {
        return 0; // TODO: Replace 0 with encoder
    }

    protected void usePIDOutput(double output) {
        this.output += output;
        if (this.output >= 1.0)
            this.output = 1.0;
        if (this.output <= -1.0)
            this.output = -1.0;
        
        shootController.rotate(this.output);
    }

    protected void initialize() {
        calculateVelocity();
        this.setSetpoint(setpoint);
        shooterTimer = new Timer();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;//
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    protected void calculateVelocity(){
        angleRadians = Math.toRadians(RobotMap.desiredAngle);
        setpoint = RobotMap.range*Math.sqrt(gravity/((RobotMap.range*Math.tan(angleRadians))-(RobotMap.target1Height)+RobotMap.shooterHeight))/(Math.sqrt(2.0)*Math.cos(angleRadians));
        //target 1 height tBD as well as shooter height
    }
}
