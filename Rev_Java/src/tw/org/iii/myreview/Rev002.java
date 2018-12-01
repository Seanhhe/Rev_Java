package tw.org.iii.myreview;

public class Rev002 {

	public static void main(String[] args) {
		int a1 = 10, a2 = 3;
		int a3 = a1 + a2;
		int a4 = a1 - a2;
		
		int a5 = a1 / a2;
		int a6 = a1 / (int)3.0;
		//int a6 = a1 / 3.0; 不可這樣寫
		//int 與 int 運算結果仍為int
		//
		
		//	byte short int 之間相互運算, 結果為int
		//	byte short int long之間相互運算, 結果為long
		byte b1 = 10, b2 = 3;
		int b3 = b1 / b2;
		byte b4 = (byte)(b1 / b2); //強制轉型
		
		byte b5 = 10 + 3;
		//byte b5 = b1 + 3; 不能完成編譯
		// 10 + 3 是常數運算 (常數是固定不變的)
		// b1(變數) + 3(常數)
		
		
		//宣告型別  其值只能在型別規範的範圍之內
		byte b6 = 127;
		b6++;	//運用位元運算(位元移動)而非數字加減, 再如何加減都在範圍內
		System.out.println(b6); //答案是-128
		b6--;
		System.out.println(b6); //127
		b6 += 4;
		System.out.println(b6); //答案是-125
		b6 -= 4;
		System.out.println(b6); //127
		//b6 = b6 + 1; 不能完成編譯, 這是屬於數字的運算
		//b6 = (byte)(b6 + 1);  //可編譯
		//System.out.println(b6); //-128
		
		// int 型別
		int b7 = 2;
		b7 = b7 + 1;
		System.out.println(b7); //答案是3
	}

}
