package tw.org.iii.myreview;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**	
 * 
 * @author SEAN
 *		20180805 Brad38 Interface應用_視窗
 *
 *		API中參數為1，通常為interface
 *		EventListener-->API中僅為分類的功能裡面沒有任何方法定義
 *
 *		設計一類別-> Rev040MyPanel 供Rev040_interface3_window使用
 *
 *
 *		Java GUI基本概念參考文章
 *		https://pydoing.blogspot.com/2011/05/java-basic-concept-of-gui.html
 *		
 */

public class Rev040_interface3_window extends JFrame {
	private Rev040MyPanel myPanel;
	// 建構式
	public Rev040_interface3_window() {
		setLayout(new BorderLayout());	// setLayout的順序位置會影響後面的add (先set可以add)
		myPanel = new Rev040MyPanel();	// 僅產生物件實體
		//myPanel = new Rev040MyPanelV2();	// 0816 review改用V2版本
		//myPanel = new Rev040MyPanelV3();	// V3版
		add(myPanel, BorderLayout.CENTER);
		
		//	滑鼠事件
		addMouseListener(new MyClicker());
	}
	
	
	public static void main(String[] args) {
		
	}

}
