package tw.org.iii.myreview;

/*		20180825AM1 Brad79 Thread
 * 		執行緒的另一個議題
 * 		=> 執行過程中，插入另外一個執行緒	=> join
 * 
 * 		run & join 的差異
 * 		run => 循序執行
 * 		join => 可以是同一執行緒內，也可能是兩個不同執行緒，讓他插隊
 */

public class Rev081_Thread {

	public static void main(String[] args) {
		Rev0811 obj1 = new Rev0811("A");
		obj1.start();
		
		try {
			Thread.sleep(1000);// main thread 睡一秒
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		// 大於等於1秒之後才會到這裡
		Rev0811 obj2 = new Rev0811("B");
		obj2.start(); // 不代表馬上執行，只代表進到Run Pool
		
		System.out.println("OK1");
		
		// 插入obj2在 Main Thread 下
		try {
			// 在A執行緒中呼叫 B執行緒.join => 插入到A中
			obj2.join();
			//obj2.join(2000); // 只join兩秒，兩秒後又是三條緒在跑
			// OK2最後才執行
			
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("OK2");
	}

}

class Rev0811 extends Thread {
	// 建立屬性
	private String name;
	
	public Rev0811(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		/*		A原本寫法是把try-catch寫在迴圈內
		 * 		有何差異？(結構)
		 * 		或是說發生例外時要break
		 * 		A 與 B 的差異？
		 * 		=> A: 發生例外時該次拋出例外，但還會繼續迴圈
		 * 		=> B: 發生例外時會直接拋出例外，並跳離迴圈
		 */
//		for (int i = 0; i < 10; i++) {
//			// A
//			System.out.println(name + " : " + i);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				System.out.println(e.getMessage());
//			}
//		}
		
//			try {
//				// B
//				for (int i = 0; i < 10; i++) {
//					System.out.println(name + " : " + i);
//					Thread.sleep(500);
//				}
//			} catch (InterruptedException e) {
//				// 發生例外時直接離開迴圈
//				System.out.println(e.getMessage());
//			}
		
		try {
			// 無窮迴圈 AM2 00:15:00
			// obj1 / obj2 生命結束前只要到 i%3==0 => new Rev0811 => 無窮迴圈
			for (int i = 1; i < 5; i++) {
				System.out.println(name + " : " + i);
				if (i % 3 == 0) {
					Rev0811 obj2 = new Rev0811(name + i);
					obj2.start();
					obj2.join();
				}else {
					Thread.sleep(500);
				}
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

		
	}
	
	
}