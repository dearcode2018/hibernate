/**
 * 描述: 
 * BlobTypeTest.java
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
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.Address;
import com.hua.orm.entity.type.BlobType;
import com.hua.orm.entity.type.PersonUserType;
import com.hua.test.BaseTest;
import com.hua.util.HibernateUtil;
import com.hua.util.ProjectUtil;
import com.hua.util.StringUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * BlobTypeTest
 */
public final class BlobTypeTest extends BaseTest {

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
	public void testBlobInsert() {
		try {
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			BlobType blobType = new BlobType();
			Byte[] array = new Byte[4];
			array[0] = 12;
			array[1] = 34;
			array[2] = 127;
			array[3] = -128;
			//
			blobType.setArray(array);
			
			byte[] bytes = new byte[] {23, 34, 98, 73, -52};
			
			// 通过字节数组创建 Blob
			Blob blob1 = Hibernate.getLobCreator(session).createBlob(bytes);
			InputStream inputStream = new FileInputStream(ProjectUtil.getAbsolutePath("/doc/lob.txt", true));
			// 通过流方式创建 Blob
			Blob blob2 = Hibernate.getLobCreator(session).createBlob(inputStream, inputStream.available());
			
			//blobType.setBlob(blob1);
			
			blobType.setBlob(blob2);
			
			// 持久化操作
			session.save(blobType);
			
			log.info("insert =====> 提交事务");
			// 提交事务
			tx.commit();
			
		} catch (Exception e) {
			log.error("testBlobInsert =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBlobGet() {
		try {
			session = factory.openSession();
			log.info("insert =====> 开始事务");
			// 开始事务
			tx = session.beginTransaction();
			
			String id = "3";
			BlobType blobType = (BlobType) session.get(BlobType.class, id);

			System.out.println(blobType.toString());
			
			Blob blob = blobType.getBlob();
			// 获取 二进制流，字符串乱码形式
			System.out.println(StringUtil.streamToString(blob.getBinaryStream()));
			
		} catch (Exception e) {
			log.error("testBlobGet =====> ", e);
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
