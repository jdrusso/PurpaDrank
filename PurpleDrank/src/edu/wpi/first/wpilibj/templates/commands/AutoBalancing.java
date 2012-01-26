/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/** 
 * Auto Balancing PID Command for the robot.
 * @author abbottk
 */
public class AutoBalancing extends PIDCommand{

    private DriveTrain DriveTrain;
    private Gyro gyro1;
    
    /**
     * 
     * @param Kp
     * @param Ki
     * @param Kd 
     */
    public AutoBalancing(double Kp, double Ki, double Kd){
        super(Kp, Ki, Kd);
        this.DriveTrain = PurpleDrank.getDriveTrain(); 
        this.gyro1 = this.DriveTrain.getGyro1();
        requires(this.DriveTrain);
        
    }
    
    /**
     * 
     * @return 
     */
    protected double returnPIDInput() {
        return gyro1.getAngle();
        
    }

    /**
     * 
     * @param output 
     */
    protected void usePIDOutput(double output) {
        DriveTrain.move(output);
    }

    /**
     * 
     */
    protected void initialize() {
        
    }

    /**
     * 
     */
    protected void execute() {
    }

    /**
     * isFinished() - determines when the PIDControl has completed.
     * @return Joystick 1, Button 3 value (true or false)
     */
    // TBD: why is this not return OI.getButton3().get(); ?
    protected boolean isFinished() {
        if( OI.getButton3().get()){
            return true;
        }
        return false;
    }

    /**
     * 
     */
    protected void end() {
    }

    /**
     * 
     */
    protected void interrupted() {
    }
    
}
