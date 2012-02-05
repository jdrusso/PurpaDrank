/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.team2035.meta.MetaGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.templates.commands.DefaultDriveTrain;
import edu.team2035.meta.MetaCommandLog;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * 
 * Handles drive motors, transmission, gyros for autonomous balancing, and
 * joystick input
 *
 * @author jrusso
 */
public class DriveTrain extends Subsystem {
    
    private static RobotDrive drive;
    private Encoder transmission1;
    private DigitalInput sensor1;
    private DigitalInput sensor2;
    private Jaguar lfJag;
    private Jaguar rtJag;
    private Jaguar lfRearJag;
    private Jaguar rtRearJag;
    private double motorSpeeds;
    private static Gyro gyro1;
    private static MetaCommandLog Log;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public DriveTrain(){
        super("Drive Train");
        Log = new MetaCommandLog("DriveTrain", "Gyro" , "Left Jaguars,Right Jaguars");
        gyro1 = new Gyro(1 , 1);
        lfJag = new Jaguar(RobotMap.frontLeftMotor);
        lfRearJag = new Jaguar(RobotMap.rearLeftMotor);
        rtJag = new Jaguar(RobotMap.frontRightMotor);
        rtRearJag = new Jaguar(RobotMap.rearRightMotor);
        drive = new RobotDrive(lfJag, lfRearJag, rtJag, rtRearJag);
        
        //lfFrontJag = new Jaguar (3);
        //rtFrontJag = new Jaguar (4);
        
        //joystick2 = new Joystick(2);
        //sensor1 = new DigitalInput(1);
        //sensor2 = new DigitalInput (2);

    }
      
    public void initDefaultCommand() {  
        super.setDefaultCommand(new DefaultDriveTrain(drive, OI.getJoystick1()));
    }
    
    public void resetMotorTimers(){
        RobotDrive.feed();
    }
    
    public void drive(double speed) {
        drive.drive(speed, 0);
    }
    

    public static Gyro getGyro1(){
        return gyro1;
    }
    
    public static MetaCommandLog getCommandLog(){
        return Log;//
    }
    
    public static void setMetaCommandOutputs(){
        Log.setOutputs("" + drive.getLeftOutputs() + "," + drive.getRightOutputs());
        
    }
    

}
