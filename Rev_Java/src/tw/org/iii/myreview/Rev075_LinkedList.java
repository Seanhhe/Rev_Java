package tw.org.iii.myreview;

import java.util.LinkedList;

/*		20180818PM2 Brad73 LinkedList 小練習
 * 		輸入端是：0123456789
 * 		輸出端要反過來：9876543210
 * 
 */

public class Rev075_LinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> numbers = new LinkedList<>();
		
		for (int i = 0; i < 10; i++) {
			numbers.addFirst(i);
			System.out.println("(Before) numbers = " + numbers);
			//numbers.add(0, i); // 指定輸入的值放到第0個位置  (starting at the specified position)
		}
		System.out.println("(After) numbers = " + numbers);
	}

}
