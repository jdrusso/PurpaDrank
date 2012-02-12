/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import com.sun.squawk.util.Arrays;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.PurpleDrank;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author jrusso
 */
public class TargetSorting extends CommandBase {

    private double[] X_values = new double[4];
    private double[] Y_values = new double[4];
    private double[][] targetArray = new double [4][2];
    private int targets;
    private int validTargets;
    
    protected void initialize() {
    }

    protected void execute()
    {
        validTargets = 0;
        
        for(int i = 1; i<=4; i++){
            
            X_values[(i-1)] = OI.getMdu().dataMessage[((i*2)-1)];
        }
        
        for(int i = 1; i<=4; i++){
            
            Y_values[(i-1)] = OI.getMdu().dataMessage[(i*2)];
        }
        
        if ((X_values[0] > 0) || (Y_values[0] > 0)){
            
            targetArray[validTargets][0] = truncate(X_values[validTargets]);
            targetArray[validTargets][1] = truncate(Y_values[validTargets]);
            validTargets++;
        } 
        if ((X_values[1] > 0) || (Y_values[1] > 0)){
            
            targetArray[validTargets][0] = truncate(X_values[validTargets]);
            targetArray[validTargets][1] = truncate(Y_values[validTargets]);
            validTargets++;
        } 
        if ((X_values[2] > 0) || (Y_values[2] > 0)){
            
            targetArray[validTargets][0] = truncate(X_values[validTargets]);
            targetArray[validTargets][1] = truncate(Y_values[validTargets]);
            validTargets++;
        } 
        if ((X_values[3] > 0) || (Y_values[3] > 0)){
            
            targetArray[validTargets][0] = truncate(X_values[validTargets]);
            targetArray[validTargets][1] = truncate(Y_values[validTargets]);
            validTargets++;
        }

        if (OI.getMdu().dataMessage[0] < 5300)
            RobotMap.range = truncate(OI.getMdu().dataMessage[0]);
        else
            RobotMap.range = 0;
        
        sortTargets();
        
        RobotMap.ultrasonicRange = PurpleDrank.getShooterController().getUltrasonicRange();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
    
    protected double[][] sortTargets(){

        double[][] sortedArray = new double[4][2];
        double[] x_sort = new double[]{0, 0, 0, 0};//{targetArray[0][0], targetArray[1][0], targetArray[2][0], targetArray[3][0]};
        for (int i = 0; i < validTargets; i++){
            
            x_sort[i] = targetArray[i][0];
        }
        double[] y_sort = new double[]{0, 0, 0, 0};//{targetArray[0][1], targetArray[1][1], targetArray[2][1], targetArray[3][1]};
        for (int i = 0; i < validTargets; i++){
            
            y_sort[i] = targetArray[i][1];
        }
        Arrays.sort(x_sort);
        Arrays.sort(y_sort);
        for (int i = 0; i<validTargets; i++){

            if (targetArray[i][1] == y_sort[0]){ //find top
                sortedArray[0][0] = targetArray[i][0];
                sortedArray[0][1] = targetArray[i][1];
            }
        }

        for (int i = 0; i<validTargets; i++){

            if (targetArray[i][1] == y_sort[validTargets-1]){ //find bottom
                sortedArray[1][0] = targetArray[i][0];
                sortedArray[1][1] = targetArray[i][1];
            }
        }

        for (int i = 0; i<validTargets; i++){

            if (targetArray[i][0] == x_sort[0]){ //find left
                sortedArray[2][0] = targetArray[i][0];
                sortedArray[2][1] = targetArray[i][1];
            }
        }

        for (int i = 0; i<validTargets; i++){

            if (targetArray[i][0] == x_sort[validTargets-1]){ //find right
                sortedArray[3][0] = targetArray[i][0];
                sortedArray[3][1] = targetArray[i][1];
            }
        }

        System.out.println("Targets sorted!" + truncate(sortedArray[0][0]) + ", " + validTargets);
        RobotMap.top[0] = sortedArray[0][0];
        RobotMap.top[1] = sortedArray[0][1];
        RobotMap.bottom[0] = sortedArray[1][0];
        RobotMap.bottom[1] = sortedArray[1][0];
        RobotMap.left[0] = sortedArray[2][0];                 
        RobotMap.left[1] = sortedArray[2][1];                 
        RobotMap.right[0] = sortedArray[3][0];
        RobotMap.right[1] = sortedArray[3][1];
        return sortedArray;
    }

    protected void interrupted() {
    }   
    
    public double truncate(double d){

        int temp = (int)(d*1000);
        double result = (double)temp/1000;
        return result;
    }
}