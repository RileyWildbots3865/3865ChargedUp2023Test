// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.subDriveTrain;

public class autoCrossLine extends CommandBase {
  subDriveTrain driveTrain;
  Timer time;
  public autoCrossLine(subDriveTrain driveTrain) {
    this.driveTrain = driveTrain;
    addRequirements(driveTrain);
    time = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time.reset();
    time.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!time.hasElapsed(3)) {
      driveTrain.drive(-0.5, -0.5);
    } else {
      driveTrain.drive(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return time.hasElapsed(4) ? true : false;
  }
}
