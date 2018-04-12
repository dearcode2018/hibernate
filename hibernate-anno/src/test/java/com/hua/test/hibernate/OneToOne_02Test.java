/**
 * 描述: 
 * OneToOne_02Test.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.test.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hua.constant.ext.Gender;
import com.hua.dao.o2o.PersonDao;
import com.hua.dao.o2o.impl.PersonDaoImpl;
import com.hua.entity.o2o._02.IdCard02;
import com.hua.entity.o2o._02.Person02;
import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * OneToOne_02Test
 */
public final class OneToOne_02Test extends BaseTest
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
	public void testInsert01() {
		try {
			
			log.info("testInsert01 =====> begin");
			
			// 测试代码
			Person02 person02 = null;
			person02 = new Person02();
			person02.setName("何进");
			person02.setAddress("广州市番禺区沥滘125号");
			person02.setBirthday(DateTimeUtil.getDateTime());
			person02.setGender(Gender.MALE);
			person02.setNation("汉族");
			person02.setPhotoUrl("http://www.bai.com/resource/abc/photo.jpg");
			
			IdCard02 IdCard02 = null;
			IdCard02 = new IdCard02();
			// 设置身份证标题
			IdCard02.setTitle("中华人民共和国 - 居民身份证");
			// 设置身份证号
			IdCard02.setCardNo("54088219890705885X");
			// 设置签发机构
			IdCard02.setIssuingAuthority("湛江市公安局");
			// 设置生效日期
			IdCard02.setEffectiveDate(dateFormat.parse("1989-07-05"));
			IdCard02.setExpiryDate(dateFormat.parse("1999-07-05"));
			
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 设置关联关系
			person02.setIdCard(IdCard02);
			IdCard02.setPerson(person02);
			
			
			// 持久化操作
			session.save(person02);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			log.error("insert =====> 回滚事务", e);
			// 回滚事务
			if (null != tx) {
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
			Person02 person02 = null;
			person02 = new Person02();
			person02.setId("18");
			
			IdCard02 IdCard02 = null;
			IdCard02 = new IdCard02();
			
			/*
			 * 一定要设置该实体的id，级联删除才能有效，
			 * 因为级联删除并没有去检查 2个实体之间的关联关系，而是以其主键
			 * 是否为空作为判断准则
			 */
			//IdCard02.setId(person.getId());
			
			session = factory.openSession();
			log.info("testDelete =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 设置关联关系
			person02.setIdCard(IdCard02);
			IdCard02.setPerson(person02);
			
			// 删除，级联
			session.delete(person02);
			
			log.info("testDelete =====> 提交事务");
			// 提交事务
			tx.commit();
			
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
			// 测试代码
			Person02 person02 = null;
			person02 = new Person02();
			person02.setName("何进");
			person02.setAddress("广州市番禺区沥滘125号");
			person02.setBirthday(DateTimeUtil.getDateTime());
			person02.setGender(Gender.MALE);
			person02.setNation("汉族");
			person02.setPhotoUrl("http://www.bai.com/resource/abc/photo.jpg");
			
			IdCard02 IdCard02 = null;
			IdCard02 = new IdCard02();
			// 设置身份证标题
			IdCard02.setTitle("中华人民共和国 - 居民身份证");
			// 设置身份证号
			IdCard02.setCardNo("54088219890705885X");
			// 设置签发机构
			IdCard02.setIssuingAuthority("湛江市公安局");
			// 设置生效日期
			IdCard02.setEffectiveDate(dateFormat.parse("1989-07-05"));
			IdCard02.setExpiryDate(dateFormat.parse("1999-07-05"));
			
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 设置关联关系
			person02.setIdCard(IdCard02);
			IdCard02.setPerson(person02);
			
			
			// 持久化操作
			session.save(person02);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
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
			// 测试代码
			Person02 person02 = null;
			person02 = new Person02();
			person02.setName("何进");
			person02.setAddress("广州市番禺区沥滘125号");
			person02.setBirthday(DateTimeUtil.getDateTime());
			person02.setGender(Gender.MALE);
			person02.setNation("汉族");
			person02.setPhotoUrl("http://www.bai.com/resource/abc/photo.jpg");
			
			IdCard02 IdCard02 = null;
			IdCard02 = new IdCard02();
			// 设置身份证标题
			IdCard02.setTitle("中华人民共和国 - 居民身份证");
			// 设置身份证号
			IdCard02.setCardNo("54088219890705885X");
			// 设置签发机构
			IdCard02.setIssuingAuthority("湛江市公安局");
			// 设置生效日期
			IdCard02.setEffectiveDate(dateFormat.parse("1989-07-05"));
			IdCard02.setExpiryDate(dateFormat.parse("1999-07-05"));
			
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 设置关联关系
			person02.setIdCard(IdCard02);
			IdCard02.setPerson(person02);
			
			
			// 持久化操作
			session.save(person02);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
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
			// 测试代码
			Person02 person02 = null;
			person02 = new Person02();
			person02.setName("何进");
			person02.setAddress("广州市番禺区沥滘125号");
			person02.setBirthday(DateTimeUtil.getDateTime());
			person02.setGender(Gender.MALE);
			person02.setNation("汉族");
			person02.setPhotoUrl("http://www.bai.com/resource/abc/photo.jpg");
			
			IdCard02 IdCard02 = null;
			IdCard02 = new IdCard02();
			// 设置身份证标题
			IdCard02.setTitle("中华人民共和国 - 居民身份证");
			// 设置身份证号
			IdCard02.setCardNo("54088219890705885X");
			// 设置签发机构
			IdCard02.setIssuingAuthority("湛江市公安局");
			// 设置生效日期
			IdCard02.setEffectiveDate(dateFormat.parse("1989-07-05"));
			IdCard02.setExpiryDate(dateFormat.parse("1999-07-05"));
			
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 设置关联关系
			person02.setIdCard(IdCard02);
			IdCard02.setPerson(person02);
			
			
			// 持久化操作
			session.save(person02);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
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
			// 测试代码
			Person02 person02 = null;
			person02 = new Person02();
			person02.setName("何进");
			person02.setAddress("广州市番禺区沥滘125号");
			person02.setBirthday(DateTimeUtil.getDateTime());
			person02.setGender(Gender.MALE);
			person02.setNation("汉族");
			person02.setPhotoUrl("http://www.bai.com/resource/abc/photo.jpg");
			
			IdCard02 IdCard02 = null;
			IdCard02 = new IdCard02();
			// 设置身份证标题
			IdCard02.setTitle("中华人民共和国 - 居民身份证");
			// 设置身份证号
			IdCard02.setCardNo("54088219890705885X");
			// 设置签发机构
			IdCard02.setIssuingAuthority("湛江市公安局");
			// 设置生效日期
			IdCard02.setEffectiveDate(dateFormat.parse("1989-07-05"));
			IdCard02.setExpiryDate(dateFormat.parse("1999-07-05"));
			
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			// 设置关联关系
			person02.setIdCard(IdCard02);
			IdCard02.setPerson(person02);
			
			
			// 持久化操作
			session.save(person02);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
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
			PersonDao pd = new PersonDaoImpl();
			
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
