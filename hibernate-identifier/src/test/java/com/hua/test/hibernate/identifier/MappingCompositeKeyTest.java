/**
 * 描述: 
 * MappingCompositeKeyTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.hibernate.identifier;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.Assigned;
import com.hua.entity.CompositeKey;
import com.hua.entity.MappingCompositeKey01;
import com.hua.entity.MappingCompositeKey02;
import com.hua.test.BaseTest;
import com.hua.util.HibernateUtil;
import com.hua.util.RandomUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * MappingCompositeKeyTest
 */
public final class MappingCompositeKeyTest extends BaseTest {

	public static final SessionFactory factory = HibernateUtil.buildByXml();
	
	
	/* Hibernate 会话 */
	public Session session;
	
	/* 增删改 会话中必须开启一个事务，然后再提交事务 */
	public Transaction tx;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMappingCompositeKey01() {
		try {
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			MappingCompositeKey01 key = new MappingCompositeKey01();
			key.setName("张鲁");
			key.setCompanyId("216401065");
			key.setAddress("新疆自治区乌鲁木齐市平山路518号");
			// 持久化操作
			session.save(key);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			log.error("testMappingCompositeKey01 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMappingCompositeKey02() {
		try {
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			
			/**
			 * 异常信息: 
			 *The class has no identifier property: com.hua.entity.MappingCompositeKey02 
			 * 需要加 name值 <composite-id name="key" class="com.hua.entity.CompositeKey">
			 */
			/**
			 * 联合主键 重复会有异常提示
			 */
			// 开始事务
			tx = session.beginTransaction();
			MappingCompositeKey02 key = new MappingCompositeKey02();
			
			CompositeKey ck = new CompositeKey();
			ck.setName("程度");
			ck.setCompanyId("216401065");
			
			key.setKey(ck);
			key.setAddress("新疆自治区乌鲁木齐市平山路518号");
			// 持久化操作
			session.save(key);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			log.error("testMappingCompositeKey02 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testInsert() {
		try {
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			Assigned assigned = new Assigned();
			assigned.setId(UUID.randomUUID().toString());
			assigned.setName("assign-" + RandomUtil.nextInt(3));
			// 持久化操作
			session.save(assigned);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			log.error("testInsert =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			System.out.println("ca6a7d0a-51c9-4ca0-983f-7e3d69b51f83".length());
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
