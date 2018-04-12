/**
 * 描述: 
 * ManyToManyTest.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hua.constant.ext.Gender;
import com.hua.entity.m2m.Course;
import com.hua.entity.m2m.Student;
import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;
import com.hua.util.HibernateM2MUtil;

/**
 * 描述: 多对多只有双向关联
 * @author qye.zheng
 * 
 * ManyToManyTest
 */
public final class ManyToManyTest extends BaseTest
{
	
	/* Hibernate 会话 */
	public Session session;
	
	/* 增删改 会话中必须开启一个事务，然后再提交事务 */
	public Transaction tx;
	
	/**
	 * 
	 * 描述: 新增测试
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testInsert() {
		try {
			/**
			 * 多对对涉及到多个对象的插入和关联，需要放在
			 * 一个会话的一个事务中进行
			 */
			log.info("testInsert =====> begin");
			// 打开会话
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 测试代码
			
			Student s1 = new Student();
			s1.setName("zhangsan");
			s1.setAddress("guagnzhoucity");
			s1.setCredit(10.5);
			s1.setBirthday(DateTimeUtil.getDate());
			s1.setGender(Gender.MALE);

			Student s2 = new Student();
			s2.setName("lisi");
			s2.setAddress("shenzhencity");
			s2.setCredit(10.5);
			s2.setBirthday(DateTimeUtil.getDate());
			s2.setGender(Gender.FEMALE);			
			
			Course c1 = new Course();
			c1.setName("大学数学2");
			c1.setCredit(4.5);
			c1.setDescription("数学课程大学");
			
			Course c2 = new Course();
			c2.setName("大学语文2");
			c2.setCredit(5.5);
			c2.setDescription("语文课程大学");			
			
			Course c3 = new Course();
			c3.setName("大学语文2");
			c3.setCredit(5.5);
			c3.setDescription("语文课程大学");			
			
			/**
			 * 在多对多关联情况下，无论让谁来维护关系都是可以的，但是不能同时
			 * 唯一，只能由一方去维护.
			 * 
			 */
			
			// 学生对象和课程对象建立双向关系
			/**
			 * 若关联关系由Student对象去维护，代码应该写成
			 * 如下的: 
			 * 
			 * (建议由发起对象去维护关系，则另外一方就设置inverse=true)
			 */
			/**
			 * 一定要充分复写 equals 和 hashCode 方法，防止在id为空时，
			 * 无法add进去集合
			 */
			s1.getCourses().add(c1);			
			s1.getCourses().add(c2);		
			
			//System.out.println(s1.getCourses().size());
			
			s2.getCourses().add(c2);

			/**
			 * 若关联关系由Course对象去维护，代码应该写成
			 * 如下的: 
			 */

/*			c1.getStudents().add(s1);
			
			c2.getStudents().add(s1);
			c2.getStudents().add(s2);*/
			
			// 操作过程
			// 持久化操作
			session.save(s1);
			session.save(s2);
			session.save(c1);
			session.save(c2);
			session.save(c3);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
			
		} catch (Exception e) {
			log.error("testInsert =====> ", e);
			if (null != tx)
			{
				tx.rollback();
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
