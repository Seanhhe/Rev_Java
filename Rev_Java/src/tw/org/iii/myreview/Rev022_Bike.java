package tw.org.iii.myreview;

/**
 * 	這裡通常會有import
 * 	例如: 常用的java.lang預設自動import
 * 	除了java.lang之外, 如果有使用到都要import
 * 
 * 	類別:
 * 	因為java是純物件導向
 * 	所有東西都在類別中
 * 	沒有類別不會有物件
 * 
 * 	類別不能執行, 只能用來產生物件
 * 	執行的是呼叫的特殊方法
 */

/**
 * 	public-->存取修飾字
 * 		一個java原始檔中只會有一個public類別, 名稱必須跟檔名相同
 * 		類別只有兩種狀況, 有public or 沒有...
 * 		public-->全都可以存取; 	沒寫: 只有相同package才可存取 
 */

/**
 * 		一個物件 \ 類別擁有(has)某些屬性 / 方法
 * 		靜態-->屬性field
 * 		動態-->方法method
 * 		重點在屬性-->方法會相同或不便, 但屬性會改變, 差異在屬性
 * 		設計類別-->設計其屬性與方法
 * 
 * 		物件彼此最大的差別在於屬性
 * 
 * 		這個類別所製造出來的物件
 * 		設計者在意何種屬性, 再依據屬性設計方法
 */

import java.io.Serializable;

/**
 * 	物件類別: Rev022_Bike
 * 	以Bike為例建立物件類別
 * 
 * 	Java的字串是物件, 擁有很多方法
 */

public class Rev022_Bike implements Serializable{
	
	/**
	 * 		屬性名稱全小寫
	 * 
	 * 		方法名稱命名慣例: 動詞/介係詞+屬性名稱
	 * 		動詞/介係詞-->全小寫
	 * 		屬性名稱-->首字大寫
	 * 		例如: getSpeed
	 * 
	 * 		
	 * 		方法宣告傳回值
	 * 		-->其名稱前要加上型別 double getSpeed() {}
	 */
	
	/**
	 * 		屬性封裝:
	 * 		屬性名稱前加上private, 讓屬性只能在此類別內使用-->屬性封裝
	 * 		方法也可以封裝for 內部呼叫
	 * 		封裝讓使用者無法直接改變屬性, 或是方法僅限內部使用
	 */
	
	/**
	 * 		屬性的存取修飾字: (由範圍大到小)
	 * 		public : 全世界
	 * 		protected : 相同package或繼承的子類別
	 * 		沒有寫 : 同路徑可以存取
	 * 		private : 只有類別中可以存取, 範圍最小, 盡量以此為預設
	 */
	
	// 宣告屬性 (若宣告private便會限制其存取範圍)
	double speed;
	
	/**
	 *  建構式 constructor
	 *  	慣例放在宣告屬性後
	 *  	不是靜態的
	 *  	永遠不會有回傳值
	 *  	建構式名稱必須跟類別名稱相同(大小寫嚴格區分)
	 *  	可以接收參數
	 *  
	 *  	建構式是在進行該物件的初始化 (物件建立時一開始要是什麼樣子)
	 *  
	 *  	可以有很多建構式
	 */
	Rev022_Bike(){ //建構式初始化
		speed = 0;
		System.out.println("BIKE Initiate");
	}
	
	// 可輸入速度的建構式
	Rev022_Bike(double speed){
		this.speed = speed;		// this.speed 本類別的物件實體的
	}
	
	// Method 方法
	void upSpeed() {	// 宣告upSpeed()方法, void->沒有傳回, ()->沒有傳入值
		this.speed = this.speed == 0?1:this.speed*1.4; 
	}
	
	// 可變速 (overload-->保持呼叫方法名稱, 僅參數或型別不同)
	void upSpeed(int gear) {
		speed = speed == 0?1:speed*1.2*gear;
	}
	
	void downSpeed() {
		speed = speed==1?0:speed*0.5; // 三元運算式
	}
	
	// 宣告方法-->回傳速度的值給使用者
	double getSpeed() {
		return speed;
	}
}
