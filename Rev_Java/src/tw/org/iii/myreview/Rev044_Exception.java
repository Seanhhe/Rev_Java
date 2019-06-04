package tw.org.iii.myreview;

/*		20180811PM1	Brad42
 * 		例外處理	Part2 try-catch finally 結構
 * 		
 * 		例外處理完整結構 --> Try {} Catch () {} Finally {}
 * 		1. 可以有多個catch也可以沒有catch
 * 		2. 可以沒有finally
 * 
 * 		# Try auto close 自動關閉 跟try catch沒有直接關係，但語法類似。
 */

public class Rev044_Exception {

	public static void main(String[] args) {
		int a = 10, b =0;
		
		try {
			System.out.println("a / b : " + (a / b));
		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			// 進入到try-catch中，無論如何finally都會執行
			System.out.println("finally {} : OK2");
		}
		System.out.println("OK3");
		
		m1();
	}
	
	static void m1() {
		// 加入return來看finally區塊與外面OK3的差異
		// 答：try-catch及finally的區塊都會執行，但try-catch區塊外則永遠無法達到
		
		int a = 10, b = 3;
		
		try {
			System.out.println("m1: " + (a / b));
			// 即便在這裡就return, finally仍會執行
			return;
		} catch (Exception e) {
			System.out.println("Exception m1");
			return;
			// return 離開, 但finally為同一結構, 也會執行，但try catch外的結構不會執行(OK3)
		} finally {
			// 只要進入到try-catch中，"無論如何" finally都會執行
			System.out.println("OK m1");
		}
		//System.out.println("OK3 m1"); // unreachable
		
	}

}
