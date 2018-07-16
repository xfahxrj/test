/**
 * 
 */
package com.zxl.treesets;

import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 胥方雁
 * @data 2018年5月8日 上午9:33:05
 */
@Component
public class SetTest {
	@Autowired
	private  TreeSetDemo treeSetDemo;
	public static void main(String[] args) {
		TreeSet<TreeSetDemo> set = new TreeSet<>();
		set.add(new TreeSetDemo("张三",13));
		set.add(new TreeSetDemo("李四",12));
		set.add(new TreeSetDemo("王五",20));
		set.add(new TreeSetDemo("赵六",12));
		set.add(new TreeSetDemo("张三",12));
		System.out.println(set.toString());
	}
	public  void print(){
		System.out.println(treeSetDemo.getName());
		//throw new Exception("123");
		throw new IllegalArgumentException("name参数的长度必须大于3，小于10！");  
	}
}
