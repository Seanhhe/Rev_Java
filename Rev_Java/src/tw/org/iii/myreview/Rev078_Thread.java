package tw.org.iii.myreview;

/*		20180819PM2 Thread 多重執行緒  Brad76
 * 
 * 		Thread => 實作 Runnable 介面
 * 		new Thread
 * 		=> 新執行緒
 * 		=> 代表一個任務
 * 		=> 通常一個執行緒只做一件獨立的事	(完整的一件事)
 * 		=> 主緒往下執行，遇到一個執行緒start，是將其交到Run pool中排隊等候執行。
 * 				CPU把時間做很細的切割
 * 				每個時間點到的時候，CPU在 Run Pool 中選擇一個執行緒來做，時間到了換下一個 (讓人感到很像同步執行)
 * 				如範例的t1 / t2 因沒有設定優先等級，先執行的機率是相同的。
 * 				在各時間點重複挑選到相同的機率很低
 * 				沒有sleep前，看不出來同時執行，因迴圈在其分割週期內衣下就跑完了
 * 		=> start 時間週期性不強 (sleep無法控制時間週期，只能做延遲性)
 * 		=> 完整的一個任務執行，做完後生命結束 (物件還在，是其表現的生命沒了)，無法再呼叫start，但可以呼叫物件方法run()
 * 		=> 生命週期-->表現同步的效果
 * 		=> run 物件方法--> 就只是順序執行(生命特徵表現在run方法中)
 * 		=> wait()：所有object都有， for Thread (媽媽等小明去買醬油)
 * 		=> notify()：某執行緒完成後發出通知	(買回醬油後跟媽媽說)
 * 		=> 提早結束執行緒：不要用stop方法(不安全)，而是透過邏輯方法中止(例如 break)
 * 
 * 		Thread.sleep(static method)
 * 		=> 睡覺	(從Run Pool中被踢出)
 * 		=> 當下的CPU就沒人占用了，CPU會再挑下一個 (所以sleep後才會發現迴圈交替執行了)
 * 		=> 有插斷例外拋出 (睡到一半被叫醒)
 * 		=> 睡醒後是回到Run Pool內排隊，不一定是馬上執行。
 * 			所以時間上，從睡著到睡醒後執行，時間會大於等於睡著的時間。
 * 
 * 		** Timer & TimerTask
 * 		=> 執行緒與Timer完全不同
 * 		=> 同步的觀念在於時間週期
 * 		=> 時間到要做的那件事
 * 
 * 		執行緒應用：程式運行時同時至網路撈資料
 */

public class Rev078_Thread {

	public static void main(String[] args) {
//		Rev0781 t1 = new Rev0781();
//		Rev0781 t2 = new Rev0781();
//		t1.start();	//開始執行緒的生命週期
//		t2.start();
//		System.out.println("OK");
//		// 通常主執行緒會先印，但其實是同時執行
//		// 多跑幾次會發現OK有時會在最下面或兩個執行緒間
		
		Rev0781 t1 = new Rev0781("t1");
		Rev0781 t2 = new Rev0781("t2");
		t1.start();
		t2.start();
		System.out.println("OK2");
		
		try {
			Thread.sleep(3*1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Wake UP");
		//t1.start(); // java.lang.IllegalThreadStateException
		t1.run();
		t2.run();
	}

}

class Rev0781 extends Thread {
	String name;
	
	Rev0781() {
		// 無傳參數建構式
	}
	
	Rev0781(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " _ " + i);
			
			try {
				// 讓執行緒睡覺 => 體會執行緒的感覺
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("有問題" + e.getMessage());
			}
		}
	}
	
	
}
