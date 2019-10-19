package tw.org.iii.myreview;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*		20180818AM2  Brad65
 * 		將本機上的指定圖檔傳遞到67號程式
 * 
 * 		接收端
 * 
 * 		**補充
 * 		如何知道對方檔案名稱 (通訊協定處理)
 * 		=>私有交換資料可使用自訂的通訊協定
 * 
 */

public class Rev067_ServerSocket {

	public static void main(String[] args) {
		
		try {
			// 1. 建立socket
			ServerSocket server = new ServerSocket(7777);
			Socket socket = server.accept();  // 完成三方交握
			
			// 2. 寫出資料 (傳送的是檔案內容  檔案格式由server決定)
			FileOutputStream fout = new FileOutputStream("dir3/rev067out.jpg");
			
			// 3. 讀取資料
			InputStream in = socket.getInputStream();
			
			int temp;
			while((temp = in.read()) != -1) {
				fout.write(temp);
			}
			in.close();
			fout.flush();
			fout.close();
			server.close();
			System.out.println("Server Received");
			
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		}
		
	}

}
