package tw.org.iii.myreview;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*		20180819AM1 13:00
 * 		Collection應用_簽名程式
 * 		1.	先設計程式視窗(Layout, Button等)
 * 		2.	建立簽名板的程式類別 => 之後完成再放在主程式
 * 		3.	設計簽名板的程式類別	(Rev094_Sign02先放一邊)
 */

public class Rev094_Sign02 extends JFrame {
	private JButton clear, undo, redo, saveObject, saveJPG, loadObject;
	private Rev094_View02 myView;
	
	public Rev094_Sign02() {
		//	視窗建構的初始化
		super("簽名程式：Rev094_Sign02 (複習版)");
		//	放最前面
		setLayout(new BorderLayout());
		
		//	產生	top 上半部 (JPanel)
		JPanel top = new JPanel(new FlowLayout());
		//	產出按鈕
		clear = new JButton("清除畫面");
		undo = new JButton("上一步");
		redo = new JButton("重作");
		saveJPG = new JButton("存成JPG");
		saveObject = new JButton("存成物件");
		loadObject = new JButton("匯入物件");
		
		//	把按鈕加入 top (上半部)
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(saveJPG);
		top.add(saveObject);
		top.add(loadObject);
		
		//	把 top 放到視窗的上半部
		add(top, BorderLayout.NORTH);
		
		//	產生簽名板物件
		myView = new Rev094_View02();
		
		//	把myView放入視窗中
		add(myView, BorderLayout.CENTER);
		
		//	加入滑鼠監聽事件 [按鈕物件.addActionListener()]
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myView.clear(); //	override使用自己寫的clear()方法
			}
		});
		
		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myView.undo();
			}
		});
		
		redo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myView.redo();
			}
		});
		
		saveJPG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveJPG();
				myView.saveJPG02();
			}
		});
		
		saveObject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveObject();
			}
		});
		
		//	放最後
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//	儲存JPG
	private void saveJPG() {
		/*	第一招
		 * 	https://stackoverflow.com/questions/19621105/save-image-from-jpanel-after-draw
		 * 	https://stackoverflow.com/questions/7032556/how-to-take-a-webpage-screenshot
		 * 	
		 * 	http://puremonkey2010.blogspot.com/2013/09/java-web-page.html	
		 * 	用螢幕截圖的方法
		 */
		BufferedImage bufImage = null;	// 清空暫存
		try {
			bufImage = new Robot().createScreenCapture(myView.getBounds()); //	把螢幕畫面擷取，並放置於bufImage
		} catch (AWTException e) {
			System.out.println(e.getMessage());
		}
		
		Graphics2D graphics2D = bufImage.createGraphics();
		myView.paint(graphics2D);	//	為什麼要再畫一次？ => 儲存繪圖的部分，沒有的話是截取視窗截圖
		try {
			ImageIO.write(bufImage, "jpg", new File("dir3/Rev094_Sign01.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//	將已經序列化的簽名物件輸出為檔案
	private void saveObject() {
		//	建立LL物件，再把 Rev094_View02 的 getLines()方法，指定給剛建立的LL物件
		LinkedList<LinkedList<HashMap<String, Integer>>> lines = myView.getLines();
		//	輸出為檔案
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir3/Rev094_Sign02.obj"));
			oout.writeObject(lines);
			oout.flush();
			oout.close();
			JOptionPane.showMessageDialog(this, "Rev094_Sign02 : 物件儲存成功");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//	將已經序列化的簽名物件讀入
	private void loadObject() {
		try {
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir3/Rev094_Sign02.obj"));
			//	把收到的物件轉回LL物件
			LinkedList<LinkedList<HashMap<String, Integer>>> input = (LinkedList<LinkedList<HashMap<String, Integer>>>) oin.readObject();
			oin.close();
			
			//	把讀出的內容，透過自訂方法setLines()，放回myView
			myView.setLines(input);
			myView.repaint();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new Rev094_Sign02();
	}

}
