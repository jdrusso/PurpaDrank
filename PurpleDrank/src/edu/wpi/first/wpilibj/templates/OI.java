/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 * 
 * @author Team 2035 Programmers
 */
public class OI {
    // Process operator interface input here.
    private static Joystick joystick1;
    private static Joystick joystick2;
    private Button Balance;
    private static Button endAutoBalance;
    private DriveTrain DriveTrain;
    
    public OI() {
        DriveTrain = PurpleDrank.getDriveTrain();
        joystick1 = new Joystick(1);
        //Joystick2 = DriveTrain.getJoystick2();
        //AutoBalancing h = new AutoBalancing(.25/40, 0, .1/20); 
        //h.start();
        endAutoBalance = new JoystickButton (joystick1, 3);
        Balance = new JoystickButton( joystick1, 2);
        Balance.whileHeld(new ManualBalancing());
        Balance.whenReleased(new AutoBalancing(.25/40, 0, .1/20));
    
    }
    
    public static Button getButton3(){
        return endAutoBalance;
    }
    
    public static Joystick getJoystick1(){
        return joystick1;
    }
    
    public static Joystick getJoystick2(){
        return joystick2;
    }
    
}

