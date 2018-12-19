package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *	迴圈應用練習_九九乘法表
 *	2X1=2 3X1=3 4X1=4
 *	2X2=4 3X2=6 4X2=8
 *
 *	console的標準縮排為8空格
 *
 *	解析:
 *	01. 先思考console如何印出-->由左至右
 *	02. 先想辦法印出第一列
 *	03. 帶入第一層迴圈
 *	04. 如何產生九列(乘上1~9)
 *	05. 帶入第二層迴圈
 *	06. 如何每四個換列
 *	07. 帶入第三層迴圈
 *	08. 變數怎麼改
 *	09. 注意! 每個常數都要有意義
 *
 */

public class Rev014_99 {

	public static void main(String[] args) {
	
//		System.out.print("2 X 1 = 2\t");
//		System.out.print("2 X 1 = 2\t");
//		System.out.print("2 X 1 = 2\t");

		// ***************************
		// 第一列完成, 接下來要跑九次
//		for (int a = 2; a<=5; a++) {
//			int c = a * 1;
//			System.out.print(a + " X " + " 1 " + " = " + c + "\t");
//		}
		
		// ***************************
		// 跑九次後調整變數, 處理換列問題
//		for (int t=1; t<10; t++) {
//			for (int a = 2; a <= 5; a++) {
//				int c = a * t;
//				System.out.print(a + " X " + t + " = " + c + "\t");
//			}
//			System.out.println();
//		}
		
		// **************************
		
		//	如何跑兩圈? 六到九的部分?
		
//		for (int r = 0; r < 2; r++) {
//			for (int t=1; t<10; t++) {
//				for (int a = 2; a <= 5; a++) {
//					int c = a * t;
//					System.out.print(a + " X " + t + " = " + c + "\t");
//				}
//				System.out.println();
//			}
//			
//			System.out.println("----------------------------------------");
//		}
		
		// **************************
		// 處理迴圈, 再處理變數的問題
		// 觀察目前print出的內容(上下兩列各差四)
		
		for (int r = 0; r < 2; r++) {
			for (int t=1; t<10; t++) {
				for (int a = 2; a <= 5; a++) {
					int newc = a + r*4; //上一行乘數與下一行乘數, 相差4
					int c = newc * t;
					System.out.print(newc + " X " + t + " = " + c + "\t");
				}
				System.out.println();
			}
			
			System.out.println("----------------------------------------");
		}

		
	}

}
