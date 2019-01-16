package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *	while & do...while 前測與後測迴圈
 */

public class Rev021 {

	public static void main(String[] args) {
		int a = 1;
		while(a < 10) {
			System.out.println(a++);
		}
		
		// 比較上下兩者, 有沒有很像
		
		int b = 1;
		for (;b < 10;) {
			System.out.println("b: " + (b++));
		}
		
		// 後測迴圈
		
		int c = 1;
		do {	// 先做一次
			System.out.println(c++);
		}while(c < 10);	//判斷要不要繼續執行迴圈
	}

}
