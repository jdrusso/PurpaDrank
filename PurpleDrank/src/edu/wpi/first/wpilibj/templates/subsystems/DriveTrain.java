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

/**
 * 
 * Handles drive motors, transmission, gyros for autonomous balancing, and
 * joystick input
 *
 * @author jrusso
 */
public class DriveTrain extends Subsystem {
    
    private RobotDrive drive;
    private Encoder transmission1;
    private DigitalInput sensor1;
    private DigitalInput sensor2;
    private Jaguar lfJag;
    private Jaguar rtJag;
    private Jaguar lfFrontJag;
    private Jaguar rtFrontJag;
    private double motorSpeeds;
    private static MetaGyro gyro1;
    private static MetaCommandLog Log;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public DriveTrain(){
        super("Drive Train");
        Log = new MetaCommandLog(this);
        gyro1 = new MetaGyro(1 , 1);
        lfJag = new Jaguar(1);
        rtJag = new Jaguar(2);
        drive = new RobotDrive(lfJag, rtJag);
        
        //lfFrontJag = new Jaguar (3);
        //rtFrontJag = new Jaguar (4);
        
        //joystick2 = new Joystick(2);
        //sensor1 = new DigitalInput(1);
        //sensor2 = new DigitalInput (2);

    }
      
    public void initDefaultCommand() {  
        //                                         //depeding on which driving method we are using.
        super.setDefaultCommand(new DefaultDriveTrain(drive, OI.getJoystick1()));
        //drive.tankDrive(joystick1, joystick2);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void move(double speed) {
        lfJag.set(speed);
        //lfFrontJag.set(speed);
        rtJag.set(-speed);
        //rtFrontJag.set(-speed);
    }
    

    public static MetaGyro getGyro1(){
        return gyro1;
    }
    
    public static MetaCommandLog getCommandLog(){
        return Log;
    }
    

}
