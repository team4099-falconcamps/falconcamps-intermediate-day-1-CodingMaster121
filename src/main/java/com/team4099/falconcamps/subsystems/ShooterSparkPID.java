package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class ShooterSparkPID extends SubsystemBase implements Loggable {
    private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    @Log private final CANEncoder shooterEncoder = shooterLeader.getEncoder();
    @Log private final CANPIDController pidController = shooterFollower.getPIDController();
    @Log private double targetVelocity = 0;

    public ShooterSparkPID() {
        pidController.setP(1/134);
        pidController.setI(0);
        pidController.setD(3 * 14903);
        pidController.setFF(0);
        shooterFollower.follow(shooterLeader);
    }

    public void setTargetVelocity(double targetVelocity) {
        this.targetVelocity = targetVelocity;
    }

    @Override
    public void periodic() {
        pidController.setReference(targetVelocity, ControlType.kVelocity);
    }
}
