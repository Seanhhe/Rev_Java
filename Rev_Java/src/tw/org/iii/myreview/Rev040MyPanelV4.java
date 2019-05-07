package tw.org.iii.myreview;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Rev040MyPanelV4 extends Rev040MyPanel {
	
	private int a = 10;
	private int b = 20;
	private int c = 30;
	
	public Rev040MyPanelV4() {
		//super();
		// 第一招：直接實作 MouseListener介面-->實務上不建議這樣寫
//		addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				
//			}
//
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//				
//			}
//			
//		});
		addMouseListener(mListener);
		addMouseListener(mListener2);
		RevMouseListenerV100 mListener3 = new RevMouseListenerV100(this); // this-->傳入MyPanelV4
		addMouseListener(mListener3);
	}
	
	/*		第二招
	 * 		由於該物件只會使用一次，可以直接產生物件變數
	 * 		通常該物件內的方法不多
	 */
	private MouseListener mListener = new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			//super.mouseClicked(e);
			System.out.println("V4 mListener: a = " + a);
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			//super.mouseEntered(arg0);
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			//super.mouseExited(arg0);
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			//super.mousePressed(arg0);
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			//super.mouseReleased(arg0);
		}
	};
	
	
	public int getC() {
		return c;
	}
	
	/*		第三招：更精簡的寫法
	 * 		mListener2
	 */
	private MouseListener mListener2 = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			super.mouseClicked(arg0);
			System.out.println("第三招  V4 mListener2 : b " + b);
		}
		
	};
}

class RevMouseListenerV100 extends MouseAdapter {
	// 變數的生命週期
	// 無法存取Rev040MyPanelV4裡的屬性? => 接收V4物件並呼叫V4.getC方法取得其值
	// 那為什麼不使用內部類別就好?
	// 因為如果該類別有產生多個物件，建議還是使用這個方法
	private Rev040MyPanelV4 obj; // 儲存傳入的Rev040MyPanelV4
	public RevMouseListenerV100(Rev040MyPanelV4 obj) {
		this.obj = obj; // 建構式接收傳入的MyPanelV4
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//super.mouseClicked(e);
		//System.out.println(c); // c 存取不到
		System.out.println("V4 : obj.getC()" + obj.getC()); // 存取該物件的方法去取值
	}
		
}