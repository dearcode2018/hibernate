/**
 * 描述: 
 * Item.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.entity.m2o;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hua.entity.BaseEntity;

/**
 * 描述: 订单
 * @author qye.zheng
 * 
 * Item
 */
@Entity
@Table(name = "item")
public class Item extends BaseEntity
{

	/**
	 * 一个客户可以拥有多个订单，一个订单只属于一个客户
	 */
	
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", insertable = true, 
			updatable = false, length = 64, 
			nullable = false, unique = true)
	@Id
	/* 对象唯一id */
	private String id;
	
	@Column(name = "name", insertable = true, 
			updatable = true, length = 128, 
			nullable = true, unique = false)
	/* 定单名称 */
	private String name;
	
	@Column(name = "orderTs", insertable = true, 
			updatable = true, nullable = true, unique = false)
	/* 下单时间戳 yyyy-MM-dd HH:mm:ss */
	private Date orderTs;
	
	@Column(name = "monetary", insertable = true, 
			updatable = true, precision = 2,
			nullable = true, unique = false)
	/* 消费金额 */
	private Double monetary;

	@Column(name = "remark", insertable = true, 
			updatable = true, length = 128, 
			nullable = true, unique = false)
	/* 备注 */
	private String remark;
	
	@JoinColumn(name ="customId", insertable = true, 
			updatable = true, nullable = true, unique = true)
	@ManyToOne
	// many to one
	/* 订单所属的客户 */
	private Custom custom;

	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	public Item()
	{
		name = "未知消费订单";
		orderTs = new Date();
	}
	
	public Item(String name)
	{
		super();
		this.name = name;
	}


	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the orderTs
	 */
	public Date getOrderTs()
	{
		return orderTs;
	}

	/**
	 * @param orderTs the orderTs to set
	 */
	public void setOrderTs(Date orderTs)
	{
		this.orderTs = orderTs;
	}

	/**
	 * @return the monetary
	 */
	public Double getMonetary()
	{
		return monetary;
	}

	/**
	 * @param monetary the monetary to set
	 */
	public void setMonetary(Double monetary)
	{
		this.monetary = monetary;
	}

	/**
	 * @return the remark
	 */
	public String getRemark()
	{
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	/**
	 * @return the custom
	 */
	public Custom getCustom()
	{
		return custom;
	}

	/**
	 * @param custom the custom to set
	 */
	public void setCustom(Custom custom)
	{
		this.custom = custom;
	}

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
	
}
