/**
 * 
 */
package com.zxl.exl导出;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.ui.Model;

/**
 * @author 胥方雁
 * @data 2018年6月5日 下午2:04:26
 */
public class Childs extends Parent{
	private int age = 1;
	public Childs(){
		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static void main(String[] args) {
		List<Field> fieldList = new ArrayList<>() ;
		List<String> fieldNameList = new ArrayList<>() ;
		Class<?> tempClass = Childs.class;
		while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
		      fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
		      tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
		}
		for (Field f : fieldList) {
		    fieldNameList.add(f.getName());
		}
		try {
			System.out.println(Childs.class.getMethod("getAge").invoke(new Childs()));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
	}
}
