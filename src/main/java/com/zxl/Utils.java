/**
 * 
 */
package com.zxl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 胥方雁
 * @data 2018年6月19日 下午3:23:40
 */
public class Utils {
	 public final static int TYPE_DATE = 0;
	 public final static int TYPE_DATETIME = 1;
	/**
	 * 将yyyy-MM-dd,yyyy/MM/dd,yyyyMMdd格式字符串变为时间
	 * 
	 * @param dateString
	 * @return Date
	 */
	public static Date getDate(String dateString) {
		if (null == dateString) {
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
	 * 判断date或String是否为null,并得到date
	 * @param obj
	 * @return Date
	 */
	public static Date getDateByObject(Object obj,int dateType) {
		if (obj == null) {
			return null;
		}
		Date date = null;
		if (obj instanceof String) {
			date= (dateType == TYPE_DATE) ?getDate((String) obj):getDateTime((String) obj);
			if (null == date) {
				return null;
			}
		} else if (obj instanceof Date) {
			return (Date) obj;
		} else {
			return null;
		}
		return date;
	}
	/**
	 * 将yyyy-MM-dd HH:mm:ss,yyyy/MM/dd HH:mm:ss格式字符串变为时间
	 * 
	 * @param dateTimeString
	 * @return
	 */
	public static Date getDateTime(String dateTimeString) {
		if (null == dateTimeString) {
			return null;
		}
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(dateTimeString);
		} catch (ParseException e) {
			sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {
				date = sdf.parse(dateTimeString);
			} catch (ParseException e1) {
				System.out.println("格式错误");
				e1.printStackTrace();
			}
		}
		return date;
	}

	public static String getDateString(Object obj) {
		Date date = getDateByObject(obj,TYPE_DATETIME);
		if (null == date) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);	
	}
	public static String getDateTimeString(Object obj) {
		Date date = getDateByObject(obj,TYPE_DATETIME);
		if (null == date) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 改变一个日期的时分秒 为一天的最后一秒
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateStringToLate(Object obj) {
		Date date = getDateByObject(obj,TYPE_DATE);
		if (null == date) {
			return null;
		} 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * Calendar calendar = Calendar.getInstance(); calendar.setTime(date);
		 * calendar.set(Calendar.HOUR_OF_DAY,
		 * calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		 * calendar.set(Calendar.MINUTE,
		 * calendar.getActualMaximum(Calendar.MINUTE));
		 * calendar.set(Calendar.SECOND,
		 * calendar.getActualMaximum(Calendar.SECOND));
		 */
		return sdf.format(date) + " 23:59:59";
	}

	/**
	 * 改变一个日期的时分秒 为一天的最开始
	 * 
	 * @param date
	 * @return String
	 */
	public static String getDateStringToEarly(Object obj) {
		Date date = getDateByObject(obj,TYPE_DATE);
		if (null == date) {
			return null;
		} 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * Calendar calendar = Calendar.getInstance(); calendar.setTime(date);
		 * calendar.set(Calendar.HOUR_OF_DAY,
		 * calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		 * calendar.set(Calendar.MINUTE,
		 * calendar.getActualMinimum(Calendar.MINUTE));
		 * calendar.set(Calendar.SECOND,
		 * calendar.getActualMinimum(Calendar.SECOND)); return
		 * sdf.format(calendar.getTime());
		 */
		return sdf.format(date) + " 00:00:00";
	}

	/**
	 * 获取某一时间属于哪个季度
	 */
	@SuppressWarnings("static-access")
	public static Integer getQuarter(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(c.MONTH) + 1;
		int quarter = 0;
		if (month >= 1 && month <= 3) {
			quarter = 1;
		} else if (month >= 4 && month <= 6) {
			quarter = 2;
		} else if (month >= 7 && month <= 9) {
			quarter = 3;
		} else {
			quarter = 4;
		}
		return quarter;
	}

	/**
	 * 获取某一时间 属于季度的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfQuarter(Date date) {
		// 时间属于哪个季度
		Integer quarter = getQuarter(date);
		Date firstDay = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		switch (quarter) {
		case 1:
			calendar.set(Calendar.MONTH, Calendar.JANUARY);
			break;
		case 2:
			calendar.set(Calendar.MONTH, Calendar.APRIL);
			break;
		case 3:
			calendar.set(Calendar.MONTH, Calendar.JULY);
			break;
		case 4:
			calendar.set(Calendar.MONTH, Calendar.OCTOBER);
			break;
		}
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		firstDay = calendar.getTime();
		return firstDay;
	}

	/**
	 * 获取某一时间 属于季度的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfQuarter(Date date) {
		// 时间属于哪个季度
		Integer quarter = getQuarter(date);
		Date lastDay = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		switch (quarter) {
		case 1:
			calendar.set(Calendar.MONTH, Calendar.MARCH);
			break;
		case 2:
			calendar.set(Calendar.MONTH, Calendar.JUNE);
			break;
		case 3:
			calendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
			break;
		case 4:
			calendar.set(Calendar.MONTH, Calendar.DECEMBER);
			break;
		}
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		lastDay = calendar.getTime();
		return lastDay;
	}
}
