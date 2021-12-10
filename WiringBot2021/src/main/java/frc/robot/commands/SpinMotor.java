// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CoderMotor;

public class SpinMotor extends CommandBase {
  /** Creates a new SpinMotor. */

  CoderMotor m_CoderMotor;

  public SpinMotor(CoderMotor cmSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_CoderMotor = cmSubsystem;
    addRequirements(m_CoderMotor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_CoderMotor.setSpeed(0.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
