/**
  * @filename AddressUserType.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import com.hua.entity.Address;

 /**
 * @type AddressUserType
 * @description 复合值映射
 * @author qye.zheng
 */
public final class AddressUserType implements UserType {

	private static final int[] SQL_TYPES = {Types.VARBINARY, Types.VARBINARY, Types.VARBINARY, Types.VARBINARY};
	
	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int[] sqlTypes() {
		
		return SQL_TYPES;
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public Class<?> returnedClass() {
		
		return Address.class;
	}

	/**
	 * @description 
	 * @param x
	 * @param y
	 * @return
	 * @throws HibernateException
	 * @author qye.zheng
	 */
	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == y)
		{
			return true;
		}
		if (null == x || null == y)
		{
			return false;
		}
		
		return x.equals(y);
	}

	/**
	 * @description 
	 * @param x
	 * @return
	 * @throws HibernateException
	 * @author qye.zheng
	 */
	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	/**
	 * @description 
	 * @param rs
	 * @param names
	 * @param session
	 * @param owner
	 * @return
	 * @throws HibernateException
	 * @throws SQLException
	 * @author qye.zheng
	 */
	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		System.out.println("AddressUserType.nullSafeGet()");
		if (rs.wasNull())
		{
			return null;
		}
		int i = 0;
		final String province = rs.getString(names[i++]);
		final String city = rs.getString(names[i++]);
		final String street = rs.getString(names[i++]);
		final String zipcode = rs.getString(names[i++]);
		
		return new Address(province, city, street, zipcode);
	}

	/**
	 * @description 
	 * @param st
	 * @param value
	 * @param index
	 * @param session
	 * @throws HibernateException
	 * @throws SQLException
	 * @author qye.zheng
	 */
	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		System.out.println("AddressUserType.nullSafeSet()");
		int i = index;
		if (null == value)
		{
			st.setNull(i++, Types.VARCHAR);
			st.setNull(i++, Types.VARCHAR);
			st.setNull(i++, Types.VARCHAR);
			st.setNull(i++, Types.VARCHAR);
		} else
		{
			final Address address = (Address) value;
			st.setString(i++, address.getProvince());
			st.setString(i++, address.getCity());
			st.setString(i++, address.getStreet());
			st.setString(i++, address.getZipcode());
		}
	}

	/**
	 * @description 
	 * @param value
	 * @return
	 * @throws HibernateException
	 * @author qye.zheng
	 */
	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public boolean isMutable() {
		return false;
	}

	/**
	 * @description 
	 * @param value
	 * @return
	 * @throws HibernateException
	 * @author qye.zheng
	 */
	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	/**
	 * @description 
	 * @param cached
	 * @param owner
	 * @return
	 * @throws HibernateException
	 * @author qye.zheng
	 */
	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	/**
	 * @description 
	 * @param original
	 * @param target
	 * @param owner
	 * @return
	 * @throws HibernateException
	 * @author qye.zheng
	 */
	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		/**
		 * Session 的merge方法把一个游离对象融合到持久化对象时，会调用此replace
		 * 方法获取用于替代持久化对象的phone属性值，orginal表示游离对象的phone属性，
		 * target表示持久化对象的phone属性，owner表示游离对象。
		 * 若参数original为不可变类型，可以直接返回original参数，若original为可变类型，
		 * 则返回参数original的快照(即调用deepCopy方法的返回值).
		 */
		return original;
	}

}
