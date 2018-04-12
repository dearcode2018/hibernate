/**
 * 描述: 
 * SQLQueryTest.java
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

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.constant.ext.CustomStatus;
import com.hua.orm.entity.m2o.Custom;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * SQLQueryTest
 */
public final class QBCTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 选中测试方法，按 F11
	 */
	@Test
	public void testQBC() {
		try {
			// 打开会话
			Session session = factory.openSession();
			// 创建qbc查询对象
			/**
			 * 实体类、别名
			 */
			Criteria criteria = session.createCriteria(Custom.class, "a");
			
			/**
			 * 一旦分组之后，只有分组字段或使用了聚合函数的字段
			 * 才能出现在select列表中
			 */
			
			// select 列
			ProjectionList selects = Projections.projectionList();
			Projection p1 = Projections.groupProperty("a.name");
			selects.add(p1, "name");
			Projection p2 = Projections.groupProperty("a.status");
			selects.add(p2, "status");
			// 设置返回列
			criteria.setProjection(selects);
			
			// 关联关系
			criteria.createAlias("a.items", "its", JoinType.LEFT_OUTER_JOIN);
			 // 动态关联抓取
			//criteria.setFetchSize(10);
			
			// 模糊查询约束 ( % _ / 特殊字符可以直接写)
			Criterion like = Restrictions.like("a.name", "郑%");
			Criterion isNoNull = Restrictions.isNotNull("a.name");
			Criterion eq = Restrictions.eq("a.status", CustomStatus.NOTACTIVATED);
			// 多个条件 与 或 非
			Criterion where = Restrictions.and(like, isNoNull, eq);
			
			// where
			criteria.add(where);
			
			// 分组
			/*
			 * 分组字段只需加入selects集合即可，selects集合已经
			 * 置入 criteria 对象了
			 */
			//Projection g1 = Projections.groupProperty("a.status");
			//selects.add(g1, "status");		
			
			// 排序
			criteria.addOrder(Order.asc("a.id"));
			
			// 分页 
			// startIndex
			criteria.setFirstResult(0);
			// pageSize 0 - 则从startIndez开始返回所有
			criteria.setMaxResults(5);
			
			// 获取单个结果
			//Object obj = criteria.uniqueResult();
			// 获取查询结果列表 List<X> List<Object[]>
			List list = criteria.list();
			System.out.println(list.size());
			//Custom c = (Custom) list.get(0);
			//System.out.println(c.toString());
		} catch (Exception e) {
			log.error("testQBC =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 选中测试方法，按 F11
	 */
	@Test
	public void testUniqueResult() {
		try {
			// 打开会话
			Session session = factory.openSession();
			// 创建qbc查询对象
			/**
			 * 实体类、别名
			 */
			Criteria criteria = session.createCriteria(Custom.class, "a");
			
			// select 列
			//criteria.setProjection(Projections.projectionList());
			//criteria.setProjection(Projections.avg("a.balance"));
			//criteria.setProjection(Property.forName("a.name"));
			//criteria.setProjection(Property.forName("a.balance"));
			
			// 关联关系
			criteria.createAlias("a.items", "its", JoinType.LEFT_OUTER_JOIN);
			 // 动态关联抓取
			//criteria.setFetchSize(10);
			
			// 模糊查询约束 ( % _ / 特殊字符可以直接写)
			Criterion like = Restrictions.like("a.name", "郑%");
			Criterion isNoNull = Restrictions.isNotNull("a.name");
			Criterion eq = Restrictions.eq("a.status", CustomStatus.NOTACTIVATED);
			// 多个条件 与 或 非
			Criterion where = Restrictions.and(like, isNoNull, eq);
			
			// where
			criteria.add(where);
			
			// 分组
			PropertyProjection projection = Projections.groupProperty("a.status");
			//criteria.setProjection(projection);
			
			// 排序
			criteria.addOrder(Order.asc("a.id"));
			
			// 分页 
			// startIndex
			criteria.setFirstResult(200);
			// pageSize  0 - 则从startIndez开始返回所有
			criteria.setMaxResults(1);
			
			// 获取单个结果
			//Object obj = criteria.uniqueResult();
			// 获取查询结果列表 List<X> List<Object[]>
			List list = criteria.list();
			Custom c = (Custom) list.get(0);
			System.out.println(list.size());
			System.out.println(c.toString());
		} catch (Exception e) {
			log.error("testUniqueResult =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetAnObject() {
		try {
			// 打开会话
			Session session = factory.openSession();
			String sql = "select a.* from custom a "
					+ " WHERE a.id = ?";
			// 创建查询对象
			Query query = session.createSQLQuery(sql);
			query.setString(0, "1");
			
			// 获取单个结果
			Object[] objs = (Object[] ) query.uniqueResult();
			System.out.println(Arrays.toString(objs));
			
		} catch (Exception e) {
			log.error("testGetAnObject =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSearchList() {
		try {
			// 打开会话
			Session session = factory.openSession();
			String sql = "select a.* from custom a "
					+ " WHERE a.status = ?";
			// 创建查询对象
			Query query = session.createSQLQuery(sql);
			query.setString(0, "1");
			
			// 获取查询结果列表 List<X> List<Object[]>
			List list = query.list();
			
			System.out.println(list.size());
			
		} catch (Exception e) {
			log.error("testSearchList =====> ", e);
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
