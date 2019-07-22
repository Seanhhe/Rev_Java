package tw.org.iii.myreview;

import java.io.File;

/*		20180811 PM1 I/O 輸入輸出 50:53 Brad44
 * 		1. 對檔案系統的一種操作
 * 		2. 對檔案的存取-->串流的觀念 (把檔案讀出來)
 * 
 * 		API_File (java.io.file)
 */

public class Rev046_IO01 {

	public static void main(String[] args) {
		/*		印出分號與斜線
		 * 		不同作業系統印出的不同
		 * 		Path: Mac ":" Win ";"
		 * 		Separator: Mac "/" Win "\"
		 */
		System.out.println("File.pathSeparatorChar => " + File.pathSeparatorChar);
		System.out.println("File.pathSeparator => " + File.pathSeparator);
		System.out.println("File.separator => " + File.separator);
		
		//File dir1 = new File("C:\\LabJava\dir1"); // escape sequence 跳脫字元 \d, \\, \n...等
		//File dir1 = new File("C:\\LabJava\\dir1"); // 兩斜線 --> 代表一個斜線
		File dir1 = new File("C:/LabJava/dir1");	// [這個比較好] 使用Mac / Linux 系統的表現方式，Java跨平台，所以可以這樣處理。
		System.out.println("dir1.exists() : " + dir1.exists()); // 該檔案目錄是否存在
		
		/*		字串內有左上右下斜的斜線 --> 除了跳脫字元以外，都會編譯失敗
		 */
		
		/*		跨平台觀念2
		 * 		static File[]	listRoots()
		 */
		System.out.println("跨平台觀念2 絕對路徑");
		File[] roots = File.listRoots(); // 列出檔案系統中可用的root
		System.out.println("root.getAbsolutePath(): ");
		for (File root : roots) {
			/*		取出該物件的絕對路徑
			 * 		Win系統會顯示多根  C: D: E: ... (各磁碟機路徑)
			 * 		Mac / Linux 只會顯示單根  /
			 * 		根  代表盡頭
			 * 
			 * 		
			 */
			System.out.println(root.getAbsolutePath());
		}
		
		
		/*		跨平台觀念3		相對路徑
		 * 		每個本目錄都會知道自己的父目錄是誰
		 * 		--> 一個串一個就可以產生樹狀架構
		 */
		System.out.println("跨平台觀念3  相對路徑");
		
		File dir2 = new File(".");	// 代表本目錄 (目前是專案目錄)
		System.out.println(dir2.getAbsolutePath());
		
		File dir3 = new File("./dir2");
		System.out.println("dir2.exists() " + dir2.exists());
		System.out.println("dir3.exists() " + dir3.exists());
		
		/*		建議學習	File System & 作業系統
		 * 		讀 / 寫 / 執行
		 */
	}

}
