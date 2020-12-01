package com.ssv.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionFactoryUtil {
	private static SqlSessionFactory sqlSessionFactory = null;
	
	private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

	private SqlSessionFactoryUtil() {}
	

	private static SqlSessionFactory initSqlSessionFactory() {
		Reader reader = null;
		
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		synchronized (CLASS_LOCK) {
			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		}
		return sqlSessionFactory;
	}
	
	public static SqlSession openSqlSession() {
		if (sqlSessionFactory == null) {
			initSqlSessionFactory();
		}
		
		return sqlSessionFactory.openSession();
	}
}
