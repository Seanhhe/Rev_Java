package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *	20180804 	繼承	extends
 *
 *	把父類別發揚光大
 *	extends 就是擴大延伸
 *	好事發揚光大, 壞事拋出意外
 *
 *	任何類別都只會有一個父類別, 且都有一個父類別, 且都有一個父類別(只是有無宣告)
 *	如果沒對外宣稱(寫)extends 預設的父類別為	java.Object
 *
 *	繼承那些東西呢?
 *	可繼承
 *	> 1. 屬性
 *	> 2. 方法
 *	不可繼承
 *	> 1. private
 *	> 2. 建構式	(不是一個類別物件所擁有的, 只是用來初始化)
 */

public class Rev_Scooter extends Rev022_Bike{
		private int gear;
		
		@Override
		double getSpeed() {
			return speed + 2;	//要父類別開放speed才可用
		}
		
		void changeGear(int gear) {
			this.gear = gear;
		}
		
		int getGear() {
			return this.gear;
		}
		
		@Override
		void upSpeed() {
			// 與父類別方法名稱相同 (Override父類別的同名方法, 在基本型別上傳回值要與父類別的方法相同)
			super.upSpeed();
			speed *= gear;
		}
}
