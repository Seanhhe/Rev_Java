package tw.org.iii.myreview;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*		20180812PM1 串接 DataOutputStream Brad53
 * 
 */

public class Rev055_DataOutputStream {

	public static void main(String[] args) {
		try {
			DataOutputStream dout = new DataOutputStream(
					new FileOutputStream("dir3/Rev055.txt"));
			// 寫入 & 輸出成 Rev055.txt
			// 寫入的格式及順序要注意
			// 將來被讀取時，也要依相同格式及順序被讀取
			dout.writeInt(4);
			dout.writeUTF("Hello, World");
			dout.writeBoolean(false);
						
			dout.flush();
			dout.close();
			System.out.println("OK: ");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: " + e);
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		
	}

}
