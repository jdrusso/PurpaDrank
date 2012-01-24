/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.templates.commands.ExampleCommand;
import edu.wpi.first.wpilibj.templates.commands.ManualBalancing;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 * The Java Virtual Machine (VM) running on the robot cRIO is configured to
 * automatically run this class, and to call the
 * methods corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class PurpleDrank extends IterativeRobot {

    Command autonomousCommand;
    private static DriveTrain DriveTrain;
    private ManualBalancing h;
    private OI oi;

        
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.  
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
        DriveTrain = new DriveTrain();
        oi = new OI();

        // Initialize all subsystems
        //CommandBase.init();
    }

    /** 
     * This code runs once when the autonomous mode is started.
     */
    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous mode
     * at about 200 times a second.
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /** 
     * This code runs once when the operator control mode is started.
     */    
    public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to 
		// continue until interrupted by another command, remove
		// this line or comment it out.
		autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control mode
     * at about 200 times a second.
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This is a helper method to return the DriveTrain subsystem.
     * @return the DriveTrain subsystem instance being used by the robot code. 
     */
    public static DriveTrain getDriveTrain(){
        
        return DriveTrain;
    }

}
