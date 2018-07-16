/**
 * 
 */
package com.zxl.观察者模式;

/**
 *  抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 * @author 胥方雁
 * @data 2018年5月7日 下午4:16:39
 */
public interface Observerable {
	 	public void registerObserver(Observer o);
	    public void removeObserver(Observer o);
	    public void notifyObserver();
}
