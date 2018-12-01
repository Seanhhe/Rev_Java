package tw.org.iii.myreview;

public class Rev001 {

	public static void main(String[] args) {
		byte b1; //宣告變數b1, 型別為byte (範圍-128~127 -> 256 -> 2^8)
		byte b2 = 15;
		byte b3 = 127;
		byte b4 = -128; //若超出範圍, IDE會出現警告訊息
		//	變數命名規則: 第一碼[a-zA-Z$_], 第二碼[a-zA-Z0-9$_]*   // *正規表示法
		//  不要使用到關鍵字
		
		byte $_$ = 123;
		byte 變數1 = 123; //Java支援unicode(2^24次方)
		
		short s1 = 128; //2^16次方
		short s2 = 32767;
		//short s3 = 32768;
		
		//整數
		int a1 = 123; //	2^32次方 約43億 (10位數)
		
		// 基本型別最大範圍 (基本型別共有8種)
		long l1 = 123; // 2^64次方
		

		
	}

}
