package tw.org.iii.myreview;

public class Rev012 {

	public static void main(String[] args) {
		//switch
		
//		char a = 97; //可
//		short a = 97; //可
//		int a = 97; //可
		byte a = 'A'; //可
		
//		long a = 123; // long不行, 編譯跳警告
//		float a = 12; // float不行
//		double a = 123; // double不行
//		boolean a = true; // boolean不行
		
		// 基本型態中, switch只能用byte, int, short, char
		// float, double, long, boolean, String 都無法使用
		
		switch (a) {
		case 97:
			System.out.println("a");
			break;
		case 'A':
			System.out.println("A");
			break;
		case 10:
			System.out.println("10");
			break;
//		case '資':		// 因為資的16進位超出byte的範圍
//			System.out.println("資");
//			break;
//		case true:
//			System.out.println("true");
//			break;
		default:
			System.out.println("default");
			break;
		
		}
		
		System.out.println("-----範例二 (類別/物件型別的字串可以比)-----");
		
		// 類別型態的字串也可以進行比對
		
		// 另外一提, 字串跟字元在JAVA中的關係分很開的>_<
//		String a = 'a'; //指定字元 (單引號) 給字串會編譯失敗
		
		String b = "Hi";
		
		switch (b) {
		case "Hello":
			System.out.println("Hi!");
			break;
		case "Hi":
			System.out.println("Hello!");
			break;
		default:
			System.out.println("default2");
			
		}
		
	}

}
