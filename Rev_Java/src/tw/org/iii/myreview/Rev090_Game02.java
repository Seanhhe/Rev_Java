package tw.org.iii.myreview;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*		20180819	週期任務應用_Ball Game (進階版)
 * 
 * 		1.	建立版面	(球移動的區域)
 * 		2.	建立球體
 * 		3.	加入Timer	(要在建構球體及加球方法前寫好)
 * 		4.	加入FPS觀念
 * 
 * 		進階：多顆球 / 每顆球 都是獨立的
 * 
 * 		結合LinkedList / MouseAdapter /
 */

public class Rev090_Game02 extends JFrame {
	private GamePanel gPanel;
	
	public Rev090_Game02() {
		super("Ball Game Improved");
		setLayout(new BorderLayout());
		
		gPanel = new GamePanel();
		add(gPanel, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//	球在裏頭運動
	private class GamePanel extends JPanel {
		private BufferedImage ball;
		private int ballH, ballW, viewH, viewW;
		private Timer timer;
		/*	ArrayList => 適用  資料不常異動
		 * 	LinkedList => 適用  執行階段	資料、元素異動頻繁時
		 * 	List => 1)	有順序性	2)	資料元素可重複
		 * 	Set  => 1)	無順序性	2)	資料元素不重複
		 */
		private LinkedList<BallTask> balls = new LinkedList<>();	//	紀錄每個球 BallTask 的位移及碰撞
		
		//	建構式
		public GamePanel() {
			timer = new Timer();	//	若沒初始化，會NullPointException
			//	建構球
			try {
				ball = ImageIO.read(new File("dir3/star01.png"));
				ballH = ball.getHeight();
				ballW = ball.getWidth();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent q) {
					super.mouseClicked(q);
					//	每點一次新增一顆球
					//addBall(q.getX(), q.getY());	//	滑鼠在圖案左上角
					addBall(q.getX()-(int)(ballW/2), q.getY()-(int)(ballH/2)); //	滑鼠在圖案中間
					
				}
			});
			
			//	把畫面repaint的動作獨立出來	(FPS觀念)
			//timer.schedule(new BallTask(), 0, 33);
			timer.schedule(new ViewTask(), 0, 33);
		}

		//	加球的方法 (透過滑鼠點擊)
		private void addBall(int x, int y) {
			//	建立新的球 (含座標)
			BallTask ballTask = new BallTask(x, y);
			//	多久做一次 (Timer)
			timer.schedule(ballTask, 500, 60);
			//	新做的球放到資料結構中	(LinkedList)
			balls.add(ballTask);
		}
		
		@Override
		protected void paintComponent(Graphics e) {
			super.paintComponent(e);
			Graphics2D g2d = (Graphics2D) e;
			viewH = getHeight(); // 回傳目前JPanel元件的高度
			viewW = getWidth();  //	回傳目前JPanel元件的寬度
			
			//	把LinkedList資料結構中的多顆不同的球資訊，透過迴圈畫出
			for (BallTask ball:balls) {
				g2d.drawImage(this.ball, ball.x, ball.y, null);
			}
			
		}
				
		//	加入Timer (要在建構球體及加球方法前寫好)
		private class ViewTask extends TimerTask {
			//	內部類別中的類別
			@Override
			public void run() {
				repaint();
				//	負責更新畫面
			}
			
		}
		
		//	球的位移及碰壁反彈設計
		private class BallTask extends TimerTask {
			int x, y, dx, dy;
			
			public BallTask(int x, int y) {
				this.x = x;
				this.y = y;
				dx = dy = 6;	//	球的位移量
			}
			
			/*	球的反彈偵測
			 * 	
			 */
			@Override
			public void run() {
				if (x < 0 || x+ballW > viewW) { //	左右碰壁偵測
					dx *= -1;	//	讓球反向移動
				}
				if (y < 0 || y+ballH > viewH) {	//	上下碰壁偵測
					dy *= -1;	//	讓球反向移動
				}
				
				x += dx;
				y += dy;
				//repaint();
				/*	球每動一次就repaint，當球很多顆的時候就不合理
				 * 	將更新畫面的動作獨立出來
				 * 	讓BallTask只負責更新位置
				 */
			}
		}
	}

	
	public static void main(String[] args) {
		new Rev090_Game02();
	}
}
