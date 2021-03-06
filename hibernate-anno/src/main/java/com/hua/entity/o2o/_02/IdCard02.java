/**
 * 描述: 
 * IdCard02.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.entity.o2o._02;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hua.entity.BaseEntity;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * IdCard02
 */
@Entity(name = "IdCard02")
@Table(name = "idCard_02")
public class IdCard02 extends BaseEntity
{
	
	/**
	 * 一个人只有一个身份证，一个身份证只属于一个人
	 */
	// 本地(数据库自身)生成方式 
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", insertable = true, 
			updatable = false, length = 64, 
			nullable = false, unique = true)
	@Id
	/* 对象唯一id */
	private String id;
	
	@Column(name = "title", insertable = true, 
			updatable = true, length = 32, 
			nullable = true, unique = false)
	/* 身份证标题, 例如 : 中华人民共和国 - 居民身份证 */
	private String title;
	
	@Column(name = "cardNo", insertable = true, 
			updatable = true, length = 64, 
			nullable = true, unique = false)
	/* 身份证号 */
	private String cardNo;
	
	@Column(name = "issuingAuthority", insertable = true, 
			updatable = true, length = 32, 
			nullable = true, unique = false)
	/* 签发机关 (Xx市公安局) */
	private String issuingAuthority;
	
	@Column(name = "effectiveDate", insertable = true, 
			updatable = true, nullable = true, unique = false)
	/* 生效日期 yyyy-MM-dd */
	private Date effectiveDate;
	
	@Column(name = "expiryDate", insertable = true, 
			updatable = true, nullable = true, unique = false)
	/* 失效日期 yyyy-MM-dd */
	private Date expiryDate;
	
	@JoinColumn(name = "personId", insertable = true, 
			updatable = true, nullable = true, unique = true)
	@OneToOne
	/* 身份证持有者 */
	private Person02 person;
	
	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * @return the cardId
	 */
	public String getCardNo()
	{
		return cardNo;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardNo(String cardNo)
	{
		this.cardNo = cardNo;
	}

	/**
	 * @return the issuingAuthority
	 */
	public String getIssuingAuthority()
	{
		return issuingAuthority;
	}

	/**
	 * @param issuingAuthority the issuingAuthority to set
	 */
	public void setIssuingAuthority(String issuingAuthority)
	{
		this.issuingAuthority = issuingAuthority;
	}

	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate()
	{
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate)
	{
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate()
	{
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate)
	{
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the person02
	 */
	public Person02 getPerson()
	{
		return person;
	}

	/**
	 * @param person02 the person02 to set
	 */
	public void setPerson(Person02 person)
	{
		this.person = person;
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
