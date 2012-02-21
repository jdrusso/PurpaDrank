/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
    public static final int LeftShooterMotor = 7;  //Left when standing behind the robot
    public static final int RightShooterMotor = 8; //Right when standing behind the robot
    
    public static double defaultShooterSpeed = 0;
    
    /* Relay outputs for Spikes
     * 
     */
    
    public static final Relay armSpike = new Relay(1);
    public static final Relay ballCollector = new Relay(2); //TODO: Add actual values
    public static final Relay elevator = new Relay(3);      //TODO: Add actual values
    //public static final Relay motor = new Relay(5);         //For testing
    //public static final Relay HorTurretMotorSpike = new Relay(4);
    //public static final Relay VerTurretMotorSpike = new Relay(5);
    
    /*
     * Height Constants for shooter in inches
     */
    public static final double target1Height = 28.0/12.0;
    public static final double target2Height = 61.0/12.0;
    public static final double target3Height = 98.0/12.0;
    public static final double shooterHeight = 30.0/12.0; //default, TBD
    
    
    /* DRIVER STATION CONTROLS
     * 
     */
    public static final int DriverJoystickNumber = 1; // Robot Driver's Joystick USB number
    
    public static final Joystick dStick = new Joystick(DriverJoystickNumber);
    
    public static final JoystickButton dTrigger = new JoystickButton(dStick, 1);
    public static final JoystickButton dButton2 = new JoystickButton(dStick, 2);
    public static final JoystickButton dButton3 = new JoystickButton(dStick, 3);
    public static final JoystickButton dButton4 = new JoystickButton(dStick, 4);
    public static final JoystickButton dButton5 = new JoystickButton(dStick, 5);
    public static final JoystickButton dButton6 = new JoystickButton(dStick, 6);
    public static final JoystickButton dButton7 = new JoystickButton(dStick, 7);
    public static final JoystickButton dButton8 = new JoystickButton(dStick, 8);
    public static final JoystickButton dButton9 = new JoystickButton(dStick, 9);
    public static final JoystickButton dButton10 = new JoystickButton(dStick, 10);
    public static final JoystickButton dButton11 = new JoystickButton(dStick, 11);
    
    public static final int shooterJoystickNumber = 1; // Robot Driver's Joystick USB number
    
    public static final Joystick shootStick = new Joystick(shooterJoystickNumber);
    
    public static final JoystickButton shootTrigger = new JoystickButton(shootStick, 1);
    public static final JoystickButton shootButton2 = new JoystickButton(shootStick, 2);
    public static final JoystickButton shootButton3 = new JoystickButton(shootStick, 3);
    public static final JoystickButton shootButton4 = new JoystickButton(shootStick, 4);
    public static final JoystickButton shootButton5 = new JoystickButton(shootStick, 5);
    public static final JoystickButton shootButton6 = new JoystickButton(shootStick, 6);
    public static final JoystickButton shootButton7 = new JoystickButton(shootStick, 7);
    public static final JoystickButton shootButton8 = new JoystickButton(shootStick, 8);
    public static final JoystickButton shootButton9 = new JoystickButton(shootStick, 9);
    public static final JoystickButton shootButton10 = new JoystickButton(shootStick, 10);
    public static final JoystickButton shootButton11 = new JoystickButton(shootStick, 11);
    
    public static final int turretJoystickNumber = 2; // Robot Driver's Joystick USB number
    
    public static final Joystick turretStick = new Joystick(turretJoystickNumber);
    
    public static final JoystickButton HorTurretFwd = new JoystickButton(turretStick, 6);
    public static final JoystickButton HorTurretRev = new JoystickButton(turretStick, 7);
    public static final JoystickButton VerTurretFwd = new JoystickButton(turretStick, 11);
    public static final JoystickButton VerTurretRev = new JoystickButton(turretStick, 10);

    public static final JoystickButton RampFwd = new JoystickButton(turretStick, 8);
    public static final JoystickButton RampRev = new JoystickButton(turretStick, 9);

    
    /* cRIO SIDECARS
     * 
     */
    public static final int AnalogSideCar = 1; // Analog SideCar is connected to cRIO Slot 1
    public static final int DigitalSideCar = 2; // Digital SideCar is connected to cRIO Slot 2
    
    /* ANALOG INPUTS 
     * These should be sequential.
     */
    public static final int DriveTrainGyroInput = 1; // Gyro Analog Input is channel 1
    public static final int VerticalTurretGyroInput = 2; // Gyro Analog Input for Vertical Turret    
    public static final int ultrasonicInput = 3;
    public static final int horRotEncoderPos = 4;
    public static final int verRotEncoderPos = 5;
    public static final int shooterEncoderPos = 6;
    
    /* DIGITAL INPUTS 
     * These should be sequential.
     */
    
    public static final DigitalInput elevatorSwitch = new DigitalInput(1); //Placeholder number
    
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
    
   
    public static boolean HorTurretManualControl = false;
    public static boolean VerTurretManualControl = false;

    public static int cameraXOffset = 0;
    public static final int defaultCameraOffset = 0;
    public static final int cameraYOffset = 0;
    public static final int realignLeft = -1;
    public static final int realignRight = 0;
    public static final int realignCenter = 1;
    /*
    * Target Values to be edited by Target Sorting thread
    */
    public static double[] top = new double[2];
    public static double[] bottom = new double[2];
    public static double[] left = new double[2];
    public static double[] right = new double[2];
    public static double range;
    
    
    //This would be useful if the ultrasonic sensors didn't suck
    public static double ultrasonicRange;
    
    public static double desiredAngle = 0.0;
    
    
    public static final double fieldZone1 = 18.0;
    public static final double fieldZone1DesiredAngle = 45.0;
    public static final double fieldZone2 = 36.0;
    public static final double fieldZone2DesiredAngle = 35.0;
    public static final double fieldZone3 = 54.0;
    public static final double fieldZone3DesiredAngle = 25.0;
    
    
    public static final int elevationEncoderPerTenthDegree = 5;  // Actually is 2.5 now -TA 2/19/2012
    public static final int azimuthEncoderPerTenthDegree = 10;
}