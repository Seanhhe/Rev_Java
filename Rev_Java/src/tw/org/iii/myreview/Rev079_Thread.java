package tw.org.iii.myreview;

import java.util.TimerTask;

/*		20180825AM1 Brad77
 * 
 * 		執行緒 Thread
 * 		介面	Runnable
 * 
 * 		執行緒的應用最常用於兩大方向：
 * 		檔案 I/O
 * 		網路的存取 (UDP或TCP) (ServerSocket to Socket)
 * 
 * 		Thread 建構式
 * 			Thread(Runnable target)
 * 
 */

public class Rev079_Thread {

	public static void main(String[] args) {
		// Thread的物件實體(因為她的父類別)
		Rev0791 obj1 = new Rev0791();
		
		// 不是Thread物件實體，只是一個Runnable的物件實體
		// 所以她沒有start方法
		Rev0792 obj2 = new Rev0792();
		
		obj1.start();
//		obj2.run(); // 沒有start方法，只有物件方法run
		
		// 用obj2 (Runnable物件)建立Thread物件實體，這樣才有start方法可執行
//		Thread t2 = new Thread(obj2);
//		t2.start();
		
		// Rev0793 => TimerTask 物件實體
		Rev0793 obj3 = new Rev0793();
		// 利用obj3建立 Thread object
		Thread t3 = new Thread(obj3);
		t3.start();
		
		Thread t4 = new Thread(obj2) {
			/*		匿名實作
			 * 		物件的Override
			 * 		想改寫但又不想另建新的類別
			 * 		=> Override obj2的 run 方法
			 */

			@Override
			public void run() {
				//super.run();
				System.out.println("t4 匿名實作 obj2");
			}
		};
		t4.start();
		
		//------------------------------------------
		/*		另一種精簡版的寫法
		 * 		建立執行緒 => 在意的是該方法做的事情，所以不另外建立新的物件類別
		 * 
		 * 		通常會這樣使用的原因
		 * 		=>	只會用一次
		 * 		=>	沒有特別需要提供給外部呼叫
		 */
		new Thread() {
			int a;
			@Override
			public void run() {
				//super.run();
				for (int i = 10000; i < 10020; i++) {
					System.out.println("No name : " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			}
			public void test1() {
				System.out.println(a);
			}
			
		}.start();
		
		System.out.println("OK");
	}

}

class Rev0791 extends Thread {
		// 繼承執行緒但卻不能再繼承其他父類別 => 設計上受限
		// Rev0791的物件實體是執行緒的物件實體
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("Rev0791: " + i);
			try {
				Thread.sleep(100);
				// 讓顯示效果明顯一點
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

class Rev0792 implements Runnable {
	// 改以繼承介面 Runnable 的方法
	// Lab792的物件實體不是執行緒(Thread)的物件實體，只能說是Runnable的物件實體
	// 處理執行緒建議使用這個方法，因為彈性較大。
	// (但是若沒有要繼承的類別需求，直接繼承Thread即可)
	
	@Override
	public void run() {
		for (int i = 100; i < 120; i++) {
			System.out.println("Rev0792: " + i);
			try {
				Thread.sleep(100);
				// 讓顯示效果明顯一點
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

class Rev0793 extends TimerTask {
	/*	TimerTask本身也有實作Runnable
	 * 	也可以拿來建構Thread物件實體	[Thread(Runnable object)]
	 */
	@Override
	public void run() {
		for (int i = 1000; i < 1020; i++) {
			System.out.println("Rev0793 : " + i);
			try {
				Thread.sleep(100); // 讓執行緒延遲效果明顯一點
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}