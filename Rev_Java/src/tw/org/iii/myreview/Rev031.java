package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *		20180805 Brad29
 *
 *		宣告, 轉型, 呼叫
 *
 *		繼承&物件型別轉換
 *		-> 宣告為某類別, 僅能呼叫該類別的方法
 *		-> 如何執行須看用何種類別實作
 *		-> 呼叫不到就用不到, 更別說執行
 *
 *		-> 假設001原本就是以B類別產生, 但是宣告為A類別, AB類別關係為父子,
 *		-> 故當強制轉型成B類別時, 原本不能呼叫的B類別方法就可以呼叫, 且可執行
 *
 *		-> 兩類別為直系血親: 編譯時期可過, 但不見得能執行
 *		-> 反之無法編譯
 *
 *
 *		instanceof
 *		-> 判斷骨子裡是否為該物件實體
 *		-> 實際應用分享
 *				聯絡人內有包含 客戶/供應商/...
 *				父類別都是聯絡人, 子類別是客戶
 *				先宣告為聯絡人
 *				要使用客戶時=>強制轉型成客戶
 *		
 */

public class Rev031 {

	public static void main(String[] args) {
		
	}

}