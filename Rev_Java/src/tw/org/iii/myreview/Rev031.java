package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *		20180805 Brad29
 *
 *		宣告, 轉型, 呼叫
 *
 *		繼承&物件型別轉換
 *		-> 宣告為某類別, 僅能呼叫該類別的方法
 *		-> 如何執行須看用何種類別實作
 *		-> 呼叫不到就用不到, 更別說執行
 *
 *		-> 假設001原本就是以B類別產生, 但是宣告為A類別, AB類別關係為父子,
 *		-> 故當強制轉型成B類別時, 原本不能呼叫的B類別方法就可以呼叫, 且可執行
 *
 *		-> 兩類別為直系血親: 編譯時期可過, 但不見得能執行
 *		-> 反之無法編譯
 *
 *
 *		instanceof
 *		-> 判斷骨子裡是否為該物件實體
 *		-> 實際應用分享
 *				聯絡人內有包含 客戶/供應商/...
 *				父類別都是聯絡人, 子類別是客戶
 *				先宣告為聯絡人
 *				要使用客戶時=>強制轉型成客戶
 *		
 */

public class Rev031 {

	public static void main(String[] args) {
		Rev0311 obj1 = new Rev0311();
		obj1.m1();
		
		/** 為什麼obj2只能宣告m1();
		 * 		->宣告為什麼就只能呼叫其宣告內的方法
		 * 			->但是，由於obj2是Rev0311()實作
		 * 			->所以呼叫的m1();是以Rev0312的方法執行
		 * 
		 * 	宣告為車子 但是是保時捷?!
		 * 	你不知道是保時捷，所以不知道有sports mode可用
		 */
		
		// 宣告為Rev0311，但骨子裡是Rev0312
		Rev0311 obj2 = new Rev0312();
		obj2.m1();
		
//		Rev0312 obj3 = obj2;	// 父類別物件無法指定給子類別宣告
		
		Rev0312 obj3 = (Rev0312)obj2; // 強制轉型
		obj3.m1();
		obj3.m2();
		System.out.println("obj2 == obj3 : " + (obj2 == obj3)); // 骨子裡真的是一樣的東西
		
//		Rev0312 obj4 = (Rev0312)obj1; // Runtime Exception (可編譯 但不能執行)
		
		Rev0314 obj5 = new Rev0314();
//		Rev0312 obj6 = (Rev0312)obj5; // compiler error 編譯失敗: 因為非父子類別關係
		
		/**
		 * 	20180805 instanceof
		 * 	-> 比較骨子裡是哪種物件實體 (參考網址：https://www.ewdna.com/2012/06/javainstanceof.html)
		 * 	
		 * 	用法:
		 * 		objectA instanceof ClassName
		 * 	01. 測試某一物件 objectA 是否為某類別 (class)或其子類別 (subclass)實例 (instance)
		 * 	02. 或是 objectA 是不是某介面 (interface) 的實作
		 * 	
		 * 	當 objectA 屬於該class(或其衍生類別) 的instance，就會回傳true; 否則傳回false
		 * 	所以 instanceof 可以被用在繼承的關係中
		 * 	需特別注意，比較時物件與類別間要有繼承關係，否則會編譯錯誤
		 * 	("myInstanceof.java": Error #:365:cannot compare java.lang.Long with java.lang.String)
		 * 	
		 * 	Java中所有class都是繼承 Object 這個class，所以理論上任意的 objectA instanceof Object 都應該回傳 true，
		 * 	這是錯的！當 objectA 指向 null時，條件判斷會回傳 false 喔！千萬注意！
		 * 	
		 * 	另外 Java 中還有基本型別 如 int, byte, boolean
		 * 	這些基本型別沒辦法使用 instanceof，必須是Integer, Byte, Boolean 物件化的才可使用
		 * 
		 * 	除了任意物件都會繼承 Object 外，任何陣列也都繼承 Object，
		 * 	所以所有物件陣列都會同時繼承 Object 和 Object[]
		 * 	
		 * 	基本型別的陣列同樣會繼承 Object，
		 * 	但因為基本型別不是物件，故基本型別陣列不會繼承 Object[]
		 */
		System.out.println("----instanceof比較骨子裡是哪種物件實體----");
		
		if (obj1 instanceof Rev0312) {
			Rev0312 obj4 = (Rev0312)obj1;
			System.out.println("Rev0312 obj4 = (Rev0312)obj1;");
		}else {
			System.out.println("XX");
		}
		
		
	}

}

/**
 * 
 * @author SEAN
 *		class structure
 *		
 *		Object
 *		-->Rev0311
 *			-->Rev0312
 *				-->Rev0313
 *		-->Rev0314
 */

class Rev0311 {
	void m1() {
		System.out.println("Rev0311: m1()");
	}
}

class Rev0312 extends Rev0311 {
	@Override
	void m1() {
		System.out.println("Rev0312: m1() : override m1()方法");
	}
	
	void m2() {
		System.out.println("Rev0312: m2()");
	}
}

class Rev0313 extends Rev0312 {
	void m3() {
		System.out.println("Rev0313: m3()");
	}
}

class Rev0314 {
	
}

