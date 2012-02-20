/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.team2035.meta.MetaCommandLog;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.MagneticEncoder;
import edu.wpi.first.wpilibj.templates.RobotMap;


/**
 *
 * @author abbottk
 */
public class VerticalTurretAxis extends Subsystem  {

  private Jaguar VerTurretJag;
//    private Relay VerTurretSpike;
    private static MetaCommandLog VerLog;
    private static Gyro gyro1;

    private static MagneticEncoder magneticencoder = new MagneticEncoder(RobotMap.verRotEncoderPos);

    public VerticalTurretAxis(){
        super("VerticalTurretAxis");
        //gyro1 = new Gyro(1 , 2);
        VerLog = new MetaCommandLog("VerticalTurretAxis", "Target Y-value" , "Jaguar");
        VerTurretJag = new Jaguar(RobotMap.VerTurretMotor);
        //this.VerTurretSpike = RobotMap.VerTurretMotorSpike;
    }
    protected void initDefaultCommand() {
        
        //super.setDefaultCommand(new VerticalTurretRotation(RobotMap.VerTurretKp, RobotMap.VerTurretKi, RobotMap.VerTurretKd));
        
    }
    
    public void rotate(double speed){
        VerTurretJag.set(speed);
        VerLog.setOutputs("" + speed);
//        if (speed > 0.1)
//            VerTurretSpike.set(Relay.Value.kForward);
//        else if (speed < 0.1)
//            VerTurretSpike.set(Relay.Value.kReverse);
//        else 
//            VerTurretSpike.set(Relay.Value.kOff);
    }
    
    public static MetaCommandLog getCommandLog(){
        return VerLog;
    }
    
    public static Gyro getGyro1(){
        return gyro1;//
    }

    /** Vertical rotations
     *
     * @return the integer number of complete rotations by the magnetic
     * encoder.
     */
    public int getVerRotations(){
        return magneticencoder.getIntegerCounter();
    }

    /**
     * This is not fully tested yet.
     * @return
     */
    public double getVerRotationsDouble(){
        return magneticencoder.getDoubleCounter();
    }
    
}
