/**
 * 描述: 
 * Person02.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.entity.o2o._02;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hua.constant.ext.Gender;
import com.hua.entity.BaseEntity;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * Person02
 */
@Entity(name = "Person02")
@Table(name = "person_02")
public class Person02 extends BaseEntity
{

	/**
	 * 一个人只有一个身份证，一个身份证只属于一个人
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
			updatable = true, length = 64, 
			nullable = true, unique = false)
	/* 姓名 */
	private String name;
	
	@Column(name = "photoUrl", insertable = true, 
			updatable = true, length = 255, 
			nullable = true, unique = false)
	/* 证件照片url */
	private String photoUrl;
	
	@Column(name = "gender", insertable = true, 
			updatable = true, length = 255, 
			nullable = true, unique = false)
	@Enumerated(EnumType.STRING)
	/* 性别 : 0-未知, 1-男(male), 2-女(female) */
	private Gender gender = Gender.UNKNOW;
	
	@Column(name = "nation", insertable = true, 
			updatable = true, length = 32, 
			nullable = true, unique = false)
	/* 民族 */
	private String nation;
	
	@Column(name = "birthday", insertable = true, 
			updatable = true, nullable = true, unique = false)
	/* 出生日期 yyyy-MM-dd */
	private Date birthday;
	
	@Column(name = "address", insertable = true, 
			updatable = true, length = 255, 
			nullable = true, unique = false)
	/* 住址 */
	private String address;
	 
	@OneToOne(mappedBy = "person", 
			cascade = CascadeType.ALL, optional = true)
	// one to one
	/* 身份证 */
	private IdCard02 idCard;
	
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
	 * @return the photoUrl
	 */
	public String getPhotoUrl()
	{
		return photoUrl;
	}

	/**
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl)
	{
		this.photoUrl = photoUrl;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender()
	{
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

	/**
	 * @return the nation
	 */
	public String getNation()
	{
		return nation;
	}

	/**
	 * @param nation the nation to set
	 */
	public void setNation(String nation)
	{
		this.nation = nation;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday()
	{
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
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
	 * @return the idCard02
	 */
	public IdCard02 getIdCard()
	{
		return idCard;
	}

	/**
	 * @param idCard02 the idCard02 to set
	 */
	public void setIdCard(IdCard02 idCard)
	{
		this.idCard = idCard;
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
