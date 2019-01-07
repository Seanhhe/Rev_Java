package tw.org.iii.myreview;

/**
 * 
 * @author SEAN
 *
 *	二維陣列練習_發牌&洗牌	
 *	寫出一個程式, 將一副52張的撲克牌洗牌後發給四位玩家
 *	四個玩家 --> 各自有13張牌 (二維陣列)
 *	一副牌 --> 52張 (一維陣列)
 *
 *	version3: 運用洗牌演算法(交換原理)
 *	亂數選取某一張牌, 將其與最後一張牌交換, 最後一張牌就算洗完不動, 接著再重新選一張牌繼續換牌
 *	
 *	先產生一組順序由小到大的牌
 *	開始進行交換
 *	用產生亂數為隨機index值, 選到後和當下的最後一張交換
 *	交換前要確認有沒有重複嗎? 不用, 因為是一個陣列內的交換,而非兩個陣列
 *	怎麼交換? --> A->B->C->A 要有中間人, 因為值的指定是複製
 *	交換完後再依序印出 (這裡可以使用for each)
 */

public class Rev020_Poker_v3 {

	public static void main(String[] args) {
		// 產生新的撲克牌陣列
		int[] newCards = new int[52];
		for (int i = 0; i < newCards.length; i++) {
			newCards[i] = i;
			System.out.println(i + ";");
		}
		
		System.out.println();
		System.out.println("------分隔線------");
		
		// 交換牌
		for (int n = newCards.length-1; n >= 0; n--) {
			int middleMan;	// 暫存被選到的牌的值
			int tempIndex = (int)(Math.random()*newCards.length);
			// 交換
			middleMan = newCards[tempIndex];
			newCards[tempIndex] = newCards[n];
			newCards[n] = middleMan;
		}
		
		//印出
		for (int finalCard: newCards) {
			System.out.println(finalCard + ",");
		}
	}

}
