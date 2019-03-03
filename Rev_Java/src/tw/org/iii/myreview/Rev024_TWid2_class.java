package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *
 *		台灣身分證字號驗證/產生器(Rewrite)
 *
 *		目標:
 *		01.使用者可以輸入身分證字號驗證是否正確
 *		02.依使用者需求(地區/性別)亂數產生身分證字號
 *
 */

public class Rev024_TWid2_class {
	
	//	Fields 屬性
	private String id;
	static final String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO"; // String的方法-->indexOf"
	
	
	//	Constructor	建構式
	
	Rev024_TWid2_class() {	//1號
		//	隨機產生地區,讓建構式自己呼叫 2-->4
		this((int)(Math.random()*26));
	}
	
	Rev024_TWid2_class(int area) {	// 2-->4
		this(area, (int)(Math.random()*2) == 0);
	}
	
	Rev024_TWid2_class(boolean isMale) {	// 3-->4
		//	auto create id by gender
		this((int)(Math.random()*26), isMale);
	}
	
	Rev024_TWid2_class(int area, boolean isMale) {	// 4號
		//	真正產生id的引擎	(宣告物件的同時初始化-->產生合格新id)
		String a1 = letters.substring(area, area+1);
		String a2 = isMale?"1":"2";
		
		/**
		 *	newId2 物件導向寫法-->組合第一碼到第九碼
		 *	使用concat (會包含舊字串回傳新字串)
		 *	(參考文件: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#concat(java.lang.String))
		 *	valueOf (Returns the string representation of the int argument.)
		 *	(參考文件: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#valueOf(int))
		 */
		
		String newId = a1.concat(a2)
//		newId = a1.concat(a2)
						.concat(String.valueOf((int)(Math.random()*10)))
						.concat(String.valueOf((int)(Math.random()*10)))
						.concat(String.valueOf((int)(Math.random()*10)))
						.concat(String.valueOf((int)(Math.random()*10)))
						.concat(String.valueOf((int)(Math.random()*10)))
						.concat(String.valueOf((int)(Math.random()*10)))
						.concat(String.valueOf((int)(Math.random()*10)));
		//	第十碼 檢查碼
		/**
		 * 	避免NullPointException的關鍵
		 * 	就是for迴圈裡的判斷式
		 * 	i <= 9, 迴圈可跑0到9
		 * 	 而不是 i<9, 迴圈只能跑0到8
		 * 	
		 * 	
		 */
		for (int i = 0; i <= 9; i++) {
			System.out.println("newId : " + newId + " i : " + i);	//	測試顯示
			if (checkId(newId+i)) {
				this.id = newId + i;
				break;
			}else {
				System.out.println("null~");	//	測試顯示
				this.id = null;	//	清空
			}
		}
	}

	//	Methods 方法
	//	驗證
	static boolean checkId(String id) {
		boolean isCorrect = false;
		if (id.matches("^[A-Z][12][0-9]{8}$")) {
			//驗證規則參考 (https://zh.wikipedia.org/wiki/%E4%B8%AD%E8%8F%AF%E6%B0%91%E5%9C%8B%E5%9C%8B%E6%B0%91%E8%BA%AB%E5%88%86%E8%AD%89#%E9%A9%97%E8%AD%89%E8%A6%8F%E5%89%87)
			int a12 = letters.indexOf(0) + 10;
			int a1 = a12 / 10;
			int a2 = a12 % 10;
			int a3 = Integer.parseInt(id.substring(1, 2));
			int a4 = Integer.parseInt(id.substring(2, 3));
			int a5 = Integer.parseInt(id.substring(3, 4));
			int a6 = Integer.parseInt(id.substring(4, 5));
			int a7 = Integer.parseInt(id.substring(5, 6));
			int a8 = Integer.parseInt(id.substring(6, 7));
			int a9 = Integer.parseInt(id.substring(7, 8));
			int a10 = Integer.parseInt(id.substring(8, 9));
			int a11 = Integer.parseInt(id.substring(9, 10));
			int sum = a1*1 + a2*9 + a3*8 + a4*7 + a5*6 + a6*5 + a7*4 + a8*3 + a9*2 + a10*1 + a11*1;
			isCorrect = (sum % 10 == 0);
		}
		return isCorrect;
	}
	
	//	供使用者讀取id
	String getId() {
		System.out.println("getId() : " + id);
		return this.id;
	}
	
	//	產生新ID, 透過static方法回傳
	static Rev024_TWid2_class createId(String id) throws Exception{
		if (checkId(id)) {
			return new Rev024_TWid2_class();
		}else {
			//return null;
			System.out.println("不合格的身分證字號");
			throw new Exception();
		}
	}
	
	//	建立Rev024_TWid2_class方法給內部呼叫
//	private Rev024_TWid2_class(String id) {
//		this.id = id;
//	}
}
