package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *
 *		身分證字號產生器&驗證器
 *		身分證字號物件
 *		屬性: id
 *
 *		設計流程:
 *
 *		01.先決定需要什麼功能
 *		02.建立屬性
 *		03.確定初始化-->建構式要做什麼
 *		04.方法建立-->如何檢查ID
 *		05.產生的ID都要先經過檢查
 *		06.建構式產生時就要產生新ID
 *
 *		從使用者觀點下手, 需要什麼樣的功能/方法
 *		目標:
 *		01.產生合法的ID
 *		02.是存在的值
 *
 *		static 關鍵字
 *		01. 不屬於任何一個物件, 是該類別所擁有的 (書上講法?!)
 *		02.是屬於這個類別可以呼叫的, (只是為了分類的要求, 例如像是random是分類在Math中)
 *		03.是功能性的東西, 與物件無關
 *		04.static裡面不會有該類別所在的物件存在
 *		05.物件可以呼叫static方法 (物件存在, 該類別就存在)
 *		06.static方法只能呼叫static方法
 */

/**
 * 
 * @author SEAN
 *		設計方向
 *		01.確認使用者輸入的格式正確
 *			a.長度	.length()
 *			b.第一碼為英文字	.charAt(0), .subString(), .matches()
 *			c.第二碼為數字1或2
 *			d.第三碼至最後一碼全是數字
 *		02.進入身分證檢查公式
 */

/**
 * 
 * @author SEAN
 *		正規表示法		[各大系統都支援, 很重要]
 *		^ 開始
 *		$ 結尾
 *		[A-Z]字元集合範圍內取一個 	例: [0-9], [12]
 *		{重複次數}
 *		. 代表該字元任何字都可以
 */

public class Rev024_TWid_class {
	
	// 屬性建立
	// 參考維基: https://zh.wikipedia.org/wiki/%E4%B8%AD%E8%8F%AF%E6%B0%91%E5%9C%8B%E5%9C%8B%E6%B0%91%E8%BA%AB%E5%88%86%E8%AD%89
	private String id;	//類別可以擁有另外一個類別實體(String)
	static final String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO"; // String的方法-->indexOf
	static final String numChars = "0123456789";	//for method: checkId2
	
	/**
	 * 	建構式內容
	 * 	如果第一道敘述句沒有寫super()/this() --> 預設自動帶入super();
	 * 	
	 * 	如果寫了super() / super(參數); 就不寫this
	 * 	如果寫了this(); 就不寫super();
	 */
	
	//	建構式	(物件的初始化)
	//	只有
	Rev024_TWid_class() {
		//	隨機給男女(true/false), 呼叫isMale執行
		//	這裡的this -> 呼叫本類別的(建構式)
		this((int)(Math.random()*2)==0);
	}
	
	Rev024_TWid_class(boolean isMale){
		// 兩個參數(使用者輸入, 亂數產生地區碼0-25)
		this(isMale, (int)(Math.random()*26));
	}
	
	Rev024_TWid_class(int area) {
		// 兩個參數(隨機產生true/false, 使用者輸入地區)
		this((int)(Math.random()*2)==0, area);
	}
	
	Rev024_TWid_class(boolean isMale, int area) {
		String i1 = letters.substring(area, area+1);
		String i2 = isMale?"1":"2";
		
		// 寫法一
//		String newId = i1 + i2 +
//				(int)(Math.random()*10) +
//				(int)(Math.random()*10) +
//				(int)(Math.random()*10) +
//				(int)(Math.random()*10) +
//				(int)(Math.random()*10) +
//				(int)(Math.random()*10) +
//				(int)(Math.random()*10) +
//				(int)(Math.random()*10);	//字串加整數=字串
//		System.out.println("newId: " + newId);
		
		/**
		 * 	 寫法二
		 *	newId2 物件導向寫法-->組合第一碼到第九碼
		 *	使用concat (會包含舊字串回傳新字串)
		 *	(參考文件: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#concat(java.lang.String))
		 *	valueOf (Returns the string representation of the int argument.)
		 *	(參考文件: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#valueOf(int))
		 */
		
		String newId2 = i1.concat(i2)
						.concat(String.valueOf((int)(Math.random()*10)))
						.concat(String.valueOf((int)(Math.random()*10)))
						.concat(String.valueOf((int)(Math.random()*10)))
						.concat(String.valueOf((int)(Math.random()*10)))
						.concat(String.valueOf((int)(Math.random()*10)))
						.concat(String.valueOf((int)(Math.random()*10)))
						.concat(String.valueOf((int)(Math.random()*10)));
		
		//	最後一碼檢查碼	(正確就產生正式ID回傳)
		//	執行checkId_方法來檢查
		for (int i = 0; i <9; i++) {
			if (checkId(newId2+i)) {
				this.id = newId2 + i;
				break;
			}
		}
	}
	
	// 方法_身分證驗證法1	(加上static 可以讓別人單獨呼叫此方法-->使用者輸入id檢查)
	static boolean checkId(String id) {
		boolean isCorrect = false;
		//	驗證規則參考 (https://zh.wikipedia.org/wiki/%E4%B8%AD%E8%8F%AF%E6%B0%91%E5%9C%8B%E5%9C%8B%E6%B0%91%E8%BA%AB%E5%88%86%E8%AD%89#%E9%A9%97%E8%AD%89%E8%A6%8F%E5%89%87)
		if (id.matches("^[A-Z][12][0-9]{8}$")) {
			// 基本格式驗證成功, 依據公式驗證
			int n12 = letters.indexOf(id.charAt(0)) + 10;	//轉換字元-->把id的index=0的值讀出(字元), 給letters.indexOf(字元)讀出屬於第幾號index--> 加10就可得知對應的轉換字元
			int n1 = n12 / 10;	//參考等價表
			int n2 = n12 % 10;
			//	把字串變成整數
			int n3 = Integer.parseInt(id.substring(1, 2));
			int n4 = Integer.parseInt(id.substring(2, 3));
			int n5 = Integer.parseInt(id.substring(3, 4));
			int n6 = Integer.parseInt(id.substring(4, 5));
			int n7 = Integer.parseInt(id.substring(5, 6));
			int n8 = Integer.parseInt(id.substring(6, 7));
			int n9 = Integer.parseInt(id.substring(7, 8));
			int n10 = Integer.parseInt(id.substring(8, 9));
			int n11 = Integer.parseInt(id.substring(9, 10));
			// 驗證規則	(https://zh.wikipedia.org/wiki/%E4%B8%AD%E8%8F%AF%E6%B0%91%E5%9C%8B%E5%9C%8B%E6%B0%91%E8%BA%AB%E5%88%86%E8%AD%89#%E9%A9%97%E8%AD%89%E8%A6%8F%E5%89%87)
			int sum = n1*1 + n2*9 + n3*8 + n4*7 + n5*6 + n6*5 + n7*4 + n8*3 + n9*2 + n10*1 + n11*1;
			isCorrect = sum % 10 == 0;
		}
		System.out.println(isCorrect);
		return isCorrect;
	}
	
	// 方法_身分證驗證法2
//	static boolean checkId2 (String id) {
//		boolean isRight = false;
//		//	不用.matches的方法
//		if (id.length() == 10) {	//比對字串長度是否10個字元
//			if (letters.indexOf(id.charAt(0)) >= 0) {	//比對字串第一個字元, 是否有在裡面 (沒有會回傳-1)
//				if (id.charAt(1) == '1' || id.charAt(1) == '2') {	//比對字串第二個字元(性別)
//					for (int i = 2; i <= 9; i++) {
//						for (int j = 0; j <= 9; j++) {
//							if (id.charAt(i) == numChars.charAt(j)) {
//								// 基本格式驗證成功, 依據公式驗證
//								int n12 = letters.indexOf(id.charAt(0)) + 10;	//轉換字元-->把id的index=0的值讀出(字元), 給letters.indexOf(字元)讀出屬於第幾號index--> 加10就可得知對應的轉換字元
//								int n1 = n12 / 10;	//參考等價表
//								int n2 = n12 % 10;
//								//	把字串變成整數
//								int n3 = Integer.parseInt(id.substring(1, 2));
//								int n4 = Integer.parseInt(id.substring(2, 3));
//								int n5 = Integer.parseInt(id.substring(3, 4));
//								int n6 = Integer.parseInt(id.substring(4, 5));
//								int n7 = Integer.parseInt(id.substring(5, 6));
//								int n8 = Integer.parseInt(id.substring(6, 7));
//								int n9 = Integer.parseInt(id.substring(7, 8));
//								int n10 = Integer.parseInt(id.substring(8, 9));
//								int n11 = Integer.parseInt(id.substring(9, 10));
//								// 驗證規則	(https://zh.wikipedia.org/wiki/%E4%B8%AD%E8%8F%AF%E6%B0%91%E5%9C%8B%E5%9C%8B%E6%B0%91%E8%BA%AB%E5%88%86%E8%AD%89#%E9%A9%97%E8%AD%89%E8%A6%8F%E5%89%87)
//								int sum = n1*1 + n2*9 + n3*8 + n4*7 + n5*6 + n6*5 + n7*4 + n8*3 + n9*2 + n10*1 + n11*1;
//								isRight = sum % 10 == 0;
//							}
//						}
//					}
//				}
//			}
//		}
//		return isRight;
//	}
	
	//	方法_回傳該物件的身分證字號
	String getId() {
		return this.id;
	}
	
	// 建立供內部呼叫的方法	[新的id]
	private Rev024_TWid_class(String id) {
		this.id = id;
	}
	
	//	方法_產生回傳新身分證字號	(因為建構式本身沒有回傳, 所以要透過static方法才能回傳新的id字串)
	static Rev024_TWid_class createTWid(String id) {	//型別是物件型別?
		if (checkId(id)) {	//確認產生的id合格
			return new Rev024_TWid_class(id);	//回傳新的id物件
		}else {
			return null;
		}
	}
	
	//	方法_讓使用者可以輸入id判斷男女	(字串版)
	String gender() {
		if (this.id.charAt(1) == '1') {
			return "男性";
		}else {
			return "女性";
		}
	}
	
	//	方法_顯示男女(true/false版)
	boolean gender2() {
		boolean gender2 = false;
		if (this.id.charAt(1) == '1') {
			gender2 = true;
		}
		return gender2;
	}
	
	//	方法_查詢地區
	String showArea() {
		String[] areaName = {	//照10~35編碼順序排列
			"台北市","台中市","基隆市","台南市","高雄市",
			"新北市","宜蘭縣","桃園市","新竹縣","苗栗縣",
			"台中縣","南投縣","彰化縣","雲林縣","嘉義縣",
			"台南縣","高雄縣","屏東縣","花蓮縣","台東縣",
			"澎湖縣","陽明山管理局","金門縣","連江縣",
			"嘉義市","新竹市"
		};
		int i = 0;
		for (; i < 26; i++) {
			if (this.id.charAt(0) == letters.charAt(i)) {	//比對字串中的字元
				// 如果id的第0個字元等於letters內的第i個字元
				// 找到了
				break;
			}
		}
		return areaName[i];
	}
	
	//	static使用體驗
//	boolean m1(String id) {
//		System.out.println("m1_method");
//		return true;
//	}
	
	
}
