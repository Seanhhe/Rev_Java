package tw.org.iii.myreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rev067_02_ServerThreadCode extends Thread {
	private ServerSocket m_serverSocket; // 建立伺服器端的Socket物件，準備接收Client端的連線
	private Socket m_socket; // 建立Server和Client之間的連線通道
	
	//建構式
	public Rev067_02_ServerThreadCode(int port) {
		try {
			// 建立伺服器端的Socket，並且設定port
			m_serverSocket = new ServerSocket(port);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());//出現例外時，捕捉並顯示例外訊息
		}
	}

	@Override
	public void run() { // 覆寫Thread內的run()方法
		//super.run();
		try {
			m_socket = m_serverSocket.accept();//等待伺服器端的連線，若未連線則程式一直停在這裡
			System.out.println("連線成功！");
			
			m_serverSocket.close();//一旦連線成功建立，且不需要再接收其他連線，則可關閉ServerSocket
			
			//送出端的編寫必須和接收端的接收Class相同
			//使用Socket的 getInputStream()和getOutputStream()進行接收和發送資料
			//想要寫入字串可以用 PrintStream;
			//想要把各種基本資料型態，如int, double...等的"值"輸出，可以用DataOutputStream;
			//想要把整個物件 Serialize(序列化)，則可以用 ObjectOutputStream。
			
			PrintStream writer; // 使用PrintStream將字串進行編寫及送出
			BufferedReader reader; // 使用BufferedReader將資料進行接收和讀取
			
			writer = new PrintStream(m_socket.getOutputStream()); // 因為是將資料編寫至此socket並印出，所以是Output
			
			/**	BufferedReader在建構時接受一個Reader物件，
			 * 	在讀取標準輸入串流時，會使用InputStreamReader，
			 * 	它繼承了Reader類別
			 */
			reader = new BufferedReader(new InputStreamReader(m_socket.getInputStream())); //接收傳入的資料，所以是Input
			
			System.out.println("Client : " + reader.readLine()); // 讀取一行字串資料
			
			SimpleDateFormat sdFormat = new SimpleDateFormat("E yyyy/MM/dd hh:mm:ss"); // 設定時間格式
			String nowDate = sdFormat.format(new Date()); //取得現在時間
			
			writer.println("現在時間是：" + nowDate);//將資料寫進串流內
			writer.flush();//清空緩衝區並送出資料
			
			m_socket.close();//關閉socket連線
		} catch (IOException e) {
			System.out.println(e.getMessage());// 出現例外時，捕捉並顯示例外訊息(連線成功不會出現例外)
		}
	}
	
	
}
