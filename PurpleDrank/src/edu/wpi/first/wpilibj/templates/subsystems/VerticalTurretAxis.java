/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.team2035.meta.MetaCommandLog;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.commands.DefaultDriveTrain;
import edu.wpi.first.wpilibj.templates.commands.VerticalTurretRotation;
import edu.wpi.first.wpilibj.templates.commands.VerticalDefaultCommand;

/**
 *
 * @author abbottk
 */
public class VerticalTurretAxis extends Subsystem  {

    private Jaguar VerTurretJag;
    private static MetaCommandLog VerLog;
    private static Gyro gyro1;

    public VerticalTurretAxis(){
        super("VerticalTurretAxis");
        //gyro1 = new Gyro(1 , 2);
        VerLog = new MetaCommandLog("VerticalTurretAxis", "Target Y-value" , "Jaguar");
        VerTurretJag = new Jaguar(RobotMap.VerTurretMotor);
    }
    protected void initDefaultCommand() {
        
        super.setDefaultCommand(new VerticalTurretRotation(RobotMap.VerTurretKp, RobotMap.VerTurretKi, RobotMap.VerTurretKd));
        
    }
    
    public void rotate(double speed){
        VerTurretJag.set(speed);
        VerLog.setOutputs("" + speed);
    }
    
    public static MetaCommandLog getCommandLog(){
        return VerLog;
    }
    
    public static Gyro getGyro1(){
        return gyro1;//
    }
    
}
