/**
 * 描述: 
 * CacheTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.hibernate;

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

import java.util.List;

import net.sf.ehcache.hibernate.EhCacheProvider;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.orm.entity.m2o.Custom;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * CacheTest
 */
public final class CacheTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCache() {
		try {
			// 打开会话
			Session session = factory.openSession();
			/*
			 * 查询出其关联的集合对象
			 */
			/*
			 * 通过构造Map对象，必须指定别名，否则
			 * 仅根据书写的列名是无法访问的
			 */
			String hql = " from " + Custom.class.getName() + " as c "
					// + " join c.items as its "
						+ " WHERE c.items.size > ?";
			// 创建查询对象
			Query query = session.createQuery(hql);
			query.setInteger(0,  0);
			List list = query.list();
			log.info("testExpression =====> " + list.size());
			
	
		} catch (Exception e) {
			log.error("testCache =====> ", e);
		}
	}
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			// 打开会话
			Session session = factory.openSession();
			/*
			 * 查询出其关联的集合对象
			 */
			/*
			 * 通过构造Map对象，必须指定别名，否则
			 * 仅根据书写的列名是无法访问的
			 */
			String hql = " from " + Custom.class.getName() + " as c "
					// + " join c.items as its "
						+ " WHERE c.items.size > ?";
			// 创建查询对象
			Query query = session.createQuery(hql);
			query.setInteger(0,  0);
			List list = query.list();
			log.info("testExpression =====> " + list.size());
		
			
	
		} catch (Exception e) {
			log.error("test =====> ", e);
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
