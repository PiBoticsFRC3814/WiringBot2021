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
  int counter = 0;

  public SetPos(CoderMotor cmSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_CoderMotor = cmSubsystem;
    addRequirements(m_CoderMotor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    counter = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    location = m_CoderMotor.getPosition();
    setPoint = SmartDashboard.getNumber("Setpoint", 0);
    SmartDashboard.putNumber("Location Degrees", location);
    if (setPoint + 5 < location)
    {
      m_CoderMotor.setSpeed(0.1);
      counter = 0;
    }
    else if (setPoint - 5 > location)
    {

       m_CoderMotor.setSpeed(-0.1);
       counter = 0;
    }
    else
    {
      m_CoderMotor.setSpeed(0.0);
      counter++;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (counter >= 1000)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}
