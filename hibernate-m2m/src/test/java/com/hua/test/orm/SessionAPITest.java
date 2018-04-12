/**
 * 描述: 
 * SessionAPITest.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.test.orm;

import java.util.Random;

import org.junit.Test;

import com.hua.orm.entity.m2o.Custom;
import com.hua.orm.entity.m2o.Item;
import com.hua.test.BaseTest;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * SessionAPITest
 */
public final class SessionAPITest extends BaseTest
{
	/**
	 * 
	 * 描述: 新增测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDmlTemplate() {
		try {
			log.info(" =====> begin");
			// 打开会话
			session = factory.openSession();
			log.info(" =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 操作过程
			// 持久化操作
			//session.save(t);
			//session.persist(t);
			
			log.info(" =====> 提交事务");
			// 提交事务
			tx.commit();
			// 测试代码
			
		} catch (Exception e) {
			log.error(" =====> ", e);
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
	 * 描述: 新增测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSession_Load() {
		try {
			
			log.info(" =====> begin");
			// 打开会话
			session = factory.openSession();
			id = "39";
			Custom custom =  (Custom) session.load(Custom.class, id);
		
			
			
			log.info(" =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			//System.out.println(custom.getName());
			// 操作过程
			// 持久化操作
			//session.save(t);
			//session.persist(t);
			
			log.info(" =====> 提交事务");
			// 提交事务
			tx.commit();
			// 测试代码
			
		} catch (Exception e) {
			log.error(" =====> ", e);
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
	 * 描述: 新增测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSession_Get() {
		try {
			
			log.info(" =====> begin");
			// 打开会话
			session = factory.openSession();
			id = "39";
			Custom custom =  (Custom) session.get(Custom.class, id);
		
			
			
			log.info(" =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			//System.out.println(custom.getName());
			// 操作过程
			// 持久化操作
			//session.save(t);
			//session.persist(t);
			
			log.info(" =====> 提交事务");
			// 提交事务
			tx.commit();
			// 测试代码
			
		} catch (Exception e) {
			log.error(" =====> ", e);
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
	 * 描述: 新增测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUpdateOneSetInverse_false() {
		try {
			
			log.info(" =====> begin");
			// 打开会话
			session = factory.openSession();
			id = "39";
			Custom custom =  (Custom) session.load(Custom.class, id);
			
		
			
			
			log.info(" =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			//System.out.println(custom.getName());
			// 操作过程
			// 持久化操作
			//session.save(t);
			//session.persist(t);
			
			log.info(" =====> 提交事务");
			// 提交事务
			tx.commit();
			// 测试代码
			
		} catch (Exception e) {
			log.error(" =====> ", e);
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
	 * 描述: 新增测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUpdateOneSetInverse_true() {
		try {
			log.info(" =====> begin");
			// 打开会话
			session = factory.openSession();
			log.info(" =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 操作过程
			// 持久化操作
			//session.save(t);
			//session.persist(t);
			
			log.info(" =====> 提交事务");
			// 提交事务
			tx.commit();
			// 测试代码
			
		} catch (Exception e) {
			log.error(" =====> ", e);
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
	 * 描述: 新增测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testInsertOneSetInverse_false() {
		try {
			log.info("testInsert =====> begin");
			Custom custom = new Custom();
			custom.setName("zhengqianye");
			custom.setAddress("guagnzhoucity");
			custom.setBalance(10.34);
			
			Item item1 = null;
			
			item1 = new Item();
			//item.setOid(new Random().nextLong());
			/**
			 * Custom.hbm.xml set元素中配置了inverse=true，
			 * 则 custom.getItems().add(item1); 去维护和多的一方
			 * 的关系是多余的、不起作用的，此时Item对象的保存
			 * 可以成功，但是关联的关系(此时是item表的外键customId字段)
			 * 的值却为空.
			 * 此时必须由 多的一方去维护关系
			 * 
			 */
			
			// one 方去维护该关系
			custom.getItems().add(item1);
			/**
			 * 由于 one方 set元素 inverse设置为false，意味着
			 * 关系可以由one方去维护，则此时，item1.setCustom(custom);
			 * 维护关系的代码是多余的，可以不用写.
			 */
			// [多]的一方来维护关系
			//item1.setCustom(custom);
			item1.setName("天河又一城1");
			item1.setRemark("消费金额1");
			item1.setMonetary(10.34);
			
/*			Item item2 = new Item();
			// 多余代码
			//custom.getItems().add(item2);
			// 由[多]的一方来维护关系
			item2.setCustom(custom);
			item2.setName("天河又一城2");
			item2.setRemark("消费金额2");
			item2.setMonetary(5.34);*/
			
			//System.out.println(item1.hashCode() + ", " + item2.hashCode());
			
			// 打开会话
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			
			
			// 操作过程
			// 持久化操作
			session.save(custom);
			session.save(item1);
			//session.save(item2);
			//session.persist(t);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
			// 测试代码
			
		} catch (Exception e) {
			log.error("testInsert =====> ", e);
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
	 * 描述: 新增测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testInsert_One_set_inverse_true() {
		try {
			log.info("testInsert =====> begin");
			Custom custom = new Custom();
			custom.setName("zhengqianye");
			custom.setAddress("guagnzhoucity");
			custom.setBalance(10.34);
			
			Item item1 = null;
			
			item1 = new Item();
			//item.setOid(new Random().nextLong());
			/**
			 * Custom.hbm.xml set元素中配置了inverse=true，
			 * 则 custom.getItems().add(item1); 去维护和多的一方
			 * 的关系是多余的、不起作用的，此时Item对象的保存
			 * 可以成功，但是关联的关系(此时是item表的外键customId字段)
			 * 的值却为空.
			 * 此时必须由 多的一方去维护关系
			 * 
			 */
			// 多余代码
			//custom.getItems().add(item1);
			// 由[多]的一方来维护关系
			item1.setCustom(custom);
			item1.setName("天河又一城1");
			item1.setRemark("消费金额1");
			item1.setMonetary(10.34);
			
			Item item2 = new Item();
			// 多余代码
			//custom.getItems().add(item2);
			// 由[多]的一方来维护关系
			item2.setCustom(custom);
			item2.setName("天河又一城2");
			item2.setRemark("消费金额2");
			item2.setMonetary(5.34);
			
			//System.out.println(item1.hashCode() + ", " + item2.hashCode());
			
			// 打开会话
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			
			
			// 操作过程
			// 持久化操作
			session.save(custom);
			session.save(item1);
			session.save(item2);
			//session.persist(t);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
			// 测试代码
			
		} catch (Exception e) {
			log.error("testInsert =====> ", e);
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
			log.info("testDelete =====> begin");
			
			// 测试代码
		
		} catch (Exception e) {
			log.error("testDelete =====> ", e);
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
			log.info("testUpdate =====> begin");
			
			// 测试代码
			
		} catch (Exception e) {
			log.error("testUpdate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 新增或更新
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSaveOrUpdate() {
		try {
			log.info("testSaveOrUpdate =====> begin");
			
			// 测试代码
			
		} catch (Exception e) {
			log.error("testSaveOrUpdate =====> ", e);
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
			log.info("testQuery =====> begin");
			
			// 测试代码
			
		} catch (Exception e) {
			log.error("testQuery =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取单个对象 - get 方式
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGet() {
		try {
			log.info("testGet =====> begin");
			
			// 测试代码
			
		} catch (Exception e) {
			log.error("testGet =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取单个对象 - load 方式
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLoad() {
		try {
			log.info("testLoad =====> begin");
			
			// 测试代码
			
		} catch (Exception e) {
			log.error("testLoad =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 统计测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCount() {
		try {
			log.info("testCount =====> begin");
			
			// 测试代码
			
			
		} catch (Exception e) {
			log.error("testCount =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 搜索测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSearch() {
		try {
			log.info("testSearch =====> begin");
			
			// 测试代码
			
		} catch (Exception e) {
			log.error("testSearch =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 执行测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testExecute() {
		try {
			log.info("testExecute =====> begin");
			
			// 测试代码
			
		} catch (Exception e) {
			log.error("testExecute =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 分页测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPaging() {
		try {
			log.info("testPaging =====> begin");
			
			// 测试代码
			
			
		} catch (Exception e) {
			log.error("testPaging =====> ", e);
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
}
