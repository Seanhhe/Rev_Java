package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *	
 *	隨機擲骰子次數計算
 *	擲一百次, 紀錄各點出現的次數
 *
 */

public class Rev018_Dice {

	public static void main(String[] args) {
		
		// Version 1 先用一般變數 (不用陣列的寫法)
//		int d1, d2, d3, d4, d5, d6, e;
//		d1 = d2 = d3 = d4 = d5 = d6 = e = 0;
//		
//		for (int i = 0; i < 100; i++) {
//			int dice = (int)(Math.random() * 6) + 1;
//			switch (dice) {
//			case 1:
//				d1++;
//				break;
//			case 2:
//				d2++;
//				break;
//			case 3:
//				d3++;
//				break;
//			case 4:
//				d4++;
//				break;
//			case 5:
//				d5++;
//				break;
//			case 6:
//				d6++;
//				break;
//			default:
//				e++;
//			}
//		}
//		if (e > 0) {
//			System.out.println("Bug: " + e);
//		}else {
//			System.out.println("Dot1: " + d1 + "times" );
//			System.out.println("Dot2: " + d2 + "times" );
//			System.out.println("Dot3: " + d3 + "times" );
//			System.out.println("Dot4: " + d4 + "times" );
//			System.out.println("Dot5: " + d5 + "times" );
//			System.out.println("Dot6: " + d6 + "times" );
//		}
		
		System.out.println("------Ver3. 使用陣列寫法------");
		
		
		// 使用陣列的寫法 (擲一百萬次)
		int[] dice = new int[7];
		for (int i = 1; i <=1000000; i++) {
			int dot = (int)(Math.random() * 6) + 1;
			if (dot >= 1 && dot <= 6) {
				dice[dot]++; // 正常情況下, 應出現1~6, 然後累加出現次數
			}else {
				dice[0]++; // dice[0]代表不正常的情況下, 出現的次數
			}
			
		}
		if (dice[0] == 0) { // dice[0]==0 代表"沒有異常出現"為true
			for (int j = 1; j < dice.length; j++) {
				System.out.println("Ver2.Dot_" + j + ":" + dice[j] + "times");
			}
		}else {
			System.out.println("Bug: " + dice[0] + " times");
		}
		
//		-----------------------------
		
		System.out.println("------Ver.4 提高部分點數的機率------");
		
		/**
		 * 	如何提高機率? (提高4,5,6點機率)
		 * 	平分機率至9份
		 * 	把多的3份分到4,5,6點
		 * 	點數1(機率1/9), 點數2(機率1/9), 點數3(機率1/9),
		 * 	點數4(機率2/9), 點數5(機率2/9), 點數6(機率2/9)
		 * 
		 */
		
		int[] dice2 = new int[7];
		
		for(int i = 0; i < 10000; i++) {
			int point = (int)(Math.random() * 9 + 1);
			if (point >= 1 && point <= 9) { // 確保點數在正確範圍內
				dice2[point>6?point-3:point]++; // 大於6的點數加到4,5,6點
			}else {
				dice2[0]++; // bug 異常次數記錄
			}
		}
		if (dice2[0] == 0) {
			for(int j = 1; j < dice2.length; j++) {
			System.out.println("Dots" + j + ":" + dice2[j] + "times Ver.4");
			}
		}else {
			System.out.println("BUG: " + dice2[0] + "times Ver.4");
		}
	}

}
