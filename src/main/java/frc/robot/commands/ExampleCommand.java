/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj.Timer;
/**
 * An example command.  You can replace me with your own command.
 */
public class ExampleCommand extends Command {
  private final TankDrive tank;
  private Timer timer;
  
  public ExampleCommand(TankDrive td) {
    this.tank = td;
    // Use requires() here to declare subsystem dependencies
    requires(tank);
    this.timer = new Timer();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.reset();
    timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (timer.hasPeriodPassed(15)) {
      tank.setRight(5);
    }
    
    else if (timer.hasPeriodPassed(10)) {
      tank.set(0);
    }
        
    else {
      tank.set(5); 
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return timer.hasElapsed(15);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    timer.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
