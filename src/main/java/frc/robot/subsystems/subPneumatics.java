// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants.PneumaticConstants;

public class subPneumatics extends SubsystemBase {
  // Creates a new subPneumatics. 
  public Solenoid liftSolenoid;
  public DoubleSolenoid clawTiltSolenoid;
  public DoubleSolenoid clawActuator;
  public Compressor myCompressor;



  public subPneumatics() {
    myCompressor = new Compressor(PneumaticsModuleType.CTREPCM);
    myCompressor.enableDigital();
    liftSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, PneumaticConstants.liftSolenoid);
    //liftSolenoid = new Solenoid(PneumaticConstants.liftSolenoid, PneumaticsModuleType.CTREPCM, 0);
    clawTiltSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);// = new DoubleSolenoid(PneumaticConstants.clawTiltSolenoidright, PneumaticsModuleType.CTREPCM, 0,1);
    //clawTiltSolenoidright = new DoubleSolenoid(PneumaticConstants.clawTiltSolenoidright, PneumaticsModuleType.CTREPCM, 2,3);
    //clawActuatorleft = new DoubleSolenoid(PneumaticConstants.clawActuatorleft, PneumaticsModuleType.CTREPCM, 4,5);
    //clawActuatorright = new DoubleSolenoid(PneumaticConstants.clawActuatorright, PneumaticsModuleType.CTREPCM, 6,7);
  }
  
  public void extend_lift() {
    liftSolenoid.set(true);
  }

  public void retract_lift() {
    liftSolenoid.set(false);
  }

  @Override
  public void periodic() {
    //System.out.println(myCompressor.getPressureSwitchValue() + " - " + myCompressor.isEnabled());
    // This method will be called once per scheduler run
  }
}
