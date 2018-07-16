/**
 * 
 */
package com.zxl.观察者模式;

import org.aspectj.lang.annotation.Aspect;

/**
 * @author 胥方雁
 * @data 2018年5月7日 下午4:21:44
 */

public class Test {
	public static void main(String[] args) {
		WechatServer server = new WechatServer();

		Observer userZhang = new User("ZhangSan");
		Observer userLi = new User("LiSi");
		Observer userWang = new User("WangWu");

		server.registerObserver(userZhang);
		server.registerObserver(userLi);
		server.registerObserver(userWang);
		server.setInfomation("PHP是世界上最好用的语言！");

		System.out.println("----------------------------------------------");
		server.removeObserver(userZhang);
		server.setInfomation("JAVA是世界上最好用的语言！");
		
	}
}
