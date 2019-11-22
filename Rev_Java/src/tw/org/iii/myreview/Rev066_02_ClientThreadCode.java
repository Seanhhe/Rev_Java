package tw.org.iii.myreview;

import java.io.BufferedReader;

/**		SimpleDateFormat可參考下方 (java.text)
 * 		https://www.ewdna.com/2009/01/javadatecalendardateformatsimpledatefor.html
 * 
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Rev066_02_ClientThreadCode extends Thread {
	private Socket m_socket;//和伺服器端進行連線
	
	public Rev066_02_ClientThreadCode(String ip, int port) {
		try {
			// 建立連線(ip為伺服器端的ip，port為伺服器端開啟的port)
			m_socket = new Socket(ip, port);
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run() {
		//super.run();
		try {
			if (m_socket != null) { // 連線成功才可繼續往下執行
				
				//由於Server端使用 PrintStream 和 BufferedReader 來接收和寄送訊息，所以Client端也要相同
				//使用Socket的 getInputStream()和getOutputStream()進行接收和發送資料
				//想要寫入字串可以用 PrintStream;
				//想要把各種基本資料型態，如int, double...等的"值"輸出，可以用DataOutputStream;
				//想要把整個物件 Serialize(序列化)，則可以用 ObjectOutputStream。
				
				PrintStream writer = new PrintStream(m_socket.getOutputStream()); //使用PrintStream將字串進行編寫和送出
				BufferedReader reader = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
				
				writer.println("現在時間是？");
				writer.flush();
				System.out.println("Server : " + reader.readLine());
				
				m_socket.close();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
