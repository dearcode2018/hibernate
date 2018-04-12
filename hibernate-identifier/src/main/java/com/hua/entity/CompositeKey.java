/**
  * @filename CompositeKey.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.entity;

import java.io.Serializable;

 /**
 * @type CompositeKey
 * @description  
 * @author qye.zheng
 */
//必须要序列化
public final class CompositeKey implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String companyId;

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
	 * @return the companyId
	 */
	public final String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public final void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
}
