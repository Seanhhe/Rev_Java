package tw.org.iii.myreview;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*		20180811 MyPanel V2
 * 		繼承Rev040MyPanelV1
 * 		原本的Rev040MyPanel改呼叫V2
 */

public class Rev089_Rev040_MyPanelV2 extends Rev089_Rev040_MyPanelV1 {
	public Rev089_Rev040_MyPanelV2() {
		/*
		 * 		Lab40改成V2仍可執行 => 父類別建構式 super();
		 * 		重點：(建構式存在的目的)
		 * 		1.	建構式是在完成物件初始化
		 * 		2.	確保父類別 (祖先們) 都存在記憶體內
		 *		3.	建構式沒有繼承，一定要重新寫		
		 */
		super();	//	可以呼叫，但是 => 父類別的無傳參數建構式裡是空的
		
		/*	add => 可增加很多？測試一下：再增加一個addML
		 * 	執行面是先觸發父類別的addML，再觸發下面這個子類別的
		 * 	如果把父類別的addML註解，只會有顏色變化
		 */
		addMouseListener(new MyMouseListener());
	}
	
	/*		Inner Class 內部類別練習
	 * 		類別中的類別
	 * 		大工廠內的小工廠
	 * 		可以直接存取外部類別的屬性與方法
	 * 
	 * 		複習：
	 * 			類別是物件的藍圖
	 * 			類別是用來產生物件實體
	 * 			類別會擁有方法&屬性
	 */
	class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			//System.out.println("V2 Click");
			//	因父類別屬性沒有宣告為private，所以子類別的內部類別可以呼叫
			color = Color.BLUE;
			System.out.println("V2 Click : Color.BLUE");
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	}
}

