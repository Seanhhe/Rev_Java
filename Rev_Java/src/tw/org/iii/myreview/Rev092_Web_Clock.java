package tw.org.iii.myreview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Rev092_Web_Clock extends JPanel implements ActionListener {
	private static final int WIDTH = 400;
	private static final int HEIGHT = WIDTH;
	private static final int SAFE_ZONE = 5; //	時鐘左右上下兩側離border多遠
	
	private BufferedImage image;
	
	public Rev092_Web_Clock() {
		super();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB); //	設定BufferedImage的 寬 高 顏色屬性類型
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		paintClockFace();
		repaint();
		
		new Timer(50, this).start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		paintClockFace();
		repaint();
	}
	
	private void paintClockFace() {
		Graphics g = image.getGraphics();
		
		//	開啟反鋸齒，避免元件看起來糟糟的	(先轉型為 Graphics2D)
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//	清除之前的繪圖 (drawings);	起始座標X,Y,繪圖範圍X,Y
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		//	fill clock background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//	draw clock border
		g.setColor(Color.BLACK);
		g.drawOval(SAFE_ZONE, SAFE_ZONE, WIDTH - (SAFE_ZONE*2), HEIGHT - (SAFE_ZONE*2));
		
		//	retrieve time 擷取時間的方法 (自行設計)
		int[] time = getTime();
		
		/*		時針與分針的角度計算
		 * 		時針每小時走30度(360/12)，每分鐘走0.5度(30/60)，每秒1/120度(0.5/60)
		 * 		分針每小時走360度(360/60)，每分鐘走6度，每秒走0.1度(6/60)
		 * 		秒針每秒走6度(360/60)
		 * 		指針中心點座標 (x,y) = (WIDTH / 2 -+ SAFE_ZONE, HEIGHT / 2 -+ SAFE_ZONE)
		 */
		//	draw hour hand 畫時針
		int hourAngle = (int)(0.5 * (time[0] * 60 + time[1]));
		int[] hourPoint = getPoint(hourAngle, WIDTH / 2 + SAFE_ZONE, HEIGHT / 2 + SAFE_ZONE, WIDTH / 2 - (SAFE_ZONE * 2));
		g.drawLine(WIDTH / 2 + SAFE_ZONE, HEIGHT / 2 + SAFE_ZONE, hourPoint[0], hourPoint[1]);
		
		//	draw the minute hand 畫分針
		int minuteAngle = (int)(time[1] * 6);
		int[] minutePoint = getPoint(minuteAngle, WIDTH / 2 + SAFE_ZONE, HEIGHT / 2 + SAFE_ZONE, WIDTH / 2 - (SAFE_ZONE * 2) - 30);
		g.drawLine(WIDTH / 2 + SAFE_ZONE, HEIGHT / 2 + SAFE_ZONE, minutePoint[0], minutePoint[1]);
		
		//	draw the second hand	畫秒針
		int secondAngle = (int)(time[2] * 6);
		int[] secondPoint = getPoint(secondAngle, WIDTH / 2 + SAFE_ZONE, HEIGHT / 2 + SAFE_ZONE, WIDTH / 2 - (SAFE_ZONE * 2) - 120);
		g.drawLine(WIDTH / 2 + SAFE_ZONE, HEIGHT / 2 + SAFE_ZONE, secondPoint[0], secondPoint[1]);
	}
	
	//	算出各個指針末端的座標	(指針角度, 時鐘中心點x, 時鐘中心點y, 各種指針半徑)
	private int[] getPoint(int angle, int x, int y, int radius) {
		int[] ret = new int[2];
		
		angle += 90 * 3;
		//angle = angle + 90 * 3;
		//	為什麼要加270度
		
		/*	輸入角度求弧度：Math.toRadians(角度)
		 * 	輸入弧度求sin值：Math.sin(弧度)
		 * 	再用三角函數求對邊 (Y方向)
		 * 
		 * 	輸入弧度求cos值：Math.cos(弧度)
		 * 	再用三角函數求鄰邊 (X方向)
		 */
		ret[0] = (int)(x + radius * Math.cos(Math.toRadians(angle)));
		ret[1] = (int)(y + radius * Math.sin(Math.toRadians(angle)));
		
		return ret;
		
	}
	
	private int[] getTime() {	//	設計擷取時間方法，自訂格式
		Calendar now = Calendar.getInstance();
		
		int[] ret = new int[3];
		ret[0] = now.get(Calendar.HOUR);
		ret[1] = now.get(Calendar.MINUTE);
		ret[2] = now.get(Calendar.SECOND);
		return ret;
	}
}
