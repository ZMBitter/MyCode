package com.zm.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;


/*对应的配置文件是：dbcp.properties*/
public class JdbcUtils {
	// 定义BasicDataSorce的父类接口的形式，获得ds的参数
	private static BasicDataSource ds;
	
	static {
		try {
			//创建一个properties容器
			Properties pro = new Properties();
			//使用类加载器获取properties文件内容的流对象
			InputStream stream = JdbcUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
			//加载字节输入流
			pro.load(stream);
			//关闭流
			stream.close();
			
			//创建BasicDataSource对象
			ds = new BasicDataSource();
			ds.setDriverClassName(pro.getProperty("jdbc.driverClassName"));
			ds.setUrl(pro.getProperty("jdbc.url"));
			ds.setUsername(pro.getProperty("jdbc.username"));
			ds.setPassword(pro.getProperty("jdbc.password"));
			ds.setInitialSize(Integer.parseInt(pro.getProperty("initialSize")));
		    ds.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	//获得数据库连接对象
	public static BasicDataSource getDataSource() {
		return ds;
	}

	// 获得与指定数据库的连接
	public static Connection getConnection(){
		Connection conn = null;
		try{
			conn = ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

}
