package tw.org.iii.myreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * 
 * @author SEAN
 *		20180818PM1 Brad66 URL 05:33
 *		> 讀出網頁的原始碼文字(html)
 *
 *		URL
 *		URLConnection
 *		HttpsURLConnection
 *
 *		可能應用：網頁爬蟲程式
 */

public class Rev068_URL01 {

	public static void main(String[] args) {
		try {
			// 從外部讀取String字串並建立一個URL物件
			URL url = new URL("https://www.google.com.tw");
			
			// 強制轉型回HttpsURLConnection (因為url內實際是https的url，所以才需要強制轉型)
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			
			// 呼叫讓物件 conn 進行連接的動作。連接後就可取得輸入串流
			conn.connect();
			
			// 串接讀取頁面原始碼
//			InputStream in = conn.getInputStream();
//			InputStreamReader isr = new InputStreamReader(in);
//			BufferedReader bufr = new BufferedReader(isr);
			
			// 串接讀取頁面的另一種簡易寫法
			BufferedReader bufr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			// 印出字串內容
			String line;
			while((line = bufr.readLine()) != null) {
				System.out.println(line);
			}
			
			// 關閉串流(接成同一根管，關掉一個即可)
			bufr.close();
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-----分隔線-----");
		
		// HTTP
		try {
			URL url = new URL("https://www.ccu.edu.tw");
			
			// 強制轉型為HttpURLConnection
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			// 呼叫讓物件 conn 進行連接的動作。連接後就可取得輸入串流
			conn.connect();
			
			// 串接輸入頁面原始碼(取得串流)
			BufferedReader bufr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			// 印出字串
			String line;
			while((line = bufr.readLine()) != null) {
				System.out.println(line);
			}
			
			// 關閉串流 (已經接成同一根管，所以關一個即可)
			bufr.close();
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
