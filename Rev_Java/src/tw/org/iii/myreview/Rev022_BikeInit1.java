package tw.org.iii.myreview;

public class Rev022_BikeInit1 {

	public static void main(String[] args) {
		Rev022_Bike b1 = new Rev022_Bike();
		System.out.println(b1);	// 物件的值就是記憶體位置-->傳值
		System.out.println(b1.getSpeed()); // has a --> b1擁有的speed; b1.speed
		
		b1.upSpeed();
		b1.upSpeed();
		b1.upSpeed();
		b1.downSpeed();
		System.out.println(b1.getSpeed());
		
		// 速度提升至10以上
		Rev022_Bike b2 = new Rev022_Bike();
		for (int i = 1; i < 10; i++) {
			b2.upSpeed();
		}
		System.out.println(b2.getSpeed());
		
		// 速度提升不合理的做法-->使用者可以存取?!
		b2.speed = 10;
		System.out.println(b2.getSpeed());
		
		// 防堵的方法: 
		// 在Rev022_Bike類別中, 屬性宣告前加上private-->讓使用者只能透過方法改變屬性
		
	}

}
