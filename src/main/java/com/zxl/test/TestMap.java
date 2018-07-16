/**
 * 
 */
package com.zxl.test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @author 胥方雁
 * @data 2018年6月26日 下午2:23:48
 */
public class TestMap {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		Map map = new HashMap();
		int i =1;
		for (int j = 0; j < 100; j++) {
			map.put(i, i++);
		}
		long time = System.currentTimeMillis();
		Iterator iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			Object key=iterator.next();  
			if (((int)key)>10) {
				//map.remove(key);
				iterator.remove();
			}
			Object value=map.get(key);
			//System.out.println(value);
		}
		System.out.println((System.currentTimeMillis()-time)/1000.0);
		time = System.currentTimeMillis();
		for (Object key : map.keySet()) { 
			Object value=map.get(key);
			System.out.println(value);
		} 
		System.out.println((System.currentTimeMillis()-time)/1000.0);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss.SSS");
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime.format(formatter));
		System.out.println(localDateTime);
		System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
		Instant instant = Instant.now();
		System.out.println(instant.getNano());
		formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String formattedDate = formatter.format(LocalDateTime.now());
		System.out.println(formattedDate);
	}
}
