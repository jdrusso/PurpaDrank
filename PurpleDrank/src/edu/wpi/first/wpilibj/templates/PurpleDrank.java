/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.team2035.meta.MetaLog;
import edu.team2035.meta.MetaTCPVariables;
import edu.team2035.meta.MetaTimer;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.DriverStationLCD.Line;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.subsystems.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class PurpleDrank extends IterativeRobot {

    Command autonomousCommand;
    private static DriveTrain DriveTrain;
    private static HorizontalTurretAxis HorizontalAxis;
    private static VerticalTurretAxis VerticalAxis;
    private static Shooter shooterController;
    private MetaTimer timer;
    private MetaTCPVariables metaTable;
    private static BalancingManual manualBalance;
    private static DriverStationLCD display;
    private static boolean isDisabled;
    private static TargetSorting targetSort;
    private static RampController ramp;
    private static Elevator elevator;
    private static BallCollector ballCollector;
    private static Shooter shooter;
    private double shooterSpeed;
    private Timer t;
    private boolean acting;
    
    public static DriveTrain getDriveTrain(){
        
        return DriveTrain;
    }
    
    public static HorizontalTurretAxis getHorizontalTurretAxis(){
        
        return HorizontalAxis;
    }
    public static VerticalTurretAxis getVerticalTurretAxis(){
        
        return VerticalAxis;
    }
    
    public static Shooter getShooterController(){
        return shooterController;
    }
    
    public static boolean getIsDisabled(){
        return isDisabled;
    }   
    
    public static Elevator getElevator(){
        return elevator;
    }  
    
    public static BallCollector getBallCollector(){
        
        return ballCollector;
    }

    /**
     * @return the ramp
     */
    public static RampController getRamp() {
        return ramp;
    }
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        timer = new MetaTimer();
        autonomousCommand = new WinAutonomous();
        DriveTrain = new DriveTrain();
        HorizontalAxis = new HorizontalTurretAxis();
        VerticalAxis = new VerticalTurretAxis();   
        shooterController = new Shooter();
        ballCollector = new BallCollector();
        elevator = new Elevator();
        ramp = new RampController();
        display = DriverStationLCD.getInstance();
        OI.initialize();
        display.updateLCD();
        display.println(Line.kMain6, 1, "Initializing...                      ");
        display.println(Line.kUser2, 1, "                                     ");
        display.println(Line.kUser3, 1, "                                     ");
        display.println(Line.kUser4, 1, "                                     ");
        display.println(Line.kUser5, 1, "                                     ");
        display.println(Line.kUser6, 1, "                                     ");
        metaTable = OI.getMdu();
        display.updateLCD();
        targetSort = new TargetSorting();
        t = new Timer();
//        RobotMap.motor.setDirection(Relay.Direction.kBoth);
//        RobotMap.motor.set(Relay.Value.kOff);

        // Initialize all subsystems
        //CommandBase.init();
    }
    public void disabledInit(){
        
        System.out.println("Entering disabled...");
    }
    public void disabledPeriodic(){
        MetaLog.closeLog();
        isDisabled = true;
 
        display.updateLCD();
        
        display.println(Line.kUser2, 1, "" + RobotMap.range      + ", " + metaTable.getConnections() + "                 ");
        display.println(Line.kUser3, 1, "" + RobotMap.top[0]     + ", " + RobotMap.top[1]            + "                 ");
        display.println(Line.kUser4, 1, "" + RobotMap.right[0]   + ", " + RobotMap.right[1]          + "                 ");
        display.println(Line.kUser5, 1, "" + RobotMap.bottom[0]  + ", " + RobotMap.bottom[1]         + "                 ");
        display.println(Line.kUser6, 1, "" + RobotMap.left[0]    + ", " + RobotMap.left[1]           + "                 ");
        display.println(Line.kMain6, 1, "Program is running... " + HorizontalAxis.getHorRotations());
        display.updateLCD();
        
        //System.out.println(HorizontalAxis.getHorRotations());
    }
    public void autonomousInit() {
        //if(targetSort.isRunning())
        //    targetSort.cancel();
        //targetSort.start();
        t.reset();
        t.start();
        acting = false;
        // schedule the autonomous command (example)
        System.out.println("Entering Autonomous...");              
        display.println(Line.kUser2, 1, "                                     ");
        display.println(Line.kUser3, 1, "                                     ");
        display.println(Line.kUser4, 1, "                                     ");
        display.println(Line.kUser5, 1, "                                     ");
        display.println(Line.kUser6, 1, "                                     ");
    }
    
    public void autonomousContinuous(){
        
        WinAutonomous();
        //System.out.println(t.get());
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        //if(targetSort.isRunning())
        //    targetSort.cancel();
        //targetSort.start();
        t.stop();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to 
		// continue until interrupted by another command, remove
		// this line or comment it out.
        targetSort.start();
        isDisabled = false;
        System.out.println("Entering TeleOp...");              
        display.println(Line.kUser2, 1, "                                     ");
        display.println(Line.kUser3, 1, "                                     ");
        display.println(Line.kUser4, 1, "                                     ");
        display.println(Line.kUser5, 1, "                                     ");
        display.println(Line.kUser6, 1, "                                     ");
        shooterSpeed = 0.0;
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	shooterSpeed = RobotMap.defaultShooterSpeed;
        MetaLog.update();
        Scheduler.getInstance().run();//
        
        //FRCControl.setErrorData("test error".getBytes(), "test error".length(), 100);
        //display.println(Line.kUser2, 1, "" +   correctRange()   + ", " + metaTable.getConnections() + "                 ");
        display.println(Line.kUser3, 1, "Top: " + RobotMap.top[0]    + ", " + RobotMap.top[1]            + "                 ");
        //display.println(Line.kUser4, 1, "" + RobotMap.right[0]  + ", " + RobotMap.right[1]          + "                 ");
        //display.println(Line.kUser5, 1, "" + RobotMap.bottom[0] + ", " + RobotMap.bottom[1]         + "                 ");
        //display.println(Line.kUser6, 1, "" + RobotMap.left[0]   + ", " + RobotMap.left[1]           + "                 ");
        //display.println(Line.kMain6, 1, "Program is running...");
        display.println(Line.kUser2, 1, "Shoot Speed: " + (RobotMap.defaultShooterSpeed) + "                                      ");
        display.println(Line.kMain6, 1, "H/V Rot: " + truncate(HorizontalAxis.getHorRotationsDouble()) + ", " + truncate(VerticalAxis.getVerRotationsDouble()) + "                      ");
        display.println(Line.kUser4, 1, "Shooter Period: " + shooterController.getRotationsPeriod() + "                 ");
        
        display.updateLCD();
//        if (RobotMap.dButton10.get())
//            RobotMap.motor.set(Relay.Value.kForward);
//        if (RobotMap.dButton11.get())
//            RobotMap.motor.set(Relay.Value.kReverse);
//        else if (!RobotMap.dButton10.get() && !RobotMap.dButton11.get())
//            RobotMap.motor.set(Relay.Value.kOff);
        
//        System.out.println("Rotations: " + HorizontalAxis.getHorRotations());
        
        if (RobotMap.shootTrigger.get()) {
            
            shooterController.LeftJaguar.set(shooterSpeed);
            shooterController.RightJaguar.set(shooterSpeed);
        }
        else {
            shooterController.LeftJaguar.set(0.0);
            shooterController.RightJaguar.set(0.0);
        }
        
        new ChangeShooterSpeed('j').start();
        System.out.println("Rots: " + truncate(VerticalAxis.getVerRotationsDouble()) + ", " + truncate(shooterController.getRotationsDouble()));
    }
    
    public double truncate(double d){
        
        int temp = (int)(d*1000);
        double result = (double)temp/1000;
        return result;
    }
    
    public double correctRange(){
        
        double x = RobotMap.range;
        return x+((0.0053*(x*x))+(0.0026*x)+0.2168); //We made this using a trendline in Excel and empirical test results with a polynomial fit
    }
    
    public void WinAutonomous(){
        double shootSpeed = RobotMap.autonomousSpeed;
        
        if(!acting)
        {
            getShooterController().LeftJaguar.set(shootSpeed);
            getShooterController().RightJaguar.set(shootSpeed);
        }
            
        if(t.get() > 3.0 && t.get() < 11.5)
        {
            
            if(!acting)
            {
                new BallCollectionOn().start();
                new ElevatorUp().start();
                acting = true;
            }
        }
        
        if(t.get() > 12)
        {
            System.out.println("OFF");
            new BallCollectionOff().start();
            new ElevatorOff().start();
            getShooterController().LeftJaguar.set(0.0);
            getShooterController().RightJaguar.set(0.0);
        }
    }
}