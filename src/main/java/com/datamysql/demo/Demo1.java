/**
 * 
 */
package com.datamysql.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.datamysql.dao.UserDao;

/**
 * @author 胥方雁
 * @data 2018年6月6日 上午11:08:12
 */
public class Demo1 {
	public static void main(String[] args) {
		ApplicationContext ct=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ct.getBean("userDao");
		Map map = new HashMap<String, Object>();
		map.put("id", (Integer)1);
		map.put("name", "zhangsan");
		userDao.saveUser(map);
		
	}
}
