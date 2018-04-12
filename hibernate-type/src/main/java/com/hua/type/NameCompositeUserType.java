/**
  * @filename NameCompositeUserType.java
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
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

import com.hua.orm.entity.type.Name;

 /**
 * @type NameCompositeUserType
 * @description Name类 复合用户类型
 * @author qye.zheng
 */
public final class NameCompositeUserType implements CompositeUserType {

	/**
	 * @description 获取所有属性的名称
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public String[] getPropertyNames() {
		
		return new String[] {"firstname", "lastname"};
	}

	/**
	 * @description 获取所有属性对应的 Hibernate 类型
	 * @return
	 * @author qye.zheng
	 */
	@Override
	// org.hibernate.type.Type
	public Type[] getPropertyTypes() {
		// org.hibernate.type
		return new Type[] {StringType.INSTANCE, StringType.INSTANCE};
	}

	/**
	 * @description 根据属性位置，获取属性值
	 * @param component Name类对象
	 * @param property 属性在Name对象中的位置
	 * @return
	 * @throws HibernateException
	 * @author qye.zheng
	 */
	@Override
	public Object getPropertyValue(Object component, int property)
			throws HibernateException {
		final Name name = (Name) component;
		String propertyValue = null;
		switch (property) {
		case 0:
			propertyValue = name.getFirstname();
			
			break;
		case 1:
			propertyValue = name.getLastname();
			
			break;
		default:
		    throw new IllegalArgumentException("unknown property: " + property);
		}
		
		return propertyValue;
	}

	/**
	 * @description 
	 * @param component Name类对象
	 * @param property 属性在Name对象中的位置
	 * @param value 属性值
	 * @throws HibernateException
	 * @author qye.zheng
	 */
	@Override
	public void setPropertyValue(Object component, int property, Object value)
			throws HibernateException {
		final Name name = (Name) component;
		final String val = (String) value;
		switch (property) {
		case 0:
			name.setFirstname(val); 
			
			break;
		case 1:
			name.setLastname(val); 
			
			break;
		default:
		    throw new IllegalArgumentException("unknown property: " + property);
		}
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public Class<?> returnedClass() {
		return Name.class;
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
		if (rs.wasNull())
		{
			return null;
		}
		int i = 0;
		final String firstname = rs.getString(names[i++]);
		final String lastname = rs.getString(names[i++]);
		if (null == firstname || null == lastname)
		{
			return null;
		}
		final Name target = new Name();
		target.setFirstname(firstname);
		target.setLastname(lastname);
		
		return target;
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
		int i = index;
		if (null == value)
		{
			st.setNull(i++, Types.VARCHAR);
			st.setNull(i++, Types.VARCHAR);
		} else
		{
			final Name name = (Name) value;
			st.setString(i++, name.getFirstname());
			st.setString(i++, name.getLastname());
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
		if (null == value)
		{
			return null;
		}
		// 深度拷贝
		final Name original = (Name) value;
		final Name target = new Name();
		target.setFirstname(original.getFirstname());
		target.setLastname(original.getLastname());
		
		return target;
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public boolean isMutable() {
		// 可变的对象
		return true;
	}

	/**
	 * @description 
	 * @param value
	 * @param session
	 * @return
	 * @throws HibernateException
	 * @author qye.zheng
	 */
	@Override
	public Serializable disassemble(Object value, SessionImplementor session)
			throws HibernateException {
		
		return (Serializable) deepCopy(value);
	}

	/**
	 * @description 
	 * @param cached
	 * @param session
	 * @param owner
	 * @return
	 * @throws HibernateException
	 * @author qye.zheng
	 */
	@Override
	public Object assemble(Serializable cached, SessionImplementor session,
			Object owner) throws HibernateException {
		
		return deepCopy(cached);
	}

	/**
	 * @description 
	 * @param original
	 * @param target
	 * @param session
	 * @param owner
	 * @return
	 * @throws HibernateException
	 * @author qye.zheng
	 */
	@Override
	public Object replace(Object original, Object target,
			SessionImplementor session, Object owner) throws HibernateException {
		
		return deepCopy(original);
	}

}
