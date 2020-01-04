package tw.org.iii.myreview;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*		20180825PM2 Racing02
 * 		追加時鐘 (外部類別)
 */

public class Rev092_Racing02 extends JFrame {
	private JButton start;
	private JLabel[] lanes = new JLabel[8];
	private Horse[] horses = new Horse[8];
	private int rank;
	private Rev092_Web_Clock clock;
	
	public Rev092_Racing02() {
		super("Rev092_Racing02");
		setLayout(new GridLayout(9, 0));
		
		//	加入時鐘，排版改變了
		JPanel top = new JPanel(new BorderLayout());
		start = new JButton("START");
		clock = new Rev092_Web_Clock();
		//clock.setSize(60, 60);
		
		//	加入按鈕、時鐘
		top.add(start, BorderLayout.CENTER);
		top.add(clock, BorderLayout.WEST);
		add(top);
		
		//	加入跑道 lanes
		for (int i = 0; i < lanes.length; i++) {
			lanes[i] = new JLabel((i+1) + ".");
			add(lanes[i]);
		}
		
		//	把動作ActionListener加入start按鈕
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				newRound();
				start.setEnabled(false);	// 把start按鈕disable (當newRound啟動時)
			}
			
		});
				
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void newRound() {
		rank = 1; //	第一名獎盃
		for (int i = 0; i < horses.length; i++) {
			lanes[i].setText((i+1) + "."); //	清除跑道
			horses[i] = new Horse(i);	//	每開新局，重新建立新物件
			horses[i].start(); //	把執行緒放到 Run Pool 排隊執行
		}
	}

	private void stopGame() {
		for (int i = 0; i < horses.length; i++) {
			//	通知所有馬匹執行緒停止 => 利用interrupt => 產生例外 > 在例外處理 (break)
			horses[i].interrupt();
			start.setEnabled(true);
		}
		
	}

	private class Horse extends Thread {
		int lane; // 馬匹對應的跑道

		public Horse(int lane) {
			this.lane = lane;
		}

		@Override
		public void run() {
			super.run();
			//	生命表現在 run方法 (執行緒)
			for (int i = 0; i < 100; i++) { //	假設跑道長度100
				lanes[lane].setText(lanes[lane].getText() + ">");	//	讀之前的text再加上新的text
				if (i == 99) {
					// show rank
					lanes[lane].setText(lanes[lane].getText() + rank);
					stopGame(); // 第一名抵達跑道終點(99)，就會停止
				}
				
				try {
					Thread.sleep(50 + (int)(Math.random()*200));
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
					break;	//	提早結束
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Rev092_Racing02();
	}

}
