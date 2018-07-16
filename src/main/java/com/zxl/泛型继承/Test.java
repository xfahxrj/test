/**
 * 
 */
package com.zxl.泛型继承;

import com.zxl.泛型继承.demo.PersonImpl;
import com.zxl.泛型继承.demo.PersonIntf;



/**
 * @author 胥方雁
 * @data 2018年5月17日 下午2:32:23
 */
public class Test {
	public static void main(String[] args) {
		EntityDao testDao = new EntityDao();
		System.out.println(testDao.getEntityClass());
		PersonIntf person = new PersonImpl();
		System.out.println(person.get());
		String str1 = null;
		System.out.println(str1);
		String str2 = "null";
		System.out.println(str2.equals(str1));
		str1+= "123";
		str2+= "123";
		System.out.println(str2.equals(str1));
		System.out.println((null+"123"));
	}
}
