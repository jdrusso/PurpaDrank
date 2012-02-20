/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.HorizontalTurretAxis;

/**
 *
 * @author jrusso
 */
public class HorizontalTurretRotationManual extends CommandBase {
    public int direction;
    //public Relay HorTurretSpike;
    public HorizontalTurretAxis ht;
    
    public HorizontalTurretRotationManual(int directionIn) {
        ht = PurpleDrank.getHorizontalTurretAxis();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        direction = directionIn;
        //HorTurretSpike = RobotMap.HorTurretMotorSpike;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ht.rotate(direction);
//        if (direction > 0)
//            HorTurretSpike.set(Relay.Value.kForward);
//        else
//            HorTurretSpike.set(Relay.Value.kReverse);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ht.rotate(direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
//        HorTurretSpike.set(Relay.Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//        HorTurretSpike.set(Relay.Value.kOff);
        ht.rotate(0.0);
    }
}
