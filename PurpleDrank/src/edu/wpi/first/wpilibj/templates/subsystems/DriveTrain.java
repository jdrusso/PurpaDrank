/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * 
 * Handles drive motors, transmission, gyros for autonomous balancing, and
 * joystick input
 *
 * @author jrusso
 */
public class DriveTrain extends Subsystem {
    
    private RobotDrive drive;
    private Joystick joystick1;
    private Transmission transmission1;
    private DigitalInput sensor1;
    private DigitalInput sensor2;
    private Jaguar lfJag;
    private Jaguar rtJag;
    private Jaguar lfFrontJag;
    private Jaguar rtFrontJag;
    
    
    Jaguar motor; 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public DriveTrain(){
        lfJag = new Jaguar(1);
        rtJag = new Jaguar(2);
        lfFrontJag = new Jaguar (3);
        rtFrontJag = new Jaguar (4);
        joystick1 = new Joystick(1);
        sensor1 = new DigitalInput(1);
        sensor2 = new DigitalInput (2);
    }
      
    public void initDefaultCommand() {
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void move(double speed) {
        motor.set(speed);
    }
}
