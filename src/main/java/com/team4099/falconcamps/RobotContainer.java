package com.team4099.falconcamps;

import com.team4099.falconcamps.subsystems.ShooterPIDSubsystem;
import com.team4099.falconcamps.subsystems.ShooterSparkPID;
import com.team4099.falconcamps.commands.shooter.ShooterPIDSubsystemCommand;
import com.team4099.falconcamps.commands.shooter.ShooterSparkPIDCommand;
import com.team4099.falconcamps.commands.shooter.ShooterSparkPIDIdleCommand;
import com.team4099.falconcamps.commands.shooter.ShooterPIDSubsystemIdleCommand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class RobotContainer implements Loggable{
    @Log private ShooterPIDSubsystem shooterSubsystem = new ShooterPIDSubsystem();
    @Log private ShooterSparkPID shooterSubsystem1 = new ShooterSparkPID();
    @Log private XboxController driverController = new XboxController(0);
    public RobotContainer() {
        new Trigger(driverController::getAButton).whenActive(new ShooterPIDSubsystemCommand(shooterSubsystem));
        shooterSubsystem.setDefaultCommand(new ShooterPIDSubsystemIdleCommand(shooterSubsystem));
        new Trigger(driverController::getAButton).whenActive(new ShooterSparkPIDCommand(shooterSubsystem1));
        shooterSubsystem1.setDefaultCommand(new ShooterSparkPIDIdleCommand(shooterSubsystem1));
    }
}
