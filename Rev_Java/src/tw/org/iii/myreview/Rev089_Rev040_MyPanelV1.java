package tw.org.iii.myreview;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/*	20180811AM1
 * 	追加點選畫面，圖案出現在滑鼠位置，且滑鼠點擊位置是該圖案中心。
 * 
 * 	作法一：
 * 	Rev089_Rev040_MyPanelV1類別繼承了JPanel，並由MouseListener實作
 * 	
 * 	作法二：
 * 	Java 2D繪圖範例架構+鍵盤滑鼠事件
 * 	http://selfinquiring.hatenablog.com/entry/2017/03/11/220901
 * 		採用Components而不用JPanel或Canvas 是因為內建有雙緩衝，更新畫面不會閃
 */

public class Rev089_Rev040_MyPanelV1 extends JPanel implements MouseListener { // 把這支副程式整個當作一個群組
	private int ballx; // 0811AM1 更新
	private int bally;
	
	Color color; // java.awt
	
	// 建構式
	public Rev089_Rev040_MyPanelV1() {
		System.out.println("Rev089_Rev040_MyPanelV1 : 無傳參數建構式");
		addMouseListener(this);
	}
	
	public Rev089_Rev040_MyPanelV1(int ballx, int bally) {
		System.out.println("Rev089_Rev040_MyPanelV1(int ballx, int bally) : 有傳參數建構式");
		this.ballx = ballx;
		this.bally = bally;
		color = Color.RED;
		
		addMouseListener(this); // 如果java不認識，就是上頭類別忘了繼承&實作介面
		// this => Rev089_Rev040_MyPanelV1 本人聽
	}

	/*		
	 * 
	 */
	
	/*		需要手動右鍵加入override方法
	 * 		(JComponent)
	 * 		注意修飾字 => protected
	 */
	
	// 繼承JPanel(父類別JComponent)的方法 => Override
	@Override
	protected void paintComponent(Graphics g) {
		//		component的生命週期  (沒有呼叫卻自動執行)
		//		component有被呼叫，並傳遞Graphics物件
		//		為何 component 會自動產生?
		//		傳入的 Graphics 已產生物件實體 (Graphic抽象類別的子類別 Graphic2D 中的 Inner class所產生)
		
		/*	該物件具有生命週期  20180811AM1
		 * 	當生命週期到了，其呼叫的方法非開發者所建立
		 * 	開發者呼叫某方法導致觸發它，而那些方法才被呼叫
		 */
		super.paintComponent(g);
		System.out.println("V1 : Paint");
		//把g強制轉型回Graphics2D [骨子裡是Graphic2D 不清楚可用instanceof ]
		Graphics2D g2d = (Graphics2D)g;
		// 以下設定初始顏色
		g2d.setColor(new Color(0,0,0,0)); // 程式依序執行，先set，後繪圖，才看得到顏色
		System.out.println("V1 : 初始顏色 (透明)");
		// 以下設定自V2~V3回傳Color物件的顏色
		g2d.setColor(color);
		System.out.println("V2~V3回傳Color物件的顏色");
		g2d.drawOval(ballx, bally, 50, 50); // drawOval 畫橢圓 (X正值往右，Y正值往下)
		g2d.fillOval(ballx, bally, 50, 50);
		
	}
	
	// MouseListener 並沒有重新implement成另一個類別
	// 而是直接實作在同一類別內，方便後續修改與存取類別內的屬性
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// 新增mouseListener的實作方法
		System.out.println("V1 mouseClicked()");
		ballx = e.getX()-25; // 減去半徑
		bally = e.getY()-25;
		repaint();	// 父類別的repaint與子類別repaint執行順序為何？ 之後設計類似的程式要注意
		// repaint 類似會被push到旁邊等color做完？ 註解repaint()試試看
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

// HW: 改成讓滑鼠點到的地方變成是圓心
