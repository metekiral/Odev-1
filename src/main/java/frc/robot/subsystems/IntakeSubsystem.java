package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private final TalonFX rightIntakeMotor = new TalonFX(1);
    private final TalonFX leftIntakeMotor  = new TalonFX(2);

    public IntakeSubsystem() {

        rightIntakeMotor.setNeutralMode(NeutralModeValue.Coast);
        leftIntakeMotor.setNeutralMode(NeutralModeValue.Coast);

        rightIntakeMotor.setInverted(false); 
        leftIntakeMotor.setInverted(true);   
    }

    public void runForward() {
        rightIntakeMotor.setVoltage(5);
        leftIntakeMotor.setVoltage(5);
    }

    public void runReverse() {
        rightIntakeMotor.setVoltage(-5);
        leftIntakeMotor.setVoltage(-5);
    }

    public void stop() {
        rightIntakeMotor.set(0);
        leftIntakeMotor.set(0);
    }
}
