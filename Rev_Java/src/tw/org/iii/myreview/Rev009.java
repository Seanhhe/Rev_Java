package tw.org.iii.myreview;
/**
 * 
 * @author SEAN
 *	基本功很重要
 *	思考如何解決一個問題
 *	if else -> 二分法 (boolean值: true或false)
 *	if 條件判斷式中使用 &&(AND), ||(OR), !(NOT) 的差異
 *		01. &&與OR 有"捷徑運算" : 
 *			01-01. 對&&來說, 只要左運算子為false -> 直接判斷為false
 *			01-02. 對||來說, 只要左運算子為true -> 直接判斷為true
 *		02. 使用&&, 左右兩邊運算子都會執行, 再判斷 true false
 *	
 *	另有位元運算, 會運用到 &(AND) |(OR) ^(XOR) ~(補數)
 *
 *
 */
public class Rev009 {

	public static void main(String[] args) {
		// 使用&& -> 左右兩個都會執行; 先判斷後執行++
		int a = 10, b = 3;
		if (a++ >= 10 && b-- <= 3) {
			System.out.println("OK1: a =" + a + ";b = " + b);
			//結果為OK1: a = 11; b = 2
		}else {
			System.out.println("NG1: a =" + a + ";b = " + b);
			//若為false, 左側執行完 則不再執行右側運算子,故b值沒減減
		}
		
		//	使用|| --> 由左至右執行, 先執行的若為true, 後面的跳過不執行, 直接判斷結果
		int c = 10, d = 4;
		if (c++ >= 10 || d-- <= 3) {
			System.out.println("OK2: c =" + c + "; d = " + d);
		}else {
			System.out.println("NG2: c =" + c + "; d = " + d);
		}
		
		//	--e, ++f => 先執行運算, 再比較
		int e = 11, f = 2;
		if (--e >= 10 && ++f <= 3) {
			System.out.println("OK3 : e =" + e + "; f = " + f);
		}else {
			System.out.println("NG3 : e = " + e + "; f = " + f);
		}
		
		// --g, ++h => 先執行運算,再比較
		int g = 10, h = 3;
		if (--g >= 10 || ++h<= 3) {
			System.out.println("OK4 : g = " + g + "; h = " + h);
		}else {
			System.out.println("NG4 : g = " + g + "; h = " + h);
		}
		
		
		//	|(OR) / &(AND) --> 二進位運算
		System.out.println(3 | 2); // 結果為3 (11)
		
		// ^ --> XOR 二進位運算
		System.out.println( 3 ^ 2); //結果為1 (01)
		// 二進位應用 -->影像處理 或 電路處理
		
		
		// JAVA 兩種結尾方式 --> 分號 或 大括號的程式區塊
		
		if (a >= 10);
		{
			//程式區塊
			System.out.println("III");
		}
		
	}

}
