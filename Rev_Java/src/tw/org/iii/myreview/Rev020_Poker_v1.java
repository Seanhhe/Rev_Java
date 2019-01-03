package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *
 *		二維陣列練習_發牌&洗牌
 *		寫出一個程式, 將一副52張的撲克牌洗牌後發給玩家
 *		四個玩家-->各有13張牌 (二維陣列)
 *		一副牌 --> 52張 (一維陣列)
 *
 *		設計想法:
 *		01.建立牌的陣列
 *		02.產生亂數依序放入牌的陣列中
 *		03.發現陣列中的亂數值會重複
 *		04.建立檢查機制-->亂數若有重複就退回, 並重新產生亂數 (boolean?)
 *		05.印出洗牌好的數值
 */

public class Rev020_Poker_v1 {

	public static void main(String[] args) {
		
		// 撲克牌的陣列
		int[] cards = new int[52];
		
		// 產生亂數依序放入陣列中
		for (int i = 0; i < 52; i++) {
			int temp = (int)(Math.random()*52);	// 產生亂數
			
			// 檢查是否重複
			boolean isRepeat = false;
			for (int j = 0; j < i; j++) {
				if (cards[j] == temp) {	//依序比對已在陣列內的值是否重複
					isRepeat = true;
					//System.out.println("sean: 重複" + "cards[" + i + "] =" + cards[i]);
					break;
				}
			}
			// 
			if (isRepeat) {
				i--;	// 退回上一步, 讓temp重新出亂數
			}else {
				cards[i] = temp;	// 把無重複的亂數放入陣列中
				System.out.println("cards[" + i + "] = " + cards[i]);
			}
		}
		
	}

}
