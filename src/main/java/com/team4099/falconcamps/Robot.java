package com.team4099.falconcamps;

import com.team4099.falconcamps.subsystems.ShooterPIDSubsystem;
import com.team4099.falconcamps.subsystems.ShooterSparkPID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import io.github.oblarg.oblog.Logger;
import io.github.oblarg.oblog.annotations.Log;

public class Robot extends TimedRobot {
    @Log private final RobotContainer robotContainer = new RobotContainer();
    @Log private final ShooterSparkPID shooterSparkSubsystem = new ShooterSparkPID();
    @Log private final ShooterPIDSubsystem shooterPIDSubsystem = new ShooterPIDSubsystem();

    @Override public void robotInit() {
        Logger.configureLoggingAndConfig(this, false);
    }

    @Override public void autonomousInit() {}

    @Override public void teleopInit() {}

    @Override public void disabledInit() {}

    @Override public void robotPeriodic() {
        CommandScheduler.getInstance().run();
        Logger.updateEntries();
    }

    @Override public void autonomousPeriodic() {}

    @Override public void disabledPeriodic() {}
}
