/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.VerticalTurretAxis;

/**
 *
 * @author jrusso
 */
public class VerticalTurretRotationManual extends CommandBase {
    public double direction;
//    public Relay VerTurretSpike;
    public VerticalTurretAxis vt;
    
    public VerticalTurretRotationManual() {
        vt = PurpleDrank.getVerticalTurretAxis();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vt);
//        VerTurretSpike = RobotMap.VerTurretMotorSpike;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        if (direction > 0)
//            VerTurretSpike.set(Relay.Value.kForward);
//        else
//            VerTurretSpike.set(Relay.Value.kReverse);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        direction = RobotMap.shootStick.getY();
        vt.rotate(direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
//        VerTurretSpike.set(Relay.Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//        VerTurretSpike.set(Relay.Value.kOff);
        vt.rotate(0.0);
    }
}
