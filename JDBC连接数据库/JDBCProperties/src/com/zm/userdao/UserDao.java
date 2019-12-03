package com.zm.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zm.bean.User;
import com.zm.util.JDBCUtils;

public class UserDao {
	List<User> list = new ArrayList<User>();
	private Connection conn;
	private Statement st;
	private ResultSet rt;
	
	//查询
	public List<User> select() throws Exception{
		//获得Connection连接对象
		conn = JDBCUtils.getConnection();
		//创建Statement会话对象
		st = conn.createStatement();
		//创建要执行的sql语句
		String sql = "select username,password from users";
		//执行sql语句，将查询到的数据保存到ResultSet结果集中
		rt = st.executeQuery(sql);
		User user = null;
		while(rt.next()){//指针遍历
			user = new User();
			user.setUsername(rt.getString("username"));
			user.setPassword(rt.getString("password"));
			//将user对象保存到list集合中
			list.add(user);
		}
		return list;
	}
	
	//插入指定的用户名、密码
	public void addUser(String user,String pwd) throws Exception{
		//获得Connection连接对象
		conn = JDBCUtils.getConnection();
		String sql = "insert into users(id,username,password) values(null,?,?)";
		//创建PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user);
		ps.setString(2, pwd);
		int num = ps.executeUpdate();
		System.out.println("成功插入"+num+"条数据");
		
	}
	

}
