package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intakeSubsystem extends SubsystemBase {
  TalonFX intake1 = new TalonFX(10);
  TalonFX intake2 = new TalonFX(11);
  VoltageOut m_voltage = new VoltageOut(0);

  public intakeSubsystem() {
    TalonFXConfiguration intakeConfigL = new TalonFXConfiguration()
        .withMotorOutput(
            new MotorOutputConfigs()
                .withInverted(InvertedValue.Clockwise_Positive)
                .withNeutralMode(NeutralModeValue.Coast))
        .withCurrentLimits(
            new CurrentLimitsConfigs()
                .withSupplyCurrentLimit(80)
                .withSupplyCurrentLimitEnable(true));

    TalonFXConfiguration intakeConfigR = new TalonFXConfiguration()
        .withMotorOutput(
            new MotorOutputConfigs()
                .withInverted(InvertedValue.CounterClockwise_Positive)
                .withNeutralMode(NeutralModeValue.Coast))
        .withCurrentLimits(
            new CurrentLimitsConfigs()
                .withSupplyCurrentLimit(80)
                .withSupplyCurrentLimitEnable(true));

    intake1.getConfigurator().apply(intakeConfigL);
    intake2.getConfigurator().apply(intakeConfigR);
}

  public void setIntakeVoltage(double voltage){
    intake1.setControl(m_voltage.withOutput(Volts.of(voltage)));
    intake2.setControl(m_voltage.withOutput(Volts.of(voltage)));
}

  @Override
  public void periodic() {
  }
}