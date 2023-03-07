

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

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
    frontLeft = new CANSparkMax(DriveConstants.frontLeft, MotorType.kBrushless);
    backLeft = new CANSparkMax(DriveConstants.backLeft, MotorType.kBrushless);
    frontRight = new CANSparkMax(DriveConstants.frontRight, MotorType.kBrushless);
    backRight = new CANSparkMax(DriveConstants.backRight, MotorType.kBrushless);
    

    frontLeft.restoreFactoryDefaults();
    backLeft.restoreFactoryDefaults();
    frontRight.restoreFactoryDefaults();
    backRight.restoreFactoryDefaults();
    
   
    ramp rate is essentially the speed at which a generator can increase or decrease generation. 
    * Generating units have different characteristics 
    making some more suited to supplying certain needed functions.

    //  frontLeft.setOpenLoopRampRate(0.1);
    //  frontRight.setOpenLoopRampRate(0.1);
    //  backleft.setOpenLoopRampRate(0.1);
    //  backRight.setOpenLoopRampRate(0.1);

    frontLeft.setInverted(DriveConstants.frontLeftInverted);
    backLeft.setInverted(DriveConstants.backLeftInverted);
    frontRight.setInverted(DriveConstants.frontRightInverted);
    backRight.setInverted(DriveConstants.backRightInverted);

    leftGroup = new MotorControllerGroup(frontLeft, backLeft);
    rightGroup = new MotorControllerGroup(frontRight, backRight);

    driveTrain = new DifferentialDrive(leftGroup, rightGroup);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //frontLeft.getAppliedOutput();
    //frontRight.getAppliedOutput();
    //frontLeft.getOutputCurrent();
    //frontRight.getOutputCurrent();
    //frontLeft.getBusVoltage();
    //frontRight.getBusVoltage();
    //frontLeft.getStickyFaults();
    //frontRight.getStickyFaults();

  }
  public void drive(DoubleSupplier leftSpeed, DoubleSupplier rightSpeed){
    drive(leftSpeed.getAsDouble(), rightSpeed.getAsDouble());
  }
  public void drive(double leftSpeed, double rightSpeed){
    driveTrain.tankDrive(leftSpeed*DriveConstants.speedFactor, rightSpeed*DriveConstants.speedFactor);
  }
}