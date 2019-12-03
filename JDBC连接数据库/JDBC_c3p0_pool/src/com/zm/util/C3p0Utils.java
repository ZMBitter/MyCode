package com.zm.util;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	private static ComboPooledDataSource cpds = null;
	static {
		try {
			/* 加载配置文件 */
			Properties pro = new Properties();
			// 用类加载器的方式加载配置文件
			InputStream stream = C3p0Utils.class.getClassLoader().getResourceAsStream("c3p0.properties");
			// 将资源放入properties容器中
			pro.load(stream);
			stream.close();
			/* 创建数据源对象 */
			cpds = new ComboPooledDataSource();
			System.out.print(cpds);
			cpds.setDriverClass(pro.getProperty("/c3p0.driverClass"));
			cpds.setJdbcUrl(pro.getProperty("c3p0.jdbcUrl"));
			cpds.setUser(pro.getProperty("c3p0.user"));
			cpds.setPassword(pro.getProperty("c3p0.password"));
		} catch (IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* 获取Connection连接对象 */
	public static Connection getConn() throws SQLException {
		return cpds.getConnection();
	}

}
