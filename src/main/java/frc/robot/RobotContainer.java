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
  private final JoysCommandXboxControllertick CommandXboxController = new Joystick(OperatorConstants.kPneumaticsControllerPort);
  private final subDriveTrain driveTrain = new subDriveTrain(); 
  private final subPneumatics george = new subPneumatics();

  public JoystickButton liftSolenoid = new JoystickButton(playstick, 1);
  public JoystickButton clawTiltSolenoid = new JoystickButton(playstick, 4);
  public JoystickButton clawTiltSolenoid = new JoystickButton(playstick, 2);
  public JoystickButton clawActuator = new JoystickButton(playstick, 3);
  public JoystickButton clawActuator = new JoystickButton(playstick, 5);
  //public JoystickButton reverseConveyorButton = new JoystickButton(playstick, 6);

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
    m_driverTwo.a().onTrue(new InstantCommand(() -> george.clawTiltSolenoid.set(Value.kForward)));
    m_driverTwo.a().onFalse(new InstantCommand(() -> george.clawTiltSolenoid.set(Value.kOff)));
    m_driverTwo.x().onTrue(new InstantCommand(() -> george.clawTiltSolenoid.set(Value.kReverse)));
    m_driverTwo.x().onFalse(new InstantCommand(() -> george.clawTiltSolenoid.set(Value.kOff)));
    m_driverTwo.y().onTrue(new InstantCommand(() -> george.clawActuator.set(Value.kForward)));
    m_driverTwo.y().onFalse(new InstantCommand(() -> george.clawActuator.set(Value.kOff)));
    m_driverTwo.b().onTrue(new InstantCommand(() -> george.clawActuator.set(Value.kReverse)));
    m_driverTwo.b().onFalse(new InstantCommand(() -> george.clawActuator.set(Value.kOff)));
    m_driverTwo.rightBumper().onTrue(new InstantCommand(() -> george.liftSolenoid.toggle()));


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
