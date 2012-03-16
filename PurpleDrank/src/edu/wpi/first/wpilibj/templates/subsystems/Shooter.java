/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.MagneticEncoder;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author abbottk
 */
public class Shooter extends Subsystem {

    public Jaguar LeftJaguar;
    public Jaguar RightJaguar;
    
    //private AnalogChannel ultrasonic = new AnalogChannel(RobotMap.ultrasonicInput);
    
    private static MagneticEncoder magneticencoder = new MagneticEncoder(RobotMap.shooterEncoderPos);

    public Shooter() {
        LeftJaguar = new Jaguar(RobotMap.LeftShooterMotor);
        RightJaguar = new Jaguar(RobotMap.RightShooterMotor);
    }
    protected void initDefaultCommand() {
    
    
    }
    
    public void setShooterMotors(double speed){
        LeftJaguar.set(speed);
        RightJaguar.set(speed);
        
    }
    
//    public double getUltrasonic(){
//     
//        return ultrasonic.getVoltage();
//    }
    
//    public double getUltrasonicRange(){
//        
//        double temp = ((5/512)*ultrasonic.getVoltage());
//        System.out.println(temp);
//        return (temp);
//    }

    public double getRotationsPeriod(){
        return magneticencoder.getPeriod();
    }
    
    public double getRotations(){
        return magneticencoder.getIntegerCounter();
    }
    
    public double getRotationsDouble(){
        return magneticencoder.getDoubleCounter();
    }

}