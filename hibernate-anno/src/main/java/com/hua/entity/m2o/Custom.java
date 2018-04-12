/**
 * 描述: 
 * Custom.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.entity.m2o;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hua.constant.ext.CustomStatus;
import com.hua.entity.BaseEntity;

/**
 * 描述: 客户
 * @author qye.zheng
 * 
 * Custom
 */
@Entity
@Table(name = "custom")
public class Custom extends BaseEntity
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
	/* 客户姓名 */
	private String name;

	@Column(name = "balance", insertable = true, 
			updatable = true, precision = 2,
			nullable = true, unique = false)
	/* 帐户余额 */
	private Double balance;
	
	@Column(name = "address", insertable = true, 
			updatable = true, length = 255, 
			nullable = true, unique = false)
	/* 住址 */
	private String address;
	
	@Column(name = "status", insertable = true, 
			updatable = true, nullable = true, unique = false)
	@Enumerated(EnumType.ORDINAL)
	/* 客户状态 (0-无效, 1-未激活, 2-正常) */
	private CustomStatus status = CustomStatus.INVALIDE;
	
	@Column(name = "customId", insertable = true, 
			updatable = false, nullable = false, unique = true)
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "custom")
	// one to many
	/* 客户的所有订单 */
	private Set<Item> items = new HashSet<Item>();

	/**
	 * @description 构造方法
	 * @author qye.zheng
	 */
	public Custom() {
	}
	
	/**
	 * 
	 * @description 构造方法
	 * @param name
	 * @param balance
	 * @param status
	 * @author qye.zheng
	 */
	public Custom(String name, Double balance, CustomStatus status) {
		super();
		this.name = name;
		this.balance = balance;
		this.status = status;
	}

	/**
	 * 
	 * @description 构造方法
	 * @param name
	 * @param balance
	 * @param status
	 * @param items
	 * @author qye.zheng
	 */
	public Custom(String name, Double balance, CustomStatus status,
			Set<Item> items) {
		super();
		this.name = name;
		this.balance = balance;
		this.status = status;
		this.items = items;
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
	 * @return the balance
	 */
	public Double getBalance()
	{
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Double balance)
	{
		this.balance = balance;
	}

	/**
	 * @return the address
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * @return the status
	 */
	public CustomStatus getStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(CustomStatus status)
	{
		this.status = status;
	}

	/**
	 * @return the items
	 */
	public Set<Item> getItems()
	{
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Set<Item> items)
	{
		this.items = items;
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
