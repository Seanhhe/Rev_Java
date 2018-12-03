package tw.org.iii.myreview;

public class Rev005 {

	public static void main(String[] args) {
		// 字元型態
		// 字元永遠只能使用'', 宣告只能一個, 不能逗號隔開
		char c1 = 'a';
		System.out.println(c1);
		
		// 使用unicode編碼, 一個中文字為一個字元.
		char c2 = '資';
		System.out.println(c2);
		
		// ASCII CODE
		// 表達範圍2^16次方, 無正負號範圍(0-65535)
		// 65為A的 ASCII CODE
		char c3 = 65;
		System.out.println(c3); //結果為A
		
		// Unicode
		char c4 = '\u0041';
		System.out.println(c4); //結果為A
		
		// 0開頭視為八進位
		System.out.println(012);//結果為十進位的10
		
		// 0x開頭視為16進位
		System.out.println(0x12); //結果為十進位的18
		
		// 字元也可被當作整數運算
		int a1 = c1 + 4;
		System.out.println(a1);
		
	}

}
