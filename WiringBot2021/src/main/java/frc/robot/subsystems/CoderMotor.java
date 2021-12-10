// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class CoderMotor extends SubsystemBase {
  /** Creates a new CoderMotor. */
  WPI_TalonSRX coderMotor;
  CANCoder encoder;

  public CoderMotor() {
    coderMotor = new WPI_TalonSRX(Constants.CoderMotor);
    encoder = new CANCoder(Constants.CanCoder1);
  }

  public double getPosition() {
    return encoder.getAbsolutePosition();
  }

  public void setSpeed(double speed) {
    coderMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}