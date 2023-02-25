// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.subDriveTrain;
import frc.robot.subsystems.subPneumatics;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  private final CommandXboxController m_driverOne = new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final subDriveTrain driveTrain = new subDriveTrain(); 
  private final subPneumatics george = new subPneumatics();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    driveTrain.setDefaultCommand(Commands.run(() -> driveTrain.drive(
      () -> MathUtil.applyDeadband(-m_driverOne.getLeftY(), 0.06), 
      () -> MathUtil.applyDeadband(-m_driverOne.getRightY(), 0.06)),
      driveTrain));
    m_driverOne.a().onTrue(new InstantCommand(() -> george.clawTiltSolenoid.set(Value.kForward)));
    m_driverOne.a().onFalse(new InstantCommand(() -> george.clawTiltSolenoid.set(Value.kOff)));
    m_driverOne.x().onTrue(new InstantCommand(() -> george.clawTiltSolenoid.set(Value.kReverse)));
    m_driverOne.x().onFalse(new InstantCommand(() -> george.clawTiltSolenoid.set(Value.kOff)));
    m_driverOne.y().onTrue(new InstantCommand(() -> george.clawActuator.set(Value.kForward)));
    m_driverOne.y().onFalse(new InstantCommand(() -> george.clawActuator.set(Value.kOff)));
    m_driverOne.b().onTrue(new InstantCommand(() -> george.clawActuator.set(Value.kReverse)));
    m_driverOne.b().onFalse(new InstantCommand(() -> george.clawActuator.set(Value.kOff)));
    m_driverOne.rightBumper().onTrue(new InstantCommand(() -> george.liftSolenoid.toggle()));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new InstantCommand();
  }
}
