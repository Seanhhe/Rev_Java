package tw.org.iii.myreview;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*		20180812PM1	序列化  (物件輸出)  Brad55
 * 		ObjectOutputStream
 * 
 * 		物件的輸入輸出
 * 		其屬性具有意義
 * 
 * 
 * 		物件的序列化
 * 		某物件被序列化之前，需要宣告該物件類別擁有可序列化的介面
 * 		(序列化介面沒有任何實作，僅需宣告即可)
 * 
 * 		Bike物件--序列化-->Object
 * 
 * 		> 如果物件中有屬性不想被序列化，在宣告時需在其前稱加上 transient
 * 
 */

public class Rev057_Serial {

	public static void main(String[] args) {
		// 物件二  腳踏車
		Rev022_Bike b1 = new Rev022_Bike();
		b1.upSpeed();
		System.out.println(b1.getSpeed());
		
		// 物件一  學生
		Student s1 = new Student(60, 65, 70, b1);
		// 學生的腳踏車的速度 (物件擁有物件)
		s1.bike.upSpeed(2);
		System.out.println(s1.calAvg() + " & " + s1.calSum());
		System.out.println(s1.bike.getSpeed());
		
		System.out.println("----------");
		
		
		// 物件輸出 (auto close)
		try (ObjectOutputStream oout = 
				new ObjectOutputStream(new FileOutputStream("dir3/Rev057.object"))) {
			// 輸出Student
			oout.writeObject(s1);
			// 輸出第二個物件bike
			oout.writeObject(b1);
			System.out.println("物件輸出 Save OK");
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException : " + e);
		} catch (IOException e) {
			System.out.println("IOException : " + e);
		}
		
	}

}

// 要被輸出的物件
class Student implements Serializable {
	// 要執行序列化的物件，需要宣告實作序列化介面
	int ch;
//	transient int ch; // 宣告該屬性不執行序列化		影響原物件，但解序列化後會有差異 (影響Rev058的計算結果)
	int eng, math;
	
	// 讓學生擁有腳踏車物件 Rev022_Bike
	Rev022_Bike bike;
	
	// 建構式
	public Student(int ch, int eng, int math, Rev022_Bike bike) {
		this.ch = ch;
		this.eng = eng;
		this.math = math;
		this.bike = bike;
	}
	
	// Method 方法
	int calSum() { // 計算總分數
		return ch + eng + math;
	}
	
	double calAvg() { // 計算總平均分數
		return calSum() / 3.0; // 總分除以全部三科目等於平均
	}
}
