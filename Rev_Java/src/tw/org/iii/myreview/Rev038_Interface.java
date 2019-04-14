package tw.org.iii.myreview;

public class Rev038_Interface {
	/**		20180805	Brad36	介面	Interface
	 * 
	 * @param args
	 * 		Interface
	 * 		與類別同等級
	 * 		<< 類似swift中的protocol
	 * 		概念上接近規格
	 * 		介面不可直接建立物件實體
	 * 		不會有任何實作方法 (但在Lambda中可以有預設的一個)
	 * 		介面中所有方法都抽象
	 * 		介面不用做存取修飾字的宣告，永遠都是public，因為沒有實作方法所以沒有安全性問題
	 * 		裡面定義的方法每個都是public
	 * 		定規格-->供其他人實作
	 * 		就是要表現多型<--與抽象類別一樣
	 * 		介面的實作可以多重--> 一個人考多張證照 (不像繼承只能單一繼承)
	 * 
	 */
	public static void main(String[] args) {
		
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

