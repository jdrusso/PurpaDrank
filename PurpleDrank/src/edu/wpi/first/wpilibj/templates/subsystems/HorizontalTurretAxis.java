/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.team2035.meta.MetaCommandLog;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.HorizontalTurretRotation;
import edu.wpi.first.wpilibj.templates.commands.HorizontalDefaultCommand;
import edu.wpi.first.wpilibj.templates.commands.VerticalDefaultCommand;
import edu.wpi.first.wpilibj.templates.MagneticEncoder;

/**
 *
 * @author abbottk
 */
public class HorizontalTurretAxis extends Subsystem{
    private Jaguar HorTurretJag;
    private Relay HorTurretSpike;
    private static MetaCommandLog HorLog;
//    private static AnalogTrigger horRotEncoder = new AnalogTrigger(RobotMap.horRotEncoderPos);
//    private static AnalogTriggerOutput horRotEncoderOutput = new AnalogTriggerOutput(horRotEncoder, AnalogTriggerOutput.Type.kRisingPulse);
//    private static Counter horRotCounter = new Counter(horRotEncoder, true, true);
    
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
//        horRotEncoder.setLimitsVoltage(0.08, 4.92);
//        horRotCounter.setUpDownCounterMode();
//        horRotCounter.setDownSource(horRotEncoder, AnalogTriggerOutput.Type.kFallingPulse);
//        horRotCounter.setDownSourceEdge(true, true);
//        horRotCounter.setUpSource(horRotEncoder, AnalogTriggerOutput.Type.kRisingPulse);
//        horRotCounter.setUpSourceEdge(true,true);
//        horRotCounter.reset();
//        horRotCounter.start();
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
    
    public int getHorRotations(){
        return magneticencoder.getIntegerCounter();
//        return horRotCounter.get()/2;
    }

    public double getHorRotationsDouble(){
        return magneticencoder.getDoubleCounter();
//        return horRotCounter.get()/2;
    }

}
