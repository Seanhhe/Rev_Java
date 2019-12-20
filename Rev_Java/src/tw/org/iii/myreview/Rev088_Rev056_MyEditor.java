package tw.org.iii.myreview;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*		20180812AM2 Reader & Writer 應用_記事本
 * 
 * 		將功能切割成小區塊-->增加程式維護的使用性
 * 		挑核心功能 / 小功能 先設計-->後續可呼叫
 * 
 * 		1.	基礎功能確認
 * 		2.	視窗版面配置
 * 		3.	開始寫程式_設定建構式 (排版)
 * 			文字編輯超過頁面時不能捲動_JScrollPane
 * 		4.	事件/功能設計：按鈕功能綁定	(程式先挑會的寫)
 * 		4-1. Open功能
 * 		4-2. ReadFile
 * 		4-3. Save功能
 * 		4-4. Save As
 * 
 */

public class Rev088_Rev056_MyEditor extends JFrame{
	private JButton newFile, open, saveAs, save;
	private JTextArea editor;
	private File nowFile;
	/*		nowFile 為什麼要給null值	(參照Rev053)
	 * 		1.	因為第一次的給值=>初始化，未初始化會導致編譯失敗。
	 * 		2.	另外一個原因，在這個類別中要開啟檔案才會真的動到這個檔
	 * 			(如果前面沒先給值就會到這時候才給，但是這樣會編譯失敗)
	 * 			因此要在宣告時給null值。
	 * 		3.	雖然給null值(空值)，但是不會因為沒有初始化造成編譯失敗
	 * 
	 * 		nowFile的作用：一次編輯一個檔案 (nowFile)
	 */
	
	public Rev088_Rev056_MyEditor() {
		super("My Editor Rev");
		// 放在建構式的開頭
		setLayout(new BorderLayout());
		
		JPanel top = new JPanel(new FlowLayout()); // 群組的容器，可放按鈕標籤等等物件
		newFile = new JButton("開新檔案");
		open = new JButton("開啟舊檔");
		save = new JButton("儲存");
		saveAs = new JButton("另存新檔");
		// 加入JPanel群組容器內 (方便後續統一設定格式)
		top.add(newFile);
		top.add(open);
		top.add(save);
		top.add(saveAs);
		
		add(top, BorderLayout.NORTH);
		
		editor = new JTextArea(); // 初始化
		editor.setFont(new Font("Default", Font.PLAIN, 20)); // 設定字體及大小
		add(editor, BorderLayout.CENTER);
		
		// Open功能
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 自創開啟檔案的 Method
				openFile();
			}
			
		});
		
		// save 功能
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveFile();
			}
			
		});
		
		// saveAs 功能
		saveAs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveAs();
			}
			
		});
		
		// newFile 功能
		newFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newFile();
			}
			
		});
		
		//	放在建構式的最後，缺一不可
		setSize(480, 480);
		setVisible(true); // false 或未設定 => 在背景執行
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void openFile() {
		JFileChooser jFileChooser = new JFileChooser("./dir3/");
		/*	參考文件：How to use JFileChooser
		 * 	https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
		 */
		int returnVal = jFileChooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// 抓取選擇的檔案
			nowFile = jFileChooser.getSelectedFile();
			// 確認檔案是可讀的
			if (nowFile.isFile() && nowFile.canRead()) {
				readFile(); // 自創讀取檔案的Method
			}else {
				nowFile = null;
			}
		}
	}
	
	private void readFile() {
		try {
			editor.setText(""); // 清空上一個檔案的文字
			FileReader reader = new FileReader(nowFile);
			int len = 0;
			char[] buf = new char[4096]; // byte陣列不可讀
			/*		read方法將 nowFile 的字元讀到buf陣列裡，回傳讀進來的
			 * 		字元數[4096]。
			 * 		如果字元數等於-1代表讀取完畢
			 */
			while((len = reader.read(buf)) != -1) {
				editor.append(new String(buf, 0, len));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 存檔功能
	/*	20191220 > 上午 > saveAs()還沒寫，saveFile()不正常
	 * 			 > 下午 > saveAs()寫了，saveFile()正常了
	 */
	private void saveFile() {
		if (nowFile != null) {
			try {
				// 先建立(把 nowFile 導入) FileWriter 物件
				FileWriter writer = new FileWriter(nowFile);
				editor.write(writer); // 再把JTextArea的內容寫出至FileWriter
				// 告訴使用者訊息
				JOptionPane.showMessageDialog(this, "儲存成功!!");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}else {
			saveAs();
		}
	}
	
	// 另存新檔
	private void saveAs() {
		JFileChooser jFileChooser = new JFileChooser("./dir3/");
		if (jFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			// 抓取選擇的檔案
			nowFile = jFileChooser.getSelectedFile();
			saveFile();
		}
	}
	
	// 開新檔案
	private void newFile() {
		nowFile = null; // 眼睛看不到的File物件也要clear
		editor.setText("");
	}

	public static void main(String[] args) {
		new Rev088_Rev056_MyEditor();
	}
}