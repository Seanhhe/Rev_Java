package tw.org.iii.myreview;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*		20180819PM1	週期任務應用_Ball Game
 * 
 * 		1.	建立版面	(球可移動的區域)
 * 		2.	建立球體
 * 		3.	加入Timer
 * 		4.	加入FPS觀念
 * 
 * 		進階：多顆球 / 每顆球都是獨立的
 * 
 * 		結合LinkedList / MouseAdapter /
 */

public class Rev090_Game01 extends JFrame {
	private GamePanel gPanel;
	
	public Rev090_Game01() {
		super("Ball Game (Review)");
		setLayout(new BorderLayout());
		
		gPanel = new GamePanel();
		add(gPanel, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//	球在裡頭運動
	private class GamePanel extends JPanel {
		private BufferedImage ball;
		private int ballH, ballW, viewH, viewW, ballX, ballY, dx, dy;
		private Timer timer;
		
		public GamePanel() {
			timer = new Timer();
			dx = dy = 5; //	球的位移量
			//	建構球
			try {
				ball = ImageIO.read(new File("dir3/star01.png"));
				ballH = ball.getHeight();
				ballW = ball.getWidth();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			//	把畫面repaint的動作獨立出來	(FPS觀念)
			timer.schedule(new BallTask(), 0, 20);
			timer.schedule(new ViewTask(), 0, 20);
		}

		@Override
		protected void paintComponent(Graphics e) {
			super.paintComponent(e);
			Graphics2D g2d = (Graphics2D)e;
			viewH = getHeight(); //	回傳這個元件的高度
			viewW = getWidth();  //	回傳這個元件的寬度
			
			g2d.drawImage(ball, ballX, ballY, null);
		}
		
		private class ViewTask extends TimerTask {
			//	內部類別中的類別
			@Override
			public void run() {
				repaint();
				//	負責更新畫面
			}
			
		}
		
		//	球的運動公式	(動一次就更新畫面一次)
		private class BallTask extends TimerTask {

			@Override
			public void run() {
				/*	02.	碰牆反彈	(判斷邏輯)
				 * 		a)	碰右邊
				 * 			ballX+ballW => X座標+圖片寬度
				 * 			viewW => 元件的寬度
				 * 		b)	碰左邊
				 * 			ballX < 0
				 * 		c)	碰下邊
				 * 			ballY+ballH => Y座標+圖片高度
				 * 			viewH => 元件的高度
				 * 		d)	碰上邊
				 * 			ballY < 0
				 */
				if (ballX < 0 || ballX+ballW > viewW) {
					dx *= -1;	//	往反方向移動
				}
				if (ballY < 0 || ballY+ballH > viewH) {
					dy *= -1;
				}
				
				//	01.	從原點開始往右下移動
				ballX += dx;
				ballY += dy;
				/*	球每動一次就repaint，當球很多顆的時候就不合理
				 * 	將更新畫面的動作獨立出來
				 * 	讓BallTask只負責更新位置
				 */
			}
			
		}
	}
	
	public static void main(String[] args) {
		new Rev090_Game01();
	}

}
