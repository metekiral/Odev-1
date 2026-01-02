package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FeederSubsystem extends SubsystemBase {

    private final TalonFX feederMotor = new TalonFX(3);
    private final DigitalInput sensor = new DigitalInput(0);

    public FeederSubsystem() {

        feederMotor.setNeutralMode(NeutralModeValue.Brake);
        feederMotor.setInverted(true); 

        Shuffleboard.getTab("Feeder")
            .addBoolean("Sensor State", this::isSensorTriggered);
    }

    public boolean isSensorTriggered() {
        return sensor.get();
    }

    public void runForward() {
        feederMotor.setVoltage(5);
    }

    public void runReverse() {
        feederMotor.setVoltage(-5);
    }

    public void stop() {
        feederMotor.set(0);
    }
}
