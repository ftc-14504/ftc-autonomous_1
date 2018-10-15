package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.vuforia.Vuforia;

/**
 * Created by ichigo on 9/15/2018.
 */

@Autonomous
public class AutonomousV1 extends LinearOpMode
{
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    @Override
    public void runOpMode()
    {
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        leftDrive  = hardwareMap.get(DcMotor.class, "left");
        rightDrive = hardwareMap.get(DcMotor.class, "right");
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        Vuforia nav = new Vuforia();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive())
        {

            nav.init();
            
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
            }
        }
    }




// Tank Mode uses one stick to control each wheel.
// - This requires no math, but it is hard to drive forward slowly and keep straight.
// leftPower  = -gamepad1.left_stick_y ;
// rightPower = -gamepad1.right_stick_y ;