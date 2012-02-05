/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author Team 2035 Programmers
 */
public class RobotMap {
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    /* PWM OUTPUTS for Digital Sidecar
     * These should be sequential.
     */
    public static final int frontLeftMotor = 1;
    public static final int rearLeftMotor = 2;
    public static final int frontRightMotor = 3;
    public static final int rearRightMotor = 4;
    public static final int HorTurretMotor = 5;
    public static final int VerTurretMotor = 6;
    public static final int TopShooterMotor = 7;
    public static final int BottomShooterMotor = 8;
    
    /*
     * Height Constants for shooter in inches
     */
    public static final double target1Height = 28.0/12/0;
    public static final double target2Height = 61.0/12.0;
    public static final double target3Height = 98.0/12.0;
    public static final double shooterHeight = 30.0/12.0; //default, TBD
    
    
    /* DRIVER STATION CONTROLS
     * 
     */
    public static final int DriverJoystick = 1; // Robot Driver's Joystick USB number
    
    /* cRIO SIDECARS
     * 
     */
    public static final int AnalogSideCar = 1; // Analog SideCar is connected to cRIO Slot 1
    public static final int DigitalSideCar = 2; // Digital SideCar is connected to cRIO Slot 2
    
    /* ANALOG INPUTS 
     * These should be sequential.
     */
    public static final int GyroInput = 1; // Gyro Analog Input is channel 1
    
    /* DIGITAL INPUTS 
     * These should be sequential.
     */
    
    /* ROBOT CODE DEFINED CONSTANTS */
    // Kp - K proportional value for AutoBalancing.
    public static final double AutoBalKp = (double) (0.25 / 45);
    // Ki - K integral value for AutoBalancing.
    public static final double AutoBalKi = (double) (0);
    // Kd - K differential value for AutoBalancing.
    public static final double AutoBalKd = (double) (0.1 / 20);
    
    /* ROBOT CODE DEFINED CONSTANTS */
    // Kp - K proportional value for HorizontalTurretRotation.
    public static final double HorTurretKp = (double) (.25/15);
    // Ki - K integral value for HorizontalTurretRotation.
    public static final double HorTurretKi = (double) (0);
    // Kp - K differential value for HorizontalTurretRotation.
    public static final double HorTurretKd = (double) (0);
    
    /* ROBOT CODE DEFINED CONSTANTS */
    // Kp - K proportional value for VerticalTurretRotation.
    public static final double VerTurretKp = (double) (.25/2);
    // Ki - K integral value for VerticalTurretRotation.
    public static final double VerTurretKi = (double) (0);
    // Kp - K differential value for VerticalTurretRotation.
    public static final double VerTurretKd = (double) (0);
    
     /* ROBOT CODE DEFINED CONSTANTS */
    // Kp - K proportional value for shooter.
    public static final double shooterKp = (double) (.1);
    // Ki - K integral value for shooter.
    public static final double shooterKi = (double) (0);
    // Kp - K differential value for shooter.
    public static final double shooterKd = (double) (0);
    
    /*String KeyValues for Vision Tracking Hashtable*/
    //VTx - X value offset
    public static final String VTx = "VTx";
    //VTy - y value offset
    public static final String VTy = "VTy";
    //VTd - distance to target
    public static final String VTd = "VTd";//
    
   
    public static final double cameraXOffset = 0.0;
    public static final double cameraYOffset = 0.0;
    /*
    * Target Values to be edited by Target Sorting thread
    */
    public static double[] top;
    public static double[] bottom;
    public static double[] left;
    public static double[] right;
    public static double range;
    
    
    public static double desiredAngle = 0.0;
    
    
    public static final double fieldZone1 = 18.0;
    public static final double fieldZone1DesiredAngle = 45.0;
    public static final double fieldZone2 = 36.0;
    public static final double fieldZone2DesiredAngle = 35.0;
    public static final double fieldZone3 = 54.0;
    public static final double fieldZone3DesiredAngle = 25.0;
}
