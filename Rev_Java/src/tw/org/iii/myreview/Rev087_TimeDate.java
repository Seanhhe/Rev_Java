package tw.org.iii.myreview;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*		20180825PM2 Brad85 00:22:30
 * 		日期時間
 * 
 * 		java.util.Date <官方不建議繼續使用>
 * 		java.util.Calendar <建議用這個>
 * 
 * 		
 * 		文字處理API => java.text
 * 		=> 數字格式 > NumberFormat
 * 		=> 日期時間格式 > SimpleDateFormat
 * 		=> 訊息 > MessageFormat
 * 		=> 日期時間格式 > DateFormat
 * 
 * 		小結論 => 盡量使用 Calendar 顯示問題再轉換就好
 * 
 * 		補充：Model View Controller (MVC)
 */

public class Rev087_TimeDate {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("java.util.Date : " + date);
		
		// Calendar 建構式  protected 不是相同 package 不能用
		// getInstance()
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar); // 不易閱讀
		
		// 格式
		// java.text.DateFormat
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println("DateFormat : " + df.format(date));
		
		// java.text.SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		System.out.println(sdf.format(date));
		
		// Calendar 怎麼格式化？ => 互相轉換
		// format方法需要先有 Date 物件實體
		// 運用getTime方法  (Return a Date object representing this Calendar's time value)
		System.out.println(sdf.format(calendar.getTime()));
		
		//		繼續嘗試Calendar
		
		int year = calendar.get(Calendar.YEAR); // 傳回的是int
		int month = calendar.get(Calendar.MONTH); // 國情不同，一月的值是0，回傳的值要加1
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + " / " + (month+1) + " / " + day);
		
//		calendar.add(Calendar.DATE, 14); // 加14天
		calendar.add(Calendar.WEEK_OF_YEAR, 2); // 加2周
		System.out.println(sdf.format(calendar.getTime()));
		
		calendar.add(Calendar.WEEK_OF_MONTH, -2); // 減2周
		System.out.println(sdf.format(calendar.getTime()));
	}

}
