package tw.org.iii.myreview;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*		20180819PM2	Racing
 * 		執行緒案例體會	=>	賽馬
 * 		
 * 		1.	設計視窗畫面排版
 * 		2.	建立視窗畫面	JFrame, JLabel(文字的賽道)
 * 		3.	設計上面賽跑的馬	(跑在哪裡=>賽道/	有生命的馬/	很多匹馬 [陣列])
 * 		4.	每回合如何執行
 * 		5.	
 */

public class Rev091_Racing01 extends JFrame {
	private JButton start;
	private JLabel[] lanes = new JLabel[8];
	private Horse[] horses = new Horse[8];
	private int rank;	//	顯示排名
	
	public Rev091_Racing01() {
		super("Rev091_Racing");
		setLayout(new GridLayout(9, 2)); //	GridLayout(rows橫, columns直)
		
		//	建立按鈕
		start = new JButton("Start");	//	初始化
		add(start);
		
		//	建立跑道
		for (int i = 0; i < lanes.length; i++) {
			lanes[i] = new JLabel((i+1) + "."); //	要建立物件並初始化
			add(lanes[i]);	//	lanes[i].equals(lanes); 是不同物件
		}
		
		//	幫start按鈕加入ActionListener
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				newRound(); //	重開新比賽
				start.setEnabled(false); //	把按鈕功能關掉(等比賽結束才能恢復start功能)
			}
		});
		
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void newRound() {
		rank = 1; //	為什麼要等於1?
		//	every round => new every horse
		for (int i = 0; i < horses.length; i++) {
			lanes[i].setText((i+1)+"."); //	清空跑道
			horses[i] = new Horse(i); //	建立新物件陣列&初始化
			horses[i].start(); // 把 horses 執行緒放到 Run Pool
		}
	}

	private void stopGame() {
		//	通知所有馬匹執行緒停止 => 利用 interrupt => 產生例外，在例外處理 break
		for (int i = 0; i < horses.length; i++) {
			horses[i].interrupt();
			start.setEnabled(true); //	enable the button
			//	是否要在迴圈外?
		}
	}
	
	private class Horse extends Thread {
		int lane;	//	馬匹要對應的跑道
		//	有生命力的馬 (執行緒) XD
		public Horse(int lane) {
			this.lane = lane;
		}
		
		@Override
		public void run() {
			super.run();
			//	生命表現在 run方法 (跑起來)
				/*	設定跑道長度為100格 (0-99)
				 * 	顯示比賽排名
				 * 	當第一名到達終點，比賽就停止
				 */
			for (int i = 0; i < 100; i++) {
				lanes[lane].setText(lanes[lane].getText() + ">"); //	讀之前的text再加上這一次的text
				//	如果第一名到終點，比賽就停止
				if (i == 99) {
					lanes[lane].setText(lanes[lane].getText() + "Rank " + rank); //	在跑道末端印出Rank排名
					stopGame();
				}
				//	還沒到終點，繼續跑 (記得馬匹是執行緒)
				try {
					Thread.sleep(50 + (int)(Math.random()*200));
				} catch (InterruptedException e) {
					//System.out.println(e.getMessage());
					break;	//	例外出現，提早結束
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Rev091_Racing01();
	}

}
