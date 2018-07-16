/**
 * 
 */
package com.zxl.泛型继承;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author 胥方雁
 * @data 2018年5月17日 下午2:26:45
 */
public class BaseDaoImpl<T> implements BaseDaoIntf<T> {
	private Class<T> entityClass;  
	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDaoImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	@Override
	public T get() {
		try {
			return entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
