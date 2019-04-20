package tw.org.iii.myreview;

/**		20180805 多重介面的實作
 * 
 * @author SEAN
 *		介面可以多重繼承其他介面  (複合式的證照：先考A再考B，等於AB都要通過)
 *		-->但是介面沒有辦法再宣告implements，因為介面不能有實作
 *
 *		介面本身無法直接實作物件實體，但可由實作該介面的類別，製作出物件實體
 *
 *		類別只能單一繼承
 *		但是可以實現多重介面  (人可以考很多張證照)
 *
 *		參考網站：
 *		1)	https://www.jeffjade.com/2015/05/11/2015-05-11-java-extends-implement/
 */

public class Rev039_Interface2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

interface Rev0391 {
	void m1();
}

interface Rev0392 {
	void m2();
}

interface Rev0393 extends Rev0391, Rev0392 {
	void m3();
}

// 多重介面的實作
class Rev0394 implements Rev0393 {
	@Override
	public void m1() {
		
	}
	@Override
	public void m2() {
		
	}
	@Override
	public void m3() {
		
	}
}