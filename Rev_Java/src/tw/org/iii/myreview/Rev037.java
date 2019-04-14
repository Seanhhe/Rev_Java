package tw.org.iii.myreview;

/**		20180805  Brad35	抽象類別 / 方法  [多型]	應用題_形狀
 * 
 * @author SEAN
 *		抽象類別的相反-->final
 */

public class Rev037 {

	public static void main(String[] args) {
		//Shape s1 = new Circle();	// Circle也是Shape
		//Shape s2 = new Rectangle(); // Rectangle也是Shape
		System.out.println("----分隔線----");
		Circle s1 = new Circle();
		Rectangle s2 = new Rectangle();
		m2(s1);
		m2(s2);
		s1.setName(); //Shape為抽象類別，故需透過Cir/Rec繼承Shape，實作方法
		
	}
	/**
	 * 		Rec Cir 都是 Shape，都可以計算面積，其執行看本體各自去表現
	 */
	
	static void m2(Shape s) { //只要是形狀都有算面積，執行面各自去判斷
		// 表現出多型，Rec / Cir 都是shape，都繼承Shape
		System.out.println("s.calArea(): " + s.calArea());
	}

}

abstract class Shape {
	Shape() {	// 抽象類別也一定有建構式
		System.out.println("Shape():建構式 初始化");
	}
	
	//方法
	void setName() {
		// 抽象類別中的一般方法
		System.out.println("方法 : setName()");
	}
	
	abstract double calLength();
	abstract double calArea();
}

class Circle extends Shape {
	@Override
	double calLength() {
		return 2.0;
	}
	
	@Override
	double calArea() {
		return 2.0;
	}
}

class Rectangle extends Shape {
	@Override
	double calLength() {
		return 2.0;
	}
	
	@Override
	double calArea() {
		return 2.0;
	}
}

final class Rev0371 { //宣告final，不可有子類別
	//final類別不能為抽象類別 /	final不會有子類別 (就不會有多型override)
}

abstract class Rev0373 { // 宣告為抽象類別，但沒有抽象方法-->不想讓人建構物件實體
	void m1() {
		//可執行的方法
	}
}

