package com.team4099.falconcamps;

import com.team4099.falconcamps.subsystems.ShooterPIDSubsystem;
import com.team4099.falconcamps.commands.shooter.ShooterPIDSubsystemCommand;
import com.team4099.falconcamps.commands.shooter.ShooterPIDSubsystemIdleCommand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
    private ShooterPIDSubsystem shooterSubsystem;
    public RobotContainer() {
        XboxController driverController = new XboxController(0);
        new Trigger(driverController::getAButton).whenActive(new ShooterPIDSubsystemCommand(shooterSubsystem));
        shooterSubsystem.setDefaultCommand(new ShooterPIDSubsystemIdleCommand(shooterSubsystem));
    }
}
