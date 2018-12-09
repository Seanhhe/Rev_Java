package tw.org.iii.myreview;

import javax.swing.JOptionPane;

/**
 * 
 * @author SEAN
 * 
 * 判斷閏年
 * 	用if else判斷, 計算年份是否為閏年
 * >>閏年條件
 * 	01.西元年份除以4可以整除, 但除以100不可以整除
 * 	02.西元年份除以400可以整除, 但除以3200不可以整除
 * >>平年條件
 * 	01.西元年份除以4, 不可以整除
 * 	02.西元年份除以100可以整除, 但除以400不可以整除
 */

public class Rev008 {

	public static void main(String[] args) {
		String acYear = JOptionPane.showInputDialog("請輸入西元年份 :");
		int yearInt = Integer.parseInt(acYear);
		
//		if (yearInt % 4 == 0) {
//			if (yearInt % 100 == 0) {
//				if (yearInt % 400 == 0) {
//					System.out.println("閏年");
//				}else {
//					System.out.println("平年");
//				}
//			}else {
//				System.out.println("閏年");
//			}
//		}else {
//			System.out.println("平年");
//		}
		
		//上述寫法不易判斷
		
		//有一行的if寫法
		//敘述句短但要注意可維護性
		
		if ((yearInt % 4 == 0 & yearInt % 100 !=0) || (yearInt % 400 == 0 & yearInt % 3200 !=0) ){
			System.out.println("閏年");
		}else {
			System.out.println("平年");
		}
	}
	
	

}
