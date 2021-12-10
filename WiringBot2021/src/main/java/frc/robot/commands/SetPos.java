// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CoderMotor;

public class SetPos extends CommandBase {

  CoderMotor m_CoderMotor;
  double setPoint = 0;
  double location = 0;

  public SetPos(CoderMotor cmSubsystem) {
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
    location = m_CoderMotor.getPosition();
    SmartDashboard.getNumber("Setpoint", setPoint);
    if (location > setPoint)
    {
      if (location < setPoint + 5)
      {
        m_CoderMotor.setSpeed(0.2);
      }
      else
      {
        m_CoderMotor.setSpeed(0.5);
      }
    }
    else if (location < setPoint)
    {
      if (location > setPoint - 5)
      {
        m_CoderMotor.setSpeed(-0.2);
      }
      else
      {
        m_CoderMotor.setSpeed(-0.5);
      }
    }
    else
    {
      m_CoderMotor.setSpeed(0.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
