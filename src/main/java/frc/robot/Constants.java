

package frc.robot;

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class DriveConstants{
    public static final int frontLeft = 15;
    public static final boolean frontLeftInverted = true;
    public static final int backLeft = 1;
    public static final boolean backLeftInverted = true;
    public static final int frontRight =13;
    public static final boolean frontRightInverted = false;
    public static final int backRight = 3;
    public static final boolean backRightInverted = false;
    public static final double speedFactor = 0.8;

  
  }
  public static class PneumaticConstants{
    public static final int LiftSolenoid = 1;
    public static final int clawTiltSolenoidleft = 2;
    public static final int clawTiltSolenoidright = 3;
    public static final int clawActuatorleft = 4;
    public static final int clawActuatorright = 5;


  }
}
