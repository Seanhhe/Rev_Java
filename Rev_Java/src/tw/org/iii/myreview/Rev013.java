package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *	無窮迴圈
 *	for (;;) {
 *		// 可做好事也可做壞事
 *		// 好事: 伺服器應用
 *		// 壞事: DOS攻擊
 *	}
 */

public class Rev013 {

	public static void main(String[] args) {
		/** for 迴圈執行順序
		 * 	for (step1; step2/step5; step4) {
		 * 			step3-1
		 * 	}
		 *  step3-2
		 *  =========
		 *  step1: 進來後只做一次
		 *  step2: 條件判斷
		 *  step3-1: 內容執行
		 *  step3-2: 跳出迴圈後執行
		 *  step4: 每跑完一圈做一次
		 *  step5: 檢查
		 *  
		 *  -->如果沒寫, 就跳過不做, 預設為true
		 *  
		 */
		
		//------範例一------
		for (int i = 0; i < 10; i++) {
			System.out.println(i+";");
		}
		
		System.out.println();
		System.out.println("------範例二------");
		
		//------範例二------
		int a = 0;
		for (; a < 3;) {
			System.out.println("inside: " + a + ";");
			a++;
		}
		System.out.println("outside: " + a);
		
		System.out.println();
		System.out.println("-----範例三-----");
		
		// ------範例三------
		int b = 0; // b->全域變數
		for (m1(); b < 10;) { 
			System.out.println(b + ";");
			b++;
		}
		System.out.println("\noutside: " + b);
		
		System.out.println();
		System.out.println("---範例四---");
		
		//------範例四------
		
		int c = 0;
		for (m1(); c < 12; System.out.println("*****")) {
			System.out.println(c++);
		}
		System.out.println("final: " + c);
		
		//-----範例五(無窮迴圈)-----
		System.out.println();
		System.out.println("----範例五(無窮迴圈)----");
		
		int d = 0;
		for (m1(); ; System.out.println("$$$$$")) {
			System.out.println(d++);
		}
	}
	
	public static void m1() {
		int a = 10, b = 3;
		System.out.println("m1: " + (a/b));
	}

}
