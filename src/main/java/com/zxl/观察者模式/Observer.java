/**
 * 
 */
package com.zxl.观察者模式;

/**
 *  抽象观察者
 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 * @author 胥方雁
 * @data 2018年5月7日 下午4:17:34
 */
public interface Observer {
	public void update(String message);
}
