/**
 * 
 */
package com.zxl.test;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.zxl.Utils;

/**
 * @author 胥方雁
 * @data 2018年6月19日 下午3:31:43
 */
public class UtilsTest {
	public static void main(String[] args) {
		System.out.println(Utils.getDateStringToEarly("2018-5-6"));
		System.out.println(Utils.getDateStringToLate(new Date()));
		System.out.println(Utils.getDateTimeString(new Date()));
		System.out.println(Utils.getDateTimeString(null));
		String str = "-000123";
		System.out.println((str==null?"":str)+"123");
		System.out.println(NumberUtils.isCreatable("-123"));
		System.out.println(Integer.parseInt(str));
	}
	
}
