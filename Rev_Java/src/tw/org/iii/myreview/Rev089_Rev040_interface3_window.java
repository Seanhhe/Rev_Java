package tw.org.iii.myreview;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
		setLayout(new BorderLayout()); // 先setLayout才能使用add方法
		
		myPanel = new Rev089_Rev040_MyPanelV1(); // 僅產生物件實體
		add(myPanel, BorderLayout.CENTER);
		
		// 加入滑鼠監聽事件
		addMouseListener(new MyClicker());
		
		
		// 放在最後 (視窗大小&顯示視窗)
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 關閉視窗方法一
		
		//	關閉視窗方法二
//		addWindowListener(new MyWindowListener());
		
		//	關閉視窗方法三
		addWindowListener(new MyListener03());
		
	}
	
	public static void main(String[] args) {
		// 程式的執行點
		new Rev089_Rev040_interface3_window();
	}

}

// 滑鼠事件
class MyClicker extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		System.out.println(e.getX()); // 透過getX()方法把值傳回e(滑鼠事件)
		System.out.println(e.getY());
		new Rev089_Rev040_MyPanelV1(); // 啟動MypanelV1()，如此才能從e取出XY值 並repaint()
	}
	
}

//----------------------------------------------
/*		不用setDefaultCloseOperation(EXIT_ON_CLOSE)方法關閉視窗
 * 		改用下面的方法：WindowListener
 * 		但只需要其中的 closing 方法
 * 		改用 class WindowAdapter (implements WindowListener的抽象類別)
 */

// 關閉視窗方法二
//class MyWindowListener implements WindowListener {
//	/*	建立MyWindowListener 實現 WindowListener 建立 WML 物件實體
//	 * 	接收視窗活動訊息
//	 */
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
//		System.exit(0); // 關閉程式
//		//	參數0 => command line return value
//		//	回傳給系統上一道指令完成的return值
//		//	通常return 0 代表 normal	/	非 0 代表 error
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
//	}
//
//	@Override
//	public void windowIconified(WindowEvent arg0) {
//		System.out.println("windowIconified(WindowEvent arg0)");
//	}
//
//	@Override
//	public void windowOpened(WindowEvent arg0) {
//		System.out.println("windowOpened(WindowEvent arg0)");
//	}
//	
//}

//	關閉視窗方法三
class MyListener03 extends WindowAdapter {
	//	繼承抽象類別 WindowAdapter 並加以 override 實作
	//	缺點是不能再找父類別繼承 (不能雙重繼承)
	
	@Override
	public void windowActivated(WindowEvent e) {
		super.windowActivated(e);
		System.out.println("windowActivated(WindowEvent e)");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
		System.out.println("windowClosing(WindowEvent e)");
		System.exit(0);	//	關閉程式
		/*	參數 0 => command line return value
		 * 	回傳給系統上一道指令完成的 return 值
		 * 	通常 return 0 代表 normal / 非0 代表 error
		 */
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		super.windowDeactivated(e);
		System.out.println("windowDeactivated(WindowEvent e)");
	}
	
}