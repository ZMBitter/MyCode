package com.zm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zm.bean.User;
import com.zm.utils.JDBCUtil;

public class UserDao {
	private List<User> list = new ArrayList<User>();
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
   public List<User> selectUser(){
	   try {
	   //获取数据库连接对象
	   conn = JDBCUtil.getConnection();
	   //创建Statement会话对象，执行sql语句
	   st = conn.createStatement();
	   //需要执行的sql语句
		String sql = "select username,password from users";
		//使用Statement对象执行sql语句，将结果保存到ResultSet结果集中
	   rs = st.executeQuery(sql);
		
		//遍历结果集对象，将值赋给相应的实体对象，并将实体对象user保存到list集合中
		User user = null;
		while(rs.next()){//指针遍历
			user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			list.add(user);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		//关闭资源
		JDBCUtil.close(conn, st, rs);
	}
	   return list;
   }
}
