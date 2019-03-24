package tw.org.iii.myreview;

/**		NOTE 20180805 String API 字串API複習
 * 	
 * @author SEAN
 *		字串有+=運算, 其結果與 .concat方法一樣, 官方建議使用concat. (因為不會破壞原物件內容, 會產生新字串物件)
 *		String 方法中, 回傳String的都是方法產生新的字串物件, 不破壞原物件內容.
 *
 *		split 方法-->把字串切割成字串陣列 String[]
 *
 *		String的父類別-->Object
 *		Object.方法--> 大概有個印象
 *
 *		某API該頁的Method Summary表, 包含其類別新增的方法與改寫父類別的方法
 *
 *		下方inherited則為繼承自父類別的方法們
 *
 *		> 在String中被override的Object方法：hashcode/toString/equals...
 *		
 *		Object.hashcode(); -->快速判別兩個物件是否為不相同的物件
 *				*hash 雜湊
 *				當判斷為似乎相同時, 由equals處理比對來真正確認是否為相同物件.
 *	
 *		Object.toString(); -->把物件轉換為字串?的方法
 *				*任何場合都可用
 */

/**		NOTE 20180805 Brad27
 * 		為什麼印出的東西不一樣? --> 字串toString Override
 * 
 * 		官方建議字串儘量不要有所異動
 * 		字串內容如有經常性的變更，請使用StringBuffer 或	StringBuilder
 * 		StringBuffer: JDK 1.0
 * 
 * 		>為什麼StringBuilder的方法只能 append StringBuffer ?
 * 
 * 		StringBuilder: JDK 1.5
 * 		原本要替代StringBuffer, 但在多重緒的執行上不保證比較安全
 * 		比StringBuffer快, 但差異不大
 * 
 * 
 * 		>JAVA 注重跨平台而非運行效能
 * 		>		前幾年的更新著重提升效能, 近幾年則主要針對語言的精簡化
 * 		>		快就不一定安全
 * 
 */

public class Rev029_String2 {

	public static void main(String[] args) {
		int a = 10;
		System.out.println(a); // 印出整數10
		
		String str1 = new String("Brad");
		System.out.println(str1); // 印出Brad
		
		Rev0291 obj1 = new Rev0291();
		System.out.println(obj1);	// 預設印出記憶體位址
		
		Rev0291 obj2 = new Rev0291();
		System.out.println(obj2);	// override後, 印出Hello
		System.out.println("obj1 == obj2 : " + (obj1 == obj2));	// 比較是否指向同一個物件實體
		System.out.println("obj1.equals(obj2) : "+ obj1.equals(obj2)); // equals沒有override 所以還是false
	}

}

class Rev0291 {		// Override toString
	@Override
		public String toString() {
			return "Hello";
	}
}
