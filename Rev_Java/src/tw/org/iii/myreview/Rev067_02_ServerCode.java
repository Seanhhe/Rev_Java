package tw.org.iii.myreview;

/*	使用Java本身提供的ServerSocket 和 Socket來進行連線的動作
 * 	且 ServerSocket的接受連線方法accept()會讓程式停頓(直到成功連線為止)
 * 	所以必須使用 Thread 執行緒。
 * 
 * 	區分為 Server和 Client的"主程式碼"，連線部分需使用Thread，故另寫一個類別
 * 	分別新增Class，命名為 ServerThreadCode 和 ClientThreadCode
 * 	
 */

public class Rev067_02_ServerCode {

	public static void main(String[] args) {
		// 建立物件，傳入port並執行等待接受連線的動作
		new Rev067_02_ServerThreadCode(8000).start();
	}

}
