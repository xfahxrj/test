/**
 * 
 */
package com.zxl.treesets;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 胥方雁
 * @data 2018年5月9日 下午2:27:30
 */
@Component
@Aspect
public class LogAspect {
	 private Logger logger=LoggerFactory.getLogger(LogAspect.class);  
	//所有实例方法调用截获
	private static final String INSTANCE_METHOD_CALL = "execution(* com.zxl..*.*(..))";
	@Pointcut(INSTANCE_METHOD_CALL) 
	public void instanceMethodCall() {
	}

	//实例方法调用前后Advice
	@Before("instanceMethodCall()") 
	public void beforInstanceCall(JoinPoint joinPoint) {
		System.out.println("@Before");
	}

	@After("instanceMethodCall()") 
	public void afterInstanceCall() {
		System.out.println("@After");
	}
	/** 
     * 异常通知 用于拦截记录异常日志 
     * 
     * @param joinPoint 
     * @param e 
     */  
     @AfterThrowing(pointcut = "instanceMethodCall()", throwing="e")  
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {  
       e.printStackTrace();
       
    }  
}
