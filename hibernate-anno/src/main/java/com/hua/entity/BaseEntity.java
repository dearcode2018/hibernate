/**
 * 描述: 
 * BaseEntity.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;



/**
 * 描述: 
 * 
 * @author qye.zheng
 * BaseEntity
 */
public abstract class BaseEntity {
	
	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}
	
}
