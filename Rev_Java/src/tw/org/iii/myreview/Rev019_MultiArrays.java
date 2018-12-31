package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *
 *	認識多維陣列
 *
 *	陣列是存放在記憶體的位址
 *	要以線性的觀念來理解, 而非空間
 *
 * 					  |--[0]
 * 			  |---[0]=|--[1]
 *            |   指向   |--[2]
 *            |
 * 			  |
 * int[][] b =|
 *            |       |--[0]
 *            |       |--[1]
 *            |---[1]-|--[2]
 *                    |--[3] 
 *                    
 *	永遠用一維的觀點看多維 (因為是線性的關係)
 *
 *	前一層決定了才可決定下一層
 *
 *	for each的用法 --> 尋訪陣列(著重在讀出陣列的值, 而非其Index)
 *		冒號左邊的變數是被尋訪陣列的元素型別
 *	
 */

public class Rev019_MultiArrays {

	public static void main(String[] args) {
		int[][] a = new int[2][3];	// 第一個陣列有兩個元素, 第二個陣列代表了第一個陣列每個元素內還有幾個陣列數
		int[][] b = new int[2][]; // 不對稱陣列的宣告方式
		b[0] = new int[3];
		b[1] = new int[4];
		
		System.out.println("----陣列a----");
		System.out.println("陣列a長度: " + a.length);
		System.out.println("陣列a[0]長度: " + a[0].length);
		System.out.println("陣列a[1]長度: " + a[1].length);
		System.out.println();
		System.out.println("----陣列b----");
		System.out.println("陣列b長度: " + b.length);
		System.out.println("陣列b[0]長度: " + b[0].length);
		System.out.println("陣列b[1]長度: " + b[1].length);
		
		System.out.println();
		
		System.out.println("------尋訪陣列a------");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + ",");
			}
			System.out.println();
		}
		
		System.out.println("------尋訪陣列b------");
		
		// 尋訪陣列b
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j] + ",");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("------用for each尋訪陣列a------");
		
		// for each 練習  
		// (尋訪陣列的另一種方法: 著重在取出陣列內的值, 而非index)
		for (int[] layer1: a) {		// 尋訪陣列a, 並將內容存放在變數layer1
			for (int layer2: layer1) {
				System.out.print(layer2 + ";");
			}
			System.out.println(); //換列
		}
		
		System.out.println();
		System.out.println("------用for each尋訪陣列b------");
		
		for (int[] layer1: b) {
			for (int layer2: layer1) {
				System.out.print(layer2 + ";");
			}
			System.out.println();
		}
		
		/**
		 * 	for-each迴圈
		 * 	當我們想要存取一個陣列或集合裡面的元素時, for-each迴圈是個簡單且有效率的方法
		 * 	(參考網址: https://openhome.cc/Gossip/JavaEssence/Foreach.html)
		 * 	(https://www.geeksforgeeks.org/for-each-loop-in-java/)
		 * 	(http://lakesd6531.pixnet.net/blog/post/342603565-java-for-each%E8%BF%B4%E5%9C%88%E7%9A%84%E7%94%A8%E6%B3%95)
		 * 
		 * 	格式:
		 * 	for (元素型別 迴圈變數: 集合或陣列名稱){
		 * 		//迴圈主體
		 * 	}
		 * 
		 * 	
		 * 
		 */
		
	}

}
