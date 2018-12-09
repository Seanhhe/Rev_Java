package tw.org.iii.myreview;
	/**
	 * 
	 * @author SEAN
	 *
	 * 亂數產生分數，並判斷分數是否及格
	 * 及格 => PASS, 不及格 => FAILED
	 */
public class Rev007 {

	public static void main(String[] args) {
		//判斷
		//int score = 60;
		//用(int)強制轉型
		// random()取得亂數 double 0.0~1.0之間
		// 為什麼乘與101? -> 因要取得0~100的值
		
		int d1 = (int)(Math.random()*101);
		//System.out.println(d1);
		
		if (d1 >= 60) {
			System.out.println(d1);
			System.out.println("PASS");
		}
		else {
			System.out.println(d1);
			System.out.println("FAILED");
		}
		
		
		//產生亂數的骰子 6->亂數範圍內有幾個值, +1 -> 修正值(位移)
		int d2 = (int)(Math.random()*6) + 1;
		System.out.println(d2);
		
		// 產生範圍30~69的亂數
		int d3 = (int)(Math.random()* 43.3) + 30;
		System.out.println(d3);
		
		//產生成績
		//(區分A,B,C,D)
//		int score1 = (int)(Math.random()*101);
//		
//		if (score1 >= 90) {
//			System.out.println(score1);
//			System.out.println("A");
//		}else {
//			if (score1 >= 80) {
//				System.out.println(score1);
//				System.out.println("B");
//			}else {
//				if (score1 >= 70) {
//					System.out.println(score1);
//					System.out.println("C");
//				}else {
//					if (score1 >= 60) {
//						System.out.println(score1);
//						System.out.println("D");
//					}else {
//						System.out.println(score1);
//						System.out.println("E");
//					}
//				}
//			}
//		}
		
		//Java 沒有 if else if 語法
		//會看到的原因 -> 單列敘述句所演變而成
		//一層又一層->過濾機制
		int score1 = (int)(Math.random()*101);
		
		if (score1 >= 90) {
			System.out.println("A");
		}else if (score1 >= 80) {
			System.out.println("B");
		}else if (score1 >= 70) {
			System.out.println("C");
		}else if (score1 >= 60) {
			System.out.println("D");
		}else {
			System.out.println("E");
		}
		
		
		System.out.println("score :" + score1);
	}

}
