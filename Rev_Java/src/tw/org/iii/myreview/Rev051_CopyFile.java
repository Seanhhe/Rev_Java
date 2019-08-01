package tw.org.iii.myreview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*		20180812AM1 Brad49
 * 		檔案複製
 * 		透過FileInputStream & FileOutputStream
 * 		將檔案byte by byte讀到另一個檔案路徑上
 * 
 */

public class Rev051_CopyFile {

	public static void main(String[] args) {
		
		try {
			// 紀錄開始時間
			long start = System.currentTimeMillis();
			
			FileInputStream fin = new FileInputStream("dir3/image.jpg");
			FileOutputStream fout = new FileOutputStream("dir3/dir4/image2.jpg");
			
			// Read byte by byte
			int temp;
			while((temp = fin.read()) != -1) {
				fout.write(temp);
			}			
			
			fin.close(); // 留意.close()的位置是否有影響？
			fout.flush();
			fout.close();
			
			// 確認有執行成功
			System.out.println("OK : " + (System.currentTimeMillis() - start));
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + e);
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		}
	}

}
