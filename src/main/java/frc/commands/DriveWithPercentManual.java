/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.OI;
import frc.subsystems.Drivetrain;
import harkerrobolib.commands.IndefiniteCommand;

public class DriveWithPercentManual extends IndefiniteCommand {

	private static final double SPEED_MULTIPLIER = 0.3;

	public DriveWithPercentManual() {
		requires(Drivetrain.getInstance());
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double speed = OI.getInstance().getDriver().getLeftY();
		double turn = OI.getInstance().getDriver().getLeftX();

		Drivetrain.getInstance().getLeftMaster().set(ControlMode.PercentOutput, SPEED_MULTIPLIER*(speed + turn));
		Drivetrain.getInstance().getRightMaster().set(ControlMode.PercentOutput, SPEED_MULTIPLIER*(speed - turn));
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Drivetrain.getInstance().getLeftMaster().set(ControlMode.Disabled, 0);
		Drivetrain.getInstance().getRightMaster().set(ControlMode.Disabled, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}