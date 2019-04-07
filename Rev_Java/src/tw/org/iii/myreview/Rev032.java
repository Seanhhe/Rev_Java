package tw.org.iii.myreview;

/**		20180805 Brad30_Override
 * 
 * @author SEAN
 *		重點：
 *		1.	Override & Overload 的差異
 *		2.	Override 基本型別與物件型別使用上的不同 (物件型別 >= 父類別)
 *		3.	相同名稱但參數不同時，呼叫對象為何？ (overload)
 *		4.	方法繼承的呼叫
 *		5.	不定個數的參數使用
 *
 *		
 *		overload:
 *		-> 只要是我這個類別可呼叫的相同名稱方法就是overload
 *		-> (名稱相同，參數不同)，有可能是繼承而來
 *		--------------------------
 *
 *		override:
 *		-> 將父類別的方法 (參數與名稱都相同) 覆蓋，發揚光大
 *
 *		->基本型別--> override的型別 / 方法名稱 / 參數 / 傳回值型別，都要與父類別一模一樣
 *		->物件型別--> override的方法名稱 / 參數要一樣，但是！型別 (是存取修飾字?!) 傳回值 要大於父類別
 *		
 *		--------------------------
 *		方法傳入多個參數 (兩種方法)
 *		1.	使用	陣列
 *		2.	使用	不定個數的參數：可與固定參數混合寫，但只能放在最後面，
 *			且只能有一個int...方法與int[]	比較：int...方法對user比較友善(容易呼叫)
 *			->	不定個數的參數在使用上較陣列參數方便 (對user比較友善)
 *			-->	但不定個數的參數在使用overload上要小心
 *
 *		--------------------------
 *		Brad31
 *		參數的傳遞存在自動轉型
 *		return也存在自動轉型
 */

public class Rev032 {

	public static void main(String[] args) {
		Rev0321 obj2 = new Rev0321();
		obj2.m1(1);
		obj2.m1(1, 2);
		obj2.m1(1, 2, 3);
		obj2.m1(1,2,3,4,5,6);
		// 分別印出Rev0321類別內對應的overload參數方法
		
		System.out.println("----分隔線----");
		
		String[] a1 = {"ACC", "AC"};
		String[][] a2 = new String[2][2];
		a2[0] = new String[] {"10", "22"};
		a2[1] = new String[] {"25", "35"};
		
		obj2.sayYa(a1);
		obj2.sayYa(a2); // 二維陣列
		obj2.sayYa("hello", "ooo", "dasf", "safds");
		
		System.out.println("---分隔線---");
		
		Rev0322 obj1 = new Rev0322();
		// 呼叫的是哪個m1方法 > 看參數 預設給的會是int 所以第二個有強制轉型
		obj1.m1();
		obj1.m1(1);
		obj1.m1((byte)2); //強制轉型
	}

}


class Rev0321 {
	int m1() {
		return 1;
	}
	
	Object m12() {
		return new Object();
	}
	
	// 名稱相同但參數不同
	int m1(int a) {
		System.out.println("m1(int a)");
		return a;
	}
	void m1(int a, int b) { // overload
		System.out.println("m1(int a, int b)");
	}
	void m1(int a, int b, int c) { // overload
		System.out.println("m1(int a, int b, int c)");
	}
	
	// 使用不定個數參數
	void m1(int...as) {
		System.out.println("m1(int...as)");
	}
	
//	void m1(int[] a) { // 與...as是型別相同，所以編譯失敗
//		System.out.println("m1(int[] a)");
//	}
	
	// 需要一次使用多個參數時，可使用字串陣列或不定個數參數
	void sayYa(String[] names) { // 字串陣列
		for (String name: names) {	// for-each
			System.out.println(name + "!" + "一維陣列");
		}
		
		/**	for-each用法
		 * 		for(元素型態  迴圈控制變數：集合或陣列名稱) {
		 * 			迴圈主體;
		 * 		}
		 * 
		 * 	注意：
		 * 	只能從頭開始走訪每個元素
		 * 	只能取出元素，不能置換
		 * 	for-each迴圈裡的變數是'區域變數'
		 * 	只適用Java 5.0以後的版本
		 * 
		 */
	}
	
	// 二維陣列
	// 不定個數的參數  (骨子裡就是陣列) [陣列裡的元素型別+...+]
	void sayYa(String[]...names) {
		for (String[] name : names) {
			for (String name2 : name) {
				System.out.println(name2 + "?" + "二維陣列");
			}
		}
	}
	
	// 不定個數的參數可與固定個數的參數混用，但只有一個且只能在最後
	void sayYa(String fname, String... names) {
		for (String name: names) {
			System.out.println(name + "!" + "不定個數的參數可與固定個數的參數混用，但只有一個且只能在最後");
		}
	}
}

class Rev0322 extends Rev0321 {
	@Override
	int m1() {		// override 基本型別與名稱參數傳回都要一樣
		super.m1();
		return 2;
	}
	
	@Override
	String m12() {		// 物件型別其傳回值要大於等於父類別 (發揚光大)
		return new String();
	}
	
	int m1(int a) {	// 名稱相同 但參數不同 不是Override
		System.out.println("名稱相同 但參數不同 不是Override");
		System.out.println("Rev0322 : int m1(int a) : " + a);
//		return a;
		return 12; //為何回傳12而不是a ?
	}
	
	byte m1(byte b) {
		System.out.println("Rev0322 : byte m1(byte b) : " + b);
		return 2; //為何回傳2 ?
	}
	
	@Override
	void m1(int[] a) {	// override Rev321的m1() => 傳回值型別改成int傳回值型別修改造成編譯失敗，代表此方法就是override
		System.out.println("Override Rev0322 : void m1(int[] a)");
	}
}

