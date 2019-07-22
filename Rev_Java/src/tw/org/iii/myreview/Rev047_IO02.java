package tw.org.iii.myreview;

import java.io.File;
import java.io.IOException;

/*		20180811 PM1 & PM2 I/O File 類別
 * 		檔案系統操作
 */

public class Rev047_IO02 {

	public static void main(String[] args) {
		File f1 = new File("dir1/");	// 後方加斜線表示為目錄
		File f2 = new File("dir2/");
//		File f3 = new File("dir3/");	// 物件有做出不代表其目錄/檔案一定存在
		
		//	代表一個目錄dir6，前面為其路徑
		File f3 = new File("dir3/dir4/dir5/dir6");
		
		//	路徑可以是檔案，也是目錄
		File f4 = new File("dir3/dir4/dir5/dir6/file1");
		
		
		if (f1.exists()) {
			System.out.println("f1 Exist");
		}
		
//		if (f3.exists()) {
//			System.out.println("f3 exist");
//		}else {
//			//	f3的實體目錄不存在--> 使用 mkdir()
//			//f3.mkdir();	//	用於替使用者建立環境目錄
//			System.out.println("f3.mkdir() : " + f3.mkdir()); // f3目錄不存在
			//f3.mkdirs();	// 建立多層目錄
//		}
		
		if (!f4.exists()) {
			/*	正常的檔案操作
			 * 	路徑是否存在
			 * 	路徑是檔案還是目錄？
			 * 	是否可讀可執行？
			 */
			
			//	如果f4的路徑不存在-->建立新檔	creatNewFile()
			try {
				f4.createNewFile();
			} catch (IOException e) {
				System.out.println(e.toString());
				//e.printStackTrace();
			}
		}else {
			System.out.println("f4檔案路徑是否存在？  " + f4.exists());
		}
		
		
		System.out.println("----------");
		
		/*		比對路徑是否相同？
		 * 		File.equals方法	(比對相對路徑)
		 * 		-->其實沒有什麼特別的意義	(test its abstractPath)
		 * 		-->如果有需要就override修改
		 * 		-->或是直接判斷絕對路徑 (抓出後用字串判斷)
		 */
		
		File f5 = new File("dir1");
		File f6 = new File("dir2/../dir1");	// .. 相對目錄回到上一層
		File f7 = new File("dir3/dir4/../../dir1");
		File f8 = new File("dir1");
		//	其實f5~f8都代表dir1的路徑
		System.out.println("f5 == f6 : " + (f5 == f6));
		System.out.println("f5.equals(f6) : " + f5.equals(f6));
		System.out.println("f5.equals(f7) : " + f5.equals(f7));
		System.out.println("f5.equals(f8) : " + f5.equals(f8));
		//	印出絕對路徑
		System.out.println(f6.getAbsolutePath());
		System.out.println(f7.getAbsolutePath());
		System.out.println(f8.getAbsolutePath());
		
		/*		File物件可建立並給予路徑名稱，但不表示實體目錄也建立
		 * 		
		 */
		
	}

}
