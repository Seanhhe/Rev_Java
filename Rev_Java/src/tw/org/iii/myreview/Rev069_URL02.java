package tw.org.iii.myreview;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/*		20180818PM1 Brad67 URL 28:17
 * 		> 讀出網頁的影像
 * 
 * 		URL
 * 		URLConnection
 * 		HttpsURLConnection
 * 
 * 		可能應用：網頁爬蟲程式
 * 
 */

public class Rev069_URL02 {

	public static void main(String[] args) {
		try {
			// URL包含通訊協定
			URL url = new URL("https://www.google.com.tw/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
			
			// 強制轉型回HttpsURLConnection (因為url內實際是https的url，所以才需要強制轉型)
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			// 呼叫讓物件 conn 進行連接的動作。連接後就可取得輸入串流
			conn.connect();
			
			// 串接讀取頁面原始碼 (取得串流)
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			
			// 檔案輸出(建立檔案輸出的物件，並指定其路徑與檔名)
			FileOutputStream fout = new FileOutputStream("dir3/rev069.png");
			
			byte[] buf = new byte[4096];
			int len;
			while((len = bin.read(buf)) != -1) {
				// 輸出到本地端
				fout.write(buf, 0, len);
			}
			
			// 關閉串流
			bin.close();
			fout.flush();
			fout.close();
			System.out.println("Download OK");
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
