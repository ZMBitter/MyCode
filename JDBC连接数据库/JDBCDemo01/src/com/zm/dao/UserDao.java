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
	   //��ȡ���ݿ����Ӷ���
	   conn = JDBCUtil.getConnection();
	   //����Statement�Ự����ִ��sql���
	   st = conn.createStatement();
	   //��Ҫִ�е�sql���
		String sql = "select username,password from users";
		//ʹ��Statement����ִ��sql��䣬��������浽ResultSet�������
	   rs = st.executeQuery(sql);
		
		//������������󣬽�ֵ������Ӧ��ʵ����󣬲���ʵ�����user���浽list������
		User user = null;
		while(rs.next()){//ָ�����
			user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			list.add(user);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		//�ر���Դ
		JDBCUtil.close(conn, st, rs);
	}
	   return list;
   }
}
