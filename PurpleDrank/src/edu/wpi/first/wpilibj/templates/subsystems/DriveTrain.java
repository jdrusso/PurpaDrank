/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.team2035.meta.MetaGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;

/**
 * 
 * Handles drive motors, transmission, gyros for autonomous balancing, and
 * joystick input
 *
 * @author jrusso
 */
public class DriveTrain extends Subsystem {
    
    private RobotDrive drive;
    private static Joystick joystick1;
    private static Joystick joystick2;
    private Encoder transmission1;
    private DigitalInput sensor1;
    private DigitalInput sensor2;
    private Jaguar lfJag;
    private Jaguar rtJag;
    private Jaguar lfFrontJag;
    private Jaguar rtFrontJag;
    private double motorSpeeds;
    private static MetaGyro gyro1;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public DriveTrain(){
        lfJag = new Jaguar(1);
        rtJag = new Jaguar(2);
        //drive = new RobotDrive(lfJag, rtJag);
        
        //lfFrontJag = new Jaguar (3);
        //rtFrontJag = new Jaguar (4);
        //joystick1 = new Joystick(1);
        //joystick2 = new Joystick(2);
        //sensor1 = new DigitalInput(1);
        //sensor2 = new DigitalInput (2);
        gyro1 = new MetaGyro(1 , 1);
    }
      
    public void initDefaultCommand() {  
        //drive.arcadeDrive(joystick1);                                           //depeding on which driving method we are using.
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
    
    public static Joystick getJoystick1(){
        return joystick1;
    }
    
    public static Joystick getJoystick2(){
        return joystick2;
    }
    
    public static MetaGyro getGyro1(){
        return gyro1;
    }
    

}
