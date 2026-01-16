// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class feederSubsystem extends SubsystemBase {
  TalonFX feedermotor = new TalonFX(12);
  VoltageOut m_voltage = new VoltageOut(0);
  DigitalInput m_input = new DigitalInput(0);

  public feederSubsystem() {
    TalonFXConfiguration feederConfig = new TalonFXConfiguration()
        .withMotorOutput(
            new MotorOutputConfigs()
                .withInverted(InvertedValue.CounterClockwise_Positive)
                .withNeutralMode(NeutralModeValue.Brake))
        .withCurrentLimits(
            new CurrentLimitsConfigs()
                .withSupplyCurrentLimit(80)
                .withSupplyCurrentLimitEnable(true));
    feedermotor.getConfigurator().apply(feederConfig);
  }

  public boolean getFeederSensor() {
    return m_input.get();
  }

  public void setFeederVoltage(double voltage){
    feedermotor.setControl(m_voltage.withOutput(Volts.of(voltage)));
  }

  @Override
  public void periodic() {
  }
}