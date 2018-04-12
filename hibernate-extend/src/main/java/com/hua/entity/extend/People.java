/**
  * @filename People.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.entity.extend;

import com.hua.entity.BaseEntity;

 /**
 * @type People
 * @description 
 * @author qye.zheng
 */
public class People extends BaseEntity {

	private String name;
	
	private String sex;
	
	private Integer age;

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
	 * @return the sex
	 */
	public final String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public final void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the age
	 */
	public final Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public final void setAge(Integer age) {
		this.age = age;
	}
	
}
