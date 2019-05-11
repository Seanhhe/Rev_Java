package tw.org.iii.myreview;

/*		類別
 * 
 */


public class Rev042 {

	public static void main(String[] args) {
		Rev001 obj1 = new Rev001();
		
		// 名字相同但import只能寫一個，故須把完整檔名寫出 p2.Rev001
//		p2.Rev001 obj2 = new p2.Rev001();
		
		// 因為存取修飾字： p2.Lab02 非public 只能由相同package的類別來存取
		// p2.Lab02 obj2 = new p2.Lab02();
	}

}
