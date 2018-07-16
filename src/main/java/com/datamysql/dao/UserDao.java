/**
 * 
 */
package com.datamysql.dao;

import java.util.Map;

/**
 * @author 胥方雁
 * @data 2018年6月6日 上午11:06:33
 */
public interface UserDao {
	Integer saveUser(Map<String, String> map);
}
