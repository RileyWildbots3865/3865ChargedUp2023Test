

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class subDriveTrain extends SubsystemBase {
  public CANSparkMax frontLeft;
  public CANSparkMax backLeft;
  public CANSparkMax frontRight;
  public CANSparkMax backRight;
  public DifferentialDrive driveTrain;
  public MotorControllerGroup leftGroup;
  public MotorControllerGroup rightGroup;

  /** Creates a new subDriveTrain. */
  public subDriveTrain() {
    frontLeft = new CANSparkMax(DriveConstants.frontLeft, MotorType.kBrushed);
    backLeft = new CANSparkMax(DriveConstants.backLeft, MotorType.kBrushed);
    frontRight = new CANSparkMax(DriveConstants.frontRight, MotorType.kBrushed);
    backRight = new CANSparkMax(DriveConstants.backRight,MotorType.kBrushed);

    frontLeft.restoreFactoryDefaults();
    backLeft.restoreFactoryDefaults();
    frontRight.restoreFactoryDefaults();
    backRight.restoreFactoryDefaults();

    frontLeft.setInverted(DriveConstants.frontLeftInverted);
    backLeft.setInverted(DriveConstants.backLeftInverted);

    leftGroup = new MotorControllerGroup(frontLeft, backLeft);
    rightGroup = new MotorControllerGroup(frontRight, backRight);

    driveTrain = new DifferentialDrive(leftGroup, rightGroup);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void drive(double leftSpeed, double rightSpeed){
    driveTrain.tankDrive(leftSpeed*DriveConstants.speedFactor, rightSpeed*DriveConstants.speedFactor);
  }
}
