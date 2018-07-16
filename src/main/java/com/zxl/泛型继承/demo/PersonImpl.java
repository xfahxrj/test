/**
 * 
 */
package com.zxl.泛型继承.demo;

import com.zxl.泛型继承.BaseDaoImpl;

/**
 * @author 胥方雁
 * @data 2018年5月17日 下午2:46:41
 */
public class PersonImpl extends BaseDaoImpl<Person> implements PersonIntf  {



	@Override
	public void print() {
		
		System.out.println("进入");

	}

}
