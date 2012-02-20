package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author jrusso
 */
public class ShootBall extends CommandGroup {
    
    public ShootBall() {
        // TODO: Check that the shooting motors are at the correct speed
        // for now we are just using the motors as is.
        //ShooterSpeed shooterSpeed = new ShooterSpeed(RobotMap.shooterKp, RobotMap.shooterKi, RobotMap.shooterKd);
        //addSequential(shooterSpeed);
        //if (shooterSpeed.isSpunUp())
        //    addParallel(new ElevatorUp());
        
        addSequential(new ElevatorUp());
        
        
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
