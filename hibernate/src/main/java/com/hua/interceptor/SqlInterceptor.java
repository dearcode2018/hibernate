/**
  * @filename SqlInterceptor.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.interceptor;

import org.hibernate.EmptyInterceptor;

/**
 * @type SqlInterceptor
 * @description 
 * @author qianye.zheng
 */
public class SqlInterceptor extends EmptyInterceptor
{
	
	private static final long serialVersionUID = -8258580150662966114L;

	/* 新的表名 */
	private String newTable;
	
	/* 分表的表名前缀 */
	private String prefix;
	
	/**
	 * @description 构造方法
	 * @param newTable
	 * @author qianye.zheng
	 */
	public SqlInterceptor(String newTable)
	{
		super();
		this.newTable = newTable;
	}

		/**
		 * @description 
		 * @param sql
		 * @return
		 * @author qianye.zheng
		 */
		@Override
		public String onPrepareStatement(String sql)
		{
			sql = sql.replaceAll(prefix, newTable);
			
			return super.onPrepareStatement(sql);
		}

		/**
		* @return the newTable
		*/
		public String getNewTable()
		{
			return newTable;
		}

		/**
		* @param newTable the newTable to set
		*/
		public void setNewTable(String newTable)
		{
			this.newTable = newTable;
		}

		/**
		* @return the prefix
		*/
		public String getPrefix()
		{
			return prefix;
		}

		/**
		* @param prefix the prefix to set
		*/
		public void setPrefix(String prefix)
		{
			this.prefix = prefix;
		}
		
		
}
