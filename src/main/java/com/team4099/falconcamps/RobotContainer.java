package com.team4099.falconcamps;

import com.team4099.falconcamps.subsystems.ShooterPIDSubsystem;
import com.team4099.falconcamps.commands.shooter.ShooterPIDSubsystemCommand;
import com.team4099.falconcamps.commands.shooter.ShooterPIDSubsystemIdleCommand;

public class RobotContainer {
    private ShooterPIDSubsystem shooterSubsystem;
    private ShooterPIDSubsystemCommand shooterCommand;
    private ShooterPIDSubsystemIdleCommand shooterIdleCommand;
    public RobotContainer() {

    }
}
