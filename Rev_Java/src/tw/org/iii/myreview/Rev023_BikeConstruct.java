package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *
 *		物件的初始化 --> 建構式
 *		new -> 產生物件實體
 *		建構式 -> 執行初始化
 */

public class Rev023_BikeConstruct {

	public static void main(String[] args) {
		Rev022_Bike b1, b2;
		b1 = new Rev022_Bike();		// new 產生物件實體在記憶體中, Rev022_Bike()執行建構式(該物件的初始化)
		System.out.println(b1.getSpeed());
		
		b2 = new Rev022_Bike(1.4);
		System.out.println("b2.getSpeed: " + b2.getSpeed());
		
		b2.upSpeed();
		System.out.println("b2.upSpeed: " + b2.getSpeed());
		b2.upSpeed(20); // void upSpeed(int gear)
		System.out.println("b2.upSpeed(20): " + b2.getSpeed());
		
		
		
	}

}
