/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author abbottk
 */
public class SetpointRealignment extends CommandBase{

    int Direction;
    
    public SetpointRealignment(int d){
        Direction = d;
    }
    
    protected void initialize() {
    }

    protected void execute() {
        switch (Direction) {
            case RobotMap.realignLeft: RobotMap.cameraXOffset += 1;
                                       break; 
               
            case RobotMap.realignRight: RobotMap.cameraXOffset -= 1;
                                        break;    
                
            case RobotMap.realignCenter: RobotMap.cameraXOffset = RobotMap.defaultCameraOffset;
                                         break;   
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
