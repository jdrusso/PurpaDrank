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
    private double[][] targetArray;
    private int targets;
    
    protected void initialize() {
    }

    protected void execute()
    {
        for(int i = 1; i<=7; i+=2){
            X_values[i] = OI.getMdu().dataMessage[i];
        }
        
        for(int i = 2; i<=8; i+=2){
            Y_values[i] = OI.getMdu().dataMessage[i];
        }
        
        targetArray[0] = new double[]{X_values[0], Y_values[0]};
        targetArray[1] = new double[]{X_values[1], Y_values[1]};
        targetArray[2] = new double[]{X_values[2], Y_values[2]};
        targetArray[3] = new double[]{X_values[3], Y_values[3]};
        
        RobotMap.range = OI.getMdu().dataMessage[0];
        
        sortTargets();
    }

    protected boolean isFinished() {
        return PurpleDrank.getIsDisabled();
    }

    protected void end() {
    }
    
    protected double[][] sortTargets(){
        double[][] sortedArray = new double[4][2];
        double[] x_sort = new double[]{targetArray[0][0], targetArray[1][0], targetArray[2][0], targetArray[3][0]};
        double[] y_sort = new double[]{targetArray[0][1], targetArray[1][1], targetArray[2][1], targetArray[3][1]};
        Arrays.sort(x_sort);
        Arrays.sort(y_sort);
        for (int i = 0; i<4; i++){
            
            if (targetArray[i][1] == y_sort[0]) //find top
                sortedArray[0] = targetArray[i];
        }
        
        for (int i = 0; i<4; i++){
            
            if (targetArray[i][1] == y_sort[3]) //find bottom
                    sortedArray[1] = targetArray[i];
        }
        
        for (int i = 0; i<4; i++){
            
            if (targetArray[i][0] == x_sort[0]) //find left
                    sortedArray[2] = targetArray[i];
        }
        
        for (int i = 0; i<4; i++){
            
            if (targetArray[i][0] == y_sort[3]) //find right
                    sortedArray[3] = targetArray[i];
            }
        
        RobotMap.top = sortedArray[0];
        RobotMap.bottom = sortedArray[1];
        RobotMap.left = sortedArray[2];                 
        RobotMap.right = sortedArray[3];
        return sortedArray;
    }

    protected void interrupted() {
    }   
}