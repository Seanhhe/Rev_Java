package tw.org.iii.myreview;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**		20180811
 * 		追加點選畫面，圖案出現在滑鼠位置，且滑鼠點擊位置為該圖案中心
 * 
 * 		作法一：
 * 		Rev040MyPanel類別繼承了JPanel，並由MouseListner實作
 * 		作法二：
 * 		http://selfinquiring.hatenablog.com/entry/2017/03/11/220901
 * 
 */

public class Rev040MyPanel extends JPanel implements MouseListener {
	private int ballx;
	private int bally;
	Color color;
	
	// 建構式
	public Rev040MyPanel() {
		System.out.println("Rev040MyPanel(); 無傳參數建構式");
		addMouseListener(this);
	}

	/**		在 JPanel 上使用 paint(Graphics g) 的問題
	 * 		https://www.javaworld.com.tw/jute/post/view?bid=5&id=172926&tpg=1&ppg=1&sty=1&age=0
	 * 		https://www.javaworld.com.tw/jute/post/view?bid=29&id=109993&sty=3&age=0&tpg=1&ppg=1#109993
	 */
	
	//繼承JPanel(父類別JComponet)的方法 -> Override
	@Override
	protected void paintComponent(Graphics g) {
		// component的生命週期	(沒有呼叫卻自動執行)
		// component有被呼叫並傳遞Graphic物件
		// 為什麼component會自動產生???
		// 傳入的 Graphic 已產生物件實體	(Graphic抽象類別的子類別Graphic2D中的 Inner class 所產生)
		
		/**		該物件具有生命週期	20180811AM
		 * 		當生命週期到了，其呼叫的方法非開法者所建立
		 * 		開發者呼叫某方法導致觸發它，而那些方法才被呼叫
		 * 
		 */
		super.paintComponent(g);
		System.out.println("paintComponent(Graphic g): paint");
		Graphics2D g2d = (Graphics2D)g; // 強制轉型回Graphics2D [骨子裡是Graphics2D 不清楚可用instanceof] (API: java.awt.Graphics2D)
		g2d.drawOval(10, 50, 50, 50); // drawOval 畫橢圓
		
		g2d.setColor(Color.ORANGE);
	}

	// MouseListener 並沒有重新implement成另一個類別
	// 而是直接實作在同一類別內，方便後續修改與存取類別內的屬性
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// 新增mouseListener的實作方法
		System.out.println("V1 mouseClicked");
		ballx = e.getX()-25; // 減去半徑
		bally = e.getY()-25;
		repaint();	// 父類別的repaint與子類別repaint執行順序為何？之後設計類似的程式要注意
		// repaint 類似會被push到旁邊等color做完？ 註解repaint試試看		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// 新增mouseListener的實作方法
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// 新增mouseListener的實作方法
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// 新增mouseListener的實作方法
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// 新增mouseListener的實作方法
		
	}
		
}

/**
 * 		TODO HW: 滑鼠點到的地方是圓心
 */
