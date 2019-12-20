package tw.org.iii.myreview;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/*		20180805 Brad38 Interface應用_視窗
 * 
 * 		API 中參數為1，通常為interface
 * 		EventListener => API中僅為分類的功能，裡面沒有任何方法定義
 * 
 * 		設計一個類別 => Rev089_Rev040_MyPanelV1 供 Rev089_Rev040_interface3_window使用
 * 		
 * 		Java GUI基本概念參考文章
 * 		https://pydoing.blogspot.com/2011/05/java-basic-concept-of-gui.html
 * 
 */

public class Rev089_Rev040_interface3_window extends JFrame {
	private Rev089_Rev040_MyPanelV1 myPanel; // 引用時注意修改V1~V4
	
	// 建構式
	public Rev089_Rev040_interface3_window() {
		// 放最前面
		setLayout(new BorderLayout());
		
		myPanel = new Rev089_Rev040_MyPanelV1(); // 僅產生物件實體
		add(myPanel, BorderLayout.CENTER);
		
		
		
		// 放在最後
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
	}

}
