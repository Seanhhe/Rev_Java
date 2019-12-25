package tw.org.iii.myreview;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*		20180811 第三版
 * 
 */

public class Rev089_Rev040_MyPanelV3 extends Rev089_Rev040_MyPanelV1 {
	public Rev089_Rev040_MyPanelV3() {
		super(); //	預設呼叫父類別的無傳參數建構式
		addMouseListener(new MyMouseListener());
	}

	private class MyMouseListener extends MouseAdapter {

		/*		Recording 1:15:00
		 * 		內部類別一樣要有物件實體，否則只是宣告而已
		 * 		Rev089_Rev040_MyPanelV3所擁有的工廠
		 * 		=>	和屬性一樣也有四個存取修飾字	[不像外部類別 只有 public/沒有 ]
		 *		=>	因為它依然屬於該物件，所以有四個存取修飾字
		 *		Rev040_MyPanelV3 Object "has-a" Inner Class
		 *		通常設為private僅供自己使用
		 */
		
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			/*		MouseAdapter -> 調變器	(抽象類別只是實作MouseListener)
			 * 		super.mouseClicked(); --> 所以可以不用
			 * 		MA目的繼承MouseListener，讓使用者好調變
			 */
			color = Color.RED;
			System.out.println("V3 mouseClicked : OK"); // 確認有觸發
		}
				
	}

}
