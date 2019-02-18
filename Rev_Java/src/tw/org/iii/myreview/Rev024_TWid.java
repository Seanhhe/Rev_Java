package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *		
 *		
 */

public class Rev024_TWid {

	public static void main(String[] args) throws Exception {
		
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
		
		//	英文字串長度
		String a = "A123456789";
		System.out.println(a.length());
		
		//	中文字串長度
		String b = "資策會";
		System.out.println(b.length());		//一中文字算一字元
		
		//	substring	(回傳一個新物件)
		String c = "abcdefg";
		System.out.println(c.substring(2, 3));	//	輸出c
		System.out.println(c.substring(0, 4));	//	輸出abcd
		//	charAt(index);
		System.out.println(c.charAt(0));	//輸出a
		
		//	.indexOf
		String c1 = "A123456789";
		String c2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String c3 = c1.substring(0, 1);
		
		if (c1.length() == 10) {
			if (c2.indexOf(c3) >= 0) {
				System.out.println("OK1");
			}
		}else {
			System.out.println("False");
		}
		
		//	.matches + [正規表示法]
		if (c1.matches("^[A-Z][12][0-9]{8}$")) {
			System.out.println("REGEX check OK");
		}else {
			System.out.println("Noooooooo");
		}
		
		String d = "0912123456";
		if (d.matches("^09........$")) {
			System.out.println("PHONE");
		}else {
			System.out.println("ORZ");
		}
		
		//	課外練習:	如何檢查Email?
		
		System.out.println("--------------------");
		
		if (Rev024_TWid_class.checkId("A123456789") == true) {
			System.out.println("ID correct");
		}else {
			System.out.println("ID error");
		}
		
		/**
		 * 		.concat() --> 回傳一個新的字串,舊字串+傳入的新字串
		 * 		這個方法呼叫重點在於 return
		 * 		字串內容一旦給定/該物件一旦形成, 該字串不能更改.
		 * 		可運用string buffer
		 * 		指向新的記憶體位址(含舊字串與新字串)
		 * 		原記憶體位址沒人指向
		 * 
		 * 		要擁有一個字串的物件實體 (招數如下)
		 * 		1.	(呼叫建構式)new 出新物件
		 * 		2.	透過其他static方法傳回物件實體
		 * 
		 */
		
		String e = "0912123456";
		System.out.println(e.concat("abc"));	//輸出0912123456abc
		
		//測試createId
		Rev024_TWid_class id1 = Rev024_TWid_class.createTWid("A12345678");
		System.out.println("id1是否為null? : " + (id1 == null));	//輸出false
		System.out.println("id1 = " + id1);	//輸出id1的記憶體位址
		System.out.println("以下---四個建構式測試 & 地區 & 性別 顯示 (共五種方法)---");
		
		
		//	測試四個建構式	(五種方法)
		Rev024_TWid_class id2 = new Rev024_TWid_class();
		System.out.println(id2.getId()); //+ " " + id2.gender() + " " + id2.showArea());
		
//		Rev024_TWid_class id3 = new Rev024_TWid_class(true);
//		System.out.println(id3.getId() + " " + id3.gender() + " " + id3.showArea());
//		
//		Rev024_TWid_class id4 = new Rev024_TWid_class(10);
//		System.out.println(id4.getId() + " " + id4.gender() + " " + id4.showArea());
//		
//		Rev024_TWid_class id5 = new Rev024_TWid_class(false, 15);
//		System.out.println(id5.getId() + " " + id5.gender() + " " + id5.showArea());
//		
//		Rev024_TWid_class id6 = Rev024_TWid_class.createTWid("A123456789");
//		System.out.println(id6.getId() + " " + id6.gender() + " " + id6.showArea());
//		
//		
////		if (Rev024_TWid_class.checkId2("A123456789") == true) {
////			System.out.println("checkId2檢查的ID2 correct");
////		}else {
////			System.out.println("ID2 NG");
////		}
	}

}
