/**
 * 
 */
package com.zxl.fastjson;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author 胥方雁
 * @data 2018年5月10日 上午8:57:37
 */
public class FastJson {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd"));
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		String jsondate = JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat);
		System.out.println(jsondate);
		System.out.println(jsondate.equals("2018-05-10"));
		User user = new User("小明", 23, new Date());
		String userString = JSON.toJSONString(user, SerializerFeature.WriteDateUseDateFormat);
		
		
	}
}
