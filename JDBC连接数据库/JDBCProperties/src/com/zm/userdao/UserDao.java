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
	
	//��ѯ
	public List<User> select() throws Exception{
		//���Connection���Ӷ���
		conn = JDBCUtils.getConnection();
		//����Statement�Ự����
		st = conn.createStatement();
		//����Ҫִ�е�sql���
		String sql = "select username,password from users";
		//ִ��sql��䣬����ѯ�������ݱ��浽ResultSet�������
		rt = st.executeQuery(sql);
		User user = null;
		while(rt.next()){//ָ�����
			user = new User();
			user.setUsername(rt.getString("username"));
			user.setPassword(rt.getString("password"));
			//��user���󱣴浽list������
			list.add(user);
		}
		return list;
	}
	
	//����ָ�����û���������
	public void addUser(String user,String pwd) throws Exception{
		//���Connection���Ӷ���
		conn = JDBCUtils.getConnection();
		String sql = "insert into users(id,username,password) values(null,?,?)";
		//����PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user);
		ps.setString(2, pwd);
		int num = ps.executeUpdate();
		System.out.println("�ɹ�����"+num+"������");
		
	}
	

}
