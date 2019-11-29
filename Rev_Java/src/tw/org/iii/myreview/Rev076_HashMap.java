package tw.org.iii.myreview;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/*		20180819AM2 Brad74
 * 		Interface_Map
 * 		=> Key 不會重複  (如果重複設定是會覆蓋前面的)
 * 		=> 沒有順序性，在意的是key & value的對應
 * 
 * 		實作=> HashMap
 * 
 * 		可應用=>稍早做過的簽名程式	(座標的x, y)
 * 
 */

/*	Map、HashMap、TreeMap
 * 	Map 是一種方便使用者存放key-value 的一種集合，而且它也很接近 Set 與 List
 * 	的集合體，存放 key 時使用 Set，存放value 時使用List。
 * 	
 * 	Map的 Key 是使用 Set 的方式儲存的，所以 Key 是不能重複的，而 Value 是用
 * 	List 的方式儲存，所以 Value 是可以重複的。
 * 
 * 	而 Map 中的 Key 因為使用 Set 的方式儲存，
 *	所以跟 Set 一樣，有HashSet、TreeSet，
 *	而 Map 則有 HashMap 與 TreeMap，
 * 	主要都是針對Key的部分。
 * 
 * 	參考網址：
 * 	http://akuma1.pixnet.net/blog/post/244432678-%E5%9F%BA%E7%A4%8E%E8%A8%93%E7%B7%B4%EF%BC%8D%EF%BC%8D%2809%29java%E8%88%87collection
 */

public class Rev076_HashMap {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		// .put(key, value)
		map.put("name", "John");
		map.put("stage", 2);
		map.put("sound", false);
		map.put("other", 2);
		map.put("other", 2); //覆蓋了第一個other=2
		map.put("other", 4); //覆蓋了第二個other=2，所以 = 4
		System.out.println("map : " + map); //key只有4個，所以value只有四組
		System.out.println("map.get(\"name\") : " + map.get("name"));
		System.out.println("map.get(\"stage\") : " + map.get("stage"));
		
		System.out.println("-----尋訪各Key值-----");
		
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key);
		}
//		for (String key : map.keySet()) {
//			System.out.println(key + " : " + map.get(key));
//		}
		
		System.out.println("-----value 方法-----");
		// Returns a Collection view of the values contained in this map.
		
		Collection<Object> v1 = map.values();
		for (Object obj : v1) {
			System.out.println(obj);
		}
	}

}
