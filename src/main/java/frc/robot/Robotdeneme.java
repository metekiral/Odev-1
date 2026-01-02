package frc.robot;

import org.ejml.dense.row.linsol.qr.AdjLinearSolverQr_DDRM;

import com.ctre.phoenix6.configs.VoltageConfigs;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Robotdeneme extends TimedRobot{
    private static final String motorSubsystem = null;
        private final TalonFX m_leftMotorTalonFX = new TalonFX(0);
        private final TalonFX m_rightMotorTalonFX = new TalonFX(1);
        private final TalonFX m_right2MotorTalonFX = new TalonFX(2);
        
        MotorControllerGroup m_right = new MotorControllerGroup(m_rightMotorTalonFX , m_right2MotorTalonFX);

        private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_rightMotorTalonFX, m_right2MotorTalonFX);
        private final Joystick m_1buttonJoystick = new Joystick(0);

        private final Robotdeneme m_robotContainer;
       PS5Controller driverJoystick = new PS5Controller(0);
    
    public Robotdeneme(){
            m_robotContainer = new Robotdeneme();
        }
    @Override
    public void teleopPeriodic(){
        if(driverJoystick.getRawButton(1)){
            Robot2.motorSubsystem.setVoltage(5);
            Robot2.motorSubsystem.setPosition(100);
        }else if(driverJoystick.getRawButton(2)){
         Robotdeneme.motorSubsystem.setVoltage(-5);
    }else{
        Robotdeneme.motorSubsystem.setVoltage(0);
    }       
}
}