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
			/*
			 * 		以下的計算，若Rev057的屬性中有 tensient 宣告，序列化時不影響原先物件。
			 * 		解序列化時，就會有影響。
			 * 		例如：Rev057輸出的Rev057.object物件，其 int ch屬性在Rev058解序列化-重新讀取Rev057.object時，
			 * 		ch的初始值會變 0 。進而影響後續的總分數 & 總平均。
			 */
			System.out.println("總分數：總平均 = " + s1.calSum() + ":" + s1.calAvg());
			
			// 學生的腳踏車	(物件中的物件)
			System.out.println("學生的腳踏車的速度：" + s1.bike.getSpeed());
			
			// 物件二腳踏車
			Rev022_Bike b1 = (Rev022_Bike)oin.readObject();
			System.out.println("腳踏車的速度：" + b1.getSpeed());
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + e);
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e);
		}
		
	}

}
