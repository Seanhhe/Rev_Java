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
		
		int d1 = (int)(Math.random()*100);
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
	}

}
