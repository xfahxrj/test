/**
 * 
 */
package com.zxl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.zxl.Utils;


/**
 * @author 胥方雁
 * @data 2018年6月19日 上午11:10:13
 */
public class SystemPrintFormat {
	public static void main(String[] args) {
		String name = "是打发", sex = "男", age = 1 + "", address = "湖北";
		int id = 11;
		System.out.printf(Locale.SIMPLIFIED_CHINESE, "%1$-2s %2$-10s %3$-8s %4$-8s %5$-8s\n", id, name, sex, age, address);
		System.out.printf(Locale.SIMPLIFIED_CHINESE, "%1$-2s %2$-10s %3$-8s %4$-8s %5$-8s\n", 12, "输电", "男", 1, "武汉");
		/*long time = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			String.format("%1$tF", new Date());
		}
		System.out.println((System.currentTimeMillis() - time) / 1000.0);
		time = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < 1000; i++) {
			sdf.format(new Date());
		}
		System.out.println((System.currentTimeMillis() - time) / 1000.0);
		time = System.currentTimeMillis();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for (int i = 0; i < 1000; i++) {
			LocalDate.now().format(df);
		}
		System.out.println((System.currentTimeMillis() - time) / 1000.0);*/
		System.out.println(getDateByString("2018-5-6"));
		System.out.println(getDateByString("2018/5/6"));
		System.out.println(getDateByString("20180506"));
		//System.out.println(getDateString("201856"));
		System.out.println(getDateStringByDate(changeToLate(getDateByString("2018-5-6"))));
		System.out.println(getDateStringToLate2(new Date()));
		System.out.println(Utils.getDateStringToEarly("2018-5-6"));
		long time = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			Utils.getDateStringToEarly("2018-5-6");
		}
		System.out.println((System.currentTimeMillis() - time) / 1000.0);
		time = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			Utils.getDateStringToEarly("2018-5-6");
		}
		System.out.println((System.currentTimeMillis() - time) / 1000.0);
	}
	/**
	 * 
	 * @param dateString
	 * @return Date
	 */
	public static Date getDateByString(String dateString) {
		if(null  == dateString){
			return null;
		}
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			sdf = new SimpleDateFormat("yyyy/MM/dd");
			try {
				date = sdf.parse(dateString);
			} catch (ParseException e1) {
				sdf = new SimpleDateFormat("yyyyMMdd");
				try {
					date = sdf.parse(dateString);
				} catch (ParseException e2) {
					System.out.println("格式错误");
					e2.printStackTrace();
				}
			}
		}
		return date;
	}
	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateStringByDate(Date date) {
		if(null == date){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	/**
	 * 改变一个日期的时分秒 为一天的最后一秒
	 * @param date
	 * @return
	 */
	public static String getDateStringToLate2(Object obj) {
		if(obj == null){
			return null;
		}
		Date date = null;
		if(obj instanceof String){
			date =getDateByString((String)obj);
		}else if (obj instanceof Date) {
			date = (Date) obj;
		}else {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		return sdf.format(calendar.getTime());
	}
	/**
	 * 改变一个日期的时分秒 为一天的最后一秒
	 * @param date
	 * @return
	 */
	public static Date changeToLate(Date date) {
		if(date == null){
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		return calendar.getTime();
	}

	/**
	 * 改变一个日期的时分秒 为一天的最开始
	 * @param date
	 * @return
	 */
	public static Date changeToEarly(Date date) {
		if(date == null){
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		return calendar.getTime();
	}
}
