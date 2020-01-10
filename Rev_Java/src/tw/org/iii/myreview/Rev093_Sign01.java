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
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*		20180819AM1	13:00
 * 		Collection應用_簽名程式
 * 		1.	先設計程式視窗(Layout, button等)
 * 		2.	建立簽名板程式類別	=>	之後完成再放在主程式
 * 		3.	設計簽名板程式類別	(Rev093_Sign01先放一邊)
 */

public class Rev093_Sign01 extends JFrame {
	private JButton clear, undo, redo, saveObject, saveJPG, loadObject;
	private Rev093_View01 myView;
	
	public Rev093_Sign01() {
		//	視窗建構的初始化
		super("Rev093_Sign01 簽名程式");
		setLayout(new BorderLayout());
		//	產出上半部
		JPanel top = new JPanel(new FlowLayout());
		//	產出按鈕
		clear = new JButton("清除畫面");
		undo = new JButton("上一步");
		redo = new JButton("重做");
		saveJPG = new JButton("存成JPG");
		saveObject = new JButton("存成物件");
		loadObject = new JButton("匯入物件");
		
		//	把按鈕加入上半部(top)
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(saveJPG);
		top.add(saveObject);
		top.add(loadObject);
		
		//	再把top放入視窗的上半部
		add(top, BorderLayout.NORTH);
		
		//	產生簽名板物件
		myView = new Rev093_View01();
		
		//	把myView放入視窗中
		add(myView, BorderLayout.CENTER);
		
		//	把按鈕功能加入ActionListener中(建構式內)
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myView.clear();
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
				myView.saveJPG01();
			}
		});
		
		saveObject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveObject();
			}
		});
		
		loadObject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadObject();
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
		BufferedImage bufImage = null; //	清空暫存
		try {
			bufImage = new Robot().createScreenCapture(myView.getBounds());
		} catch (AWTException e) {
			System.out.println(e.getMessage());
		}
		
		Graphics2D graphics2D = bufImage.createGraphics();
		myView.paint(graphics2D);	//	為什麼要再畫一次？	=>	儲存繪圖的部分，沒有的話是擷取視窗截圖
		try {
			ImageIO.write(bufImage, "jpeg", new File("dir3/Rev093_save01.jpeg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/*		ArrayList =>	資料不常異動的 (建議使用)
	 * 		LinkedList =>	執行階段/元素異動性大的 (建議使用)
	 * 		兩者在應用面上沒有太大差別
	 * 
	 * 		Set的特性
	 * 		1.	沒有順序性
	 * 		2.	裡面的元素不會重複
	 * 
	 * 		List的特性
	 * 			有順序性，元素可重複
	 * 
	 * 		可參考：https://github.com/dh-46/HW_Java/blob/master/Practice_Java/src/tw/org/iii/practiceJava/Rev073_Collection.java
	 */
	
	//	將簽名物件序列化輸出
	private void saveObject() {
		//	取得LinkedList物件
		LinkedList<LinkedList<RevPoint>> lines = myView.getLines();
		
		//	輸出物件 (輸出變成實體的檔案)
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir3/Rev093_Sign01.obj"));
			oout.writeObject(lines);
			oout.flush();
			oout.close();
			JOptionPane.showMessageDialog(this, "儲存成功");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void loadObject() {
		try {
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir3/Rev093_Sign01.obj"));
			//	把收到的東西轉回來
			LinkedList<LinkedList<RevPoint>> input = (LinkedList<LinkedList<RevPoint>>) oin.readObject();
			oin.close();
			
			//	把讀出來的內容放回myView
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
		new Rev093_Sign01();
	}

}
