/**
 * 描述: 
 * ClobTypeTest.java
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

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Clob;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.Address;
import com.hua.orm.entity.type.ClobType;
import com.hua.orm.entity.type.PersonUserType;
import com.hua.test.BaseTest;
import com.hua.util.HibernateUtil;
import com.hua.util.IOUtil;
import com.hua.util.ProjectUtil;
import com.hua.util.StringUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ClobTypeTest
 */
public final class ClobTypeTest extends BaseTest {

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
	public void testClobInsert() {
		try {
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			ClobType clobType = new ClobType();
			clobType.setString("string hahaha");
			// 通过字节数组创建 Blob
			Clob clob1 = Hibernate.getLobCreator(session).createClob("hibernate create clob");
			InputStream inputStream = new FileInputStream(ProjectUtil.getAbsolutePath("/doc/lob.txt", true));
			Reader reader = IOUtil.streamToReader(inputStream);
			
			// 通过流方式创建 Clob
			Clob clob2 = Hibernate.getLobCreator(session).createClob(reader, inputStream.available());
			
			clobType.setClob(clob1);
			// 持久化操作
			session.save(clobType);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
			
		} catch (Exception e) {
			log.error("testClobInsert =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testClobGet() {
		try {
			session = factory.openSession();
			String id = "3";
			ClobType clobType = (ClobType) session.get(ClobType.class, id);

			System.out.println(clobType.toString());
			
			Clob clob = clobType.getClob();
			// 获取 字节流
			System.out.print(StringUtil.streamToString(clob.getAsciiStream()));
			// 获取 字符流
			System.out.println(IOUtil.getString(clob.getCharacterStream()));
			
		} catch (Exception e) {
			log.error("testClobGet =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPersonUserTypeSET() {
		try {
			PersonUserType person = new PersonUserType();
			Address home = new Address("青海省", "西宁市", "宁安路123号", "586233");
			Address compay = new Address("甘肃省", "兰州市", "兰海路59号", "886233");
			person.setHomeAddress(home);
			person.setHomeAddress(compay);
			
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
			log.error("testPersonUserTypeSET =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPersonUserTypeGET() {
		try {
			PersonUserType person = null;
			
			session = factory.openSession();
			String id = "2";
			person = (PersonUserType) session.get(PersonUserType.class, id);
			
			System.out.println(person.toString());
			
		} catch (Exception e) {
			log.error("testPersonUserTypeGET =====> ", e);
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
