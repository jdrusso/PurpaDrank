
package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;

public class OI {
    // Process operator interface input here.
    private Joystick Joystick1;
    private Joystick Joystick2;
    private Button Balance;
    private DriveTrain DriveTrain;
    
    public OI() {
        DriveTrain = PurpleDrank.getDriveTrain();
        //Joystick1 = DriveTrain.getJoystick1();
        //Joystick2 = DriveTrain.getJoystick2();
        AutoBalancing h = new AutoBalancing(.25/40, 0, .1/20); 
        h.start();
        //Balance = new JoystickButton( Joystick1, 4);
        //Balance.whileHeld(new ManualBalancing());
        //Balance.whenReleased(new AutoBalancing(.25/40, 0, .1/20));
    
}
}

