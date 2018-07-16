/**
 * 
 */
package com.zxl.泛型继承.demo;

import com.zxl.泛型继承.BaseDaoIntf;

/**
 * @author 胥方雁
 * @data 2018年5月17日 下午2:44:53
 */
public interface PersonIntf extends BaseDaoIntf<Person>{
	void print();
}
