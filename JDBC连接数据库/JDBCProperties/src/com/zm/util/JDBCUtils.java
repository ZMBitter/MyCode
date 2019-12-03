package com.zm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class JDBCUtils {
	private static String driver;//mysql的驱动位置
	private static String url;//指示连接的数据库路径
	private static String user;//用户名
	private static String pwd;//密码
	private static Connection conn;
	
	static{
		//读取properties文件中的内容
		
		//方式一：通过输入流的方式获取jdbc.properties文件中的内容
		/*
		 * try {
			//创建一个properties容器
			Properties pro = new Properties();
			//需要外部属性配置文件的路径
			InputStream stream = new FileInputStream(new File("src/jdbc.properties"));
		    //加载配置文件
			pro.load(stream);
			//从配置文件中获取属性值
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			pwd = pro.getProperty("pwd");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		
		//方式2：通过类加载器读取jdbc.properties文件中的数据
		/*
		 * try{
			//创建一个properties容器
			Properties pro = new Properties();
			//需要外部属性配置文件名+后缀名
			//JDBCUtils.class JDBCUtils类的实例
			InputStream stream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			pro.load(stream);
			
			//从配置文件中读取数据
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			pwd = pro.getProperty("pwd");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		*/
		
		//方式3：通过ResourceBundle.getBundle("")静态方法获取
		try{
			//需要外部属性文件的文件名
			ResourceBundle rb = ResourceBundle.getBundle("jdbc");
			driver = rb.getString("driver");
			url = rb.getString("url");
			user = rb.getString("user");
			pwd = rb.getString("pwd");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	//获取Connection连接对象
	public static Connection getConnection() throws Exception{
		//注册数据库驱动
		Class.forName(driver);
		//使用DriverManager对象获取数据库连接对象
		conn = DriverManager.getConnection(url, user, pwd);
		return conn;
	}
	
	//关闭连接资源
	public static void close(Connection conn,Statement st,ResultSet rt) {
		try{
			if(rt!=null){
				rt.close();
			}
			
			if(st!=null){
				st.close();
			}
			
			if(conn!=null){
				conn.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
