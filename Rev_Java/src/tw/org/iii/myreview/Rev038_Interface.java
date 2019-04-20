package tw.org.iii.myreview;

public class Rev038_Interface {
	/**		20180805	Brad36	介面	Interface
	 * 
	 * 		Interface
	 * 		與類別同等級
	 * 		<< 類似swift中的protocol
	 * 		概念上接近規格
	 * 		介面不可直接建立物件實體
	 * 		不會有任何實作方法 (但在Lambda中可以有預設的一個)
	 * 		介面中所有方法都是抽象方法
	 * 		介面不用做存取修飾字的宣告，永遠都是public，因為沒有實作方法所以沒有安全性問題
	 * 		裡面定義的方法每個都是public
	 * 		定規格-->供其他人實作
	 * 		就是要表現多型<--與抽象類別一樣
	 * 		介面的實作可以多重--> 一個人考多張證照 (不像繼承只能單一繼承)
	 * 
	 */
	public static void main(String[] args) {
		Rev0383 obj1 = new Rev0383();
		Rev0382 obj2 = new Rev0383();
		
		// obj1 與 obj2 可呼叫的方法同之前觀念，要看回其宣告的類別
		obj2.m2(); //輸出"Rev0383:m2()"
	}

}

interface Rev0381 {
	void m22();
	void m23();
}

interface Rev0382 {	//介面	定規格
	void m1();
	void m2();
}

class Rev0383 implements Rev0382 {
	@Override
	public void m1() {
		//要加上public，因為來源的interface的方法定義是public
		
	}
	
	@Override
	public void m2() {
		System.out.println("Rev0383:m2()");
	}
	
	void m3() {
		
	}
}

abstract class Rev0384 implements Rev0382 {
	// 如果只有做一個介面裡的方法，可在宣告為抽象類別
	@Override
	public void m1() {
		//	TODO
		
	}
	
	abstract public void m2();
}

class Rev0385 implements Rev0382, Rev0381 { //介面可以多重實作(implements)
	@Override
	public void m1() {
		
	}
	@Override
	public void m2() {
		
	}
	@Override
	public void m22() {
		
	}
	@Override
	public void m23() {
		
	}
}