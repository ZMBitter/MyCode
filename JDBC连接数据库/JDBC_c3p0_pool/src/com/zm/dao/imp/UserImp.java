package com.zm.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zm.dao.UserDAO;
import com.zm.util.C3p0Utils;

public class UserImp implements UserDAO{

	@Override
	public int addUser() {
		try {
			/*获得connection连接对象*/
			Connection conn = C3p0Utils.getConn();
			/*创建要执行的sql语句*/
			String sql = "insert into users(id,username,password) values(null,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "帐三");
			ps.setString(2, "123");
			int n = ps.executeUpdate();
			if(n>0){
				return n;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}


}
