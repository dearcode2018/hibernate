/**
  * @filename MappingCompositeKey02.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.entity;

 /**
 * @type MappingCompositeKey02
 * @description  
 * @author qye.zheng
 */
public final class MappingCompositeKey02 {
	
	private CompositeKey key;
	
	private String address;

	/**
	 * @return the key
	 */
	public final CompositeKey getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public final void setKey(CompositeKey key) {
		this.key = key;
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
