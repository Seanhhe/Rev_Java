package tw.org.iii.myreview;

//import java.awt.FontFormatException;
import java.io.IOException;
import java.text.ParseException;

/**
 * 
 * @author SEAN
 *		20180811PM1 Brad43 Review
 *		例外處理	Part3	Checked Exception
 *
 *		# 拋出例外不一定是壞事=>而是讓使用者的處理保有彈性
 *
 *		對外宣稱throws Exception 但實際拋出內容要等於小於Exception
 *		-->不可宣告RuntimeException，但內容為Exception (因為 RE < Ex 的範圍)
 *
 *		呼叫的人要看宣告的Exception為何  (宣告可以多個)
 *		
 *		例外處理如果沒有處理則要宣告--> 一層一層拋出 (堆疊觀念)
 */

public class Rev045_Checked_Exception {

	public static void main(String[] args) {
		RevBird b1 = new RevBird();
		/*		對於預先可知的例外要用try-catch
		 * 		如果宣告的是RuntimeException 可不使用try catch
		 *		反之 Checked Exception 就一定要  try-catch
		 * 		
		 */
		// 第一種
//		try {
//			b1.setLeg(3);
//		} catch (Exception e) {
//			System.out.println("Exception: " + e);
//		}
		
		/*		使用者可以選擇單一處理Exception 或 各自處理
		 * 		如果不使用try-catch，可在main方法再 throw Exception，
		 * 		語法上合乎規則但沒有意義！
		 * 		因為同樣是交由JVM處理
		 */
		// 第二種
		try {
			b1.setLeg(3);
		} catch (ParseException e) {
			// 處理一
		} catch (IOException e) {
			// 處理二
		}
	}

}

class RevBird {
	/*		小鳥類別
	 * 		->腳只能2/1/0隻
	 * 		->其他都是例外
	 */
	private int leg;
	
	// 第一種
//	void setLeg(int leg) throws Exception { // 必須宣告會拋出例外
//		if (leg < 0 || leg > 2) {
//			// 發生例外狀況，交給使用者處理(拋出例外)
//			// [保有處理的彈性]
//			throw new RuntimeException();
//			// RuntimeException < Exception
//		}else {
//			this.leg = leg;
//			System.out.println("leg: " + leg);
//		}
//	}
	
	
	// 第二種
	void setLeg(int leg) throws ParseException, IOException {
		// 可對外宣告一個Exception(一定要涵蓋有的例外，但是對使用者較不清楚實際可能發生的例外)，
		// 或者都各自宣告(讓使用者清楚有那些例外)
		// 更細部的拋出例外(對使用者的彈性更大)
		if (leg < 0) {
			throw new ParseException("XXX", 3);
		}else if (leg > 2) {
				throw new IOException();
		}else {
			this.leg = leg;
		}
	}
}

class RevBire2 extends RevBird {

//	@Override
//	void setLeg(int leg) throws ParseException {
//		/*		實作的內容有什麼例外，就要宣告出來。
//		 * 		但是如果沒有宣告完整，裡面要用try-catch處理。
//		 */
//		try {
//			super.setLeg(leg);
//		} catch (IOException e) {
//			//e.printStackTrace();
//		}
//	}

//	@Override
//	void setLeg(int leg) {
//		/*		沒有使用super-->完全改寫
//		 * 		所以也不用拋出例外
//		 */
//	}
	
//	@Override
//	void setLeg(int leg) throws ParseException, IOException, FontFormatException {
//		/*		Override的例外要小於或少於父類別的例外
//		 * 		或者：不要Override該方法，直接另建新方法
//		 */
//		super.setLeg(leg);
//		if (leg > 1000) {
//			throw new FontFormatException("X");
//		}
//	}
	
	@Override
	void setLeg(int leg) throws ParseException, IOException {
		// 正常的版本
		super.setLeg(leg);
	}
	
}


