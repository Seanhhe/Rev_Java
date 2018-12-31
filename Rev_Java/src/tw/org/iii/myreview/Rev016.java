package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *
 *	for 迴圈結構
 *	標籤介紹
 *		continue <-- 以下不做直接跳回開頭 (到此結束, 繼續下一次迴圈)
 *		break	 <-- 脫離目前所在的迴圈
 *
 *	標籤: <-- 給for迴圈使用, 僅能緊跟著要指定的迴圈敘述, 如for, while, do...while等
 *		break + 標籤		<-- 脫離標籤指定的迴圈
 *		標籤命名原則與變數相同
 *		continue也可以使用標籤 --> continue D1;
 *
 *	補充: 陣列與字串在JAVA, 都被視為物件
 *
 */

public class Rev016 {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				continue;	//以下不做直接跳回開頭 (到此結束, 繼續下一次迴圈)
			}
			System.out.print(i + ";");
		}
		
		System.out.println();
		
		H1:		// 給for迴圈使用的標籤 (僅能緊跟著要指定的迴圈敘述, 如for, while, do...while等)
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j <10; j++) {
				if (i + j >= 10) {
//					break;		// 脫離所在迴圈
					break H1;	// 脫離H1迴圈
				}
				System.out.println(i + ":" + j);
			}
		}
		System.out.println("After H1");
	}
	
	

}
