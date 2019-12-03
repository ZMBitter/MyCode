package com.zm.utils;

import java.io.InputStream;

/*
BasciDataSource   它可以通过实例化对象的方式获得一个对象。
它里面有如下方法：
setDriverClassName(String driverClassName) 设置驱动类的名称。
setInitialSize(int initialSize) 设置初始化时的链接数目。
setMaxActive(int maxIdle) 设置最大的并发访问数量。
setMaxIdle(int maxIdle): 设置最大的闲置数目。
setPassword:用于设置密码。
setUrl:设置url
setUsername:设置用户名。
setMaxTotal 能从数据库连接池中申请到的最大连接数，设置为负值则无限制
数据源实现BasicDataSourceFactory   用于创建数据源的工厂类
*/


import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;


/*
 *对应的配置文件是：db.properties
 *
 * 使用DBCP连接池技术管理数据库连接*/
public class DBCPUtil {
	//数据库连接池
	private static DataSource dbcp;
	//为不同线程管理连接
	private static ThreadLocal<Connection> th1;
	//通过配置文件来获取数据库参数
	static{
		try{
			Properties pro = new Properties();
			InputStream stream = DBCPUtil.class.getClassLoader().getResourceAsStream("db.properties");
		    //加载字节输入流
			pro.load(stream);
			//关闭流
			stream.close();
			
			//1.初始化连接池
			
			//BasicDataSource 是dbcp的核心连接池 BasicDataSource 实现了Datasource这个接口
			dbcp = BasicDataSourceFactory.createDataSource(pro);
			
			//初始化本地线程
			th1 = new ThreadLocal<Connection>();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	/*获得数据库连接
	 * @return
	 * @SQLException
	 * */
	public static Connection getConnection(){
		Connection conn=null;
		try{
			conn=dbcp.getConnection();
			th1.set(conn);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	//获取了Connection对象后，对于增删改查操作，正常的使用jdbc去写
	
	/*
	 * 关闭数据库连接
	 * */
	public static void closeConn(){
		Connection conn = th1.get();
		try{
		if(conn!=null){
			
			 /* 
			 *通过连接池获取Connection对象，然后调用close方法，实际上并没有将连接关闭，而是归还
			 * 了Connection连接对象
			 * */
			 
			conn.close();
			th1.remove();
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
