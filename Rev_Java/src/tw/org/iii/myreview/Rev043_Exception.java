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
		
		
	}

}
