// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants.PneumaticConstants;

public class subPneumatics extends SubsystemBase {
  // Creates a new subPneumatics. 
  public Solenoid liftSolenoid;
  public DoubleSolenoid clawTiltSolenoidleft;
  public DoubleSolenoid clawTiltSolenoidright;
  public DoubleSolenoid clawActuatorleft;
  public DoubleSolenoid clawActuatorright;



  public subPneumatics() {
    liftSolenoid = new Solenoid(PneumaticConstants.liftSolenoid, PneumaticsModuleType.CTREPCM, 0);
    clawTiltSolenoidleft = new DoubleSolenoid(PneumaticConstants.clawTiltSolenoidright, PneumaticsModuleType.CTREPCM, 1,2);
    clawTiltSolenoidright = new DoubleSolenoid(PneumaticConstants.clawTiltSolenoidright, PneumaticsModuleType.CTREPCM, 3,4);
    clawActuatorleft = new DoubleSolenoid(PneumaticConstants.clawActuatorleft, PneumaticsModuleType.CTREPCM, 5,6);
    clawActuatorright = new DoubleSolenoid(PneumaticConstants.clawActuatorright, PneumaticsModuleType.CTREPCM, 7,8);
  }
  
  public void extend_lift() {
    liftSolenoid.set(true);
  }

  public void retract_lift() {
    liftSolenoid.set(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
