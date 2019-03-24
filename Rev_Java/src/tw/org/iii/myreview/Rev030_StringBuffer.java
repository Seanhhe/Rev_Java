package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *		NOTE 20180805 StringBuffer
 *
 *		StringBuffer & StringBuilder 用法一樣
 *		
 *		觀念：
 *		使用任何類別物件前記得先看API
 *			看建構式
 *			有無無傳參數建構式
 *			是否為Final --> 不能繼承
 *			其他方法介紹(它的父類別)
 *
 *		物件型別 sysout 印toString
 *		基本型別 sysout 印其值
 *
 *		>> 字串回傳的物件為新的物件實體
 *		>> StringBuffer回傳的為其原本的物件實體
 */

public class Rev030_StringBuffer {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();
		System.out.println(sb1); // 印出該物件的toString
		System.out.println(sb1.capacity()); // 容量
		System.out.println(sb1.length()); // 字串長度
		
		System.out.println("--------");
		
		// StringBuffer.append --> 傳回StringBuffer
		
	}

}
