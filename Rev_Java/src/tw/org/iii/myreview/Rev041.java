package tw.org.iii.myreview;

/*		20180811 Review 內部類別	Brad39
 * 
 */

public class Rev041 {

	public static void main(String[] args) {
		/*		產生內部類別的物件實體：
		 * 		要先產生外部類別的物件實體，才能存取內部類別，建立內部的這個物件實體
		 * 		(has-a的概念)
		 */
		
		Rev0411 obj1 = new Rev0411();
		Rev0411.Rev0412 obj2 = obj1.new Rev0412(); // 411的412物件
		System.out.println("obj2.m1() : " + obj2.m1()); // 收到的傳回資料是記憶體位址
		
		
		Rev0411.Rev0413 obj3 = new Rev0411.Rev0413();
		obj3.m1();
		
		Rev0411.Rev0413.m2();
	}

}

class Rev0411 { // 外部類別
	private int a = 10; // 外部類別的屬性
	
	class Rev0412 {
		// 我是內部類別
		
//		void m1() {
//			System.out.println("Rev0411-0412 m1()");
//			// 印出 int a (內部類別可以存取外部類別的屬性)
//			System.out.println("a : " + a);
//			System.out.println("Rev0411.this.a : " + Rev0411.this.a);
//		}
		
		Rev0411 m1() {
			// 由內部類別來傳回外部類別的物件實體
			// 外部物件相關設定的動作可能會這樣使用
			return Rev0411.this;
		}
	}
	
	static class Rev0413 {
		/*		static 內部類別
		 * 		->不需要外部類別的物件實體就可以建立物件實體
		 * 		(就像: Math.random() )
		 * 		->只是歸類在Rev0411類別下
		 */
		void m1() {
			System.out.println("Rev0411's Rev0413: m1()");
		}
		
		static void m2() {
			// static 不用建立物件就可以呼叫方法
			System.out.println("Rev0411's Rev0413: m2() static");
		}
	}
}

