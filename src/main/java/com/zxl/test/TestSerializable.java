
/**
 * 
 */
package com.zxl.test;

import java.io.Serializable;

/**
 * @author 胥方雁
 * @data 2018年7月9日 上午11:17:50
 */
public class TestSerializable implements Serializable{

	private static final long serialVersionUID = 1L;
	private  Integer id = 1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static void main(String[] args) {
		TestSerializable test = new TestSerializable();
		test.print(12);
		System.out.println(test.getId());
	}
	public void print(Serializable id){
		this.id = (Integer) id;
	}
}
