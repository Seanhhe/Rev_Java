package tw.org.iii.myreview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
			
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + e);
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		}
		
	}

}
