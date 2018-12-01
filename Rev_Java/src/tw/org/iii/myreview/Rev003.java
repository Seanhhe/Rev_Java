package tw.org.iii.myreview;

public class Rev003 {

	public static void main(String[] args) {
		// 浮點數
		// float f1 = 1.2; //1.2被視為 double, 12被視為 int
		float f1 = 1.2f;
		double s1 = 12.3;
		
		f1++;
		System.out.println(f1); //答案是2.2
		f1 += 10;
		System.out.println(f1); //答案是12.2
		
		
		//運算
		long a1 = 10;
		float a2 = a1 + f1;
		System.out.println(a2); //答案是22.2
		
		double a3 = 12;
		double a4 = a3 + f1; 
		System.out.println(a4); //答案是24.199999809265137
		//位元範圍 double 大於 float
	}

}
