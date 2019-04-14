package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *		20180805	繼承觀念的延伸
 *		繼承表現多型
 *		A類別透過extends父類別	可以	表現出多型(Override)
 *
 *
 *		abstract 抽象  (修飾字)
 *		
 *		抽象類別
 *		-->強迫子類別一定要表現多型 (Override)
 *		-->如果類別裡有抽象方法，必須宣稱自己是抽象類別。
 *		-->也可以宣稱自己是抽象類別，但內容無抽象方法
 *		-->一旦宣告為抽象類別，該類別無法 "直接" 建立物件實體
 *		-->final類別不能為抽象類別 /	final不會有子類別 (就不會有多型override)
 *		-->抽象類別也一定有建構式
 *
 *		抽象方法
 *		-->有定義而無實作方法
 *		-->前面一定要加上abstract修飾字
 */

public class Rev036_extends {

	public static void main(String[] args) {
		//Rev0361 obj1 = new Rev0361();	// 一旦宣告為抽象類別，該類別無法直接建立實體物件
		Rev0361 obj1 = new Rev0362();	// 利用Rev0362實作，但宣告為Rev0361
		Rev0361 obj2 = new Rev0363();
		
		obj1.m2();	//外表是361，執行的是本體362
		obj2.m2();	//外表是361，執行的是本體362
		
	}

}

abstract class Rev0361 { // 抽象類別
	void m1() {
		System.out.println("Rev0361: m1()");
	}
	
	// 抽象方法
	abstract void m2();
}

class Rev0362 extends Rev0361 {	// 繼承Rev0361抽象類別，必須實作m2()方法，如果沒有實作，可以繼續當作抽象類別
	void m2() {		// 實作抽象m2()方法
		System.out.println("Rev0362: m2()");
	}
}

class Rev0363 extends Rev0361 {
	void m2() {
		System.out.println("Rev0363: m2()");
	}
}

abstract class Rev0364 extends Rev0361 {	// 若不想實作父類別的抽象方法，可以繼續當作抽象類別
	void m3() {
		System.out.println("Rev0364: m3() 自己的實作，而非繼承實作");
	}
}