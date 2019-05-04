package tw.org.iii.myreview;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
	private Rev040MyPanelV3 myPanel;
	// 建構式
	public Rev040_interface3_window() {
		setLayout(new BorderLayout());	// setLayout的順序位置會影響後面的add (先set可以add)
		//myPanel = new Rev040MyPanel();	// 僅產生物件實體
		//myPanel = new Rev040MyPanelV2();	// 0816 review改用V2版本
		myPanel = new Rev040MyPanelV3();	// V3版
		add(myPanel, BorderLayout.CENTER);
		
		//	滑鼠事件
		//addMouseListener(new MyClicker());
		
		// 關閉視窗 方法一
		//addWindowListener(new MyWindowListener());
		
		// 關閉視窗 方法二
		addWindowListener(new MyListener());
		
		// 視窗大小 & 顯示視窗
		setSize(640, 480);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE); // 關閉視窗方法一
	}
	
	
	public static void main(String[] args) {
		// 程式的執行點
		new Rev040_interface3_window();
	}

}

//// 滑鼠事件
//class MyClicker extends MouseAdapter {
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		super.mouseClicked(e);
//		System.out.println(e.getX());
//		System.out.println(e.getY());
//		new Rev040MyPanel();
//	}
//}


/**
 * 		不用setDefaultCloseOperation(EXIT_ON_CLOSE);方法關閉視窗
 * 		改用下面的方法：WindowListener
 * 		但僅需要其中的closing方法
 *		改用 class WindowAdapter (implements WindowListener的抽象類別)
 */

//// 關閉視窗 方法一
//class MyWindowListener implements WindowListener {
//	// 建立MyWindowListener 實現WindowListener 建立MWL物件實體
//	// 接收視窗活動訊息
//		
//	@Override
//	public void windowActivated(WindowEvent arg0) {
//		System.out.println("windowActivated(WindowEvent arg0)");
//	}
//
//	@Override
//	public void windowClosed(WindowEvent arg0) {
//		System.out.println("windowClosed(WindowEvent arg0)");
//	}
//
//	@Override
//	public void windowClosing(WindowEvent arg0) {
//		System.out.println("windowClosing(WindowEvent arg0)");
//		System.exit(0);	//	關閉程式
//		//	參數0  -->  command line return value
//		//	回傳給系統上一道指令完成的return值
//		//	通常return 0 代表 normal / 非0 代表 error
//		
//	}
//
//	@Override
//	public void windowDeactivated(WindowEvent arg0) {
//		System.out.println("windowDeactivated(WindowEvent arg0)");
//	}
//
//	@Override
//	public void windowDeiconified(WindowEvent arg0) {
//		System.out.println("windowDeiconified(WindowEvent arg0)");
//		
//	}
//
//	@Override
//	public void windowIconified(WindowEvent e) {
//		System.out.println("windowIconified(WindowEvent e)");
//	}
//
//	@Override
//	public void windowOpened(WindowEvent arg0) {
//		System.out.println("windowOpened(WindowEvent arg0)");
//	}
//	
//}

// 關閉視窗_方法二
class MyListener extends WindowAdapter {
	// 繼承抽象類別 WindowAdapter 並加以override實作
	// 缺點是不能再找父類別繼承
	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
		System.exit(0); //	關閉程式
		//	參數0  -->  command line return value
		//	回傳給系統上一道指令完成的return值
		//	通常return 0 代表 normal / 非0 代表 error
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		super.windowActivated(e);
		System.out.println("Activated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		super.windowDeactivated(e);
		System.out.println("Deactivated");
	}
	
	
}
