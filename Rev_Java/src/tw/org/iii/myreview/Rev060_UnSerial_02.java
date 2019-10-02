package tw.org.iii.myreview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/*		20180812PM2	Brad58	解序列化 (繼承結構)
 * 		
 * 		解序列化 --> 拿回物件
 */

public class Rev060_UnSerial_02 {

	public static void main(String[] args) {
		try (ObjectInputStream oin =
				new ObjectInputStream(new FileInputStream("dir3/Rev059.object"))) {
			Object obj = oin.readObject(); // 從記憶體讀入程式內
			
			Rev0593 rev060 = (Rev0593)obj; // 將建立的物件強制轉型為 Rev0593
			
			System.out.println("obj: " + obj);
			System.out.println("Rev0593 : " + rev060);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
	}

}
