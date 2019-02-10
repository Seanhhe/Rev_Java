package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *		
 *		
 */

public class Rev024_TWid {

	public static void main(String[] args) {
		
		//	static 練習
		//Rev024_TWid_class.checkId("123");
		//Rev024_TWid_class.m1("123");
		
		//	必須擁有物件才可以執行m1方法(當物件內的建構式沒有static時)
		//Rev024_TWid_class id1 = new Rev024_TWid_class();
		//id1.m1("AAA");
		//id1.checkId("1123");
		
		//	假設使用者使用檢查身分證程式
		if (Rev024_TWid_class.checkId("A123456789") == true) {
			System.out.println("OK");
		}else {
			System.out.println("NG");
		}
		
		//	字串處理API練習-->為了第一個英文字判斷
		
		
	}

}
