/**
 * 描述: 
 * BaseTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test;

// 静态导入
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.hua.entity.PagerEntity;
import com.hua.log.BaseLog;
import com.hua.orm.entity.m2o.Custom;
import com.hua.orm.entity.m2o.Item;
import com.hua.util.HibernateUtil;

/**
 * 描述: 测试基类
 * 包含多个测试示例
 * 
 * @author qye.zheng
 * BaseTest
 */
//@RunWith()
public class BaseTest extends BaseLog {
	
	/* SessionFactory */
	public static SessionFactory factory = null;
	//public static final SessionFactory factory = HibernateUtil.getSessionFactory();
	
	/* Hibernate 会话 */
	public Session session;
	
	public Query query;
	
	/* 增删改 会话中必须开启一个事务，然后再提交事务 */
	public Transaction tx;
	
	/* 日期格式 */
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	/* 对象唯一id */
	public String id;
	
	public PagerEntity pagerEntity = new PagerEntity();
	
	public Custom custom = null;
	
	public Item item = null;
	
	public Set<Item> items = null;
	
	public String sql;
	
	public String hql;
	
	/**
	 * 
	 * 描述: [所有测试]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass()");
	}
	
	/**
	 * 
	 * 描述: [所有测试]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
	}

}
