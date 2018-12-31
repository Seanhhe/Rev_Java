package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *
 *		陣列介紹
 *		1. Type 型別/型態是固定的 (宣告字串陣列, 該陣列內就只能放字串)
 *		2. Length 陣列長度是固定的, 如果要再追加, 要新建一個陣列, 再把內容複製過去
 *
 *		JAVA陣列相較某些語言來說不好用, 但JAVA有其因應的方法
 *
 *		只要是new 出來的絕對是清楚的物件, 也已完成初始化(給值)
 *		(只要可以給值, 在JAVA裡就是可以初始化)
 *		int b;
 *		b = 123;
 *
 *		物件絕對是清清楚楚的存在!!
 *
 *		基本型別陣列初始值(不清楚就試試看)
 *		int, short, byte, long, char --> 0
 *		float, double --> 0.0
 *		boolean --> false
 *
 *		陣列長度範圍 --> int的正整數範圍
 *
 *		陣列名稱.length --> 陣列長度
 *
 *		index 從零開始計算
 *		--> 記憶體上的位址 (偏移量)
 *		--> 變數宣告後指向記憶體中的某個位址, a[0]就是記憶體偏移量為零
 *
 */

public class Rev017_Arrays {

	public static void main(String[] args) {
		
		// 宣告整數型態陣列a
		int[] a;
		
		// 初始化(第一次給值)
		// 宣告陣列有四個int元素
		a = new int[4];
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ";");	// 陣列中的值都是初始值0
		}
		
		System.out.println();
		
		// 其他宣告方式
		
		int[] b = new int[] {4,3,6,3,127,168};
		int[] c = new int[4];
		
		for (int i=0; i<c.length; i++) {
			System.out.print("c[" + i + "]=" + c[i] + "; ");
			
		}
		
		System.out.println();
		
		// 以下寫法只能在宣告時給值, 無法另外給值
		int[] d = {3,4,5,6};
		for (int i=0; i<d.length; i++) {
			System.out.print("d[" + i + "]=" + d[i] + "; ");
		}
		
		// 以下寫法同上, 只能在宣告時給值, 之後無法另外給值
		int[] e;
		e = new int[] {1,2,3,4,5};
		
//		編譯錯誤
//		int[] f;
//		f = {1,2,3,4};
	}

}
