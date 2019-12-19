package tw.org.iii.myreview;

import java.util.HashSet;

/*		20180825PM1 Brad82 認證班題目解析
 * 
 * 		補充 Switch
 * 		物件中只有字串可以Switch
 * 		=> Null 值會拋出例外
 * 		=> 不可case null
 * 		=> 比對的物件未初始化		[編譯失敗]
 * 
 */

public class Rev084_StringSwitch {

	public static void main(String[] args) {
		//String a;
		//String a = null; // 可以初始化為null，但執行會出現 NullPointException
//		String a = "A";
//		
//		switch (a) {
//		case "A":
//				System.out.println("A");
//				break;
//		case "B":
//				System.out.println("B");
//				break;
////	case null:	// 編譯失敗
////			System.out.println("Null");
////			break;
//		default:
//				System.out.println("Default");
//				break;
//		}
		
		// 考單列敘述句觀念
		// 考認證=> 先在紙張上整理一下題目的程式碼
		// 參考：http://www.codedata.com.tw/book/java-basic-source/ch7-1.htm
		
//		String[] table = {"aa", "bb", "cc"};
//		int ii = 0;
//		do
//			while(ii < table.length) {
//				System.out.println(ii++);
//			}
//		while(ii < table.length);
		
		//-----------------------------------
		// HashSet
		// 當使用資料結構時，物件的操作上要以資料結構為準
		HashSet<Integer> set = new HashSet<>();
		Integer i1 = 1;
		Integer i2 = 2;
		set.add(i1);
		set.add(i2);
		System.out.println(set.size());
		set.remove(i1);
		System.out.println(set.size()); // 剩下一個
		i2 = 3; // 已經不是原來被add進去的物件實體，而是將i2變數指向另一個物件實體
		System.out.println(i2);
		set.remove(i2); // 移除的是新的i2
		System.out.println(set.size()); // 剩下一個
		System.out.println(set); // [2]

		//------------------------
//		String a = null;
//		System.out.println(a.toString()); // 本身不存在，所以物件方法也不能用 => 拋出例外
		
//		try {
//			test1(); // 會先印出什麼？ 先B再C
//		} catch (Exception e) {
//			System.out.println("C");
//		}
		
		//------------------------
		long a = 123; // int 自動轉型 => long
		//Long b = 123; // int 自動轉型 => long > Long (但是...自動只能做一項)
		Long c = 123L;
		
	}

}
