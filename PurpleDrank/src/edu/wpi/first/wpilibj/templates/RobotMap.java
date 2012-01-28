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
    
    /* PWM OUTPUTS
     * These should be sequential.
     */
    public static final int frontLeftMotor = 1;
    public static final int rearLeftMotor = 2;
    public static final int frontRightMotor = 3;
    public static final int rearRightMotor = 4;
    public static final int HorTurretMotor = 5;
    public static final int VerTurretMotor = 6;
    
    
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
    // Kp - K differential value for AutoBalancing.
    public static final double AutoBalKd = (double) (0.1 / 20);
    
    /* ROBOT CODE DEFINED CONSTANTS */
    // Kp - K proportional value for HorizontalTurretRotation.
    public static final double HorTurretKp = (double) (.1);
    // Ki - K integral value for HorizontalTurretRotation.
    public static final double HorTurretKi = (double) (0);
    // Kp - K differential value for HorizontalTurretRotation.
    public static final double HorTurretKd = (double) (0);
    
    /* ROBOT CODE DEFINED CONSTANTS */
    // Kp - K proportional value for VerticalTurretRotation.
    public static final double VerTurretKp = (double) (.1);
    // Ki - K integral value for VerticalTurretRotation.
    public static final double VerTurretKi = (double) (0);
    // Kp - K differential value for VerticalTurretRotation.
    public static final double VerTurretKd = (double) (0);
    
    /*String KeyValues for Vision Tracking Hashtable*/
    //VTx - X value offset
    public static final String VTx = "VTx";
    //VTy - y value offset
    public static final String VTy = "VTy";
    //VTd - distance to target
    public static final String VTd = "VTd";
}
