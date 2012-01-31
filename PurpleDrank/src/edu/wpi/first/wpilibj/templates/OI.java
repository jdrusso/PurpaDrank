/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.team2035.meta.MetaUDPVariables;
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
    private static Joystick joystick1;
    private static Joystick joystick2;
    private static Button Balance;
    private static Button AutoBalance;
    private static Button shooter;
    private static MetaUDPVariables mdu;
    private static Button endAutoBalance;
    private DriveTrain DriveTrain;
    private static Button PushRamp;
    private static Button ballCollector;
    
    public static void initialize() {
        mdu = new MetaUDPVariables();
        
        joystick1 = new Joystick(1);
        joystick2 =new Joystick(2);
        
        AutoBalance = new JoystickButton(joystick1, 3);
        //AutoBalance.whenDoublePressed(new AutoBalancing(RobotMap.AutoBalKp, RobotMap.AutoBalKi, RobotMap.AutoBalKd));
        
        shooter = new JoystickButton( joystick2, 1);
        shooter.whileHeld(new HorizontalTurretRotation(RobotMap.HorTurretKp, RobotMap.HorTurretKi, RobotMap.HorTurretKd));
        shooter.whileHeld(new VerticalTurretRotation(RobotMap.VerTurretKp, RobotMap.VerTurretKi, RobotMap.VerTurretKd));
        
        //Balance = new JoystickButton( joystick1, 2);
        //Balance.whileHeld(new ManualBalancing());
        //Balance.whenReleased(new AutoBalancing(RobotMap.AutoBalKp, RobotMap.AutoBalKi, RobotMap.AutoBalKd));
        
        //ballCollector = new JoystickButton(joystick2, 2); //unsure what number joystick trigger is
        //ballCollector.whileHeld(new BallCollectionOn());
        //ballCollector.whenReleased(new BallCollectionOff());
        //PushRamp = new JoystickButton(joystick1, 4);
        //PushRamp.whenPressed(new ArmDown());
    }
    
    public static Button getButton3(){
        return AutoBalance;
    }
    
    public static Joystick getJoystick1(){
        return joystick1;
    }
    
    public static Joystick getJoystick2(){
        return joystick2;
    }
    
    public static MetaUDPVariables getMdu(){
        return mdu;
    }
    
}

