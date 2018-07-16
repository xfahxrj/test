/**
 * 
 */
package com.zxl.treesets;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author 胥方雁
 * @data 2018年5月8日 下午2:20:15
 */
@Component
public class TestSpring {
	static ApplicationContext context;
	static{
		 context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	

	public static void main(String[] args) {
		SetTest setTest = (SetTest) context.getBean("setTest");
		
		setTest.print();
		//TreeSetDemo demo = (TreeSetDemo) context.getBean("treeSetDemo");
		//System.out.println(demo.getName());
		
	}
	

}
