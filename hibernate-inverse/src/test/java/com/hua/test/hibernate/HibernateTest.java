/**
 * 描述: 
 * HibernateTest.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.test.hibernate;

import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.Hbm2Ddl;
import com.hua.util.HibernateUtil;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * HibernateTest
 */
public final class HibernateTest extends BaseTest
{
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testHibernate() {
		try {
			
			
		} catch (Exception e) {
			log.error("testHibernate =====> ", e);
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
	 * 描述: 新增测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testInsert() {
		try {
			// 打开会话
			session = factory.openSession();
			log.info("testInsert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 操作过程
			
			log.info("testInsert =====> 提交事务");
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			log.error("testInsert =====> 回滚事务", e);
			// 回滚事务
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			if (null != session) {
				// 关闭会话
				session.close();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 删除测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDelete() {
		try {
			// 打开会话
			session = factory.openSession();
			log.info("testDelete =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 操作过程
			
			log.info("testDelete =====> 提交事务");
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			log.error("testDelete =====> 回滚事务", e);
			// 回滚事务
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			if (null != session) {
				// 关闭会话
				session.close();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 更新测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUpdate() {
		try {
			// 打开会话
			session = factory.openSession();
			log.info("testUpdate =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 操作过程
			
			log.info("testUpdate =====> 提交事务");
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			log.error("testUpdate =====> 回滚事务", e);
			// 回滚事务
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			if (null != session) {
				// 关闭会话
				session.close();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 查询测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQuery() {
		try {
			// 打开会话
			session = factory.openSession();
			
			// 操作过程
			
			
		} catch (Exception e) {
			log.error("testQuery =====> ", e);
		} finally {
			if (null != session) {
				// 关闭会话
				session.close();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSchemaExport() {
		try {
		/*	final boolean script = true;
			final boolean export = false;
			// 输出
			Hbm2Ddl.schemaExport(script, export);*/
			// 输出到控制台
			Hbm2Ddl.printDdl();
			
		} catch (Exception e) {
			log.error("testSchemaExport =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBuild() {
		try {
			HibernateUtil.buildByXml();
			
		} catch (Exception e) {
			log.error("testBuild =====> ", e);
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
	
}
