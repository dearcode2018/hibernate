/**
 * 描述: 
 * LazyTest.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.test.orm;

import org.hibernate.Hibernate;
import org.junit.Test;

import com.hua.dao.m2o.CustomDao;
import com.hua.dao.m2o.ItemDao;
import com.hua.dao.m2o.impl.CustomDaoImpl;
import com.hua.dao.m2o.impl.ItemDaoImpl;
import com.hua.orm.entity.m2o.Custom;
import com.hua.orm.entity.m2o.Item;
import com.hua.test.BaseTest;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * LazyTest
 */
public final class LazyTest extends BaseTest
{
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
			ItemDao itemDao = new ItemDaoImpl();
			
			Custom custom = new Custom();
			
			custom.setName("zhengqianye");
			custom.setAddress("guagnzhoucity");
			custom.setBalance(10.34);
			
			Item item1 = null;
			item1 = new Item();
			// 设置关联关系 (发起关系维护)
			item1.setCustom(custom);
			item1.setName("天河又一城1");
			item1.setRemark("消费金额1");
			item1.setMonetary(10.34);
			
			Item item2 = new Item();
			// 设置关联关系 (发起关系维护)
			item2.setCustom(custom);
			item2.setName("天河又一城2");
			item2.setRemark("消费金额2");
			item2.setMonetary(5.34);
			
			ca.insert(custom);
			itemDao.insert(item1);
			itemDao.insert(item2);

		} catch (Exception e) {
			log.error("testInsert =====> ", e);
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
			log.info("testInsert =====> begin");
			
			// 测试代码
			// 测试代码
			CustomDao ca = new CustomDaoImpl();
			ItemDao itemDao = new ItemDaoImpl();
			id = "40";
			Custom custom = ca.load(Custom.class, id);
			
			Item item1 = null;
			item1 = new Item();
			// 设置关联关系 (发起关系维护)
			item1.setCustom(custom);
			item1.setName("天河又一城3");
			item1.setRemark("消费金额3");
			item1.setMonetary(10.34);
			
			Item item2 = new Item();
			// 设置关联关系 (发起关系维护)
			item2.setCustom(custom);
			item2.setName("天河又一城4");
			item2.setRemark("消费金额4");
			item2.setMonetary(5.34);
			
			itemDao.insert(item1);
			itemDao.insert(item2);
			
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
			CustomDao ca = new CustomDaoImpl();
			ItemDao itemDao= new ItemDaoImpl();
			id = "41";
			/**
			 * 不管对象在数据库中是否存在，get方法都
			 * 不会抛异常
			 */
			custom = ca.get(Custom.class, id);
			
			
			
			
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
			id = "40";
			/**
			 * load 方法返回的是代理对象，是被代理对象的子类
			 */
			//custom = ca.load(Custom.class, id);
			
			// 打开会话
			session = factory.openSession();
			custom = (Custom) session.load(Custom.class, id);
			
			
			
			
			/**
			 * org.hibernate.Hibernate 类的initialize()静态方法
			 * 用于在Session范围内显式初始化代理类实例，
			 * isInitialized()方法用于判断代理类实例是否已经被初始化
			 */
/*			if (!Hibernate.isInitialized(custom))
			{
				
				 * 显式初始化代理类实例. 这样可以在
				 * session 关闭之后，仍然可以正常访问Custom游离对象
				 
				Hibernate.initialize(custom);
			}*/
			//注意：Hibernate支持Lazy策略，只有session打开状态才有效 
			/**
			 * session 关闭之后，再调用代理对象去获取属性值，就会
			 * 抛如下异常:
			 * org.hibernate.LazyInitializationException: could not initialize proxy - no Session
			 */
			//session.close();
			log.info("testLoad =====> name = " + custom.getName());
			log.info("testLoad =====> address = " + custom.getAddress());
			//log.info("testLoad =====> superClass = " + custom.getClass().getSuperclass().getName());
			
			// class = com.hua.orm.entity.m2o.Custom_$$_jvst21_1
			//System.out.println("class = " + custom.getClass().getName());
			// superClass = com.hua.orm.entity.m2o.Custom
			//System.out.println("superClass = " + custom.getClass().getSuperclass().getName());
			
		} catch (Exception e) {
			log.error("testLoad =====> ", e);
		} finally {
			if (null != session) {
				// 关闭会话
				session.close();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 获取单个对象 
	 * 属性延迟加载
	 * 通过 Query 查询API来实现
	 * session的load方法暂时不能实现
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPropertyLazy() {
		try {
			log.info("testPropertyLazy =====> begin");
			
			// 测试代码
			id = "40";
			/**
			 * load 方法返回的是代理对象，是被代理对象的子类
			 */
			//custom = ca.load(Custom.class, id);
			
			// 打开会话
			session = factory.openSession();
			//custom = (Custom) session.load(Custom.class, id);
			hql = "from " + Custom.class.getName() + " a where a.oid = ?";
			query = session.createQuery(hql);
			query.setString(0, id);
			custom = (Custom) query.list().get(0);
			/**
			 * org.hibernate.Hibernate 类的initialize()静态方法
			 * 用于在Session范围内显式初始化代理类实例，
			 * isInitialized()方法用于判断代理类实例是否已经被初始化
			 */
/*			if (!Hibernate.isInitialized(custom))
			{
				
				 * 显式初始化代理类实例. 这样可以在
				 * session 关闭之后，仍然可以正常访问Custom游离对象
				 
				Hibernate.initialize(custom);
			}*/
			//注意：Hibernate支持Lazy策略，只有session打开状态才有效 
			/**
			 * session 关闭之后，再调用代理对象去获取属性值，就会
			 * 抛如下异常:
			 * org.hibernate.LazyInitializationException: could not initialize proxy - no Session
			 */
			//session.close();
			//log.info("testPropertyLazy =====> name = " + custom.getName());
			log.info("testPropertyLazy =====> address = " + custom.getAddress());
			//log.info("testLoad =====> superClass = " + custom.getClass().getSuperclass().getName());
			
			// class = com.hua.orm.entity.m2o.Custom_$$_jvst21_1
			//System.out.println("class = " + custom.getClass().getName());
			// superClass = com.hua.orm.entity.m2o.Custom
			//System.out.println("superClass = " + custom.getClass().getSuperclass().getName());
			
		} catch (Exception e) {
			log.error("testPropertyLazy =====> ", e);
		} finally {
			if (null != session) {
				// 关闭会话
				session.close();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 获取单个对象 - load 方式
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLoadInitialize() {
		try {
			log.info("testLoadInitialize =====> begin");
			
			// 测试代码
			id = "40";
			/**
			 * load 方法返回的是代理对象，是被代理对象的子类
			 */
			//custom = ca.load(Custom.class, id);
			
			// 打开会话
			session = factory.openSession();
			custom = (Custom) session.load(Custom.class, id);
			
			/**
			 * org.hibernate.Hibernate 类的initialize()静态方法
			 * 用于在Session范围内显式初始化代理类实例，
			 * isInitialized()方法用于判断代理类实例是否已经被初始化
			 */
			if (!Hibernate.isInitialized(custom))
			{
				/*
				 * 显式初始化代理类实例. 这样可以在
				 * session 关闭之后，仍然可以正常访问Custom游离对象
				 */
				log.info("testLoadInitialize =====> 显式初始化代理类实例");
				/**
				 * 若对象在数据中不存在，也会抛出 
				 * org.hibernate.ObjectNotFoundException 异常
				 */
				Hibernate.initialize(custom);
			}
			//注意：Hibernate支持Lazy策略，只有session打开状态才有效 
			/**
			 * session 关闭之后，再调用代理对象去获取属性值，就会
			 * 抛如下异常:
			 * org.hibernate.LazyInitializationException: could not initialize proxy - no Session
			 */
			session.close();
			/**
			 * session 关闭之后，仍然可以正常访问Custom游离对象
			 */
			log.info("testLoadInitialize =====> name = " + custom.getName());
			
			// class = com.hua.orm.entity.m2o.Custom_$$_jvst21_1
			//System.out.println("class = " + custom.getClass().getName());
			// superClass = com.hua.orm.entity.m2o.Custom
			//System.out.println("superClass = " + custom.getClass().getSuperclass().getName());
			
		} catch (Exception e) {
			log.error("testLoadInitialize =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 获取单个对象 - load 方式
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLoadObjectNoExist() {
		try {
			log.info("testLoadObjectNoExist =====> begin");
			
			// 测试代码
			id = "41";
			/**
			 * load 方法返回的是代理对象，是被代理对象的子类
			 */
			//custom = ca.load(Custom.class, id);
			
			// 打开会话
			session = factory.openSession();
			custom = (Custom) session.load(Custom.class, id);
			
			//注意：Hibernate支持Lazy策略，只有session打开状态才有效 
			/**
			 * session 关闭之后，再调用代理对象去获取属性值，就会
			 * 抛如下异常:
			 * org.hibernate.LazyInitializationException: could not initialize proxy - no Session
			 */
			//session.close();
			/**
			 * 由于该对象在数据库并不存在，因此调用该对象的具体
			 * 方法的时候，就会抛出如下异常: (ObjectNotFoundException)
			 * org.hibernate.ObjectNotFoundException: No row with the given identifier exists: 
			 * [com.hua.orm.entity.m2o.Custom#41]
			 * 如果不获取该对象的除了oid之外的其他值，则执行load方法并不会抛异常
			 */
			log.info("testLoadObjectNoExist =====> name = " + custom.getName());
			
			// class = com.hua.orm.entity.m2o.Custom_$$_jvst21_1
			//System.out.println("class = " + custom.getClass().getName());
			// superClass = com.hua.orm.entity.m2o.Custom
			//System.out.println("superClass = " + custom.getClass().getSuperclass().getName());
			
		} catch (Exception e) {
			log.error("testLoadObjectNoExist =====> ", e);
		} finally {
			if (null != session) {
				// 关闭会话
				session.close();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 获取单个对象 - load 方式
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLoadSessionClose() {
		try {
			log.info("testLoadSessionClose =====> begin");
			
			// 测试代码
			// 测试代码
			CustomDao ca = new CustomDaoImpl();
			ItemDao itemDao= new ItemDaoImpl();
			id = "40";
			/**
			 * load 方法返回的是代理对象，是被代理对象的子类
			 */
			//custom = ca.load(Custom.class, id);
			
			// 打开会话
			session = factory.openSession();
			custom = (Custom) session.load(Custom.class, id);
			/**
			 * session 关闭之后，再调用代理对象去获取属性值，就会
			 * 抛如下异常:
			 * org.hibernate.LazyInitializationException: could not initialize proxy - no Session
			 * 关闭Session后访问Customer游离对象
			 */
			session.close();
			log.info("testLoadSessionClose =====> name = " + custom.getName());
			
			// class = com.hua.orm.entity.m2o.Custom_$$_jvst21_1
			//System.out.println("class = " + custom.getClass().getName());
			// superClass = com.hua.orm.entity.m2o.Custom
			//System.out.println("superClass = " + custom.getClass().getSuperclass().getName());
			
		} catch (Exception e) {
			log.error("testLoadSessionClose =====> ", e);
		} finally {
			if (null != session) {
				// 关闭会话
				session.close();
			}
		}
	}
	
	/**
	 * 
	 * 描述: 获取单个对象 - load 方式
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLoadProxy() {
		try {
			log.info("testLoadProxy =====> begin");
			
			// 测试代码
			// 测试代码
			CustomDao ca = new CustomDaoImpl();
			ItemDao itemDao= new ItemDaoImpl();
			id = "40";
			/**
			 * load 方法返回的是代理对象，是被代理对象的子类
			 */
			custom = ca.load(Custom.class, id);
			
			// class = com.hua.orm.entity.m2o.Custom_$$_jvst21_1
			System.out.println("class = " + custom.getClass().getName());
			// superClass = com.hua.orm.entity.m2o.Custom
			System.out.println("superClass = " + custom.getClass().getSuperclass().getName());
			
		} catch (Exception e) {
			log.error("testLoadProxy =====> ", e);
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
