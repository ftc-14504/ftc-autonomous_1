package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import java.util.concurrent.TimeUnit;

/**
 * Created by ichigo on 9/15/2018.
 */

@TeleOp
public class TeleOp1 extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor left;
    private DcMotor right;
    private Servo servo;
    private DcMotor collector;
    private DcMotor lifter;


    public int clip(int power)
    {
        if(power)
        {

        }
        return;
    }



    public void movement()
    {
        double tgtPower = -this.gamepad1.right_stick_y;
        left.setPower(tgtPower);
        right.setPower(-tgtPower);

        if (gamepad1.right_stick_x != 0) {
            tgtPower = this.gamepad1.right_stick_x;
            left.setPower(0.2 + tgtPower);
            right.setPower(0.2 + tgtPower);
            telemetry.addData("tgtPower", "amount of power", tgtPower);
        }
    }


    public void collect()
    {
        while(gamepad1.y)
            collector.setPower(0.75);
        while(gamepad1.x)
            collector.setPower(-0.75);

        collector.setPower(0);
    }

    public void lifting()
    {
        while(gamepad1.a)
            lifter.setPower(0.3);

        while(gamepad1.b)
            lifter.setPower(-0.3);

        lifter.setPower(0);
    }

    @Override
    public void runOpMode()
    {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
        collector = hardwareMap.get(DcMotor.class, "collector");


        waitForStart();
        runtime.reset();


        while (opModeIsActive()) {
            left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            collector.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            movement();
            collect();


            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}