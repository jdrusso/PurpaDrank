/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.team2035.meta.MetaCommandLog;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.HorizontalTurretRotation;
import edu.wpi.first.wpilibj.templates.commands.HorizontalDefaultCommand;
import edu.wpi.first.wpilibj.templates.commands.VerticalDefaultCommand;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.AnalogTriggerOutput;

/**
 *
 * @author abbottk
 */
public class HorizontalTurretAxis extends Subsystem{
    private Jaguar HorTurretJag;
    private static MetaCommandLog HorLog;
    private static AnalogTrigger horRotEncoder = new AnalogTrigger(RobotMap.horRotEncoderPos);
    //private static AnalogTriggerOutput horRotEncoderOutput = new AnalogTriggerOutput(horRotEncoder, AnalogTriggerOutput.Type.kRisingPulse);
    private static Counter horRotCounter = new Counter(horRotEncoder, true, false);
    
    public HorizontalTurretAxis(){
        super("HorizontalTurretAxis");
        HorLog = new MetaCommandLog("HorizontalTurretAxis", "Target X-value" , "Jaguar");
        HorTurretJag = new Jaguar(RobotMap.HorTurretMotor);
    }
    protected void initDefaultCommand() {
        HorLog.setCommand("Default");//
        super.setDefaultCommand(new HorizontalTurretRotation(RobotMap.HorTurretKp, RobotMap.HorTurretKi, RobotMap.HorTurretKd));
        horRotCounter.setDownSource(horRotEncoder, AnalogTriggerOutput.Type.kFallingPulse);
        horRotCounter.setDownSourceEdge(false, true);
        horRotCounter.setUpSource(horRotEncoder, AnalogTriggerOutput.Type.kRisingPulse);
        horRotCounter.setUpSourceEdge(true, false);
        horRotCounter.reset();
        horRotCounter.start();
    }
    
    public void rotate(double speed){
        HorTurretJag.set(speed);
        HorLog.setOutputs("" + speed);
        
    }
    
    public static MetaCommandLog getCommandLog(){
        return HorLog;
    }
    
    public double getHorRotations(){
        
        return horRotCounter.get();
    }
    
}
