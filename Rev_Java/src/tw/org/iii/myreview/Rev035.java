package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *		20180805 Brad33  建構式的特性
 *
 *		物件在建構式上到底是如何產生
 *
 *		建構式-->希望產生什麼樣的物件
 *		在建構式執行前物件實體早已存在
 */

public class Rev035 {

	public static void main(String[] args) {
		System.out.println("---Static 0351---");
		
		//Rev0351.m2();
		
		System.out.println();
		
		System.out.println("---Static---");
		// static 方法	不用產生物件實體就可呼叫
		Rev0352.m2();
		/**
		 * 		執行時顯示如下 (當Rev0351.m2()被註解掉時)
		 * 		Rev0351{static} 程式區塊
		 * 		Rev0352{static} 程式區塊
		 * 		Rev0352: m2()
		 * 
		 * 		執行時會先載入父類別的static程式區塊
		 * 		再執行子類別的static程式區塊，
		 * 		再來是static m2方法
		 * 		->如果繼承作三代，前兩代的也會做
		 * 		-->功能被分類在352，但是352是繼承自351
		 * 			如果不先產生351，則352不會存在
		 * 
		 * 		-> Math.XXX => 全部都是static方法 ==> 工具類別
		 * 			通常這類的只會有object父類別
		 * 		
		 */
		
		System.out.println();
		
		System.out.println("----Rev0351----");
		
		Rev0351 obj1 = new Rev0351();
		
		/**		先執行父類別object，再執行程式區塊，最後做初始化
		 * 		Rev0351{} 程式區塊
		 * 		Rev0351: m1()
		 * 		Rev0351() 建構式
		 * 
		 * 		--> 建構式是做初始化，物件在new Rev0351()時早已產生
		 * 		----> 前面有沒有載入會有差別
		 * 
		 */
		
		System.out.println();
		
		
		//
		System.out.println("----Rev0352 obj2 = new Rev0352();----");
		
		Rev0352 obj2 = new Rev0352();
		
		/**
		 * 
		 */
	}

}

class Rev0351 {
	/**程式區塊什麼時候執行
	 * 		->
	 */
	{	// 程式區塊 code block 在類別中同級
		System.out.println("Rev0351{} 程式區塊");
		m1();
	}
	static {
		System.out.println("Rev0351{static} 程式區塊");
		// 因為是static所以無法呼叫m1();
	}
	
	// 建構式
	Rev0351() {
		System.out.println("Rev0351() 建構式");
	}
	
	// 方法
	void m1() {
		System.out.println("Rev0351: m1() 方法");
	}
	
	static void m2() {
		System.out.println("Rev0351: m2()");
	}
}

class Rev0352 extends Rev0351 {
	// 程式區塊	在類別中同級
	{
		System.out.println("Rev0352{} 程式區塊");
	}
	static {
		System.out.println("Rev0352{static} 程式區塊");
	}
	
	// 建構式
	Rev0352() {
		System.out.println("Rev0352() 建構式");
	}
	
	// 方法
	void m1() {
		System.out.println("Rev0352: m1()");
	}
	static void m2() {
		System.out.println("Rev0352: m2()");
	}
}