package tw.org.iii.myreview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*		20180811 PM2	17:00	Brad46	串流Part1
 * 		InputStream
 * 
 * 		java.io.InputStream
 * 				java.io.FileInputStream
 * 
 */

public class Rev048_Stream1 {

	public static void main(String[] args) {
		
		try {
			FileInputStream fin = new FileInputStream("dir3/Rev048_Steam01.txt");
			
			// read(); 一次只能讀取一個byte
			int a = fin.read();
			System.out.println("int a = " + a);	// 讀出文字檔中的第一個字元碼
			int b = fin.read();
			System.out.println("int b = " + b); // 讀出第二個字元碼
			
			//	如何讀出完整的檔案內容
			//	寫法一
			int temp;
			do {
				temp = fin.read();
				//	把讀進來的字元碼強制轉型成字元
				System.out.println((char)temp);
			}while (temp != -1);
			
			
			//	寫法
			
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + e);
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
	}

}
