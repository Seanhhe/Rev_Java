package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *	Brad24
 */

public class Rev026_Extends {

	public static void main(String[] args) {
		Rev022_Bike b1 = new Rev022_Bike();
		Rev_Scooter s1 = new Rev_Scooter();
		
		System.out.println("初始b1 (new Rev022_Bike): " + b1.getSpeed());
		System.out.println("初始s1 (new Rev_Scooter): " + s1.getSpeed());
		
		/**
		 *  s1 可以印出 bike的speed, 可是 speed 不是 private 嗎?
		 *  s1 繼承Bike的方法 getSpeed--> 執行時是到父類別物件執行
		 *  當s1物件存在時, 其父類別早就存在
		 *  s1的初始化是先進行其父類別的建構式, 再進行子類別中的建構式
		 */
		
		System.out.println("--------以下為 多型 --------");
		
		/**
		 * 	多型	(宣告什麼就是什麼, 但執行要看本體是什麼)
		 * 	s3	宣告為Rev022_Bike 就是 Rev022_Bike
		 * 	但是, 執行動作是看操作的本體是什麼 --> s3 的本體是Rev_Scooter 物件實體
		 * 	所以, s3 可以呼叫 Rev022_Bike的方法, 但是執行面要看 Rev_Scooter
		 * 
		 * 	一台車 --> 法拉利
		 * 	是台車 --> 加速不同
		 * 	=> 多型
		 */
		
		Rev022_Bike s3 = new Rev_Scooter();
		s3.upSpeed();
		s3.upSpeed();	// 似乎沒加速效果
		System.out.println(s3.getSpeed());
		
		System.out.println("--------以下為 Overload & Override (重載與重新定義)--------");
		
		/*
		 * 		Overload & Override	(重載與重新定義)
		 * 
		 * 		Overload --> 相同方法名稱  參數不同
		 * 
		 * 		Override --> 相同方法名稱相同參數, 實作內容不同
		 * 					(發揚光大)
		 */
		
		Rev022_Bike b3 = new Rev022_Bike();
		b3.upSpeed();
		System.out.println("b3.getSpeed (new Rev022_Bike) : " + b3.getSpeed());
		Rev_Scooter s4 = new Rev_Scooter();
		s4.upSpeed();
		System.out.println("s4.getSpeed (new Rev_Scooter) : " + s4.getSpeed());
		
		s4.changeGear(3); // 發揚光大
		s4.upSpeed();	// Override 的方法
//		b3.changeGear(3); // b3.changeGear 失敗 Bike裡沒有這個功能
		
		System.out.println("s4.changeGear(3) : " + s4.getSpeed());
		
	}

}
