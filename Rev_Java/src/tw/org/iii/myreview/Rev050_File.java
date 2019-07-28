package tw.org.iii.myreview;

import java.io.File;

/*		20180812AM1 Brad48 File 檔案
 * 
 * 		檔案的複製、剪下、貼上
 * 
 * 		// 檔案的移動 (同時改名)
 * 		File物件A.renameTo(File物件B) 
 * 		--> 是將檔案從物件A的路徑，移動到物件B所指定的路徑。
 * 			(B的目的地檔案必須尚未產生，才會移動成功)
 * 		--> 技術參考：https://blog.xuite.net/jane17512001/PenguinDesign/116288112-%E6%AA%94%E6%A1%88%E6%93%8D%E4%BD%9C%28java.io%E3%80%81FileInputStream%E3%80%81FileOutputStream%29
 * 		
 */

public class Rev050_File {

	public static void main(String[] args) {
		// (相同分割區)剪下貼上	(Rev4-->5)
		
//		File f1 = new File("dir3/Rev4.txt");
//		File f2 = new File("dir3/dir4/Rev5.txt");
//		System.out.println("f1.getPath() : " + f1.getPath());
//		System.out.println("f2.getPath() : " + f2.getPath());
//		
//		if (f1.renameTo(f2)) {
//			System.out.println("f1.renameTo(f2) : OK");
//		}else {
//			System.out.println("f1.renameTo(f2) : Error");
//		}
		
		//	(不同分割區) 剪下貼上
		File f1 = new File("dir3/Rev5.txt"); // 先創造Rev5.txt，再執行程式
		File f2 = new File("D:/LabJava/dir1/Rev6.txt");
		
		if (f1.renameTo(f2)) {
			System.out.println("f1.renameTo(f2) : OK");
		}else {
			System.out.println("f1.renameTo(f2) : Error");
		}
		
	}

}
