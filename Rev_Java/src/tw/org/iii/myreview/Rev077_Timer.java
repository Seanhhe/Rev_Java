package tw.org.iii.myreview;

import java.util.Timer;
import java.util.TimerTask;

/*		20180819PM1 Brad75
 * 		週期 / 預約任務
 * 		java.util.Timer
 * 				timer.shedule --> 依參數不同有延遲(週期)與預約
 * 
 * 		java.util.TimerTask
 * 				implements Runnable
 * 
 */

public class Rev077_Timer {

	public static void main(String[] args) {
//		Timer timer = new Timer();
//		MyTask myTask = new MyTask();
//		StopTimer stopTimer = new StopTimer(timer);
//		
//		//timer.schedule(myTask, (3*1000)); // 三秒鐘後執行 myTask(TimerTask)
//		//timer.cancel(); // 關閉timer => 整個程式也結束 (不好控制，需另尋方式)
//		timer.schedule(myTask, 1*1000, 1*1000); // 每隔一秒鐘執行一秒鐘  (週期任務)
//		timer.schedule(stopTimer, 10*1000); // 十秒後執行stopTimer
//		System.out.println("Here"); // 執行後紅燈還是亮著 --> 直到十秒後才stopTimer
		
		/*		測試 isDaemon 是否在背景執行
		 * 		Timer(boolean isDaemon)
		 * 		Timer(String name, boolean isDaemon)
		 * 		Daemon：背景常駐程式	(伺服器的程式通常稱為Daemon)
		 * 		=> 相依於前景程式
		 * 		=> false 不是Daemon 是前景; true 是背景程式，前景結束Daemon就結束
		 * 		=> 預設是false
		 */
		Timer timer = new Timer(true); // 設為true後直接結束
		MyTask myTask = new MyTask();
		//StopTimer stopTimer = new StopTimer(timer);
		timer.schedule(myTask, 1*1000, 1*1000); //每秒執行一次
		//timer.schedule(stopTimer, 10*1000);
		System.out.println("here：啟動myTask程式後的下一行");
		
	}
	/*	複習：若寫成內部類別，必須先擁有外部類別的物件實體；
	 * 	或將該內部類別宣告為 static
	 */
}

//外部類別
class MyTask extends TimerTask {
	// 設計一個時間到要做的事	(原本寫成內部類別，但是...請看上面複習)
	@Override
	public void run() {
		System.out.println("MyTask : OK");
	}
	
}

class StopTimer extends TimerTask {
	Timer timer;
	
	//建構式
	public StopTimer(Timer timer) {
		this.timer = timer;
	}
	
	@Override
	public void run() {
		System.out.println("結束");
		timer.cancel(); // 利用timer的方法，停止Timer及程式
		
		// system.exit(0);
		/*	有些人在寫視窗程式都會以System.exit(0);關閉視窗，
		 * 不過比較好的做法應該是dispose()才能釋放資源。
		 * 而且System.exit(0);會終止當前運行的 Java 虛擬機器，
		 * 試寫了一個按下新增鈕，就會開新視窗，多按幾下就會多開幾個，
		 * 最後隨便在其中一個視窗按下exit鈕執行System.exit(0);
		 * 全部的視窗都會關閉。
		 * 
		 */
	}
	
}
