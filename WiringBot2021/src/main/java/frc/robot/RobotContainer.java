// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.NetworkButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final CoderMotor m_coderMotor = new CoderMotor();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  //private final GetEncoderPos 


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    m_coderMotor.setDefaultCommand(new GetEncoderPos(m_coderMotor));
    SmartDashboard.putBoolean("SpinMotor", false);
    SmartDashboard.putBoolean("PositionControl", false);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final NetworkButton SpinMotor = new NetworkButton("SmartDashboard", "SpinMotor");
    final NetworkButton Position = new NetworkButton("SmartDashboard", "PositionControl");

    SpinMotor.whenPressed(new SpinMotor(m_coderMotor));
    SpinMotor.whenReleased(new StopMotor(m_coderMotor));

    Position.whenPressed(new SetPos(m_coderMotor));
    Position.whenReleased(new StopMotor(m_coderMotor));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
