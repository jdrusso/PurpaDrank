/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.team2035.meta.MetaCommandLog;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.MagneticEncoder;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.HorizontalTurretRotation;

/**
 *
 * @author abbottk
 */
public class HorizontalTurretAxis extends Subsystem{
    private Jaguar HorTurretJag;
    private Relay HorTurretSpike;
    private static MetaCommandLog HorLog;
    
    private static MagneticEncoder magneticencoder = new MagneticEncoder(RobotMap.horRotEncoderPos);
    
    public HorizontalTurretAxis(){
        super("HorizontalTurretAxis");
        HorLog = new MetaCommandLog("HorizontalTurretAxis", "Target X-value" , "Jaguar");
        HorTurretJag = new Jaguar(RobotMap.HorTurretMotor);
        //HorTurretJag = new Jaguar(RobotMap.HorTurretMotorSpike);
        //HorTurretSpike = RobotMap.HorTurretMotorSpike;
    }
    protected void initDefaultCommand() {
        HorLog.setCommand("Default");//
        super.setDefaultCommand(new HorizontalTurretRotation(RobotMap.HorTurretKp, RobotMap.HorTurretKi, RobotMap.HorTurretKd));

    }
    
    public void rotate(double speed){
        HorTurretJag.set(speed);
        HorLog.setOutputs("" + speed);
//        if (speed > 0.1)
//            HorTurretSpike.set(Relay.Value.kForward);
//        else if (speed < 0.1)
//            HorTurretSpike.set(Relay.Value.kReverse);
//        else 
//            HorTurretSpike.set(Relay.Value.kOff);
        
    }
    
    public static MetaCommandLog getCommandLog(){
        return HorLog;
    }

    /**
     *
     * @return the integer number of complete rotations by the magnetic
     * encoder.
     */
    public int getHorRotations(){
        return magneticencoder.getIntegerCounter();
    }

    /**
     * This is not completely tested yet.
     * @return
     */
    public double getHorRotationsDouble(){
        return magneticencoder.getDoubleCounter();
    }

}
