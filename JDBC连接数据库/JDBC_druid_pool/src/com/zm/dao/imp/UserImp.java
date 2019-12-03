package com.zm.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zm.bean.User;
import com.zm.dao.UserDAO;
import com.zm.utils.DruidUtils;

public class UserImp implements UserDAO{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	/*查询数据库stuinformation中users表的信息*/
	@Override
	public List<User> selUser() {
		List<User> list = new ArrayList<User>();
		try {
			/*获得连接对象*/
			conn = DruidUtils.getConn();
			/*要执行的sql语句*/
			String sql = "select id,username,password from users";
			/*获得执行sql语句的预编译对象*/
			ps = conn.prepareStatement(sql);
			/*返回ResultSet结果集*/
			rs = ps.executeQuery();
		    while(rs.next()){
		    	User u = new User();
		    	u.setId(rs.getInt("id"));
		    	u.setUsername(rs.getString("username"));
		    	u.setPassword(rs.getString("password"));
		    	list.add(u);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
