/**
 * 
 */
package com.zxl.观察者模式;

/**
 * @author 胥方雁
 * @data 2018年5月7日 下午4:20:36
 */
public class User implements Observer{
	private String name;
    private String message;
    
    public User(String name) {
        this.name = name;
    }
    
	@Override
	public void update(String message) {
		 this.message = message;
	     read();
	}
	public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
