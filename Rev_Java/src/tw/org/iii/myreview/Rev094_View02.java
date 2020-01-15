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
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//import tw.org.iii.myreview.Rev094_View02.Rev094MouseListener;

/*		20180819AM1	Rev094_View02
 * 		簽名程式 Rev094_Sign02 中的簽名區域 (簽名板)
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

public class Rev094_View02 extends JPanel {
	private Rev094MouseListener mouseListener = new Rev094MouseListener();
	//private LinkedList<RevPoint> line = new LinkedList<>();	// 一線段
	
	//	把收集回來的點放到LL成線段，再放到LL中儲存成很多線段(筆畫)
	//	泛型 => <線段> 線段裡面是RevPoint泛型
	//private LinkedList<LinkedList<RevPoint>> lines = new LinkedList<>();
	//	存放被刪除的線段 (資源回收)
	//private LinkedList<LinkedList<RevPoint>> recycle = new LinkedList<>();
	
	//	改用HashMap 取代 RevPoint
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines = new LinkedList<>();
	private LinkedList<LinkedList<HashMap<String, Integer>>> recycle = new LinkedList<>();
	
	public Rev094_View02() {
		setBackground(Color.BLACK); // 設定簽名板背景色
		
		/*		兩個整合成一個mouseListener
		 * 		原本需要兩個實作MouseListener & MouseMotionListener
		 * 		但透過MouserAdapter讓程式精簡化
		 * 		實作MouseAdapter內部類別 listen 兩個功能
		 */
		addMouseListener(mouseListener);	// for click
		addMouseMotionListener(mouseListener);	//	for movement
	}

	//	繪圖方法 [paintComponent(Graphics g)]
	@Override
	protected void paintComponent(Graphics g) {
		/*		透過別的方法觸發此方法 (repaint方法->執行paintComponent方法)
		 * 		而非直接呼叫	=>	一個元素的生命週期
		 * 		使用者隨時看到的畫面
		 * 
		 * 		>	為了效能：儘量在這方法內，只做讓畫面異動的動作
		 * 
		 * 		setStroke抽象方法 => 已由paintComponent實作
		 */
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.CYAN);	// 設定畫筆顏色
		g2d.setStroke(new BasicStroke(4));	//	產生畫筆，並設定寬度參數
		//g2d.drawLine(0, 0, 100, 100);	//	顯示測試線段可否正常顯示
		
		//	畫多條線
		for (LinkedList<HashMap<String, Integer>> line:lines) {
			//	畫單一一條線 (對使用者而言是畫一整條線)
			for (int i = 1; i < line.size(); i++) {
				HashMap<String, Integer> p0 = line.get(i-1);	//	線段起始點
				HashMap<String, Integer> p1 = line.get(i);	//	下一個點
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
			}
		}
	}

	// 按鈕內的方法
	public void clear() {
		lines.clear();	// 清除資料結構內的資料
		repaint();		// 重繪
	}
	
	public void undo() {
		//	上一步 => 拿掉最後一條線段
		//	先確認有線段存在lines中才執行removeLast()
		if (lines.size() > 0) {
			//lines.removeLast();
			/*		由於removeLast後會回傳被移除的那最後一個LL
			 * 		所以先把回傳的放到recycle中，若使用者需要可再提取
			 * 		=>	供redo使用
			 */
//			LinkedList<HashMap<String, Integer>> undoLastLine = lines.removeLast();
//			recycle.add(undoLastLine); // 上述兩行簡化成下面一行
			recycle.add(lines.removeLast());
		}
		repaint();	//	放在if外，不管true / false 都會repaint
	}
	
	public void redo() {
		//	先確認recycle內是否有值，才執行add
		if (recycle.size() > 0) {
			/*	把recycle最後的值拋回給lines
			 * 	=>	就會是使用者最後清除的那段線條
			 */
			//lines.add(recycle.getLast());
			lines.add(recycle.removeLast());
		}
		repaint();
	}
	
	public void saveJPG02() {
		//	第二招
		BufferedImage paintImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D graphics2D = paintImage.createGraphics();
		paint(graphics2D);
		try {
			ImageIO.write(paintImage, "jpg", new File("dir3/Rev094_save02.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//	把lines物件序列化，可傳到外部讓Rev094_Sign02呼叫使用
	public LinkedList<LinkedList<HashMap<String,Integer>>> getLines(){
		return lines;
	}
	
	//	讓解序列化的物件可以讀進來
	public void setLines(LinkedList<LinkedList<HashMap<String, Integer>>> lines) {
		this.lines = lines;
	}
	
	//	MouseAdapter滑鼠監聽事件
	private class Rev094MouseListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			//super.mousePressed(e);
			//	滑鼠偵測=>收集座標=>座標點交給paint畫出線段
			
			//RevPoint point = new RevPoint(e.getX(), e.getY());	//	取得滑鼠按下時的座標值
			
			//	收集點座標
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			//	點下去是產生新的線段
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
			line.add(point);	//	將點放入線段line中
			lines.add(line);	//	把線段放到筆畫集合裡
		}

		@Override
		public void mouseDragged(MouseEvent e) {
//			super.mouseDragged(e);
//			RevPoint point = new RevPoint(e.getX(), e.getY());
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			/*		拆解：滑鼠拖移，並顯示畫線軌跡
			 * 		把線段集合的最後一個點取出
			 * 		再把最新取得的點座標加上
			 */
			lines.getLast().add(point);
			repaint();
		}
	}
}

//class RevPoint implements Serializable {
//	/*		為了儲存物件的方法，將RevPoint從原本的內部類別改成外部類別
//	 * 		並實作可序列化
//	 */
//	
//	//	儲存座標位置
//	int x, y;
//	public RevPoint(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}