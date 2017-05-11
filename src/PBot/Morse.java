package PBot;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Morse {
	public static int WaitTime = 2500;//3500
	public static int Space = 40;//60
	public static int DotSpace = 30;//40
	public static int LongDot = 20;//30
	public static int rivinvaihto = 5;
	
	public static int MoveBack = 550;
	
	private static boolean enter = false;
	
	private static int laskin = 0;
	public static String[] morseTrans;
	
	public static void start(String sana){
		MorseMaaritys();
		Dimensions.Init();
		Translate(sana);
	}
	
	public static void MorseTest(){
		
		
		
	}
	
	public static void Dot(){
		
		Dimensions.mDown();
		Delay.msDelay(WaitTime);
		Dimensions.mUp();
		Delay.msDelay(WaitTime);
		Dimensions.MoveY(DotSpace);
		Delay.msDelay(WaitTime);
	}
	
	public static void LongDot(){
		Dimensions.mDown();
		Delay.msDelay(WaitTime);
		
		Dimensions.MoveY(LongDot);
		
		
		Delay.msDelay(WaitTime);
		
		Dimensions.mUp();
		Delay.msDelay(WaitTime);
		
		Dimensions.MoveY(DotSpace);
		
		Delay.msDelay(WaitTime);
		
		
	}
	
	public static void Vali(){
		//Delay.msDelay(WaitTime);
		Dimensions.MoveY(Space);
		Delay.msDelay(WaitTime);
		
	}
	
	public static void dotSpace(){
		//Delay.msDelay(WaitTime);
		Dimensions.MoveY(DotSpace);
		Delay.msDelay(WaitTime);
		
	}
	
	
	
	public static void TranslateCommand(char com){
			
		laskin++;
		
		if(com == '.'){
			
			Dot();
				
		}else if(com == '-'){
				
			LongDot();
		}else if(com == ' '){
			
			Vali();	
			enter = true;
		}else{
			
		}
		
		if(laskin > rivinvaihto && enter){
			
			Dimensions.ChangeLine();
			laskin = 0;
			enter = false;
		}
		
		
		
	}
	
	public static void Translate(String word){
		
		
		
		
		
		for(char c: word.toLowerCase().toCharArray()){
			
			for(char x : morseTrans[c].toCharArray()){
				
				TranslateCommand(x);
			}
			
			dotSpace();
			
		}
		
		Dimensions.MoveY(-Dimensions.laskeForwards);
		Delay.msDelay(2000);
		
	}
	
	public static void MorseMaaritys(){
		morseTrans = new String[256];
		
		morseTrans['a'] = ".-";
		morseTrans['b'] = "-...";
		morseTrans['c'] = "-.-.";
		morseTrans['d'] = "-..";
		morseTrans['e'] = ".";
		morseTrans['f'] = "..-.";
		morseTrans['g'] = "--.";
		morseTrans['h'] = "....";
		morseTrans['i'] = "..";
		morseTrans['j'] = ".---";
		morseTrans['k'] = "-.-";
		morseTrans['l'] = ".-..";
		morseTrans['m'] = "--";
		morseTrans['n'] = "-.";
		morseTrans['o'] = "---";
		morseTrans['p'] = ".--.";
		morseTrans['q'] = "--.-";
		morseTrans['r'] = ".-.";
		morseTrans['s'] = "...";
		morseTrans['t'] = "-";
		morseTrans['u'] = "..-";
		morseTrans['v'] = "...-";
		morseTrans['w'] = ".--";
		morseTrans['x'] = "-..-";
		morseTrans['y'] = "-.--";
		morseTrans['z'] = "--..";
		morseTrans[' '] = " ";
		
		
	}
	
	
	
	

}
