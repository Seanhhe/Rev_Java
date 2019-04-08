package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *		20180805 參數自動轉型
 *			設計的類別參數有overload
 *			使用上參數需要強制轉型
 */

public class Rev033_parameter {

	public static void main(String[] args) {
		Rev0331_parameter obj1 = new Rev0331_parameter();
		byte a = 1, b = 2;
		obj1.m1(a);
		//傳入兩個byte 當沒有D版的時候  會有錯誤，
		//加入D可解決，或把C註解掉 (使用B版，b 自動轉型為int)
		obj1.m1(a, b);
		//obj1.m1(a, (int)b); //或是在傳入時強制轉型
	}

}

class Rev0331_parameter {
	void m1(byte a) {
		System.out.println("A");
	}
	
	void m1(byte a, int b) {
		System.out.println("B");
	}
	
	void m1(int a, byte b) {
		System.out.println("C");
	}
	
	void m1(byte a, byte b) {
		System.out.println("D");
	}
}
