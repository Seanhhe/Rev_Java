package tw.org.iii.myreview;

import javax.swing.JOptionPane;

public class Rev004 {

	public static void main(String[] args) {
		String a1 = JOptionPane.showInputDialog("Input a number1 here");
		String a2 = JOptionPane.showInputDialog("Input a number2 here");
		System.out.println(a1 + "/" + a2 + " = ");
		
		int i1 = Integer.parseInt(a1);
		int i2 = Integer.parseInt(a2);
		int r3 = i1 / i2;
		int r4 = i1 % i2;
		System.out.println(a1 + "/" + a2 + " = " + r3 + "...." + r4);
	}

}
