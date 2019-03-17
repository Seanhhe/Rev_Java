package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *		
 *		20180804	Brad25 (Lab27) 建構式
 *
 *		> 任何一個類別都會有建構式
 *		> 因為任何一個類別都會有父類別
 *	> 如果類別內沒有定義建構式, 就會使用他的父類別的無傳參數建構式, 作為他的預設建構式.
 *	> 如果類別內有自己所定義的建構式, 就不再尋求父類別的無傳參數建構式
 */

public class Rev027 {

	public static void main(String[] args) {
//		Rev0271 b1 = new Rev0271();
		Rev0271 b2 = new Rev0271(2);
//		Rev0271 b3 = new Rev0271();	//	如果該類別有自訂建構式, 父類別就不會給預設建構式
		Rev0272 b4 = new Rev0272();
		
		Rev0271 b5 = new Rev0271(2);
		Rev0273 b6 = new Rev0273();
		
		System.out.println(" b2.equals(b5) : " + b2.equals(b5));	// 這裡的equals是Object的方法, 與String.equals不同. 所以是比較兩者是否為相同物件實體?
		System.out.println(" b2 == b5 : " + (b2 == b5));
		System.out.println(" b2.isSame(b5) : " + b2.isSame(b5));
		System.out.println("b2.equals(b2) : " + b2.equals(b2));
		System.out.println("b2.equals(b4) : " + b2.equals(b4));
		System.out.println("b2.equals(b6) : " + b2.equals(b6));
		
	}

}

class Rev0271 {
	private int a;
	
	Rev0271(int a) {
		//super();		<-- 呼叫父類別的建構式, 產生父類別的物件實體(所以才能呼叫父類別的方法?). 只能在第一道敘述句 (預設會自動產生此敘述句)
		this.a = a;
		System.out.println("Rev0271");
	}
	
	
	//	改寫父類別的方法 equals (快捷鍵: equ + alt + /)
	/*
	 * 	(non-Javadoc)
	 * 	
	 * 	@see java.lang.Object #equals(java.lang.Object)
	 * 	Override 改寫的存取修飾字需要大於或等於被改寫的父類別方法
	 * 	--> 發揚光大
	 */
	
//	@Override	// notation for compiler
//	public boolean equals(Object obj) {		// 存取修飾字要大於或等於原被改寫的方法
//		return ((Rev0271)obj).getA() == a;	// (Rev0271)obj		強迫轉型
//	}
	
	public int getA() {
		return a;
	}
	
	// 不Override equals --> 自創
	public boolean isSame(Rev0271 obj) {
		return this.getA() == a;
	}
	
}

/*		另建立一個Rev272並繼承Rev0271, 為何不能繼承?
 * 		沒有建構式-->尋求父類別的建構式-->當父類別只有參數建構式時 --> 編譯失敗
 *		
 *		!!
 *		任何物件只要在記憶體內存在, 其父類別以上的類別也都會存在於記憶體內.
 *		(祖宗八代都會在 XDDD)
 *		Java是透過建構式處理這部分
 */

//--------------------------------------

/*		建構式內容		20180804
 * 		如果第一道敘述句沒有寫super()或 this() --> 預設自動帶入 super();
 * 		
 * 		如果寫了 super() / super(參數); 就不寫this
 * 		如果寫了 this(); 就不寫super();
 * 
 */

class Rev0272 extends Rev0271{
	Rev0272(){
		//super();	// 第一道敘述句如果不寫, 其實有隱含super();在裡面
		super(3);	// super();永遠寫在建構式的第一道敘述句
					// -->先處理父類別的建構式. (父類別有傳參數建構式)
	}
}

class Rev0273 extends Rev0272 {
	// 第一道敘述句如果不寫, 其實有隱含super();在裡面
}