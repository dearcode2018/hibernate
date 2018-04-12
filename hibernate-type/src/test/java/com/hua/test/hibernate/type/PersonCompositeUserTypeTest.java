/**
 * 描述: 
 * PersonCompositeUserTypeTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.hibernate.type;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.constant.ext.Gender;
import com.hua.orm.entity.type.Name;
import com.hua.orm.entity.type.PersonCompositeUserType;
import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;
import com.hua.util.HibernateUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * PersonCompositeUserTypeTest
 */
public final class PersonCompositeUserTypeTest extends BaseTest {

	public static final SessionFactory factory = HibernateUtil.buildByXml();
	
	
	/* Hibernate 会话 */
	public Session session;
	
	/* 增删改 会话中必须开启一个事务，然后再提交事务 */
	public Transaction tx;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPersonSimpleUserTypeSet() {
		try {
			// 测试代码
			PersonCompositeUserType person = null;
			person = new PersonCompositeUserType();
			
			Name name = new Name();
			name.setFirstname("李");
			name.setLastname("向前");
			person.setName(name);
			
			person.setAddress("广州市番禺区沥滘125号");
			person.setBirthday(DateTimeUtil.getDateTime());
			person.setGender(Gender.MALE);
			person.setNation("汉族");
			person.setPhotoUrl("http://www.bai.com/resource/abc/photo.jpg");
			
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			
			// 持久化操作
			session.save(person);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
			
		} catch (Exception e) {
			log.error("testPersonSimpleUserTypeSet =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPersonSimpleUserTypeGet() {
		try {
			// 测试代码
			PersonCompositeUserType person = null;
			session = factory.openSession();
			String id = "2";
			person = (PersonCompositeUserType) session.get(PersonCompositeUserType.class, id);
			
			System.out.println(person.toString());
			
		} catch (Exception e) {
			log.error("testPersonSimpleUserTypeSet =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPersonSimpleUserTypeGetOfHQL01() {
		try {
			// 测试代码
			PersonCompositeUserType person = null;
			/**
			 * 支持 hql 语句，多级参数导航
			 */
			String hql = "FROM " 
					+ PersonCompositeUserType.class.getName() + " a WHERE a.name.firstname=:firstname";
			session = factory.openSession();
			Query query = session.createQuery(hql);
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("firstname", "李");
			
			query.setProperties(param);
			@SuppressWarnings({"unchecked"})
			List<PersonCompositeUserType>  data = query.list();
			
			System.out.println(data.size());
			System.out.println(data.get(0).toString());
		} catch (Exception e) {
			log.error("testPersonSimpleUserTypeGetOfHQL01 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPersonSimpleUserTypeGetOfHQL02() {
		try {
			// 测试代码
			PersonCompositeUserType person = null;
			/**
			 * 支持 hql 语句，多级参数导航
			 */
			// 问号 下标 从 0  开始
			String hql = "FROM " 
					+ PersonCompositeUserType.class.getName() + " a WHERE a.name.firstname=?";
			session = factory.openSession();
			Query query = session.createQuery(hql);
			
			query.setString(0, "李");
			@SuppressWarnings({"unchecked"})
			List<PersonCompositeUserType>  data = query.list();
			
			System.out.println(data.size());
			System.out.println(data.get(0).toString());
		} catch (Exception e) {
			log.error("testPersonSimpleUserTypeGetOfHQL02 =====> ", e);
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
