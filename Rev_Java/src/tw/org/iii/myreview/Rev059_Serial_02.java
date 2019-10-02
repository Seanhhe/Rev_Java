package tw.org.iii.myreview;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*		20180812PM1	序列化	(物件輸出)	Brad57
 * 		ObjectOutputStream
 * 
 * 		物件序列化_繼承結構
 * 
 */

public class Rev059_Serial_02 {

	public static void main(String[] args) {
		Rev0593 obj = new Rev0593();
		
		try (ObjectOutputStream oout = 
				new ObjectOutputStream(new FileOutputStream("dir3/Rev059.object"))) {
			oout.writeObject(obj);
			System.out.println("Save OK");
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + e);
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		}
		
	}

}

/*		要被輸出的物件
 * 		父類別子類別在三代繼承中，實作序列化寫在祖、父、子各有何差異？
 * 		同樣輸出Rev0593
 * 
 * 		Rev060_UnSerial_02	解序列化後
 * 		祖類別：都沒印
 * 		父類別：只印Rev0591()
 * 		子類別：印 Rev0591()、Rev0592()
 * 
 * 		我的理解：
 * 		解序列化是把儲存的資料還原成物件
 * 		1.	祖類別有實作序列化 --> 當子類別物件序列化的時候，祖、父兩代都有序列化(都在裡面)
 * 			儲存物件的祖、父類別物件本來就已經存在，所以不用new & 初始化。
 * 		2.	在父類別實作序列化 --> 解序列化的時候，只有到父類別，所以要new祖類別物件
 * 			(包含初始化)	(儲存Rev0592 & Rev0593)
 * 		3.	在子類別實作序列化 --> 解序列化的時候，只有自己，但是自己在，
 * 			祖宗八代都要在，所以祖、父類別才會有初始化的動作。
 */

class Rev0591 {		// 祖類別
	Rev0591() {
		System.out.println("Rev0591()");
	}
}

class Rev0592 extends Rev0591 {		// 父類別
	Rev0592() {
		super();
		System.out.println("Rev0592()");
	}
}

// 子類別
class Rev0593 extends Rev0592 implements Serializable {
	Rev0593() {
		super();
		System.out.println("Rev0593()");
	}
}