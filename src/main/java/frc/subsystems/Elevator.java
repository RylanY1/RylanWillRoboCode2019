/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

/** 
 * Add your docs here.
 */
public class Elevator extends Subsystem {

	public static Elevator instance;

	private static final boolean MASTER_TALON_INVERT = ;
	private static final boolean FOLLOWER_TALON_INVERT = ;
	private static final boolean L_FOLLOWER_INVERT = ;
	private static final boolean R_FOLLOWER_INVERT = ;

	private static HSTalon leftTalon;
	private static HSTalon rightTalon;
	private static HSTalon leftVictor;
	private static HSTalon rightVictor;

	private Elevator() {

		leftTalon = new HSTalon(RobotMap.MASTER_TALON_ID);
		rightTalon = new HSTalon(RobotMap.FOLLOWER_TALON_ID);
		leftVictor = new HSTalon(RobotMap.LEFT_FOLLOWER_ID);
		rightVictor = new HSTalon(RobotMap.RIGHT_FOLLOWER_ID);

		setUpMotors();

	}

	private void setUpMotors() {

		getleftTalon().setInverted(MASTER_TALON_INVERT);
		getrightTalon().setInverted(FOLLOWER_TALON_INVERT);
		getleftVictor().setInverted(L_FOLLOWER_INVERT);
		getrightVictor().setInverted(R_FOLLOWER_INVERT);

		getrightTalon().follow(getleftTalon());
		getleftVictor().follow(getleftTalon());
		getrightVictor().follow(getleftTalon());

	}

	public static HSTalon getleftTalon() {
		return leftTalon;
	}
	public static HSTalon getrightTalon() {
		return rightTalon;
	}
	public static HSTalon getleftVictor() {
		return leftVictor;
	}
	public static HSTalon getrightVictor() {
		return rightVictor;
	}

	@Override
	public void initDefaultCommand() {
    
	}

	public static Elevator getInstance() {
		if (instance == null)
			instance = new Elevator();
		return instance;
	}

}