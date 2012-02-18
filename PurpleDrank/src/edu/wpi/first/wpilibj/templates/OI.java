/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.team2035.meta.MetaTCPVariables;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
/**
 * 
 * @author Team 2035 Programmers
 */
public class OI {
    // Process operator interface input here.
    private static Button Balance;
    private static Button AutoBalance;
    private static Button manualShooter;
    private static MetaTCPVariables mdu;
    private static Button endAutoBalance;
    private DriveTrain DriveTrain;
    private static Button PushRamp;
    private static Button ballCollector;
    
    public static void initialize() {
        
        mdu = new MetaTCPVariables();
        
        Balance = RobotMap.dButton2;
        Balance.whileHeld(new ManualBalancing());
        Balance.whenReleased(new AutoBalancing(RobotMap.AutoBalKp, RobotMap.AutoBalKi, RobotMap.AutoBalKd));        
        
        //AutoBalance = RobotMap.dButton3;
        //AutoBalance.whenDoublePressed(new AutoBalancing(RobotMap.AutoBalKp, RobotMap.AutoBalKi, RobotMap.AutoBalKd));
        
        manualShooter = RobotMap.shootTrigger;
        manualShooter.whileHeld(new verticalDefaultCommand());
        manualShooter.whileHeld(new horizontalDefaultCommand());
        manualShooter.whenDoublePressed(new Shooting());
        
        ballCollector = RobotMap.dButton5;
        ballCollector.whenPressed(new BallCollectionOn());
        ballCollector.whenReleased(new BallCollectionOff());
        ballCollector.whenDoublePressed(new BallCollectionReverse());
        
        PushRamp = RobotMap.dButton4;
        PushRamp.whenPressed(new ArmDown());
        PushRamp.whenDoublePressed(new ArmReset());
    }
    
    public static Button getButton3(){
        return AutoBalance;
    }
    
    public static Joystick getJoystick1(){
        return RobotMap.dStick;
    }
    
    public static Joystick getJoystick2(){
        return RobotMap.shootStick;
    }
    
    public static MetaTCPVariables getMdu(){
        return mdu;
    }
    
}

