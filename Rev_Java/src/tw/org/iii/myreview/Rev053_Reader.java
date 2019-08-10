package tw.org.iii.myreview;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*		20180812AM2 Reader
 * 		讀取字元資料用
 * 		=> Reader & Writer
 */

public class Rev053_Reader {

	public static void main(String[] args) {
		
		try {
			FileReader reader = new FileReader("dir3/Rev053.txt");
			 
			/* 	FileReader的方法，繼承自
			 * 	1) java.io.InputStreamReader
			 *		--> int read() --> 讀取字元，遇到-1結束
			 *		--> int read() --> 
			 *	2) java.io.Reader
			 *		-->
			 *	3) java.lang.Object
			 *		-->
			 */
			
//			int v = reader.read(); // 方法1-1
//			System.out.println("v : " + (char)v);
			int temp; // 將資料放在這裡
			char[] b = new char[4096]; // 一次讀取幾個字元
			while((temp = reader.read(b)) != -1) {
				System.out.print(new String(b, 0, temp));
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("系統內找不到檔案：" + e);
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		}
	}

}
