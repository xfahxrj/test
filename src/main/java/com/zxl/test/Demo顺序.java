/**
 * 
 */
package com.zxl.test;

/**
 * @author 胥方雁
 * @data 2018年6月28日 上午10:22:32
 */
public class Demo顺序 {
	public static void main(String[] args) {
		int i= 0;
		System.out.println("A:"+i++);
		print();
		System.out.println("A:"+i++);
		System.out.println("A:"+i++);
		System.out.println("A:"+i++);
	}
	public static void print(){
		int i= 0;
		for (int j = 0; j < 10; j++) {
			System.out.println("B:"+i++);
		}
	}
}
