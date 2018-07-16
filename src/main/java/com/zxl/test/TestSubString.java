/**
 * 
 */
package com.zxl.test;

/**
 * @author 胥方雁
 * @data 2018年7月12日 下午2:20:41
 */
public class TestSubString {
	public static void main(String[] args) {
		String subDistrict = "积玉桥街办事处";
		String address = "湖北省武汉市武昌区积玉桥街办事处静安路";
		System.out.println(address.substring(address.lastIndexOf(subDistrict)+subDistrict.length(),address.length()));
	}
}
