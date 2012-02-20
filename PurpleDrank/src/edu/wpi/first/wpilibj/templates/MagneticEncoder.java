/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST Team 2035, 2012. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.AnalogTriggerOutput;
import edu.wpi.first.wpilibj.Counter;

/** Magnetic Encoder implementation.
 *
 * @author jrusso
 */
public class MagneticEncoder {
    
    private static double VOLTAGE_MAX = 5.12;
    public AnalogChannel channel;
    public AnalogTrigger trigger;
    public Counter counter;
    public MagneticEncoder(int triggerAnalogInput) {
        channel = new AnalogChannel(triggerAnalogInput);
        trigger = new AnalogTrigger(channel);
        counter = new Counter(trigger, true, true);    
        trigger.setLimitsVoltage(0.08, 4.92);
        counter.setUpDownCounterMode();
        counter.setDownSource(trigger, AnalogTriggerOutput.Type.kFallingPulse);
        counter.setDownSourceEdge(true, true);
        counter.setUpSource(trigger, AnalogTriggerOutput.Type.kRisingPulse);
        counter.setUpSourceEdge(true,true);
        counter.reset();
        counter.start();
    }
    
    /**
     * 
     * @return the integer value of the magnetic encoder.  For example, will
     * return 5 for any rotation between 5 and 6 turns.
     */
    public int getIntegerCounter()
    {
        return counter.get()/2;
    }
    
    /**
     * 
     * @return the double value of the magnetic encoder.  For example, will 
     * return 5.25 for 5 complete turns and a quarter turn. 
     */
    public double getDoubleCounter()
    {
        // we can improve the estimate.
        double voltage = channel.getVoltage();
        if (voltage > VOLTAGE_MAX)
            VOLTAGE_MAX = voltage;
        
        return (double)truncate((counter.get()/2) + voltage/VOLTAGE_MAX);
    }
    
 
    private double truncate(double d){
        
        int temp = (int)(d*1000);
        double result = (double)temp/1000;
        return result;
    }
}
