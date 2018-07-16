package com.zxl.test;

import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 * 
 */
public class App {
	protected final static Logger log = LoggerFactory.getLogger(App.class);
	private String name = "";

	public static void main(String[] args) throws InterruptedException {
		/*
		 * System.out.println( "Hello World!" ); System.out.println(
		 * StringUtils.isBlank("123"));
		 * System.out.println(StringUtils.isNumeric("-0132")); Pattern pattern =
		 * Pattern.compile("^[\\+]?[\\d]*$");
		 * System.out.println(pattern.matcher("+0123").matches());
		 * 
		 * System.out.println(NumberUtils.isNumber("2.34f"));
		 * System.out.println(123); App app = new App();
		 * app.setName("ZhangSan");
		 */
		int messageSize = 1000000;
		int threadSize = 50;
		final int everySize = messageSize / threadSize;

		final CountDownLatch cdl = new CountDownLatch(threadSize);
		long startTime = System.currentTimeMillis();
		for (int ts = 0; ts < threadSize; ts++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int es = 0; es < everySize; es++) {
						log.info("======info");
					}
					cdl.countDown();
				}
			}).start();
		}

		cdl.await();
		long endTime = System.currentTimeMillis();
		System.out.println("log4j1:messageSize = " + messageSize + ",threadSize = " + threadSize + ",costTime = " + (endTime - startTime) + "ms");
			
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
