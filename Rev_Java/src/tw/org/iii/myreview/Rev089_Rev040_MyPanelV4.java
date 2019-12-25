package tw.org.iii.myreview;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Rev089_Rev040_MyPanelV4 extends Rev089_Rev040_MyPanelV1 {
	private int a = 10;
	private int b = 20;
	private int c = 30;
	
	public Rev089_Rev040_MyPanelV4() {
		//super();
		//	第一招：直接實作 MouseListener 介面 => 實務上不建議這樣寫
//		addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				
//			}
//			
//		});
		addMouseListener(mListener);
	}
	
	/*		第二招
	 * 		由於該物件只會使用一次，可以直接產生物件變數
	 * 		通常該物件內的方法不多
	 */	
	private MouseListener mListener = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			color = Color.BLACK;
			System.out.println("V4 mListener : a = " + a);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			//super.mouseEntered(e);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			//super.mouseExited(e);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			//super.mousePressed(e);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			//super.mouseReleased(e);
		}
		
	};
	
}
