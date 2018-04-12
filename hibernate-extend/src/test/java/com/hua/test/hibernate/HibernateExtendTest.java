/**
 * 描述: 
 * HibernateExtendTest.java
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

import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.extend.People;
import com.hua.entity.extend.Teacher;
import com.hua.entity.extend.Worker;
import com.hua.test.BaseTest;
import com.hua.util.RandomUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * HibernateExtendTest
 */
public final class HibernateExtendTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testExtendInsert01() {
		try {
			session = factory.openSession();
			
			//People w = new Worker();
			//People t = new Teacher();
			
			Worker worker = new Worker();
			worker.setId(RandomUtil.randomNumeric(4));
			worker.setName("王东");
			worker.setAge(32);
			worker.setSex("Male");
			worker.setwNo("20065689");
			worker.setSalary(4500.00);
			
			Teacher teacher = new Teacher();
			teacher.setId(RandomUtil.randomNumeric(4));
			teacher.setName("徐茂公");
			teacher.setAge(32);
			teacher.setSex("Male");
			teacher.settNo("2003");
			teacher.setSchool("东北理工大学");
			
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 持久化操作
			session.save(worker);
			session.save(teacher);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
			
			
		} catch (Exception e) {
			log.error("testExtendInsert01 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testExtendInsert02() {
		try {
			session = factory.openSession();
			
			//People w = new Worker();
			//People t = new Teacher();
			
			Worker worker = new Worker();
			worker.setName("王东");
			worker.setAge(32);
			worker.setSex("Male");
			worker.setwNo("20065689");
			worker.setSalary(4500.00);
			
			Teacher teacher = new Teacher();
			teacher.setName("徐茂公");
			teacher.setAge(32);
			teacher.setSex("Male");
			teacher.settNo("2003");
			teacher.setSchool("东北理工大学");
			
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 持久化操作
			session.save(worker);
			session.save(teacher);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
			
			
		} catch (Exception e) {
			log.error("testExtendInsert02 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testExtendInsert03() {
		try {
			session = factory.openSession();
			
			//People w = new Worker();
			//People t = new Teacher();
			
			Worker worker = new Worker();
			worker.setId(RandomUtil.randomNumeric(4));
			worker.setName("王东");
			worker.setAge(32);
			worker.setSex("Male");
			worker.setwNo("20065689");
			worker.setSalary(4500.00);
			
			Teacher teacher = new Teacher();
			teacher.setId(RandomUtil.randomNumeric(4));
			teacher.setName("徐茂公");
			teacher.setAge(32);
			teacher.setSex("Male");
			teacher.settNo("2003");
			teacher.setSchool("东北理工大学");
			
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 持久化操作
			session.save(worker);
			session.save(teacher);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
			
			
		} catch (Exception e) {
			log.error("testExtendInsert03 =====> ", e);
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
