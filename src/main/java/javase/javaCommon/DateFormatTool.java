package javase.javaCommon;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期工具类
 * pattern格式：	yyyy-MM-dd HH:mm:ss.SSS
 * @since 2011-12-8
 */
public class DateFormatTool {

	/**
	 * 格式化工具集合
	 */
	private static final Map<String, DateFormat> formatMap = new HashMap<String, DateFormat>();
	
	/**
	 * 格式化表达式
	 */
	private static DateFormat getFormat(String pattern){
		DateFormat format = formatMap.get(pattern);
		if(format == null){
			format = new SimpleDateFormat(pattern);
			formatMap.put(pattern, format);
		}
		return format;
	}
	
	/**
	 * 格式化日期	Date -> String
	 */
	public static String format(Date date, String pattern){
		return getFormat(pattern).format(date);
	}
	
	/**
	 * 解析日期	String -> Date
	 */
	public static Date parse(String date, String pattern) throws ParseException {
		return getFormat(pattern).parse(date);
	}
	
	/**
	 * 增减年, 月, 日
	 * 年月日不需要增减的传零值; 	增:传递正数;	减:传递负数
	 */
	public static Date changeDate(Date date, int year, int month, int day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, year);
		calendar.add(Calendar.MONTH, month);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}
	
	/**
	 * 获得月初、月末、周初、周末
	 */
	public static Date getSpecialDay(Date date, String week_month, String first_last) {
		Calendar calendar = Calendar.getInstance();
		//周初
		if("WEEK".equals(week_month) && "FIRST".equals(first_last)){
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			return calendar.getTime();
		}
		//周末
		if("WEEK".equals(week_month) && "LAST".equals(first_last)){
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);	
			calendar.add(Calendar.DAY_OF_MONTH, 6);
			return calendar.getTime();
		}
		//月初
		if("MONTH".equals(week_month) && "FIRST".equals(first_last)){
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			return calendar.getTime();
		}
		//月末
		if("MONTH".equals(week_month) && "LAST".equals(first_last)){
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_MONTH, 1);	
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			return calendar.getTime();
		}
		return null;
	}
	
	/**
	 * 测试
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(parse("2011-09-08 00:00:00", "yyyy-MM-dd HH:mm:ss").toString());
		System.out.println(format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		System.out.println("增减年, 月, 日 : " + format(changeDate(new Date(), -1,0,-2),"yyyy-MM-dd HH:mm:ss"));
		System.out.println("获得周初  " + format(getSpecialDay(new Date(),"WEEK","FIRST"),"yyyy-MM-dd"));
		System.out.println("获得周末  " + format(getSpecialDay(new Date(),"WEEK","LAST"),"yyyy-MM-dd"));
		System.out.println("获得月初  " + format(getSpecialDay(new Date(),"MONTH","FIRST"),"yyyy-MM-dd"));
		System.out.println("获得月末  " + format(getSpecialDay(new Date(),"MONTH","LAST"),"yyyy-MM-dd"));
	}
}








