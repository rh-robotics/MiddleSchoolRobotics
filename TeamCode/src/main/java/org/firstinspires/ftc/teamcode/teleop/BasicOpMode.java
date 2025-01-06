package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/* Optional: OpModes are an FTC defined class that allow us to write all of our code. There are two types of OpModes,
the LinearOpMode, which run once through the whole time, and the regular OpMode, which is what we're using,
defined by the program saying "extends OpMode" as a part of the class header "public class Drive".
The regular OpMode has two functions you must define– "init" and "loop". The init() function runs once,
after the driver presses init on the Driver Hub, while the loop() function runs over and over after
start is pressed on the Driver Hub, up until "stop" is pressed. */

/* The @TeleOp annotation tells the program it's a TeleOp file (on the Driver Hub, it will be sorted into
Autonomous OpModes and TeleOp OpModes, distinguished by this annotation. Note that the name on the Driver Hub
does not technically have to match the class name– it just generally keeps things simple if it's similar
enough to recognize. */

@TeleOp(name = "TeleOp OpMode")
public class BasicOpMode extends OpMode {
    // declare variables here, note that every line *must* end with a semicolon (;)
    DcMotor leftDrive;

    // TODO: declare the rest of the variables here– think through what good names for each of the
    // TODO: motors and servos on our robot could be.

    /* here, we also declare other variables, some of which are constants, to use throughout our program.
    the advantage to using variables is mostly that it allows you to easily update a lot of the program
    by just changing the value of one constant (if you do it right). For instance, by changing
    MAX_DRIVE_POWER from 1 to 0.5, I can scale back how fast all of the drive motors are running
    without having to worry that I missed one, which would have made the program no longer work as intended. */

    // note that we declare the TYPE of the variable here too. Remember that doubles are numbers with decimal points.
    double MAX_DRIVE_POWER = 1;

    double forwardValue;
    double turnValue;
    double leftDrivePower;
    double rightDrivePower;

    // the init() function on our OpMode will be run ONCE, after the Driver clicks "init" on the Driver Hub
    /* Optional: If you're interested, we use the @Override annotation by convention, since this function
    was declared in the definition of an OpMode, meaning by writing it here, in the "child" class (remember
    the "extends OpMode" line? That was declaring this OpMode as a child class of the OpMode parent.), we're
    writing over (or, as the annotation says, overriding) whatever it was previously defined as in the parent
    OpMode class. */
    @Override
    public void init() {
        // Telemetry is basically like a print statement, acting as our way to communicate with the Driver.
        telemetry.addData("Status", "Initializing");


        // Initialize, meaning give their initial value, each of the robot parts here.
        // note that we're using the same names that we declared up above, and that capitalization is important!
        /* Later, we're going to define our hardwareMap on the Driver Hub, which will tell the robot
        where to find each of these motors/servos. for example, we might tell it that a DcMotor
        called "leftDrive" can be found in motor port 1, which we reference here to be able to affect
        it throughout our program. */
        leftDrive = hardwareMap.get(DcMotor.class, "leftFront");

        // TODO: initialize the rest of the motors and servos on your robot!


        /* Optional: Note here that we use the same addData function to update a value called "Status".
        This will make it so it will change the line we "printed" to the console, rather than printing a new one,
        which we would have done through the telemetry.addLine("Hello World"); function. */
        telemetry.addData("Status", "Initialized");
    }

    /* This function will LOOP CONTINUOUSLY as soon as "start" is pressed on the Driver Hub
    as long as "stop" has not been pressed yet. This means the code will *not* just be run once,
    and we can write it with the assumption that it's running continuously with constantly updating
    information. */
    // tl;dr: This is where we write the code that makes our robot move throughout the game!
    @Override
    public void loop() {
        /* The first thing we're going to write out is the drive code. The logic behind how we're going
        to do this is by first assigning values to our "forwardValue" and "turnValue" variables, based
        on gamepad inputs. We want to use the left stick for our forward/backward driving and the right
        stick for turning. Then, we can assign a "base value" of forwardValue to each of our drive powers.
        Lastly, we want to change these values to also affect the rotation value. */

        // Note that gamepad1.left_stick_y will return a value from -1.0 to 1.0
        forwardValue = gamepad1.left_stick_y;

        // TODO: assign turnValue a value based on the right joystick's left to right value.


        // What might be some advantage of using a variable to hold the left and right drive powers?
        // What would an alternative be?
        leftDrivePower = forwardValue;
        rightDrivePower = forwardValue;

        // TODO: factor in the turnValues
        /* Think through this before you program: how do you want to do this? Should we affect both sides?
        Or just one? What would allow the robot to turn in place? Would using that method affect how well
        it would turn while we run the OpMode? Don't be scared to try a couple methods and run the code on the robot! */


        // This line is what actually makes the motors "run".
        /* Why do you think we're multiplying the leftDrivePower by MAX_DRIVE_POWER? Why is it important
        that leftDrivePower already falls between -1.0 and 1.0? Think through what would happen at
        some important points– what happens at 1.0? What happens at -1.0? What about 0? 0.5? */
        leftDrive.setPower(MAX_DRIVE_POWER * leftDrivePower);

        // TODO: set the rightDrive motor power


        /* What are some other functions we want the robot to be able to do? Pick one motor or servo to affect
        first and plan out how you want to make it move, first. Do you want to make it move based on an analog
        value like the joystick values for drive– calculated and assigned constantly, reguardless of what
        the values are? Or do you want to have it move only when a certain threshhold is reached or a button is
        pressed? */
        // IMPORTANT: make sure you make a plan *BEFORE* writing the code out!! This will help to keep you out
        // of making so many semantic (logic) errors, plus it'll make sure you're writing good code and keep
        // you from basically tying yourself up in knots with your program.
    }
}
