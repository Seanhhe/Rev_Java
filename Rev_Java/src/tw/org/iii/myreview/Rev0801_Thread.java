package tw.org.iii.myreview;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/*	執行緒與網路應用
 * 	同時抓取多張圖片
 */

public class Rev0801_Thread {

	public static void main(String[] args) {
		System.out.println("開始時間 : " + System.currentTimeMillis());
		
		String[] urls = {"https://wallpapershome.com/images/wallpapers/mountain-2560x1440-snow-rock-high-altitude-4k-18682.jpg",
				 "https://wallpapershome.com/images/wallpapers/yosemite-3840x2160-5k-4k-wallpaper-8k-forest-osx-apple-mountains-3946.jpg",
				 "https://wallpapershome.com/images/wallpapers/karlie-kloss-3840x2160-karlie-elizabeth-kloss-victorias-secret-angel-1413.jpg"};

		String[] targets = {"Rev0801.jpg", "Rev0802.jpg", "Rev0803.jpg"};
		
		for (int i = 0; i < urls.length; i++) {
			new FetchURLImage01(urls[i], targets[i]).start();
		}
	}

}

class FetchURLImage01 extends Thread {
	// 要抓取的網址
	private String url;
	// 要儲存的目的地
	private String target;	
	
	public FetchURLImage01(String url, String target) {
		this.url = url;
		this.target = target;
	}

	@Override
	public void run() {
		URL source;
		try {
			// 讀入目標URL
			source = new URL(url);
			// 建立連結openConnection > 建立物件並轉型為 HttpsURLConnection
			HttpsURLConnection conn = (HttpsURLConnection)source.openConnection();
			// 把URLConnection物件與網路連接 .connect();
			conn.connect();
			// 輸入緩衝串流
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			// 輸出檔案串流
			FileOutputStream fout = new FileOutputStream("dir3/" + target);
			
			// 讀取資料
			byte[] buf = new byte[4096*1024]; // 一次讀取的byte
			int len = 0; // 索引初始值
			while((len = bin.read(buf)) != -1) {
				fout.write(buf, 0, len); // 一次寫多少
			}
			fout.flush();
			fout.close();
			bin.close();
			
			System.out.println(target + " : OK");
		} catch (MalformedURLException e) {
			System.out.println(target + " : MalformedURLException");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(target + " : IOException");
			System.out.println(e.getMessage());
		}
		System.out.println("結束時間 : " + System.currentTimeMillis());
	}
	
	
}