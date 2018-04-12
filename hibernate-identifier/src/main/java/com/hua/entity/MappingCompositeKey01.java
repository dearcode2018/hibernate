/**
  * @filename MappingCompositeKey01.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.entity;

import java.io.Serializable;

 /**
 * @type MappingCompositeKey01
 * @description  
 * @author qye.zheng
 */
// 必须要序列化
public final class MappingCompositeKey01 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String companyId;
	
	private String address;

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

	/**
	 * @return the address
	 */
	public final String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public final void setAddress(String address) {
		this.address = address;
	}
	
}
