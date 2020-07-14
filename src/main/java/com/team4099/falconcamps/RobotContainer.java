package com.team4099.falconcamps;

import com.team4099.falconcamps.subsystems.ShooterPIDSubsystem;
import com.team4099.falconcamps.commands.shooter.ShooterPIDSubsystemCommand;
import com.team4099.falconcamps.commands.shooter.ShooterPIDSubsystemIdleCommand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
    private ShooterPIDSubsystem shooterSubsystem = new ShooterPIDSubsystem();
    private XboxController driverController = new XboxController(0);
    public RobotContainer() {
        new Trigger(driverController::getAButton).whenActive(new ShooterPIDSubsystemCommand(shooterSubsystem));
        shooterSubsystem.setDefaultCommand(new ShooterPIDSubsystemIdleCommand(shooterSubsystem));
    }
}
