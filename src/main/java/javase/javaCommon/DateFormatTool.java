package javase.javaCommon;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ���ڹ�����
 * pattern��ʽ��	yyyy-MM-dd HH:mm:ss.SSS
 * @since 2011-12-8
 */
public class DateFormatTool {

	/**
	 * ��ʽ�����߼���
	 */
	private static final Map<String, DateFormat> formatMap = new HashMap<String, DateFormat>();
	
	/**
	 * ��ʽ�����ʽ
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
	 * ��ʽ������	Date -> String
	 */
	public static String format(Date date, String pattern){
		return getFormat(pattern).format(date);
	}
	
	/**
	 * ��������	String -> Date
	 */
	public static Date parse(String date, String pattern) throws ParseException {
		return getFormat(pattern).parse(date);
	}
	
	/**
	 * ������, ��, ��
	 * �����ղ���Ҫ�����Ĵ���ֵ; 	��:��������;	��:���ݸ���
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
	 * ����³�����ĩ���ܳ�����ĩ
	 */
	public static Date getSpecialDay(Date date, String week_month, String first_last) {
		Calendar calendar = Calendar.getInstance();
		//�ܳ�
		if("WEEK".equals(week_month) && "FIRST".equals(first_last)){
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			return calendar.getTime();
		}
		//��ĩ
		if("WEEK".equals(week_month) && "LAST".equals(first_last)){
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);	
			calendar.add(Calendar.DAY_OF_MONTH, 6);
			return calendar.getTime();
		}
		//�³�
		if("MONTH".equals(week_month) && "FIRST".equals(first_last)){
			calendar.setTime(date);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			return calendar.getTime();
		}
		//��ĩ
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
	 * ����
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(parse("2011-09-08 00:00:00", "yyyy-MM-dd HH:mm:ss").toString());
		System.out.println(format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		System.out.println("������, ��, �� : " + format(changeDate(new Date(), -1,0,-2),"yyyy-MM-dd HH:mm:ss"));
		System.out.println("����ܳ�  " + format(getSpecialDay(new Date(),"WEEK","FIRST"),"yyyy-MM-dd"));
		System.out.println("�����ĩ  " + format(getSpecialDay(new Date(),"WEEK","LAST"),"yyyy-MM-dd"));
		System.out.println("����³�  " + format(getSpecialDay(new Date(),"MONTH","FIRST"),"yyyy-MM-dd"));
		System.out.println("�����ĩ  " + format(getSpecialDay(new Date(),"MONTH","LAST"),"yyyy-MM-dd"));
	}
}








