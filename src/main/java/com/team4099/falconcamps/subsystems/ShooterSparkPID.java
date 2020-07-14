package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSparkPID extends SubsystemBase {
    private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANEncoder shooterEncoder = shooterLeader.getEncoder();
    private final CANPIDController pidController = shooterFollower.getPIDController();
    private double targetVelocity = 0;

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
