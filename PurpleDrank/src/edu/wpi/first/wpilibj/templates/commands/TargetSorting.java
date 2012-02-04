/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.team2035.meta.MetaTCPVariables;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author abbottk
 */
public class TargetSorting extends CommandBase {

    private double[] X_values = new double[4];
    private double[] Y_values = new double[4];//
    private int targets;
    private int left;
    private int right;
    private int bottom;
    private int top;
    private boolean noHigh;
    private boolean noLow;
    private boolean noLeft;
    private boolean noRight;
    
    protected void initialize() {
    }

    protected void execute() {
        for(int i = 0; i<4; i++){
            X_values[i] = MetaTCPVariables.dataMessage[i];            
        }
        
        for(int i = 5; i<8; i++){
            X_values[i] = MetaTCPVariables.dataMessage[i];
        }
        
        RobotMap.range = MetaTCPVariables.dataMessage[9];
        
        viableTargets();
        if(targets >= 3){
            RobotMap.isBottom = true;
            RobotMap.isTop = true;
            RobotMap.isLeft = true;
            RobotMap.isRight = true;
            sortYValues(); 
            sortXValues();
        }
        
        RobotMap.Ty = Y_values[top];
        RobotMap.Tx = X_values[top];
        RobotMap.By = Y_values[bottom];
        RobotMap.Bx = X_values[bottom];
        RobotMap.Ly = Y_values[left];
        RobotMap.Lx = X_values[left];
        RobotMap.Ry = Y_values[right];
        RobotMap.Rx = X_values[right];     
        
        
        
    }

    protected boolean isFinished() {
        return PurpleDrank.getIsDisabled();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    protected void viableTargets(){
        int numTargets = 0;
        for(int i = 0; i < X_values.length; i++){
            if(X_values[i] != 0){
                numTargets += 1;
            }
        }
        
        if (numTargets < 3){
            RobotMap.isBottom = false;
            RobotMap.isTop = false;
            RobotMap.isLeft = false;
            RobotMap.isRight = false;
            return;
        }
        
        else if(numTargets == 3){
            targets = 3;
            return;
        }
        
        else if(numTargets == 4){
            targets = 4;
            return;
        }
        
    }
    
    protected void sortYValues(){
        
        int top = 0;
        int bottom = 0;
        for (int i = 1; i < 4; i++){
            if(Y_values[i] > Y_values[bottom]){                   
                bottom = i; 
            }
            if(Y_values[i] < Y_values[top]){
               top = i; 
            }            
        }    
    }
    
    protected void sortXValues(){
        
        left = 0;
        right = 0;
        for (int i = 1; i < 4; i++){
            if(X_values[i] > X_values[right]){                   
                right = i; 
            }
            if(Y_values[i] < Y_values[left]){
               left = i; 
            }            
        }    
    }
}
