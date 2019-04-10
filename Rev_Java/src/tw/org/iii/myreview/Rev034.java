package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *		20180805 Override 為什麼要使用? 	[Code Review]
 *		-->Override的精神是發揚光大
 *		-->只是蓋住非移除，所以還是會占用記憶體位址
 *		=> 所以為什麼要使用override
 *		-->"不是抹煞父類別的方法，而是在父類別方法上強化他的功能"
 *
 */

public class Rev034 {

	public static void main(String[] args) {
		
	}

}

class Rev0341 {
	void m1() {
		System.out.println("Rev0341: m1()");
	}
}

class Rev0342 extends Rev0341 {
	@Override
	void m1() {		//為什麼這裡要使用override？	何不另開新方法？
		//	super 在override方法中可以任意擺放，端看程式邏輯以及想要改良的部分;
		// super.m1();
		System.out.println("Rev0342: m1()");
		super.m1();
		
		/**
		 * 		建構式的super
		 * 		是因為在初始化子類別前，父類別要先初始化
		 * 		才會一定要在第一道敘述句
		 */
		
	}
}