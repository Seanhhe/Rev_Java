package tw.org.iii.myreview;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 
 * @author SEAN
 * 		How To Use FlowLayout
 *		參考網址: https://docs.oracle.com/javase/tutorial/uiswing/layout/flow.html
 *		
 *		程式碼範例
 *		https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/FlowLayoutDemoProject/src/layout/FlowLayoutDemo.java
 *		
 *		00. 物件
 *		01. 屬性
 *		02. 建構式
 *		03. 主程式
 */
public class Rev028_FlowLayoutDemo extends JFrame{
	JRadioButton RtoLbutton;
	JRadioButton LtoRbutton;
	FlowLayout experimentLayout = new FlowLayout();
	JButton applyButton = new JButton("Apply component orientation");
	String RtoL = "Right to Left";
	String LtoR = "Left to Right";
	
	// 建構式
	public Rev028_FlowLayoutDemo(String name) {
		super(name);
	}
	
	// 方法
	/*
	 * 		JPanel: 有點像一個群組的概念, 可以把許多元件放在同一個Panel裡面,
	 * 				 然後對整個Panel進行整體背景、邊框來設計.
	 * 				或是進行權限控管的時候，也可以用Panel來區分
	 * 		參考網址：https://blog.xuite.net/jane17512001/PenguinDesign/246071255-%E8%A6%96%E7%AA%97%E7%A8%8B%E5%BC%8F+Java+Swing+-+%E5%B8%B8%E7%94%A8%E5%85%83%E4%BB%B6
	 * 		
	 */
	//	方法
	public void addComponetsToPane(final Container pane) {
		final JPanel compsToExperiment = new JPanel();
		compsToExperiment.setLayout(experimentLayout); // FlowLayout的變數 --> experimentLayout
		experimentLayout.setAlignment(FlowLayout.TRAILING); // 設定FlowLayout的對齊方式 (trailing 尾隨)
		JPanel controls = new JPanel();
		controls.setLayout(new FlowLayout());
		
		LtoRbutton = new JRadioButton(LtoR);
		LtoRbutton.setActionCommand(LtoR);
		RtoLbutton = new JRadioButton(RtoL);
		RtoLbutton.setActionCommand(RtoL);
		
		// Add buttons to the experiment layout
		// 將按鈕加入experiment layout中
		compsToExperiment.add(new JButton("Button 1"));
		compsToExperiment.add(new JButton("Button 2"));
		compsToExperiment.add(new JButton("Button 3"));
		compsToExperiment.add(new JButton("Long-Named Button 4"));
		compsToExperiment.add(new JButton("5"));
		// Left to right component orientation is selected by default
		// 由左至右的排序被選為預設值
		compsToExperiment.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); // import java.awt.ComponentOrientation
		
		// Add controls to set up the component orientation in the experiment layout
		// 疑問: 1) ButtonGroup用法。 2) 為何要用final?
		final ButtonGroup group = new ButtonGroup();
		group.add(LtoRbutton);
		group.add(RtoLbutton);
		controls.add(LtoRbutton);
		controls.add(RtoLbutton);
		controls.add(applyButton);
		
		// Process the Apply component orientation button press
		// 處理套用按鈕按下去的元件排序
		// 整段看不大懂
		applyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String command = group.getSelection().getActionCommand();
				// Check the selection 檢查選擇
				
			}
			
			
		});
	}
	
	public static void main(String[] args) {
		
	}

}
