package tw.org.iii.myreview;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

import javax.imageio.ImageIO;

/*		20180819AM1	Rev093_View01
 * 		簽名程式 Rev093_Sign01 中的簽名區域 (簽名板)
 * 		=>	自訂類別 (物件)
 * 		=>	功能要能夠劃線	=> 畫筆 (滑鼠)
 * 
 * 		任何時候的畫面是由paintComponet決定
 * 
 * 		劃線：每一筆的點擊都是一個座標	(有順序性但不知道有幾個點)
 * 		利用資料結構 List，儲存每個座標點
 * 		各點連成線
 * 
 * 		利用LinkedList儲存各座標點
 * 		再利用LinkedList儲存各條線LinkedList<MyPoint>(筆畫)
 * 
 * 		01.	初始化：簽名板背景色設定
 * 		02.	paintComponet設定(畫筆)
 * 		03.	加入滑鼠偵測
 * 		04.	自訂座標類別
 * 		05.	建立資料結構，儲存滑鼠收集的座標
 * 		06.	將座標類別物件放入滑鼠方法中收集
 * 		07.	滑鼠移動 => repaint
 * 		08.	利用 for 迴圈重複畫每個小線段 (實測後發現都會連成一條線，無法有筆劃)
 * 		09.	LinkedList<LinkedList<RevPoint>> (點-->線段-->筆劃)
 * 		10.	點下去跟按著不放的差異 => 點下去是新線段，按著放開後是線段的最後一點
 * 		11.	點下去或按著不放都要不斷的把座標傳到LinkedList中，再交給repaint中的迴圈印出
 * 		12.	單一迴圈只有線段，筆劃需要再一層迴圈
 * 		13.	基本功能完成 => 再寫 clear 清除畫面功能
 * 		14.	在Rev093_Sign01按鈕綁定clear功能	[核心功能到位，延伸的就好寫]
 * 		15.	undo
 * 		16.	redo
 * 		17.	save、load 功能
 */

import javax.swing.JPanel;

public class Rev093_View01 extends JPanel {

	private MyMouseListener mouseListener = new MyMouseListener();
	//private LinkedList<RevPoint> line = new LinkedList<>();
	
	//	把蒐集回來的點放到LL成線段，再放到LL中儲存成很多線段(筆劃)
	//	泛型 => <線段> 線段裡面是RevPoint泛型
	private LinkedList<LinkedList<RevPoint>> lines = new LinkedList<>();
	
	//	存放被刪除的線段 (資源回收桶，以供undo, redo 使用)
	private LinkedList<LinkedList<RevPoint>> recycle = new LinkedList<>();
	
	public Rev093_View01() {
		setBackground(Color.YELLOW);	//	簽名板背景色
		
		/*		兩個整合成一個mouseListener
		 * 		原本會需要兩個實作MouseListener & MouseMotionListener
		 * 		但透過MouseAdapter讓程式簡化
		 * 		實作MouseAdapter 內部類別 listen 兩個功能
		 */
		addMouseListener(mouseListener);		// for click
		addMouseMotionListener(mouseListener);	// for movement
	}

	@Override
	protected void paintComponent(Graphics g) {
		/*		透過別的方法觸發此方法
		 * 		而非直接呼叫	=>	一個元素的生命週期
		 * 		使用者隨時看得到畫面
		 * 
		 * 		為了效能，盡量在這方法只做讓畫面異動的動作
		 * 
		 * 		setStroke抽象方法 => 已由paintComponet實作
		 */
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLUE);	//	畫筆藍色
		g2d.setStroke(new BasicStroke(4));	//	產生畫筆 (new BasicStroke(畫筆寬度))
		//g2d.drawLine(0, 0, 100, 100); //	測試到此能否正常執行
		
		//	畫多條線
		for (LinkedList<RevPoint> line:lines) {
			//	畫單一一條線 (對使用者而言是畫一整條線)
			for (int i = 1; i < line.size(); i++) {
				RevPoint p0 = line.get(i - 1); //	線段起始點
				RevPoint p1 = line.get(i); //	下一個點
				g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
			}
		}
	}

	//	方法
	public void clear() {
		lines.clear(); // 清除資料結構內的資料
		repaint();	//	重繪
	}

	public void undo() {
		//	上一步 => 拿掉最後一條線
		if (lines.size() > 0) {
			//	先確認有最後一條再移除
			//	lines.removeLast();
			/*		由於remove後會回傳LL內，被移除的最後一個 元素內容
			 * 		所以先把回傳的LL放到recycle中，若使用者需要可再提取
			 * 		=>	供 redo 使用
			 */
			recycle.add(lines.removeLast());
		}
		repaint();
	}

	public void redo() {
		if (recycle.size() > 0) {
			/*		把recycle 最後的那個元素內容 拋出，再加回給 lines
			 * 		=> 就會是使用者最後清除的那條線段
			 */
			lines.add(recycle.removeLast());
		}
		repaint();
	}

	public void saveJPG01() {
		//	第二招
		BufferedImage paintImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D graphics2D = paintImage.createGraphics();
		paint(graphics2D);
		try {
			ImageIO.write(paintImage, "jpg", new File("dir3/Rev093_save0101.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//	偵測滑鼠的內部類別
	private class MyMouseListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			//	super.mousePressed(e);
			//	滑鼠偵測=>收集座標點=>座標點交給paint畫出現段
			RevPoint point = new RevPoint(e.getX(), e.getY());
			//	點下去是產生新線段 (line)
			LinkedList<RevPoint> line = new LinkedList<>();
			line.add(point);	//	將點座標放入線段line中
			lines.add(line);	//	把線段放入筆劃集合裡
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			//super.mouseDragged(e);
			RevPoint point = new RevPoint(e.getX(), e.getY());
			lines.getLast().add(point);	//	該點是放在該筆劃的最後一個點座標
			repaint();
		}
		
	}
	
	//	方法：傳到外部讓Rev093_Sign01可以執行物件的序列化
	public LinkedList<LinkedList<RevPoint>> getLines() {
		return lines;
	}
	
	//	方法：讓解序列化的物件可以讀進來
	public void setLines(LinkedList<LinkedList<RevPoint>> lines) {
		this.lines = lines;
	}
}

class RevPoint implements Serializable {
	/*		為了儲存物件的方法，將RevPoint從原本的內部類別改成外部類別
	 * 		並實作可序列化
	 */
	
	//	儲存座標位置
	int x, y;
	public RevPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}	
}
