package tw.org.iii.myreview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/*		20180812PM2  Brad56  解序列化
 * 		
 * 		讀取物件，每個東西都是有意義的
 * 		較為常用
 * 
 * 		序列化的目的在於，把物件變成資料。
 * 		可以透過網際網路將物件傳遞到遠端。
 * 
 * 		物件重要的東西是屬性
 * 		序列化其實主要是序列其屬性資料
 * 
 * 		
 * 		多個物件 (不同類別) 也可以一起序列化，但要注意其解序列化的順序也需和序列化時一樣
 * 		A物件擁有B物件
 * 		只要擁有的物件有實作序列化就沒有問題
 * 		但若被序列化的屬性本身沒有實作序列化，會有無法序列化的例外出現
 * 
 */

public class Rev058_UnSerial {

	public static void main(String[] args) {
		try (ObjectInputStream oin = 
				new ObjectInputStream(new FileInputStream("dir3/Rev057.object"))) {
			
			Object obj1 = oin.readObject(); // 在記憶體中建立物件實體，儲存讀出的物件
			Student s1 = (Student)obj1; // 把讀出的物件轉型回原形
			System.out.println("總平均 : 總分數 = " + s1.calAvg() + ":" + s1.calSum());
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + e);
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e);
		}
		
	}

}
