package tw.org.iii.myreview;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Rev040MyPanelV4 extends Rev040MyPanel {
	
	public Rev040MyPanelV4() {
		//super();
		addMouseListener(new MouseListener() {
			// 第一招：直接實作 MouseListener介面-->實務上不建議這樣寫
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
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
			
		});
		
	}
	
	
}

class RevMouseListenerV100 extends MouseAdapter {
	// 變數的生命週期
	// 無法存取Rev040MyPanelV4裡的屬性? => 接收V4物件並呼叫V4.getC方法取得其值
	// 那為什麼不使用內部類別就好?
	// 
}