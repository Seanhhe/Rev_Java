package tw.org.iii.myreview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*		20180818PM1 Brad69 URL 38:00
 * 		> OpenData試玩
 * 		https://data.coa.gov.tw/Query/ServiceDetail.aspx?id=195
 * 		資料介接：
 * 		https://data.coa.gov.tw/Service/OpenData/DataFileService.aspx?UnitId=151
 * 		> JSON格式轉換
 * 		JSON 格式 => import json package (org.json)
 * 
 * 		>> 行動裝置使用OPEN DATA
 * 			資料處裡 --> 另架伺服器固定至該政府單位撈資料，整理後再讓行動裝置端定期來抓取更新資料
 * 				-> 減少政府單位伺服器的繁忙
 * 				-> 手機端資料拿到的已是整理過的資料(手機端演算法減少)
 * 
 * 		URL
 * 		URLConnection
 * 		HttpURLConnection
 */

public class Rev071_OpenData {

	public static void main(String[] args) {
		
		try {
			// URL包含通訊協定
			URL url = new URL("http://data.coa.gov.tw/Service/OpenData/DataFileService.aspx?UnitId=151");
			
			// 強制轉型回HttpsURLConnection
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// 呼叫connection()方法，讓conn物件取得輸入串流
			conn.connect();
			
			// 串接資料
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String tempLine; // 當作暫存
			
			StringBuffer sb = new StringBuffer(); // 串接後完成的字串(預設容量為16字元)
			
			/*	BufferedReader的readLine()方法，回傳的值是"String"。
			 * 	所以要把逐行讀出的字串先放到tempLine，
			 */
			while((tempLine = reader.readLine()) != null) {
				/*	從串接資料後，立刻一列一列輸出到本地端
				 * 	(透過StringBuffer的append()方法，一行一行把字串加在末端)
				 * 	直到接收端reader空了，才結束逐行輸出
				 */
				sb.append(tempLine);	//串接字串
			}
			//關閉串流
			reader.close();
			
			//把String轉換成JSON
			parseJSON(sb.toString());
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

/*		解析JSON的方法
 * 		將下載下來的JSON Package複製貼上至專案中
 * 		記得package名稱改寫成org.json 配合來源檔案設定
 * 		https://stleary.github.io/JSON-java/index.html
 * 		Android開發已將JSON API納入官方API
 */

	private static void parseJSON(String json) {
		/*		OpenData來源是陣列JSON
		 * 
		 */
		
		try {
			//讀入字串資料轉成JSONArray (解析第一層)
			JSONArray root = new JSONArray(json);
			System.out.println("root.length() : " + root.length());
			
			/*	尋訪JSON陣列裡的元素
			 * 	注意！JSON陣列裡面有可能是物件{ }，也有可能是另一層陣列[ ]
			 * 	要懂得判讀元素格式
			 * 	https://j796160836.pixnet.net/blog/post/30530326-%e7%9e%ad%e8%a7%a3json%e6%a0%bc%e5%bc%8f
			 */
			for (int i = 0; i < root.length(); i++) {
				/*
				 * 	第一層是陣列，第二層是物件
				 */
				JSONObject obj = root.getJSONObject(i);
				String forestRoadName = obj.getString("林道名稱");
				String county = obj.getString("縣市");
				String township = obj.getString("鄉鎮");
				String settlements = obj.getString("林道途經聚落");
				String startingPoint = obj.getString("起點");
				String endPoint = obj.getString("終點");
				
				
				System.out.println(forestRoadName + " : " + county + " : " + township + " : " + settlements + " : " + startingPoint +" : " + endPoint);
			}
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}
	}

}
