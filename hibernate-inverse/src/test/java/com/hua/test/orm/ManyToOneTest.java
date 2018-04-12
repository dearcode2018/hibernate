/**
 * 描述: 
 * ManyToOneTest.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.test.orm;

import org.junit.Test;

import com.hua.dao.m2o.CustomDao;
import com.hua.dao.m2o.impl.CustomDaoImpl;
import com.hua.orm.entity.m2o.Custom;
import com.hua.orm.entity.m2o.Item;
import com.hua.test.BaseTest;

/**
 * 描述: many to one 双向
 * @author qye.zheng
 * 
 * ManyToOneTest
 */
public final class ManyToOneTest extends BaseTest
{
	
	/**
	 * 新增客户 --> 新增/查询订单
	 * 
	 * 删除客户 --> 删除/查询该客户的所有订单
	 *  
	 * 更新客户 --> 新增/删除/修改/查询 订单
	 *  
	 * 查询客户 --> 新增/删除/修改/查询 订单
	 * 
	 */
	
	/**
	 * 描述: 新增测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testInsert01() {
		try {
			
			log.info("testInsert =====> begin");
			
			// 测试代码
			CustomDao ca = new CustomDaoImpl();
			Custom custom = new Custom();
			custom.setName("zhengqianye");
			custom.setAddress("guagnzhoucity");
			custom.setBalance(10.34);
			Item item = null;
			item = new Item();
			custom.getItems().add(item);
			item.setCustom(custom);
			item.setName("天河又一城1");
			item.setRemark("消费金额1");
			item.setMonetary(10.34);
			
			item = new Item();
			custom.getItems().add(item);
			item.setCustom(custom);
			item.setName("天河又一城2");
			item.setRemark("消费金额2");
			item.setMonetary(5.34);
			
			ca.insert(custom);
			
		} catch (Exception e) {
			log.error("testInsert =====> ", e);
		}
	}
	
	/**
	 * 描述: 新增测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testInsert02() {
		try {
			log.info("testInsert =====> begin");
			
			// 测试代码
			CustomDao ca = new CustomDaoImpl();
			Custom custom = new Custom();
			custom.setName("zhengqianye");
			custom.setAddress("guagnzhoucity");
			custom.setBalance(10.34);
			Item item = null;
			item = new Item();
			custom.getItems().add(item);
			item.setCustom(custom);
			item.setName("天河又一城1");
			item.setRemark("消费金额1");
			item.setMonetary(10.34);
			
			item = new Item();
			custom.getItems().add(item);
			item.setCustom(custom);
			item.setName("天河又一城2");
			item.setRemark("消费金额2");
			item.setMonetary(5.34);
			
			ca.insert(custom);
			
		} catch (Exception e) {
			log.error("testInsert =====> ", e);
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
