package tw.org.iii.myreview;

public class Rev011 {

	public static void main(String[] args) {
		
		byte a = 10, b = 100;
		final byte c = 100;
		
		final byte d;
		d = 123;
//		d = 11; // d已給final 不可再修改其值
		
		switch (a) {
		case 1:
			System.out.println("A");
			break;
		//default不一定要放最後, 若沒加break會繼續執行, 
		//通常放前面或中間並沒有加上break, 可能是為了配合後面的case運作
		default:
			System.out.println("除錯用的default");
//		case b: // case的值必須是常數值 -->編譯錯誤
//			System.out.println("B");
//			break;
		case c: // 這裡的c變數已被宣告為final
			System.out.println("C");
			break;
		case c-90: // 原因同上, 因為c已被宣告為final視為常數, 可加減, 結果值若錯誤仍不可編譯
			System.out.println("c-90");
//			break; //在switch區塊最後的break 可省略
//		case d: // 有宣告final 為何不行? --> 因為變數宣告時沒先給值, 後面給的 case 不能接受
//			System.out.println("D");
//			break;
//		case 1000: // case值已經超過byte範圍
//			System.out.println("E");
//			break;
		}
	}

}
