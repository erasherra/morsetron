package PBot;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Dimensions {
	private static RegulatedMotor mLeft = null;
	private static RegulatedMotor mRight = null;
	private static RegulatedMotor mUpDown = null;
	
	private static int speed = 150;
	private static int amount = 530;//570
	
	private static int mUpDownAmount = 50;//60
	private static int mUpDownSpeed = 40;//20
	
	public static int laskeForwards = 0;
	
	public static void Init(){
		
		mLeft = new EV3LargeRegulatedMotor(MotorPort.B);
		mRight = new EV3LargeRegulatedMotor(MotorPort.D);
		mUpDown = new EV3LargeRegulatedMotor(MotorPort.C);
		
		mUpDown.setSpeed(mUpDownSpeed);
		mLeft.setSpeed(speed);
		mRight.setSpeed(speed);
	}
	
	public static void PrintAngles(){
		LCD.clear();
		LCD.drawString(mLeft.getLimitAngle() + ", " + mRight.getLimitAngle(), 0, 0);
	}
	
	
	
	
	
	public static void TurnAmount(int a){
		
		amount = a;

	}
	
	public static void motorUpDownTest(int updown){
		mUpDownAmount = updown;
		mUpDown.rotate(updown, true);
		LCD.drawString("3", 2, 0);
		Delay.msDelay(2000);
		
		mUpDown.rotate(-updown, true);
		LCD.drawString("4", 3, 0);
	}
	
	
	
	public static void MorseTest(int amount,int updown){
		
		
		mUpDown.rotate(updown, true);
		Delay.msDelay(2000);
		mLeft.rotate(amount, true);
		mRight.rotate(amount, true);
		Delay.msDelay(2000);
		mLeft.rotate(amount, true);
		mRight.rotate(amount, true);
		Delay.msDelay(2000);
		mUpDown.rotate(-updown, true);
	}
	
	
	
	public static void mUp(){
		
		mUpDown.rotate(-mUpDownAmount, true);
	}
	
	public static void mDown(){
		mUpDown.rotate(mUpDownAmount, true);
	}
	/*
	public static void MForward(){
		
		mLeft.rotate(amount, true);
		mRight.rotate(amount, true);
		
	}
	
	public static void MBackward(){
		
		mLeft.rotate(-amount, true);
		mRight.rotate(-amount, true);
	}
	*/
	public static void Turn90DegR(){
		mLeft.rotate(amount , true);
		mRight.rotate(-amount , true);
	}
	
	public static void Turn90DegL(){
		mLeft.rotate(-amount - 10 , true);
		mRight.rotate(amount + 10 , true);
	}
	
	
	public static void SetUpDownSpeed(int updownspeed){
		mUpDownSpeed = updownspeed;
		mUpDown.setSpeed(updownspeed);
		
	}
	
	public static void SetSpeedForThis(int s){
		
		speed = s;
		
		mLeft.setSpeed(speed);
		mRight.setSpeed(speed);
		
	}
	
	public static void ChangeLine(){
		Delay.msDelay(5000);
		MoveY(-laskeForwards);
		
		Delay.msDelay(10000);
		
		
		Turn90DegR();
		
		
		Delay.msDelay(7000);
		
		MoveY(40);
		Delay.msDelay(5000);
		
		
		Turn90DegL();
		
		
		Delay.msDelay(7000);
		
		laskeForwards = 0;
	}
	
	public static void MoveY(int amount){
		
		
		laskeForwards += amount;
		mLeft.rotate(amount, true);
		mRight.rotate(amount, true);
	}
	
	public static void MoveX(int a){
		amount = a;
		mLeft.rotate(amount, true);
		mRight.rotate(-amount, true);
		
	}

	
	
	
	
	
	
	
	
	
}
