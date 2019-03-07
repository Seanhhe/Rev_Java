package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *		20190304
 *		Brad23
 *		字串物件_String
 *
 *		String API
 *		在JAVA中傳輸電子交換的資料, 傳入的資料都是字串
 *
 */

public class Rev025_String {

	public static void main(String[] args) {
		//	試玩 String 物件建構式
		String s1 = new String();
		
		byte[] b1 = new byte[] {97, 98, 99, 100, 65, 66, 67, 68};	//	ASCII Code
		String s2 = new String(b1);
		
		String s3 = new String(b1, 1, 3);	// String(byte[] bytes, int offset, int length)
		
		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		System.out.println("s3 : " + s3);
		
		/**
		 * 	API 中的 Deprecated 標記 => 未來的版本可能會取消不使用的部分
		 * 			==> 主要是改善或安全性的考量
		 * 			==> 通常都會提前公告
		 * 
		 * 	重點: 一個字串的物件實體已經存在的情況下, 其物件的"字串內容"就不再會被變更.
		 * 
		 */
		
		// 這個s1的物件實體已經不是原來的那一個, 因為已經被new重新指向String(b1)
		s1 = new String(b1);	// 不建議使用這種初始化語法
		
		/**
		 * 	s1原本的物件實體不再被指向--> JAVA Garbage collection 會自動回收.
		 * 	但是, garbage collection 不知道什麼時候會執行, 無法設定時機.
		 */
		
		System.out.println("------分隔線------");
		
		/**
		 * 	另一個段落
		 * 	01. 雙引號夾住=>字串 (不論夾住的字元長度)
		 * 
		 * 	02. String Pool 字串池
		 * 	s4-->在字串池中產生一個新物件實體"Hello, world", 讓s4指向該物件實體.
		 *  s5-->s5建立時在字串池中找到相同的物件實體, 所以把他直接指向s5.
		 *  s6-->因為有"new", 所以會在記憶體中的某處產生s6的物件實體, 然後其中透過建構式進行初始化 (放入s4的字串內容與類別方法)
		 *  s7-->同s6
		 *  
		 *  	**字串物件與字串內容不同!!!
		 */
		
		String s4 = "Hello, world!";
		System.out.println("s4 : " + s4);
		String s5 = "Hello, world!";
		System.out.println("s5 : " + s5);
		String s6 = new String(s4);
		System.out.println("s6 : " + s6);
		String s7 = new String(s5);
		System.out.println("s7 : " + s7);
		
		//-----------------------------
		
		// == 比較是否為相同的物件實體-->比對字串物件裡的"址"
		int a = 10, b = 10;
		System.out.println("數字比對 : " + (a == b));
		
		System.out.println(s4 == s5);	//字串內容在記憶體中是相同的位址
		System.out.println(s5 == s6);	//相同字串內容, 但在記憶體中是不同的位址
		System.out.println(s6 == s7);	//理由同上
		
		System.out.println("----比對字串內容----");
		
		// String.equals 比對物件的字串內容
		System.out.println("s4.equals(s5) : " + s4.equals(s5));
		System.out.println("s5.equals(s6) : " + s5.equals(s6));
		System.out.println("s6.equals(s7) : " + s6.equals(s7));
		
		System.out.println("----分隔線----");
		
		s4 = s6;	// 把s6的內容傳遞給s4(s4改指向s6物件實體)
		System.out.println("s4 == s6 : " + s4 == s6 + " 代表不同物件實體 ");
		System.out.println("s4.equals(s6) : " + s4.equals(s6));
		
	}

}
