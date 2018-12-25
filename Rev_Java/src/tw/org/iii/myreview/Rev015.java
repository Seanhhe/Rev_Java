package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *
 *	迴圈應用練習_質數檢查
 *	1~100標出質數
 *
 *	01.先印出1~100
 *	02.如何找質數? (維基百科)
 *	03.用迴圈檢查每個產出的數字是否為質數
 *	04.建立boolean值預設是質數, 判斷紀錄
 *	05. 利用條件運算式(三元運算式)在為質數的值前面加上標記
 *
 *	三元運算式 --> boolean?true時要做的:false要做的
 *
 */

public class Rev015 {

	public static void main(String[] args) {
		// 質數作業檢查
		// 1~10一列的表格, 可寫一圈或兩圈的for
		// 判斷質數 --> 做到j < j開根號; j/2; 全部檢查
		
		// ******一圈的版本******
		
//		long start = System.currentTimeMillis(); // 千分之一秒的現在時間(與 1970/01/01 0:00:00[unix紀元] 計算-->Timestamp)
//		
//		for (int i = 1; i <= 100; i++) {
//			
//			// 判斷是否為質數
//			boolean isPrime = true; 		// 初始值
//			for (int j = 2; j < i ; j++) {	// 依序檢查當下的i是否為質數
//				if (i % j == 0) {
//					isPrime = false; // 非質數
//					break; // 跳離
//				}
//			}
//			
//			// print out
//			// 運用三元運算式
//			System.out.print(i + (isPrime?"*":" ") + "\t");
//			if (i % 10 == 0) {
//				System.out.println();
//			}
//		}
//		System.out.println("運算時間: " + (System.currentTimeMillis() - start)); // 現在時間減去起始時間
	
		// ******兩圈的版本******
		// 花費時間11
		// 有問題,為何4會被標記為質數?!
		System.out.println("------效率更好的版本 (數字除二)------");
		
		long start = System.currentTimeMillis();	// 千分之一秒的現在時間 (timestamp)
		for (int i = 1; i <= 100; i ++) {
			boolean isPrime = true;
			for (int j = 2; j< (i/2); j++) {	//依序檢查當下的i是否為質數
				if (i%j == 0) {
					isPrime = false;
					break;
				}
			}
			System.out.print((isPrime?"*":" ") + i + "\t");
			if (i%10 == 0) {System.out.println();}
		}
		System.out.println(System.currentTimeMillis() - start); // 印出從啟動到結束的時間
		
	}

}
