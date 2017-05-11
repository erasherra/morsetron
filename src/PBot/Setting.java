package PBot;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Setting {
	
	private static int speed = 100;
	private static int amount = 100;
	
	
	private static int motorspeed = 0;
	private static int motoramount = 0; 
	
	public Setting(){
		
		
	}
	
	public static void SetSettings(){
		
		Dimensions.Init();
		LCD.drawString("Setting", 0, 0);
		
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
				valuesetting();
				LCD.clear();
			}
			
			
			Delay.msDelay(50);
		}
		
		Dimensions.TurnAmount(amount);
		Dimensions.SetSpeedForThis(speed);
		LCD.clear();
		LCD.drawString("Pen Setting", 0, 1);
		Delay.msDelay(2000);
		PenSetting();
		
	}
	
	public static int GetSpeed(){
		
		return speed;
	}
	
	public static int GetAmount(){
		
		return amount;
	}
	
	
	
	
	public static void valuesetting(){
		
		LCD.clear();
		Delay.msDelay(500);
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

	}
	
	public static void PenSetting(){
		//Dimensions.Init();
		LCD.clear();
		while(!Button.ESCAPE.isDown()){
			
			if(Button.DOWN.isDown()){
				motorspeed--;
				
			}else if(Button.UP.isDown()){
				motorspeed++;
				
			}else if(Button.LEFT.isDown()){
				motoramount--;
				
				
			}else if(Button.RIGHT.isDown()){
				motoramount++;
				
				
			}else if(Button.ENTER.isDown()){
				Delay.msDelay(2000);
				Dimensions.SetUpDownSpeed(motorspeed);
				Dimensions.motorUpDownTest(motoramount);
			
				LCD.clear();
			}
			
			LCD.drawString("Penspeed: "+motorspeed, 0, 2);
			LCD.drawString("Penamount: "+motoramount, 0, 3);
			Delay.msDelay(50);
		}
		
		Delay.msDelay(2000);
		
		Dimensions.MorseTest(amount, motoramount);
		
	}
	
	
	
	
}
