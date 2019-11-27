package tw.org.iii.myreview;

/*		20180818PM2 Brad70 Java資料結構
 * 
 * 		基本型別 int, short, byte
 * 
 * 		大寫 Byte, Integer, Double, ...這是物件
 * 
 * 		Wrapper (包裹器)
 *			-> 自動裝箱
 *			-> 自動拆箱
 */

public class Rev072_Wrapper {

	/*	使用@SuppressWarnings來排除警告
	 * 	https://www.ibm.com/support/knowledgecenter/zh-tw/SSQ2R2_9.5.1/org.eclipse.jdt.doc.user/tasks/task-suppress_warnings.htm
	 */
	
	
	public static void main(String[] args) {
//		Byte i = new Byte("20");	// 自動裝箱把字串變20個Byte
//		System.out.println(i+10);	// i的單位是Byte，所以加上10 Byte
		
		int a = 10;
		Integer b = new Integer(10); // IDE畫上線仍可以使用但編譯器建議加上宣告
		Integer c = new Integer("10"); 
		Integer d = 10;	// 寫法與字串雷同 => auto-boxing自動封箱
		
//		System.out.println("int a = " + a);
//		System.out.println("Integer(10) = " + b);
//		System.out.println("(字串型別)10 = " + c);
//		System.out.println("Integer d = " + d);
		
		/*	為什麼可以相加？ 不是物件嗎？
		 * 	--> unWrap; => auto-unboxing
		 * 	--> 	b 仍然是Integer物件
		 * 
		 */
		
		System.out.println("a + 3 = " + (a+3));
		System.out.println("b + 4 = " + (b+4));
		System.out.println("d + 6 = " + (d+6)); // unWrapper => auto-unboxing
		System.out.println("a == b : " + (a==b)); // true
		System.out.println("b.equals(a) : " + b.equals(a)); // true
		System.out.println("b == c : " + (b==c)); // false; 因為比較是否為相同物件
		System.out.println("c == a : " + (c==a)); // true; 與常數比較 => 自動拆箱
		System.out.println("a == d : " + (a==d)); // true; 與常數比較 => 自動拆箱
		System.out.println("c == d : " + (c==d)); // false; c與d已經自動封箱，所以比較的是物件
		
		
	}

}
