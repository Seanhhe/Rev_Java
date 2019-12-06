package tw.org.iii.myreview;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/*		20180825AM1 Brad78 00:47~1:22
 * 		執行緒與網路應用
 * 		同時抓取多張圖片
 */

public class Rev080_Thread {

	public static void main(String[] args) {
		System.out.println("Start Time : " + System.currentTimeMillis());
		
		String[] urls = {"https://wallpapershome.com/images/wallpapers/mountain-2560x1440-snow-rock-high-altitude-4k-18682.jpg",
						 "https://wallpapershome.com/images/wallpapers/yosemite-3840x2160-5k-4k-wallpaper-8k-forest-osx-apple-mountains-3946.jpg",
						 "https://wallpapershome.com/images/wallpapers/karlie-kloss-3840x2160-karlie-elizabeth-kloss-victorias-secret-angel-1413.jpg"};
		
		String[] targets = {"Rev0801.jpg", "Rev0802.jpg", "Rev0803.jpg"};
		
//		for (int i = 0; i < urls.length; i++) {
//			new FetchURLImage(urls[i], targets[i]).start();
//			/*	start方法 => 同時進行
//			 * 	一樣是循序進行，只是每一個start都被依序丟給 Run Pool
//			 * 	減少CPU閒置時間
//			 */
//		}
		
		for (int i = 0; i < urls.length; i++) {
			new FetchURLImage(urls[i], targets[i]).run();
			/*	run方法 => 普通物件方法，循序進行
			 * 	無執行緒的生命表現，循序一個接一個 => 易被延遲
			 * 	(處理速度比.start方法慢很多)
			 */
		}
	}

}

class FetchURLImage extends Thread {
	// 要抓取的網址
	private String url;
	// 儲存的目的地
	private String target;
	// 有傳參數的建構式
	public FetchURLImage(String url, String target) {
		this.url = url;
		this.target = target;
	}

	@Override
	public void run() {
		//super.run();
		//URL source;
		try {
			// 讀入目標URL
			URL source = new URL(url);
			// 連接網路 HttpsURLConnection
			HttpsURLConnection conn = (HttpsURLConnection)source.openConnection();
			// 開啟連結(呼叫讓物件 conn 進行連接的動作。連接後就可取得輸入串流)
			conn.connect();
			// 輸入串流(串接讀取頁面原始碼)
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			// 輸出
			FileOutputStream fout = new FileOutputStream("dir3/" + target);
			
			// 讀取
			byte[] buf = new byte[4096*1024];
			int len = 0;
			while ((len = bin.read(buf)) != -1) {
				fout.write(buf, 0, len); // 一次寫多少
			}
			fout.flush();
			fout.close();
			bin.close();
			
			System.out.println(target + " : OK");
			
		} catch (MalformedURLException e) {
			System.out.println(target + ": Error 1");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(target + ": Error 2");
			System.out.println(e.getMessage());
		}
		System.out.println("END TIME : " + System.currentTimeMillis());
	}
	
	
}
