/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.AutoBalancing;
import edu.wpi.first.wpilibj.templates.commands.ManualBalancing;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 * This is the Operator Interface class of the Robot code.
 * 
 * Code relating to joysticks, buttons, etc and their interactions
 * with the subsystems and commands are here.
 */
public class OI {
    // Process operator interface input here.
    private Joystick Joystick1;
    private Joystick Joystick2;
    private Button Balance;
    private static Button endAutoBalance;
    private DriveTrain DriveTrain;
    
    /**
     * Constructor for the OI class.  This is where input events are 
     * registered (connected) to the commands. 
     */
    public OI() {
        DriveTrain = PurpleDrank.getDriveTrain();
        Joystick1 = DriveTrain.getJoystick1();
        //Joystick2 = DriveTrain.getJoystick2();
        //AutoBalancing h = new AutoBalancing(.25/40, 0, .1/20); 
        //h.start();
        endAutoBalance = new JoystickButton (Joystick1, 3);
        Balance = new JoystickButton( Joystick1, 2);
        Balance.whileHeld(new ManualBalancing());
        Balance.whenReleased(new AutoBalancing(RobotMap.Kp, RobotMap.Ki, RobotMap.Kd));
    
    }
    
    /** getButton3()
     * This can be used as getButton3().get() to return the button
     * state.
     * 
     * @return the button 3 on Joystick 1 object.
     * 
     */
    public static Button getButton3(){
        return endAutoBalance;
    }
}

