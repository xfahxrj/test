/**
 * 
 */
package com.zxl.线程;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 胥方雁
 * @data 2018年6月29日 下午3:33:23
 */
public class Test1 extends Thread {
	private static volatile AtomicInteger t= new AtomicInteger(0);
	private static  int[] arr = new int[20000];
	   private static int add(){
		   arr[t.get()]=t.get();
	        return t.getAndIncrement();
	    }

	    public static void testVolatile(){
	        for (int i=0;i<20;i++){
	            new Test1().start();
	        }
	        while (Thread.activeCount()>1){
	            Thread.yield();
	        }
	        System.err.println(t);
	        int j = 0 ;
	        for (int  i= 15000; i <19999; i++,j++) {
	        	System.err.print(arr[i]+"  ");
	        	if (j == 1000) {
					System.out.println();
					j = 0;
				}
			}
	    }

	    public static void main(String[] args){
	        testVolatile();
	    }

		@Override
		public void run() {
			 for (int j=0;j<1000;j++) {
                 add();
             }
		}

}
