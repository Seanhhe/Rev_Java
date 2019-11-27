package tw.org.iii.myreview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/*		20180818PM2 Brad71 JAVA 資料結構
 * 		Collection 介面 => 規格
 * 		其子介面 (定義的更細節)
 * 			java.util.Set / List
 * 
 * 		Set的特性
 * 		1.	沒有順序性
 * 		2.	裡面的元素不會重複
 * 
 * 		=> 重點在於如何使用！
 * 
 * 		>	例如其實作的類別	HashSet
 * 		HashSet的方法	iterator (迭代器)
 * 			=> 將物件一個一個取出 (取完後迭代器會自動銷毀)
 * 
 * 		<E>	泛型	E 代表元素
 * 		=> 確保邏輯內的資料格式一致
 * 
 * 		List 特性 (與Set相反)
 * 		1.	有順序性
 * 		2.	裡面的元素可重複
 */

public class Rev073_Collection {

	public static void main(String[] args) {
//		HashSet set = new HashSet<>();
//		set.add(12);
//		set.add(34);
//		set.add("Hello");
//		set.add(new Rev022_Bike());
//		set.add(12); // 元素不會重複，所以數量還是只有上面四個
//		set.add(34);
//		
//		// 裡面有幾個元素
//		System.out.println(set.size());
//		
//		// 印出內容，會發現內容無順序性
//		System.out.println(set.toString());
		
		/*
		 * 		應用		=> 樂透？
		 * 		選出的號碼不會重複，不須順序性
		 * 
		 * 		選出的號碼做排序	=> 可是SET不是沒有順序性嗎？
		 * 		排序與順序不同
		 * 		=> 利用TreeSet
		 * 
		 * 		洗牌程式也可利用泛型來做
		 * 
		 * 		Set 其他應用：
		 * 		手機裝置藍芽搜尋
		 * 			=>	發出封包後，其他裝置可能多次回應
		 * 			=>	列表不可重複，不須順序性
		 */
		
		//	簡易樂透隨機選號
		//	運用泛型限定只有 Integer
		System.out.println("-----簡易特透隨機選號-----");
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size() < 6) { // 把產生的整數加入HashSet中，並設定迴圈條件
			set.add((int)(Math.random()*49+1)); //隨機從1-49取號
		}
		System.out.println("樂透隨機選號：" + set);
		
		System.out.println("-----分隔線-----");
		
//		System.out.println("Set (TreeSet 及 HashSet)用法示範");
//		// https://blog.xuite.net/jane17512001/PenguinDesign/116288117-%E5%AE%B9%E5%99%A8%28Container%29%E3%80%81ArrayList%E3%80%81HashSet%E3%80%81TreeSet%E3%80%81HashMap%E3%80%81TreeMap
//		TreeSet treeSet = new TreeSet();
//		//加入資料(如果TreeSet內尚未重複的話，就加入資料，並回傳boolean值)
//		System.out.println(treeSet.add((int)1));
//		System.out.println(treeSet.add(3));
//		System.out.println(treeSet.add(3));
//		System.out.println(treeSet.add(2));
//		System.out.println(treeSet.add(4));
//		//取得資料數量
//		System.out.println("取得資料數量 = " + treeSet.size());
//		//判斷是否有某一筆資料
//		System.out.println("判斷是否有某一筆資料.contains() : " + treeSet.contains(1));
//		//移除資料 (成功移除的話，回傳boolean值)
//		System.out.println("移除資料4 : .remove() = " + treeSet.remove(4));
//		//列出所有資料
//		// https://openhome.cc/Gossip/DesignPattern/IteratorPattern.htm
//		Iterator iterator = treeSet.iterator(); 
//		/*
//		 *	Collection介面下的iterator()方法，它會回傳iterator物件，
//		 *	所以要先建立 Iterator 物件來指定。 
//		 */
//		while(iterator.hasNext()) {
//			System.out.println("列出所有資料 iterator.next() : " + iterator.next());
//		}
		
		System.out.println("-----樂透隨機選號V2_TreeSet-----");
		//	樂透隨機選號V2_TreeSet
		//	TreeSet 預設以ASCII方式排序，由小到大  (SortedSet介面的實作類別)
		TreeSet<Integer> set1 = new TreeSet<>();
		while(set1.size() < 6) {
			// 隨機從1-49取號
			set1.add((int)(Math.random()*49+1));
		}
		System.out.println("set1 : " + set1);// 由小到大排序
		
		System.out.println("-----取得樂透選出的數字(透過迭代器)-----");
		//	取得樂透選出的數字
		Iterator<Integer> it = set.iterator();
		/*
//		 *	Collection介面下的iterator()方法，它會回傳iterator物件，
//		 *	所以要先建立 Iterator 物件來指定。 
//		 */
		while(it.hasNext()) {
			Integer num = it.next(); // 因為前面有宣告泛型，不然這裡會需要強制轉型
			System.out.println(num); // 迭代器內的元素一個個搬出後，迭代器會自動銷毀
		}
		
		System.out.println("-----取得選出的數字: 第二招-----");
		// 取得選出的數字：第二招	(for...each)
		// 陣列、collection 都可以for each
		for (Integer num : set1) {
			System.out.println(num);
		}
	}

}
