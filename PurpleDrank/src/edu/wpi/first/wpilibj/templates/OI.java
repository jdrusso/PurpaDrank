/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.team2035.meta.MetaTCPVariables;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.templates.commands.*;
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
    private static Button PushRamp;
    private static Button ballCollector;
    private static Button ShooterRealignRight;
    private static Button ShooterRealignLeft;
    private static Button ShooterRealignCenter;
    private static Button speedSetterUp;
    private static Button speedSetterDown;
    private static Button elevatorController;
    private static Button relayTest;
    
    private static Button HorTurretFwd;
    private static Button HorTurretRev;
    private static Button VerTurretFwd;
    private static Button VerTurretRev;
    
    
    public static void initialize() {
        
        mdu = new MetaTCPVariables();
        
        Balance = RobotMap.dButton2;
        Balance.whileHeld(new BalancingManual());
        Balance.whenReleased(new BalancingAutomatic(RobotMap.AutoBalKp, RobotMap.AutoBalKi, RobotMap.AutoBalKd));        
        
        //AutoBalance = RobotMap.dButton3;
        //AutoBalance.whenDoublePressed(new BalancingAutomatic(RobotMap.AutoBalKp, RobotMap.AutoBalKi, RobotMap.AutoBalKd));
        
        manualShooter = RobotMap.shootTrigger;
        manualShooter.whileHeld(new VerticalDefaultCommand());
        manualShooter.whileHeld(new HorizontalDefaultCommand());
        //manualShooter.whenDoublePressed(new ShooterSpeed(RobotMap.shooterKp, RobotMap.shooterKi, RobotMap.shooterKd));
        
        ballCollector = RobotMap.dButton5;
        ballCollector.whenPressed(new BallCollectionOn());
        ballCollector.whenReleased(new BallCollectionOff());
        ballCollector.whenDoublePressed(new BallCollectionReverse());
        
        elevatorController = RobotMap.dButton3;
        elevatorController.whenPressed(new ElevatorUp());
        elevatorController.whenDoublePressed(new ElevatorDown());
        elevatorController.whenReleased(new ElevatorOff());

        ShooterRealignRight = RobotMap.shootButton5;
        //ShooterRealignRight.whenReleased(new SetpointRealignment(RobotMap.realignRight));
        
        ShooterRealignLeft = RobotMap.shootButton4;
        //ShooterRealignLeft.whenReleased(new SetpointRealignment(RobotMap.realignLeft));
        
        ShooterRealignCenter = RobotMap.shootButton10;
        //ShooterRealignRight.whenReleased(new SetpointRealignment(RobotMap.realignCenter));
        
        PushRamp = RobotMap.dButton4;
        PushRamp.whenPressed(new ArmDown());
        PushRamp.whenDoublePressed(new ArmUp());
        
        speedSetterUp = RobotMap.shootButton6;
        speedSetterDown = RobotMap.shootButton7;
        speedSetterUp.whileHeld(new ChangeShooterSpeed('+'));
        speedSetterDown.whileHeld(new ChangeShooterSpeed('-'));
        speedSetterUp.whenReleased(new ChangeShooterSpeed(' '));
        speedSetterDown.whenReleased(new ChangeShooterSpeed(' '));
        speedSetterUp.whenDoublePressed(new ChangeShooterSpeed('r'));
        speedSetterDown.whenDoublePressed(new ChangeShooterSpeed('r'));
        
        HorTurretFwd = RobotMap.HorTurretFwd;
        HorTurretRev = RobotMap.HorTurretRev;
        VerTurretFwd = RobotMap.VerTurretFwd;
        VerTurretRev = RobotMap.VerTurretRev;
        
        HorTurretFwd.whileHeld(new HorizontalTurretRotationManual(1));
        HorTurretRev.whileHeld(new HorizontalTurretRotationManual(-1));
        
        VerTurretFwd.whileHeld(new VerticalTurretRotationManual(1));
        VerTurretRev.whileHeld(new VerticalTurretRotationManual(-1));
        
        
        
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

