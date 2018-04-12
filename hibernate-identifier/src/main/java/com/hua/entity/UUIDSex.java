/**
  * @filename UUIDSex.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.entity;

 /**
 * @type UUIDSex
 * @description  increment 标识符生成器
 * @author qye.zheng
 */
public final class UUIDSex {

	private String id;
	
	private String name;

	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}
	
}
