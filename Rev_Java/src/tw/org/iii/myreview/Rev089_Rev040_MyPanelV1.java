package tw.org.iii.myreview;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/*	20180811AM1
 * 	追加點選畫面，圖案出現在滑鼠位置，且滑鼠點擊位置是該圖案中心。
 */

public class Rev089_Rev040_MyPanelV1 extends JPanel implements MouseListener { // 把這支副程式整個當作一個群組
	private int ballx; // 0811AM1 更新
	private int bally;
	
	Color color; // java.awt
	
	// 建構式
	public Rev089_Rev040_MyPanelV1() {
		System.out.println("Rev089_Rev040_MyPanelV1 : 無傳參數建構式");
		//addMouseListener(this);
	}
	
	public Rev089_Rev040_MyPanelV1(int ballx, int bally) {
		System.out.println("Rev089_Rev040_MyPanelV1(int ballx, int bally) : 有傳參數建構式");
		this.ballx = ballx;
		this.bally = bally;
		color = Color.RED;
		
		addMouseListener(this); // 如果java不認識，就是上頭類別忘了繼承&實作介面
		// this => Rev089_Rev040_MyPanelV1 本人聽
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
