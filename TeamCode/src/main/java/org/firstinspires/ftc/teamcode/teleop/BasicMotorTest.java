package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Motor Test")
public class BasicMotorTest extends OpMode {
    // declare variables here, note that every line *must* end with a semicolon (;)
    DcMotor motor;

    // the init() function on our OpMode will be run ONCE, after the Driver clicks "init" on the Driver Hub
    @Override
    public void init() {
        // Telemetry is basically like a print statement, acting as our way to communicate with the Driver on the Driver Hub.
        telemetry.addData("Status", "Initializing");

        // This line basically connects the variable "motor" to the actual motor that
        motor = hardwareMap.get(DcMotor.class, "testMotor");

        telemetry.addData("Status", "Initialized");
    }

    /* This function will LOOP CONTINUOUSLY as soon as "start" is pressed on the Driver Hub
    as long as "stop" has not been pressed yet. This means the code will *not* just be run once,
    and we can write it with the assumption that it's running continuously with constantly updating
    information. */
    // tl;dr: This is where we write the code that makes our robot move throughout the game!!
    @Override
    public void loop() {
        motor.setPower(gamepad1.left_stick_y);

        if(gamepad1.a) {
            motor.setPower(1);
        }

        if(gamepad1.b) {
            motor.setPower(-1);
        }
    }
}
