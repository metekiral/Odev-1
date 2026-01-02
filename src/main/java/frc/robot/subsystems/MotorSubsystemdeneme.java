package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Volts;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

  public class MotorSubsystemdeneme extends SubsystemBase {
    TalonFX krakenTalonFX = new TalonFX(0);
    TalonFX krakeTalonFX = new TalonFX(1);
    TalonFX krakTalonFX = new TalonFX(2);
    
    VoltageOut m_voltage = new VoltageOut(0);
    DutyCycleOut m_dutyCycle = new DutyCycleOut(0);

    TalonFX m_TalonFX = new TalonFX(3);
    TalonFX m_TalonnFX = new TalonFX(4);
    TalonFX m_TalonFXx = new TalonFX(5);
    
    //sensör
    private final DigitalInput sensor = new DigitalInput(0)

    PositionVoltage m_PositionVoltage = new PositionVoltage(0).withSlot(0);
    MotionMagicVoltage m_MotionMagicVoltage = new MotionMagicVoltage(0);
    VelocityVoltage m_VelocityVoltage = new VelocityVoltage(0).withSlot(0);
    TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration();

    public void MotorSubsystemdeneme() {

      TalonFXConfiguration talonFXConfigs = new TalonFXConfiguration();
          withMotorOutput(
           new MotorOutputConfigs()
              .withInverted(InvertedValue.Clockwise_Positive)
              .withNeutralMode(NeutralModeValue.Brake))
        .withCurrentLimits(
          new CurrentLimitsConfigs()
              .withSupplyCurrentLimit(80)
              .withSupplyCurrentLimitEnable(true));
              
      m_TalonFX.setPosition(0);
  talonFXConfiguration.CurrentLimits.SupplyCurrentLimit = true;
  talonFXConfiguration.CurrentLimits.SupplyCurrentLimit = 80;
    
    talonFXConfiguration.MotorOutput.NeutralMode = NeutralModeValue.Coast;

    public MotorSubsystemdeneme(){

      krakenTalonFX.setNeutralMode(NeutralModeValue.Coast);
      krakeTalonFX.setNeutralMode(NeutralModeValue.Coast);
      krakTalonFX.setNeutralMode(NeutralModeValue.Brake);
  }
  
   
    private TalonFXConfiguration withMotorOutput(MotorOutputConfigs withNeutralMode) {
      throw new UnsupportedOperationException("Unimplemented method 'withMotorOutput'");
    }
    

    TalonFXConfiguration talonFXConfigs = new TalonFXConfiguration();

    public void setVoltage(double voltage) {
      krakeTalonFX.setControl(m_voltage.withOutput(Volts.of(voltage)));
    }  
    
    public void setSpeed(double speed) {
      krakeTalonFX.setControl(m_dutyCycle.withOutput(speed));
    }
@Override
public void periodic() {
  SmartDashboard.putNumber("Motor Sicaklik", getMotorTemp());
    SmartDashboard.putNumber("Motor Pozisyonu", getMotorPos());
    }
    
    private double getMotorTemp() {
    throw new UnsupportedOperationException("Unimplemented method 'getMotorTemp'");
  }
  
    private double getMotorPos() {
    throw new UnsupportedOperationException("Unimplemented method 'getMotorPos'");
  }
    public void setVoltage(int i) {
      throw new UnsupportedOperationException("Unimplemented method 'setVoltage'");
    }
    public void setPosition(int i) {
      throw new UnsupportedOperationException("Unimplemented method 'setPosition'");
    }
    public void setSpeed(int i) {
        throw new UnsupportedOperationException("Unimplemented method 'setSpeed'");
    }
 }
} 
