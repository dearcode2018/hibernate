/**
  * @filename Teacher.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.entity.extend;

 /**
 * @type Teacher
 * @description 
 * @author qye.zheng
 */
public final class Teacher extends People {

	/* 教师编号 */
	private String tNo;
	
	/* 学校 */
	private String school;

	/**
	 * @return the tNo
	 */
	public final String gettNo() {
		return tNo;
	}

	/**
	 * @param tNo the tNo to set
	 */
	public final void settNo(String tNo) {
		this.tNo = tNo;
	}

	/**
	 * @return the school
	 */
	public final String getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public final void setSchool(String school) {
		this.school = school;
	}
	
}
