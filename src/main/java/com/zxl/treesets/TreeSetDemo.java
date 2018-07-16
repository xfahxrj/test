/**
 * 
 */
package com.zxl.treesets;

import org.springframework.stereotype.Component;

/**
 * @author 胥方雁
 * @data 2018年5月8日 上午9:28:58
 */
@Component
public class TreeSetDemo implements Comparable<TreeSetDemo> {
	private String name;
	private int age;

	public TreeSetDemo() {
		name = "未知";
	}
	
	public TreeSetDemo(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(TreeSetDemo o) {
		// 先按age排序
		if (this.age != o.getAge()) {
			return (this.age - o.getAge());
		}
		// 按name排序
		/*if (this.name.compareTo(o.getName()) > 0) {
			return 1;
		}
		if (this.name.compareTo(o.getName()) < 0) {
			return -1;
		}*/
		return this.name.compareTo(o.getName());
	}

	@Override
	public String toString() {
		return "{name:" + name + ", age:" + age + "}";
	}
	
}
