package tw.org.iii.myreview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*		20180812AM 複製檔案V2
 * 
 * 		第一次 Rev051 以 byte 方式讀取，速度很慢，如何改善？
 * 		
 * 		將檔案一次讀到陣列中，再讀到新檔案裏頭。
 * 
 * 		陣列的長度就是原始資料的長度
 * 		-->
 * 		Length回傳的是long，要轉換成陣列index的int 
 * 		(最大2G 2^32次方)，一次性的buffer。
 */

public class Rev052_CopyFile02 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		File source = new File("dir3/image.jpg");
		byte[] buf = new byte[(int)source.length()];
		
		try {
			FileInputStream fin = new FileInputStream(source);
			fin.read(buf);
			fin.close();
			
			FileOutputStream fout = new FileOutputStream("dir3/dir4/image3.jpg");
			fout.write(buf);
			fout.flush();
			fout.close();
			
			System.out.println("OK : " + (System.currentTimeMillis() - start));
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + e);
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		}
		
//		// 長度限制	(原本為long強制轉型後，喪失精度)
//		int v1 = (int)5000000000L;
//		//int v3 = 2147483647; // 21億 (測試 int 的上限)
//		long v2 = 5000000000L;
//		System.out.println("v1 : " + v1);
//		System.out.println("v2 : " + v2);
//		
//		//	改寫! 調整程式使其迎合超過2G以上的檔案
//		//	(1G = 1,024 MB = 1,048,576 KB = 1,073,741,824 bytes)
//		//	(2G = 2,147,483,648 bytes)--> 剛好超過int的上限 1 byte
//		//	補充：有時候會有狀況是因為，當複製超過 4G 大小的檔案到目的地，
//		//	其檔案系統是否容許 (就像USB FAT32)
//		
//		File source = new File("dir3/image.jpg");
		
	}

}
