package frc.robot;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.FeederSubsystem;

import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

    private final IntakeSubsystem intake = new IntakeSubsystem();
    private final FeederSubsystem feeder = new FeederSubsystem();

    private final PS5Controller controller = new PS5Controller(0);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {

        new JoystickButton(controller, PS5Controller.Button.kCross.value) //x tusu pas
            .whileTrue(() -> {
                if (feeder.isSensorTriggered()) {
                    intake.stop();
                    feeder.stop();
                } else {
                    intake.runForward();
                    feeder.runForward();
                }
            })
            .onFalse(() -> {	
                intake.stop();
                feeder.stop();
            });


        new JoystickButton(controller, PS5Controller.Button.kCircle.value) //o tusu sut
            .whileTrue(() -> {
                intake.runReverse();
                feeder.runReverse();
            })
            .onFalse(() -> {
                intake.stop();
                feeder.stop();
            });
    }
}
