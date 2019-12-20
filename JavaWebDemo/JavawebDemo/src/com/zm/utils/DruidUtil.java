package com.zm.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.PreparedStatement;

/*druid连接池的使用
 * 1.导入jar包
 * 2.定义配置文件
 * 3.加载配置文件
 * 4.使用DruidDataSourceFactory的createDataSource获得连接池对象
 * 5.创建connection对象
 * 6.创建要执行的sql语句
 * 7.创建Statement/PreparedStatement对象执行sql语句
 * 8.获得ResultSet结果集对象(查询)或者返回影响的行数
 * 9.关闭连接，释放资源
 * 
 * */
public class DruidUtil {
	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;
	//数据源对象
	private static DataSource ds;
	//connection连接对象
	private static Connection conn;
	
	static{
		
		try {
			
		/*加载配置文件*/
		Properties pro = new Properties();
		InputStream stream = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
		pro.load(stream);
		/*获得数据库连接池对象*/
		ds = DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	
	/*获取连接对象*/
	public static Connection getConn() throws Exception {
		return ds.getConnection();
	}
	
	/*关闭连接，释放资源*/
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs){
		try{
		if(rs!=null){
			rs.close();
		}
		
		if(ps!=null){
			ps.close();
		}
		
		if(conn!=null){
			conn.close();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*获取连接池*/
	public static DataSource getDaSource(){
		return ds;
	}
}
