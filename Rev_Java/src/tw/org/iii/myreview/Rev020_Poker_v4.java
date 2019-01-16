package tw.org.iii.myreview;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 
 * @author SEAN
 *	
 *	二維陣列練習_發牌&洗牌
 *	寫出一個程式, 將一副52張的撲克牌洗牌後發給四位玩家
 *	四個玩家 --> 各自有13張牌 (二維陣列)
 *	一副牌-->52張牌 (一維陣列)
 * 
 * 	version4: 使用shuffle API
 */

public class Rev020_Poker_v4 {

	public static void main(String[] args) {
		LinkedList<Integer> poker = new LinkedList<>();
		for (int i = 0; i < 52; i++) {
			poker.add(i);
		}
		Collections.shuffle(poker);
		
		for (Integer i:poker) {
			System.out.println(i);
		}
	}

}
