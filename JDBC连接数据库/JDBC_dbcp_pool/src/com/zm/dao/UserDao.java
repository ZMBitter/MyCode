package com.zm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zm.bean.User;
import com.zm.utils.DBCPUtil;

public class UserDao {
	private List<User> list;
	private Connection conn;
	private Statement st;
	private ResultSet rt;
	//查询users表里面的用户名和密码
	public void select() {
		try{
		//获得Connection连接对象
		conn = DBCPUtil.getConnection();
		//要执行的sql语句
		String sql = "select username,password from users";
		st = conn.createStatement();
		rt = st.executeQuery(sql);
		list = new ArrayList<User>();
		while(rt.next()){
			User u = new User();
			u.setUsername(rt.getString("username"));
			u.setPassword(rt.getString("password"));
			list.add(u);
		}
		
		System.out.println(list);
		}catch(Exception e){
		   e.printStackTrace();
		}
		
	}

}
