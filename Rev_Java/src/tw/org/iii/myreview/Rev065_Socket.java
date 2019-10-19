package tw.org.iii.myreview;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*		20180818AM2 Brad63 Socket (for TCP)
 * 		Client端 (用戶發送端)
 * 
 * 		port 23 > telnet 開啟		=> 指令為明碼 (安全性差)
 * 		port 22 > SSH => 傳遞之間有私鑰與公鑰加密
 * 
 */

public class Rev065_Socket {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("", 9999);
			
			// 發送資訊
			OutputStream out = socket.getOutputStream();
			out.write("資策會\nLine2\n中文字".getBytes());
			out.flush();
			out.close();
			socket.close();
			System.out.println("Socket OK");
			
		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			/*		可能例外
			 * 		1.  目標位址不認識
			 * 		2.  對方不回應
			 * 		3.  都會拋出例外
			 */
			System.out.println(e);
		}
	}

}
