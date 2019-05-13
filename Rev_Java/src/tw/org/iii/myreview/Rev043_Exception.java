package tw.org.iii.myreview;

/*		20180811 Brad41	例外
 * 		
 * 		樹狀架構：
 * 		Throwable (可拋出的物件) [java.lang.Throwable]
 * 				|--Error (可能是硬體上的錯誤等，無法處理)
 * 				|--Exception (軟體上可處理的狀況)
 * 						|--RuntimeException (unchecked exception 執行階段發生的)
 * 						|--other exception (checked exception 需要事先檢查 / 處理的)
 * 		E.g. 衝墾丁發生車禍 (例外出現) -->報警 (處理) --> 處理完沒事 繼續前往目的地 (繼續執行)
 */

public class Rev043_Exception {

	public static void main(String[] args) {
		
		/*		編譯通過，但是執行後發生例外	java.lang.ArithmeticException.
		 * 		=> is a RuntimeException
		 */
		int a = 10, b = 0;
		//int c = a / b;		//編譯通過，但發生例外，因為分母為0
		//System.out.println("c: " + c);
		
		/*		陣列Index範圍	int --> 編譯可過
		 * 		但是	拋出ArrayIndexOutOfBoundsException
		 */
		int[] d = new int[3];
		//System.out.println("d[3]: " + d[3]); //超出範圍，index共三個只有0,1,2。
		
//		int a = 10, b = 3;
//		int c = a / b;
//		System.out.println(c); // 成功執行：3
//		//System.out.println(d[3]); // 拋出例外
//		System.out.println("GG"); // 上一行程式提前終止，所以此行沒有執行
		
//		try {
//			System.out.println("d[3]: " + d[3]);
//		} catch (ArrayIndexOutOfBoundsException e) {
//			// 捕捉到例外後的處理方法 (沒寫就是不處理)
//			// 處理完後，程式繼續執行
//			System.out.println("有捕捉到例外喔");
//		}
//		System.out.println("GG");
		
//		try {
//			System.out.println("d[3]" + d[3]);
//		} catch (ArithmeticException e) {
//			// 預設要抓的例外非實際發生的-->抓不到
//			System.out.println("預設要抓的例外非實際發生的-->抓不到");
//		}
//		System.out.println("GG");
		
//		try {
//			System.out.println("Before");
//			System.out.println(d[13]);
//			System.out.println("After"); // 這句並沒有執行，因為前一句有例外產生(有狀況)直接跳到catch
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("有狀況1");
//		} catch (ArithmeticException e) {
//			// 增加其他例外條件，讓程式一個一個判斷
//			System.out.println("有狀況2");
//		}
//		System.out.println("END");
		
		System.out.println("--------");
		
		try {
			b = 0;
			int c = a / b;
			System.out.println(c); // 這裡先有狀況就拋出
			System.out.println(d[13]); // 前一行有狀況，所以此行根本沒執行，雖然此行也有狀況
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("有狀況1");
		} catch (ArithmeticException e) {
			System.out.println("有狀況2");
		}
		System.out.println("END");
		
		/*		前面練習中的例外關係圖
		 * 		Exception
		 * 		|-->RuntimeException
		 * 				|--> ArithmeticException
		 * 				|--> I..
		 * 						|--> Array
		 * 		catch的順序
		 * 		-->如果非直系血親=沒差
		 * 		-->若為直系血親-->子類別(細部處理)要放在父類別上面
		 */
	}

}
