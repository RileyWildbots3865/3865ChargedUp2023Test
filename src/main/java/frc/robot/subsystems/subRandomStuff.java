// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RandomStuff;

public class subRandomStuff extends SubsystemBase {
  public CANSparkMax clawMotor;
  public subRandomStuff() {
    clawMotor = new CANSparkMax(RandomStuff.clawMotor, MotorType.kBrushless);
    
    clawMotor.restoreFactoryDefaults();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
