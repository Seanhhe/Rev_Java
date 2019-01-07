package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *	二維陣列練習_發牌&理牌
 *	將一副52張的撲克牌洗牌後發給四位玩家
 *	四個玩家-->各自有13張牌(二維陣列)
 *	一副牌-->52張牌(一維陣列)
 *
 *	設計想法:
 *
 *	試用do while迴圈
 *	(測試: do while迴圈與 for迴圈概念是否類似?)
 *	(哪些事情是每次必須要做的?	ex: 亂數, 檢查重複)
 */

public class Rev020_Poker_v2 {

	public static void main(String[] args) {
		// 撲克牌的陣列
		int[] cards = new int[52];
		
		// 產生亂數依序放入陣列中
		for (int i = 0; i < cards.length; i++) {
			int temp;
			boolean isRepeat;
			
			// 產生亂數
			do {
				isRepeat = false;
				temp = (int)(Math.random()*cards.length);
				
				// 檢查機制
				for(int j = 0; j < i; j++) {
					if (cards[j] == temp) {		// 發現重複
						isRepeat = true;
						break;
					}
				}
				
			}while(isRepeat);
			cards[i] = temp;
			System.out.println(cards[i]);
			
		}
	}

}
