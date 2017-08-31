package javase.basic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Date utility class.
 * 
 * @author anil
 */
public class DateUtil {
	/**
	 * Returns date for Sunday of current week.
	 */
	public static Date getCurrentPeriodEndingDate() {
		// loop forward till we find SUNDAY
		GregorianCalendar gc = new GregorianCalendar();
		while (gc.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY)
			gc.add(GregorianCalendar.DATE, 1);

		return gc.getTime();
	}

	/**
	 * Returns date for Monday of current week
	 */
	public static Date getCurrentPeriodStartingDate() {
		// loop backward till we find MONDAY
		GregorianCalendar gc = new GregorianCalendar();
		while (gc.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.MONDAY)
			gc.add(GregorianCalendar.DATE, -1);
		return gc.getTime();
	}

	/**
	 * Returns date parameter with time components zeroed out
	 */
	public static Date getDateWithZeroTime(Date date) {
		Calendar modifiedDate = new GregorianCalendar();
		modifiedDate.setTime(date);
		modifiedDate.set(Calendar.HOUR_OF_DAY, 0);
		modifiedDate.set(Calendar.MINUTE, 0);
		modifiedDate.set(Calendar.SECOND, 0);
		modifiedDate.set(Calendar.MILLISECOND, 0);

		return modifiedDate.getTime();
	}

	/**
	 * Returns date parameter with time components set to maximum values for day
	 * (that is, 11:59:59.999)
	 */
	public static Date getDateWithMaxTime(Date date) {
		Calendar modifiedDate = new GregorianCalendar();
		modifiedDate.setTime(date);
		modifiedDate.set(Calendar.HOUR_OF_DAY, 23);
		modifiedDate.set(Calendar.MINUTE, 59);
		modifiedDate.set(Calendar.SECOND, 59);
		modifiedDate.set(Calendar.MILLISECOND, 999);

		return modifiedDate.getTime();
	}

	/**
	 * Determines if checkDate falls in current week (from current Monday till
	 * Sunday)
	 */
	public static boolean isInCurrentPayPeriod(Date checkDate) {
		Date weekStartDate = getDateWithZeroTime(getCurrentPeriodStartingDate());
		Date weekEndDate = getDateWithMaxTime(getCurrentPeriodEndingDate());

		return (!checkDate.before(weekStartDate) && !checkDate
				.after(weekEndDate));
	}

	/**
	 * formatNowDate
	 * 
	 * @return
	 */
	public static String formatDateString() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = formatter.format(currentTime);
		return strDate;
	}

	/**
	 * formateDateMinute
	 * 
	 * @return
	 */
	public static String formatDateMinuteString() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
		String strDate = formatter.format(currentTime);
		return strDate;
	}

	/**
	 * ��1��9��Ϊ01-09
	 * 
	 * @param i
	 * @return
	 */
	public static String formatTenNumber(int i) {
		if (i < 10)
			return "0" + String.valueOf(i);
		else
			return String.valueOf(i);
	}

	public static String numberChangeMonth(String numStr) {
		int num = Integer.parseInt(numStr);
		switch (num) {
		case 1:
			return "һ��";
		case 2:
			return "����";
		case 3:
			return "����";
		case 4:
			return "����";
		case 5:
			return "����";
		case 6:
			return "����";
		case 7:
			return "����";
		case 8:
			return "����";
		case 9:
			return "����";
		case 10:
			return "ʮ��";
		case 11:
			return "ʮһ��";
		case 12:
			return "ʮ����";
		}

		return null;

	}

	public static void main(String args[]) {
		String s = formatDateMinuteString();
		System.out.println("s=" + s);
	}

}
