/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Skeleton;
import edu.wpi.first.wpilibj.KinectStick;

/**
 *
 * @author jrusso
 */
public class Kinect extends Subsystem {
    KinectStick leftArm = new KinectStick(1);
    KinectStick rightArm = new KinectStick(2);

    //moving left arm controls robot speed, down speeds up
    public double getKinectY(){
        
        return -leftArm.getY();
    }
    
    //Moving right arm controls robot turning
    public double getKinectX(){
        
        return -rightArm.getY();
    }
    
    public double getKinectTankDriveRight(){
        
        return -rightArm.getY();
    }
    
    public double getKinectTankDriveLeft(){
        
        return -leftArm.getY();
    }
    
    //Returns true if head is turned to the right
    public boolean getRightLegOut(){
        
        return leftArm.getRawButton(3);
    }
 
    //True if arms are detectable
    public boolean kinectIsEnabled(){
        
        return leftArm.getRawButton(9);
    }
    
    public void initDefaultCommand() {
        
    }
}