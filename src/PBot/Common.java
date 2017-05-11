package PBot;
import PBot.Dimensions;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Common {
	
	//private static int speed = 20;
	//private static int amount = 90;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Setting.SetSettings();
		Morse.start("Hello world");
		/*
		Dimensions.Init();
		Dimensions.MoveY(50);
		
		Dimensions.ChangeLine();
		*/
		/*
		Dimensions.Init(20);
		
	
		 amount = 90;
		 speed = 20;
		Dimensions.SetSpeedForThis(speed);
		//Dimensions.MoveY(500);
		while(!Button.ESCAPE.isDown()){
			if(Button.DOWN.isDown()){
				Dimensions.MoveY(amount);
			}else if(Button.UP.isDown()){
				Dimensions.MoveY(-amount);
			}else if(Button.LEFT.isDown()){
				Delay.msDelay(5000);
				Dimensions.MoveX(amount);
			}else if(Button.RIGHT.isDown()){
				Delay.msDelay(5000);
				Dimensions.MoveX(-amount);
			}else if(Button.ENTER.isDown()){
				setting();
			}
			
			
			Delay.msDelay(50);
			
		}
		*/
	}
	
	public static void setting(){
		/*Delay.msDelay(500);
		LCD.drawString("Syota arvot", 0, 0);
		while(true){
			
			if(Button.DOWN.isDown()){
				speed -= 10;
				Delay.msDelay(50);
				
			}else if(Button.UP.isDown()){
				speed += 10;
				Delay.msDelay(50);
			}else if(Button.LEFT.isDown()){
				
				amount -= 10;
				Delay.msDelay(50);
			}else if(Button.RIGHT.isDown()){
				
				amount += 10;
				Delay.msDelay(50);
			}else if(Button.ENTER.isDown()){
				Dimensions.SetSpeedForThis(speed);
				LCD.clear();
				LCD.drawString("lopettaa", 0, 1);
				Delay.msDelay(1000);
				break;
			}
			
			LCD.drawString("Speed: "+speed, 0, 2);
			
			LCD.drawString("Amount: "+amount, 0, 3);
			
			
			
		}
		*/
		
	}

}
