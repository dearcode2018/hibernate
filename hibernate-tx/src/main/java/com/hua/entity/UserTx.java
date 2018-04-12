/**
  * @filename UserTx.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.entity;

import java.util.Date;

 /**
 * @type UserTx
 * @description  
 * @author qye.zheng
 */
public final class UserTx extends BaseEntity {

	private String name;
	
	private Date birthday;
	
	private Integer version;

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

	/**
	 * @return the birthday
	 */
	public final Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public final void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the version
	 */
	public final Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public final void setVersion(Integer version) {
		this.version = version;
	}
	
	
}
