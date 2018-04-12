/**
 * 描述: 
 * SelectTest.java
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

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.orm.entity.m2o.Custom;
import com.hua.orm.entity.m2o.Item;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * SelectTest
 */
public final class SelectTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSelect() {
		try {
			// 打开会话
			Session session = factory.openSession();
			String hql = "select c.items from " + Custom.class.getName() + " as c "
					+ " WHERE c.id = ?";
			// 创建查询对象
			Query query = session.createQuery(hql);
			query.setString(0, "1");
			// 获取查询结果列表 List<X> List<Object[]>
			List<Item> list = query.list();
			Item i = list.get(0);
			
			System.out.println(i.getName());
			
		} catch (Exception e) {
			log.error("testSelect =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSelectCollection() {
		try {
			// 打开会话
			Session session = factory.openSession();
			/*
			 * 查询出其关联的集合对象
			 */
			String hql = "select c.items from " + Custom.class.getName() + " as c "
					+ " WHERE c.id = ?";
			// 等效于
			 hql = "select its from " + Custom.class.getName() + " as c "
					 + " join c.items its"
						+ " WHERE c.id = ?";
			
			// 创建查询对象
			Query query = session.createQuery(hql);
			query.setString(0, "1");
			// 获取查询结果列表 List<X> List<Object[]>
			List<Item> list = query.list();
			Item i = list.get(0);
			
			System.out.println(i.getName());
			
		} catch (Exception e) {
			log.error("testSelectCollection =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSelectSomeField() {
		try {
			// 打开会话
			Session session = factory.openSession();
			/*
			 * 查询出其关联的集合对象
			 */
			String hql = "select c.id, c.name, c.balance from " + Custom.class.getName() + " as c "
					// join 关联对象之后，会出现多条，
					 //+ " join c.items its"
						+ " WHERE c.id = ?";
			
			// 创建查询对象
			Query query = session.createQuery(hql);
			query.setString(0, "1");
			Object[] objs = (Object[]) query.uniqueResult();
			
			System.out.println(Arrays.toString(objs));
			
		} catch (Exception e) {
			log.error("testSelectSomeField =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSelectGetAnObject() {
		try {
			// 打开会话
			Session session = factory.openSession();
			/*
			 * 查询出其关联的集合对象
			 */
			// 通过构造方法来构造对象
			String hql = "select new " + Custom.class.getName()
			 + "(c.name, c.balance, c.status)"
			 +" from " + Custom.class.getName() + " as c "
					// + " join c.items as its "
						+ " WHERE c.id = ?";
			
			// 创建查询对象
			Query query = session.createQuery(hql);
			query.setString(0, "1");
			Custom custom = (Custom) query.uniqueResult();
			
			System.out.println(custom.toString());
			
		} catch (Exception e) {
			log.error("testSelectGetAnObject =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSelectGetAMap() {
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
			String hql = "select new map"
			 + "(c.name as name, c.balance as balance, c.status as status)"
			 +" from " + Custom.class.getName() + " as c "
					// + " join c.items as its "
						+ " WHERE c.id = ?";
			
			// 创建查询对象
			Query query = session.createQuery(hql);
			query.setString(0, "1");
			Map<String, Object> map = (Map<String, Object>) query.uniqueResult();
			
			System.out.println(map.get("name"));
			System.out.println(map.get("balance"));
			System.out.println(map.get("status"));
			
		} catch (Exception e) {
			log.error("testSelectGetAMap =====> ", e);
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
			String hql = "";
			// 创建查询对象
			Query query = session.createQuery(hql);
			
			// 获取单个结果
			Object obj = query.uniqueResult();
			// 获取查询结果列表 List<X> List<Object[]>
			List list = query.list();
			
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
