/**
  * @filename Worker.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.entity.extend;

 /**
 * @type Worker
 * @description 
 * @author qye.zheng
 */
public final class Worker extends People {

	/* 工人编号 */
	private String wNo;
	
	/* 薪资 */
	private Double salary;

	/**
	 * @return the wNo
	 */
	public final String getwNo() {
		return wNo;
	}

	/**
	 * @param wNo the wNo to set
	 */
	public final void setwNo(String wNo) {
		this.wNo = wNo;
	}

	/**
	 * @return the salary
	 */
	public final Double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public final void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
