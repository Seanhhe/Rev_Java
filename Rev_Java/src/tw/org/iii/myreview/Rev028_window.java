package tw.org.iii.myreview;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 		20180808 Brad26 單一視窗程式(JFrame)
 * 		https://docs.oracle.com/javase/7/docs/api/
 * 
 * @author SEAN
 *		如何尋找合適的API類別來使用?
 *		1. 人類的知識判斷(關鍵字)
 *		2. 經驗累積
 *		3. 善用google
 *
 *		>所有的視窗元件都是Componet
 *		>容器可以再裝容器
 *
 *		重點: 物件導向的方式寫程式
 */

public class Rev028_window extends JFrame{

	// fields 屬性
	private JButton b1;
	private JButton b2;
	private JButton b3;
	
	// constructor
	public Rev028_window() {	// 自訂建構式
		super("my first window");	// 指定呼叫父類別有傳參數建構式 (傳入視窗標題)
		
		// 加入按鈕 (視窗擁有按鈕)
		b1 = new JButton("Button1");
		b2 = new JButton("Button2");
		b3 = new JButton("Button3");
		
//		// 顯示按鈕 --> 變成滿版的大按鈕, 且按鈕會重疊 >> 改用setLayout
//		b1.setLocation(100, 100);
//		b2.setLocation(200,200);
//		b3.setLocation(300,300);
//		add(b1);	// 視覺上的加入到容器中
//		add(b2);
//		add(b3);
//		// 控制效果差
//		setSize(100,100);	// 視窗尺寸
//		setVisible(true);
		
		/*	上面那招不好用, 改找個室內設計師 --> setLayout
		 * 	add可以多個, set只能一個
		 * 	
		 * 	Interface (介面) : 比較像是一種規格
		 * 	LayoutManager --> FlowLayout
		 * 	
		 * 	FlowLayout建構式
		 *  FlowLayout(int align, int hgap, int vgap);
		 */
		
		// 自動版面配置
		setLayout(new FlowLayout(FlowLayout.LEFT, 50, 100));
		add(b1); add(b2); add(b3);
		
		// 按下按鈕要做什麼事 (觸發動作)
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("b1: OK");
			}
			
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("b2: OK");
			}
		});
		
		
		/*	善用繼承關係 & API文件
		 * 	當繼承的類別方法沒有所需的方法時, 可向上找尋父類別的父類別是否有合適的方法
		 */
		//System.out.println("Hello");
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	
	public static void main(String[] args) {
		// 程式執行點
		// Rev028_window a1 = new Rev028_window(); // 給變數只是為了呼叫方便
		new Rev028_window(); // 沒有要呼叫的話, 直接new新物件就可以了
	}

}
