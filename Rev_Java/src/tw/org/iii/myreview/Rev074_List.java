package tw.org.iii.myreview;

import java.util.LinkedList;

/*	20180818PM2 Brad72
 * 	Interface List<E> 介面
 * 	子實作：
 * 	ArrayList => 適用 資料不常異動
 * 	LinkedList => 適用 執行階段 資料、元素異動頻繁時
 * 	兩者在應用面上沒有太大的差別
 * 
 */

public class Rev074_List {

	public static void main(String[] args) {
		/*	參考文件
		 * 	http://akuma1.pixnet.net/blog/post/244432678-%E5%9F%BA%E7%A4%8E%E8%A8%93%E7%B7%B4%EF%BC%8D%EF%BC%8D%2809%29java%E8%88%87collection
		 * 	List => 1) 有順序性		2) 資料元素可重複
		 * 	Set  => 1) 沒有順序性	2) 資料元素不重複
		 * 	
		 * 	<E> 泛型	E  代表元素  =>  確保邏輯內的資料格式一致
		 */
		LinkedList<String> names = new LinkedList<>();
		names.add("Hello");
		names.add("Hi");
		names.add("Taiwan");
		names.add("Hello");
		names.add("Taiwan");
		System.out.println("names.size() : " + names.size()); // 重複的仍有計算
		System.out.println("names : " + names); // 按照順序
		System.out.println("-----分隔線-----");
		
		// 利用for each分別取出
		for (String out : names) {
			System.out.println(out);
		}
		System.out.println("-----分隔線-----");
		
		// 拿出指定序號的資料
		System.out.println("names.get(4) : " + names.get(4)); // index從 0 起算
		
	}

}
