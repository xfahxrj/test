/**
 * 
 */
package com.zxl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 胥方雁
 * @data 2018年5月17日 上午10:53:57
 */
public class TestDate {
	public static String getLastMomentByTheDay(String time){
		String newDateString = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			newDateString = sdf.format(sdf.parse(time))+" 23:59:59";
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("时间转换出错");
			
		}
		return newDateString;
	}
	public static void main(String[] args)  {
		System.out.println(getLastMomentByTheDay("2018-05-17"));
		String string = "123";
		string += null;
		string += "123";
		System.out.println(string);
		StringBuilder param = new StringBuilder();
		String isnull = null;
		param.append(isnull);
		System.out.println(param.length());
		String str = "123";
		System.out.println(str.substring(0, str.length()-1));
		System.out.println("".hashCode());
		String kon = "";
		System.out.println(kon != "");
		System.out.println("".equals(kon));
		String  dataTimeString = "2018/06/21 09:01:01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = sdf.parse(dataTimeString);
			date = sdf2.parse(dataTimeString);
			date = sdf3.parse(dataTimeString);
		} catch (ParseException e) {
		}
		System.out.println(date);
	}
}
