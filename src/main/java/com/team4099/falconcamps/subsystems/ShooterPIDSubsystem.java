package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

public class ShooterPIDSubsystem extends PIDSubsystem {
    private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANEncoder shooterEncoder = shooterLeader.getEncoder();

    public ShooterPIDSubsystem() {
        super(new PIDController(1/134, 0, 3 * 14903));
        shooterFollower.follow(shooterLeader);
    }

    @Override
    public void periodic() {

    }

    @Override
    public void useOutput(double output, double setpoint) {
        // TODO Auto-generated method stub
        shooterLeader.set(output);
    }

    @Override
    public double getMeasurement() {
        // TODO Auto-generated method stub
        return shooterEncoder.getVelocity();
    }
}
