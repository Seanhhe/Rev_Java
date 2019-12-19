package tw.org.iii.myreview;

/*		20180825 brad83
 * 		
 * 		同學提問
 * 		=> 方法中的類別 (實務上很少運用)
 * 		=> 算是內部類別的一種
 */

public class Rev085_InnerClass {

	public static void main(String[] args) {
		class Rev0851 {
			public Rev0851() {
				System.out.println("Rev0851");
			}
			
			void m1() {
				System.out.println("Rev0851_m1()");
			}
		}
		
		Rev0851 obj1 = new Rev0851();
		obj1.m1();
	}

}
